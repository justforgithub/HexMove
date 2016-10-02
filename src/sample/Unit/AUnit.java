package sample.Unit;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import sample.*;
import sample.RectangleButtons.*;
import sample.Resources.Backpack;

import java.util.ArrayList;

import static java.lang.StrictMath.round;


/**
 * Created by Deviltech on 07.09.2016.
 */
public abstract class AUnit extends ACellContent {

    public double energy;
    public double health;
    public Faction faction;
    public double attackDamage;
    public SimpleBooleanProperty isSelected;
    private boolean hasAttacked;

    @Override
    public Group drawObject() {
        draw.getChildren().clear();
        // Draw shadow in background if selected
        if(isSelected.getValue()) {
            draw.getChildren().addAll(generateShadow(texture, -0.5, 0.5));
        }
        draw.getChildren().addAll(generateRectangle(texture, -0.5, 0.5));
        return draw;
    }

    public AUnit(sample.Faction faction, HexCell hexCell){
        this.isSelected = new SimpleBooleanProperty(false);
        // If selection changes, redraw object
        this.isSelected.addListener((value)->{
            drawObject();
        });
        this.faction = faction;
        this.energy = getMaxEnergy();
        this.health = getMaxHealth();
        this.draw = new Group();
        this.pathCost = MyValues.UNIT_PATHCOST;
        this.hexCell = hexCell;
        this.hasAttacked = false;
    }

    @Override
    public void executeNewTurn(){
        // new Attack possible for this round
        hasAttacked = false;
        // new Energy each round
        resetEnergy();
    }

    @Override
    public boolean isSameContent(HexCell cell) {
        return cell.getUnit() != null && this.getClass().equals(cell.getUnit().getClass());
    }

    @Override
    public Backpack getBackpack() {
        return null;
    }

    public abstract ArrayList<HexCell> getAttackCells();

    public abstract MyValues.ATTACK_TYPE getAttackType();

    public abstract boolean isLoaded();

    public abstract void setLoaded(boolean b);

    public abstract boolean reload();

    public abstract boolean isEnoughEnergyForAttack();

    /**
     * generate a Menubutton based on Unit type and status
     * @return
     */
    public abstract HexagonMenu generateHexagonMenu();
    /**
     * Sets the energy to the unit's max value
     */
    public abstract void resetEnergy();

    /**
     * get the unit's max energy
     *
     * @return
     */
    public abstract double getMaxEnergy();

    /**
     * Sets the health to the unit's max value
     */
    public abstract void resetHealth();

    /**
     * get the unit's max health
     *
     * @return
     */
    public abstract double getMaxHealth();

    /**
     * returns all possible adjacent cells of unit for melee range
     *
     * @return
     */
    ArrayList<HexCell> getMeleeAttackCells() {
        ArrayList<HexCell> attackCells = new ArrayList<>();
        Board board = this.hexCell.board;
        for (MyValues.HEX_POSITION pos : MyValues.HEX_POSITION.values()) {
            HexCell currentCell = board.getAdjacentCell(this.hexCell, pos, true);
            if (currentCell != null) {
                attackCells.add(currentCell);
            }
        }
        return attackCells;
    }

    /**
     * Get circular Range Cells between min and max range
     *
     * @param minRange
     * @param maxRange
     * @return
     */
    ArrayList<HexCell> getRangeAttackCells(int minRange, int maxRange) {
        ArrayList<HexCell> attackCells = new ArrayList<>();
        Board board = this.hexCell.board;
        MyValues.HEX_POSITION positions[] = MyValues.HEX_POSITION.values();
        // iterate over all range lengths
        for (int i = Math.max(0, minRange); i <= maxRange; i++) {
            Tuple currentTuple = hexCell.getCoords();
            // move current coordinate to south with current range langth i
            currentTuple.addY(i);
            for (MyValues.HEX_POSITION currentPosition : positions) {
                // "walk a circle clockwise" collect all cells at current range i
                for (int count = 0; count < i; count++) {
                    currentTuple = board.getAdjacentCoords(currentTuple, currentPosition, true);
                    if (board.getCell(currentTuple) != null) {
                        attackCells.add(board.getCell(currentTuple));
                    }
                }
            }
        }
        return attackCells;
    }

    ArrayList<HexCell> getSiegeAttackCells(int minRange, int maxRange) {
        ArrayList<HexCell> attackCells = new ArrayList<>();
        Board board = this.hexCell.board;
        MyValues.HEX_POSITION positions[] = MyValues.HEX_POSITION.values();

        Tuple currentTuple = hexCell.getCoords();
        for (MyValues.HEX_POSITION currentPosition : positions) {
            currentTuple = hexCell.getCoords();
            for (int i = 0; i <= maxRange; i++) {
                currentTuple = board.getAdjacentCoords(currentTuple, currentPosition, true);
                if (MyMath.isInBounds(minRange, maxRange, i)) {
                    HexCell currentCell = board.getCell(currentTuple);
                    if (currentCell != null) {
                        attackCells.add(currentCell);
                    }
                }
            }
        }
        return attackCells;

    }

    //
    public double calculateAttackDamage(AUnit defender){
        double damage = attackDamage * ((health + 0.1) / getMaxHealth()) * defender.hexCell.getTerrain().coverage;
        return round(damage);
    }

    /**
     * add amount to health, check bounds
     * @param amount
     * @return
     */
    public double addHealth(double amount){
        double newHealth = health  + amount;
        health = MyMath.setInBounds(0, getMaxHealth(), newHealth);
        return health;
    }

    public boolean isHasAttacked(){
        return hasAttacked;
    }

    public void setHasAttacked(boolean b){
        hasAttacked = b;
    }

    @Override
    public String toString(){
        return this.name + ", Energy: " + this.energy +"/" + getMaxEnergy() + "\n" + "Health: " + health + "/" + getMaxHealth() + "\n" + faction.getName();
    }

    /**
     * generates a standad Hexagon menu with attack, move, cancel and strategy
     * @return
     */
    HexagonMenu generateStandardHexagonMenu(){
        HexagonMenu menu = new HexagonMenu();
        menu.setButton(new MoveButton(menu), 0);
        menu.setButton(new AttackButton(menu), 1);
        menu.setButton(new CancelButton(menu), 4);
        menu.setButton(new StrategyButton(menu), 5);
        return menu;
    }

    /**
     * generate pattern based on faction specific images
     * @param s
     * @return
     */
    public ImagePattern generatePattern(String s){
        return  generateGeneralPattern(faction.getPath() + s);
    }

    /**
     * Returns if there is any valid enemy in range
     * @return
     */
    public boolean isEnemyInRange(HexCell cell){
        if(getAttackCells().contains(cell)){
            if(cell.getUnit() != null){
                return !faction.isSameFaction(cell.getUnit().faction);
            }
        }
        return false;
    }

    /**
     * Completely deselects unit, field and hexmenu
     */
    public void completeDeselect(){
        isSelected.set(false);
        hexCell.board.dummy1 = null;
        hexCell.board.closeHexMenu();
        hexCell.board.deselectAllCells();
    }


}


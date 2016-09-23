package sample.Unit;

import javafx.scene.Group;
import javafx.scene.text.Text;
import sample.*;
import sample.Resources.Backpack;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.StrictMath.round;


/**
 * Created by Deviltech on 07.09.2016.
 */
public abstract class AUnit extends ACellContent {

    public double energy;
    public double health;
    public double attackDamage;

    @Override
    public Group drawObject() {
        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle(texture, -0.5, 0.5));
        return draw;
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

    @Override
    public String toString(){
        return this.name + ", Energy: " + this.energy +"/" + getMaxEnergy() + "\n" + "Health: " + health + "/" + getMaxHealth();
    }


}


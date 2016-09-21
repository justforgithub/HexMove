package sample.Unit;

import javafx.scene.Group;
import sample.ACellContent;
import sample.Board;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.Backpack;

import java.util.ArrayList;


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
        draw.getChildren().addAll(generateRectangle(texture, -0.5,0.5));
        return draw;
    }

    @Override
    public boolean isSameContent(HexCell cell){
        return cell.unit != null && this.getClass().equals(cell.unit.getClass());
    }

    @Override
    public Backpack getBackpack(){
        return null;
    }

    public abstract ArrayList<HexCell> getAttackCells();



    /**
     * Sets the energy to the unit's max value
     */
    public abstract void resetEnergy();

    /**
     * get the unit's max energy
     * @return
     */
    public abstract double getMaxEnergy();

    /**
     * Sets the health to the unit's max value
     */
    public abstract void resetHealth();

    /**
     * get the unit's max health
     * @return
     */
    public abstract double getMaxHealth();

    /**
     * returns all possible adjacent cells of unit for melee range
     * @return
     */
    public ArrayList<HexCell> getMeleeAttackCells(){
        ArrayList<HexCell> attackCells = new ArrayList<>();
        Board board = this.hexCell.board;
        for(MyValues.HEX_POSITION  pos: MyValues.HEX_POSITION.values()){
           HexCell currentCell = board.getAdjacentCell(this.hexCell, pos);
            if(currentCell != null){
                attackCells.add(currentCell);
            }
        }
        return attackCells;
    }

    public ArrayList<HexCell> getRangeAttackCells(int min, int max){
        ArrayList<HexCell> attackCells = new ArrayList<>();
        Board board = this.hexCell.board;
        for(int i = min; i < max; i++){
// TODO
        }
        return attackCells;
    }

}


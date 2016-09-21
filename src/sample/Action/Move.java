package sample.Action;

import sample.HexCell;
import sample.MyValues;
import sample.Path;
import sample.Unit.AUnit;

import java.util.ArrayList;

/**
 * Created by Deviltech on 12.09.2016.
 */
public class Move extends AAction {

    private AUnit unit;
    private Path path;
    private int position;

    public Move(AUnit unit, Path path){
        this.unit = unit;
        this.path = path;
        this.position = path.pathCells.size()-1;
        this.actionStatus = MyValues.ACTION_STATUS.READY;
    }


    @Override
    public void execute(){
        ArrayList<HexCell> cells = path.pathCells;
        if(cells.size() >= 2 && position >= 1) {
            HexCell startCell = cells.get(position);
            HexCell endCell = cells.get(position - 1);
            double currentPathCost = startCell.getAllCosts(false) + endCell.getAllCosts(true);
            while (cells.size() >= 2 && position >=1) {
                System.out.println("Path l: " + cells.size() + " pos: " + position + " unit e: " + unit.energy + " +cost " + currentPathCost);
                if (unit.energy >= currentPathCost) {
                    unit.energy -= currentPathCost;
                    endCell.setUnit(unit);
                    unit.hexCell = endCell;
                    startCell.setUnit(null);
                    startCell.drawObject();
                    endCell.drawObject();
                    cells.remove(position);
                    position -= 1;
                    // Workaround TODO
                    if(position >= 1) {
                        startCell = cells.get(position);
                        endCell = cells.get(position - 1);
                        currentPathCost = startCell.getAllCosts(false) + endCell.getAllCosts(true);
                    }
                } else {
                    actionStatus = MyValues.ACTION_STATUS.WAIT;
                    System.out.println("WAIT");
                    break;
                }
            }
        } else{
            actionStatus = MyValues.ACTION_STATUS.OBSOLETE;
        }
    }
}

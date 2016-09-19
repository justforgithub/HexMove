package sample.Action;

import sample.HexCell;
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
        this.isObsolete = false;
    }

    /**
     * Executes a move, if possible
     */
    public void execute(){
        ArrayList<HexCell> cells = path.pathCells;
        if(cells.size() >= 2 && position >= 1) {
            HexCell startCell = cells.get(position);
            HexCell endCell = cells.get(position - 1);
            double currentPathCost = startCell.getAllCosts(false) + endCell.getAllCosts(true);
            while (cells.size() >= 2 && position >=1) {
                if (unit.energy >= currentPathCost) {
                    unit.energy -= currentPathCost;
                    endCell.unit = unit;
                    unit.hexCell = endCell;
                    startCell.unit = null;
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
                    break;
                }
            }
        } else{
            isObsolete = true;
        }
    }
}

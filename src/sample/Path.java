package sample;

import java.util.ArrayList;

/**
 * Created by Deviltech on 11.09.2016.
 */
public class Path {

    public ArrayList<HexCell> pathCells;
    public double pathCost;

    Path(ArrayList<HexCell> pathCells, double pathCost){
        this.pathCells = pathCells;
        this.pathCost = pathCost;
    }

    public HexCell getStart(){
        return pathCells.get(pathCells.size()-1);
    }

    public HexCell getEnd(){
        return pathCells.get(0);
    }

    public void setSelected(boolean bool){
        for (HexCell cell: pathCells){
            cell.setSelected(bool);
        }
    }

}

package sample.Terrain;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 07.09.2016.
 */
public class Grassland extends ATerrain{

    public Grassland(HexCell hexCell){
        this.name = MyValues.NAMES_GRASSLAND;
        this.texture = generatePattern("grassland.png");
        this.pathCost = 1.0;
        this.draw = new Group();
        this.hexCell = hexCell;
    }


    @Override
    public ATerrain generateNewCopy(HexCell hexCell) {
        return new Grassland(hexCell);
    }
}

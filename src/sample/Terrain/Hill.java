package sample.Terrain;


import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 08.09.2016.
 */
public class Hill extends ATerrain {

    public Hill(HexCell hexCell){
        this.name = MyValues.NAMES_HILL;
        this.texture = generatePattern("hill.png");
        this.pathCost = 3.0;
        this.draw = new Group();
        this.hexCell = hexCell;
    }

    @Override
    public ATerrain generateNewCopy(HexCell hexCell) {
        return new Hill(hexCell);
    }
}

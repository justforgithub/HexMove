package sample.Terrain;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 08.09.2016.
 */
public class Forest extends ATerrain{

    public Forest(HexCell hexCell){
        this.name = MyValues.NAMES_FOREST;
        this.texture = MyValues.IMAGE_FOREST;
        this.pathCost = 2.0;
        this.draw = new Group();
        this.hexCell = hexCell;
    }

    @Override
    public ATerrain generateNewCopy(HexCell hexCell) {
        return new Forest(hexCell);
    }
}

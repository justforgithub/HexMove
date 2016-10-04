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
        this.texture = generatePattern("forest.png");
        this.pathCost = 2.0;
        this.coverage = 0.7;
        this.draw = new Group();
        this.hexCell = hexCell;
    }

    @Override
    public ATerrain generateCopy(HexCell hexCell) {
        return new Forest(hexCell);
    }
}

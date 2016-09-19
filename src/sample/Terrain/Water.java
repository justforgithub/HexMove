package sample.Terrain;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 08.09.2016.
 */
public class Water extends ATerrain {

    public Water(HexCell hexCell){
        this.name = MyValues.NAMES_WATER;
        this.texture = generatePattern("water.png");
        this.pathCost = 10.0;
        this.draw = new Group();
        this.hexCell = hexCell;
    }

    @Override
    public ATerrain generateNewCopy(HexCell hexCell) {
        return new Water(hexCell);
    }
}

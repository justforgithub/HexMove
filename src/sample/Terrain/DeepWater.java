package sample.Terrain;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 21.09.2016.
 */
public class DeepWater extends ATerrain {

    public DeepWater(HexCell hexCell){
        this.name = MyValues.NAMES_DEEP_WATER;
        this.texture = generatePattern("water_deep.png");
        this.pathCost = 10.0;
        this.coverage = 0.4;
        this.draw = new Group();
        this.hexCell = hexCell;
    }

    @Override
    public ATerrain generateNewCopy(HexCell hexCell) {
        return new DeepWater(hexCell);
    }
}

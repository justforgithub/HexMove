package sample.Terrain;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class HQBackground extends ATerrain {

    public HQBackground(HexCell hexCell){
        this.name = MyValues.NAMES_HEAD_QUARTER;
        this.texture = MyValues.IMAGE_HEAD_QUARTER;
        this.pathCost = 1.0;
        this.draw = new Group();
        this.hexCell = hexCell;
    }

    @Override
    public ATerrain generateNewCopy(HexCell hexCell) {
        return new HQBackground(hexCell);
    }

}
package sample.Terrain;

import javafx.scene.Group;
import sample.MyValues;

/**
 * Created by Deviltech on 08.09.2016.
 */
public class Water extends ATerrain {

    public Water(){
        this.name = MyValues.NAMES_WATER;
        this.texture = MyValues.IMAGE_WATER;
        this.pathCost = 10.0;
        this.draw = new Group();
    }

    @Override
    public ATerrain generateNewCopy() {
        return new Water();
    }
}

package sample.Terrain;

import javafx.scene.Group;
import sample.MyValues;

/**
 * Created by Deviltech on 08.09.2016.
 */
public class Forest extends ATerrain{

    public Forest(){
        this.name = MyValues.NAMES_FOREST;
        this.texture = MyValues.IMAGE_FOREST;
        this.pathCost = 2.0;
        this.draw = new Group();
    }

    @Override
    public ATerrain generateNewCopy() {
        return new Forest();
    }
}

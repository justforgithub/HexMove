package sample.Terrain;


import javafx.scene.Group;
import sample.MyValues;

/**
 * Created by Deviltech on 08.09.2016.
 */
public class Hill extends ATerrain {

    public Hill(){
        this.name = MyValues.NAMES_HILL;
        this.texture = MyValues.IMAGE_HILL;
        this.pathCost = 3.0;
        this.draw = new Group();
    }

    @Override
    public ATerrain generateNewCopy() {
        return new Hill();
    }
}

package sample.Terrain;

import javafx.scene.Group;
import sample.MyValues;

/**
 * Created by Deviltech on 07.09.2016.
 */
public class Grassland extends ATerrain{

    public Grassland(){
        this.name = MyValues.NAMES_GRASSLAND;
        this.texture = MyValues.IMAGE_GRASSLAND;
        this.pathCost = 1.0;
        this.draw = new Group();
    }


    @Override
    public ATerrain generateNewCopy() {
        return new Grassland();
    }
}

package sample.Building;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Food;

/**
 * Created by Deviltech on 11.09.2016.
 */
public class FoodBerries extends AResourceField{


    public FoodBerries(HexCell hexCell, double capacity){
        this.name = MyValues.NAMES_BERRIES;
        this.texture=MyValues.IMAGE_BERRIES;
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
        this.resource = new Food(capacity);
    }

    @Override
    public String toString(){
        return this.name + ": " + resource.capacity;
    }


}

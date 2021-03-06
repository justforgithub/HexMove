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
        this.texture=generatePattern("berries.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
        this.resource = new Food(capacity);
    }

    @Override
    public String toString(){
        return this.name + ": " + resource.getCurrentCapacity();
    }

    @Override
    public AField generateCopy(){
        return new FoodBerries(this.hexCell, this.resource.getCurrentCapacity());
    }


}

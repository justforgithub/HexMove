package sample.Building;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Wood;

/**
 * Created by Deviltech on 11.09.2016.
 */
public class WoodPile extends AResourceField{


    public WoodPile(HexCell hexCell, double capacity){
        this.name = MyValues.NAMES_WOOD;
        this.texture = generatePattern("wood.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
        this.resource = new Wood(capacity);
    }

    @Override
    public String toString(){
        return this.name + ": " + resource.getCurrentCapacity();
    }

    @Override
    public AField generateCopy(){
        return new WoodPile(this.hexCell, this.resource.getCurrentCapacity());
    }


}

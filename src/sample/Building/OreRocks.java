package sample.Building;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Ore;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class OreRocks extends AResourceField {


    public OreRocks(HexCell hexCell, double capacity) {
        this.name = MyValues.NAMES_ORE;
        this.texture = generatePattern("ore.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
        this.resource = new Ore(capacity);
    }

    @Override
    public String toString(){
        return this.name + ": " + resource.capacity;
    }


}

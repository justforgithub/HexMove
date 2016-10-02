package sample.Terrain;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 02.10.2016.
 */
public class Swamp extends ATerrain {

    String[] variant = {"swamp_0", "swamp_1", "swamp_2", "swamp_3"};

    public Swamp(HexCell hexcell){
        this.name = MyValues.NAMES_SWAMP;
        this.texture = generatePattern(variant[0] + ".png");
        this.pathCost = Double.MAX_VALUE;
        this.coverage = 0.7;
        this.draw = new Group();
        this.hexCell = hexCell;
    }

    public Swamp chooseVariant(int i){
        this.texture = generatePattern(variant[i% variant.length ] + ".png");
        return this;
    }


    @Override
    public ATerrain generateNewCopy(HexCell hexCell) {
        return new Swamp(hexCell);
    }
}

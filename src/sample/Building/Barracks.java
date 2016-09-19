package sample.Building;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class Barracks extends ABuildingField {

    public Barracks(HexCell hexCell) {
        this.name = MyValues.NAMES_BARRACKS;
        this.texture = generatePattern("barracks.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
    }
}

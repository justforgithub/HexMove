package sample.Building;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 07.09.2016.
 */
public class Hut extends ABuildingField {

    public Hut(HexCell hexCell) {
        this.name = MyValues.NAMES_HUT;
        this.texture = generatePattern("hut.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
    }


}

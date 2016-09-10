package sample.Building;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.MyValues;

/**
 * Created by Deviltech on 07.09.2016.
 */
public class Hut extends ABuilding {

    public Hut() {
        this.name = "hut";
        this.texture = MyValues.IMAGE_HUT;
        this.draw = new Group();
    }

    @Override
    public Group drawObject() {

        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle());

        return draw;
    }
}

package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Created by Deviltech on 08.09.2016.
 */
public abstract class ACellContent {

    public String name;
    public ImagePattern texture;
    public Group draw;

    public abstract Group drawObject();

    public Rectangle generateRectangle(){

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(MyValues.HEX_HALF_CELL);
        rectangle.setWidth(MyValues.HEX_HALF_CELL);
        rectangle.setFill(texture);

        rectangle.setX(-rectangle.getWidth() * 0.5);
        rectangle.setY(-rectangle.getHeight() * 0.5);

        return rectangle;
    }

}

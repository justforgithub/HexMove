package sample;

import javafx.scene.Group;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Created by Deviltech on 08.09.2016.
 */
public abstract class ACellContent {

    public String name;
    public ImagePattern texture;
    public Group draw;
    public HexCell hexCell;
    public double pathCost;

    public abstract Group drawObject();

    public abstract String toString();

    public abstract boolean isSameContent(HexCell cell);

    /**
     * draw rectangle with x, y, placement in %
     * @param x
     * @param y
     * @return
     */
    public Rectangle generateRectangle(ImagePattern texture, double x, double y){

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(MyValues.HEX_HALF_CELL);
        rectangle.setWidth(MyValues.HEX_HALF_CELL);
        rectangle.setFill(texture);

        rectangle.setX((-rectangle.getWidth() * 0.5)*(1-x));
        rectangle.setY((-rectangle.getHeight() * 0.5)*(1-y));

        return rectangle;
    }

}

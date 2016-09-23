package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.Resources.Backpack;
import sample.Unit.Worker;

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

    public abstract Backpack getBackpack();

    public String getName(){
        return name;
    }

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

    /**
     * generate general pattern
     * @param s
     * @return
     */
    public ImagePattern generatePattern(String s){
        return new ImagePattern(new Image(getClass().getClassLoader().getResource(MyValues.IMAGE_PATH + s).toExternalForm()), 0, 0, 1, 1, true);
    }

    /**
     * generate pattern based on faction specific images
     * @param f
     * @param s
     * @return
     */
    public ImagePattern generatePattern(Faction f, String s){
        String factionNumber = Integer.toString(f.getTeamID());
        String imagePath = MyValues.IMAGE_PATH + MyValues.FACTION_PATH + factionNumber + "/" + s;
        return new ImagePattern(new Image(getClass().getClassLoader().getResource(imagePath).toExternalForm()), 0, 0, 1, 1, true);
    }


}

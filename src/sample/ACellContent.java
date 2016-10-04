package sample;

import javafx.scene.Group;
import javafx.scene.effect.ColorAdjust;
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

    /**
     * trigger new turn execution of cell content
     */
    public abstract void executeNewTurn();

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
     * Generate background Shadow for cellcontent
     * @param texture
     * @param x
     * @param y
     * @return
     */
    public Rectangle generateShadow(ImagePattern texture, double x, double y){
        Rectangle rectangle = generateRectangle(texture, x, y);
        double scale = MyValues.SHADOW_SCALE;
        double oldHeight = rectangle.getHeight();
        double oldWidth = rectangle.getWidth();
        // Place white shadow cenetered behind object
        rectangle.setHeight(oldHeight * scale);
        rectangle.setWidth(oldWidth * scale);
        rectangle.setX(rectangle.getX() - (rectangle.getWidth() - oldWidth)*0.5 );
        rectangle.setY(rectangle.getY() - (rectangle.getHeight() - oldHeight)*0.5 );
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(1.0);
        rectangle.setEffect(colorAdjust);
        return rectangle;
    }

    /**
     * image pattern generator to be overwritten by different subclasses
     * @param s
     * @return
     */
    public abstract ImagePattern generatePattern(String s);

    /**
     * generate general pattern independent from subclasses
     * @param s
     * @return
     */
    public ImagePattern generateGeneralPattern(String s){
        return new ImagePattern(new Image(getClass().getClassLoader().getResource(MyValues.PATH_IMAGE + s).toExternalForm()), 0, 0, 1, 1, true);
    }


    public void setBrightBackground(){
        ColorAdjust colorAdjust = new ColorAdjust();
        //colorAdjust.setContrast(0.1);
        //colorAdjust.setHue(-0.05);
        colorAdjust.setBrightness(0.5);
        //colorAdjust.setSaturation(0.2);

        draw.setEffect(colorAdjust);
    }



}

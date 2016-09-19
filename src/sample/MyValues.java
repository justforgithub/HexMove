package sample;


import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

/**
 * Created by Deviltech on 11.08.2016.
 */
public class MyValues {

    //enums

    public enum HEX_POSITION {TOP_LEFT, TOP, TOP_RIGHT, BOT_RIGHT, BOT, BOT_LEFT};

    public enum FIELD_TYPE {BUILDING, RESOURCE};


    // Hex cell

    public static double HEX_HORIZONTAL_VALUE = 2.0;

    public static double HEX_DIAGONAL_VALUE = 1.4142;

    public static double HEX_SCALE = 20;

    public static Color HEX_BACKGROUND = Color.WHITE;

    public static Color HEX_STROKE = Color.BLACK;

    public static Color HEX_STROKE_SELECTED = Color.ORANGERED;

    public static double HEX_STROKE_WIDTH = 2;

    public static double HEX_HALF_CELL = (HEX_DIAGONAL_VALUE + 0.5* HEX_HORIZONTAL_VALUE) * HEX_SCALE;

    // MISC

    public static double UNIT_PATHCOST = Double.MAX_VALUE;

    public static double WORKER_BACKPACK_CAPACITY = 30.0;

    public static double HUT_BACKPACK_CAPACITY = 200.0;


    // NAME

    public static String NAMES_HUT = "Hut";

    public static String NAMES_BARRACKS = "Barracks";

    public static String NAMES_HEAD_QUARTER = "Head Quarter";

    public static String NAMES_WOOD = "Wood";

    public static String NAMES_BERRIES = "Berries";

    public static String NAMES_ORE = "Iron Ore";

    public static String NAMES_GRASSLAND = "Grassland";

    public static String NAMES_WORKER = "Worker";

    public static String NAMES_HILL = "Hill";

    public static String NAMES_WATER = "Water";

    public static String NAMES_FOREST = "Forest";


    // IMAGE

    public static String IMAGE_PATH = "images/";


    //#################################################################

    private static ImagePattern generatePattern(String s){
        //return new ImagePattern(new Image(IMAGE_PATH + s), 0, 0, 1, 1, true);
        return new ImagePattern(new Image(IMAGE_PATH + s));
    }



}

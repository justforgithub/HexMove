package sample;


import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;

/**
 * Created by Deviltech on 11.08.2016.
 */
public class MyValues {

    //enums

    public enum HEX_POSITION {TOP_LEFT, TOP, TOP_RIGHT, BOT_RIGHT, BOT, BOT_LEFT};

    public enum FIELD_TYPE {BUILDING, RESOURCE};

    public enum ACTION_STATUS {INIT, READY, WAIT, OBSOLETE}



    // Hex cell

    public static double HEX_HORIZONTAL_VALUE = 2.0;

    public static double HEX_DIAGONAL_VALUE = 1.4142;

    public static double HEX_SCALE = 20;

    public static Color HEX_BACKGROUND = Color.WHITE;

    public static Color[] HEX_STROKE_SELECTION = {Color.BLACK, Color.GREENYELLOW, Color.ORANGERED, Color.DARKRED};

    public static double HEX_STROKE_WIDTH = 2;

    public static double HEX_HALF_CELL = (HEX_DIAGONAL_VALUE + 0.5* HEX_HORIZONTAL_VALUE) * HEX_SCALE;

    // MISC

    public static double UNIT_PATHCOST = Double.MAX_VALUE;

    public static double HUT_BACKPACK_CAPACITY = 200.0;


    // WORKER

    public static double WORKER_MAX_HEALTH = 10.0;

    public static double WORKER_MAX_ENERGY = 10.0;

    public static double WORKER_ATTACK_DAMAGE = 2.0;

    public static double WORKER_BACKPACK_CAPACITY = 30.0;


    // ARCHER

    public static double ARCHER_MAX_HEALTH = 10.0;

    public static double ARCHER_MAX_ENERGY = 8.0;

    public static double ARCHER_ATTACK_DAMAGE = 4;

    // SWORDSMAN

    public static double SWORDSMAN_MAX_HEALTH = 20;

    public static double SWORDSMAN_MAX_ENERGY = 6;

    public static double SWORDSMAN_ATTACK_DAMAGE = 5;


    // NAME

    public static String NAMES_HUT = "Hut";

    public static String NAMES_BARRACKS = "Barracks";

    public static String NAMES_HEAD_QUARTER = "Head Quarter";

    public static String NAMES_WOOD = "Wood";

    public static String NAMES_BERRIES = "Berries";

    public static String NAMES_ORE = "Iron Ore";

    public static String NAMES_GRASSLAND = "Grassland";

    public static String NAMES_ARCHER = "Archer";

    public static String NAMES_SWORDSMAN = "Swordsman";

    public static String NAMES_WORKER = "Worker";

    public static String NAMES_HILL = "Hill";

    public static String NAMES_WATER = "Water";

    public static String NAMES_DEEP_WATER = "Deep Water";

    public static String NAMES_FOREST = "Forest";


    // IMAGE

    public static String IMAGE_PATH = "images/";


    //#################################################################



}

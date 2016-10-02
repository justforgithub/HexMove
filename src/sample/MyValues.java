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

    public enum ATTACK_TYPE {MELEE, RANGE, SIEGE}



    // Hex cell

    public static double HEX_HORIZONTAL_VALUE = 2.0;

    public static double HEX_DIAGONAL_VALUE = 1.4142;

    public static double HEX_SCALE = 20;

    public static double SHADOW_SCALE = 1.1;

    public static Color HEX_BACKGROUND = Color.WHITE;

    public static Color[] HEX_STROKE_SELECTION = {Color.BLACK, Color.GREENYELLOW, Color.ORANGERED, Color.DARKRED};

    public static double HEX_STROKE_WIDTH = 2;

    public static double HEX_HALF_CELL = (HEX_DIAGONAL_VALUE + 0.5* HEX_HORIZONTAL_VALUE) * HEX_SCALE;

    // MISC

    public static double UI_BUTTON_SCALE = 1.2;

    public static Color UI_BUTTON_STROKE_COLOR = Color.BLACK;

    public static double UNIT_PATHCOST = Double.MAX_VALUE;

    public static double HUT_BACKPACK_CAPACITY = 200.0;

    public static double PRODUCTION_CAPACITY = 40;

    public static double PRODUCTION_REGENERATION = 3.0;

    public static double RESOURCE_REGENERATION = 1.0;


    // WORKER

    public static double WORKER_MAX_HEALTH = 100.0;

    public static double WORKER_MAX_ENERGY = 10.0;

    public static double WORKER_ATTACK_DAMAGE = 20.0;

    public static double WORKER_BACKPACK_CAPACITY = 30.0;

    // SCOUT

    public static double SCOUT_MAX_HEALTH = 120.0;

    public static double SCOUT_MAX_ENERGY = 14.0;

    public static double SCOUT_ATTACK_DAMAGE = 30.0;



    // ARCHER

    public static double ARCHER_MAX_HEALTH = 100.0;

    public static double ARCHER_MAX_ENERGY = 8.0;

    public static double ARCHER_ATTACK_DAMAGE = 50.0;

    public static double ARCHER_RELOAD_COST = ARCHER_MAX_ENERGY * 0.5;

    // SWORDSMAN

    public static double SWORDSMAN_MAX_HEALTH = 200.0;

    public static double SWORDSMAN_MAX_ENERGY = 8.0;

    public static double SWORDSMAN_ATTACK_DAMAGE = 60.0;


    // CATAPULT

    public static double CATAPULT_MAX_HEALTH = 150.0;

    public static double CATAPULT_MAX_ENERGY = 5.0;

    public static double CATAPULT_ATTACK_DAMAGE = 70.0;

    public static double CATAPULT_RELOAD_COST = CATAPULT_MAX_ENERGY;


    // NAME

    public static String NAMES_HUT = "Hut";

    public static String NAMES_FARM = "Farm";

    public static String NAMES_QUARRY = "Quarry";

    public static String NAMES_LUMBERJACK = "Lumberjack";

    public static String NAMES_BARRACKS = "Barracks";

    public static String NAMES_HEAD_QUARTER = "Head Quarter";

    public static String NAMES_CONSTRUCTION_SITE = "Construction Site";

    public static String NAMES_WOOD = "Wood";

    public static String NAMES_BERRIES = "Berries";

    public static String NAMES_ORE = "Iron Ore";

    public static String NAMES_GRASSLAND = "Grassland";

    public static String NAMES_ARCHER = "Archer";

    public static String NAMES_SCOUT = "Scout";

    public static String NAMES_SWORDSMAN = "Swordsman";

    public static String NAMES_WORKER = "Worker";

    public static String NAMES_CATAPULT = "Catapult";

    public static String NAMES_HILL = "Hill";

    public static String NAMES_WATER = "Water";

    public static String NAMES_DEEP_WATER = "Deep Water";

    public static String NAMES_FOREST = "Forest";

    public static String NAMES_HQ_BACKGROUND = "HQ Background";

    public static String NAMES_BUTTON_MOVE = "Move";

    public static String NAMES_BUTTON_ATTACK  = "Attack";

    public static String NAMES_BUTTON_STRATEGY = "Strategy";

    public static String NAMES_BUTTON_HARVEST = "Harvest";

    public static String NAMES_BUTTON_DEPOSIT = "Deposit";

    public static String NAMES_BUTTON_RELOAD = "Reload";

    public static String NAMES_BUTTON_BUILD = "Build";

    public static String NAMES_BUTTON_EMPTY = "";

    public static String NAMES_BUTTON_CANCEL = "Cancel";

    // IMAGE

    public static String PATH_IMAGE = "images/";

    public static String PATH_BUILDING = "building/";

    public static String PATH_BUTTON = "button/";

    public static String PATH_TERRAIN = "terrain/";

    public static String PATH_DETAILS = "details/";

    public static String PATH_FACTION = "faction_";


    //#################################################################

    // FACTION

    public static String[] FACTION_NAMES = {"Wolves of the North", "Hogs of the East", "Snakes of the South", "Eagles of the West", "Fluffy Bunnies United"};
    public static int NUMBER_OF_FACTIONS = FACTION_NAMES.length;




}

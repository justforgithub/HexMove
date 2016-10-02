package sample;

/**
 * Created by Deviltech on 21.09.2016.
 */
public class MyMath {

    /**
     * returns if min <= value >= max
     * @param min
     * @param max
     * @param value
     * @return
     */
    public static boolean isInBounds(int min, int max, int value){
        return value >= min && value <= max;
    }

    /**
     * returns if min <= value >= max
     * @param min
     * @param max
     * @param value
     * @return
     */
    public static boolean isInBounds(double min, double max, double value){
        return value >= min && value <= max;
    }

    /**
     * if value is out of bound, set it to bound
     * @param min
     * @param max
     * @param value
     * @return
     */
    public static double setInBounds(double min, double max, double value){
        return Math.min(Math.max(min, value), max);
    }

    /**
     * if value is out of bound, set it to bound
     * @param min
     * @param max
     * @param value
     * @return
     */
    public static int setInBounds(int min, int max, int value){
        return Math.min(Math.max(min, value), max);
    }

    /**
     * Generate Coordinates for hexagons
     * @param hor
     * @param dia
     * @return
     */
    public static Double[] generateHexagonCoords(double hor, double dia){
        return new Double[]{
                -(dia + 0.5 * hor), 0.0,
                -0.5 * hor, -hor,
                +0.5 * hor, -hor,
                +(dia + 0.5 * hor), 0.0,
                +0.5 * hor, hor,
                -0.5 * hor, hor,
        };
    }

    /**
     * Calculate the position coords of an adjacent hexcell
     * @param hor
     * @param dia
     * @param position
     */
    public static DoubleTuple calculatePositionCoords(double hor, double dia, MyValues.HEX_POSITION position){
        double x = 0;
        double y = 0;
        switch (position) {
            case TOP:
                x = 0;
                y = -2 * hor;
                break;
            case TOP_LEFT:
                x = -(hor + dia);
                y = -hor;
                break;
            case TOP_RIGHT:
                x = +(hor + dia);
                y = -hor;
                break;
            case BOT:
                x = 0;
                y = +2 * hor;
                break;
            case BOT_LEFT:
                x = -(hor + dia);
                y = +hor;
                break;
            case BOT_RIGHT:
                x = +(hor + dia);
                y = +hor;
                break;
        }
        return new DoubleTuple(x, y);
    }

}

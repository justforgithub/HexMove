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
}

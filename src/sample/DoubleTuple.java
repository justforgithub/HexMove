package sample;

/**
 * Created by Deviltech on 21.09.2016.
 */
public class DoubleTuple {

    private double x;
    private double y;

    public DoubleTuple(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public DoubleTuple addX(double x){
        this.x += x;
        return this;
    }

    public DoubleTuple addY(double y){
        this.y += y;
        return this;
    }

    @Override
    public String toString(){
        return "{" + x + ", " + y + "}";
    }
}

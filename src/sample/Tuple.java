package sample;

/**
 * Created by Deviltech on 21.09.2016.
 */
public class Tuple {

    private int x;
    private int y;

    public Tuple(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tuple addX(int x){
        this.x += x;
        return this;
    }

    public Tuple addY(int y){
        this.y += y;
        return this;
    }

    @Override
    public String toString(){
        return "{" + x + ", " + y + "}";
    }
}

package sample.Resources;

/**
 * Created by Deviltech on 18.09.2016.
 */
public abstract class AResource {

    public double capacity;

    public AResource(double capacity){
        this.capacity = capacity;
    }

    public abstract void addResource(Backpack backpack, double value);
}

package sample.Resources;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class Wood extends AResource {

    public Wood(double capacity) {
        super(capacity);
    }

    @Override
    public void addResource(Backpack backpack, double value) {
        backpack.addWood(value);
    }
}

package sample.Resources;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class Ore extends AResource {


    public Ore(double capacity) {
        super(capacity);
    }

    @Override
    public void addResource(Backpack backpack, double value) {
        backpack.addOre(value);
    }

    @Override
    public AResource findResource(Backpack backpack) {
        return backpack.getOre();
    }
}

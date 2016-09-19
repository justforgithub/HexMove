package sample.Resources;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class Food extends AResource {

    public Food(double capacity) {
        super(capacity);
    }

    @Override
    public void addResource(Backpack backpack, double value) {
        backpack.addFood(value);
    }

    @Override
    public AResource findResource(Backpack backpack) {
        return backpack.getFood();
    }


}

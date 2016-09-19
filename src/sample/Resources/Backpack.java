package sample.Resources;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class Backpack {

    private Food food;
    private Ore ore;
    private Wood wood;
    private double capacity;

    public Backpack(double capacity){
        this.food = new Food(0);
        this.ore = new Ore(0);
        this.wood = new Wood(0);
        this.capacity = capacity;
    }

    public double getRemainingCapacity(){
        return (Math.max(0, capacity - food.capacity - ore.capacity - wood.capacity));
    }


    public void addFood(double value){
        this.food.capacity += value;
    }

    public void addOre(double value){
        this.ore.capacity += value;
    }

    public void addWood(double value){
        this.wood.capacity += value;
    }

    /**
     * add amount x to backpack according to given resource type
     * @param value
     * @param resource
     */
    public void addResource(double value, AResource resource){
        resource.findResource(this).capacity += value;
    }

    public Food getFood(){
        return food;
    }

    public Ore getOre(){
        return ore;
    }

    public Wood getWood(){
        return wood;
    }

    @Override
    public String toString(){
        return "F: " + food.capacity + ", O: " + ore.capacity + ", W: " +  wood.capacity +", Capacity; " + (capacity - getRemainingCapacity()) + "/" +capacity;
    }


}

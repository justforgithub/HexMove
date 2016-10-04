package sample.Resources;

import sample.MyMath;

import java.util.ArrayList;

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
        food.setMaxCapacity(capacity);
        this.ore = new Ore(0);
        ore.setMaxCapacity(capacity);
        this.wood = new Wood(0);
        wood.setMaxCapacity(capacity);
        this.capacity = capacity;
    }

    public double getRemainingCapacity(){
        return (MyMath.setInBounds(0, capacity, capacity - food.getCurrentCapacity() - ore.getCurrentCapacity() - wood.getCurrentCapacity()));
    }

    /**
     * Sets the overal Capacity to the summed maximum capacities of all resources
     */
    public void adjustCapacity(){
        capacity = food.getMaxCapacity() + ore.getMaxCapacity() + wood.getMaxCapacity();
        System.out.println("ADJUSTED " + capacity);
    }


    public void addFood(double value){
        food.addRemainingCapacity(value);
    }

    public void addOre(double value){
        ore.addRemainingCapacity(value);
    }

    public void addWood(double value){
        wood.addRemainingCapacity(value);
    }

    /**
     * add amount x to backpack according to given resource type
     * @param value
     * @param resource
     */
    public void addResource(double value, AResource resource){
        resource.findResource(this).addRemainingCapacity(value);
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
        String s = "F: " + food.toString() + ", O: " + ore.toString() + ", W: " +  wood.toString() +", Capacity; " +
                (food.getCurrentCapacity() + ore.getCurrentCapacity() + wood.getCurrentCapacity());
                // Check if capacity is limitless
                if(capacity == Double.MAX_VALUE){
                    s += "/-";
                } else {
                    s +=  "/" + capacity;
                }
        return s;
    }

    /**
     * If there are resources, return them in a list
     * @return
     */
    public ArrayList<AResource> getAllResources(){
        ArrayList<AResource> resources = new ArrayList<>();
        if(food.getCurrentCapacity() > 0){
            resources.add(food);
        }
        if(ore.getCurrentCapacity() > 0){
            resources.add(ore);
        }
        if(wood.getCurrentCapacity() > 0){
            resources.add(wood);
        }
        return resources;
    }


}

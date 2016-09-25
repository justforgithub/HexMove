package sample.Resources;

import sample.MyMath;
import sample.MyValues;

/**
 * Created by Deviltech on 18.09.2016.
 */
public abstract class AResource {

    private double currentCapacity;
    private double maxCapacity;

    public AResource(double currentCapacity) {
        this.currentCapacity = currentCapacity;
        this.maxCapacity = Double.MAX_VALUE;
    }

    /**
     * Limits the capacity to a value
     * @param value
     * @return
     */
    public AResource setMaxCapacity(double value){
        this.maxCapacity = Math.max(0, value);
        return this;
    }

    public double getCurrentCapacity(){
        return currentCapacity;
    }

    public double getMaxCapacity(){
        return maxCapacity;
    }

    public double getRemainingCapacity(){
        return maxCapacity - currentCapacity;
    }

    public void setRemainingCapacity(double value){
        this.currentCapacity = MyMath.setInBounds(0, maxCapacity, value);
    }

    public AResource addRemainingCapacity(double value){
        setRemainingCapacity(currentCapacity + value);
        return this;
    }

    /**
     * Add a given resource to the backpack
     * @param backpack
     * @param value
     */
    public abstract void addResource(Backpack backpack, double value);

    /**
     * Finds the searched Resource in the backpack
     * @param backpack
     * @return
     */
    public abstract AResource findResource(Backpack backpack);

    @Override
    public String toString(){
        String max = "";
        if(maxCapacity == Double.MAX_VALUE){
            max = " ";
        } else {
            max = "/" + Double.toString(maxCapacity) +" ";
        }
        return this.currentCapacity  + max;
    }
}

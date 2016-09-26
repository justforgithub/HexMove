package sample.Building;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Backpack;

/**
 * Created by Deviltech on 26.09.2016.
 */
public class Mill extends ABuildingField{


    public Backpack backpack;

    public Mill(sample.Faction faction, HexCell hexCell) {
        this.faction = faction;
        this.name = MyValues.NAMES_MILL;
        this.texture = generatePattern("mill.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
        this.backpack = new Backpack(MyValues.PRODUCTION_CAPACITY);
        this.backpack.getWood().setMaxCapacity(0);
        this.backpack.getOre().setMaxCapacity(0);
        this.backpack.getFood().setMaxCapacity(MyValues.PRODUCTION_CAPACITY);
    }

    @Override
    public void executeNewTurn(){
        backpack.getFood().addRemainingCapacity(MyValues.PRODUCTION_REGENERATION);
    }

    @Override
    public String toString(){
        return this.name  + ": " +  backpack.toString();
    }

    @Override
    public double getResourceQuantityByType(AResource toCompare){
        return toCompare.findResource(backpack).getCurrentCapacity();
    }

    @Override
    public Backpack getBackpack(){
        return backpack;
    }

    @Override
    public Backpack getConstructionCosts() {
        Backpack constructionBackpack = new Backpack(Double.MAX_VALUE);
        constructionBackpack.getFood().setMaxCapacity(0);
        constructionBackpack.getWood().setMaxCapacity(50);
        constructionBackpack.getOre().setMaxCapacity(20);
        constructionBackpack.adjustCapacity();
        return constructionBackpack;
    }


}

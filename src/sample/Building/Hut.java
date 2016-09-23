package sample.Building;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Backpack;

/**
 * Created by Deviltech on 07.09.2016.
 */
public class Hut extends ABuildingField {

    public Backpack backpack;

    public Hut(sample.Faction faction, HexCell hexCell) {
        this.faction = faction;
        this.name = MyValues.NAMES_HUT;
        this.texture = generatePattern("hut.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
        this.backpack = new Backpack(MyValues.HUT_BACKPACK_CAPACITY);
    }

    @Override
    public String toString(){
        return this.name  + backpack.toString();
    }

    @Override
    public double getResourceQuantityByType(AResource toCompare){
        return toCompare.findResource(backpack).capacity;
    }

    @Override
    public Backpack getBackpack(){
        return backpack;
    }

}

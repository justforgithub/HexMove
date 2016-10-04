package sample.Building;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.Backpack;
import sample.Unit.AUnit;
import sample.Unit.Archer;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class Barracks extends ABuildingField {

    public Barracks(sample.Faction faction, HexCell hexCell) {
        this.faction = faction;
        this.name = MyValues.NAMES_BARRACKS;
        this.texture = generatePattern("barracks.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
    }


    @Override
    public Backpack getConstructionCosts() {
        Backpack constructionBackpack = new Backpack(Double.MAX_VALUE);
        constructionBackpack.getFood().setMaxCapacity(0);
        constructionBackpack.getWood().setMaxCapacity(100);
        constructionBackpack.getOre().setMaxCapacity(200);
        constructionBackpack.adjustCapacity();
        return constructionBackpack;
    }

    @Override
    public AField generateCopy(){
        return new Barracks(this.faction, this.hexCell);
    }
}

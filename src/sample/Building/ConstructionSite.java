package sample.Building;

import javafx.scene.Group;
import sample.Faction;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Backpack;

/**
 * Created by Deviltech on 25.09.2016.
 */
public class ConstructionSite extends ABuildingField{

    private ABuildingField buildingField;
    private Backpack backpack;

    public ConstructionSite(sample.Faction faction, ABuildingField buildingField, HexCell hexCell) {
        this.faction = faction;
        this.name = MyValues.NAMES_CONSTRUCTION_SITE;
        this.texture = generatePattern(MyValues.PATH_BUILDING + "construction_site.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
        this.backpack = buildingField.getConstructionCosts();
        this.buildingField = buildingField;
        this.buildingField.hexCell = hexCell;
    }

    @Override
    public String toString(){
        return this.name + ": " + buildingField.name + "\n" + backpack.toString();
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
        // Has no construction costs itself
        return null;
    }

    /**
     * Finishes the construction process, overrides Construction site with actual building
     */
    public void construct(){
        if (backpack.getRemainingCapacity() <= 0.0) {
            this.hexCell.setTerraBuildUnitGetDraw(null, this.buildingField, null);
        }
    }



}

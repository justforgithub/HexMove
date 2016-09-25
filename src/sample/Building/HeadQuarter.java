package sample.Building;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.Backpack;

/**
 * Created by Deviltech on 18.09.2016.
 */
public class HeadQuarter extends ABuildingField{


    public HeadQuarter(sample.Faction faction, HexCell hexCell) {
        this.faction = faction;
        this.name = MyValues.NAMES_HEAD_QUARTER;
        this.texture = generatePattern(faction, "banner2.png");
        this.draw = new Group();
        this.hexCell = hexCell;
        this.pathCost = 0.0;
    }

    // TODO CAUTION WITH change
    @Override
    public Group drawObject() {

        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle(texture, 0, 0.55));

        return draw;
    }

    @Override
    public Backpack getConstructionCosts() {
        Backpack constructionBackpack = new Backpack(Double.MAX_VALUE);
        constructionBackpack.getFood().setMaxCapacity(200);
        constructionBackpack.getWood().setMaxCapacity(300);
        constructionBackpack.getOre().setMaxCapacity(100);
        constructionBackpack.adjustCapacity();
        return constructionBackpack;
    }

}

package sample.Building;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

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

}

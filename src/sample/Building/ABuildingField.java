package sample.Building;

import javafx.scene.Group;
import sample.Faction;
import sample.MyValues;
import sample.Resources.AResource;

/**
 * Created by Deviltech on 18.09.2016.
 */
public abstract class ABuildingField extends AField {

    Faction faction;

    public Faction getFaction(){
        return faction;
    }

    // In general, Buildings dont hold resources
    public double getResourceQuantityByType(AResource toCompare){
        return 0.0;
    }

    @Override
    public MyValues.FIELD_TYPE getFieldType(){
        return MyValues.FIELD_TYPE.BUILDING;
    }

    @Override
    public Group drawObject() {

        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle(texture, 0, 0.55), generateRectangle(generatePattern(faction, "banner1.png"), 0.75, 0.55));

        return draw;
    }
}

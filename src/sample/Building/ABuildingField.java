package sample.Building;

import javafx.scene.Group;
import sample.MyValues;

/**
 * Created by Deviltech on 18.09.2016.
 */
public abstract class ABuildingField extends AField {

    @Override
    public MyValues.FIELD_TYPE getFieldType(){
        return MyValues.FIELD_TYPE.BUILDING;
    }

    @Override
    public Group drawObject() {

        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle(texture, 0, 0.55), generateRectangle(generatePattern("banner1_blue.png"), 0.75, 0.55));

        return draw;
    }
}

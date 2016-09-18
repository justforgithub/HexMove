package sample.Building;

import javafx.scene.Group;
import sample.MyValues;
import sample.Resources.AResource;

/**
 * Created by Deviltech on 18.09.2016.
 */
public abstract class AResourceField extends AField {

    AResource resource;

    @Override
    public Group drawObject() {

        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle(texture, 0, 0.55));

        return draw;
    }

    @Override
    public MyValues.FIELD_TYPE getFieldType(){
        return MyValues.FIELD_TYPE.RESOURCE;
    }

    /**
     * Get resource from resource field
     * @return
     */
    public  AResource getResource(){
        return resource;
    }
}

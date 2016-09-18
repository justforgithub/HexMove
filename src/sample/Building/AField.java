package sample.Building;

import javafx.scene.Group;
import sample.ACellContent;
import sample.HexCell;
import sample.MyValues;

/**
 * Created by Deviltech on 07.09.2016.
 */
public abstract class AField extends ACellContent {

    public abstract MyValues.FIELD_TYPE getFieldType();




    @Override
    public boolean isSameContent(HexCell cell){

        return cell.field != null && this.getClass().equals(cell.field.getClass());
    }

    @Override
    public String toString(){
        return this.name;
    }
}

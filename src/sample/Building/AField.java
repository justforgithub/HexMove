package sample.Building;

import javafx.scene.Group;
import sample.ACellContent;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Backpack;

/**
 * Created by Deviltech on 07.09.2016.
 */
public abstract class AField extends ACellContent {

    public abstract MyValues.FIELD_TYPE getFieldType();

    /**
     * returns the amount of resource of a given type of this field
     * @param toCompare
     * @return
     */
    public abstract double getResourceQuantityByType(AResource toCompare);



    @Override
    public Backpack getBackpack(){
        return null;
    }

    @Override
    public boolean isSameContent(HexCell cell){

        return cell.getField() != null && this.getClass().equals(cell.getField().getClass());
    }

    @Override
    public String toString(){
        return this.name;
    }
}

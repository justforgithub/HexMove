package sample.Building;

import javafx.scene.Group;
import javafx.scene.paint.ImagePattern;
import sample.ACellContent;
import sample.Faction;
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

    public abstract AField generateCopy();


    public abstract AField chooseFaction(Faction f);


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

    public ImagePattern generatePattern(String s){
        return generateGeneralPattern(MyValues.PATH_BUILDING + s);
    }
}

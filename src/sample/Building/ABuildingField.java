package sample.Building;

import javafx.scene.Group;
import sample.Faction;
import sample.MyValues;
import sample.Resources.AResource;
import sample.Resources.Backpack;

/**
 * Created by Deviltech on 18.09.2016.
 */
public abstract class ABuildingField extends AField {

    Faction faction;

    public Faction getFaction(){
        return faction;
    }

    @Override
    public AField chooseFaction(Faction f){
        this.faction = f;
        return this;
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

        String factionNumber = Integer.toString(this.faction.getTeamID());
        String imagePath = MyValues.PATH_FACTION + factionNumber + "/";
        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle(texture, 0, 0.55), generateRectangle(generateGeneralPattern(imagePath + "banner1.png"), 0.75, 0.55));

        return draw;
    }

    @Override
    public void executeNewTurn(){
        // do nothing
    }

    /**
     * returns construction costs via to be filled backpack
     * @return
     */
    public abstract Backpack getConstructionCosts();
}

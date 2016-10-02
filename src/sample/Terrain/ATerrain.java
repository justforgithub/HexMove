package sample.Terrain;


import javafx.scene.Group;
import javafx.scene.paint.ImagePattern;
import sample.ACellContent;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.Backpack;

/**
 * Created by Deviltech on 07.09.2016.
 */
public abstract class ATerrain extends ACellContent {

    public double pathCost;
    public double coverage;

    @Override
    public Group drawObject() {

        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle(texture, 0,0));
        return draw;
    }

    @Override
    public void executeNewTurn(){
        // Nothing happens to Terrain
    }

    @Override
    public boolean isSameContent(HexCell cell){
        return cell.getTerrain() != null && this.getClass().equals(cell.getTerrain().getClass());
    }

    @Override
    public Backpack getBackpack(){
        return null;
    }

    @Override
    public String toString(){
        return this.name;
    }

    /**
     * generates a new copy of itself
     * @return
     */
    public abstract ATerrain generateNewCopy(HexCell hexCell);

    public ImagePattern generatePattern(String s){
        return generateGeneralPattern(MyValues.PATH_TERRAIN + s);
    }

}

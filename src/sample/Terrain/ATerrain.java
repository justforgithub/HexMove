package sample.Terrain;


import javafx.scene.Group;
import sample.ACellContent;
import sample.HexCell;

/**
 * Created by Deviltech on 07.09.2016.
 */
public abstract class ATerrain extends ACellContent {

    public double pathCost;

    @Override
    public Group drawObject() {

        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle(texture, 0,0));
        return draw;
    }

    @Override
    public boolean isSameContent(HexCell cell){
        return cell.terrain != null && this.getClass().equals(cell.terrain.getClass());
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

}

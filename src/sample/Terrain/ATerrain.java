package sample.Terrain;


import javafx.scene.Group;
import sample.ACellContent;

/**
 * Created by Deviltech on 07.09.2016.
 */
public abstract class ATerrain extends ACellContent {

    public double pathCost;

    @Override
    public Group drawObject() {

        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle());
        return draw;
    }

    /**
     * generates a new copy of itself
     * @return
     */
    public abstract ATerrain generateNewCopy();

}

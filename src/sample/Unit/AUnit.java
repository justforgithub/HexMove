package sample.Unit;

import javafx.scene.Group;
import sample.ACellContent;
import sample.HexCell;


/**
 * Created by Deviltech on 07.09.2016.
 */
public abstract class AUnit extends ACellContent {

    public double energy;
    public double health;

    @Override
    public Group drawObject() {
        draw.getChildren().clear();
        draw.getChildren().addAll(generateRectangle(texture, -0.5,0.5));
        return draw;
    }

    @Override
    public boolean isSameContent(HexCell cell){
        return cell.unit != null && this.getClass().equals(cell.unit.getClass());
    }



    /**
     * Sets the energy to the unit's max value
     */
    public abstract void resetEnergy();

    /**
     * get the unit's max energy
     * @return
     */
    public abstract double getMaxEnergy();

    /**
     * Sets the health to the unit's max value
     */
    public abstract void resetHealth();

    /**
     * get the unit's max health
     * @return
     */
    public abstract double getMaxHealth();

}


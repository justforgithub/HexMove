package sample.Action;

import javafx.scene.input.MouseButton;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 04.10.2016.
 */
public class Reload extends AAction {

    private AUnit unit;

    public Reload(AUnit unit){
        this.unit = unit;
    }


    @Override
    public boolean isActionPossible() {
        return !unit.isLoaded() && unit.isEnoughEnergyForAttack();
    }


    @Override
    public void execute() {
        if(isActionPossible()){
            unit.reload();
            unit.useAttackEnergy();
            System.out.println("energy afterwards " + unit.energy);

        }
    }

}

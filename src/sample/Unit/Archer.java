package sample.Unit;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

import java.util.ArrayList;

/**
 * Created by Deviltech on 21.09.2016.
 */
public class Archer extends AUnit{


    public Archer(sample.Faction faction, HexCell hexCell) {
        super(faction, hexCell);
        this.name = MyValues.NAMES_ARCHER;
        this.texture = generatePattern(faction, "archer.png");
        this.attackDamage = MyValues.ARCHER_ATTACK_DAMAGE;
    }

    @Override
    public ArrayList<HexCell> getAttackCells() {
        return getRangeAttackCells(2,3);
    }

    @Override
    public MyValues.ATTACK_TYPE getAttackType(){
        return MyValues.ATTACK_TYPE.RANGE;
    }

    @Override
    public void resetEnergy() {
        this.energy = getMaxEnergy();
    }

    @Override
    public double getMaxEnergy() {
        return MyValues.ARCHER_MAX_ENERGY;
    }

    @Override
    public void resetHealth() {
        this.health = getMaxHealth();
    }

    @Override
    public double getMaxHealth() {
        return MyValues.ARCHER_MAX_HEALTH;
    }

}

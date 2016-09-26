package sample.Unit;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

import java.util.ArrayList;

/**
 * Created by Deviltech on 23.09.2016.
 */
public class Scout extends AUnit{

    public Scout(sample.Faction faction, HexCell hexCell) {
        this.faction = faction;
        this.name = MyValues.NAMES_SCOUT;
        this.texture = generatePattern(faction, "scout.png");
        this.energy = getMaxEnergy();
        this.health = getMaxHealth();
        this.draw = new Group();
        this.pathCost = MyValues.UNIT_PATHCOST;
        this.hexCell = hexCell;
        this.attackDamage = MyValues.SCOUT_ATTACK_DAMAGE;
    }

    @Override
    public ArrayList<HexCell> getAttackCells() {
        return getMeleeAttackCells();
    }

    @Override
    public MyValues.ATTACK_TYPE getAttackType(){
        return MyValues.ATTACK_TYPE.MELEE;
    }

    @Override
    public void resetEnergy() {
        this.energy = getMaxEnergy();
    }

    @Override
    public double getMaxEnergy() {
        return MyValues.SCOUT_MAX_ENERGY;
    }

    @Override
    public void resetHealth() {
        this.health = getMaxHealth();
    }

    @Override
    public double getMaxHealth() {
        return MyValues.SCOUT_MAX_HEALTH;
    }


}
package sample.Unit;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.Backpack;

import java.util.ArrayList;

/**
 * Created by Deviltech on 21.09.2016.
 */
public class Archer extends AUnit{


    public Archer(HexCell hexCell) {
        this.name = MyValues.NAMES_ARCHER;
        this.texture = generatePattern("archer.png");
        this.energy = getMaxEnergy();
        this.health = getMaxHealth();
        this.draw = new Group();
        this.pathCost = MyValues.UNIT_PATHCOST;
        this.hexCell = hexCell;
        this.attackDamage = MyValues.ARCHER_ATTACK_DAMAGE;
    }

    @Override
    public ArrayList<HexCell> getAttackCells() {
        return getRangeAttackCells(2,3);
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

    @Override
    public String toString(){
        return this.name + ", Energy: " + this.energy +"\n" + "Backpack: ";
    }
}

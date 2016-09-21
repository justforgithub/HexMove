package sample.Unit;

import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;

import java.util.ArrayList;

/**
 * Created by Deviltech on 22.09.2016.
 */
public class Swordsman extends AUnit {



    public Swordsman(HexCell hexCell) {
        this.name = MyValues.NAMES_SWORDSMAN;
        this.texture = generatePattern("swordsman.png");
        this.energy = getMaxEnergy();
        this.health = getMaxHealth();
        this.draw = new Group();
        this.pathCost = MyValues.UNIT_PATHCOST;
        this.hexCell = hexCell;
        this.attackDamage = MyValues.SWORDSMAN_ATTACK_DAMAGE;
    }

    @Override
    public ArrayList<HexCell> getAttackCells() {
        return getMeleeAttackCells();
    }

    @Override
    public void resetEnergy() {
        this.energy = getMaxEnergy();
    }

    @Override
    public double getMaxEnergy() {
        return MyValues.SWORDSMAN_MAX_ENERGY;
    }

    @Override
    public void resetHealth() {
        this.health = getMaxHealth();
    }

    @Override
    public double getMaxHealth() {
        return MyValues.SWORDSMAN_MAX_HEALTH;
    }

    @Override
    public String toString(){
        return this.name + ", Energy: " + this.energy +"\n";
    }
}

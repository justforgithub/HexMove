package sample.Unit;

import javafx.scene.Group;
import javafx.scene.text.Text;
import sample.HexCell;
import sample.MyValues;
import sample.Resources.Backpack;

import java.util.ArrayList;

/**
 * Created by Deviltech on 07.09.2016.
 */
public class Worker extends AUnit {

    Backpack backpack;


    public Worker(sample.Faction faction, HexCell hexCell) {
        this.faction = faction;
        this.name = MyValues.NAMES_WORKER;
        this.texture = generatePattern(faction, "worker.png");
        this.energy = getMaxEnergy();
        this.health = getMaxHealth();
        this.draw = new Group();
        this.pathCost = MyValues.UNIT_PATHCOST;
        this.hexCell = hexCell;
        this.backpack = new Backpack(MyValues.WORKER_BACKPACK_CAPACITY);
        this.attackDamage = MyValues.WORKER_ATTACK_DAMAGE;

    }



    @Override
    public void resetEnergy() {
        this.energy = getMaxEnergy();
    }

    @Override
    public double getMaxEnergy() {
        return MyValues.WORKER_MAX_ENERGY;
    }

    @Override
    public void resetHealth() {
        this.health = getMaxHealth();
    }

    @Override
    public double getMaxHealth() {
        return MyValues.WORKER_MAX_HEALTH;
    }

    @Override
    public Backpack getBackpack(){
        return backpack;
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
    public String toString(){
        return this.name + ", Energy: " + this.energy +"/" + getMaxEnergy() + "\n" + "Health: " + health + "/" + getMaxHealth() + "\n" + getBackpack().toString();
    }

}

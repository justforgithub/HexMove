package sample.Unit;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import javafx.scene.text.Text;
import sample.HexCell;
import sample.MyValues;
import sample.RectangleButtons.*;
import sample.Resources.Backpack;

import java.util.ArrayList;

/**
 * Created by Deviltech on 07.09.2016.
 */
public class Worker extends AUnit {

    Backpack backpack;


    public Worker(sample.Faction faction, HexCell hexCell) {
        super(faction, hexCell);
        this.name = MyValues.NAMES_WORKER;
        this.texture = generatePattern("worker.png");
        this.backpack = new Backpack(MyValues.WORKER_BACKPACK_CAPACITY);
        this.attackDamage = MyValues.WORKER_ATTACK_DAMAGE;

    }

    @Override
    public boolean isLoaded() {
        return true;
    }

    @Override
    public void setLoaded(boolean b) {
    }

    @Override
    public HexagonMenu generateHexagonMenu() {
        HexagonMenu menu = super.generateStandardHexagonMenu();
        menu.setButton(new HarvestDepositButton(menu), 2);
        menu.setButton(new BuildButton(menu), 3);
        return menu;
    }

    @Override
    public boolean reload(){
        return false;
    }

    @Override
    public boolean isEnoughEnergyForAttack(){
        return true;
    }

    @Override
    public void useAttackEnergy() {
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

    @Override
    public AUnit generateCopy(){
        return new Worker(this.faction, this.hexCell);
    }

}

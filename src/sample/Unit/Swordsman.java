package sample.Unit;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.RectangleButtons.HexagonMenu;

import java.util.ArrayList;

/**
 * Created by Deviltech on 22.09.2016.
 */
public class Swordsman extends AUnit {



    public Swordsman(sample.Faction faction, HexCell hexCell) {
        super(faction, hexCell);
        this.name = MyValues.NAMES_SWORDSMAN;
        this.texture = generatePattern("swordsman.png");
        this.attackDamage = MyValues.SWORDSMAN_ATTACK_DAMAGE;
    }

    @Override
    public boolean isLoaded() {
        return true;
    }

    @Override
    public void setLoaded(boolean b) {
    }

    @Override
    public boolean  reload(){
        return false;
    }

    @Override
    public boolean isEnoughEnergyForAttack(){
        return true;
    }

    @Override
    public HexagonMenu generateHexagonMenu() {
        return super.generateStandardHexagonMenu();
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

    }

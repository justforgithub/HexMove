package sample.Unit;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.RectangleButtons.HexagonMenu;

import java.util.ArrayList;

/**
 * Created by Deviltech on 23.09.2016.
 */
public class Scout extends AUnit{

    public Scout(sample.Faction faction, HexCell hexCell) {
        super(faction, hexCell);
        this.name = MyValues.NAMES_SCOUT;
        this.texture = generatePattern("scout.png");
        this.attackDamage = MyValues.SCOUT_ATTACK_DAMAGE;
    }

    @Override
    public boolean isLoaded() {
        return true;
    }

    @Override
    public void setLoaded(boolean b) {
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

    @Override
    public AUnit generateCopy(){
        return new Scout(this.faction, this.hexCell);
    }


}

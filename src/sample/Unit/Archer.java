package sample.Unit;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Group;
import sample.HexCell;
import sample.MyValues;
import sample.RectangleButtons.AttackButton;
import sample.RectangleButtons.HexagonMenu;
import sample.RectangleButtons.ReloadButton;

import java.util.ArrayList;

/**
 * Created by Deviltech on 21.09.2016.
 */
public class Archer extends AUnit{

    private boolean isLoaded;

    public Archer(sample.Faction faction, HexCell hexCell) {
        super(faction, hexCell);
        this.name = MyValues.NAMES_ARCHER;
        this.texture = generatePattern(faction, "archer.png");
        this.attackDamage = MyValues.ARCHER_ATTACK_DAMAGE;
        this.isLoaded = true;
    }

    @Override
    public HexagonMenu generateHexagonMenu(){
        HexagonMenu menu = super.generateStandardHexagonMenu();
        if(isLoaded){
            menu.setButton(new AttackButton(menu), 1);
        } else {
            menu.setButton(new ReloadButton(menu), 1);
        }
        return menu;
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
    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public void setLoaded(boolean b) {
        this.isLoaded = b;
    }

    @Override
    public void reload(){
        if(!isLoaded && energy >= MyValues.ARCHER_RELOAD_COST){
            energy -= MyValues.ARCHER_RELOAD_COST;
            isLoaded = true;
        }
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

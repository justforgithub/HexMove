package sample.Action;

import sample.MyMath;
import sample.MyValues;
import sample.Unit.AUnit;

/**
 * Created by Deviltech on 21.09.2016.
 */
public class Attack extends AAction {
    private AUnit attacker;
    private AUnit defender;

    public Attack(AUnit attacker, AUnit defender){
        this.attacker = attacker;
        this.defender = defender;
    }

    @Override
    public void execute() {
        if(attacker != null && defender!= null && attacker.isLoaded()){
            // attacker does damage
            if(attacker.getAttackCells().contains(defender.hexCell)){
                double damage = attacker.calculateAttackDamage(defender);
                defender.addHealth(- damage);
                // Attacker has to reload afterwards
                attacker.setLoaded(false);
                System.out.println("Attacker hits for HP: " + damage);
                // defender hits back, if melee and in range
                if(defender.getAttackType().equals(MyValues.ATTACK_TYPE.MELEE) && defender.getAttackCells().contains(attacker.hexCell)){
                    double counterDamage = defender.calculateAttackDamage(attacker);
                    System.out.println("Defender hits back: " + counterDamage);
                    attacker.addHealth(- counterDamage);
                }
            } else {
                System.out.println("Wrong attack ranges or not reloaded");
            }
        }
    }
}

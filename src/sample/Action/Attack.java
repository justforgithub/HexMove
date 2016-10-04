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

    public Attack(AUnit attacker, AUnit defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    @Override
    public boolean isActionPossible() {
        boolean isPossible = false;
        // Check if attacker is in condition to attack
        if (attacker != null && defender != null && attacker.isLoaded() && !attacker.isHasAttacked() && attacker.isEnoughEnergyForAttack()) {
            // Check if defender faction is legit and defender in range
            if ( !attacker.faction.isSameFaction(defender.faction) && attacker.getAttackCells().contains(defender.hexCell)) {
                isPossible = true;
            }
        }
        return isPossible;
    }

    @Override
    public void execute() {
        if (isActionPossible()) {
            double damage = attacker.calculateAttackDamage(defender);
            defender.addHealth(-damage);
            // Attacker has to reload afterwards
            attacker.setLoaded(false);
            attacker.setHasAttacked(true);
            attacker.useAttackEnergy();
            System.out.println("Attacker hits for HP: " + damage);
            System.out.println("energy afterwards " + attacker.energy);

            // defender hits back, if melee and in range
            if (defender.getAttackType().equals(MyValues.ATTACK_TYPE.MELEE) && defender.getAttackCells().contains(attacker.hexCell)) {
                double counterDamage = defender.calculateAttackDamage(attacker);
                System.out.println("Defender hits back: " + counterDamage);
                attacker.addHealth(-counterDamage);
            }
        } else {
            System.out.println("Wrong attack ranges or not reloaded or already attacked");
        }
    }
}

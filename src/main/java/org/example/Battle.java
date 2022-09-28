package org.example;

public class Battle {
    public static boolean fight(Warrior attacker, Warrior defender) {
        while (attacker.isAlive() && defender.isAlive()) {
            attacker.hit(defender);
            if (defender.isAlive()) {
                defender.hit(attacker);
            }
        }
        return attacker.isAlive();
    }

    public static boolean fight(Army attackers, Army defenders) {
        while (!attackers.isEmpty() && !defenders.isEmpty()) {
            Warrior attacker = attackers.peekUnit();
            Warrior defender = defenders.peekUnit();

            if (fight(attacker, defender)) {
                defenders.removeUnit();
            } else {
                attackers.removeUnit();
            }
        }

        return !attackers.isEmpty();
    }
}

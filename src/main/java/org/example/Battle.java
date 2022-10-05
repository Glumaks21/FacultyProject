package org.example;

import org.example.units.Warrior;

import java.util.Iterator;

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
        Iterator<Warrior> attackIterator = attackers.iterator();
        Iterator<Warrior> defIterator = defenders.iterator();

        while (attackIterator.hasNext() && defIterator.hasNext()) {
            if (fight(attackIterator.next(), defIterator.next())) {
                defenders.removeUnit();
            } else {
                attackers.removeUnit();
            }
        }

        return !attackers.isEmpty();
    }
}

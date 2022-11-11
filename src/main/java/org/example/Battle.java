package org.example;

import org.example.unit.Unit;

import java.util.Iterator;

public class Battle {
    public static boolean fight(Unit attacker, Unit defender) {
        while (attacker.isAlive() && defender.isAlive()) {
            attacker.hit(defender);
            if (defender.isAlive()) {
                defender.hit(attacker);
            }
        }
        return attacker.isAlive();
    }

    public static boolean fight(Army attackers, Army defenders) {
        Iterator<Unit> attackIterator = attackers.iterator();
        Iterator<Unit> defIterator = defenders.iterator();

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

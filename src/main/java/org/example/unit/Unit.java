package org.example.unit;

import org.example.ability.CanAttack;
import org.example.ability.CanReceiveDamage;

public interface Unit extends CanAttack, CanReceiveDamage {
    static Unit newWarrior() {
        return new Warrior();
    }
    static Unit newKnight() {
        return new Knight();
    }
    static Unit newDefender() {
        return new Defender();
    }
    static Unit newVampire() {
        return new Vampire();
    }
    static Unit newLancer() {
        return new Lancer();
    }
}

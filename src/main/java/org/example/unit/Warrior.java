package org.example.unit;

import org.example.unit.bonus.WithDefence;
import org.example.unit.bonus.WithVampirism;

public interface Warrior extends CanAttack, CanReceiveDamage {
    static Warrior createSimpleWarrior() {
        return new SimpleWarrior(50, 5);
    }
    static Warrior createKnight() {
        return new SimpleWarrior(50, 12);
    }
    static Warrior createDefender() {
        return new WithDefence(new SimpleWarrior(60, 3), 2);
    }
    static Warrior createVampire() {
        return new WithVampirism(new SimpleWarrior(40, 4), 50);
    }
}

package org.example.unit.bonus;

import org.example.unit.CanAttack;
import org.example.unit.HasDefence;
import org.example.unit.Warrior;

public class WithDefence extends WarriorDecorator implements HasDefence {
    private final int defence;

    public WithDefence(Warrior warrior, int defence) {
        super(warrior);
        if (defence < 0) {
            throw new IllegalArgumentException();
        }
        this.defence = defence;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public void receiveDamage(CanAttack from, int damage) {
        super.receiveDamage(from, reduceDamage(damage));
    }
}

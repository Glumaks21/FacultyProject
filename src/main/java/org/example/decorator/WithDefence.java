package org.example.decorator;

import org.example.ability.CanAttack;
import org.example.ability.HasDefence;
import org.example.unit.Unit;

public class WithDefence extends UnitDecorator implements HasDefence {
    private final int defence;

    public WithDefence(Unit warrior, int defence) {
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
    public int getMaxHealth() {
        return super.getMaxHealth();
    }

    @Override
    public void receiveDamage(CanAttack from, int damage) {
        super.receiveDamage(from, reduceDamage(damage));
    }
}

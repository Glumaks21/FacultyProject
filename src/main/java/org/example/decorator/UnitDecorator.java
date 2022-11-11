package org.example.decorator;

import org.example.ability.CanAttack;
import org.example.unit.Unit;

import java.util.Objects;

public abstract class UnitDecorator implements Unit {
    private final Unit unit;

    public UnitDecorator(Unit warrior) {
        Objects.requireNonNull(warrior);
        this.unit = warrior;
    }

    public Unit getKernel() {
        if (unit instanceof UnitDecorator) {
            UnitDecorator decorator = (UnitDecorator) unit;
            return decorator.getKernel();
        }

        return unit;
    }

    @Override
    public int getAttack() {
        return unit.getAttack();
    }

    @Override
    public int getHealth() {
       return unit.getHealth();
    }

    @Override
    public int getMaxHealth() {
        return unit.getMaxHealth();
    }

    @Override
    public void receiveDamage(CanAttack from, int value) {
        unit.receiveDamage(from, value);
    }
}

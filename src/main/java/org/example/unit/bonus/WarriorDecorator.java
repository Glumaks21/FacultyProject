package org.example.unit.bonus;

import org.example.unit.CanAttack;
import org.example.unit.Warrior;

import java.util.Objects;

public abstract class WarriorDecorator implements Warrior {
    private final Warrior warrior;

    public WarriorDecorator(Warrior warrior) {
        Objects.requireNonNull(warrior);
        this.warrior = warrior;
    }

    public Warrior getKernel() {
        if (warrior instanceof WarriorDecorator) {
            WarriorDecorator decorator = (WarriorDecorator) warrior;
            return decorator.getKernel();
        }

        return warrior;
    }

    @Override
    public int getAttack() {
        return warrior.getAttack();
    }

    @Override
    public int getHealth() {
       return warrior.getHealth();
    }

    @Override
    public void receiveDamage(CanAttack from, int value) {
        warrior.receiveDamage(from, value);
    }
}

package org.example.unit.bonus;

import org.example.unit.*;

public class WithVampirism extends WarriorDecorator implements HasVampirism {
    private final int regenPercent;

    public WithVampirism(Warrior warrior, int regenPercent) {
        super(warrior);
        if (regenPercent < 0) {
            throw new IllegalArgumentException();
        }
        this.regenPercent = regenPercent;
    }

    @Override
    public int getVampirism() {
        return regenPercent;
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int before = opponent.getHealth();
        super.hit(opponent);
        int after = opponent.getHealth();

        vampire(before - after);
    }

    @Override
    public void heal(int health) {
        Warrior kernel = getKernel();
        if (kernel instanceof SimpleWarrior) {
            SimpleWarrior simpleWarrior = (SimpleWarrior) kernel;
            simpleWarrior.heal(health);
        }
    }
}

package org.example.decorator;

import org.example.ability.CanReceiveDamage;
import org.example.ability.CanRestoreHealth;
import org.example.ability.HasVampirism;
import org.example.unit.Unit;

public class WithVampirism extends UnitDecorator implements HasVampirism {
    private final int regenPercent;

    public WithVampirism(Unit warrior, int regenPercent) {
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
    public void restoreHealth(int health) {
        Unit kernel = getKernel();
        if (kernel instanceof CanRestoreHealth) {
            CanRestoreHealth simpleWarrior = (CanRestoreHealth) kernel;
            simpleWarrior.restoreHealth(health);
        }
    }
}

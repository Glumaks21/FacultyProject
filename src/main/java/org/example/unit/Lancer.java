package org.example.unit;

import org.example.ability.CanReceiveDamage;
import org.example.ability.HasNeighborUnits;

public class Lancer extends AbstractUnit {
    private static final int STANDARD_HEALTH = 50;
    private static final int STANDARD_ATTACK = 6;
    private static final int STANDARD_PENETRATION_PERCENT = 50;

    private int penetrationPercent;

    public Lancer() {
        this(STANDARD_HEALTH, STANDARD_ATTACK, STANDARD_PENETRATION_PERCENT);
    }

    public Lancer(int health, int attack, int penetrationPercent) {
        super(health, attack);
        if (penetrationPercent < 0) {
            throw new IllegalArgumentException();
        }
        this.penetrationPercent = penetrationPercent;
    }

    public int getPenetrationPercent() {
        return penetrationPercent;
    }

    protected void setPenetrationPercent(int penetrationPercent) {
        this.penetrationPercent = Math.max(0, penetrationPercent);
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        int healthBefore = opponent.getHealth();
        opponent.receiveDamage(this, getAttack());

        if (opponent instanceof HasNeighborUnits) {
            HasNeighborUnits hasNeighborUnits = (HasNeighborUnits) opponent;
            Unit next = hasNeighborUnits.unitAfter();

            if (next != null) {
                int receivedDamage = healthBefore - opponent.getHealth();
                int attackForTheNext = receivedDamage * getPenetrationPercent() / 100;
                next.receiveDamage(this, attackForTheNext);
            }
        }
    }
}

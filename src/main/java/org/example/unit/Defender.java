package org.example.unit;

import org.example.ability.CanAttack;
import org.example.ability.HasDefence;

public class Defender extends AbstractUnit implements HasDefence {
    public final static int STANDARD_HEALTH = 60;
    public final static int STANDARD_ATTACK = 3;
    public final static int STANDARD_DEFENCE = 2;

    private int defence;

    public Defender() {
        this(STANDARD_HEALTH, STANDARD_ATTACK, STANDARD_DEFENCE);
    }

    public Defender(int health, int attack, int defence) {
        super(health, attack);
        if (defence < 0) {
            throw new IllegalArgumentException();
        }
        this.defence = defence;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    protected void setDefence(int defence) {
        this.defence = Math.max(0, defence);
    }

    @Override
    public void receiveDamage(CanAttack from, int damage) {
        super.receiveDamage(from, reduceDamage(damage));
    }
}

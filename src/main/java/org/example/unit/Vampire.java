package org.example.unit;

import org.example.ability.CanReceiveDamage;
import org.example.ability.HasVampirism;

public class Vampire extends AbstractUnit implements HasVampirism {
    public final static int STANDARD_HEALTH = 40;
    public final static int STANDARD_ATTACK = 4;
    public final static int STANDARD_VAMPIRISM_PERCENT = 50;

    private int vampirismPercent;

    public Vampire() {
        this(STANDARD_HEALTH, STANDARD_ATTACK, STANDARD_VAMPIRISM_PERCENT);
    }

    public Vampire(int health, int attack, int vampirismPercent) {
        super(health, attack);
        if (vampirismPercent < 0) {
            throw new IllegalArgumentException();
        }
        this.vampirismPercent = vampirismPercent;
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
        setHealth(Math.min(getMaxHealth(), getHealth() + health));
    }


    @Override
    public int getVampirism() {
        return vampirismPercent;
    }

    protected void setVampirismPercent(int vampirismPercent) {
        this.vampirismPercent = Math.max(0, vampirismPercent);
    }
}

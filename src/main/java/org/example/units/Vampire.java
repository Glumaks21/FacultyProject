package org.example.units;

public class Vampire extends Warrior {
    public static final int STANDARD_HEALTH = 40;
    public static final int STANDARD_ATTACK = 4;
    public static final int STANDARD_REGEN_PERCENT = 50;

    private int regenPercent;

    public Vampire() {
        this(STANDARD_HEALTH, STANDARD_ATTACK, STANDARD_REGEN_PERCENT);
    }

    public Vampire(int health, int attack, int regenPercent) {
        super(health, attack);
        if (regenPercent < 0) {
            throw new IllegalArgumentException();
        }

        this.regenPercent = regenPercent;
    }

    public double getPercentRegen() {
        return regenPercent;
    }

    public void setRegen(int regenPercent) {
        this.regenPercent = Math.max(0, regenPercent);
    }

    public void hit(Warrior opponent) {
        int before = opponent.getHealth();
        super.hit(opponent);
        int after = opponent.getHealth();

        int regenerated = (before - after) * regenPercent / 100;
        heal(regenerated);
    }
}

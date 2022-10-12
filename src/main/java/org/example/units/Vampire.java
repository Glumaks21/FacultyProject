package org.example.units;

public class Vampire extends Warrior {
    public static final int STANDARD_HEALTH = 40;
    public static final int STANDARD_ATTACK = 4;
    public static final double STANDARD_REGEN_PERCENT = 0.50;

    private double regenPercent;

    public Vampire() {
        this(STANDARD_HEALTH, STANDARD_ATTACK, STANDARD_REGEN_PERCENT);
    }

    public Vampire(int health, int attack, double regenPercent) {
        super(health, attack);
        if (regenPercent < 0) {
            throw new IllegalArgumentException();
        }

        this.regenPercent = regenPercent;
    }

    public double getPercentRegen() {
        return regenPercent;
    }

    public void setRegen(double regenPercent) {
        this.regenPercent = Math.max(0, regenPercent);
    }

    public void hit(Warrior opponent) {
        int before = opponent.getHealth();
        super.hit(opponent);
        int after = opponent.getHealth();

        int regened = (int) ((before - after) * regenPercent);
        heal(regened);
    }
}

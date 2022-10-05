package org.example.units;

public class Warrior {
    private final static int STANDARD_HEALTH = 50;
    private final static int STANDARD_DAMAGE = 5;

    private int health;
    private int damage;

    public Warrior() {
        health = STANDARD_HEALTH;
        damage = STANDARD_DAMAGE;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException();
        }

        this.damage = damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void hit(Warrior opponent) {
        opponent.receiveDamage(getDamage(), this);
    }

    public void receiveDamage(int value, Warrior from) {
        setHealth(getHealth() - value);
    }
}

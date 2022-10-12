package org.example.units;

public class Warrior {
    public final static int STANDARD_HEALTH = 50;
    public final static int STANDARD_ATTACK = 5;

    private int health;
    private int attack;

    public Warrior() {
        this(STANDARD_HEALTH, STANDARD_ATTACK);
    }

    public Warrior(int health, int attack) {
        if (health < 0 || attack < 0) {
            throw new IllegalArgumentException();
        }

        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public void heal(int health) {
        if (health > 0) {
            setHealth(Math.min(STANDARD_HEALTH, getHealth() + health));
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = Math.max(attack, 0);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void hit(Warrior opponent) {
        opponent.receiveDamage(getAttack(), this);
    }

    public void receiveDamage(int value, Warrior from) {
        setHealth(Math.max(0, getHealth() - value));
    }
}

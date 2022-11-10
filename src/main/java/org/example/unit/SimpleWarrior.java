package org.example.unit;

public class SimpleWarrior implements Warrior, CanHeal {
    public final static int STANDARD_HEALTH = 50;
    public final static int STANDARD_ATTACK = 5;

    private int health;
    private int attack;

    public SimpleWarrior() {
        this(STANDARD_HEALTH, STANDARD_ATTACK);
    }

    public SimpleWarrior(int health, int attack) {
        if (health < 0 || attack < 0) {
            throw new IllegalArgumentException();
        }

        this.health = health;
        this.attack = attack;
    }

    @Override
    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    @Override
    public void heal(int health) {
        if (health > 0) {
            setHealth(Math.min(STANDARD_HEALTH, getHealth() + health));
        }
    }

    @Override
    public int getAttack() {
        return attack;
    }

    private void setAttack(int attack) {
        this.attack = Math.max(attack, 0);
    }

    @Override
    public void receiveDamage(CanAttack from, int damage) {
        setHealth(Math.max(0, getHealth() - damage));
    }
}

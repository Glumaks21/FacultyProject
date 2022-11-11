package org.example.unit;

import org.example.ability.CanAttack;

public abstract class AbstractUnit implements Unit {
    private final int maxHealth;
    private int health;
    private int attack;

    public AbstractUnit(int health, int attack) {
        if (health <= 0 || attack <= 0) {
            throw new IllegalArgumentException();
        }

        maxHealth = health;
        this.health = health;
        this.attack = attack;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    protected void setAttack(int attack) {
         this.attack = Math.max(0, attack);
    }

    @Override
    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public void receiveDamage(CanAttack from, int damage) {
        setHealth(Math.max(0, getHealth() - damage));
    }
}

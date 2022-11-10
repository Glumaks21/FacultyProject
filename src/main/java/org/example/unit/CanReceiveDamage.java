package org.example.unit;

public interface CanReceiveDamage {
    int getHealth();
    default boolean isAlive() {
        return getHealth() > 0;
    }
    void receiveDamage(CanAttack from, int value);
}

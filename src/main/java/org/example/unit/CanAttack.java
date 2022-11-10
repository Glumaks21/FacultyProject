package org.example.unit;

public interface CanAttack {
    int getAttack();
    default void hit(CanReceiveDamage opponent) {
        opponent.receiveDamage(this, getAttack());
    }
}

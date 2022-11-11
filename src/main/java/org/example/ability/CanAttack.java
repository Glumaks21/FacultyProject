package org.example.ability;

public interface CanAttack {
    int getAttack();
    default void hit(CanReceiveDamage opponent) {
        opponent.receiveDamage(this, getAttack());
    }
}

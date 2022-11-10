package org.example.unit;

public interface HasVampirism extends CanHeal {
    int getVampirism();
    default void vampire(int finalDamage) {
        int regeneratedHealth = finalDamage * getVampirism() / 100;
        heal(regeneratedHealth);
    }
}

package org.example.ability;

public interface HasVampirism extends CanRestoreHealth {
    int getVampirism();
    default void vampire(int finalDamage) {
        int regeneratedHealth = finalDamage * getVampirism() / 100;
        restoreHealth(regeneratedHealth);
    }
}

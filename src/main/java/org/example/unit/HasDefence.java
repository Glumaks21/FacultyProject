package org.example.unit;

public interface HasDefence extends CanReceiveDamage {
    int getDefence();
    default int reduceDamage(int damage) {
        return Math.max(0, damage - getDefence());
    }
}

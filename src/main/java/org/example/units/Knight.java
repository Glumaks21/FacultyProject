package org.example.units;

public class Knight extends Warrior {
    public final static int STANDARD_ATTACK = 12;

    public Knight() {
        super(STANDARD_HEALTH, STANDARD_ATTACK);
    }

    public Knight(int health, int attack) {
        super(health, attack);
    }
}

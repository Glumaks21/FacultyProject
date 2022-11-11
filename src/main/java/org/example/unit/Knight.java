package org.example.unit;

public class Knight extends AbstractUnit {
    public final static int STANDARD_HEALTH = 50;
    public final static int STANDARD_ATTACK = 7;

    public Knight() {
        this(STANDARD_HEALTH, STANDARD_ATTACK);
    }

    public Knight(int health, int attack) {
        super(health, attack);
    }
}

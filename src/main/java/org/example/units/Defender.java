package org.example.units;

public class Defender extends Warrior {
    public static final int STANDARD_HEALTH = 60;
    public static final int STANDARD_ATTACK = 3;
    public static final int STANDARD_BLOCK = 2;

    private int block;

    public Defender() {
        this(STANDARD_HEALTH, STANDARD_ATTACK, STANDARD_BLOCK);
    }

    public Defender(int health, int attack, int block) {
        super(health, attack);
        if (block < 0) {
            throw new IllegalArgumentException();
        }

        this.block = block;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = Math.max(0, block);
    }

    @Override
    public void receiveDamage(int value, Warrior from) {
        super.receiveDamage(value - getBlock(), from);
    }
}

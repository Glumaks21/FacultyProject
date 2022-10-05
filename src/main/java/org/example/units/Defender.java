package org.example.units;

public class Defender extends Warrior {
    private static final int STANDARD_HEALTH = 60;
    private static final int STANDARD_ATTACK = 3;
    private static final int STANDARD_BLOCK = 2;

    private int block;

    public Defender() {
        setHealth(STANDARD_HEALTH);
        setDamage(STANDARD_ATTACK);
        setBlock(STANDARD_BLOCK);
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        if (block < 0) {
            throw new IllegalArgumentException();
        }

        this.block = block;
    }

    @Override
    public void receiveDamage(int value, Warrior from) {
        setHealth(getHealth() - Math.max(value - block, 0));
    }
}

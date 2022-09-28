package org.example;


import java.util.*;
import java.util.function.Supplier;

public class Army {
    private final Queue<Warrior> troops;

    public Army() {
        troops = new LinkedList<>();
    }

    public Warrior peekUnit() {
        return troops.peek();
    }

    public Warrior removeUnit() {
        return troops.remove();
    }

    public Army addUnit(Warrior warrior) {
        troops.add(warrior);
        return this;
    }

    public Army addUnits(Supplier<Warrior> type, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < quantity; i++) {
            troops.add(type.get());
        }
        return this;
    }

    public boolean isEmpty() {
        return troops.isEmpty();
    }
}

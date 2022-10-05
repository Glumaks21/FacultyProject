package org.example;


import org.example.units.Warrior;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    private final Queue<Warrior> units;

    public Army() {
        units = new LinkedList<>();
    }

    public boolean isEmpty() {
        return units.isEmpty();
    }

    public Warrior removeUnit() {
        return units.remove();
    }

    public Army addUnit(Warrior warrior) {
        if (warrior == null) {
            throw new IllegalArgumentException();
        }

        units.add(warrior);
        return this;
    }

    public Army addUnits(Supplier<Warrior> type, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < quantity; i++) {
            units.add(type.get());
        }
        return this;
    }

    public Iterator<Warrior> iterator() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<Warrior> {
        @Override
        public boolean hasNext() {
            while (units.peek() != null && !units.peek().isAlive()) {
                units.remove();
            }

            return !units.isEmpty();
        }

        @Override
        public Warrior next() {
            if (units.isEmpty()) {
                throw new NoSuchElementException();
            }

            return units.peek();
        }
    }
}

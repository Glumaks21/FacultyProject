package org.example;


import org.example.decorator.WithNeighborUnits;
import org.example.unit.Unit;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    private final List<Unit> units;

    public Army() {
        units = new ArrayList<>();
    }

    public boolean isEmpty() {
        return units.isEmpty();
    }

    public Unit removeUnit() {
        return units.remove(0);
    }

    public Army addUnit(Unit unit) {
        if (unit == null) {
            throw new IllegalArgumentException();
        }

        Unit unitInArmy;
        if (!units.isEmpty()) {
            Unit unitBefore = units.get(units.size() - 1);
            unitInArmy = new WithNeighborUnits(unit, unitBefore, null);
            WithNeighborUnits withNeighborUnits = (WithNeighborUnits) unitBefore;
            withNeighborUnits.setAfter(unitInArmy);
        } else {
            unitInArmy = new WithNeighborUnits(unit, null, null);
        }

        units.add(unitInArmy);
        return this;
    }

    public Army addUnits(Supplier<Unit> type, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < quantity; i++) {
            addUnit(type.get());
        }
        return this;
    }

    public Iterator<Unit> iterator() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<Unit> {
        @Override
        public boolean hasNext() {
            while (!units.isEmpty() && !units.get(0).isAlive()) {
                units.remove(0);
            }

            return !units.isEmpty();
        }

        @Override
        public Unit next() {
            if (units.isEmpty()) {
                throw new NoSuchElementException();
            }

            return units.get(0);
        }
    }
}

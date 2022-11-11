package org.example.decorator;

import org.example.ability.HasNeighborUnits;
import org.example.unit.Unit;

import java.util.Objects;

public class WithNeighborUnits extends UnitDecorator implements HasNeighborUnits {
    private Unit before;
    private Unit after;

    public WithNeighborUnits(Unit warrior, Unit before, Unit after) {
        super(warrior);
        this.before = before;
        this.after = after;
    }

    @Override
    public Unit unitBefore() {
        return before;
    }

    public void setAfter(Unit after) {
        this.after = after;
    }

    @Override
    public Unit unitAfter() {
        return after;
    }

    public void setBefore(Unit before) {
        this.before = before;
    }
}

package Pump;

import Fuel.Fuel;

import java.util.List;

class GasPump extends Pump {
    public GasPump(String id, List<Fuel> fuels) {
        super(id, fuels);
    }

    @Override
    protected Fuel findFuel(String type) {
        if (!type.startsWith("AI-")) {
            throw new IllegalArgumentException("Эта колонка работает только с бензином!");
        }
        return super.findFuel(type);
    }
}


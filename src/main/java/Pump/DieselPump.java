package Pump;
import Fuel.Fuel;
import java.util.List;

class DieselPump extends Pump {
    public DieselPump(String id, List<Fuel> fuels) {
        super(id, fuels);
        // Проверка: здесь должен быть только Diesel
    }

    @Override
    protected Fuel findFuel(String type) {
        if (!type.equalsIgnoreCase("Diesel")) {
            throw new IllegalArgumentException("Эта колонка работает только с дизелем!");
        }
        return super.findFuel(type);
    }
    /* checks for diesel only */

}


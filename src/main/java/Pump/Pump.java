package Pump;

import Car.Car;
import Fuel.Fuel;

import java.util.List;

public class Pump {
    protected String id;
    protected List<Fuel> fuels; // поддерживаемые виды
// refuel(car, liters), refuel(car, money), refuel(car)...
public Pump(String id, List<Fuel> fuels) {
    this.id = id;
    this.fuels = fuels;
}

    protected Fuel findFuel(String type) {
        for (Fuel f : fuels) {
            if (f.getName().equalsIgnoreCase(type)) {
                return f;
            }
        }
        throw new IllegalArgumentException("Несовместимый тип топлива: " + type);
    }

    // Заправка по литрам
    public double refuel(Car car, double liters) {
        Fuel f = findFuel(car.getFuelType());
        if (f == null) throw new IllegalArgumentException("Несовместимый тип топлива");
        double actual = f.consume(Math.min(liters, car.getFreeSpace()));
        car.addFuel(actual);
        return actual * f.getPricePerUnit(); // стоимость
    }

    // Заправка по деньгам
    public double refuel(Car car, int money) {
        Fuel f = findFuel(car.getFuelType());
        if (f == null) throw new IllegalArgumentException("Несовместимый тип топлива");
        double liters = money / f.getPricePerUnit();
        return refuel(car, liters);
    }

    // Заправка до полного бака
    public double refuel(Car car) {
        return refuel(car, car.getFreeSpace());
    }



    @Override
    public String toString() {
        return "Pump[" + id + ", fuels=" + fuels + "]";
    }
}


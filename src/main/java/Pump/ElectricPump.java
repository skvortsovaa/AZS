package Pump;

import Car.Car;
import Fuel.Fuel;

import java.util.List;

public class ElectricPump extends Pump {
    private static final double kWhPerMinute = 1.5; // например, 1.5 кВт⋅ч в минуту зарядки

    public ElectricPump(String id, List<Fuel> fuels) {
        super(id, fuels);
    }

    public double charge(Car car, int minutes) {
        if (!car.getFuelType().equalsIgnoreCase("Electric")) {
            throw new IllegalArgumentException("Эта колонка только для электромобилей!");
        }

        Fuel electricity = findFuel("Electricity");
        double energy = minutes * kWhPerMinute; // сколько зарядили
        double actual = electricity.consume(Math.min(energy, car.getFreeSpace()));
        car.addFuel(actual);
        return actual * electricity.getPricePerUnit();
    }

    @Override
    public double refuel(Car car, double liters) {
        throw new UnsupportedOperationException("Для электромобилей используйте charge()");
    }

    @Override
    public double refuel(Car car, int money) {
        throw new UnsupportedOperationException("Для электромобилей используйте charge()");
    }

    @Override
    public double refuel(Car car) {
        throw new UnsupportedOperationException("Для электромобилей используйте charge()");
    }
}

package GasStation;

import Car.Car;
import Fuel.Fuel;
import Pump.Pump;
import java.util.List;

public class GasStation {
    private List<Pump> pumps;
    private double revenue; // выручка
    private double expenses; // расходы на поставки
// addPump, serveCustomer, getRevenue, orderFuelDelivery, fuelStats ...
    public void addPump(Pump pump) {
        pumps.add(pump);
    }

    public double serveCustomer(Car car, Pump pump, double liters) {
        double cost = pump.refuel(car, liters);
        revenue += cost;
        return cost;
    }

    public double serveCustomer(Car car, Pump pump, int money) {
        double cost = pump.refuel(car, money);
        revenue += cost;
        return cost;
    }

    public double serveCustomer(Car car, Pump pump) {
        double cost = pump.refuel(car);
        revenue += cost;
        return cost;
    }

    public void orderFuelDelivery(Fuel fuel, double volume, double pricePerUnit) {
        fuel.add(volume);
        expenses += volume * pricePerUnit; // затраты на закупку
    }

    public double getRevenue() {
        return revenue - expenses;
    }

    public void fuelStats() {
        for (Pump p : pumps) {
            System.out.println(p);
        }
    }
}


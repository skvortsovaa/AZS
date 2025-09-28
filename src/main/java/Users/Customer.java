package Users;

import Car.Car;
import GasStation.GasStation;
import Pump.Pump;
import Pump.ElectricPump;

final class Customer extends User {
    private final Car car;

    public Customer(String name, Car car) {
        super(name);
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    // "Действие" клиента — заправка
    @Override
    public void performAction() {
        System.out.println(name + " подъехал на заправку: " + car);
    }

    public void refuelByLiters(Pump pump, double liters, GasStation station) {
        double cost = station.serveCustomer(car, pump, liters);
        System.out.println(name + " заправился на " + liters + " л за " + cost + " руб.");
    }

    public void refuelByMoney(Pump pump, int money, GasStation station) {
        double cost = station.serveCustomer(car, pump, money);
        System.out.println(name + " заправился на " + money + " руб. (получил топлива на " + cost + " руб.)");
    }

    public void refuelFull(Pump pump, GasStation station) {
        double cost = station.serveCustomer(car, pump);
        System.out.println(name + " заправился до полного бака на " + cost + " руб.");
    }

    public void chargeElectric(ElectricPump pump, int minutes, GasStation station) {
        double cost = pump.charge(car, minutes);
        System.out.println(name + " зарядился " + minutes + " мин, стоимость: " + cost + " руб.");
    }
}

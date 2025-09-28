package Users;

import Fuel.Fuel;
import GasStation.GasStation;

final class Manager extends User {
    private final GasStation station;

    public Manager(String name, GasStation station) {
        super(name);
        this.station = station;
    }

    @Override
    public void performAction() {
        System.out.println("Менеджер " + name + " работает с отчетами АЗС");
    }

    public void viewRevenue() {
        System.out.println("Чистая прибыль: " + station.getRevenue() + " руб.");
    }

    public void viewFuelStats() {
        System.out.println("Остатки топлива:");
        station.fuelStats();
    }

    public void orderFuelDelivery(Fuel fuel, double volume, double purchasePrice) {
        station.orderFuelDelivery(fuel, volume, purchasePrice);
        System.out.println("Менеджер " + name + " заказал поставку "
                + volume + " л топлива " + fuel.getName()
                + " по цене " + purchasePrice + " руб/л");
    }
}


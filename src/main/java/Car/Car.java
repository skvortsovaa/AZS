package Car;

public class Car {
    private final String fuelType; // "AI-95", "Diesel", "Electric"
    private final double tankCapacity;
    private double currentFuel;

    public Car(String fuelType, double tankCapacity, double currentFuel) {
        if (tankCapacity <= 0) throw new IllegalArgumentException("Ёмкость бака должна быть > 0");
        if (currentFuel < 0 || currentFuel > tankCapacity)
            throw new IllegalArgumentException("Некорректный уровень топлива");
        this.fuelType = fuelType;
        this.tankCapacity = tankCapacity;
        this.currentFuel = currentFuel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public double getFreeSpace() {
        return tankCapacity - currentFuel;
    }

    public void addFuel(double liters) {
        if (liters < 0) throw new IllegalArgumentException("Нельзя добавить отрицательный объём");
        if (currentFuel + liters > tankCapacity) {
            currentFuel = tankCapacity; // переполнение запрещено, заливаем до полного
        } else {
            currentFuel += liters;
        }
    }

    @Override
    public String toString() {
        return "Car[fuel= " + fuelType + ", tank=" + currentFuel + "/" + tankCapacity + " L]";
    }

}

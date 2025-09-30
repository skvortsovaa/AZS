package Fuel;

public class Fuel {
    private String name; // "AI-80", "AI-95", "AI-98", "Diesel", "Electricity"
    private double pricePerUnit; // литр или кВт⋅ч
    private double available; // остаток

    public Fuel(String name, double pricePerUnit, double available) {
        if (pricePerUnit < 0 || available < 0)
            throw new IllegalArgumentException("Цена и остаток должны быть >= 0");
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.available = available;
    }

    public String getName() { return name; }
    public double getPricePerUnit() { return pricePerUnit; }
    public double getAvailable() { return available; }

    public void add(double volume) {
        if (volume < 0) throw new IllegalArgumentException("Нельзя добавить отрицательный объём");
        available += volume;
    }

    public double consume(double volume) {
        if (volume < 0) throw new IllegalArgumentException("Нельзя отпустить отрицательный объём");
        double given = Math.min(volume, available);
        available -= given;
        return given; // фактически отпущено
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fuel)) return false;
        Fuel fuel = (Fuel) o;
        return name.equalsIgnoreCase(fuel.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Fuel" +name + ':' + pricePerUnit + "руб/л, остаток " + available + 'L';
    }
// consume, add, equals/hashCode, toString ...
}


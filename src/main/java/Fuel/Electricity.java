package Fuel;

public class Electricity extends Fuel {
    public Electricity(String name, double pricePerUnit, double available) {
        super(name, pricePerUnit, available);
    }

    @Override
    public String toString() {
        return super.toString() + " (Electricity)]";
    }
}

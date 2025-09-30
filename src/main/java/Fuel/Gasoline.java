package Fuel;

public class Gasoline extends Fuel {
    private int octane;

    public Gasoline(String name, double pricePerUnit, double available, int octane) {
        super(name, pricePerUnit, available);
        this.octane = octane;
    }

    public int getOctane() {
        return octane;
    }

    @Override
    public String toString() {
        return super.toString() + ", octane=" + octane + "]";
    }
}


package Fuel;

public class Diesel extends Fuel {
    private String grade; // например, "Зимний", "Летний"

    public Diesel(String name, double pricePerUnit, double available, String grade) {
        super(name, pricePerUnit, available);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return super.toString() + ", grade=" + grade + "]";
    }
}


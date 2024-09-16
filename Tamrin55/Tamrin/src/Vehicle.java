public class Vehicle {

    protected String brand;
    protected String fuelType;

    public Vehicle(String brand, String fuelType) {
        this.brand = brand;
        this.fuelType = fuelType;
    }

    public void start() {
        System.out.println(brand + " is starting.");
    }

    public void move() {
        System.out.println(brand + " is moving.");
    }
}

public class Car extends Vehicle {

    private String bodyType;

    public Car(String brand, String fuelType, String bodyType) {
        super(brand, fuelType);
        this.bodyType = bodyType;
    }
}

class Airplane extends Vehicle {
    private String status;

    public Airplane(String brand, String fuelType, String status) {
        super(brand, fuelType);
        this.status = status;
    }

    public void fly() {
        System.out.println(brand + " is flying.");
    }
}


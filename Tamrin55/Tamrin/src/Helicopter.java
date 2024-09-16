public class Helicopter extends Vehicle{

    public Helicopter(String brand, String fuelType) {
        super(brand, fuelType);
    }

    public void fly() {
        System.out.println(brand + " is flying.");
    }

    public void verticalTakeoff() {
        System.out.println(brand + " is taking off vertically.");
    }
}

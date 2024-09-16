import java.util.ArrayList;
import java.util.List;

public class Parking {

    private int capacity;
    private List<Car> cars;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public void parkCar(Car car) {
        if (cars.size() < capacity) {
            cars.add(car);
            System.out.println(car.brand + " is parked.");
        } else {
            System.out.println("Parking is full.");
        }
    }
}

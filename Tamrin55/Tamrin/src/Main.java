
public class Main {
    public static void main(String[] args) {
        Airport airport = new Airport();

        Car car1 = new Car("Toyota", "Gasoline", "Sedan");
        Car car2 = new Car("BMW", "Diesel", "SUV");
        airport.getParking().parkCar(car1);
        airport.getParking().parkCar(car2);

        Airplane airplane1 = new Airplane("Boeing", "Jet Fuel", "On Time");
        Helicopter helicopter1 = new Helicopter("Bell", "Aviation Fuel");
        airport.addAirplane(airplane1);
        airport.addHelicopter(helicopter1);

        car1.start();
        car1.move();
        airplane1.start();
        airplane1.fly();
        helicopter1.start();
        helicopter1.fly();
        helicopter1.verticalTakeoff();
    }
}
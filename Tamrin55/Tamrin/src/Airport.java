import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Airplane> airplanes;
    private List<Helicopter> helicopters;
    private Parking parking;

    public Airport() {
        this.airplanes = new ArrayList<>();
        this.helicopters = new ArrayList<>();
        this.parking = new Parking(10);
    }

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public void addHelicopter(Helicopter helicopter) {
        helicopters.add(helicopter);
    }

    public Parking getParking() {
        return parking;
    }
}

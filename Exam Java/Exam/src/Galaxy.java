import java.util.ArrayList;

public class Galaxy {
    private String name;
    private ArrayList<Planet> planets;

    public Galaxy(String name) {
        this.name = name;
        this.planets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }
}

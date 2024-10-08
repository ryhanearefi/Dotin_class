import java.util.ArrayList;

public class ResourceRichPlanet extends Planet {
    private ArrayList<String> resources;

    public ResourceRichPlanet(String name, String type, int numberOfMoons, double distanceFromSun, ArrayList<String> resources) {
        super(name, type, numberOfMoons, distanceFromSun);
        this.resources = resources;
    }

    public ArrayList<String> getResources() {
        return resources;
    }

    @Override
    public String toString() {
        return super.toString() + ", منابع طبیعی: " + String.join(", ", resources);
    }
}

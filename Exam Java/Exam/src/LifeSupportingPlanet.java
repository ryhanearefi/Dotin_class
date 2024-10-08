public class LifeSupportingPlanet extends Planet {
    private boolean hasLife;

    public LifeSupportingPlanet(String name, String type, int numberOfMoons, double distanceFromSun, boolean hasLife) {
        super(name, type, numberOfMoons, distanceFromSun);
        this.hasLife = hasLife;
    }

    public boolean hasLife() {
        return hasLife;
    }

    @Override
    public String toString() {
        return super.toString() + ", وضعیت حیات: " + (hasLife ? "دارد" : "ندارد");
    }
}

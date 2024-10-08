public class Planet {
    private String name;
    private String type;
    private int numberOfMoons;
    private double distanceFromSun;

    public Planet(String name, String type, int numberOfMoons, double distanceFromSun) {
        this.name = name;
        this.type = type;
        this.numberOfMoons = numberOfMoons;
        this.distanceFromSun = distanceFromSun;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfMoons(int numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }

    @Override
    public String toString() {
        return "نام: " + name + ", نوع: " + type + ", تعداد قمرها: " + numberOfMoons +
                ", فاصله از خورشید: " + distanceFromSun + " میلیون کیلومتر";
    }
}

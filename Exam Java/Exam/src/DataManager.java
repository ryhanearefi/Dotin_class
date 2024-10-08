import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataManager {
    public static void loadData(ArrayList<Galaxy> galaxies, String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                return;
            }
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                String name = parts[0].split(":")[1].trim();
                String galaxyName = parts[1].trim();
                String type = parts[2].trim();
                int moons = Integer.parseInt(parts[3].trim());
                double distance = Double.parseDouble(parts[4].trim());
                String lifeStatus = parts[5].trim();
                String resourcesInput = parts.length > 6 ? parts[6].trim() : "";

                boolean hasLife = lifeStatus.equalsIgnoreCase("دارد") || lifeStatus.equalsIgnoreCase("has life");

                ArrayList<String> resources = new ArrayList<>();
                if (!resourcesInput.isEmpty() && !resourcesInput.equalsIgnoreCase("nothing")) {
                    String[] resourcesArray = resourcesInput.split("،|,");
                    for (String res : resourcesArray) {
                        resources.add(res.trim());
                    }
                }

                Planet planet;
                if (hasLife) {
                    planet = new LifeSupportingPlanet(name, type, moons, distance, true);
                } else if (!resources.isEmpty()) {
                    planet = new ResourceRichPlanet(name, type, moons, distance, resources);
                } else {
                    planet = new Planet(name, type, moons, distance);
                }

                Galaxy galaxy = findGalaxyByName(galaxies, galaxyName);
                if (galaxy == null) {
                    galaxy = new Galaxy(galaxyName);
                    galaxies.add(galaxy);
                }
                galaxy.addPlanet(planet);
            }

            fileScanner.close();
        } catch (Exception e) {
            System.out.println("خطا در خواندن فایل داده‌ها.");
        }
    }

    public static void saveData(ArrayList<Galaxy> galaxies, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            for (Galaxy galaxy : galaxies) {
                for (Planet planet : galaxy.getPlanets()) {
                    StringBuilder line = new StringBuilder();
                    line.append("سیاره: ").append(planet.getName()).append(", ");
                    line.append(galaxy.getName()).append(", ");
                    line.append(planet instanceof LifeSupportingPlanet ? ((LifeSupportingPlanet) planet).toString() : planet.toString());
                    writer.write(line.toString());
                    writer.newLine();
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("خطا در ذخیره‌سازی فایل داده‌ها.");
        }
    }

    private static Galaxy findGalaxyByName(ArrayList<Galaxy> galaxies, String name) {
        for (Galaxy galaxy : galaxies) {
            if (galaxy.getName().equalsIgnoreCase(name)) {
                return galaxy;
            }
        }
        return null;
    }
}

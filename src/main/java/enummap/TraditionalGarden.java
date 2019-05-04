package enummap;

import java.util.HashSet;
import java.util.Set;

public class TraditionalGarden {

    public static void main(String[] args) {

        GardenFullOfPlants traditionalGarden = new GardenFullOfPlants();

        // Using ordinal() to index into an array - Don't do this!

        // Create an array of sets
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        // Initialize each set
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        // Add each plant in the gardent to corresponding set
        for (Plant p : traditionalGarden.plants) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        // Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.format("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }
}

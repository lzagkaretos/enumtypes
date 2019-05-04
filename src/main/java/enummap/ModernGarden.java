package enummap;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class ModernGarden {

    public static void main(String[] args) {

        GardenFullOfPlants modernGarden = new GardenFullOfPlants();

        // Using an EnumMap to associate data with an enum

        // Create a map (Lifecycle, Plants)
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lifeCycle : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lifeCycle, new HashSet<>());
        }

        for (Plant p : modernGarden.plants) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        System.out.println(plantsByLifeCycle);
        System.out.println();

        // Naive stream-based approach - unlikely to produce an EnumMap!
        Map<Plant.LifeCycle, Set<Plant>> naiveMap =
                modernGarden.plants.stream().collect(groupingBy(p -> p.lifeCycle, toSet()));

        System.out.println(naiveMap.getClass());
        System.out.println(naiveMap);
        System.out.println();

        // Using a stream and an EnumMap to associate data with an enum
        Map<Plant.LifeCycle, Set<Plant>> enumMap = modernGarden.plants.stream()
                .collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet()));

        System.out.println(enumMap.getClass());
        System.out.println(enumMap);
    }
}

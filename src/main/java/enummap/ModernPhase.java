package enummap;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public enum ModernPhase {

    SOLID, LIQUID, GAS, PLASMA;

    public enum ModernTransition {

        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),
        CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS),
        DEPOSIT(GAS, SOLID),

        IONIZE(GAS, PLASMA),
        DEIONIZE(PLASMA, GAS);

        private final ModernPhase from;
        private final ModernPhase to;

        ModernTransition(ModernPhase from, ModernPhase to) {
            this.from = from;
            this.to = to;
        }

        private ModernPhase getFrom() {
            return from;
        }

        private ModernPhase getTo() {
            return to;
        }

        // Initialize the phase transition map
        // Map of Maps
        // Cascaded sequence of two collectors (groupingBy(), toMap())
        private static final Map<ModernPhase, Map<ModernPhase, ModernTransition>> m =
                Stream.of(values())
                        .collect(groupingBy(ModernTransition::getFrom,
                                () -> new EnumMap<>(ModernPhase.class),
                                toMap(ModernTransition::getTo, t -> t, (x, y) -> y, () -> new EnumMap<>(ModernPhase.class))));

        public static ModernTransition from(ModernPhase from, ModernPhase to) {
            return m.get(from).get(to);
        }
    }
}

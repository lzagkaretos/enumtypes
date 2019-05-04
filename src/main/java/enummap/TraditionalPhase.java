package enummap;

public enum TraditionalPhase {

    SOLID, LIQUID, GAS;

    public enum TraditionalTransition {

        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        // Rows indexed by from-ordinal, cols by to-ordinal
        private static final TraditionalTransition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        public static TraditionalTransition from(TraditionalPhase from, TraditionalPhase to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}

package enummap;

public enum TraditionalPhase {

    SOLID, LIQUID, GAS, PLASMA;

    public enum TraditionalTransition {

        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT, IONIZE, DEIONIZE;

        // Rows indexed by from-ordinal, cols by to-ordinal
        private static final TraditionalTransition[][] TRANSITIONS = {
                {null, MELT, SUBLIME, null},
                {FREEZE, null, BOIL, null},
                {DEPOSIT, CONDENSE, null, IONIZE},
                {null, null, DEIONIZE, null}
        };

        public static TraditionalTransition from(TraditionalPhase from, TraditionalPhase to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}

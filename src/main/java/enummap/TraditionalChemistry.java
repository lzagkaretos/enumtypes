package enummap;

public class TraditionalChemistry {

    public static void main(String[] args) {

        TraditionalPhase fromPhase = TraditionalPhase.GAS;
        TraditionalPhase toPhase = TraditionalPhase.PLASMA;

        TraditionalPhase.TraditionalTransition transition =
                TraditionalPhase.TraditionalTransition.from(fromPhase, toPhase);

        System.out.format("Traditional transition from %s to %s is %s.", fromPhase, toPhase, transition);
    }
}

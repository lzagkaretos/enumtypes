package enummap;

public class ModernChemistry {

    public static void main(String[] args) {

        ModernPhase fromPhase = ModernPhase.LIQUID;
        ModernPhase toPhase = ModernPhase.SOLID;

        ModernPhase.ModernTransition transition =
                ModernPhase.ModernTransition.from(fromPhase, toPhase);

        System.out.format("Modern transition from %s to %s is %s.", fromPhase, toPhase, transition);
    }
}

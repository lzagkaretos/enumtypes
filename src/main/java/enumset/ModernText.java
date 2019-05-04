package enumset;

import java.util.EnumSet;
import java.util.Set;

public class ModernText {

    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyAllStyles(Set<Style> styles) {

        styles.stream().forEach(i -> System.out.format("%s style is active.\n", i));
    }

    public static void main(String[] args) {

        ModernText modernText = new ModernText();
        modernText.applyAllStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}

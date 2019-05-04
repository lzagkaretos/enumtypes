package enumset;

public class TraditionalText {

    // Bit field enumeration constants - OBSOLETE!
    public static final int STYLE_BOLD           = 1 << 0; // 1 - 0001
    public static final int STYLE_ITALIC         = 1 << 1; // 2 - 0010
    public static final int STYLE_UNDERLINE      = 1 << 2; // 4 - 0100
    public static final int STYLE_STRIKETHROUGH  = 1 << 3; // 8 - 1000

    // Parameter is bitwise OR of zero or more STYLE_ constants
    public void applyAllStyles(int styles) {

        System.out.format("Applying styles. Passed value: %d - %s.\n",
                styles, String.format("%4s", Integer.toBinaryString(styles)).replace(" ", "0"));

        if ((STYLE_BOLD & styles) == STYLE_BOLD) {
            System.out.println("Bold style is active.");
        }
        if ((STYLE_ITALIC & styles) == STYLE_ITALIC) {
            System.out.println("Italic style is active.");
        }
        if ((STYLE_UNDERLINE & styles) == STYLE_UNDERLINE) {
            System.out.println("Underline style is active.");
        }
        if ((STYLE_STRIKETHROUGH & styles) == STYLE_STRIKETHROUGH) {
            System.out.println("Strikethrough style is active.");
        }
    }

    public static void main(String[] args) {

        TraditionalText traditionalText = new TraditionalText();

        // Use bitwise OR operation to combine several constants into a Set, known as a bit field
        traditionalText.applyAllStyles(STYLE_BOLD | STYLE_ITALIC);
    }
}

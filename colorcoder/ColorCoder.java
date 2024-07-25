package colorcoder;

public class ColorCoder {

    private static final String[] majorColorNames = {
            "White", "Red", "Black", "Yellow", "Violet"
    };
    private static final int numberOfMajorColors = majorColorNames.length;
    private static final String[] minorColorNames = {
            "Blue", "Orange", "Green", "Brown", "Slate"
    };
    private static final int numberOfMinorColors = minorColorNames.length;

    public static String getMajorColorName(MajorColor majorColor) {
        return majorColorNames[majorColor.getIndex()];
    }

    public static String getMinorColorName(MinorColor minorColor) {
        return minorColorNames[minorColor.getIndex()];
    }

    public static ColorPair getColorFromPairNumber(int pairNumber) {
        int zeroBasedPairNumber = pairNumber - 1;
        MajorColor majorColor = MajorColor.fromIndex(zeroBasedPairNumber / numberOfMinorColors);
        MinorColor minorColor = MinorColor.fromIndex(zeroBasedPairNumber % numberOfMinorColors);
        return new ColorPair(majorColor, minorColor);
    }

    public static int getPairNumberFromColor(MajorColor major, MinorColor minor) {
        return major.getIndex() * numberOfMinorColors + minor.getIndex() + 1;
    }

    public static void printColorCodingManual() {
        System.out.println("Color Coding Manual:");
        for (int i = 1; i <= numberOfMajorColors * numberOfMinorColors; i++) {
            ColorPair colorPair = getColorFromPairNumber(i);
            System.out.println(i + " - " + colorPair.toString());
        }
    }
}

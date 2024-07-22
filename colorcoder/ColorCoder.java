package colorcoder;

public class ColorCoder {

    public enum MajorColor {
        WHITE(0),
        RED(1),
        BLACK(2),
        YELLOW(3),
        VIOLET(4);

        private int index;

        MajorColor(int index) {
            this.index = index;
        }

        int getIndex() {
            return index;
        }

        public static MajorColor fromIndex(int index) {
            for (MajorColor color : MajorColor.values()) {
                if (color.getIndex() == index) {
                    return color;
                }
            }
            return null;
        }
    }

    public enum MinorColor {
        BLUE(0),
        ORANGE(1),
        GREEN(2),
        BROWN(3),
        SLATE(4);

        private int index;

        MinorColor(int index) {
            this.index = index;
        }

        int getIndex() {
            return index;
        }

        public static MinorColor fromIndex(int index) {
            for (MinorColor color : MinorColor.values()) {
                if (color.getIndex() == index) {
                    return color;
                }
            }
            return null;
        }
    }

    private static final String[] majorColorNames = {
            "White", "Red", "Black", "Yellow", "Violet"
    };
    private static final int numberOfMajorColors = majorColorNames.length;
    private static final String[] minorColorNames = {
            "Blue", "Orange", "Green", "Brown", "Slate"
    };
    private static final int numberOfMinorColors = minorColorNames.length;

    public static class ColorPair {
        private MajorColor majorColor;
        private MinorColor minorColor;

        public ColorPair(MajorColor major, MinorColor minor) {
            majorColor = major;
            minorColor = minor;
        }

        public MajorColor getMajor() {
            return majorColor;
        }

        public MinorColor getMinor() {
            return minorColor;
        }

        @Override
        public String toString() {
            return majorColorNames[majorColor.getIndex()] + " " + minorColorNames[minorColor.getIndex()];
        }
    }

    public static ColorPair getColorFromPairNumber(int pairNumber) {
        int zeroBasedPairNumber = pairNumber - 1;
        MajorColor majorColor =
                MajorColor.fromIndex(zeroBasedPairNumber / numberOfMinorColors);
        MinorColor minorColor =
                MinorColor.fromIndex(zeroBasedPairNumber % numberOfMinorColors);
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

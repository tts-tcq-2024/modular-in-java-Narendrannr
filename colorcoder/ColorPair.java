package colorcoder;

public class ColorPair {
    private ColorCoder.MajorColor majorColor;
    private ColorCoder.MinorColor minorColor;

    public ColorPair(ColorCoder.MajorColor major, ColorCoder.MinorColor minor) {
        this.majorColor = major;
        this.minorColor = minor;
    }

    public ColorCoder.MajorColor getMajor() {
        return majorColor;
    }

    public ColorCoder.MinorColor getMinor() {
        return minorColor;
    }

    @Override
    public String toString() {
        return ColorCoder.getMajorColorName(majorColor) + " " + ColorCoder.getMinorColorName(minorColor);
    }
}

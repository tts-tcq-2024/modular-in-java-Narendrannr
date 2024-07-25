package colorcoder;

public class ColorUtil {
    public static <T extends Enum<T> & ColorIndex> T fromIndex(T[] values, int index) {
        for (T color : values) {
            if (color.getIndex() == index) {
                return color;
            }
        }
        return null;
    }

    public interface ColorIndex {
        int getIndex();
    }
}

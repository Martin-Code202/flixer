package android.support.v4.graphics;

import android.graphics.Color;
public final class ColorUtils {
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();

    public static int compositeColors(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i), alpha2, Color.red(i2), alpha, compositeAlpha), compositeComponent(Color.green(i), alpha2, Color.green(i2), alpha, compositeAlpha), compositeComponent(Color.blue(i), alpha2, Color.blue(i2), alpha, compositeAlpha));
    }

    private static int compositeAlpha(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int compositeComponent(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static double calculateLuminance(int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / 100.0d;
    }

    public static double calculateContrast(int i, int i2) {
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        }
        if (Color.alpha(i) < 255) {
            i = compositeColors(i, i2);
        }
        double calculateLuminance = calculateLuminance(i) + 0.05d;
        double calculateLuminance2 = calculateLuminance(i2) + 0.05d;
        return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
    }

    public static int setAlphaComponent(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    public static void colorToXYZ(int i, double[] dArr) {
        RGBToXYZ(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    public static void RGBToXYZ(int i, int i2, int i3, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = ((double) i) / 255.0d;
        double pow = d < 0.04045d ? d / 12.92d : Math.pow((0.055d + d) / 1.055d, 2.4d);
        double d2 = ((double) i2) / 255.0d;
        double pow2 = d2 < 0.04045d ? d2 / 12.92d : Math.pow((0.055d + d2) / 1.055d, 2.4d);
        double d3 = ((double) i3) / 255.0d;
        double pow3 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((0.055d + d3) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
        dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
        dArr[2] = ((0.0193d * pow) + (0.1192d * pow2) + (0.9505d * pow3)) * 100.0d;
    }

    private static double[] getTempDouble3Array() {
        double[] dArr = TEMP_ARRAY.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        TEMP_ARRAY.set(dArr2);
        return dArr2;
    }
}

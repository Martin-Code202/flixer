package o;
public class FJ extends FK {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static final FG m4990(int i, int i2) {
        return FG.f5660.m4985(i, i2, -1);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final FE m4991(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return FE.f5658.m4980();
        }
        return new FE(i, i2 - 1);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final int m4987(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final int m4988(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final int m4989(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
        } else if (i < i2) {
            return i2;
        } else {
            if (i > i3) {
                return i3;
            }
            return i;
        }
    }
}

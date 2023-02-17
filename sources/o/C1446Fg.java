package o;
/* renamed from: o.Fg  reason: case insensitive filesystem */
public final class C1446Fg {
    /* renamed from: ॱ  reason: contains not printable characters */
    private static final int m5004(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final int m5003(int i, int i2, int i3) {
        return m5004(m5004(i, i3) - m5004(i2, i3), i3);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final int m5002(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - m5003(i2, i, i3);
        }
        if (i3 < 0) {
            return m5003(i, i2, -i3) + i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}

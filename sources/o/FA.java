package o;
public final class FA {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final double f5652 = (1.0d / f5657);

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final double f5653 = (1.0d / f5656);

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final double f5654 = Math.log(2.0d);

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final double f5655 = Math.ulp(1.0d);

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final double f5656 = Math.sqrt(f5655);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final double f5657 = Math.sqrt(f5656);

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final float m4975(float f) {
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        if (f > 0.0f) {
            return (float) Math.floor((double) f);
        }
        return (float) Math.ceil((double) f);
    }
}

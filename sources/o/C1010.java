package o;
/* renamed from: o.ᵌ  reason: contains not printable characters */
public class C1010 {
    /* renamed from: ˏ  reason: contains not printable characters */
    private static float m15968(float f) {
        if (f <= 0.0031308f) {
            return 12.92f * f;
        }
        return (float) ((Math.pow((double) f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static float m15967(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((double) ((0.055f + f) / 1.055f), 2.4000000953674316d);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m15969(float f, int i, int i2) {
        float f2 = ((float) ((i >> 24) & 255)) / 255.0f;
        float r4 = m15967(((float) ((i >> 16) & 255)) / 255.0f);
        float r5 = m15967(((float) ((i >> 8) & 255)) / 255.0f);
        float r6 = m15967(((float) (i & 255)) / 255.0f);
        float r8 = m15967(((float) ((i2 >> 16) & 255)) / 255.0f);
        float f3 = f2 + (((((float) ((i2 >> 24) & 255)) / 255.0f) - f2) * f);
        float r14 = r6 + ((m15967(((float) (i2 & 255)) / 255.0f) - r6) * f);
        return (Math.round(f3 * 255.0f) << 24) | (Math.round(m15968(r4 + ((r8 - r4) * f)) * 255.0f) << 16) | (Math.round(m15968(r5 + ((m15967(((float) ((i2 >> 8) & 255)) / 255.0f) - r5) * f)) * 255.0f) << 8) | Math.round(m15968(r14) * 255.0f);
    }
}

package o;
/* renamed from: o.ᵋ  reason: contains not printable characters */
public class C1009 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final float[] f15094;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int[] f15095;

    public C1009(float[] fArr, int[] iArr) {
        this.f15094 = fArr;
        this.f15095 = iArr;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public float[] m15963() {
        return this.f15094;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int[] m15966() {
        return this.f15095;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m15964() {
        return this.f15095.length;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15965(C1009 r5, C1009 r6, float f) {
        if (r5.f15095.length != r6.f15095.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + r5.f15095.length + " vs " + r6.f15095.length + ")");
        }
        for (int i = 0; i < r5.f15095.length; i++) {
            this.f15094[i] = C1150.m16323(r5.f15094[i], r6.f15094[i], f);
            this.f15095[i] = C1010.m15969(f, r5.f15095[i], r6.f15095[i]);
        }
    }
}

package o;
/* access modifiers changed from: package-private */
/* renamed from: o.ﹰ  reason: contains not printable characters */
public class C1158 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f15406;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final double f15407;

    /* renamed from: ॱ  reason: contains not printable characters */
    private double f15408 = -1.0d;

    public C1158(double d) {
        int i;
        this.f15407 = d;
        if (d == 0.0d) {
            i = Integer.MAX_VALUE;
        } else {
            i = (int) Math.ceil(1.0d / d);
        }
        this.f15406 = i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public double m16346() {
        return this.f15408;
    }
}

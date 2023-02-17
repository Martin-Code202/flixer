package o;

import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
/* renamed from: o.Cr  reason: case insensitive filesystem */
public class C1375Cr implements AbstractC1370Co {

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f5195;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f5196 = SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f5197;

    /* renamed from: ˋ  reason: contains not printable characters */
    private double f5198 = 0.5d;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f5199 = 1000;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f5200 = 120000;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private double f5201 = 1.5d;

    public C1375Cr() {
        m4547();
    }

    public C1375Cr(int i, double d, double d2, int i2, int i3) {
        this.f5199 = i;
        if (d > 1.0d || d <= 0.0d) {
            this.f5198 = 0.0d;
        } else {
            this.f5198 = d;
        }
        this.f5201 = d2;
        this.f5196 = i2;
        this.f5200 = i3;
        m4547();
    }

    @Override // o.AbstractC1370Co
    /* renamed from: ॱ */
    public long mo4515() {
        if (!mo4514()) {
            return -1;
        }
        int r5 = m4544(this.f5198, Math.random(), this.f5197);
        m4545();
        return (long) r5;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m4545() {
        if (((double) this.f5197) >= ((double) this.f5196) / this.f5201) {
            this.f5197 = this.f5196;
        } else {
            this.f5197 = (int) (((double) this.f5197) * this.f5201);
        }
    }

    @Override // o.AbstractC1370Co
    /* renamed from: ˋ */
    public boolean mo4514() {
        return m4546() <= ((long) this.f5200);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m4547() {
        this.f5197 = this.f5199;
        this.f5195 = System.nanoTime();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final long m4546() {
        return (System.nanoTime() - this.f5195) / 1000000;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m4544(double d, double d2, int i) {
        if (d <= 0.0d) {
            return i;
        }
        double d3 = d * ((double) i);
        double d4 = ((double) i) - d3;
        return (int) (((((((double) i) + d3) - d4) + 1.0d) * d2) + d4);
    }
}

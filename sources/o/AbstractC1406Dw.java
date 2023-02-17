package o;
/* renamed from: o.Dw  reason: case insensitive filesystem */
public abstract class AbstractC1406Dw {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f5467 = false;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1405Dv f5468 = null;

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract C1405Dv mo4765(int i);

    protected AbstractC1406Dw() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m4766(int i) {
        if (this.f5467) {
            return false;
        }
        if (this.f5468 != null) {
            return true;
        }
        this.f5468 = m4767(i);
        return this.f5468 != null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1405Dv m4767(int i) {
        if (this.f5467) {
            return null;
        }
        if (this.f5468 == null) {
            return mo4765(i);
        }
        C1405Dv dv = this.f5468;
        this.f5468 = null;
        return dv;
    }
}

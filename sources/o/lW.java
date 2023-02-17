package o;
public abstract class lW implements AbstractC1976mg {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected String f8596;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected long f8597;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected float f8598;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected long f8599;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m8702() {
        return this.f8596;
    }

    @Override // o.AbstractC1976mg
    /* renamed from: ॱ  reason: contains not printable characters */
    public long mo8705() {
        return this.f8597;
    }

    @Override // o.AbstractC1976mg
    /* renamed from: ˎ  reason: contains not printable characters */
    public long mo8703() {
        return this.f8599;
    }

    @Override // o.AbstractC1976mg
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo8706(long j, long j2) {
        if (j <= j2) {
            return j2 > this.f8597 && j <= this.f8599;
        }
        C1283.m16850("nf_subtitles", "From can not be later than to!");
        return false;
    }

    @Override // o.AbstractC1976mg
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo8704(long j) {
        return j >= this.f8597 && j <= this.f8599;
    }

    public String toString() {
        return ", mId='" + this.f8596 + "', mStart=" + this.f8597 + ", mEnd=" + this.f8599 + ", mMaxFontSizeMultiplier=" + this.f8598;
    }
}

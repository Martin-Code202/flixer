package o;
/* renamed from: o.mt  reason: case insensitive filesystem */
public abstract class AbstractC1989mt implements AbstractC1992mw {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected short f8930;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected String f8931;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected short f8932;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected short f8933;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected String f8934;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected short f8935;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected int f8936;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected int f8937;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected int f8938;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected int f8939;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected int f8940;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected boolean f8941;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected long f8942;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected int f8943;

    @Override // o.AbstractC1992mw
    /* renamed from: ˏ  reason: contains not printable characters */
    public int mo9078() {
        return this.f8940;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo9082() {
        return this.f8936;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ˋ  reason: contains not printable characters */
    public short mo9076() {
        return this.f8935;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ˎ  reason: contains not printable characters */
    public short mo9077() {
        return this.f8933;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ˊ  reason: contains not printable characters */
    public short mo9072() {
        return this.f8932;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public short mo9085() {
        return this.f8930;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ʽ  reason: contains not printable characters */
    public long mo9071() {
        return this.f8942;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ʼ  reason: contains not printable characters */
    public int mo9070() {
        return this.f8943;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ʻ  reason: contains not printable characters */
    public synchronized String mo9069() {
        return this.f8931;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void mo9080(String str) {
        this.f8931 = str;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ᐝ  reason: contains not printable characters */
    public String mo9086() {
        return this.f8934;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo9079(int i) {
        this.f8939 = i;
        this.f8934 = i + ".png";
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo9083(long j) {
        return ((long) this.f8940) <= j && ((long) this.f8936) > j;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo9074(long j, long j2) {
        if (j <= j2) {
            return j2 > ((long) this.f8940) && j <= ((long) this.f8936);
        }
        C1283.m16850("nf_subtitles", "From can not be later than to!");
        return false;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public int mo9084() {
        return this.f8939;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public int mo9075() {
        return this.f8938;
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void mo9081() {
        if (!this.f8941) {
            this.f8941 = true;
            this.f8938++;
        }
    }

    @Override // o.AbstractC1992mw
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo9073(long j) {
        if (j < ((long) this.f8936)) {
            this.f8941 = false;
        }
    }
}

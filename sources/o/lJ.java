package o;

import com.google.gson.annotations.SerializedName;
class lJ extends lC {
    @SerializedName("moffold")
    protected long moffold;
    @SerializedName("moffoldms")
    protected long moffoldms;
    @SerializedName("navt")
    protected long navt;

    protected lJ() {
    }

    public lJ(String str) {
        super("repos", str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lJ m8616(long j) {
        super.m8545(j);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public lJ m8617(long j) {
        this.moffold = j / 1000;
        this.moffoldms = j;
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lJ m8618(long j) {
        this.navt = j;
        return this;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public lJ m8615(long j) {
        m8547(j);
        return this;
    }
}

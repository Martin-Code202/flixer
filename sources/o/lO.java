package o;

import com.google.gson.annotations.SerializedName;
class lO extends lC {
    @SerializedName("volume")
    protected int newVolume;
    @SerializedName("volumeOld")
    protected int oldVolume;

    protected lO() {
    }

    public lO(String str) {
        super("volumechange", str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lO m8655(long j) {
        m8547(j);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public lO m8657(long j) {
        m8545(j);
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public lO m8656(int i) {
        this.oldVolume = i;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lO m8654(int i) {
        this.newVolume = i;
        return this;
    }
}

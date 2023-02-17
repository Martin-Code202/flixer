package o;

import com.google.gson.annotations.SerializedName;
class lK extends lC {
    @SerializedName("manifestswitch")
    protected boolean manifestswitch;
    @SerializedName("vbitrate")
    protected Long vbitrate;
    @SerializedName("vbitrateold")
    protected Long vbitrateold;
    @SerializedName("vdlid")
    protected String vdlid;
    @SerializedName("vdlidold")
    protected String vdlidold;

    protected lK() {
    }

    public lK(String str) {
        super("renderstrmswitch", str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lK m8619(long j) {
        m8547(j);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lK m8622(long j) {
        m8545(j);
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public lK m8621(String str, long j) {
        this.vdlidold = str;
        this.vbitrateold = Long.valueOf(j);
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public lK m8620(String str, long j) {
        this.vdlid = str;
        this.vbitrate = Long.valueOf(j);
        return this;
    }
}

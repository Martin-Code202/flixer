package o;

import com.google.gson.annotations.SerializedName;
import o.AbstractC1952kz;
class lA extends lC {
    @SerializedName("bw")
    protected Integer bw;
    @SerializedName("lbw")
    protected Integer lbw;
    @SerializedName("vbitrate")
    protected Integer vbitrate;
    @SerializedName("vbitrateold")
    protected Integer vbitrateold;
    @SerializedName("vdlid")
    protected String vdlId;
    @SerializedName("vdlidold")
    protected String vdlidold;

    protected lA() {
    }

    public lA(String str) {
        super("chgstrm", str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lA m8544(AbstractC1952kz.C0142 r2) {
        this.vdlidold = r2.f8490;
        this.vbitrateold = Integer.valueOf(r2.f8491);
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lA m8542(AbstractC1952kz.C0142 r3) {
        super.m8545(r3.f8489);
        this.vdlId = r3.f8490;
        this.bw = Integer.valueOf(r3.f8487);
        this.lbw = Integer.valueOf(r3.f8488);
        this.vbitrate = Integer.valueOf(r3.f8491);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public lA m8543(long j) {
        m8547(j);
        return this;
    }
}

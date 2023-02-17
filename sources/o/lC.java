package o;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.aseinterface.IAsePlayerState;
import com.netflix.mediaclient.servicemgr.Logblob;
public abstract class lC {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static final transient Logblob.Severity f8502 = Logblob.Severity.info;
    @SerializedName("abuflbytes")
    protected Long abuflbytes;
    @SerializedName("abuflmsec")
    protected Long abuflmsec;
    @SerializedName("moff")
    protected Long moff;
    @SerializedName("moffms")
    protected Long moffms;
    @SerializedName("playertype")
    protected String player = "exoplayer";
    @SerializedName("soff")
    protected Long soff;
    @SerializedName("soffms")
    protected Long soffms;
    @SerializedName("type")
    protected String type;
    @SerializedName("vbuflbytes")
    protected Long vbuflbytes;
    @SerializedName("vbuflmsec")
    protected Long vbuflmsec;
    @SerializedName("xid")
    protected String xid;

    /* renamed from: ˋ  reason: contains not printable characters */
    private transient Logblob.Severity f8503 = f8502;

    protected lC() {
    }

    public lC(String str, String str2) {
        this.type = str;
        this.xid = str2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Logblob mo8548() {
        return new lF(this.type, this.f8503, mo1083(), this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8547(long j) {
        this.soffms = Long.valueOf(j);
        this.soff = Long.valueOf(j / 1000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8545(long j) {
        this.moffms = Long.valueOf(j);
        this.moff = Long.valueOf(j / 1000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m8546(Logblob.Severity severity) {
        this.f8503 = severity;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public boolean mo1083() {
        return false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lC mo8549(long j, IAsePlayerState iAsePlayerState) {
        if (iAsePlayerState != null) {
            IAsePlayerState.Cif[] r2 = iAsePlayerState.mo1008();
            long r3 = iAsePlayerState.mo1007();
            this.abuflmsec = Long.valueOf(Math.max(j, r2[0].m1021(r3)));
            this.vbuflmsec = Long.valueOf(Math.max(j, r2[1].m1021(r3)));
            this.abuflbytes = Long.valueOf(r2[0].m1022());
            this.vbuflbytes = Long.valueOf(r2[1].m1022());
        }
        return this;
    }
}

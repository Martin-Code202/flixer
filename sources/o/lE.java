package o;

import com.google.gson.annotations.SerializedName;
import o.AbstractC1952kz;
/* access modifiers changed from: package-private */
public class lE extends lC {
    @SerializedName("cdnid")
    protected String cdnid;
    @SerializedName("imagebasedsubtitle")
    protected Boolean subtitleRebuffer;
    @SerializedName("vdlid")
    protected String vdlid;

    protected lE() {
    }

    public lE(String str) {
        super("intrplay", str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public lE m8554(long j) {
        super.m8545(j);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lE m8555(long j) {
        m8547(j);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lE m8556(AbstractC1952kz.If r2) {
        if (r2 != null) {
            this.cdnid = Integer.toString(r2.f8472);
        }
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public lE m8557(boolean z) {
        this.subtitleRebuffer = z ? true : null;
        return this;
    }
}

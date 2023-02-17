package o;

import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.CurrentNetworkInfo;
/* access modifiers changed from: package-private */
public class lN extends lC {
    @SerializedName("carrier")
    protected String carrier;
    @SerializedName("ifname")
    protected String ifname;
    @SerializedName("mcc")
    protected Integer mcc;
    @SerializedName("mnc")
    protected Integer mnc;
    @SerializedName("netspec")
    protected CurrentNetworkInfo.NetSpec netspec;
    @SerializedName("nettype")
    protected CurrentNetworkInfo.NetType nettype;

    protected lN() {
    }

    public lN(String str) {
        super("networksel", str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public lN m8653(CurrentNetworkInfo currentNetworkInfo) {
        this.carrier = currentNetworkInfo.m1038();
        this.mcc = currentNetworkInfo.m1037();
        this.mnc = currentNetworkInfo.m1041();
        this.nettype = currentNetworkInfo.m1039();
        this.netspec = currentNetworkInfo.m1040();
        return this;
    }
}

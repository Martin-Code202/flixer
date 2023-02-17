package o;

import android.content.Context;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.OfflineCodecPrefData;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadVideoQuality;
import com.netflix.mediaclient.util.ConnectivityUtils;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ja  reason: case insensitive filesystem */
public class C1900ja extends iW {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f7998 = iW.class.getSimpleName();

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f7999;

    /* renamed from: ˎ  reason: contains not printable characters */
    private DownloadVideoQuality f8000;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f8001;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f8002;

    C1900ja(Context context, AbstractC1221 r2, UserAgentInterface userAgentInterface, ConnectivityUtils.NetType netType) {
        super(context, userAgentInterface, r2, netType);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public C1900ja m7987(String str, String str2) {
        this.f7999 = str;
        this.f8001 = str2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public C1900ja m7986(DownloadVideoQuality downloadVideoQuality) {
        this.f8000 = downloadVideoQuality;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public C1900ja m7985(String str) {
        this.f8002 = str;
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ॱ */
    public void mo7614(JSONObject jSONObject) {
        jSONObject.put("type", IBladeRunnerClient.ManifestType.OFFLINE.m943());
        jSONObject.put("downloadQuality", this.f8000);
        Assert.assertNotNull(this.f7999);
        Assert.assertNotNull(this.f8001);
        jSONObject.put("oxid", this.f7999);
        jSONObject.put("dxid", this.f8001);
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ॱ */
    public JSONArray mo7613() {
        if (!C1349Bv.m4107(this.f8002)) {
            return super.mo7613();
        }
        C1283.m16863(f7998, "using mSelectedVideoCodecProfile %s", this.f8002);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f8002);
        m7609(jSONArray);
        return jSONArray;
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ˋ */
    public boolean mo7608(Context context) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ˎ */
    public boolean mo7610() {
        OfflineCodecPrefData m_ = this.f7674.m_();
        return m_ != null && m_.isVP9HWCodecEnabled;
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ˏ */
    public boolean mo7612() {
        OfflineCodecPrefData m_ = this.f7674.m_();
        return m_ != null && m_.isEveVP9HWCodecEnabled;
    }

    /* access modifiers changed from: protected */
    @Override // o.iW
    /* renamed from: ˋ */
    public boolean mo7607() {
        OfflineCodecPrefData m_ = this.f7674.m_();
        return m_ != null && m_.isAVCHighCodecEnabled;
    }
}

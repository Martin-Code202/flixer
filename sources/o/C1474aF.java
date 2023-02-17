package o;

import android.os.SystemClock;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.HttpResponse;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.aF  reason: case insensitive filesystem */
public class C1474aF extends AbstractC1523az {

    /* renamed from: ʻ  reason: contains not printable characters */
    private AssetType f5892;

    /* renamed from: ʽ  reason: contains not printable characters */
    private JSONObject f5893;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f5894;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f5895;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1489aU f5896;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f5897 = "INVALID";

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m5372() {
        return this.f5894;
    }

    public C1474aF(String str, AssetType assetType, String str2) {
        this.f5894 = str;
        this.f5892 = assetType;
        if (str2 == null) {
            C1276.m16820().mo5725("defaultResourceLocationType for UIAssetRequestSession is null");
        }
        this.f5897 = str2;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "uiAssetRequest";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1489aU m5374(IClientLogging.CompletionReason completionReason, HttpResponse httpResponse, Error error, String str) {
        this.f5895 = SystemClock.elapsedRealtime();
        C1489aU aUVar = new C1489aU(System.currentTimeMillis() - this.f6160);
        aUVar.setCategory(mo5643());
        aUVar.setSessionId(this.f6158);
        aUVar.m5395(this.f5894);
        aUVar.m5393(this.f5892);
        aUVar.m5394(error);
        aUVar.m5396(completionReason);
        aUVar.m5399(httpResponse);
        aUVar.m5397(new C1483aO());
        aUVar.m5400(str == null ? this.f5897 : str);
        if (this.f5893 != null) {
            aUVar.m5398(this.f5893);
        }
        return aUVar;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0013: APUT  
      (r2v1 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Boolean : 0x000e: INVOKE  (r3v2 java.lang.Boolean) = (r3v1 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5371(JSONObject jSONObject) {
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.f5896 != null);
        C1283.m16863("nf_UIAssetRequestSession", "UIAssetRequestSession setUiAssetNetworkStats has endEvent=%b", objArr);
        this.f5893 = jSONObject;
        if (this.f5896 != null) {
            this.f5896.m5398(this.f5893);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m5376() {
        if (this.f5893 == null && SystemClock.elapsedRealtime() - this.f5895 < 10000) {
            return true;
        }
        return false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1489aU m5373() {
        return this.f5896;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5375(C1489aU aUVar) {
        this.f5896 = aUVar;
    }
}

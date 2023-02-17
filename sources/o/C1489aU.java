package o;

import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.HttpResponse;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.aU  reason: case insensitive filesystem */
public final class C1489aU extends SessionEndedEvent {

    /* renamed from: ʼ  reason: contains not printable characters */
    private HttpResponse f5919;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1483aO f5920;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f5921 = "INVALID";

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f5922;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Error f5923;

    /* renamed from: ˏ  reason: contains not printable characters */
    private IClientLogging.CompletionReason f5924;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AssetType f5925;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private JSONObject f5926;

    public C1489aU(long j) {
        super("uiAssetRequest", new DeviceUniqueId(), j);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5400(String str) {
        this.f5921 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5395(String str) {
        this.f5922 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5394(Error error) {
        this.f5923 = error;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5396(IClientLogging.CompletionReason completionReason) {
        this.f5924 = completionReason;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5393(AssetType assetType) {
        this.f5925 = assetType;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5399(HttpResponse httpResponse) {
        this.f5919 = httpResponse;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f5922 != null) {
            data.put("url", this.f5922);
        }
        if (this.f5923 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f5923.toJSONObject());
        }
        if (this.f5919 != null) {
            data.put("response", this.f5919.toJSONObject());
        }
        if (this.f5924 != null) {
            data.put("reason", this.f5924.name());
        }
        if (this.f5925 != null) {
            data.put("assetType", this.f5925.name());
        }
        if (this.f5921 != null) {
            data.put("resourceLocationType", this.f5921);
        }
        if (this.f5926 != null) {
            data.put("networkStats", this.f5926);
        } else {
            C1283.m16862("AssetRequestEndedEvent", "mUiAssetNetworkStats null");
        }
        return data;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5397(C1483aO aOVar) {
        this.f5920 = aOVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getCustomData() {
        if (this.f5920 == null) {
            return null;
        }
        return this.f5920.m5387();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5398(JSONObject jSONObject) {
        this.f5926 = jSONObject;
    }
}

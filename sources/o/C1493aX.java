package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.HttpResponse;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.aX  reason: case insensitive filesystem */
public final class C1493aX extends SessionEndedEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Error f5938;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f5939;

    /* renamed from: ˎ  reason: contains not printable characters */
    private HttpResponse f5940;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f5941;

    /* renamed from: ॱ  reason: contains not printable characters */
    private IClientLogging.CompletionReason f5942;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1483aO f5943;

    public C1493aX(long j) {
        super("uiDataRequest", new DeviceUniqueId(), j);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5413(String str) {
        this.f5939 = str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5409(String str) {
        this.f5941 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5411(Error error) {
        this.f5938 = error;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5408(HttpResponse httpResponse) {
        this.f5940 = httpResponse;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5412(IClientLogging.CompletionReason completionReason) {
        this.f5942 = completionReason;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f5939 != null) {
            data.put("url", this.f5939);
        }
        if (this.f5938 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f5938.toJSONObject());
        }
        if (this.f5940 != null) {
            data.put("response", this.f5940.toJSONObject());
        }
        if (this.f5942 != null) {
            data.put("reason", this.f5942.name());
        }
        if (this.f5941 != null) {
            data.put("requestId", this.f5941);
        }
        return data;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5410(C1483aO aOVar) {
        this.f5943 = aOVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getCustomData() {
        if (this.f5943 == null) {
            return null;
        }
        return this.f5943.m5387();
    }

    @Override // com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent, com.netflix.mediaclient.service.logging.client.model.SessionEvent, com.netflix.mediaclient.service.logging.client.model.Event
    public String toString() {
        return "UIDataRequestSessionEndedEvent [url=" + this.f5939 + ", requestId=" + this.f5941 + ", error=" + this.f5938 + ", response=" + this.f5940 + ", reason=" + this.f5942 + "]";
    }
}

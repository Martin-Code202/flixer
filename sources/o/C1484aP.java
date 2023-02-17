package o;

import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import org.json.JSONObject;
/* renamed from: o.aP  reason: case insensitive filesystem */
public final class C1484aP extends SessionStartedEvent {

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f5913 = false;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f5914 = true;

    public C1484aP() {
        super("appSession");
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("lastShutdownGraceful", this.f5914);
        data.put("lastShutdownByUser", this.f5913);
        return data;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5388(boolean z) {
        this.f5914 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5389(boolean z) {
        this.f5913 = z;
    }
}

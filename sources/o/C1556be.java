package o;

import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import org.json.JSONObject;
/* renamed from: o.be  reason: case insensitive filesystem */
public final class C1556be extends SessionStartedEvent {

    /* renamed from: ˎ  reason: contains not printable characters */
    private ApplicationPerformanceMetricsLogging.Trigger f6153;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f6154;

    public C1556be(ApplicationPerformanceMetricsLogging.Trigger trigger, long j) {
        super("userSession");
        if (trigger == null) {
            throw new IllegalArgumentException("Trigger is null!");
        }
        this.f6153 = trigger;
        this.f6154 = j;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("trigger", this.f6153.name());
        data.put("idleTime", this.f6154);
        return data;
    }
}

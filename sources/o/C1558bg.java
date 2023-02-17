package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import org.json.JSONObject;
/* renamed from: o.bg  reason: case insensitive filesystem */
public final class C1558bg extends SessionEndedEvent {

    /* renamed from: ˊ  reason: contains not printable characters */
    private ApplicationPerformanceMetricsLogging.EndReason f6155;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f6156;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f6157;

    public C1558bg(DeviceUniqueId deviceUniqueId, long j, ApplicationPerformanceMetricsLogging.EndReason endReason, long j2) {
        super("userSession", deviceUniqueId, j);
        this.f6157 = j;
        this.f6156 = j2;
        if (endReason == null) {
            throw new IllegalArgumentException("End reason is null!");
        }
        this.f6155 = endReason;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("lastUserActivityTime", this.f6156);
        data.put("userSessionDuration", this.f6157);
        return data;
    }
}

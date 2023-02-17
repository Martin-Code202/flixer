package o;

import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import org.json.JSONObject;
/* renamed from: o.de  reason: case insensitive filesystem */
public class C1666de extends SessionStartedEvent {

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1487aS f6433;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ApplicationPerformanceMetricsLogging.UiStartupTrigger f6434;

    public C1666de(ApplicationPerformanceMetricsLogging.UiStartupTrigger uiStartupTrigger, C1487aS aSVar) {
        super("foreground");
        this.f6434 = uiStartupTrigger;
        this.f6433 = aSVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f6434 != null) {
            data.put("appTrigger", this.f6434.m1500());
        } else {
            data.put("appTrigger", ApplicationPerformanceMetricsLogging.UiStartupTrigger.dedicatedOnScreenIcon.m1500());
        }
        if (this.f6433 != null) {
            data.put("trigger", ApplicationPerformanceMetricsLogging.UiStartupTrigger.externalApp.m1500());
            if (C1349Bv.m4107(this.f6433.m5392())) {
                data.put("sourceTypePayload", this.f6433.m5392());
            }
        } else {
            data.put("trigger", ApplicationPerformanceMetricsLogging.UiStartupTrigger.dedicatedOnScreenIcon.m1500());
        }
        return data;
    }
}

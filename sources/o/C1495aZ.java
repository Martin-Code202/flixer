package o;

import com.netflix.mediaclient.service.logging.apm.model.Display;
import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.client.model.Version;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: o.aZ  reason: case insensitive filesystem */
public final class C1495aZ extends SessionEndedEvent {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f5946;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f5947;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f5948;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Display f5949;

    /* renamed from: ˋ  reason: contains not printable characters */
    private IClientLogging.ModalView f5950;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f5951 = true;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ApplicationPerformanceMetricsLogging.UiStartupTrigger f5952;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C1491aV f5953;

    /* renamed from: ॱ  reason: contains not printable characters */
    private UIError f5954;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Map<String, Integer> f5955;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1487aS f5956;

    public C1495aZ(long j, ApplicationPerformanceMetricsLogging.UiStartupTrigger uiStartupTrigger, IClientLogging.ModalView modalView, boolean z, C1487aS aSVar, C1491aV aVVar) {
        super("uiStartup", new DeviceUniqueId(), j);
        if (uiStartupTrigger == null) {
            throw new IllegalArgumentException("Trigger is null!");
        }
        this.f5952 = uiStartupTrigger;
        if (modalView == null) {
            throw new IllegalArgumentException("Destination is null!");
        }
        this.f5950 = modalView;
        this.f5951 = z;
        this.f5956 = aSVar;
        this.f5953 = aVVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("trigger", this.f5952.name());
        data.put("destinationView", this.f5950.name());
        data.put(FalkorPathResult.SUCCESS, this.f5951);
        data.put("voiceEnabled", this.f5947);
        if (this.f5949 != null) {
            data.put("display", this.f5949.m594());
        }
        if (this.f5954 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f5954.toJSONObject());
        }
        if (this.f5946 != null) {
            data.put("trackId", this.f5946);
        }
        if (this.f5948 != null) {
            data.put("searchTerm", this.f5948);
        }
        if (this.f5955 != null) {
            JSONObject jSONObject = new JSONObject();
            data.put("activeABTests", jSONObject);
            for (String str : this.f5955.keySet()) {
                jSONObject.put(str, this.f5955.get(str));
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        data.put(LoggingRequest.VERSION, jSONObject2);
        if (this.f5956 != null) {
            data.put("deeplinkMsgParams", this.f5956.m5391());
        }
        jSONObject2.put(Version.OS, String.valueOf(C1317As.m3758()));
        data.put("playerType", "JPLAYER2");
        return data;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getCustomData() {
        if (this.f5953 == null) {
            return null;
        }
        return this.f5953.m5404();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5417(Display display) {
        this.f5949 = display;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5415(UIError uIError) {
        this.f5954 = uIError;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5414(String str) {
        this.f5946 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5418(String str) {
        this.f5948 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5416(Map<String, Integer> map) {
        this.f5955 = map;
    }
}

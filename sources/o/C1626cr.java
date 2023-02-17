package o;

import com.netflix.cl.model.event.session.DebugSession;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionStartedEvent;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: o.cr  reason: case insensitive filesystem */
public class C1626cr extends AbstractC1560bi {

    /* renamed from: ʻ  reason: contains not printable characters */
    SessionEndedEvent f6373;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6374 = "PerfSession";

    /* renamed from: ˎ  reason: contains not printable characters */
    public DebugSession f6375;

    /* renamed from: ˏ  reason: contains not printable characters */
    SessionStartedEvent f6376;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Map<String, String> f6377;

    @Override // o.AbstractC1560bi
    /* renamed from: ˋ */
    public String mo5643() {
        return "PerformanceProfiler";
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "PerformanceSession";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5952(SessionEndedEvent sessionEndedEvent) {
        this.f6373 = sessionEndedEvent;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5957(SessionStartedEvent sessionStartedEvent) {
        this.f6376 = sessionStartedEvent;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public SessionStartedEvent m5960() {
        return this.f6376;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public SessionEndedEvent m5961() {
        return this.f6373;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m5959() {
        return (this.f6376 == null || this.f6373 == null) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f6376 != null) {
            sb.append(String.format("Name - %s.started, logTime - %d", this.f6376.getSessionName(), Long.valueOf(this.f6376.getTime())));
        }
        if (this.f6373 != null) {
            if (this.f6376 != null) {
                sb.append("\n");
            }
            sb.append(String.format("Name - %s.ended, logTime - %d, duration - %d", this.f6373.getSessionName(), Long.valueOf(this.f6373.getTime()), Long.valueOf(this.f6373.getDuration())));
        }
        return sb.toString();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1626cr m5955(Sessions sessions, Map<String, String> map) {
        C1626cr crVar = new C1626cr();
        AnonymousClass4 r2 = new SessionStartedEvent(sessions.name()) { // from class: o.cr.4
        };
        r2.setSessionId(crVar.m5779());
        r2.setCategory("PerformanceProfiler");
        crVar.m5957(r2);
        crVar.m5958(map);
        return crVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5956(final Map<String, String> map) {
        AnonymousClass2 r0 = new SessionEndedEvent(this.f6376, 0) { // from class: o.cr.2
            /* access modifiers changed from: protected */
            @Override // com.netflix.mediaclient.service.logging.client.model.Event
            public JSONObject getCustomData() {
                if (C1626cr.this.f6377 != null && map != null) {
                    C1626cr.this.f6377.putAll(map);
                } else if (map != null) {
                    C1626cr.this.f6377 = map;
                }
                if (C1626cr.this.f6377 == null || C1626cr.this.f6377.isEmpty()) {
                    return super.getCustomData();
                }
                return new JSONObject(C1626cr.this.f6377);
            }
        };
        r0.setCategory("PerformanceProfiler");
        r0.setDuration(r0.getTime() - this.f6376.getTime());
        m5952(r0);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5958(Map<String, String> map) {
        this.f6377 = map;
    }
}

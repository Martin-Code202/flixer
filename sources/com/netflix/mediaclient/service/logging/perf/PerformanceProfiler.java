package com.netflix.mediaclient.service.logging.perf;

import android.app.Activity;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;
import com.netflix.cl.Logger;
import com.netflix.cl.model.event.session.DebugSession;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import o.AH;
import o.AbstractC0723;
import o.BW;
import o.C0729;
import o.C1127;
import o.C1283;
import o.C1331Bd;
import o.C1626cr;
import org.json.JSONException;
import org.json.JSONObject;
public enum PerformanceProfiler {
    INSTANCE;
    

    /* renamed from: ˊ  reason: contains not printable characters */
    private final ArrayList<DiscreteEvent> f1248 = new ArrayList<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final ConcurrentHashMap<Long, C1626cr> f1249 = new ConcurrentHashMap<>();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ConcurrentHashMap<Sessions, List<AbstractC0017>> f1250 = new ConcurrentHashMap<>();

    /* renamed from: com.netflix.mediaclient.service.logging.perf.PerformanceProfiler$ˊ  reason: contains not printable characters */
    public interface AbstractC0017 {
        /* renamed from: ˋ  reason: contains not printable characters */
        void m673(Sessions sessions, C1626cr crVar);

        /* renamed from: ॱ  reason: contains not printable characters */
        void m674(Sessions sessions, C1626cr crVar);
    }

    private PerformanceProfiler() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m658(Sessions sessions, C1626cr crVar) {
        List<AbstractC0017> list = this.f1250.get(sessions);
        if (list != null) {
            for (AbstractC0017 r0 : list) {
                r0.m674(sessions, crVar);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m654(Sessions sessions, C1626cr crVar) {
        List<AbstractC0017> list = this.f1250.get(sessions);
        if (list != null) {
            for (AbstractC0017 r0 : list) {
                r0.m673(sessions, crVar);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m664() {
        synchronized (this.f1248) {
            this.f1248.clear();
        }
        synchronized (this.f1249) {
            this.f1249.clear();
        }
        for (List<AbstractC0017> list : this.f1250.values()) {
            if (list != null) {
                list.clear();
            }
        }
        this.f1250.clear();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Map<String, String> m652() {
        return Collections.singletonMap("reason", IClientLogging.CompletionReason.failed.name());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m669(Events events, Map<String, String> map) {
        DiscreteEvent r1 = m660(events, map);
        synchronized (this.f1248) {
            this.f1248.add(r1);
        }
        C0729 r2 = new C0729(m657((Enum) events, map));
        Logger.INSTANCE.m131(r2);
        m659("discreteEvent CLV2: ", r2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Long m670(Sessions sessions, Map<String, String> map) {
        C1626cr r3 = C1626cr.m5955(sessions, map);
        DebugSession debugSession = new DebugSession(m657(sessions, map), DebugSession.DebugSessionType.Performance);
        r3.f6375 = debugSession;
        Logger.INSTANCE.m142(debugSession);
        m659("startSession CLV2: ", debugSession);
        synchronized (this.f1249) {
            this.f1249.put(Long.valueOf(r3.m5779().getValue()), r3);
        }
        m658(sessions, r3);
        return Long.valueOf(r3.m5779().getValue());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Long m663(Sessions sessions) {
        return m670(sessions, (Map<String, String>) null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m667(Sessions sessions, Map<String, String> map, Long l) {
        if (l == null || !this.f1249.containsKey(l)) {
            C1283.m16862("PerformanceProfiler", "Couldn't find the SessionStartedEvent");
            return;
        }
        C1626cr crVar = this.f1249.get(l);
        if (crVar != null) {
            crVar.m5956(map);
            DebugSession debugSession = crVar.f6375;
            if (debugSession != null) {
                C1127 r4 = new C1127(debugSession, m657(sessions, map));
                Logger.INSTANCE.m147(r4);
                m659("endSession CLV2: ", r4);
            }
            m654(sessions, crVar);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m665(Sessions sessions, Map<String, String> map) {
        synchronized (this.f1249) {
            for (C1626cr crVar : this.f1249.values()) {
                if (crVar.m5961() == null && crVar.m5960().getSessionName().equals(sessions.name())) {
                    m667(sessions, map, Long.valueOf(crVar.m5779().getValue()));
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m672(Sessions sessions) {
        m665(sessions, null);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m668() {
        C1283.m16862("PerformanceProfiler", "flush...");
        m661();
        ArrayList<DiscreteEvent> arrayList = new ArrayList();
        synchronized (this.f1248) {
            arrayList.addAll(this.f1248);
            this.f1248.clear();
        }
        for (DiscreteEvent discreteEvent : arrayList) {
            BW.m3936(discreteEvent);
        }
        Iterator<C1626cr> it = this.f1249.values().iterator();
        while (it.hasNext()) {
            C1626cr next = it.next();
            if (next.m5959()) {
                it.remove();
                BW.m3939(next);
                BW.m3934(next);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m661() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m671(Activity activity) {
        m661();
        if (C1331Bd.m4011(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 232);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ArrayList<DiscreteEvent> arrayList = new ArrayList();
        synchronized (this.f1248) {
            arrayList.addAll(this.f1248);
        }
        for (DiscreteEvent discreteEvent : arrayList) {
            try {
                m662(discreteEvent, sb);
            } catch (JSONException e) {
                C1283.m16862("PerformanceProfiler", "DiscreteEvent prep failed: " + e.getMessage());
            }
        }
        ArrayList<C1626cr> arrayList2 = new ArrayList();
        synchronized (this.f1249) {
            arrayList2.addAll(this.f1249.values());
        }
        for (C1626cr crVar : arrayList2) {
            try {
                m655(crVar, sb);
            } catch (JSONException e2) {
                C1283.m16862("PerformanceProfiler", "Session prep failed: " + e2.getMessage());
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        if (AH.m3344("PerformanceProfiler", sb.toString(), "perf_dump.txt")) {
            Toast.makeText(activity, "File dumped! Please run perfScripts/perf.sh", 0).show();
            C1283.m16862("PerformanceProfiler", "File dumped! Please run perfScripts/perf.sh");
        } else {
            Toast.makeText(activity, "File dump failed!", 0).show();
            C1283.m16862("PerformanceProfiler", "File dump failed!");
        }
        m664();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m662(DiscreteEvent discreteEvent, StringBuilder sb) {
        m653(discreteEvent.toJSONObject(), discreteEvent.getTime(), discreteEvent.getTime() + 30, m656(discreteEvent.toJSONObject()), sb);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m655(C1626cr crVar, StringBuilder sb) {
        JSONObject jSONObject = crVar.m5960().toJSONObject();
        if (crVar.m5961() != null) {
            m653(jSONObject, crVar.m5960().getTime(), crVar.m5961().getTime(), m656(crVar.m5961().toJSONObject()), sb);
        } else {
            C1283.m16850("PerformanceProfiler", "Session not closed, so we can't graph it..." + crVar);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m653(JSONObject jSONObject, long j, long j2, boolean z, StringBuilder sb) {
        jSONObject.put("epoch", m666());
        jSONObject.put(SessionEndedEvent.DURATION, j2 - j);
        jSONObject.put("color", z ? "red" : "green");
        sb.append(jSONObject);
        sb.append(",");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m666() {
        long time;
        synchronized (this.f1248) {
            time = this.f1248.size() > 0 ? this.f1248.get(0).getTime() : SystemClock.elapsedRealtime();
        }
        return time;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m656(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(Event.CUSTOM);
        if (optJSONObject != null) {
            return optJSONObject.optBoolean("failed");
        }
        return false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static DiscreteEvent m660(Events events, final Map<String, String> map) {
        AnonymousClass5 r1 = new DiscreteEvent() { // from class: com.netflix.mediaclient.service.logging.perf.PerformanceProfiler.5
            /* access modifiers changed from: protected */
            @Override // com.netflix.mediaclient.service.logging.client.model.Event
            public JSONObject getCustomData() {
                if (map == null || map.isEmpty()) {
                    return super.getCustomData();
                }
                return new JSONObject(map);
            }
        };
        r1.setName(events.name());
        r1.setCategory("PerformanceProfiler");
        return r1;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m651(Map<String, String> map) {
        INSTANCE.m669(Events.APP_TRIM_MEMORY, map);
        INSTANCE.m668();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static JSONObject m657(Enum r4, Map<String, String> map) {
        JSONObject jSONObject = null;
        if (map != null) {
            try {
                if (map.size() > 0) {
                    jSONObject = new JSONObject(map);
                    jSONObject.put("name", r4.name());
                    return jSONObject;
                }
            } catch (JSONException e) {
            }
        }
        jSONObject = new JSONObject();
        jSONObject.put("name", r4.name());
        return jSONObject;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m659(String str, AbstractC0723 r1) {
    }
}

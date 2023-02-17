package com.netflix.mediaclient.net;

import android.content.Context;
import android.os.SystemClock;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.util.HashMap;
import java.util.Map;
import o.AbstractApplicationC1258;
import o.AbstractC0646;
import o.AbstractC1052;
import o.C0655;
import o.C0660;
import o.C0666;
import o.C1283;
import o.C1339Bl;
import o.C1349Bv;
import org.json.JSONArray;
import org.json.JSONObject;
public enum NetworkRequestLogger implements AbstractC0646 {
    INSTANCE;
    

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f998;

    /* renamed from: ʽ  reason: contains not printable characters */
    private JSONObject f999;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f1000;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f1001;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1052.If f1002;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f1003 = true;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Map<NetworkRequestType, C0666> f1004 = new HashMap();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Map<AppVisibilityState, C0660> f1005 = new HashMap();

    private NetworkRequestLogger() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m476(AbstractC1052.If r7, long j) {
        this.f1002 = r7;
        this.f1001 = j;
        String r4 = C1339Bl.m4045(r7.mo15853(), "previous_network_stats", (String) null);
        C1283.m16851("nf_net_stats", "NetworkRequestLogge::init: previousNetworkStats: %s", r4);
        if (!C1349Bv.m4113(r4)) {
            C1339Bl.m4041(r7.mo15853(), "previous_network_stats");
            try {
                this.f999 = new JSONObject(r4);
            } catch (Throwable th) {
                C1283.m16856("nf_net_stats", th, "Failed to create JSON!", new Object[0]);
            }
        }
    }

    @Override // o.AbstractC0646
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void mo474(NetworkRequestType networkRequestType, String str, Long l, Long l2) {
        if (!C1349Bv.m4113(str)) {
            C1283.m16851("nf_net_stats", "onNetworkRequestFinished:: url: %s", str);
            m468(this.f1002);
            Context r5 = this.f1002.mo15853();
            if (networkRequestType == null) {
                networkRequestType = m469(str);
            }
            if (networkRequestType == null) {
                C1283.m16865("nf_net_stats", "onNetworkRequestFinished:: networkRequestType is null!");
                m470(r5);
                return;
            }
            C1283.m16851("nf_net_stats", "onNetworkRequestFinished:: networkRequestType: %s", networkRequestType.name());
            C0666 r6 = this.f1004.get(networkRequestType);
            if (r6 == null) {
                r6 = new C0666(networkRequestType);
                this.f1004.put(networkRequestType, r6);
            }
            String r7 = C0655.m14816(r5);
            if (r7 == null) {
                C1283.m16850("nf_net_stats", "Network type is null, not expected! Set it to 'unknown'");
                r7 = "unkown";
            }
            r6.m14862(r7, l, l2);
            AppVisibilityState appVisibilityState = AbstractApplicationC1258.getInstance().mo236() ? AppVisibilityState.BACKGROUND : AppVisibilityState.FOREGROUND;
            C0660 r9 = this.f1005.get(appVisibilityState);
            if (r9 == null) {
                r9 = new C0660();
                this.f1005.put(appVisibilityState, r9);
            }
            r9.m14832(l, l2);
            m470(r5);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m470(Context context) {
        if (m472()) {
            C1283.m16854("nf_net_stats", "Saving network starts...");
            C1339Bl.m4039(context, "previous_network_stats", toString());
            C1283.m16854("nf_net_stats", "Saving network done.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized JSONObject m473() {
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.f1001;
        C1283.m16851("nf_net_stats", "toJson: now: %d, startTimeInMs: %d, duration: %d", Long.valueOf(currentTimeMillis), Long.valueOf(this.f1001), Long.valueOf(j));
        jSONObject = new JSONObject();
        jSONObject.put("appId", this.f1000);
        jSONObject.put("startTime", this.f1001);
        jSONObject.put(SessionEndedEvent.DURATION, j);
        JSONArray jSONArray = new JSONArray();
        jSONObject.put(Event.DATA, jSONArray);
        for (C0666 r0 : this.f1004.values()) {
            jSONArray.put(r0.m14861());
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONObject.put("app_visibility_data", jSONArray2);
        for (Map.Entry<AppVisibilityState, C0660> entry : this.f1005.entrySet()) {
            JSONObject r14 = entry.getValue().m14829();
            r14.put("state", entry.getKey().toString());
            jSONArray2.put(r14);
        }
        return jSONObject;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        try {
            return m473().toString();
        } catch (Throwable th) {
            C1283.m16856("nf_net_stats", th, "Failed to create toString!", new Object[0]);
            return "";
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private synchronized void m468(AbstractC1052.If r6) {
        if (this.f1003) {
            this.f1000 = r6.mo15847().mo1520();
            if (C1349Bv.m4113(this.f1000)) {
                C1283.m16850("nf_net_stats", "saveAppData:: appId is still not available!");
                return;
            }
            C1283.m16851("nf_net_stats", "saveAppData:: appId: %s, start time in ms: %d", this.f1000, Long.valueOf(this.f1001));
            this.f1003 = false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m472() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = elapsedRealtime - this.f998 > 30000;
        C1283.m16851("nf_net_stats", "shouldSaveStats:: now: %d, lastTimeLogged: %d, save: %b", Long.valueOf(elapsedRealtime), Long.valueOf(this.f998), Boolean.valueOf(z));
        if (z) {
            this.f998 = elapsedRealtime;
        }
        return z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject m475() {
        return this.f999;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static NetworkRequestType m469(String str) {
        if (str.contains("/msl")) {
            return m467(str);
        }
        return m471(str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static NetworkRequestType m467(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        String substring = str.substring(lastIndexOf + 1);
        C1283.m16851("nf_net_stats", "parseMslRequestForNetworkRequestType:: last index of /: %d, type: %s", Integer.valueOf(lastIndexOf), substring);
        return NetworkRequestType.m477(substring);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static NetworkRequestType m471(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf("&TAG=");
        if (lastIndexOf < 0) {
            lastIndexOf = str.lastIndexOf("?TAG=");
        }
        int lastIndexOf2 = str.lastIndexOf("&");
        if (lastIndexOf < 0) {
            return null;
        }
        if (lastIndexOf < lastIndexOf2) {
            lastIndexOf2 = str.indexOf("&", lastIndexOf + 5);
            str2 = str.substring(lastIndexOf + 5, lastIndexOf2);
        } else {
            str2 = str.substring(lastIndexOf + 5);
        }
        C1283.m16851("nf_net_stats", "parseWebRequestForNetworkRequestType:: last index of '[&|?]TAG=': %d, last index of delimiter: %d, type: %s", Integer.valueOf(lastIndexOf), Integer.valueOf(lastIndexOf2), str2);
        return NetworkRequestType.m477(str2);
    }
}

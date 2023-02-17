package com.netflix.mediaclient.service.logging.pdslogging.offline;

import android.content.Context;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.util.ConnectivityUtils;
import o.AbstractC1613cg;
import o.AbstractC1897iy;
import o.C1283;
import o.C1618cl;
import o.C1621co;
import o.M;
import o.oX;
import org.json.JSONArray;
import org.json.JSONObject;
public class PdsOfflinePlaySession implements AbstractC1613cg, C1621co.AbstractC0106 {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final String f1174 = PdsOfflinePlaySession.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private oX f1175;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private C1621co f1176;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f1177;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private boolean f1178 = false;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f1179;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f1180;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private long f1181;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f1182;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private JSONObject f1183;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Context f1184;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f1185;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private M f1186;

    /* renamed from: ͺ  reason: contains not printable characters */
    private long f1187;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f1188;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f1189;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean f1190;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f1191;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C1618cl f1192;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f1193;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private PlayState f1194;

    enum PlayState {
        STARTING,
        PLAYING,
        PAUSED,
        STOPPED
    }

    public PdsOfflinePlaySession(Context context, String str, String str2, long j, String str3, String str4, M m, oX oXVar, boolean z) {
        this.f1184 = context;
        this.f1180 = str2;
        this.f1185 = str;
        this.f1191 = j;
        this.f1179 = j;
        this.f1177 = str3;
        this.f1188 = str4;
        this.f1186 = m;
        this.f1175 = oXVar;
        this.f1176 = new C1621co(this);
        this.f1194 = PlayState.STARTING;
        this.f1190 = z;
    }

    @Override // o.AbstractC1613cg
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo612(AbstractC1897iy.If r5) {
        JSONObject r3 = r5.mo7641();
        if (r3 != null) {
            this.f1183 = r3.optJSONObject(LoggingRequest.EVENTS);
            if (this.f1183 == null) {
                C1283.m16854(f1174, "Legacy manifest detected. only send stop message");
                this.f1189 = true;
                this.f1183 = r3.optJSONObject("stopPlayback");
            }
            C1283.m16845(f1174, "mEventsLink: " + this.f1183);
        }
        this.f1182 = r5.mo7637();
        this.f1193 = r5.mo7632();
        this.f1192 = r5.mo7644();
    }

    @Override // o.AbstractC1613cg
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo615(JSONObject jSONObject) {
        if (this.f1194 == PlayState.STARTING) {
            this.f1194 = PlayState.PLAYING;
            this.f1187 = System.currentTimeMillis();
            m606(m603(IBladeRunnerClient.PdsEventType.START, jSONObject, this.f1191));
        } else if (this.f1194 == PlayState.PAUSED) {
            this.f1194 = PlayState.PLAYING;
            m606(m603(IBladeRunnerClient.PdsEventType.RESUME, jSONObject, this.f1191));
        }
        m605();
    }

    @Override // o.AbstractC1613cg
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo609(JSONObject jSONObject) {
        this.f1194 = PlayState.PAUSED;
        m606(m603(IBladeRunnerClient.PdsEventType.PAUSE, jSONObject, this.f1191));
    }

    @Override // o.AbstractC1613cg
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo614(long j) {
        this.f1191 = j;
    }

    @Override // o.AbstractC1613cg
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo607(JSONObject jSONObject, String str, String str2) {
        if (this.f1194 == PlayState.STARTING || this.f1194 == PlayState.STOPPED) {
            C1283.m16851(f1174, "ignore duplicate stop message, playableId: %s, errorCode: %s", jSONObject, str);
            return;
        }
        this.f1194 = PlayState.STOPPED;
        if (this.f1176.m5899()) {
            this.f1176.m5898(false);
        }
        m606(m603(IBladeRunnerClient.PdsEventType.STOP, jSONObject, this.f1191));
        this.f1186.mo5180();
    }

    @Override // o.AbstractC1613cg
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo611(Context context, long j, JSONObject jSONObject) {
        C1283.m16851(f1174, "notifyPlayProgress %d, %s", Long.valueOf(j), jSONObject);
        if (j >= this.f1191) {
            this.f1191 = j;
        }
        if (this.f1187 > 0 && System.currentTimeMillis() >= this.f1181) {
            m605();
            if (ConnectivityUtils.m2964(context)) {
                m606(m603(IBladeRunnerClient.PdsEventType.KEEP_ALIVE, jSONObject, this.f1191));
            }
        }
    }

    @Override // o.AbstractC1613cg
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo608() {
        this.f1176.m5896();
    }

    @Override // o.AbstractC1613cg
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo610(boolean z) {
        this.f1176.m5898(z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m606(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.f1190) {
                C1283.m16854(f1174, "dropping pds event. disabled via config");
            } else if (this.f1176.m5899()) {
                this.f1176.m5895(jSONObject);
            } else {
                mo613(jSONObject);
            }
        }
    }

    @Override // o.C1621co.AbstractC0106
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo613(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        this.f1186.mo5179(jSONObject2);
        if (this.f1178) {
            C1283.m16851(f1174, "pdsEvent: %s", jSONObject2);
        }
        if (ConnectivityUtils.m2964(this.f1184)) {
            this.f1186.mo5180();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private JSONObject m603(IBladeRunnerClient.PdsEventType pdsEventType, JSONObject jSONObject, long j) {
        C1283.m16851(f1174, "buildPdsEvent %s, bookmarkInMs(%d)", pdsEventType, Long.valueOf(j));
        if (!this.f1189 || pdsEventType == IBladeRunnerClient.PdsEventType.STOP) {
            JSONObject r5 = m604(pdsEventType, jSONObject, j);
            switch (pdsEventType) {
                case START:
                case SPLICE:
                case PAUSE:
                case RESUME:
                case KEEP_ALIVE:
                case STOP:
                    break;
                default:
                    C1283.m16851(f1174, "unexpected eventType, %s", pdsEventType);
                    break;
            }
            return r5;
        }
        C1283.m16854(f1174, "skip building non stop message for Legacy manifest");
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject m604(IBladeRunnerClient.PdsEventType pdsEventType, JSONObject jSONObject, long j) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = this.f1183;
            jSONObject2.put(LoggingRequest.VERSION, 2);
            jSONObject2.put("url", jSONObject3.optString("href"));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.putOpt("event", pdsEventType.m945());
            jSONObject4.putOpt("xid", this.f1180);
            jSONObject4.putOpt("clientTime", Long.valueOf(System.currentTimeMillis()));
            jSONObject4.putOpt("position", Long.valueOf(j));
            jSONObject4.putOpt("startPosition", Long.valueOf(this.f1179));
            jSONObject4.putOpt("sessionStartTime", Long.valueOf(this.f1187));
            long currentTimeMillis = System.currentTimeMillis();
            if (pdsEventType == IBladeRunnerClient.PdsEventType.STOP) {
                jSONObject4.putOpt("sessionEndTime", Long.valueOf(currentTimeMillis));
            }
            jSONObject4.putOpt("trackId", Integer.valueOf(this.f1175.getTrackId()));
            jSONObject4.putOpt("sessionId", this.f1188);
            jSONObject4.putOpt("appId", this.f1177);
            jSONObject4.putOpt("cachedcontent", true);
            jSONObject4.putOpt("persistentlicense", Boolean.valueOf(this.f1176.m5897()));
            if (IBladeRunnerClient.PdsEventType.START != pdsEventType) {
                jSONObject4.putOpt("playTimes", jSONObject);
            }
            JSONObject jSONObject5 = new JSONObject();
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.putOpt("trackId", Integer.valueOf(this.f1175.getTrackId()));
            jSONObject6.putOpt("rank", Integer.valueOf(this.f1175.mo9589()));
            jSONObject6.putOpt("row", Integer.valueOf(this.f1175.getListPos()));
            if (this.f1192 != null) {
                jSONObject6.putOpt("uiDownloadContext", this.f1192.m5856());
            }
            jSONObject5.putOpt("uiplaycontext", jSONObject6.toString());
            jSONObject4.putOpt("sessionParams", jSONObject5);
            if (!this.f1189) {
                jSONObject2.put("params", jSONObject4);
            } else {
                jSONObject2.put("method", jSONObject3.optString("rel"));
                jSONObject4.put("oxid", this.f1182);
                jSONObject4.put("dxid", this.f1193);
                jSONObject4.put("movieId", this.f1185);
                jSONObject4.put("appid", this.f1177);
                jSONObject4.put("sessionid", this.f1188);
                jSONObject4.put("trackid", this.f1175.getTrackId());
                jSONObject4.put("sessionStartEpoch", this.f1187);
                jSONObject4.put("sessionEndEpoch", currentTimeMillis);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject4);
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.putOpt("stopEvents", jSONArray);
                jSONObject2.put("params", jSONObject7);
                jSONObject2.put("playbackExperience", "default");
            }
        } catch (Exception e) {
            C1283.m16855(f1174, "error building basePdsEvent, %s", pdsEventType);
        }
        return jSONObject2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m605() {
        this.f1181 = System.currentTimeMillis() + 60000;
    }
}

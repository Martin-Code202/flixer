package com.netflix.mediaclient.service.logging.pdslogging.streaming;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.logging.pdslogging.streaming.IPdsPlayTimes;
import com.netflix.mediaclient.service.player.bladerunnerclient.IBladeRunnerClient;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.util.ConnectivityUtils;
import o.AbstractC0542;
import o.AbstractC1617ck;
import o.AbstractC1628ct;
import o.AbstractC2055pd;
import o.BA;
import o.C1283;
import o.C1349Bv;
import o.C1625cq;
import o.C1629cu;
import o.C2048ox;
import o.M;
import o.jI;
import o.oX;
import org.json.JSONException;
import org.json.JSONObject;
public class PdsStreamingPlaySession implements AbstractC1617ck {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static final String f1207 = PdsStreamingPlaySession.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f1208;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean f1209;

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f1210;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private PlayState f1211;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f1212;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final Runnable f1213 = new Runnable() { // from class: com.netflix.mediaclient.service.logging.pdslogging.streaming.PdsStreamingPlaySession.3
        @Override // java.lang.Runnable
        public void run() {
            if (PdsStreamingPlaySession.this.f1211 == PlayState.STOPPED || PdsStreamingPlaySession.this.f1211 == PlayState.STARTING) {
                C1283.m16854(PdsStreamingPlaySession.f1207, "ignore posting keepAlive - stop already sent");
                return;
            }
            PdsStreamingPlaySession.this.m620();
            PdsStreamingPlaySession.this.m625((int) SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS);
        }
    };

    /* renamed from: ˈ  reason: contains not printable characters */
    private AbstractC1628ct f1214;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Context f1215;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C1625cq f1216;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f1217;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f1218;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f1219 = false;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private M f1220;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Handler f1221;

    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject f1222;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C1629cu f1223;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private long f1224;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private AbstractC2055pd f1225;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f1226;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f1227;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f1228;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private long f1229 = -1;

    /* access modifiers changed from: package-private */
    public enum PlayState {
        STARTING,
        PLAYING,
        PAUSED,
        STOPPED
    }

    public PdsStreamingPlaySession(Context context, String str, long j, JSONObject jSONObject, String str2, String str3, M m, Handler handler, oX oXVar, AbstractC1628ct ctVar, boolean z, AbstractC2055pd pdVar) {
        this.f1215 = context;
        this.f1217 = Long.parseLong(str);
        this.f1220 = m;
        this.f1208 = j;
        this.f1212 = str2;
        this.f1226 = str3;
        this.f1222 = m619(jSONObject);
        this.f1221 = handler;
        this.f1228 = oXVar.getTrackId();
        this.f1214 = ctVar;
        this.f1211 = PlayState.STARTING;
        this.f1216 = new C1625cq();
        this.f1227 = z;
        this.f1225 = pdVar;
        C1283.m16854(f1207, "PdsStreamingPlaySession created");
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo645(jI jIVar) {
        if (this.f1223 == null) {
            this.f1223 = new C1629cu(jIVar);
            this.f1216.m5948(this.f1223.m5973());
            C1283.m16854(f1207, "got manifest info");
        }
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo637(long j) {
        if (this.f1211 == PlayState.STARTING) {
            this.f1224 = System.currentTimeMillis();
            this.f1211 = PlayState.PLAYING;
            m621(IBladeRunnerClient.PdsEventType.START, this.f1208);
            m628();
        } else if (this.f1211 == PlayState.PAUSED) {
            this.f1218 = true;
        }
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo640(long j, AbstractC0542 r12) {
        C1283.m16851(f1207, "streamPresentEvent: %s", r12);
        if (this.f1223 == null) {
            C1283.m16844(f1207, "drop streamPresentEvent because manifest is null, xid: %d %s", Long.valueOf(j), r12);
            return;
        }
        IPdsPlayTimes.StreamType r5 = m623(r12);
        String r6 = m627(r12);
        C1283.m16851(f1207, "streamChanged: type: %s, %s, mediaId: %s", r5, r12, r6);
        boolean r7 = m630(r5, r6);
        String r8 = this.f1216.m5942();
        this.f1216.m5947(r5, m631(r12), r6);
        if (r7 && this.f1223.m5975(this.f1216.m5942())) {
            C1283.m16851(f1207, "sending mediaId for %s (%s)", this.f1216.m5942(), r8);
            m621(IBladeRunnerClient.PdsEventType.SPLICE, this.f1214.mo5965());
            m634();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m621(IBladeRunnerClient.PdsEventType pdsEventType, long j) {
        m649(m618(pdsEventType, j, this.f1225));
        if (ConnectivityUtils.m2964(this.f1215) && (this.f1225 instanceof C2048ox)) {
            this.f1220.mo5180();
        }
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo641() {
        this.f1209 = true;
        C1283.m16851(f1207, "mIsBackgrounded : %b", Boolean.valueOf(this.f1209));
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo647(long j) {
        if (this.f1211 != PlayState.PLAYING) {
            C1283.m16851(f1207, "ignoring pause in wrong state : %s", this.f1211);
            return;
        }
        this.f1211 = PlayState.PAUSED;
        if (this.f1224 != this.f1229) {
            long currentTimeMillis = System.currentTimeMillis() - this.f1224;
            this.f1224 = this.f1229;
            C1283.m16851(f1207, "incrementing bookmarkInMs: %d by %d, new: %d", Long.valueOf(j), Long.valueOf(currentTimeMillis), Long.valueOf(j + currentTimeMillis));
            j += currentTimeMillis;
        }
        m650(j);
        m621(IBladeRunnerClient.PdsEventType.PAUSE, j);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m636(long j) {
        this.f1209 = false;
        this.f1211 = PlayState.PLAYING;
        m621(IBladeRunnerClient.PdsEventType.RESUME, j);
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo638(long j) {
        if (this.f1211 == PlayState.STARTING || this.f1211 == PlayState.STOPPED) {
            C1283.m16854(f1207, "ignoring stop, already sent");
            return;
        }
        this.f1209 = false;
        this.f1211 = PlayState.STOPPED;
        m650(j);
        m621(IBladeRunnerClient.PdsEventType.STOP, j);
        m624();
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo639(long j, String str, String str2) {
        C1283.m16851(f1207, "subtitleChanged xid:%d, downloadId: %s, mediaId: %s", Long.valueOf(j), str, str2);
        if (C1349Bv.m4113(str2)) {
            m643(false);
        } else if (this.f1223 != null) {
            boolean r5 = m630(IPdsPlayTimes.StreamType.TIMED_TEXT, str2);
            String r6 = this.f1216.m5942();
            this.f1216.m5947(IPdsPlayTimes.StreamType.TIMED_TEXT, str, str2);
            if (r5 && this.f1223.m5975(this.f1216.m5942())) {
                C1283.m16851(f1207, "sending mediaId for %s (%s)", this.f1216.m5942(), r6);
                m621(IBladeRunnerClient.PdsEventType.SPLICE, this.f1214.mo5965());
            }
        }
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo648(long j, boolean z) {
        m643(z);
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo644(long j) {
        if (this.f1211 != PlayState.STOPPED && this.f1211 != PlayState.STARTING) {
            m621(IBladeRunnerClient.PdsEventType.STOP, j);
            m624();
            this.f1211 = PlayState.STOPPED;
        }
    }

    @Override // o.AbstractC1617ck
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo642(long j) {
        m635(j);
        C1283.m16851(f1207, "updatePts bookmarkInMs: %d", Long.valueOf(j));
        this.f1224 = System.currentTimeMillis();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private JSONObject m618(IBladeRunnerClient.PdsEventType pdsEventType, long j, AbstractC2055pd pdVar) {
        C1283.m16851(f1207, "buildPdsEvent %s, bookmarkInMs(%d)", pdsEventType, Long.valueOf(j));
        switch (pdsEventType) {
            case START:
                this.f1210 = BA.m3835();
                break;
            case SPLICE:
            case PAUSE:
            case RESUME:
            case KEEP_ALIVE:
            case STOP:
                break;
            default:
                C1283.m16851(f1207, "unexpected eventType, %s", pdsEventType);
                break;
        }
        return m632(pdsEventType, j, pdVar);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0116: APUT  
      (r2v1 java.lang.Object[])
      (2 ??[int, float, short, byte, char])
      (wrap: java.lang.Long : 0x0111: INVOKE  (r3v4 java.lang.Long) = (r3v3 long) type: STATIC call: java.lang.Long.valueOf(long):java.lang.Long)
     */
    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject m632(IBladeRunnerClient.PdsEventType pdsEventType, long j, AbstractC2055pd pdVar) {
        JSONObject jSONObject = new JSONObject();
        long r6 = BA.m3835();
        try {
            JSONObject r8 = this.f1223.m5971();
            jSONObject.put(LoggingRequest.VERSION, 2);
            jSONObject.put("url", r8.optString("href"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("event", pdsEventType.m945());
            jSONObject2.putOpt("xid", Long.valueOf(this.f1217));
            jSONObject2.putOpt("clientTime", Long.valueOf(r6));
            jSONObject2.putOpt("position", Long.valueOf(j));
            jSONObject2.putOpt("sessionStartTime", Long.valueOf(this.f1210));
            if (pdsEventType == IBladeRunnerClient.PdsEventType.STOP) {
                jSONObject2.putOpt("sessionEndTime", Long.valueOf(r6));
            }
            jSONObject2.putOpt("trackId", Integer.valueOf(this.f1228));
            jSONObject2.putOpt("sessionId", this.f1226);
            jSONObject2.putOpt("appId", this.f1212);
            if (pdsEventType == IBladeRunnerClient.PdsEventType.START) {
                m622(jSONObject2, m646());
            } else if (C1349Bv.m4107(this.f1216.m5942())) {
                m622(jSONObject2, this.f1216.m5942());
            }
            if (IBladeRunnerClient.PdsEventType.START != pdsEventType) {
                jSONObject2.putOpt("playTimes", this.f1216 != null ? this.f1216.m5944() : new JSONObject());
            }
            if (IBladeRunnerClient.PdsEventType.KEEP_ALIVE == pdsEventType) {
                jSONObject2.putOpt("isBackgrounded", Boolean.valueOf(this.f1209));
            }
            jSONObject2.putOpt("sessionParams", this.f1222);
            jSONObject.put("params", jSONObject2);
            jSONObject.put("playbackExperience", this.f1225.mo9715().m9854());
        } catch (Exception e) {
            C1283.m16855(f1207, "error building basePdsEvent, %s", pdsEventType);
        }
        String str = f1207;
        Object[] objArr = new Object[3];
        objArr[0] = pdsEventType.m945();
        objArr[1] = Long.valueOf(j);
        objArr[2] = Long.valueOf(this.f1216 == null ? 0 : this.f1216.m5949());
        C1283.m16851(str, "event: %s, bookmark: %d, totalDuration:%d ", objArr);
        return jSONObject;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static NetworkRequestType m626(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("params")) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                String optString = jSONObject2.optString("event");
                if (C1349Bv.m4107(optString) && C1349Bv.m4126(optString, IBladeRunnerClient.PdsEventType.KEEP_ALIVE.m945())) {
                    boolean optBoolean = jSONObject2.optBoolean("isBackgrounded", false);
                    C1283.m16851(f1207, "isBackgrounded : %b", Boolean.valueOf(optBoolean));
                    return optBoolean ? NetworkRequestType.PDS_KEEP_ALIVE_BACKGROUND : NetworkRequestType.PDS_KEEP_ALIVE;
                }
            } catch (JSONException e) {
                C1283.m16847(f1207, "exception in getNetworkRequestType ", e);
            }
        }
        return NetworkRequestType.PDS_EVENT;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m622(JSONObject jSONObject, String str) {
        try {
            if (this.f1223.m5975(str)) {
                C1283.m16851(f1207, "insertMediaIdIntoMessage %s", str);
                jSONObject.putOpt("mediaId", str);
            }
        } catch (JSONException e) {
            C1283.m16854(f1207, "error while inserting mediaId");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private JSONObject m619(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("uiplaycontext")) {
            return jSONObject;
        }
        try {
            jSONObject.put("uiplaycontext", jSONObject.getJSONObject("uiplaycontext").toString());
        } catch (JSONException e) {
            C1283.m16847(f1207, "error transformingUiPlayContext", e);
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m620() {
        m621(IBladeRunnerClient.PdsEventType.KEEP_ALIVE, this.f1214.mo5965());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m625(int i) {
        this.f1221.removeCallbacks(this.f1213);
        this.f1221.postDelayed(this.f1213, (long) i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m624() {
        C1283.m16854(f1207, "Stop timer...");
        this.f1221.removeCallbacks(this.f1213);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m628() {
        C1283.m16854(f1207, "Start timer...");
        this.f1221.postDelayed(this.f1213, 60000);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m646() {
        return this.f1223.m5974();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m649(JSONObject jSONObject) {
        if (jSONObject != null) {
            String jSONObject2 = jSONObject.toString();
            if (this.f1227) {
                C1283.m16854(f1207, "dropping pds event. disabled via config");
                return;
            }
            this.f1220.mo5179(jSONObject2);
            if (this.f1219) {
                C1283.m16851(f1207, "streaming pdsEvent: %s", jSONObject2);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m635(long j) {
        if (this.f1216 != null) {
            if (this.f1218) {
                this.f1218 = false;
                m636(j);
            }
            this.f1216.m5943(j);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m650(long j) {
        if (this.f1216 != null) {
            this.f1216.m5946(j);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m643(boolean z) {
        if (this.f1216 != null) {
            this.f1216.m5951(z);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private String m631(AbstractC0542 r2) {
        return r2.mo8417();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m630(IPdsPlayTimes.StreamType streamType, String str) {
        boolean z = false;
        switch (streamType) {
            case AUDIO:
                String r6 = this.f1216.m5950();
                if (C1349Bv.m4107(r6) && !C1349Bv.m4126(str, r6)) {
                    z = true;
                    break;
                } else {
                    z = false;
                    break;
                }
                break;
            case TIMED_TEXT:
                if (C1349Bv.m4126(str, this.f1216.m5945())) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
        }
        C1283.m16851(f1207, "didAudioOrTextChange : %b, %s (%s), %s, %s", Boolean.valueOf(z), streamType, str, this.f1216.m5950(), this.f1216.m5945());
        return z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m627(AbstractC0542 r3) {
        return this.f1223.m5972(r3.mo8417());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private IPdsPlayTimes.StreamType m623(AbstractC0542 r6) {
        C1283.m16851(f1207, "getStreamType event: %s", r6);
        return r6.mo8418();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m634() {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.PLAYER_AUDIO_SUBTITLE_CHANGED");
        intent.addCategory("com.netflix.mediaclient.intent.category.PLAYER");
        LocalBroadcastManager.getInstance(this.f1215).sendBroadcast(intent);
    }
}

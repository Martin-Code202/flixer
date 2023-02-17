package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.service.logging.pdslogging.streaming.IPdsPlayTimes;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.cq  reason: case insensitive filesystem */
public class C1625cq implements IPdsPlayTimes {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f6358 = C1625cq.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f6359;

    /* renamed from: ʼ  reason: contains not printable characters */
    private Map<String, Long> f6360 = new HashMap();

    /* renamed from: ʽ  reason: contains not printable characters */
    private Map<String, Long> f6361 = new HashMap();

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6362;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f6363 = false;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private long f6364 = -1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6365;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6366;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Map<String, Long> f6367 = new HashMap();

    /* renamed from: ͺ  reason: contains not printable characters */
    private final long f6368 = -1;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6369;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Object f6370 = new Object();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6371;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6372;

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5948(String str) {
        this.f6371 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m5950() {
        return this.f6369;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m5945() {
        return this.f6371;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m5942() {
        if (!C1349Bv.m4113(this.f6369) && !C1349Bv.m4113(this.f6372) && !C1349Bv.m4113(this.f6371)) {
            return this.f6369 + "|" + this.f6372 + "|" + this.f6371;
        }
        C1283.m16844(f6358, "currentMediaId null: audio: %s, video: %s, text: %s", this.f6369, this.f6372, this.f6371);
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public JSONObject m5944() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        try {
            jSONObject.put("total", this.f6359);
            if (C1349Bv.m4107(this.f6366)) {
                m5935(jSONArray, this.f6360);
            }
            jSONObject.put(IPdsPlayTimes.StreamType.AUDIO.m616(), jSONArray);
            if (C1349Bv.m4107(this.f6362)) {
                m5935(jSONArray2, this.f6361);
            }
            jSONObject.put(IPdsPlayTimes.StreamType.VIDEO.m616(), jSONArray2);
            if (C1349Bv.m4107(this.f6365)) {
                m5935(jSONArray3, this.f6367);
            }
            jSONObject.put(IPdsPlayTimes.StreamType.TIMED_TEXT.m616(), jSONArray3);
        } catch (JSONException e) {
            C1283.m16847(f6358, "error creating playtime json exception", e);
        }
        return jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5943(long j) {
        C1283.m16851(f6358, "update ticker prevBookMarkMs: %d bookmarkMs: %d, delta:(%d),  mSubtitlePlaying : %b", Long.valueOf(this.f6364), Long.valueOf(j), Long.valueOf(j - this.f6364), Boolean.valueOf(this.f6363));
        if (this.f6364 == -1) {
            this.f6364 = j;
        } else if (j < this.f6364) {
            C1283.m16844(f6358, "un captured seek?. bookmarkMs: %d < prevBookmark %d", Long.valueOf(j), Long.valueOf(this.f6364));
            this.f6364 = j;
        } else {
            m5939(j - this.f6364);
            this.f6364 = j;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5946(long j) {
        C1283.m16851(f6358, "stop ticker mSubtitlePlaying: %b", Boolean.valueOf(this.f6363));
        m5943(j);
        this.f6364 = -1;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5947(IPdsPlayTimes.StreamType streamType, String str, String str2) {
        C1283.m16851(f6358, "stream changed type: %s, downloadId: %s (%s), mSubtitlePlaying:%b", streamType, str, str2, Boolean.valueOf(this.f6363));
        if (IPdsPlayTimes.StreamType.TIMED_TEXT == streamType) {
            this.f6363 = true;
        }
        if (!m5940()) {
            m5937(streamType, str, str2);
            if (!m5940()) {
                C1283.m16851(f6358, "audio/video has not started - ignore streamEvent %s; mCurrentAudioId: %s, mCurrentVideoId: %s", streamType, this.f6366, this.f6362);
                return;
            }
        }
        m5937(streamType, str, str2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5951(boolean z) {
        C1283.m16851(f6358, "subtitleVisibilityChanged : %b", Boolean.valueOf(z));
        this.f6363 = z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5937(IPdsPlayTimes.StreamType streamType, String str, String str2) {
        C1283.m16851(f6358, "updateCurrentIds tye:%s, downloadId:%s (%s), mCurrentAudioId: %s, mCurrentVideoId: %s", streamType, str, str2, this.f6366, this.f6362);
        if (C1349Bv.m4113(str2)) {
            C1283.m16844(f6358, "ignoring null mediaId for streamType:%s", streamType);
            return;
        }
        if (IPdsPlayTimes.StreamType.AUDIO == streamType) {
            this.f6366 = str;
            this.f6369 = str2;
        } else if (IPdsPlayTimes.StreamType.VIDEO == streamType) {
            this.f6362 = str;
            this.f6372 = str2;
        } else if (IPdsPlayTimes.StreamType.TIMED_TEXT == streamType) {
            this.f6365 = str;
            this.f6371 = str2;
        } else {
            C1283.m16855(f6358, "unknown streamType: %s received. did:%s (%s)", streamType, str, str2);
        }
        C1283.m16851(f6358, "updateCurrentIds updated - mCurrentAudioId: %s(%s), mCurrentVideoId: %s(%s), mCurrentTextId: %s(%s)", this.f6366, this.f6369, this.f6362, this.f6372, this.f6365, this.f6371);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m5940() {
        return C1349Bv.m4107(this.f6362) && C1349Bv.m4107(this.f6366);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5939(long j) {
        if (!m5941()) {
            C1283.m16851(f6358, "Ignore playTime update mCurrentAudioId: %s, mCurrentVideoId: %s", this.f6366, this.f6362);
            return;
        }
        synchronized (this.f6370) {
            m5938(Long.valueOf(j));
            m5936(this.f6360, this.f6366, Long.valueOf(j));
            m5936(this.f6361, this.f6362, Long.valueOf(j));
            if (this.f6363 && C1349Bv.m4107(this.f6365)) {
                m5936(this.f6367, this.f6365, Long.valueOf(j));
            }
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean m5941() {
        return C1349Bv.m4107(this.f6366) && C1349Bv.m4107(this.f6362);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5938(Long l) {
        this.f6359 += l.longValue();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5936(Map<String, Long> map, String str, Long l) {
        Long l2 = map.get(str);
        map.put(str, Long.valueOf(l2 == null ? l.longValue() : l2.longValue() + l.longValue()));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private JSONArray m5935(JSONArray jSONArray, Map<String, Long> map) {
        try {
            for (String str : map.keySet()) {
                if (C1349Bv.m4107(str)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("downloadableId", str);
                    jSONObject.putOpt(SessionEndedEvent.DURATION, map.get(str));
                    jSONArray.put(jSONObject);
                }
            }
        } catch (JSONException e) {
            C1283.m16847(f6358, "Error adding stream playTimes", e);
        }
        return jSONArray;
    }

    public String toString() {
        return "PdsPlayTimes{mCurrentAudioId='" + this.f6366 + "', mCurrentVideoId='" + this.f6362 + "', mCurrentTextId='" + this.f6365 + "', mTotalPlayTime=" + this.f6359 + ", audioPlayTimesMs=" + this.f6360 + ", videoPlayTimesMs=" + this.f6361 + ", textPlayTimesMs=" + this.f6367 + '}';
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m5949() {
        return this.f6359;
    }
}

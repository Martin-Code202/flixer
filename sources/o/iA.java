package o;

import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class iA {

    /* renamed from: ʻ  reason: contains not printable characters */
    String f7493;

    /* renamed from: ˊ  reason: contains not printable characters */
    String f7494;

    /* renamed from: ˋ  reason: contains not printable characters */
    Map<String, Integer> f7495 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    Map<String, Integer> f7496 = new HashMap();

    /* renamed from: ˏ  reason: contains not printable characters */
    String f7497;

    /* renamed from: ॱ  reason: contains not printable characters */
    Map<String, Integer> f7498 = new HashMap();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f7499 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m7408(String str, String str2, String str3) {
        this.f7497 = str;
        this.f7494 = str2;
        this.f7493 = str3;
        if (C1349Bv.m4107(str) && !this.f7498.containsKey(str)) {
            this.f7498.put(str, 0);
        }
        if (C1349Bv.m4107(str2) && !this.f7495.containsKey(str2)) {
            this.f7495.put(str2, 0);
        }
        if (C1349Bv.m4107(str3) && !this.f7496.containsKey(this.f7493)) {
            this.f7496.put(this.f7493, 0);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7407(int i) {
        this.f7499 += (long) i;
        if (C1349Bv.m4107(this.f7497) && this.f7498.containsKey(this.f7497)) {
            this.f7498.put(this.f7497, Integer.valueOf(this.f7498.get(this.f7497).intValue() + i));
        }
        if (C1349Bv.m4107(this.f7494) && this.f7495.containsKey(this.f7494)) {
            this.f7495.put(this.f7494, Integer.valueOf(this.f7495.get(this.f7494).intValue() + i));
        }
        if (C1349Bv.m4107(this.f7493) && this.f7496.containsKey(this.f7493)) {
            this.f7496.put(this.f7493, Integer.valueOf(this.f7496.get(this.f7493).intValue() + i));
        }
    }

    public String toString() {
        return "PlayTimeTracker{mSubtitlePlayTime=" + this.f7496 + ", mAudioPlayTime=" + this.f7495 + ", mVideoPlayTime=" + this.f7498 + '}';
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public JSONObject m7406() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("total", this.f7499);
            jSONObject.put("video", m7403(this.f7498));
            jSONObject.put("audio", m7403(this.f7495));
            if (this.f7496.size() > 0) {
                jSONObject.put("timedtext", m7403(this.f7496));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static JSONObject m7404() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put("total", 0);
            jSONObject.put("video", jSONArray);
            jSONObject.put("audio", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m7405() {
        return this.f7499;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private JSONArray m7403(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("downloadableId", str);
            jSONObject.put(SessionEndedEvent.DURATION, map.get(str));
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}

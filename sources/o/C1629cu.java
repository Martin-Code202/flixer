package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.cu  reason: case insensitive filesystem */
public class C1629cu {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String f6380 = C1629cu.class.getSimpleName();

    /* renamed from: ˋ  reason: contains not printable characters */
    private HashSet<String> f6381 = new HashSet<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6382;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Map<String, String> f6383 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject f6384;

    public C1629cu(jI jIVar) {
        JSONObject r1 = jIVar.mo7908();
        m5968(r1);
        m5970(r1);
        m5966(r1);
        this.f6384 = m5969(jIVar);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5970(JSONObject jSONObject) {
        String str = null;
        JSONArray optJSONArray = jSONObject.optJSONArray("defaultTrackOrderList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2.has("preferenceOrder") && jSONObject2.has("mediaId") && jSONObject2.getInt("preferenceOrder") < Integer.MAX_VALUE) {
                        str = jSONObject2.getString("mediaId");
                    }
                } catch (JSONException e) {
                    C1283.m16854(f6380, "defaultTrackOrderlist parsing exception");
                }
            }
            this.f6382 = str;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public JSONObject m5971() {
        return this.f6384;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m5974() {
        return this.f6382;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m5973() {
        String[] split = this.f6382.split("\\|");
        for (String str : split) {
            if (str.contains("T:")) {
                return str;
            }
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5966(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("media");
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.getJSONObject(i).optString("id");
                if (C1349Bv.m4107(optString)) {
                    this.f6381.add(optString);
                }
            }
        } catch (JSONException e) {
            C1283.m16847(f6380, "unable to get tracks", e);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5968(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("video_tracks");
            JSONArray optJSONArray = jSONObject.optJSONArray("audio_tracks");
            m5967(jSONArray);
            m5967(optJSONArray);
        } catch (JSONException e) {
            C1283.m16847(f6380, "unable to get tracks", e);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5967(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("new_track_id");
                    JSONArray jSONArray2 = jSONObject.getJSONArray("streams");
                    int length = jSONArray2.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f6383.put(((JSONObject) jSONArray2.get(i2)).getString("downloadable_id"), optString);
                    }
                } catch (JSONException e) {
                    C1283.m16847(f6380, "error add tracks to downloadIdList", e);
                    return;
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m5972(String str) {
        return this.f6383.get(str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject m5969(jI jIVar) {
        JSONObject r4 = jIVar.mo7915();
        if (r4 == null) {
            return null;
        }
        JSONObject optJSONObject = r4.optJSONObject(LoggingRequest.EVENTS);
        C1283.m16845(f6380, "mEventsLink: " + optJSONObject);
        return optJSONObject;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m5975(String str) {
        return this.f6381.isEmpty() || this.f6381.contains(str);
    }
}

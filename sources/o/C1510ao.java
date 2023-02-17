package o;

import android.os.Build;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ao  reason: case insensitive filesystem */
public final class C1510ao {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f6044;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6045;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6046;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6047;

    public C1510ao(String str, boolean z, String str2, String str3) {
        this.f6046 = str;
        this.f6044 = z;
        this.f6045 = str2;
        this.f6047 = str3;
        if (str2 == null) {
            throw new IllegalArgumentException("Event type can not be null!");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject m5628() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LoggingRequest.APP_NAME, "android");
        jSONObject.put("time", "" + System.currentTimeMillis());
        if (this.f6047 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(LoggingRequest.DEVICE, jSONObject2);
            jSONObject2.put("deviceModelHeader", this.f6047);
        }
        JSONArray jSONArray = new JSONArray();
        jSONObject.put(LoggingRequest.EVENTS, jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        jSONArray.put(jSONObject3);
        jSONObject3.put("name", "advdevtag");
        JSONObject jSONObject4 = new JSONObject();
        jSONObject3.put(Event.DATA, jSONObject4);
        jSONObject4.put("advdevtag_type", "android");
        if (this.f6046 != null) {
            jSONObject4.put("advdevtag_id", this.f6046);
        }
        jSONObject4.put("ad_tracking_preference", this.f6044 ? "opt-in" : "opt-out");
        jSONObject4.put("event_type", this.f6045);
        jSONObject4.put("os_version", Build.VERSION.RELEASE);
        String property = System.getProperty("http.agent");
        if (C1349Bv.m4107(property)) {
            jSONObject4.put("user_agent", property);
        }
        return jSONObject;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m5629() {
        try {
            return m5628().toString();
        } catch (JSONException e) {
            return "{}";
        }
    }
}

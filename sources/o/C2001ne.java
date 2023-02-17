package o;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ne  reason: case insensitive filesystem */
public class C2001ne {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static String f9123 = "oldAppVersion";

    /* renamed from: ʽ  reason: contains not printable characters */
    private static String f9124 = "userId";

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private static String f9125 = "optInDisplayed";

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static String f9126 = "soundEnabled";

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static String f9127 = "ts";

    /* renamed from: ͺ  reason: contains not printable characters */
    private static String f9128 = "optIn";

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static String f9129 = "currentUserId";

    /* renamed from: ʼ  reason: contains not printable characters */
    public int f9130 = 0;

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean f9131;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f9132;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f9133;

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean f9134;

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean f9135;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int f9136 = Integer.MIN_VALUE;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public long f9137;

    /* renamed from: ˎ  reason: contains not printable characters */
    private JSONObject m9284() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f9124, this.f9133);
        jSONObject.put(f9123, this.f9136);
        jSONObject.put(f9128, this.f9134);
        jSONObject.put(f9126, this.f9130);
        jSONObject.put(f9125, this.f9135);
        if (this.f9137 <= 0) {
            this.f9137 = System.currentTimeMillis();
        }
        jSONObject.put(f9127, this.f9137);
        jSONObject.put(f9129, this.f9132);
        return jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Map<String, C2001ne> m9283(Context context) {
        C1283.m16854("nf_push", "load Notification settings start...");
        try {
            String r3 = C1339Bl.m4045(context, "notification_settings", (String) null);
            if (r3 == null) {
                return new HashMap();
            }
            JSONArray jSONArray = new JSONArray(r3);
            HashMap hashMap = new HashMap(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                C2001ne r6 = m9286(jSONArray.getJSONObject(i));
                hashMap.put(r6.f9133, r6);
            }
            C1283.m16854("nf_push", "load Notification settings end.");
            return hashMap;
        } catch (Throwable th) {
            C1283.m16847("nf_push", "Failed to load settings", th);
            return new HashMap();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static C2001ne m9286(JSONObject jSONObject) {
        C2001ne neVar = new C2001ne();
        neVar.f9133 = jSONObject.optString(f9124);
        neVar.f9134 = jSONObject.optBoolean(f9128);
        neVar.f9130 = jSONObject.optInt(f9126);
        neVar.f9136 = jSONObject.optInt(f9123);
        neVar.f9137 = AK.m3388(jSONObject, f9127, 0);
        if (jSONObject.has(f9125)) {
            neVar.f9135 = jSONObject.getBoolean(f9125);
        } else {
            neVar.f9135 = true;
        }
        neVar.f9132 = jSONObject.getString(f9129);
        return neVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9285(Context context, Map<String, C2001ne> map) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (C2001ne neVar : map.values()) {
                jSONArray.put(neVar.m9284());
            }
            C1339Bl.m4039(context, "notification_settings", jSONArray.toString());
        } catch (Throwable th) {
            C1283.m16847("nf_push", "Failed to save settings", th);
        }
    }

    public int hashCode() {
        return (this.f9133 == null ? 0 : this.f9133.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C2001ne)) {
            return false;
        }
        C2001ne neVar = (C2001ne) obj;
        if (this.f9133 == null) {
            if (neVar.f9133 != null) {
                return false;
            }
            return true;
        } else if (!this.f9133.equals(neVar.f9133)) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        return "NotificationUserSettings [userId=" + this.f9133 + ", current=" + this.f9131 + ", optedIn=" + this.f9134 + ", optInDisplayed=" + this.f9135 + ", oldAppVersion=" + this.f9136 + ", soundEnabled=" + this.f9130 + ", timestamp=" + this.f9137 + ", currentUserId=" + this.f9132 + "]";
    }
}

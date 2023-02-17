package o;

import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ᖮ  reason: contains not printable characters */
public class C0914 {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static PointF m15713(JSONObject jSONObject, float f) {
        return new PointF(m15715(jSONObject.opt("x")) * f, m15715(jSONObject.opt("y")) * f);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static PointF m15714(JSONArray jSONArray, float f) {
        if (jSONArray.length() >= 2) {
            return new PointF(((float) jSONArray.optDouble(0, 1.0d)) * f, ((float) jSONArray.optDouble(1, 1.0d)) * f);
        }
        throw new IllegalArgumentException("Unable to parse point for " + jSONArray);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static float m15715(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (obj instanceof Integer) {
            return (float) ((Integer) obj).intValue();
        }
        if (obj instanceof Double) {
            return (float) ((Double) obj).doubleValue();
        }
        if (obj instanceof JSONArray) {
            return (float) ((JSONArray) obj).optDouble(0);
        }
        return 0.0f;
    }
}

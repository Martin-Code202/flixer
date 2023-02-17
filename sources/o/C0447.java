package o;

import android.graphics.PointF;
import o.AbstractC0923;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ˮ  reason: contains not printable characters */
public class C0447 implements AbstractC0923.Cif<PointF> {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C0447 f13486 = new C0447();

    private C0447() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public PointF mo14319(Object obj, float f) {
        if (obj instanceof JSONArray) {
            return C0914.m15714((JSONArray) obj, f);
        }
        if (obj instanceof JSONObject) {
            return C0914.m15713((JSONObject) obj, f);
        }
        throw new IllegalArgumentException("Unable to parse point from " + obj);
    }
}

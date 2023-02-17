package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import org.json.JSONObject;
/* renamed from: o.jf  reason: case insensitive filesystem */
public class C1905jf {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f8010 = iT.f7647;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static JSONObject m7994(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.optJSONObject("value");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static JSONObject m7998(String str, String str2, JSONObject jSONObject) {
        JSONObject r1 = m7994(jSONObject);
        if (r1 != null) {
            return r1.optJSONObject(str2);
        }
        C1283.m16846(str, "null response ");
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Status m7995(Context context, JSONObject jSONObject, BladerunnerErrorStatus.BrRequestType brRequestType) {
        return m7996(jSONObject) ? m7997(context, jSONObject, brRequestType) : AbstractC0367.f13235;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Status m7997(Context context, JSONObject jSONObject, BladerunnerErrorStatus.BrRequestType brRequestType) {
        return new BladerunnerErrorStatus(context, jSONObject, brRequestType);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m7996(JSONObject jSONObject) {
        C1283.m16851(f8010, "hasErrors: %b", Boolean.valueOf(BladerunnerErrorStatus.m955(jSONObject)));
        return BladerunnerErrorStatus.m955(jSONObject);
    }
}

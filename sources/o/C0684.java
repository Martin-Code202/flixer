package o;

import android.content.Context;
import com.netflix.cl.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ท  reason: contains not printable characters */
public final class C0684 {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m14963(Context context) {
        String r2 = C1339Bl.m4045(context, "stubLaunchLogs", (String) null);
        if (!C1349Bv.m4113(r2)) {
            try {
                JSONArray jSONArray = new JSONArray(r2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    jSONObject.putOpt("info", "AndroidAppWidgetLaunch");
                    Logger.INSTANCE.m131(new C0729(jSONObject));
                }
            } catch (JSONException e) {
                C1283.m16847("partner", "could not send stub launch logs", e);
            }
            C1339Bl.m4041(context, "stubLaunchLogs");
        }
    }
}

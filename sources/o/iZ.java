package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class iZ {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static List<String> f7684;

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public iZ m7624(List<String> list) {
        f7684 = list;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final String m7623() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LoggingRequest.VERSION, 2);
            jSONObject.put("method", "syncDeactivateLinks");
            jSONObject.put("url", "/syncDeactivateLinks");
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deactivateLinks", m7622());
            jSONObject2.put("clientTime", seconds);
            jSONObject.putOpt("params", jSONObject2);
        } catch (Exception e) {
            C1283.m16856("nf_msl_volley_bladerunner", e, "error creating manifest params", new Object[0]);
        }
        return jSONObject.toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private JSONArray m7622() {
        JSONArray jSONArray = new JSONArray();
        if (f7684 == null) {
            return jSONArray;
        }
        try {
            for (String str : f7684) {
                String optString = new JSONObject(str).optString("href");
                if (C1349Bv.m4107(optString)) {
                    jSONArray.put(optString);
                }
            }
        } catch (JSONException e) {
            C1283.m16851("nf_msl_volley_bladerunner", "error creating json array", e);
        }
        return jSONArray;
    }
}

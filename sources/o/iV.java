package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
public class iV {

    /* renamed from: ˋ  reason: contains not printable characters */
    JSONObject f7659;

    /* renamed from: ˎ  reason: contains not printable characters */
    Map<String, String> f7660;

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public iV m7581(JSONObject jSONObject) {
        this.f7659 = jSONObject;
        this.f7660 = new HashMap();
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public iV m7580(String str, String str2) {
        try {
            if (C1349Bv.m4107(str) && C1349Bv.m4107(str2)) {
                this.f7660.put(str, str2);
            }
        } catch (Exception e) {
        }
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public JSONObject mo7577() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("clientTime", TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
            for (Map.Entry<String, String> entry : this.f7660.entrySet()) {
                if (C1349Bv.m4107(entry.getKey()) && C1349Bv.m4107(entry.getValue())) {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                }
            }
        } catch (JSONException e) {
            C1283.m16856("nf_msl_volley_bladerunner", e, "error creating params", new Object[0]);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject m7579(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(LoggingRequest.VERSION, 2);
            if (this.f7659 != null) {
                jSONObject2.put("method", this.f7659.optString("rel"));
                jSONObject2.put("url", this.f7659.optString("href"));
            }
            jSONObject2.putOpt("params", mo7577());
        } catch (JSONException e) {
            C1283.m16856("nf_msl_volley_bladerunner", e, "error creating request object", new Object[0]);
        }
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ */
    public String mo7578() {
        return m7579(mo7577()).toString();
    }
}

package o;

import com.netflix.cl.model.LoggingSchema;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import org.json.JSONObject;
/* renamed from: o.ⅴ  reason: contains not printable characters */
public final class C1062 extends AbstractC1274 implements AbstractC0514 {
    public C1062() {
        m14630("Log");
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put(NetflixActivity.EXTRA_SOURCE, C0441.m14298().name());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("schema", jSONObject2);
        jSONObject2.put("name", LoggingSchema.netflixApp.name());
        jSONObject2.put(LoggingRequest.VERSION, "1.20.0");
        return jSONObject;
    }
}

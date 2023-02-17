package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import org.json.JSONObject;
/* renamed from: o.ᒪ  reason: contains not printable characters */
public final class C0788 extends AbstractC0783 {
    public C0788() {
        m14630("LoggerInitialized");
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put(LoggingRequest.VERSION, "1.20.0");
        return jSONObject;
    }
}

package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import org.json.JSONObject;
/* renamed from: o.ﺬ  reason: contains not printable characters */
public final class C1198 extends AbstractC1201 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f15580;

    public C1198(String str) {
        m14630("NetflixId");
        this.f15580 = str;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, LoggingRequest.NETFLIX_ID, this.f15580);
        return jSONObject;
    }
}

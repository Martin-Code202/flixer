package o;

import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import org.json.JSONObject;
/* renamed from: o.ʃ  reason: contains not printable characters */
public class C0389 extends C1275 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private C0510 f13344;

    public C0389(AbstractC1274 r2, C0510 r3) {
        super(r2);
        m14630("ActionFailed");
        this.f13344 = r3;
    }

    @Override // o.C1275, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14624(jSONObject, ExceptionClEvent.CATEGORY_VALUE, this.f13344);
        return jSONObject;
    }
}

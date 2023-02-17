package o;

import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import org.json.JSONObject;
/* renamed from: o.ᘄ  reason: contains not printable characters */
public final class C0927 extends AbstractC0783 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private C0510 f14812;

    public C0927(C0510 r2) {
        m14630("ExceptionOccurred");
        this.f14812 = r2;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14624(jSONObject, ExceptionClEvent.CATEGORY_VALUE, this.f14812);
        return jSONObject;
    }
}

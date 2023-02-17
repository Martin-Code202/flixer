package o;

import com.netflix.mediaclient.service.logging.client.model.Device;
import org.json.JSONObject;
/* renamed from: o.ᓰ  reason: contains not printable characters */
public final class C0839 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f14669;

    public C0839(String str) {
        m14630("Device");
        this.f14669 = str;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, Device.MODEL, this.f14669);
        return jSONObject;
    }
}

package o;

import com.netflix.mediaclient.service.logging.client.model.Device;
import org.json.JSONObject;
/* renamed from: o.ᕻ  reason: contains not printable characters */
public final class C0899 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f14777;

    public C0899(String str) {
        m14630("Esn");
        this.f14777 = str;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, Device.ESN, this.f14777);
        return jSONObject;
    }
}

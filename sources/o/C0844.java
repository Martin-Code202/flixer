package o;

import org.json.JSONObject;
/* renamed from: o.ᓵ  reason: contains not printable characters */
public final class C0844 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f14681;

    public C0844(String str) {
        m14630("DeviceLocale");
        this.f14681 = str;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "deviceLocale", this.f14681);
        return jSONObject;
    }
}

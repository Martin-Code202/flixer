package o;

import org.json.JSONObject;
/* renamed from: o.ە  reason: contains not printable characters */
public class C0630 extends AbstractC0470 implements AbstractC0514 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f13941;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C0557 f13942;

    public C0630(String str, C0557 r3) {
        m14630("EditProfile");
        this.f13941 = str;
        this.f13942 = r3;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "profileGuid", this.f13941);
        m14624(jSONObject, "desiredSettings", this.f13942);
        return jSONObject;
    }
}

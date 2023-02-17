package o;

import org.json.JSONObject;
/* renamed from: o.Ꮣ  reason: contains not printable characters */
public final class C0726 extends AbstractC0470 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f14270;

    public C0726(String str) {
        m14630("SelectProfile");
        this.f14270 = str;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "profileGuid", this.f14270);
        return jSONObject;
    }
}

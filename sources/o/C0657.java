package o;

import org.json.JSONObject;
/* renamed from: o.ণ  reason: contains not printable characters */
public class C0657 extends AbstractC0470 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f13999;

    public C0657(String str) {
        m14630("DeleteProfile");
        this.f13999 = str;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "profileGuid", this.f13999);
        return jSONObject;
    }
}

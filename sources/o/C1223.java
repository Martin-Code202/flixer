package o;

import org.json.JSONObject;
/* renamed from: o.Ｊ  reason: contains not printable characters */
public final class C1223 extends AbstractC1201 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f15744;

    public C1223(String str) {
        m14630("ProfileGuid ");
        this.f15744 = str;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "profileGuid", this.f15744);
        return jSONObject;
    }
}

package o;

import org.json.JSONObject;
/* renamed from: o.ᒨ  reason: contains not printable characters */
public final class C0786 extends AbstractC0470 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f14444;

    public C0786(String str) {
        m14630("SelectPlan");
        this.f14444 = str;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "planId", this.f14444);
        if (this.f14444 != null) {
            jSONObject.put("planId", this.f14444);
        }
        return jSONObject;
    }
}

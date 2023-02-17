package o;

import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ᘇ  reason: contains not printable characters */
public final class C0930 extends C1275 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private C0609[] f14813;

    C0930(C0789 r2, C0609[] r3) {
        super(r2);
        m14630("ShareEnded");
        this.f14813 = r3;
    }

    @Override // o.C1275, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        if (this.f14813 != null) {
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("shares", jSONArray);
            C0609[] r3 = this.f14813;
            for (C0609 r6 : r3) {
                if (r6 != null) {
                    jSONArray.put(r6.toJSONObject());
                }
            }
        }
        return jSONObject;
    }
}

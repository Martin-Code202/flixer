package o;

import org.json.JSONObject;
/* renamed from: o.ﮆ  reason: contains not printable characters */
public final class C1137 extends AbstractC0675 implements AbstractC0514 {
    public C1137() {
        m14630("OsVersion");
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "osVersion", C0441.m14297());
        return jSONObject;
    }
}

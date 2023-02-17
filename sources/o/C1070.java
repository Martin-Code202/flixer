package o;

import org.json.JSONObject;
/* renamed from: o.〳  reason: contains not printable characters */
public final class C1070 extends AbstractC1100 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Object f15228;

    public C1070(String str) {
        m14630("ChangeValueCommand");
        this.f15228 = str;
    }

    public C1070(boolean z) {
        m14630("ChangeValueCommand");
        this.f15228 = Boolean.valueOf(z);
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("desiredValue", this.f15228);
        return jSONObject;
    }
}

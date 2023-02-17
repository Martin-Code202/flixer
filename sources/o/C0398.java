package o;

import org.json.JSONObject;
/* renamed from: o.ʏ  reason: contains not printable characters */
public final class C0398 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f13348;

    public C0398(String str) {
        m14630("UiLocale");
        this.f13348 = str;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "uiLocale", this.f13348);
        return jSONObject;
    }
}

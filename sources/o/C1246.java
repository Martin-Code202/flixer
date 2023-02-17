package o;

import org.json.JSONObject;
/* renamed from: o.ｭ  reason: contains not printable characters */
public class C1246 extends AbstractC0675 implements AbstractC0514 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f15793;

    public C1246(String str) {
        m14630("UiVersion");
        this.f15793 = str;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "uiVersion", this.f15793);
        return jSONObject;
    }
}

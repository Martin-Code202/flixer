package o;

import org.json.JSONObject;
/* renamed from: o.ເ  reason: contains not printable characters */
public final class C0711 extends AbstractC0401 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f14238;

    public C0711(float f, String str) {
        super(f);
        m14630("DeepLinkInput");
        this.f14238 = str;
    }

    @Override // o.AbstractC0401, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "url", this.f14238);
        return jSONObject;
    }
}

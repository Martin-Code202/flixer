package o;

import org.json.JSONObject;
/* renamed from: o.ﮢ  reason: contains not printable characters */
public final class C1146 extends AbstractC0783 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f15396;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f15397;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f15398;

    public C1146(String str, String str2, String str3) {
        m14630("dial.ServerDiscovered");
        this.f15398 = str;
        this.f15397 = str2;
        this.f15396 = str3;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14626(jSONObject, "uuid", this.f15398);
        m14626(jSONObject, "deviceDescription", this.f15397);
        m14626(jSONObject, "discoveryResponseHeaders", this.f15396);
        return jSONObject;
    }
}

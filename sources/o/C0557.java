package o;

import com.netflix.cl.model.MaturityLevel;
import com.netflix.mediaclient.service.logging.client.model.Event;
import org.json.JSONObject;
/* renamed from: o.כ  reason: contains not printable characters */
public class C0557 implements AbstractC0503 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private MaturityLevel f13796;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f13797;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f13798;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f13799;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f13800;

    public C0557(String str, String str2, boolean z, String str3, MaturityLevel maturityLevel) {
        this.f13799 = str;
        this.f13800 = str2;
        this.f13797 = z;
        this.f13798 = str3;
        this.f13796 = maturityLevel;
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.f13799 != null) {
            jSONObject.put("name", this.f13799);
        }
        if (this.f13800 != null) {
            jSONObject.put("avatarName", this.f13800);
        }
        jSONObject.put(Event.KIDS, this.f13797);
        if (this.f13798 != null) {
            jSONObject.put("language", this.f13798);
        }
        if (this.f13796 != null) {
            jSONObject.put("maturity", this.f13796.name());
        }
        return jSONObject;
    }
}

package o;

import com.netflix.cl.model.AppView;
import org.json.JSONObject;
/* renamed from: o.ᒧ  reason: contains not printable characters */
public final class C0785 extends AbstractC0715 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f14442;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AppView f14443;

    public C0785(boolean z, AppView appView, AbstractC0574 r4) {
        super(r4);
        m14630("Presented");
        this.f14442 = z;
        this.f14443 = appView;
    }

    @Override // o.AbstractC0715, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("contentMissing", this.f14442);
        m14628(jSONObject, "view", this.f14443);
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}

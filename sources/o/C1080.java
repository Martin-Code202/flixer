package o;

import com.netflix.cl.model.AppView;
import org.json.JSONObject;
/* renamed from: o.ィ  reason: contains not printable characters */
public final class C1080 extends AbstractC1251 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private AppView f15255;

    public C1080(AppView appView, AbstractC0574 r3) {
        super(r3);
        m14630("Focus");
        this.f15255 = appView;
    }

    @Override // o.AbstractC1251, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14628(jSONObject, "view", this.f15255);
        return jSONObject;
    }
}

package o;

import com.netflix.cl.model.AppView;
import org.json.JSONObject;
/* renamed from: o.ﻣ  reason: contains not printable characters */
public final class C1212 extends AbstractC1251 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AppView f15737;

    public C1212(AppView appView, AbstractC0574 r3) {
        super(r3);
        m14630("NavigationLevel");
        this.f15737 = appView;
    }

    @Override // o.AbstractC1251, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14628(jSONObject, "view", this.f15737);
        return jSONObject;
    }
}

package o;

import com.netflix.mediaclient.service.logging.client.model.Event;
import org.json.JSONObject;
/* renamed from: o.Ꮮ  reason: contains not printable characters */
public final class C0729 extends AbstractC0783 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private JSONObject f14272;

    public C0729(JSONObject jSONObject) {
        m14630("DebugEvent");
        this.f14272 = jSONObject;
    }

    @Override // o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14629(jSONObject, Event.DATA, this.f14272);
        return jSONObject;
    }
}

package o;

import com.netflix.cl.model.event.session.DebugSession;
import com.netflix.mediaclient.service.logging.client.model.Event;
import org.json.JSONObject;
/* renamed from: o.ﭨ  reason: contains not printable characters */
public final class C1127 extends C1275 {

    /* renamed from: ᐝ  reason: contains not printable characters */
    private JSONObject f15360;

    public C1127(DebugSession debugSession, JSONObject jSONObject) {
        super(debugSession);
        m14630("DebugSessionEnded");
        this.f15360 = jSONObject;
    }

    @Override // o.C1275, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        m14629(jSONObject, Event.DATA, this.f15360);
        return jSONObject;
    }
}

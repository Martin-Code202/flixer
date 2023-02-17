package o;

import org.json.JSONObject;
/* renamed from: o.ᴻ  reason: contains not printable characters */
public final class C0991 extends AbstractC0715 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f15051;

    public C0991(AbstractC0574 r2, long j) {
        super(r2);
        m14630("PushNotificationReceived");
        this.f15051 = j;
    }

    @Override // o.AbstractC0715, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("receivedTime", this.f15051);
        return jSONObject;
    }
}

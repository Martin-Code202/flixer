package o;

import org.json.JSONObject;
/* renamed from: o.ᴰ  reason: contains not printable characters */
public abstract class AbstractC0971 extends AbstractC0715 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f14974;

    public AbstractC0971(AbstractC0574 r2, long j) {
        super(r2);
        m14630("PushNotificationResolved");
        this.f14974 = j;
    }

    @Override // o.AbstractC0715, o.AbstractC0723, o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("resolvedTime", this.f14974);
        return jSONObject;
    }
}

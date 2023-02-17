package o;

import java.util.UUID;
import org.json.JSONObject;
/* renamed from: o.ز  reason: contains not printable characters */
public final class C0582 extends AbstractC0675 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f13847;

    /* renamed from: ॱ  reason: contains not printable characters */
    private UUID f13848;

    public C0582(long j, UUID uuid) {
        m14630("Xid");
        this.f13848 = uuid;
        this.f13847 = j;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        jSONObject.put("xid", this.f13847);
        if (this.f13848 != null) {
            jSONObject.put("sharedUuid", this.f13848.toString());
        }
        return jSONObject;
    }
}

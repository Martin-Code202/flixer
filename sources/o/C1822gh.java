package o;

import org.json.JSONObject;
/* renamed from: o.gh  reason: case insensitive filesystem */
public final class C1822gh extends AbstractC1824gj {

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1820gf f6970;

    public C1822gh(JSONObject jSONObject) {
        super("PLAYER_STATE_CHANGED");
        this.f6970 = new C1820gf(jSONObject);
        this.f6980 = jSONObject;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1820gf m6662() {
        return this.f6970;
    }
}

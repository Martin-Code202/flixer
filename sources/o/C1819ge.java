package o;

import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ge  reason: case insensitive filesystem */
public final class C1819ge extends AbstractC1824gj {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f6956;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f6957 = 0;

    public C1819ge(JSONObject jSONObject) {
        super("startSessionResponse");
        try {
            this.f6957 = jSONObject.getInt("sessionId");
            this.f6956 = true;
        } catch (JSONException e) {
            this.f6956 = false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m6650() {
        return this.f6956;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m6649() {
        return this.f6957;
    }
}

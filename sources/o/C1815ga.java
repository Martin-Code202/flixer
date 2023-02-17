package o;

import org.json.JSONObject;
/* renamed from: o.ga  reason: case insensitive filesystem */
public final class C1815ga extends AbstractC1824gj {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String f6940 = "isPinVerified";

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f6941;

    public C1815ga(JSONObject jSONObject) {
        super("MDX_ACTION_PIN_VERIFICATION_NOT_REQUIRED");
        this.f6941 = jSONObject.optBoolean(f6940);
        this.f6980 = jSONObject;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m6644() {
        return this.f6941;
    }
}

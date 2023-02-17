package o;

import org.json.JSONObject;
/* renamed from: o.fZ  reason: case insensitive filesystem */
public final class C1766fZ extends AbstractC1824gj {

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f6733 = 0;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f6734;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f6735 = false;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f6736;

    public C1766fZ(JSONObject jSONObject) {
        super("HANDSHAKE_ACCEPTED");
        this.f6736 = jSONObject.optInt("contractVersion");
        this.f6734 = jSONObject.getBoolean("accepted");
        if (jSONObject.has("volumeControl")) {
            this.f6735 = jSONObject.optBoolean("volumeControl");
        }
        if (jSONObject.has("volumeStep")) {
            this.f6733 = jSONObject.optInt("volumeStep");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m6360() {
        return this.f6734;
    }
}

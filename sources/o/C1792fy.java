package o;

import com.netflix.mediaclient.service.mdx.protocol.event.Events;
import org.json.JSONObject;
/* renamed from: o.fy  reason: case insensitive filesystem */
public class C1792fy extends AbstractC1787ft {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final Events f6832 = Events.mdx_session_messagingerror;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f6833;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f6834;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f6835;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6836;

    public C1792fy(JSONObject jSONObject) {
        super(f6832.m750(), jSONObject);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1787ft
    /* renamed from: ˏ */
    public void mo6437(JSONObject jSONObject) {
        this.f6836 = m6458(jSONObject, "pairingContext", null);
        this.f6835 = AK.m3386(jSONObject, "transactionId", -1);
        this.f6833 = AK.m3386(jSONObject, "sid", -1);
        this.f6834 = AK.m3386(jSONObject, "errorCode", -1);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m6464() {
        return this.f6835;
    }
}

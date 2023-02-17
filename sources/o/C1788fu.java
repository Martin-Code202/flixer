package o;

import com.netflix.mediaclient.service.mdx.protocol.event.Events;
import org.json.JSONObject;
/* renamed from: o.fu  reason: case insensitive filesystem */
public class C1788fu extends AbstractC1787ft {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Events f6816 = Events.mdx_session_messagedelivered;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6817;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f6818;

    public C1788fu(JSONObject jSONObject) {
        super(f6816.m750(), jSONObject);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1787ft
    /* renamed from: ˏ */
    public void mo6437(JSONObject jSONObject) {
        this.f6817 = m6458(jSONObject, "pairingContext", null);
        this.f6818 = AK.m3386(jSONObject, "transactionId", -1);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m6459() {
        return this.f6818;
    }
}

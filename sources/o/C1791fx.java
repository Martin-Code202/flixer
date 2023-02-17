package o;

import com.netflix.mediaclient.service.mdx.protocol.event.Events;
import org.json.JSONObject;
/* renamed from: o.fx  reason: case insensitive filesystem */
public class C1791fx extends AbstractC1787ft {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Events f6825 = Events.mdx_session_message;

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f6826;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f6827;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6828;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6829;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6830;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private JSONObject f6831;

    public C1791fx(JSONObject jSONObject) {
        super(f6825.m750(), jSONObject);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1787ft
    /* renamed from: ˏ */
    public void mo6437(JSONObject jSONObject) {
        this.f6830 = m6458(jSONObject, "pairingContext", null);
        this.f6826 = AK.m3386(jSONObject, "transactionId", -1);
        this.f6829 = AK.m3376(jSONObject, "type", (String) null);
        this.f6827 = AK.m3386(jSONObject, "sid", -1);
        this.f6831 = AK.m3380(jSONObject, "msgObject", (JSONObject) null);
        this.f6828 = AK.m3376(jSONObject, "msgbody", (String) null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m6463() {
        return this.f6828;
    }
}

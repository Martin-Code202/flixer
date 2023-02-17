package o;

import com.netflix.mediaclient.service.mdx.protocol.event.Events;
import org.json.JSONObject;
/* renamed from: o.fp  reason: case insensitive filesystem */
public class C1783fp extends AbstractC1787ft {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final Events f6794 = Events.mdx_discovery_devicefound;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1785fr f6795;

    public C1783fp(JSONObject jSONObject) {
        super(f6794.m750(), jSONObject);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1787ft
    /* renamed from: ˏ */
    public void mo6437(JSONObject jSONObject) {
        this.f6795 = C1785fr.m6451(jSONObject);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1785fr m6449() {
        return this.f6795;
    }
}

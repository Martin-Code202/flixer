package o;

import com.netflix.mediaclient.service.mdx.protocol.event.Events;
import org.json.JSONObject;
/* renamed from: o.fq  reason: case insensitive filesystem */
public class C1784fq extends AbstractC1787ft {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Events f6796 = Events.mdx_mdxstate;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f6797;

    public C1784fq(JSONObject jSONObject) {
        super(f6796.m750(), jSONObject);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1787ft
    /* renamed from: ˏ */
    public void mo6437(JSONObject jSONObject) {
        this.f6797 = "READY".equalsIgnoreCase(AK.m3376(jSONObject, "status", "NOT_READY"));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m6450() {
        return this.f6797;
    }
}

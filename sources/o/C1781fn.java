package o;

import com.netflix.mediaclient.service.mdx.protocol.event.Events;
import org.json.JSONObject;
/* renamed from: o.fn  reason: case insensitive filesystem */
public class C1781fn extends AbstractC1787ft {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Events f6782 = Events.mdx_init;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6783;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f6784;

    public C1781fn(JSONObject jSONObject) {
        super(f6782.m750(), jSONObject);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1787ft
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6437(JSONObject jSONObject) {
        this.f6784 = AK.m3386(jSONObject, "errorCode", -1);
        this.f6783 = AK.m3376(jSONObject, "errorDesc", (String) null);
    }
}

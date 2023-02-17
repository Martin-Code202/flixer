package o;

import com.netflix.mediaclient.service.mdx.protocol.event.Events;
import org.json.JSONObject;
/* renamed from: o.fw  reason: case insensitive filesystem */
public class C1790fw extends AbstractC1787ft {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Events f6821 = Events.mdx_discovery_remoteDeviceReady;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6822;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f6823;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6824;

    public C1790fw(JSONObject jSONObject) {
        super(f6821.m750(), jSONObject);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1787ft
    /* renamed from: ˏ */
    public void mo6437(JSONObject jSONObject) {
        this.f6822 = m6458(jSONObject, "dialUsn", null);
        this.f6824 = m6458(jSONObject, "uuid", null);
        this.f6823 = AK.m3386(jSONObject, "launchStatus", 0);
        if (C1349Bv.m4113(this.f6824) && null != this.f6822) {
            this.f6824 = this.f6822.substring("uuid:".length());
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m6462() {
        return this.f6823;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m6461() {
        return this.f6824;
    }
}

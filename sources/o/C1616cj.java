package o;

import android.content.Context;
import android.os.Handler;
import com.netflix.mediaclient.service.logging.pdslogging.offline.PdsOfflinePlaySession;
import com.netflix.mediaclient.service.logging.pdslogging.streaming.PdsStreamingPlaySession;
import com.netflix.mediaclient.service.webclient.model.leafs.PdsAndLogblobConfig;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import org.json.JSONObject;
/* renamed from: o.cj  reason: case insensitive filesystem */
public class C1616cj implements AbstractC1615ci {

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1619cm f6261;

    /* renamed from: ˋ  reason: contains not printable characters */
    private PdsAndLogblobConfig f6262;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Handler f6263;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1853hl f6264;

    /* renamed from: ॱ  reason: contains not printable characters */
    private IClientLogging f6265;

    public C1616cj(IClientLogging iClientLogging) {
        this.f6265 = iClientLogging;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5854(Handler handler, AbstractC1853hl hlVar, PdsAndLogblobConfig pdsAndLogblobConfig) {
        this.f6263 = handler;
        this.f6264 = hlVar;
        this.f6262 = pdsAndLogblobConfig;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5853() {
        if (this.f6261 != null) {
            m5851();
            this.f6261.m5883(AbstractApplicationC1258.m16692());
        }
    }

    @Override // o.AbstractC1615ci
    /* renamed from: ˎ */
    public void mo5846(String str, String str2, String str3, C1618cl clVar, JSONObject jSONObject) {
        if (this.f6261 == null) {
            this.f6261 = new C1619cm(AbstractApplicationC1258.m16692(), this.f6264, this.f6265);
            this.f6261.m5885();
            m5852();
        }
        this.f6261.m5884(str, str2, str3, clVar, jSONObject);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5852() {
        this.f6263.post(new Runnable() { // from class: o.cj.5
            @Override // java.lang.Runnable
            public void run() {
                C1616cj.this.f6264.mo7124(C1616cj.this.f6261);
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5851() {
        this.f6263.post(new Runnable() { // from class: o.cj.2
            @Override // java.lang.Runnable
            public void run() {
                C1616cj.this.f6264.mo7135(C1616cj.this.f6261);
            }
        });
    }

    @Override // o.AbstractC1615ci
    /* renamed from: ॱ */
    public AbstractC1613cg mo5848(Context context, String str, String str2, long j, oX oXVar) {
        return new PdsOfflinePlaySession(context, str, str2, j, this.f6265.mo1520(), this.f6265.mo1517(), this.f6265.mo1506(), oXVar, this.f6262.getDisableOfflinePdsEvents());
    }

    @Override // o.AbstractC1615ci
    /* renamed from: ˏ */
    public AbstractC1617ck mo5847(Context context, String str, String str2, long j, Handler handler, JSONObject jSONObject, oX oXVar, AbstractC1628ct ctVar, AbstractC2055pd pdVar) {
        return new PdsStreamingPlaySession(context, str2, j, jSONObject, this.f6265.mo1520(), this.f6265.mo1517(), this.f6265.mo1506(), handler, oXVar, ctVar, this.f6262.getDisableStreamingPdsEvents(), pdVar);
    }
}

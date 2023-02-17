package o;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.user.UserAgent;
import com.netflix.mediaclient.service.voip.BaseVoipEngine;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipCallAttributes;
import com.netflix.mediaclient.service.webclient.model.leafs.VoipCallConfigData;
import com.netflix.mediaclient.servicemgr.IVoip;
/* renamed from: o.oe  reason: case insensitive filesystem */
public class C2029oe extends AbstractC1052 implements AbstractC1156 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final PhoneStateListener f9318 = new PhoneStateListener() { // from class: o.oe.2
        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            switch (i) {
                case 0:
                    C1283.m16862("nf_voip_agent", "onCallStateChanged: CALL_STATE_IDLE");
                    return;
                case 1:
                    C1283.m16862("nf_voip_agent", "onCallStateChanged: CALL_STATE_RINGING");
                    return;
                case 2:
                    if (C2029oe.this.f9320 != null && C2029oe.this.f9320.mo1437()) {
                        C1283.m16854("nf_voip_agent", "Incoming PSTN call answered, disconnecting VoIP");
                        C2029oe.this.f9320.mo1538();
                        return;
                    }
                    return;
                default:
                    C1283.m16862("nf_voip_agent", "UNKNOWN_STATE: " + i);
                    return;
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1221 f9319;

    /* renamed from: ˋ  reason: contains not printable characters */
    private BaseVoipEngine f9320 = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C1116 f9321;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final UserAgent f9322;

    /* renamed from: ॱ  reason: contains not printable characters */
    private VoipCallAttributes.SDKTypes f9323 = null;

    public C2029oe(C1260 r4, UserAgent userAgent) {
        this.f9319 = r4;
        this.f9322 = userAgent;
        this.f9321 = new C1116(m16093(), this.f9319);
    }

    @Override // o.AbstractC1156
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo9649() {
        return (m16101() == null || m16101().mo16527() == null || !m16101().mo16527().isEnableVoip()) ? false : true;
    }

    @Override // o.AbstractC1156
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo9645() {
        return ((TelephonyManager) m16093().getSystemService("phone")).getCallState() == 0;
    }

    @Override // o.AbstractC1156
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo9646(final AbstractC0477 r5) {
        t_().mo15842(this.f9321.m16250(C1098.m16203(), new AbstractC0477() { // from class: o.oe.1
            @Override // o.AbstractC0477
            /* renamed from: ˏ */
            public void mo3735(VoipCallConfigData voipCallConfigData, Status status) {
                if (r5 != null) {
                    r5.mo3735(voipCallConfigData, status);
                }
            }
        }));
    }

    @Override // o.AbstractC1156
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo9648(String str, AbstractC2033oi oiVar) {
        t_().mo15842(this.f9321.m16248(str, oiVar));
    }

    @Override // o.AbstractC1156
    /* renamed from: ॱ  reason: contains not printable characters */
    public IVoip mo9647(VoipCallConfigData voipCallConfigData) {
        if (!BaseVoipEngine.m1426(voipCallConfigData)) {
            C1283.m16850("nf_voip_agent", "Invalid call config data");
            return null;
        }
        VoipCallAttributes.SDKTypes sdkType = voipCallConfigData.getCallAttributes().getSdkType();
        if (this.f9323 == null || !this.f9323.equals(sdkType) || this.f9320 == null) {
            m9641();
            this.f9320 = new C2028od(m16093(), this, m16096(), this.f9322, this.f9319, voipCallConfigData, v_());
            C1283.m16854("nf_voip_agent", "Instantiating Linphone VoIP engine");
            try {
                ((TelephonyManager) m16093().getSystemService("phone")).listen(this.f9318, 32);
            } catch (Exception e) {
                C1283.m16850("nf_voip_agent", e.getMessage());
            }
            this.f9323 = sdkType;
            this.f9320.m1429();
            return this.f9320;
        }
        this.f9320.m1436(voipCallConfigData);
        return this.f9320;
    }

    @Override // o.AbstractC1156
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo9644() {
        m9641();
        ((TelephonyManager) m16093().getSystemService("phone")).listen(this.f9318, 0);
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m9641() {
        if (this.f9320 != null) {
            C1283.m16854("nf_voip_agent", "--- VOIPAGENT destroyVoipEngineIfExist");
            this.f9320.m1432();
            this.f9320.mo1539();
            this.f9320.m1433();
            this.f9320 = null;
            this.f9323 = null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public IVoip m9643() {
        return this.f9320;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        m16090(AbstractC0367.f13235);
    }

    @Override // o.AbstractC1052
    public synchronized boolean r_() {
        return this.f9320 != null && this.f9320.mo1537();
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        m9641();
    }
}

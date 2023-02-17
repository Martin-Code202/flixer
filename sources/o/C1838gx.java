package o;

import android.content.BroadcastReceiver;
import android.os.SystemClock;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.msl.client.MslErrorException;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.ui.error.CryptoErrorManager;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import com.netflix.msl.MslException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import o.oD;
/* renamed from: o.gx  reason: case insensitive filesystem */
public class C1838gx extends AbstractC1052 implements oD, AbstractC2064pm, AbstractC2047ow {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean f7031 = false;

    /* renamed from: ʻ  reason: contains not printable characters */
    private BroadcastReceiver f7032;

    /* renamed from: ʼ  reason: contains not printable characters */
    private oD.AbstractC0158 f7033;

    /* renamed from: ʽ  reason: contains not printable characters */
    private List<oD.AbstractC2024iF> f7034 = new ArrayList();

    /* renamed from: ˊ  reason: contains not printable characters */
    private If f7035;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final CryptoErrorManager f7036;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f7037;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1796gB f7038;

    /* renamed from: ͺ  reason: contains not printable characters */
    private AbstractC1370Co f7039;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC0661 f7040;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private AtomicBoolean f7041 = new AtomicBoolean(false);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f7042;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f7043;

    public C1838gx(AbstractC0661 r3, CryptoErrorManager cryptoErrorManager) {
        this.f7040 = r3;
        this.f7036 = cryptoErrorManager;
        if (f7031) {
            this.f7035 = new If();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        C1283.m16854("nf_msl_agent", "MSLAgent::doInit start ");
        Status r2 = m6775();
        if (r2.mo301()) {
            C1283.m16854("nf_msl_agent", "MSLAgent::doInit internalInit error done");
            m16090(r2);
        } else if (!m16101().mo16508()) {
            Status r22 = mo6783();
            C1283.m16854("nf_msl_agent", "MSLAgent::doInit with delayed crypto init done");
            m16090(r22);
        } else {
            C1283.m16854("nf_msl_agent", "MSLAgent::doInit done");
            m16090(AbstractC0367.f13235);
        }
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private Status m6775() {
        m6779();
        try {
            this.f7038 = new C1796gB(m16093(), m16101(), m16085(), this.f7040);
            return AbstractC0367.f13235;
        } catch (Throwable th) {
            C1283.m16856("nf_msl_agent", th, "MSLAgent::doInit failed!", new Object[0]);
            return AbstractC0367.f13259;
        }
    }

    @Override // o.AbstractC2047ow
    /* renamed from: ˊ  reason: contains not printable characters */
    public Status mo6783() {
        try {
            m6770();
        } catch (MslErrorException e) {
            C1283.m16867("nf_msl_agent", e, "MSLAgent::doInit appboot failed!");
            Status r4 = m6766(e.m809());
            if (r4 != null) {
                C1283.m16854("nf_msl_agent", "MSLAgent::doInit failed.");
                return r4;
            }
        } catch (Throwable th) {
            C1283.m16856("nf_msl_agent", th, "MSLAgent::doInit failed!", new Object[0]);
            return AbstractC0367.f13259;
        }
        return AbstractC0367.f13235;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Status m6766(DD dd) {
        if (!AX.m3490(dd)) {
            return null;
        }
        C1283.m16854("nf_msl_agent", "Our device is one of black listed, we need to default to legacy crypto and offline is NOT supported!");
        return m6769();
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private Status m6769() {
        if (this.f7036.mo1738() == CryptoErrorManager.CryptoFailback.widevineL3) {
            return AbstractC0367.f13237;
        }
        m16086().mo1515().mo5714("MSL_BLACKLISTED_DEVICE");
        return AbstractC0367.f13239;
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        super.mo1236();
        if (this.f7032 != null) {
            AG.m3329(m16093(), this.f7032);
        }
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private void m6770() {
        if (this.f7038.m6506()) {
            C1283.m16854("nf_msl_agent", "Execute AppBoot synchronously, first app launch...");
            m6771();
            return;
        }
        C1283.m16854("nf_msl_agent", "Execute AppBoot asynchronously, regular app launch...");
        new BackgroundTask().m285(new Runnable() { // from class: o.gx.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1838gx.this.m6771();
                } catch (Throwable th) {
                    C1283.m16856("nf_msl_agent", th, "Failed to execute AppBoot asynchronously", new Object[0]);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˌ  reason: contains not printable characters */
    private void m6771() {
        m6780((String) null);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6780(String str) {
        C0355 r4;
        C0355 r3 = this.f7038.m6493(null, null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C1349Bv.m4113(str)) {
            r4 = this.f7038.m6510(r3);
        } else {
            r4 = this.f7038.m6503(str, r3);
        }
        m6776(r4, SystemClock.elapsedRealtime() - elapsedRealtime);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6776(C0355 r3, long j) {
        if (m6768(r3)) {
            C1283.m16865("nf_msl_agent", "Explicit retry on server response...");
            return;
        }
        m6781(r3);
        m6773(r3, j);
        m6764(r3);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m6768(C0355 r9) {
        if (!r9.m13991("retry")) {
            return false;
        }
        int r6 = r9.m13977("retry").m13989("delay", -1) * 1000;
        AnonymousClass3 r7 = new Runnable() { // from class: o.gx.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1838gx.this.m6771();
                } catch (Throwable th) {
                    C1283.m16856("nf_msl_agent", th, "Failed to execute AppBoot on %d retry", Integer.valueOf(C1838gx.this.f7037));
                }
            }
        };
        if (r6 > 0) {
            C1283.m16851("nf_msl_agent", "Explicit retry in %d seconds", Integer.valueOf(r6));
            s_().postDelayed(r7, (long) r6);
            return true;
        }
        C1283.m16865("nf_msl_agent", "Delay is not found, retry now.");
        s_().post(r7);
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6781(C0355 r7) {
        if (r7.m13991(ExceptionClEvent.CATEGORY_VALUE)) {
            C0355 r5 = r7.m13977(ExceptionClEvent.CATEGORY_VALUE);
            if (!m6777(r5)) {
                C1283.m16855("nf_msl_agent", "handleError:: not handling error %s", r5);
                throw new MslException(CT.f4804, String.format("Unhandled error in appboot response (%s)", r5));
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m6777(C0355 r4) {
        if (!r4.m13991("actionid")) {
            C1283.m16865("nf_msl_agent", "Error found, but not actionid. Not expected!");
            return false;
        }
        switch (r4.m13988("actionid")) {
            case 2:
                return m6778();
            case 7:
                return m6765(r4);
            case 13:
                return m6774(r4);
            default:
                return false;
        }
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private boolean m6778() {
        C1283.m16854("nf_msl_agent", "Handling action ID 2, retry appboot...");
        this.f7037++;
        if (this.f7037 > 5) {
            C1283.m16844("nf_msl_agent", "Reached maximal number (%d) of retries %d for action ID 2", 5, Integer.valueOf(this.f7037));
            return false;
        } else if (!this.f7039.mo4514()) {
            C1283.m16844("nf_msl_agent", "Can not retry anymore using backoff policy on action ID 2, attempt %d", Integer.valueOf(this.f7037));
            return false;
        } else {
            long r5 = this.f7039.mo4515();
            C1283.m16844("nf_msl_agent", "Retry # %d for action ID 2 (max %d) in %d ms", Integer.valueOf(this.f7037), 5, Long.valueOf(r5));
            s_().postDelayed(new Runnable() { // from class: o.gx.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C1838gx.this.m6771();
                    } catch (Throwable th) {
                        C1283.m16856("nf_msl_agent", th, "Failed to execute AppBoot on %d retry", Integer.valueOf(C1838gx.this.f7037));
                    }
                }
            }, r5);
            return true;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m6765(C0355 r7) {
        C1283.m16854("nf_msl_agent", "Handling action ID 7, change appboot url and retry appboot...");
        if (!r7.m13991("appbootendpoint")) {
            C1283.m16850("nf_msl_agent", "New appboot server URL not found. Not expected!");
            return false;
        }
        String r4 = r7.m13980("appbootendpoint");
        if (!C1377Ct.m4558(r4)) {
            C1283.m16844("nf_msl_agent", "New appboot server URL found, but is not proper web URL: %s. Not expected!", r4);
            return false;
        }
        try {
            m6780(r4);
            return false;
        } catch (Throwable th) {
            C1283.m16856("nf_msl_agent", th, "Failed to re-execute AppBoot on actionid 2", new Object[0]);
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m6774(C0355 r5) {
        C1283.m16854("nf_msl_agent", "Handling action ID 13...");
        AbstractC1268 r3 = C1061.m16114().mo14162().mo1763(m16093(), this, m16085(), r5);
        if (r3 == null) {
            return true;
        }
        v_().mo5362(r3);
        C1283.m16846("nf_msl_agent", "Error handler added for action ID 13.");
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6773(C0355 r5, long j) {
        if (r5.m13991("servertime_seconds")) {
            this.f7042 = r5.m13973("servertime_seconds");
            BA.m3836((this.f7042 * 1000) + (j / 2));
            if (this.f7033 != null) {
                C1283.m16854("nf_msl_agent", "Updating server time to nrd.");
                this.f7033.m9393(this.f7042);
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m6764(C0355 r8) {
        if (r8.m13991("ssltruststore")) {
            String r2 = r8.m13977("ssltruststore").m13980(Event.DATA);
            if (C1349Bv.m4107(r2)) {
                synchronized (this.f7034) {
                    this.f7043 = r2;
                    for (oD.AbstractC2024iF iFVar : this.f7034) {
                        iFVar.m9392(this.f7043);
                    }
                }
            }
        }
    }

    @Override // o.oD
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6792(String str, String str2) {
        this.f7038.m6505(str, str2);
    }

    @Override // o.oD
    /* renamed from: ˋ  reason: contains not printable characters */
    public DY mo6786(String str, String str2) {
        C1411Eb r1 = this.f7038.m6492(str);
        if (r1 == null) {
            return null;
        }
        return new DY(r1, str2);
    }

    @Override // o.oD
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6790() {
        if (this.f7038 != null) {
            this.f7038.m6511();
        }
    }

    @Override // o.oD
    /* renamed from: ˋ  reason: contains not printable characters */
    public oD.If mo6787() {
        if (this.f7038 == null) {
            return null;
        }
        return this.f7038.m6514();
    }

    @Override // o.oD
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo6788(String str) {
        return (this.f7038 == null || this.f7038.m6492(str) == null) ? false : true;
    }

    @Override // o.oD
    /* renamed from: ॱ  reason: contains not printable characters */
    public oD.C0159 mo6793() {
        if (m16085() == null || this.f7038 == null) {
            return null;
        }
        return this.f7038.m6497(m16085().mo1340());
    }

    @Override // o.oD
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public AbstractC1400Dq mo6785() {
        if (this.f7038 == null) {
            return null;
        }
        return this.f7038.m6487();
    }

    @Override // o.oD
    /* renamed from: ˉ  reason: contains not printable characters */
    public C1407Dx mo6782() {
        if (this.f7038 == null) {
            return null;
        }
        return this.f7038.m6513();
    }

    @Override // o.AbstractC2004nh
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo6791(NetflixDataRequest netflixDataRequest) {
        return u_().mo6791(netflixDataRequest);
    }

    /* renamed from: o.gx$If */
    static class If {

        /* renamed from: ˏ  reason: contains not printable characters */
        private Map<String, Object> f7047;

        private If() {
            this.f7047 = new HashMap();
        }
    }

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private void m6779() {
    }

    @Override // o.AbstractC2064pm
    /* renamed from: ˏ */
    public AuthorizationCredentials mo6502(String str) {
        return this.f7038.mo6502(str);
    }

    @Override // o.AbstractC2064pm
    /* renamed from: ˏ */
    public void mo6504(String str, AuthorizationCredentials authorizationCredentials) {
        this.f7038.mo6504(str, authorizationCredentials);
    }

    @Override // o.oD
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo6784(oO oOVar) {
        gV gVVar = (gV) oOVar;
        try {
            gVVar.m6623(this.f7038);
            gVVar.m6626(m16101());
            gVVar.m6618(m16085());
            gVVar.m6624((oD) this);
            gVVar.m6625(m16086().mo1515());
            gVVar.m6628(C1260.m16720());
            if (gVVar.m6621() == null) {
                gVVar.m6619(m16085().mo1361());
            }
        } catch (Throwable th) {
            C1283.m16856("nf_msl_agent", th, "Failed to add request! This can happen only when ESN provoder is null, ignore since app is not in working state. Error will be reported to an user by UI,", new Object[0]);
        }
    }

    @Override // o.oD
    /* renamed from: ˍ  reason: contains not printable characters */
    public void mo6789() {
        if (this.f7038 != null) {
            this.f7038.m6507();
        }
    }
}

package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.servicemgr.AdvertiserIdLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import o.C1170;
import o.C1260;
import org.json.JSONObject;
public final class N extends AbstractC1052 implements IClientLogging, C1260.Cif {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final ThreadFactory f5751 = new ThreadFactory() { // from class: o.N.5

        /* renamed from: ˋ  reason: contains not printable characters */
        private final AtomicInteger f5778 = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "LoggingAgent #" + this.f5778.getAndIncrement());
        }
    };

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1507al f5752;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private C1616cj f5753;

    /* renamed from: ʼ  reason: contains not printable characters */
    private Y f5754;

    /* renamed from: ʽ  reason: contains not printable characters */
    private A f5755;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final BroadcastReceiver f5756 = new BroadcastReceiver() { // from class: o.N.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16853("nf_log", "Received intent ", intent);
            if (!N.this.m5190(intent)) {
                N.this.f5755.mo3255(intent);
            }
        }
    };

    /* renamed from: ˈ  reason: contains not printable characters */
    private Runnable f5757 = new Runnable() { // from class: o.N.2
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("nf_log", "Running state check...");
            N.this.f5755.mo3258();
            N.this.f5754.m5355();
            N.this.f5762.mo5222();
            N.this.f5765.mo5279();
            N.this.f5767.mo5303();
            AbstractApplicationC1258.getInstance().mo234().mo14202();
            C1283.m16854("nf_log", "Running state check done.");
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private ScheduledExecutorService f5758;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final UserAgentInterface f5759;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private long f5760 = System.currentTimeMillis();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Context f5761;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private AbstractC2107r f5762;

    /* renamed from: ͺ  reason: contains not printable characters */
    private AtomicInteger f5763 = new AtomicInteger();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1221 f5764;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private AbstractC2138s f5765;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private B f5766;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private AbstractC2362z f5767;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private AbstractC2049oy f5768;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C1170.iF f5769;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AbstractC2041oq f5770;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private AtomicBoolean f5771 = new AtomicBoolean(false);

    public N(Context context, AbstractC1221 r4, UserAgentInterface userAgentInterface) {
        C1283.m16854("nf_log", "ClientLoggingAgent::");
        this.f5761 = context;
        this.f5770 = new C1555bd();
        this.f5768 = new C1525bA();
        this.f5753 = new C1616cj(this);
        this.f5764 = r4;
        this.f5759 = userAgentInterface;
        C1283.m16854("nf_log", "ClientLoggingAgent:: done");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        C1283.m16854("nf_log", "ClientLoggingAgent::init start ");
        this.f5755 = C2333y.m13077(m16093(), this, m5200(), this.f5764);
        this.f5754 = new Y(m16093(), this, m5200());
        this.f5752 = new C1507al(m16093(), this, m16101());
        this.f5762 = T.m5254(this.f5761, this, m5200(), this.f5764);
        this.f5766 = new B(m16093());
        this.f5765 = T.m5255(this.f5761, this, m5200());
        this.f5767 = new V(this, m5200(), m16093());
        C1283.m16854("nf_log", "ClientLoggingAgent::init create executor thread start ");
        this.f5758 = Executors.newSingleThreadScheduledExecutor(f5751);
        C1283.m16854("nf_log", "ClientLoggingAgent::init create executor thread done ");
        this.f5758.scheduleWithFixedDelay(this.f5757, 60000, 60000, TimeUnit.MILLISECONDS);
        this.f5758.schedule(new Runnable() { // from class: o.N.4
            @Override // java.lang.Runnable
            public void run() {
                N.this.m5194();
            }
        }, 30, TimeUnit.SECONDS);
        this.f5755.mo3253(this.f5758);
        this.f5754.m5347(this.f5758);
        this.f5752.m5625();
        this.f5762.mo5224(this.f5758);
        this.f5753.m5854(s_(), m16088(), m16101().mo16537());
        this.f5765.mo5280(this.f5758);
        this.f5767.mo5305(this.f5758);
        m5195();
        C1529bE.f6119.m5739(m16093(), f15192, m16101().mo16521(), m16101().mo16519());
        C1532bG.f6127.m5748(m5197());
        m5188();
        m5193();
        this.f5766.m3833(this.f5758, this.f5762);
        m16090(AbstractC0367.f13235);
        C1283.m16854("nf_log", "ClientLoggingAgent::init done ");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5205(final JSONObject jSONObject, final JSONObject jSONObject2) {
        if (mo1512() == null) {
            C1283.m16865("nf_log", "ClientLoggingAgent not ready to deliver startup logblob.");
            mo1515().mo5714("ClientLoggingAgent not ready to deliver startup logblob.");
            return;
        }
        this.f5758.schedule(new Runnable() { // from class: o.N.3
            @Override // java.lang.Runnable
            public void run() {
                N.this.mo1512().mo5226(new C1543bR(N.this.f5761, N.this.f5764, jSONObject, jSONObject2));
            }
        }, 0, TimeUnit.SECONDS);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m5197() {
        if (m16101() == null || m16101().mo16505() == null) {
            return null;
        }
        ABTestConfigData r2 = m16101().mo16505();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : r2.entrySet()) {
            ABTestConfig aBTestConfig = (ABTestConfig) entry.getValue();
            if (!(aBTestConfig == null || aBTestConfig.getCell() == null || !aBTestConfig.isExplicit())) {
                sb.append(entry.getKey()).append("=").append(aBTestConfig.getCell().getCellId()).append(",");
            }
        }
        return sb.toString();
    }

    /* renamed from: ـ  reason: contains not printable characters */
    private void m5188() {
        String str = "Explicit AB allocations: " + m5197();
        C1283.m16851("nf_log", "leaveTestAllocationsBreadcrumb: %s", str);
        C1276.m16820().mo5728(str);
    }

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private void m5193() {
        AbstractC1221 r1 = m16101();
        if (r1 instanceof C1260) {
            ((C1260) r1).m16743((C1260.Cif) this);
        }
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        C1283.m16854("nf_log", "PNA:: destroy and unregister receiver");
        AG.m3329(m16093(), this.f5756);
        C1170.m16369(this.f5769);
        if (this.f5752 != null) {
            this.f5752.m5626();
        }
        if (this.f5755 != null) {
            this.f5755.mo3259();
        }
        if (this.f5762 != null) {
            this.f5762.mo5223();
        }
        if (this.f5753 != null) {
            this.f5753.m5853();
        }
        super.mo1236();
    }

    @Override // o.AbstractC1052
    public boolean r_() {
        return true;
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˎ */
    public AbstractC2063pl mo1509() {
        return this.f5754;
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˊ */
    public AbstractC2041oq mo1504() {
        return this.f5770;
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ॱ */
    public AbstractC2049oy mo1515() {
        return this.f5768;
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˊᐝ */
    public M mo1506() {
        return this.f5765;
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˉ */
    public P mo1503() {
        return this.f5767;
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    public UserAgentInterface m5200() {
        return m16085();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˌ  reason: contains not printable characters */
    public long m5199() {
        return System.currentTimeMillis() - this.f5760;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m5202(Intent intent) {
        if (intent != null) {
            return false;
        }
        C1283.m16865("nf_log", "Intent is null");
        return false;
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    private void m5195() {
        C1283.m16854("nf_log", "Register receiver");
        IntentFilter intentFilter = new IntentFilter();
        this.f5755.mo3256(intentFilter);
        m5185(intentFilter, new String[]{"com.netflix.mediaclient.intent.action.LOG_PAUSE_EVENTS_DELIVERY", "com.netflix.mediaclient.intent.action.LOG_RESUME_EVENTS_DELIVERY", "com.netflix.mediaclient.intent.action.LOG_RESUME_ALL_EVENTS_DELIVERY"});
        intentFilter.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intentFilter.setPriority(999);
        try {
            LocalBroadcastManager.getInstance(m16093()).registerReceiver(this.f5756, intentFilter);
        } catch (Throwable th) {
            C1283.m16847("nf_log", "Failed to register ", th);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5185(IntentFilter intentFilter, String[] strArr) {
        for (String str : strArr) {
            intentFilter.addAction(str);
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˋᐝ */
    public long mo1508() {
        return (long) (this.f5763.incrementAndGet() * SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋˋ  reason: contains not printable characters */
    public void m5198() {
        this.f5763.set(0);
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    public void m5203() {
        this.f5755.mo3261();
        this.f5754.m5353();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5201(boolean z) {
        this.f5755.mo3257(z);
        this.f5754.m5352(z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private void m5194() {
        synchronized (this.f5771) {
            if (this.f5771.get()) {
                C1283.m16865("nf_log", "LoggingAgent::startDelivery: log delivery was already started!");
                return;
            }
            C1283.m16854("nf_log", "LoggingAgent::startDelivery: starting log delivery!");
            this.f5771.set(true);
            this.f5755.mo3249();
            this.f5754.m5350();
            this.f5762.mo5225();
            this.f5765.mo5278();
            this.f5767.mo5304();
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˏˎ */
    public AdvertiserIdLogging mo1511() {
        return this.f5752;
    }

    @Override // o.AbstractC1052
    /* renamed from: ʼ  reason: contains not printable characters */
    public void mo5196() {
        if (this.f5755 != null) {
            this.f5755.mo3250();
        }
        if (this.f5762 != null) {
            this.f5762.mo5227();
        }
        if (this.f5754 != null) {
            this.f5754.m5348();
        }
        if (this.f5765 != null) {
            this.f5765.mo5281();
        }
        if (this.f5767 != null) {
            this.f5767.mo5306();
        }
    }

    @Override // o.C1260.Cif
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo5204(Status status) {
        if (status.mo298()) {
            C1283.m16846("nf_log", "Refresh configuration for error and breadcrumb logging");
            C1529bE.f6119.m5739(m16093(), f15192, m16101().mo16521(), m16101().mo16519());
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˑ */
    public void mo1513() {
        C1283.m16854("nf_log", "onUserLogout");
        AP.m3401();
        AP.m3398();
        this.f5755.mo3248();
        this.f5754.m5349(false);
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˎˏ */
    public void mo1510() {
        C1283.m16854("nf_log", "Flush events");
        this.f5755.mo3260(true);
        this.f5754.m5349(true);
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ͺॱ */
    public void mo1514() {
        C1283.m16854("nf_log", "Flush events");
        this.f5754.m5349(true);
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˏˏ */
    public oQ mo1512() {
        return this.f5762;
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ॱͺ */
    public String mo1520() {
        return String.valueOf(AP.m3397());
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ॱʻ */
    public String mo1517() {
        return String.valueOf(AP.m3400());
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ॱʼ */
    public AbstractC1615ci mo1518() {
        return this.f5753;
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ˋ */
    public void mo1507(C1359Ce ce) {
        this.f5755.mo3254(ce);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m5190(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("flush", false);
        String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.LOG_PAUSE_EVENTS_DELIVERY".equals(action)) {
            C1283.m16854("nf_log", "Pause CL and PT events!");
            m5203();
            return true;
        } else if ("com.netflix.mediaclient.intent.action.LOG_RESUME_EVENTS_DELIVERY".equals(action)) {
            C1283.m16854("nf_log", "Resume CL and PT events!");
            m5201(booleanExtra);
            return true;
        } else if (!"com.netflix.mediaclient.intent.action.LOG_RESUME_ALL_EVENTS_DELIVERY".equals(action)) {
            return false;
        } else {
            C1283.m16854("nf_log", "Start deliverying all events!");
            m5194();
            return true;
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ॱʽ */
    public String mo1519() {
        return this.f5755.mo3252();
    }

    @Override // com.netflix.mediaclient.servicemgr.IClientLogging
    /* renamed from: ॱ */
    public void mo1516(boolean z, Object obj) {
        this.f5755.mo3251(z, obj);
    }
}

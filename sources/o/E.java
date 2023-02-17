package o;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.mediaclient.service.logging.client.model.SessionEvent;
import com.netflix.mediaclient.service.logging.client.model.SessionKey;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.CustomerServiceLogging;
import com.netflix.mediaclient.servicemgr.ISearchLogging;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import o.AbstractC2285x;
public class E extends AbstractC2285x implements K {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private D f5482;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private Q f5483;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private H f5484;

    /* renamed from: ʾ  reason: contains not printable characters */
    private Z f5485;

    /* renamed from: ʿ  reason: contains not printable characters */
    private G f5486;

    /* renamed from: ˈ  reason: contains not printable characters */
    private X f5487;

    /* renamed from: ˉ  reason: contains not printable characters */
    private final C0084 f5488 = new C0084();

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private L f5489;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final AtomicLong f5490 = new AtomicLong(1);

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final List<AbstractC1561bj> f5491 = Collections.synchronizedList(new ArrayList());

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C1497ab f5492;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C2257w f5493;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private C1499ad f5494;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private C1498ac f5495;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private C1500ae f5496;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private W f5497;

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ʼ */
    public /* bridge */ /* synthetic */ void mo3249() {
        super.mo3249();
    }

    @Override // o.AbstractC2285x, o.AbstractC0479
    /* renamed from: ˊ */
    public /* bridge */ /* synthetic */ boolean mo4161(String str) {
        return super.mo4161(str);
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ void mo3253(ScheduledExecutorService scheduledExecutorService) {
        super.mo3253(scheduledExecutorService);
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ˎ */
    public /* bridge */ /* synthetic */ void mo3257(boolean z) {
        super.mo3257(z);
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ॱ */
    public /* bridge */ /* synthetic */ void mo3259() {
        super.mo3259();
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ᐝ */
    public /* bridge */ /* synthetic */ void mo3261() {
        super.mo3261();
    }

    E(Context context, N n, UserAgentInterface userAgentInterface, AbstractC1221 r7) {
        super(context, n, userAgentInterface, r7);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2285x
    /* renamed from: ˎ */
    public void mo4163() {
        this.f5493 = new C2257w(this, this.f11930);
        BW.m3933(this.f5493);
        this.f5492 = new C1497ab(this, this.f11928.m5200());
        this.f5495 = new C1498ac(this);
        this.f5494 = new C1499ad(this);
        this.f5497 = new W(this, this.f11928.m5200());
        this.f5482 = new D(this);
        this.f5496 = new C1500ae(this);
        this.f5483 = new Q(this);
        this.f5484 = new H(this);
        this.f5487 = new X(this);
        this.f5485 = new Z(this);
        this.f5486 = new G(this);
        this.f5489 = new L(this);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2285x
    /* renamed from: ˏ */
    public void mo4166(Intent intent) {
        if (C1330Bc.m4002(this.f11924)) {
            C1283.m16854("nf_log_cl", "UI is in foreground when service was started, create foreground session");
            this.f5494.m5579(intent);
        } else if (this.f11921.mo14200() > 0) {
            C1283.m16854("nf_log_cl", "UI exist, but app is background");
            this.f5494.m5578();
        } else {
            C1283.m16854("nf_log_cl", "UI does not exist, app is in suspend state");
            this.f5494.m5577();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public long m4784() {
        return this.f5490.getAndAdd(1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public List<SessionKey> m4787() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f5491) {
            for (AbstractC1561bj bjVar : this.f5491) {
                arrayList.add(bjVar.mo5776());
            }
        }
        return arrayList;
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˎ */
    public void mo211(AbstractC0457 r7, Intent intent) {
        C1283.m16854("nf_log_cl", "App in foreground");
        long elapsedRealtime = SystemClock.elapsedRealtime() - r7.mo14207();
        if (elapsedRealtime > 0) {
            this.f5493.m12247(ApplicationPerformanceMetricsLogging.Trigger.resumeFromBackground, elapsedRealtime);
        } else {
            this.f5493.mo1486(ApplicationPerformanceMetricsLogging.Trigger.resumeFromBackground);
        }
        this.f5494.m5581();
        this.f5494.m5587();
        this.f5494.m5585();
        this.f5494.m5586();
        this.f5494.m5579(intent);
        this.f5494.m5582();
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ॱ */
    public void mo213(AbstractC0457 r3) {
        C1283.m16854("nf_log_cl", "App in background");
        this.f5494.m5582();
        this.f5494.m5578();
        this.f5494.m5583();
        this.f5494.m5576();
        this.f5494.m5584();
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˋ */
    public void mo209(AbstractC0457 r7) {
        C1283.m16854("nf_log_cl", "App ui started");
        long elapsedRealtime = SystemClock.elapsedRealtime() - r7.mo14207();
        if (elapsedRealtime > 0) {
            this.f5493.m12247(ApplicationPerformanceMetricsLogging.Trigger.appStart, elapsedRealtime);
        } else {
            this.f5493.mo1486(ApplicationPerformanceMetricsLogging.Trigger.appStart);
        }
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˎ */
    public void mo210(AbstractC0457 r3) {
        C1283.m16854("nf_log_cl", "App ui gone");
        this.f5494.m5582();
        this.f5494.m5583();
        this.f5494.m5577();
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˏ */
    public void mo212(AbstractC0457 r3) {
        C1283.m16854("nf_log_cl", "App ui lost focus");
        this.f5494.m5575();
    }

    @Override // o.AbstractC2285x, o.AbstractC0390
    /* renamed from: ˊ */
    public void mo208(AbstractC0457 r3) {
        C1283.m16854("nf_log_cl", "App ui gains focus");
        this.f5494.m5582();
    }

    @Override // o.K
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo4786(AbstractC1561bj bjVar) {
        if (bjVar != null) {
            this.f5491.add(bjVar);
        }
    }

    @Override // o.K
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo4785(AbstractC1561bj bjVar) {
        if (bjVar != null) {
            this.f5491.remove(bjVar);
        }
    }

    @Override // o.K
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo4783(final Event event) {
        event.addAllActiveSession(m4787());
        event.setSequence(m4784());
        event.setUptime(this.f11928.m5199());
        event.setKids(m12731());
        if (event.getModalView() == null) {
            event.setModalView(this.f5493.m12241());
        }
        this.f11930.execute(new Runnable() { // from class: o.E.4
            @Override // java.lang.Runnable
            public void run() {
                E.this.f5488.m3276(event);
            }
        });
    }

    @Override // o.A
    /* renamed from: ˏॱ */
    public void mo3258() {
        m12736();
        m4782();
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private void m4782() {
        if (this.f11932.get()) {
            C1283.m16854("nf_log_cl", "Local playback is in progress, consider that user just interacted with UI. Exit.");
            this.f11921.mo14203();
            return;
        }
        C1283.m16854("nf_log_cl", "Local playback is NOT in progress, check last user interaction");
        long r4 = this.f11921.mo14207();
        long r6 = m12729();
        if (r4 >= r6 && this.f5493.m12232()) {
            C1283.m16854("nf_log_cl", "It is more than 30 minutes and user session exist. End user session");
            this.f5493.m12242(ApplicationPerformanceMetricsLogging.EndReason.timeout, System.currentTimeMillis() - r4);
        } else if (r4 < r6 && !this.f5493.m12228() && !this.f5493.m12232()) {
            C1283.m16854("nf_log_cl", "It is less than 30 minutes and user session does NOT exist. Start user session");
            this.f5493.mo1486(ApplicationPerformanceMetricsLogging.Trigger.inputEvent);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m4778(List<Event> list, boolean z) {
        LoggingRequest loggingRequest = new LoggingRequest(this.f11924, this.f11927, this.f11923, this.f11923.mo1328().m3973());
        loggingRequest.addAllEvent(list);
        try {
            String jSONObject = loggingRequest.toJSONObject().toString();
            if (z) {
                String r6 = m12733(jSONObject);
                this.f11922.add(r6);
                mo4167(r6, this.f11923.mo1340(), jSONObject, new AbstractC2285x.iF(jSONObject));
                return;
            }
            mo4167(null, this.f11923.mo1340(), jSONObject, new AbstractC2285x.iF(jSONObject));
        } catch (Exception e) {
            C1283.m16847("nf_log_cl", "Failed to create JSON object for logging request", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2285x
    /* renamed from: ॱ */
    public void mo4167(String str, String str2, String str3, AbstractC1562bk bkVar) {
        C1283.m16854("nf_log_cl", "sendLoggingEvents starts...");
        NetflixDataRequest r2 = this.f11926.m5793(str2, str, str3, bkVar);
        if (r2 != null) {
            this.f11928.m16092(r2);
        } else if (bkVar != null) {
            C1283.m16854("nf_log_cl", "CLV1 events can not be delivered for correct profile, drop them and remove them from persistence.");
            bkVar.onEventsDelivered(str);
        }
        C1283.m16854("nf_log_cl", "sendLoggingEvents done.");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m4776(List<Event> list) {
        for (Event event : list) {
            m4777(event);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m4777(Event event) {
        if (!(event instanceof SessionEvent) || !"appSession".equals(((SessionEvent) event).getSessionName())) {
            List<SessionKey> allActiveSessions = event.getAllActiveSessions();
            int i = 0;
            int i2 = 0;
            ArrayList<SessionKey> arrayList = new ArrayList();
            for (SessionKey sessionKey : allActiveSessions) {
                if ("appSession".equals(sessionKey.getName())) {
                    if (sessionKey.getId() == null) {
                        C1283.m16850("nf_log_cl", "Application session id was missing! Remove session key!");
                        arrayList.add(sessionKey);
                    } else {
                        i++;
                    }
                }
                if ("userSession".equals(sessionKey.getName())) {
                    if (sessionKey.getId() == null) {
                        C1283.m16850("nf_log_cl", "User session id is missing!! Remove session key!");
                        arrayList.add(sessionKey);
                    } else {
                        i2++;
                    }
                }
            }
            for (SessionKey sessionKey2 : arrayList) {
                event.removeActiveSession(sessionKey2);
            }
            if (i < 1 || i2 < 1) {
                C1283.m16865("nf_log_cl", "validate session found error");
            } else {
                C1283.m16854("nf_log_cl", "validate session done with no errors");
            }
        } else {
            C1283.m16854("nf_log_cl", "Do not check app session start event, skip");
        }
    }

    @Override // o.AbstractC2285x
    /* renamed from: ˏ */
    public String mo4165() {
        return "iclevents";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.E$ˊ  reason: contains not printable characters */
    public class C0084 extends AC<Event> {
        public C0084() {
            super("nf_icl_queue", 30, 60000, true, true);
        }

        /* access modifiers changed from: protected */
        @Override // o.AC
        /* renamed from: ˏ */
        public void mo3277(List<Event> list, boolean z) {
            E.this.m4776(list);
            E.this.m4778(list, z);
        }
    }

    @Override // o.A
    /* renamed from: ˋ */
    public void mo3254(C1359Ce ce) {
        this.f5493.m12239(ce);
        this.f5492.m5519(ce);
        this.f5483.m5249(ce);
        this.f5484.m5158(ce);
        this.f5487.m5325(ce);
    }

    @Override // o.A
    /* renamed from: ˎ */
    public void mo3255(Intent intent) {
        boolean r2 = AD.m3306(this.f11924);
        if (this.f5493.m12240(intent, r2)) {
            C1283.m16854("nf_log_cl", "Handled by APM logger");
        } else if (this.f5492.m5520(intent, r2)) {
            C1283.m16854("nf_log_cl", "Handled by UI Action logger");
        } else if (this.f5495.m5567(intent, r2)) {
            C1283.m16854("nf_log_cl", "Handled by UI View logger");
        } else if (this.f5497.m5316(intent)) {
            C1283.m16854("nf_log_cl", "Handled by Search logger");
        } else if (this.f5482.m4578(intent)) {
            C1283.m16854("nf_log_cl", "Handled by customer service logging logger");
        } else if (this.f5496.m5602(intent)) {
            C1283.m16854("nf_log_cl", "Handled by signIn logger");
        } else if (this.f5483.m5243(intent)) {
            C1283.m16854("nf_log_cl", "Handled by Offline logger");
        } else if (this.f5484.m5159(intent)) {
            C1283.m16854("nf_log_cl", "Handled by ExceptionLoggingCl logger");
        } else if (this.f5487.m5326(intent)) {
            C1283.m16854("nf_log_cl", "Handled by RatingsLogging logger");
        } else if (this.f5485.m5357(intent)) {
            C1283.m16854("nf_log_cl", "Handled by PushNotification logger");
        } else if (this.f5486.m5051(intent)) {
            C1283.m16854("nf_log_cl", "Handled by Dial logger");
        } else if (this.f5489.m5177(intent)) {
            C1283.m16854("nf_log_cl", "Handled by FTL logger");
        }
        if (intent.getBooleanExtra("FORCE_FLUSH", false)) {
            this.f5488.mo3266(true);
        }
    }

    @Override // o.A
    /* renamed from: ॱ */
    public void mo3260(final boolean z) {
        this.f11930.execute(new Runnable() { // from class: o.E.5
            @Override // java.lang.Runnable
            public void run() {
                E.this.f5488.mo3266(z);
            }
        });
    }

    @Override // o.AbstractC2285x, o.A
    /* renamed from: ʽ */
    public void mo3250() {
        super.mo3250();
        this.f5493.mo1493(this.f11924);
    }

    @Override // o.A
    /* renamed from: ʻॱ */
    public void mo3248() {
        mo3261();
        try {
            this.f5494.m5580();
            this.f5495.m5568();
            this.f5492.m5523();
            this.f5497.m5317();
            this.f5482.m4579();
            this.f5493.m12229();
            this.f5496.m5600();
            this.f5483.m5240();
            this.f5489.m5171();
        } catch (Throwable th) {
            C1276.m16820().mo5729("Failed to report", th);
        }
        mo3257(false);
    }

    @Override // o.A
    /* renamed from: ˎ */
    public void mo3256(IntentFilter intentFilter) {
        m4780(intentFilter, ApplicationPerformanceMetricsLogging.f2379);
        m4780(intentFilter, UserActionLogging.f2746);
        m4780(intentFilter, UIViewLogging.f2673);
        m4780(intentFilter, ISearchLogging.f2589);
        m4780(intentFilter, CustomerServiceLogging.f2419);
        m4780(intentFilter, SignInLogging.f2660);
        m4780(intentFilter, R.f5805);
        m4780(intentFilter, oC.f9222);
        m4780(intentFilter, X.f5855);
        m4780(intentFilter, AbstractC2062pk.f9412);
        m4780(intentFilter, AbstractC2044ot.f9366);
        m4780(intentFilter, I.f5733);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m4780(IntentFilter intentFilter, String[] strArr) {
        for (String str : strArr) {
            intentFilter.addAction(str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2285x
    /* renamed from: ˊ */
    public AA mo4160() {
        return this.f5488;
    }

    @Override // o.A
    /* renamed from: ˊॱ */
    public String mo3252() {
        return this.f5482.m4575();
    }

    @Override // o.A
    /* renamed from: ˊ */
    public void mo3251(boolean z, Object obj) {
        UIError uIError = null;
        if (obj instanceof UIError) {
            uIError = (UIError) obj;
        }
        this.f5493.m12245(z, uIError);
    }

    @Override // o.A
    /* renamed from: ᐝॱ */
    public boolean mo3262() {
        return false;
    }
}

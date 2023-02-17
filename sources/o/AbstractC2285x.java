package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import o.BP;
/* renamed from: o.x  reason: case insensitive filesystem */
abstract class AbstractC2285x implements AbstractC0390, A {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected AbstractC0457 f11921;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected final List<String> f11922 = new ArrayList();

    /* renamed from: ʽ  reason: contains not printable characters */
    protected final UserAgentInterface f11923;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final Context f11924;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected BP f11925;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected C1566bo f11926;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected final AbstractC1221 f11927;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final N f11928;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected final BroadcastReceiver f11929 = new BroadcastReceiver() { // from class: o.x.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_STARTED".equals(action)) {
                AbstractC2285x.this.f11932.set(true);
            } else if ("com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_ENDED".equals(action)) {
                AbstractC2285x.this.f11932.set(false);
            } else if ("com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_PAUSED".equals(action)) {
                AbstractC2285x.this.f11932.set(false);
            } else if ("com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_UNPAUSED".equals(action)) {
                AbstractC2285x.this.f11932.set(true);
            }
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    protected ScheduledExecutorService f11930;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Runnable f11931 = new Runnable() { // from class: o.x.1
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("nf_log_cl", "Check if we have not delivered events from last time our app was runnung...");
            AbstractC2285x.this.f11925.mo3900(new BP.AbstractC1327iF() { // from class: o.x.1.1
                @Override // o.BP.AbstractC1327iF
                /* renamed from: ॱ */
                public void mo3905(BP.If[] ifArr) {
                    if (ifArr == null || ifArr.length <= 0) {
                        C1283.m16854("nf_log_cl", "No saved payloads found.");
                    } else {
                        AbstractC2285x.this.m12730(ifArr, false);
                    }
                }
            });
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected final AtomicBoolean f11932 = new AtomicBoolean(false);

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected J f11933;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public abstract AA mo4160();

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public abstract void mo4163();

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract String mo4165();

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract void mo4166(Intent intent);

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public abstract void mo4167(String str, String str2, String str3, AbstractC1562bk bkVar);

    AbstractC2285x(Context context, N n, UserAgentInterface userAgentInterface, AbstractC1221 r6) {
        this.f11928 = n;
        this.f11923 = userAgentInterface;
        this.f11933 = new J(r6);
        this.f11924 = context;
        this.f11927 = r6;
        this.f11926 = new C1566bo(this.f11927, userAgentInterface);
    }

    @Override // o.A
    /* renamed from: ˋ */
    public void mo3253(ScheduledExecutorService scheduledExecutorService) {
        this.f11930 = scheduledExecutorService;
        this.f11921 = AbstractApplicationC1258.getInstance().mo234();
        mo4163();
        Intent r2 = this.f11921.mo14201();
        C1283.m16854("nf_log_cl", "Add ICL manager as listener on user input...");
        this.f11921.mo14206(this);
        C1283.m16854("nf_log_cl", "Add ICL manager as listener on user input done.");
        m12725();
        m12734();
        mo4166(r2);
    }

    @Override // o.A
    /* renamed from: ॱ */
    public void mo3259() {
        if (this.f11921 != null) {
            this.f11921.mo14208(this);
        }
        m12735();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12725() {
        C1283.m16854("nf_log_cl", "ICLManager::init data repository started ");
        File file = new File(this.f11924.getFilesDir(), mo4165());
        file.mkdirs();
        this.f11925 = new BO(file, mo3262());
        C1283.m16854("nf_log_cl", "ICLManager::init data repository done ");
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m12728() {
        if (mo4160().m3264()) {
            this.f11930.schedule(this.f11931, 15, TimeUnit.SECONDS);
        } else {
            this.f11930.execute(this.f11931);
        }
    }

    @Override // o.A
    /* renamed from: ʽ */
    public void mo3250() {
        if (ConnectivityUtils.m2970(this.f11924)) {
            C1283.m16854("nf_log_cl", "Device is connected, lets see if we need to deliver cached events...");
            BP.If[] r2 = this.f11925.mo3901();
            if (r2 != null || r2.length > 0) {
                C1283.m16854("nf_log_cl", "We found %d cached log entries, network is connected, lets try to deliver them");
                m12730(r2, false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12726(final String str) {
        this.f11925.mo3899(str, new BP.AbstractC0068() { // from class: o.x.3
            @Override // o.BP.AbstractC0068
            /* renamed from: ˎ */
            public void mo3907(String str2, String str3, byte[] bArr, long j) {
                if (bArr == null || bArr.length < 1) {
                    C1283.m16850("nf_log_cl", "We failed to retrieve payload. Trying to delete it");
                    AbstractC2285x.this.m12732(str);
                    return;
                }
                try {
                    String str4 = new String(bArr, "utf-8");
                    AbstractC2285x.this.mo4167(str, str3, str4, new iF(str4));
                } catch (Throwable th) {
                    C1283.m16847("nf_log_cl", "Failed to send events. Try to delete it.", th);
                    AbstractC2285x.this.m12732(str);
                }
            }
        });
    }

    @Override // o.A
    /* renamed from: ᐝ */
    public void mo3261() {
        mo4160().m3265();
    }

    @Override // o.A
    /* renamed from: ˎ */
    public void mo3257(boolean z) {
        mo4160().m3268(z);
    }

    @Override // o.A
    /* renamed from: ʼ */
    public void mo3249() {
        mo4160().m3270();
        m12728();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public String m12733(String str) {
        try {
            return this.f11925.mo3895(String.valueOf(System.currentTimeMillis()), str.getBytes("utf-8"), this.f11923.mo1340());
        } catch (Throwable th) {
            C1283.m16847("nf_log_cl", "Failed to save payload to repository", th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12732(String str) {
        try {
            this.f11922.remove(str);
            this.f11925.mo3898(str);
        } catch (Throwable th) {
            C1283.m16847("nf_log_cl", "Failed to remove payload from repository", th);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12730(BP.If[] ifArr, boolean z) {
        if (ifArr == null || ifArr.length < 1) {
            C1283.m16854("nf_log_cl", "No saved events found");
            return;
        }
        for (BP.If r8 : ifArr) {
            final String r9 = r8.mo3882();
            if (this.f11922.contains(r9)) {
                C1283.m16865("nf_log_cl", "We are already trying to deliver %s deliveryRequestId, skip");
            } else {
                this.f11922.add(r9);
                if (z) {
                    this.f11930.schedule(new Runnable() { // from class: o.x.4
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractC2285x.this.m12726(r9);
                        }
                    }, this.f11928.mo1508(), TimeUnit.MILLISECONDS);
                } else {
                    this.f11930.execute(new Runnable() { // from class: o.x.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AbstractC2285x.this.m12726(r9);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public long m12729() {
        AbstractC1221 r2 = this.f11927;
        if (r2 == null) {
            return 1800000;
        }
        return 1000 * ((long) r2.mo16514());
    }

    @Override // o.AbstractC0479
    /* renamed from: ˊ */
    public boolean mo4161(String str) {
        return this.f11933.m5169(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m12736() {
        if (mo4160().m3269()) {
            C1283.m16854("nf_log_cl", "Events were send recently. We reached timeout, force send");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean m12731() {
        UserAgentInterface userAgentInterface = this.f11923;
        if (userAgentInterface == null) {
            C1283.m16865("nf_log_cl", "getUiMode:: getUserAgent is null! isKids() = false");
            return false;
        } else if (!userAgentInterface.mo1333()) {
            C1283.m16854("nf_log_cl", "getUiMode:: user is NOT logged in. isKids() = false");
            return false;
        } else {
            AbstractC2089qj r3 = userAgentInterface.mo1383();
            if (r3 != null) {
                return r3.isKidsProfile();
            }
            C1283.m16865("nf_log_cl", "getUiMode:: user is logged in, but profile is null. isKids() = false");
            return false;
        }
    }

    @Override // o.AbstractC0390
    /* renamed from: ˏ */
    public void mo212(AbstractC0457 r3) {
        C1283.m16854("nf_log_cl", "App ui lost focus");
    }

    @Override // o.AbstractC0390
    /* renamed from: ˊ */
    public void mo208(AbstractC0457 r3) {
        C1283.m16854("nf_log_cl", "App ui gains focus");
    }

    @Override // o.AbstractC0390
    /* renamed from: ˋ */
    public void mo209(AbstractC0457 r3) {
        C1283.m16854("nf_log_cl", "App ui started");
    }

    @Override // o.AbstractC0390
    /* renamed from: ˎ */
    public void mo211(AbstractC0457 r3, Intent intent) {
        C1283.m16854("nf_log_cl", "App ui foreground");
    }

    @Override // o.AbstractC0390
    /* renamed from: ॱ */
    public void mo213(AbstractC0457 r3) {
        C1283.m16854("nf_log_cl", "App ui background");
    }

    @Override // o.AbstractC0390
    /* renamed from: ˎ */
    public void mo210(AbstractC0457 r3) {
        C1283.m16854("nf_log_cl", "App ui gone");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public void m12734() {
        AG.m3334(this.f11924, this.f11929, "com.netflix.mediaclient.intent.category.PLAYER", "com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_STARTED", "com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_ENDED", "com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_PAUSED", "com.netflix.mediaclient.intent.action.PLAYER_LOCAL_PLAYBACK_UNPAUSED");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m12735() {
        AG.m3329(this.f11924, this.f11929);
    }

    /* renamed from: o.x$iF */
    protected class iF implements AbstractC1562bk {
        public iF(String str) {
        }

        @Override // o.AbstractC1562bk
        public void onEventsDeliveryFailed(final String str) {
            if (!C1349Bv.m4113(str)) {
                AbstractC2285x.this.f11922.remove(str);
                AbstractC2285x.this.f11930.schedule(new Runnable() { // from class: o.x.iF.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC2285x.this.m12726(str);
                    }
                }, AbstractC2285x.this.f11928.mo1508(), TimeUnit.MILLISECONDS);
            }
        }

        @Override // o.AbstractC1562bk
        public void onEventsDelivered(String str) {
            AbstractC2285x.this.f11928.m5198();
            AbstractC2285x.this.m12732(str);
        }
    }
}

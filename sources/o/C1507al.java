package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.servicemgr.AdvertiserIdLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.al  reason: case insensitive filesystem */
public final class C1507al implements AdvertiserIdLogging {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f6027;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final BroadcastReceiver f6028 = new BroadcastReceiver() { // from class: o.al.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16853("nf_adv_id", "Received intent ", intent);
            String action = intent.getAction();
            if ("com.netflix.mediaclient.intent.action.PUSH_ONLOGIN".equals(action)) {
                C1283.m16854("nf_adv_id", "onLogin");
                C1507al.this.m5609();
            } else if ("com.netflix.mediaclient.intent.action.PUSH_ONLOGOUT".equals(action)) {
                C1283.m16854("nf_adv_id", "onLogout");
                C1507al.this.m5607();
            } else if ("com.netflix.mediaclient.intent.action.ONSIGNUP".equals(action)) {
                C1283.m16854("nf_adv_id", "onSignUp");
                C1507al.this.mo1482(AdvertiserIdLogging.EventType.sign_up.name());
            } else {
                C1283.m16851("nf_adv_id", "We do not support action %s", action);
            }
        }
    };

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f6029;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1221 f6030;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6031;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC1506ak f6032;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Context f6033;

    /* renamed from: ॱ  reason: contains not printable characters */
    private IClientLogging f6034;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Boolean f6035;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1511ap f6036;

    public C1507al(Context context, IClientLogging iClientLogging, AbstractC1221 r4) {
        this.f6033 = context;
        this.f6034 = iClientLogging;
        this.f6036 = new C1511ap(r4);
        this.f6030 = r4;
        m5613();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5613() {
        new BackgroundTask().m285(new Runnable() { // from class: o.al.5
            @Override // java.lang.Runnable
            public void run() {
                C1507al.this.f6031 = C1339Bl.m4045(C1507al.this.f6033, "advertisement_id", (String) null);
                C1507al.this.f6029 = C1339Bl.m4044(C1507al.this.f6033, "advertisement_id_ts", 0);
                C1507al.this.f6035 = Boolean.valueOf(C1339Bl.m4051(C1507al.this.f6033, "advertisement_id_opted_in", false));
                C1507al.this.f6032 = C1508am.m5627(C1507al.this.f6033);
                String str = C1507al.this.f6027;
                C1507al.this.f6027 = null;
                if (!AD.m3295(C1507al.this.f6033)) {
                    C1283.m16854("nf_adv_id", "Not first start after installation");
                } else {
                    C1283.m16854("nf_adv_id", "First start after installation");
                    C1507al.this.mo1482(AdvertiserIdLogging.EventType.install.name());
                }
                if (str != null) {
                    C1507al.this.mo1482(str);
                }
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5625() {
        m5623();
    }

    @Override // com.netflix.mediaclient.servicemgr.AdvertiserIdLogging
    /* renamed from: ˊ */
    public synchronized void mo1482(String str) {
        if (this.f6032 == null) {
            C1283.m16854("nf_adv_id", "User is logged in, but ADV ID provider is not readu, postpone sending ID");
            this.f6027 = str;
            return;
        }
        this.f6027 = null;
        C1283.m16854("nf_adv_id", "Ad ID provider is ready and request to send AD ID exist, execute.");
        String r5 = this.f6032.mo5605();
        boolean z = !this.f6032.mo5606();
        C1283.m16851("nf_adv_id", "Ad ID provider exist, if we need to send ID %s, opted in %b", r5, Boolean.valueOf(z));
        if (r5 == null) {
            C1283.m16850("nf_adv_id", "Ad id can not be null!");
        } else if (!str.equals(AdvertiserIdLogging.EventType.check_in.name())) {
            C1283.m16854("nf_adv_id", "Not check in, execute");
            m5618(r5, Boolean.valueOf(z), str);
        } else {
            C1283.m16854("nf_adv_id", "Check in, validate");
            if (this.f6031 == null || !this.f6031.equals(this.f6032.mo5605())) {
                C1283.m16854("nf_adv_id", "Ad ID changed, execute");
                m5618(r5, Boolean.valueOf(z), str);
            } else if (this.f6035 == null || z != this.f6035.booleanValue()) {
                C1283.m16854("nf_adv_id", "opt in status changed, execute");
                m5618(r5, Boolean.valueOf(z), str);
            } else {
                C1283.m16854("nf_adv_id", "Adverising ID is not changed, check when it was last time sent.");
                if (m5622()) {
                    C1283.m16854("nf_adv_id", "Ad id and opt in status already sent in last 24 hours, do not send again");
                } else {
                    C1283.m16854("nf_adv_id", "Ad id and opt in status were NOT sent in last 24 hours, execute");
                    m5618(r5, Boolean.valueOf(z), str);
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5618(final String str, final Boolean bool, String str2) {
        String str3 = null;
        if (!(this.f6034 == null || this.f6030 == null || this.f6030.d_() == null)) {
            str3 = this.f6030.d_().mo14452();
        }
        C1510ao aoVar = new C1510ao(str, bool.booleanValue(), str2, str3);
        m5619(aoVar.m5629(), new AbstractC1505aj() { // from class: o.al.2
            @Override // o.AbstractC1505aj
            /* renamed from: ˎ */
            public void mo5603() {
                C1283.m16854("nf_adv_id", "Advertiser ID delivered");
                long currentTimeMillis = System.currentTimeMillis();
                AY ay = new AY(C1507al.this.f6033);
                ay.m3497("advertisement_id", str);
                ay.m3499("advertisement_id_ts", currentTimeMillis);
                ay.m3498("advertisement_id_opted_in", bool.booleanValue());
                ay.m3494();
                C1507al.this.f6031 = str;
                C1507al.this.f6029 = currentTimeMillis;
                C1507al.this.f6035 = bool;
            }

            @Override // o.AbstractC1505aj
            /* renamed from: ˏ */
            public void mo5604() {
                C1283.m16854("nf_adv_id", "Advertiser ID failed to be delivered");
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5619(String str, AbstractC1505aj ajVar) {
        C1283.m16851("nf_adv_id", "send Advertising ID event send starts: %s", str);
        this.f6034.m1505(this.f6036.m5630(str, ajVar));
        C1283.m16854("nf_adv_id", "send Advertising ID event send done.");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m5622() {
        return this.f6029 > 0 && System.currentTimeMillis() < this.f6029 + 86400000;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m5609() {
        mo1482(AdvertiserIdLogging.EventType.sign_in.name());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m5607() {
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m5623() {
        C1283.m16854("nf_adv_id", "Register receiver");
        IntentFilter intentFilter = new IntentFilter("com.netflix.mediaclient.intent.action.PUSH_ONLOGIN");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.PUSH_ONLOGOUT");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.ONSIGNUP");
        intentFilter.addCategory("com.netflix.mediaclient.intent.category.PUSH");
        intentFilter.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        intentFilter.setPriority(999);
        try {
            LocalBroadcastManager.getInstance(this.f6033).registerReceiver(this.f6028, intentFilter);
        } catch (Throwable th) {
            C1283.m16856("nf_adv_id", th, "Failed to register ", new Object[0]);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m5608() {
        try {
            LocalBroadcastManager.getInstance(this.f6033).unregisterReceiver(this.f6028);
        } catch (Throwable th) {
            C1283.m16856("nf_adv_id", th, "Failed to unregister ", new Object[0]);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5626() {
        C1283.m16854("nf_adv_id", "Destroy and unregister receiver");
        m5608();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m5624() {
        return this.f6032 != null;
    }

    @Override // com.netflix.mediaclient.servicemgr.AdvertiserIdLogging
    /* renamed from: ˊ */
    public String mo1481() {
        if (m5624()) {
            return this.f6032.mo5605();
        }
        return null;
    }
}

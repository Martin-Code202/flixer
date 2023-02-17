package com.netflix.mediaclient.service.pushnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationManagerCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import com.netflix.cl.Logger;
import com.netflix.cl.model.PushNotificationType;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.log.UIScreen;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import java.util.Map;
import o.AD;
import o.AG;
import o.AJ;
import o.AbstractApplicationC1258;
import o.AbstractC0367;
import o.AbstractC0933;
import o.AbstractC1052;
import o.AbstractC1899j;
import o.C0352;
import o.C0462;
import o.C0724;
import o.C1032;
import o.C1058;
import o.C1283;
import o.C1317As;
import o.C1318At;
import o.C1339Bl;
import o.C1349Bv;
import o.C1361Cg;
import o.C1362Ch;
import o.C1496aa;
import o.C1582cD;
import o.C1583cE;
import o.C1998nb;
import o.C1999nc;
import o.C2000nd;
import o.C2001ne;
import o.C2002nf;
import o.oI;
public class PushNotificationAgent extends AbstractC1052 implements oI {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f2170 = -1;

    /* renamed from: ʻ  reason: contains not printable characters */
    private Map<String, C2001ne> f2171;

    /* renamed from: ʼ  reason: contains not printable characters */
    private C2001ne f2172;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f2173;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final BroadcastReceiver f2174 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.service.pushnotification.PushNotificationAgent.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            UIScreen r3 = PushNotificationAgent.m1205(intent);
            if ("com.netflix.mediaclient.intent.action.PUSH_ONLOGIN".equals(action)) {
                C1283.m16854("nf_push", "onLogin");
                PushNotificationAgent.this.m1231();
            } else if ("com.netflix.mediaclient.intent.action.PUSH_ONLOGOUT".equals(action)) {
                C1283.m16854("nf_push", "onLogout");
                PushNotificationAgent.this.m1233(PushNotificationAgent.this.m1207(intent));
            } else if ("com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_OPTIN".equals(action)) {
                C1283.m16854("nf_push", "optIn");
                PushNotificationAgent.this.m1220(true, r3);
            } else if ("com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_OPTOUT".equals(action)) {
                C1283.m16854("nf_push", "optOut");
                PushNotificationAgent.this.m1220(false, r3);
            }
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private final UserAgentInterface f2175;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1998nb f2176;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC1899j f2177;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Context f2178;

    /* renamed from: ॱ  reason: contains not printable characters */
    private CloudPushSupport f2179 = CloudPushSupport.UNKNOWN;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private AbstractC0933 f2180;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f2181;

    /* access modifiers changed from: package-private */
    public enum CloudPushSupport {
        NOT_SUPPORTED,
        SUPPORTED,
        UNKNOWN
    }

    public PushNotificationAgent(Context context, UserAgentInterface userAgentInterface) {
        this.f2178 = context;
        this.f2175 = userAgentInterface;
        C1283.m16854("nf_push", "PushNotificationAgent::");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ  reason: contains not printable characters */
    public void mo1237() {
        m1217();
        m1246();
        m1229();
        this.f2180 = m16097();
        this.f2177 = m16095();
        m1216();
        m16090(AbstractC0367.f13235);
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ  reason: contains not printable characters */
    public void mo1236() {
        C1283.m16854("nf_push", "PNA:: destroy and unregister receiver");
        m1228();
        super.mo1236();
    }

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private void m1217() {
        this.f2171 = C2001ne.m9283(m16093());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m1243() {
        switch (this.f2179) {
            case SUPPORTED:
                return true;
            case NOT_SUPPORTED:
                return false;
            case UNKNOWN:
            default:
                m1246();
                return this.f2179 == CloudPushSupport.SUPPORTED;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1246() {
        if (this.f2179 == CloudPushSupport.UNKNOWN && this.f2178 != null) {
            m1215(AD.m3321(this.f2178));
            C1283.m16851("nf_push", "Device supports GCM: %s", this.f2179);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1215(boolean z) {
        this.f2179 = z ? CloudPushSupport.SUPPORTED : CloudPushSupport.NOT_SUPPORTED;
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    private void m1218() {
        String r5 = this.f2175.mo1339();
        if (C1349Bv.m4113(r5)) {
            C1283.m16850("nf_push", "accountOwnerToken ID is empty! This should NOT happen!");
        } else if (this.f2172 == null || !r5.equals(this.f2172.f9133)) {
            C1283.m16854("nf_push", "We DO NOT have user! Try to find it from settings");
            if (this.f2172 != null) {
                this.f2172.f9131 = false;
            }
            this.f2172 = this.f2171.get(r5);
            if (this.f2172 == null) {
                C1283.m16854("nf_push", "User was not know from before");
                this.f2172 = m1232(r5, this.f2175.mo1353());
                return;
            }
            this.f2172.f9131 = true;
            C1283.m16851("nf_push", "User was know from before and he opted in %b", Boolean.valueOf(this.f2172.f9134));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private C2001ne m1232(String str, String str2) {
        C2001ne neVar = new C2001ne();
        neVar.f9131 = true;
        neVar.f9133 = str;
        neVar.f9132 = str2;
        neVar.f9136 = C1318At.m3778(m16093());
        this.f2171.put(str, neVar);
        return neVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1227(String str) {
        this.f2172.f9132 = str;
        this.f2172.f9137 = System.currentTimeMillis();
        this.f2171.put(this.f2172.f9133, this.f2172);
        C2001ne.m9285(m16093(), this.f2171);
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private void m1216() {
        if (!m1243()) {
            C1283.m16850("nf_push", "device does NOT support GCM!");
            return;
        }
        this.f2173 = FirebaseInstanceId.getInstance().getToken();
        C1283.m16851("nf_push", "device supports GCM token: %s", this.f2173);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1211(boolean z) {
        if (this.f2172 == null) {
            C1283.m16854("nf_push", "User is NOT logged in, do nothing. We can not register");
            return;
        }
        this.f2172.f9134 = z;
        this.f2172.f9135 = true;
        m1222();
    }

    @Override // o.oI
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo1245() {
        if (!m1243()) {
            C1283.m16850("nf_push", "Device is NOT GCM registered, do not display notification! That is why true is returned");
            return true;
        }
        m1218();
        if (this.f2172 != null) {
            return this.f2172.f9135;
        }
        C1283.m16854("nf_push", "Current user is empty. Do NOT display opt in dialog!");
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private synchronized void m1233(C1496aa aaVar) {
        C1283.m16854("nf_push", "User is logging out");
        if (!m1243()) {
            C1283.m16850("nf_push", "We can not do anything because device does not support push notifications!");
            return;
        }
        m1212(false, false, UIScreen.logout);
        if (aaVar != null) {
            this.f2172 = this.f2171.get(aaVar.f5960);
            if (this.f2172 == null) {
                C1283.m16850("nf_push", "User is logging out and it was uknown before?");
                this.f2172 = new C2001ne();
                this.f2172.f9131 = true;
                this.f2172.f9133 = aaVar.f5960;
                this.f2172.f9134 = true;
                this.f2172.f9132 = aaVar.f5962;
                this.f2172.f9136 = C1318At.m3778(m16093());
            }
        }
        m1222();
        this.f2172 = null;
        AJ.m3362();
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private void m1222() {
        final Map<String, C2001ne> map = this.f2171;
        if (map == null) {
            C1283.m16850("nf_push", "This should not happen! Map is null!");
        } else {
            new BackgroundTask().m285(new Runnable() { // from class: com.netflix.mediaclient.service.pushnotification.PushNotificationAgent.2
                @Override // java.lang.Runnable
                public void run() {
                    C2001ne.m9285(PushNotificationAgent.this.m16093(), map);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1220(boolean z, UIScreen uIScreen) {
        C1283.m16851("nf_push", "onNotificationOptIn - user optIn ? %b", Boolean.valueOf(z));
        m1218();
        m1211(z);
        C0352.m13956(m16093(), z);
        mo1242(z, uIScreen);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1209(String str) {
        this.f2173 = str;
        mo1242(this.f2172.f9134, UIScreen.login);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m1239() {
        return m1243();
    }

    @Override // o.oI
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo1242(boolean z, UIScreen uIScreen) {
        m1212(z, true, uIScreen);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1212(boolean z, boolean z2, UIScreen uIScreen) {
        if (!m1243()) {
            C1283.m16850("nf_push", "We can not report anything if device does not support push notifications!");
        } else if (C0462.m14348()) {
            C1283.m16854("nf_push", "skipping push notification reporting - automation run");
        } else {
            boolean r7 = m1230();
            if (!C1349Bv.m4113(this.f2173)) {
                String r8 = m1214(this.f2178, this.f2173);
                Long r9 = Logger.INSTANCE.m142(new C0724());
                PushNotificationType[] pushNotificationTypeArr = C1317As.m3774() ? new PushNotificationType[]{PushNotificationType.alert, PushNotificationType.sound, PushNotificationType.badge} : new PushNotificationType[]{PushNotificationType.alert, PushNotificationType.sound};
                if (r9 != null) {
                    if (r7) {
                        Logger.INSTANCE.m147(C0724.m15061(r9, this.f2173, pushNotificationTypeArr, z2, z, r8));
                    } else {
                        Logger.INSTANCE.m147(C0724.m15061(r9, this.f2173, pushNotificationTypeArr, z2, false, r8));
                    }
                }
                IClientLogging.ModalView modalView = null;
                if (uIScreen != null) {
                    modalView = uIScreen.f4084;
                }
                C1362Ch.m4410(modalView);
                if (r7) {
                    C1362Ch.m4417(IClientLogging.CompletionReason.success, null, this.f2173, z, z2, r8);
                } else {
                    C1362Ch.m4417(IClientLogging.CompletionReason.success, null, this.f2173, false, z2, r8);
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private String m1214(Context context, String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        String r4 = C1339Bl.m4045(context, "old_push_message_token", (String) null);
        C1283.m16851("nf_push", "oldDeviceToken in Pref: %s", r4);
        if (C1349Bv.m4113(r4)) {
            C1339Bl.m4039(context, "old_push_message_token", str);
            return null;
        } else if (C1349Bv.m4126(r4, str)) {
            return null;
        } else {
            C1339Bl.m4039(context, "old_push_message_token", str);
            return r4;
        }
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    private boolean m1230() {
        NotificationManagerCompat from = NotificationManagerCompat.from(m16093());
        if (from == null) {
            C1283.m16854("nf_push", "areNotificationsEnabled:: NotificationManagerCompat is null, assume that notifications are enabled");
            return true;
        }
        boolean areNotificationsEnabled = from.areNotificationsEnabled();
        C1283.m16851("nf_push", "areNotificationsEnabled:: notifications are enabled %b", Boolean.valueOf(areNotificationsEnabled));
        return areNotificationsEnabled;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private C1496aa m1207(Intent intent) {
        C1496aa aaVar = new C1496aa();
        aaVar.f5965 = intent.getStringExtra(Device.ESN);
        aaVar.f5957 = intent.getStringExtra("device_cat");
        aaVar.f5961 = intent.getStringExtra("nid");
        aaVar.f5964 = intent.getStringExtra("sid");
        aaVar.f5960 = intent.getStringExtra("uid");
        aaVar.f5962 = intent.getStringExtra("cp_uid");
        return aaVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1219(Intent intent) {
        C1283.m16854("nf_push", "Message received, create notification. Running it on main thread.");
        if (this.f2176 == null) {
            synchronized (this) {
                if (this.f2176 == null) {
                    this.f2176 = new C1998nb(this.f2177, m16101(), this);
                }
            }
        }
        if (intent == null) {
            C1283.m16850("nf_push", "NotificationFactory.createNotification:: Intent is null!");
            return;
        }
        Context r7 = AbstractApplicationC1258.m16692();
        Payload payload = new Payload(intent);
        if (C2002nf.m9289(payload)) {
            if (this.f2175.mo1383() == null || !C1349Bv.m4107(payload.f2128)) {
                C1283.m16865("nf_push", "processing gcm message, payload has no profileId or currentProfile is null ");
            } else {
                String profileGuid = this.f2175.mo1383().getProfileGuid();
                if (!C1349Bv.m4126(profileGuid, payload.f2128)) {
                    C1283.m16854("nf_push", String.format("drop push event - currentProfile :%s != profileGuid:%s", profileGuid, payload.f2128));
                    return;
                }
            }
            if (UmaAlert.TYPE_INFO.equals(payload.f2140)) {
                this.f2176.m9274(r7, this, t_(), payload, intent, this.f2175.mo1383());
            } else if (!C2002nf.m9287(this.f2177, this.f2175.mo1383(), payload, intent)) {
                C2002nf.m9288(r7, payload, this.f2180, m1213(m16093()));
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m1206(Intent intent) {
        AJ.m3363(m16093(), intent, "nf_push");
        C1999nc r4 = C1999nc.m9278(intent);
        if (r4 == null) {
            C1283.m16850("nf_push", "Unable to report canceled notification since message data are missing!");
            return;
        }
        C1283.m16851("nf_push", "User canceled notification %s", r4);
        m1234(r4);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m1234(C1999nc ncVar) {
        Logger.INSTANCE.m131(new C1058(new C2000nd(ncVar), 0));
        C1361Cg.m4378(m16093(), new C1582cD(new C1583cE(ncVar), UserFeedbackOnReceivedPushNotification.canceled.m1248()));
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m1235(Intent intent) {
        C1999nc r4 = C1999nc.m9278(intent);
        if (r4 == null) {
            C1283.m16850("nf_push", "Unable to report browser redirect notification since message data are missing!");
            return;
        }
        C1283.m16851("nf_push", "User browser redirect notification %s", r4);
        m1210(r4);
        C1283.m16849("nf_push", intent);
        String stringExtra = intent.getStringExtra("target_url");
        if (stringExtra != null) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(stringExtra));
            intent2.setFlags(872415232);
            m16093().startActivity(intent2);
            return;
        }
        C1283.m16850("nf_push", "URI is missing! Can not open to browser!");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1210(C1999nc ncVar) {
        Logger.INSTANCE.m131(new C1032(new C2000nd(ncVar), 0));
        C1361Cg.m4378(m16093(), new C1582cD(new C1583cE(ncVar), UserFeedbackOnReceivedPushNotification.opened.m1248()));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private synchronized int m1213(final Context context) {
        int i;
        if (f2170 == -1) {
            f2170 = C1339Bl.m4037(context, "nf_notification_id_counter", 1);
        }
        i = f2170;
        f2170++;
        new BackgroundTask().m285(new Runnable() { // from class: com.netflix.mediaclient.service.pushnotification.PushNotificationAgent.3
            @Override // java.lang.Runnable
            public void run() {
                C1339Bl.m4042(context, "nf_notification_id_counter", PushNotificationAgent.f2170);
            }
        });
        return i;
    }

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private void m1229() {
        C1283.m16854("nf_push", "Register receiver");
        AG.m3334(m16093(), this.f2174, "com.netflix.mediaclient.intent.category.PUSH", "com.netflix.mediaclient.intent.action.PUSH_ONLOGIN", "com.netflix.mediaclient.intent.action.PUSH_ONLOGOUT", "com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_OPTIN", "com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_OPTOUT");
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private void m1228() {
        AG.m3329(m16093(), this.f2174);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m1231() {
        if (!m1243()) {
            C1283.m16850("nf_push", "We can not do anything because device does not support push notifications!");
            return;
        }
        String r5 = this.f2175.mo1339();
        String r6 = this.f2175.mo1353();
        this.f2172 = this.f2171.get(r5);
        if (this.f2172 == null) {
            C1283.m16854("nf_push", "User was not know from before");
            this.f2172 = m1232(r5, r6);
        } else {
            this.f2172.f9131 = true;
            if (!C1349Bv.m4126(this.f2172.f9132, r6)) {
                C1283.m16854("nf_push", "currentProfile change detected");
                m1227(r6);
            }
            C1283.m16851("nf_push", "User was known from before and he opted in %b", Boolean.valueOf(this.f2172.f9134));
        }
        try {
            C1283.m16851("nf_push", "report sGcmInfoEventStartedService: %s", Boolean.valueOf(this.f2181));
            if (this.f2181) {
                t_().mo15844(600000);
                return;
            }
            C0352.m13956(m16093(), this.f2172.f9134);
            mo1242(this.f2172.f9134, UIScreen.login);
        } catch (Throwable th) {
            C1283.m16847("nf_push", "Check if we are registered already failed!", th);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m1247(Intent intent) {
        if (intent == null) {
            C1283.m16865("nf_push", "Intent is null");
            return false;
        } else if ("com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_GCM_ONREGISTERED".equals(intent.getAction())) {
            C1283.m16854("nf_push", "Handle registration");
            m1209(intent.getStringExtra("reg_id"));
            return true;
        } else if ("com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_GCM_ONMESSAGE".equals(intent.getAction())) {
            C1283.m16854("nf_push", "Handle message");
            m1219(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.NOTIFICATION_CANCELED".equals(intent.getAction())) {
            C1283.m16854("nf_push", "Handle notification canceled");
            m1206(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.NOTIFICATION_BROWSER_REDIRECT".equals(intent.getAction())) {
            C1283.m16854("nf_push", "Handle notification browser redirect");
            m1235(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.NOTIFICATION_MARK_AS_READ".equals(intent.getAction())) {
            C1283.m16854("nf_push", "Handle notification respond mark as read redirect");
            m1241(intent);
            return true;
        } else {
            C1283.m16850("nf_push", "Unknown command!");
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ʻ  reason: contains not printable characters */
    public static UIScreen m1205(Intent intent) {
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra(NetflixActivity.EXTRA_SOURCE);
        if (C1349Bv.m4107(stringExtra)) {
            return UIScreen.valueOf(stringExtra);
        }
        return null;
    }

    @Override // o.oI
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public void mo1240() {
        C1283.m16854("nf_push", "noting that gcmInfoEvent started NetflixService");
        this.f2181 = true;
    }

    @Override // o.oI
    /* renamed from: ˉ  reason: contains not printable characters */
    public boolean mo1238() {
        if (this.f2172 != null) {
            return this.f2172.f9134;
        }
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1241(Intent intent) {
        C1283.m16853("nf_push", "markAsRead", intent);
        this.f2177.mo7814(new IrisNotificationSummary(intent.getStringExtra("g"), null));
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    public void m1244() {
        m1218();
        if (this.f2172 != null) {
            mo1242(this.f2172.f9134, UIScreen.browseTitles);
            return;
        }
        C1283.m16865("nf_push", "Uknown user, report false");
        mo1242(false, UIScreen.browseTitles);
    }
}

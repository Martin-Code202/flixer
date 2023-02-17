package o;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.netflix.falkor.cache.FalkorCache;
import com.netflix.mediaclient.service.pushnotification.Payload;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.Locale;
/* renamed from: o.nb  reason: case insensitive filesystem */
public class C1998nb {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final RunnableC0154 f9101 = new RunnableC0154();

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Runnable f9102 = new Runnable() { // from class: o.nb.1
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16862("nf_push_info", "fetching preAppData via runnable");
            if (C1998nb.this.f9107 != null) {
                C1998nb.this.f9107.mo7812(6, 6);
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private final oI f9103;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f9104 = new Handler(Looper.getMainLooper());

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1221 f9105;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final RunnableC0153 f9106 = new RunnableC0153();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1899j f9107;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Runnable f9108 = new Runnable() { // from class: o.nb.3
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16862("nf_push_info", "Refreshing socialNotifications via runnable");
            if (C1998nb.this.f9107 != null) {
                C1998nb.this.f9107.mo7807(true, false, true, (C1999nc) null);
            }
        }
    };

    /* access modifiers changed from: package-private */
    /* renamed from: o.nb$ˊ  reason: contains not printable characters */
    public class RunnableC0153 implements Runnable {

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f9112;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f9113;

        private RunnableC0153() {
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m9275(String str, String str2) {
            this.f9112 = str;
            this.f9113 = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1283.m16863("nf_push_info", "Refreshing list %s via runnable", this.f9112);
            if (C1998nb.this.f9107 != null) {
                C1276.m16820().mo5728(String.format(Locale.ENGLISH, "gcm.%s.refresh", this.f9112));
                C1998nb.this.f9107.mo7811(this.f9112, this.f9113);
                if (LoMoType.CONTINUE_WATCHING.m1575().equals(this.f9112)) {
                    C1998nb.this.f9107.A_();
                }
                this.f9113 = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.nb$ˋ  reason: contains not printable characters */
    public class RunnableC0154 implements Runnable {

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f9115;

        private RunnableC0154() {
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m9276(String str) {
            this.f9115 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1283.m16862("nf_push_info", "Refreshing ALL lolomo via runnable");
            if (C1998nb.this.f9107 != null) {
                C1998nb.this.f9107.mo7815(this.f9115);
            }
        }
    }

    public C1998nb(AbstractC1899j jVar, AbstractC1221 r4, oI oIVar) {
        this.f9107 = jVar;
        this.f9105 = r4;
        this.f9103 = oIVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9274(Context context, oI oIVar, AbstractC1250 r11, Payload payload, Intent intent, AbstractC2089qj qjVar) {
        boolean r4 = C1333Bf.m4018(intent, "isRunning");
        boolean r5 = ((AbstractC2104qx) C1281.m16832(AbstractC2104qx.class)).mo10123(context);
        boolean z = !FalkorCache.m167();
        boolean equalsIgnoreCase = "true".equalsIgnoreCase(payload.f2153);
        if (equalsIgnoreCase) {
            C1283.m16854("nf_push_info", "received message contains ping param. reporting current state");
            oIVar.mo1242(C0352.m13957(context), UIScreen.homeScreen);
        }
        if (z && !r4 && !r5 && !equalsIgnoreCase) {
            C1283.m16854("nf_push_info", "handleEvent bailing because !wasServiceRunning && !isWidgetInstalled");
            m9271(r11);
        } else if (qjVar == null) {
            C1283.m16854("nf_push_info", String.format("currentProfile null dropping gcm event payload:%s", payload));
        } else if ("NewLolomo".equalsIgnoreCase(payload.f2141)) {
            m9270(context, r11, r4, payload);
        } else if ("NewRow".equalsIgnoreCase(payload.f2141)) {
            m9266(r4, r5, payload.f2132, payload.f2133 != null ? payload.f2133 : payload.f2158);
        } else if (Payload.ActionInfoType.m1201(payload.f2156)) {
            m9268(r4);
        } else if (Payload.ActionInfoType.m1200(payload.f2156)) {
            m9273(r4);
        } else {
            C1283.m16851("nf_push_info", "unknown message - dropping - %s", payload);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9270(Context context, AbstractC1250 r11, boolean z, Payload payload) {
        boolean r7 = ((AbstractC2104qx) C1281.m16832(AbstractC2104qx.class)).mo10123(context);
        if (z || r7) {
            C1362Ch.m4413(null, null);
            this.f9104.removeCallbacks(this.f9101);
            String str = payload.f2133 != null ? payload.f2133 : payload.f2158;
            if (!TextUtils.isEmpty(str)) {
                this.f9101.m9276(str);
            }
            this.f9104.postDelayed(this.f9101, m9272());
            C1362Ch.m4399(IClientLogging.CompletionReason.success, null, payload.f2135, payload.f2130, Long.valueOf(payload.f2134), payload.f2158, payload.f2152);
            return;
        }
        m9271(r11);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9266(boolean z, boolean z2, String str, String str2) {
        if (z) {
            this.f9106.m9275(str, str2);
            this.f9104.removeCallbacks(this.f9106);
            this.f9104.postDelayed(this.f9106, m9272());
        } else if (z2) {
            this.f9104.removeCallbacks(this.f9102);
            this.f9104.postDelayed(this.f9102, m9272());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m9268(boolean z) {
        if (z) {
            C1283.m16854("nf_push_info", "handling EVENT_NOTIFICATION_READ");
            this.f9104.removeCallbacks(this.f9108);
            this.f9104.postDelayed(this.f9108, m9269());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m9273(boolean z) {
        if (z) {
            C1283.m16854("nf_push_info", "handling EVENT_NOTIFICATION_LIST_CHANGED");
            this.f9104.removeCallbacks(this.f9108);
            this.f9104.postDelayed(this.f9108, m9269());
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9271(AbstractC1250 r6) {
        C1283.m16854("nf_push_info", "Skip handling event - gcmInfoEvent woke up netflixService intent: ");
        this.f9103.mo1240();
        C1283.m16851("nf_push_info", "kill service in %d ms", 600000L);
        r6.mo15844(600000);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private long m9272() {
        int r2 = this.f9105.mo16545();
        if (r2 < 0) {
            return 0;
        }
        if (r2 > 0) {
            return (long) (r2 * 1000);
        }
        return 1000;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private long m9269() {
        int n_ = this.f9105.n_();
        if (n_ < 0) {
            return 0;
        }
        if (n_ > 0) {
            return (long) (n_ * 1000);
        }
        return 1000;
    }
}

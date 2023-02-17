package o;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.service.pushnotification.Payload;
/* renamed from: o.nf  reason: case insensitive filesystem */
public final class C2002nf {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m9289(Payload payload) {
        if (C1349Bv.m4107(Payload.m1191(payload))) {
            return false;
        }
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9288(Context context, Payload payload, AbstractC0933 r7, int i) {
        Logger.INSTANCE.m131(new C0991(new C2000nd(payload), SystemClock.currentThreadTimeMillis()));
        C1361Cg.m4377(context, new C1580cB(new C1583cE(payload)));
        if (NetflixApplication.m16693()) {
            C1283.m16862("nf_push_notificationFactory", "App is active - don't send a notification to Android status bar");
        } else {
            ((AbstractC2105qy) C1281.m16832(AbstractC2105qy.class)).mo10125(context, payload, r7, i);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m9287(AbstractC1899j jVar, AbstractC2089qj qjVar, Payload payload, Intent intent) {
        if (!"SOCIAL".equals(payload.f2140)) {
            return false;
        }
        if (qjVar == null) {
            return true;
        }
        jVar.mo7807(true, true, false, C1999nc.m9278(intent));
        return true;
    }
}

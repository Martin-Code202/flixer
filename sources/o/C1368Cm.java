package o;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AllocationMode;
import com.netflix.cl.model.ComputationMode;
import com.netflix.cl.model.InteractionMode;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: o.Cm  reason: case insensitive filesystem */
public final class C1368Cm {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C1368Cm f5175 = new C1368Cm();

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long f5176;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final ArrayList<Long> f5177 = new ArrayList<>();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static C0680 f5178;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final If f5179 = new If();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final C0081 f5180 = new C0081();

    private C1368Cm() {
    }

    /* renamed from: o.Cm$If */
    public static final class If extends AbstractC1314Ap {
        If() {
        }

        @Override // o.AbstractC1314Ap, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            C1457Fr.m5025(activity, "activity");
            super.onActivityCreated(activity, bundle);
            C1283.m16851("ProcessStateLoggingManager", "Activity created %s", activity.getLocalClassName());
            if ((activity instanceof NetflixActivity) && ((NetflixActivity) activity).hasInteractiveUI()) {
                C1368Cm.f5175.m4503();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final void m4504() {
        C1283.m16846("ProcessStateLoggingManager", "reset()");
        f5176 = 0;
        f5177.clear();
        f5178 = null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final void m4506() {
        C1283.m16846("ProcessStateLoggingManager", "init()");
        NetflixApplication instance = NetflixApplication.getInstance();
        C1457Fr.m5016((Object) instance, "NetflixApplication.getInstance()");
        instance.m237().mo14206(f5180);
        f5175.m4509(new C0610(AllocationMode.none, ComputationMode.none, InteractionMode.none));
        f5175.m4509(new C0610(AllocationMode.normal, ComputationMode.normal, InteractionMode.direct));
        f5175.m4505();
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0041: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v1 java.lang.Long) */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m4505() {
        if (f5178 != null) {
            C1283.m16854("ProcessStateLoggingManager", "Ignore start ProcessStateTransition, there is a running process state transition session already");
            return;
        }
        NetflixApplication.getInstance().registerActivityLifecycleCallbacks(f5179);
        C0680 r5 = new C0680(SystemClock.currentThreadTimeMillis());
        Logger.INSTANCE.m142(r5);
        f5178 = r5;
        Object[] objArr = new Object[2];
        C0680 r3 = f5178;
        objArr[0] = r3 != null ? Long.valueOf(r3.m16816()) : null;
        objArr[1] = Long.valueOf(f5176);
        C1283.m16851("ProcessStateLoggingManager", "Start ProcessStateTransition %d, current context %d", objArr);
    }

    /* access modifiers changed from: private */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0044: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v1 java.lang.Long) */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m4503() {
        if (f5178 == null) {
            C1283.m16854("ProcessStateLoggingManager", "Ignore end ProcessStateTransition, there is no start process state transition session");
            return;
        }
        NetflixApplication.getInstance().unregisterActivityLifecycleCallbacks(f5179);
        Logger logger = Logger.INSTANCE;
        C0680 r1 = f5178;
        logger.m147(C0680.m16815(r1 != null ? Long.valueOf(r1.m16816()) : null));
        Object[] objArr = new Object[1];
        C0680 r3 = f5178;
        objArr[0] = r3 != null ? Long.valueOf(r3.m16816()) : null;
        C1283.m16851("ProcessStateLoggingManager", "End ProcessStateTransition %d", objArr);
        m4510();
        f5178 = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m4509(C0610 r6) {
        if (f5176 > 0) {
            f5177.add(Long.valueOf(f5176));
        }
        f5176 = Logger.INSTANCE.m127(r6);
        C1283.m16851("ProcessStateLoggingManager", "Current ProcessState %s - %d", r6, Long.valueOf(f5176));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m4510() {
        Iterator<T> it = f5177.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            Logger.INSTANCE.m132(Long.valueOf(longValue));
            C1283.m16851("ProcessStateLoggingManager", "Remove ProcessState %d", Long.valueOf(longValue));
        }
        f5177.clear();
    }

    /* renamed from: o.Cm$ˊ  reason: contains not printable characters */
    public static final class C0081 implements AbstractC0390 {
        C0081() {
        }

        @Override // o.AbstractC0390
        /* renamed from: ˎ */
        public void mo211(AbstractC0457 r6, Intent intent) {
            C1457Fr.m5025(r6, "userInputTracker");
            C1283.m16846("ProcessStateLoggingManager", "onForeground()");
            C1368Cm.f5175.m4509(new C0610(AllocationMode.normal, ComputationMode.normal, InteractionMode.direct));
            C1368Cm.f5175.m4505();
            C1368Cm.f5175.m4503();
        }

        @Override // o.AbstractC0390
        /* renamed from: ॱ */
        public void mo213(AbstractC0457 r6) {
            C1457Fr.m5025(r6, "userInputTracker");
            C1283.m16846("ProcessStateLoggingManager", "onBackground()");
            C1368Cm.f5175.m4509(new C0610(AllocationMode.reduced, ComputationMode.reduced, InteractionMode.indirect));
            C1368Cm.f5175.m4505();
            C1368Cm.f5175.m4503();
        }

        @Override // o.AbstractC0390
        /* renamed from: ˋ */
        public void mo209(AbstractC0457 r2) {
            C1457Fr.m5025(r2, "userInputManager");
        }

        @Override // o.AbstractC0390
        /* renamed from: ˏ */
        public void mo212(AbstractC0457 r2) {
            C1457Fr.m5025(r2, "userInputManager");
        }

        @Override // o.AbstractC0390
        /* renamed from: ˊ */
        public void mo208(AbstractC0457 r2) {
            C1457Fr.m5025(r2, "userInputManager");
        }

        @Override // o.AbstractC0390
        /* renamed from: ˎ */
        public void mo210(AbstractC0457 r2) {
            C1457Fr.m5025(r2, "userInputManager");
        }
    }
}

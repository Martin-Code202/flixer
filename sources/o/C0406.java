package o;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.netflix.mediaclient.ui.launch.LaunchActivity;
import com.netflix.mediaclient.ui.launch.NetflixComLaunchActivity;
import com.netflix.mediaclient.ui.launch.UIWebViewActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* renamed from: o.ʢ  reason: contains not printable characters */
public class C0406 implements AbstractC0457, Application.ActivityLifecycleCallbacks {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final ThreadFactory f13356 = new ThreadFactory() { // from class: o.ʢ.4

        /* renamed from: ˋ  reason: contains not printable characters */
        private final AtomicInteger f13367 = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "UserInputManager #" + this.f13367.getAndIncrement());
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    private Intent f13357;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AtomicBoolean f13358;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AtomicInteger f13359;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AtomicLong f13360;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ScheduledExecutorService f13361;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<AbstractC0390> f13362;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AtomicInteger f13363;

    /* access modifiers changed from: package-private */
    /* renamed from: o.ʢ$iF */
    public static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        static final C0406 f13372 = new C0406();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0406 m14192() {
        return iF.f13372;
    }

    private C0406() {
        this.f13360 = new AtomicLong(SystemClock.elapsedRealtime());
        this.f13362 = Collections.synchronizedList(new ArrayList());
        this.f13359 = new AtomicInteger();
        this.f13363 = new AtomicInteger();
        this.f13358 = new AtomicBoolean();
        this.f13361 = Executors.newSingleThreadScheduledExecutor(f13356);
    }

    @Override // o.AbstractC0457
    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized boolean mo14206(AbstractC0390 r3) {
        if (!this.f13362.contains(r3)) {
            return this.f13362.add(r3);
        }
        C1283.m16850("nf_input", "Listener already exist");
        return false;
    }

    @Override // o.AbstractC0457
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo14208(AbstractC0390 r2) {
        return this.f13362.remove(r2);
    }

    @Override // o.AbstractC0457
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo14203() {
        this.f13360.set(SystemClock.elapsedRealtime());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14193(int i) {
        if (i == 1) {
            C1283.m16854("nf_input", "UI may just started, only one activity");
            this.f13361.execute(new Runnable() { // from class: o.ʢ.2
                @Override // java.lang.Runnable
                public void run() {
                    for (AbstractC0390 r2 : C0406.this.f13362) {
                        r2.mo209(C0406.this);
                    }
                }
            });
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14197(int i) {
        if (i == 0) {
            C1283.m16854("nf_input", "UI is  gone");
            this.f13361.execute(new Runnable() { // from class: o.ʢ.3
                @Override // java.lang.Runnable
                public void run() {
                    for (AbstractC0390 r2 : C0406.this.f13362) {
                        r2.mo210(C0406.this);
                    }
                }
            });
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private synchronized boolean m14199() {
        if (this.f13362.isEmpty()) {
            return false;
        }
        for (AbstractC0390 r4 : this.f13362) {
            C1283.m16854("nf_input", "isSuspendLoggingReady: listener " + r4);
            if (r4 instanceof A) {
                C1283.m16854("nf_input", "Logger ready!");
                return true;
            }
        }
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private synchronized void m14195(Activity activity, final Intent intent, boolean z) {
        if (!z) {
            C1283.m16854("nf_input", "Our app was in background");
        } else if (intent == null) {
            C1283.m16854("nf_input", "Our app is in foreground already and we do not have a deep link");
            return;
        } else {
            C1283.m16854("nf_input", "Our app is in foreground already, deep link most likely");
        }
        if (m14199()) {
            C1283.m16854("nf_input", "We are initialized, report...");
            this.f13361.execute(new Runnable() { // from class: o.ʢ.5
                @Override // java.lang.Runnable
                public void run() {
                    for (AbstractC0390 r3 : C0406.this.f13362) {
                        r3.mo211(C0406.this, intent);
                    }
                }
            });
        } else if (intent != null) {
            C1283.m16853("nf_input", "Logger is not ready, cold start, save intent", intent);
            this.f13357 = intent;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14191(Activity activity) {
        if (mo14205()) {
            C1283.m16854("nf_input", "Our app is still in foreground!");
            return;
        }
        C1283.m16854("nf_input", "Our app is in background now");
        this.f13361.execute(new Runnable() { // from class: o.ʢ.1
            @Override // java.lang.Runnable
            public void run() {
                for (AbstractC0390 r2 : C0406.this.f13362) {
                    r2.mo213(C0406.this);
                }
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14194(Activity activity) {
        mo14205();
        if (this.f13363.get() > 0) {
            C1283.m16854("nf_input", "Our app UI still has focus!");
            return;
        }
        C1283.m16854("nf_input", "Our app UI lost focus");
        this.f13361.execute(new Runnable() { // from class: o.ʢ.9
            @Override // java.lang.Runnable
            public void run() {
                for (AbstractC0390 r2 : C0406.this.f13362) {
                    r2.mo212(C0406.this);
                }
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14198(Activity activity) {
        mo14205();
        if (this.f13363.get() <= 0) {
            C1283.m16854("nf_input", "Our app UI was not in focus!");
            this.f13361.execute(new Runnable() { // from class: o.ʢ.8
                @Override // java.lang.Runnable
                public void run() {
                    for (AbstractC0390 r2 : C0406.this.f13362) {
                        r2.mo208(C0406.this);
                    }
                }
            });
            return;
        }
        C1283.m16854("nf_input", "Our app UI had focus before!");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        m14193(this.f13359.incrementAndGet());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        m14197(this.f13359.decrementAndGet());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity instanceof NetflixComLaunchActivity) {
            C1283.m16854("nf_input", "NetflixComLaunchActivity, ignore");
        } else {
            m14194(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity instanceof NetflixComLaunchActivity) {
            C1283.m16854("nf_input", "NetflixComLaunchActivity, ignore");
        } else {
            m14198(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (activity instanceof NetflixComLaunchActivity) {
            C1283.m16854("nf_input", "NetflixComLaunchActivity, ignore");
            return;
        }
        boolean r2 = mo14205();
        this.f13363.incrementAndGet();
        if ((activity instanceof UIWebViewActivity) || (activity instanceof LaunchActivity)) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                C1283.m16853("nf_input", "LaunchActivity: Foreground with intent", intent);
            } else {
                C1283.m16854("nf_input", "LaunchActivity: Foreground without intent");
            }
            m14195(activity, intent, r2);
            return;
        }
        m14195(activity, null, r2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity instanceof NetflixComLaunchActivity) {
            C1283.m16854("nf_input", "NetflixComLaunchActivity, ignore");
            return;
        }
        this.f13363.decrementAndGet();
        m14191(activity);
    }

    @Override // o.AbstractC0457
    /* renamed from: ॱ  reason: contains not printable characters */
    public long mo14207() {
        return SystemClock.elapsedRealtime() - this.f13360.get();
    }

    @Override // o.AbstractC0457
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo14202() {
        m14190();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m14190() {
        C1306Ah.m3611(mo14207());
    }

    @Override // o.AbstractC0457
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo14205() {
        return this.f13363.get() > 0;
    }

    @Override // o.AbstractC0457
    /* renamed from: ʼ  reason: contains not printable characters */
    public synchronized Intent mo14201() {
        Intent intent;
        intent = this.f13357;
        this.f13357 = null;
        return intent;
    }

    @Override // o.AbstractC0457
    /* renamed from: ʻ  reason: contains not printable characters */
    public int mo14200() {
        return this.f13359.get();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14204(boolean z) {
        this.f13358.set(z);
    }

    @Override // o.AbstractC0457
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo14209() {
        return this.f13358.get();
    }
}

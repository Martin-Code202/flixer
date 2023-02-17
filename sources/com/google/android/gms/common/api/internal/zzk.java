package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.zzp;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
public final class zzk implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final zzk zzfir = new zzk();
    private final ArrayList<zzl> mListeners = new ArrayList<>();
    private boolean zzdod = false;
    private final AtomicBoolean zzfis = new AtomicBoolean();
    private final AtomicBoolean zzfit = new AtomicBoolean();

    private zzk() {
    }

    public static void zza(Application application) {
        synchronized (zzfir) {
            if (!zzfir.zzdod) {
                application.registerActivityLifecycleCallbacks(zzfir);
                application.registerComponentCallbacks(zzfir);
                zzfir.zzdod = true;
            }
        }
    }

    public static zzk zzafz() {
        return zzfir;
    }

    private final void zzbe(boolean z) {
        synchronized (zzfir) {
            ArrayList<zzl> arrayList = this.mListeners;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                zzl zzl = arrayList.get(i);
                i++;
                zzl.zzbe(z);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.zzfis.compareAndSet(true, false);
        this.zzfit.set(true);
        if (compareAndSet) {
            zzbe(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.zzfis.compareAndSet(true, false);
        this.zzfit.set(true);
        if (compareAndSet) {
            zzbe(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.zzfis.compareAndSet(false, true)) {
            this.zzfit.set(true);
            zzbe(true);
        }
    }

    public final void zza(zzl zzl) {
        synchronized (zzfir) {
            this.mListeners.add(zzl);
        }
    }

    @TargetApi(16)
    public final boolean zzbd(boolean z) {
        if (!this.zzfit.get()) {
            if (!zzp.zzalf()) {
                return true;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.zzfit.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.zzfis.set(true);
            }
        }
        return this.zzfis.get();
    }
}

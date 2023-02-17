package o;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* renamed from: o.Ap  reason: case insensitive filesystem */
public abstract class AbstractC1314Ap implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        C1457Fr.m5025(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        C1457Fr.m5025(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        C1457Fr.m5025(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        C1457Fr.m5025(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        C1457Fr.m5025(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        C1457Fr.m5025(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        C1457Fr.m5025(activity, "activity");
    }
}

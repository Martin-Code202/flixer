package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;
public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new Callable<Scheduler>() { // from class: io.reactivex.android.schedulers.AndroidSchedulers.1
        @Override // java.util.concurrent.Callable
        public Scheduler call() {
            return MainHolder.DEFAULT;
        }
    });

    /* access modifiers changed from: package-private */
    public static final class MainHolder {
        static final Scheduler DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()));
    }

    public static Scheduler mainThread() {
        return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
    }
}

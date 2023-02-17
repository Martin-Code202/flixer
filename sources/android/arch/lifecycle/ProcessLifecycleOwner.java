package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ReportFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
public class ProcessLifecycleOwner implements LifecycleOwner {
    private static final ProcessLifecycleOwner sInstance = new ProcessLifecycleOwner();
    private Runnable mDelayedPauseRunnable = new Runnable() { // from class: android.arch.lifecycle.ProcessLifecycleOwner.1
        @Override // java.lang.Runnable
        public void run() {
            ProcessLifecycleOwner.this.dispatchPauseIfNeeded();
            ProcessLifecycleOwner.this.dispatchStopIfNeeded();
        }
    };
    private Handler mHandler;
    private ReportFragment.ActivityInitializationListener mInitializationListener = new ReportFragment.ActivityInitializationListener() { // from class: android.arch.lifecycle.ProcessLifecycleOwner.2
        @Override // android.arch.lifecycle.ReportFragment.ActivityInitializationListener
        public void onCreate() {
        }

        @Override // android.arch.lifecycle.ReportFragment.ActivityInitializationListener
        public void onStart() {
            ProcessLifecycleOwner.this.activityStarted();
        }

        @Override // android.arch.lifecycle.ReportFragment.ActivityInitializationListener
        public void onResume() {
            ProcessLifecycleOwner.this.activityResumed();
        }
    };
    private boolean mPauseSent = true;
    private final LifecycleRegistry mRegistry = new LifecycleRegistry(this);
    private int mResumedCounter = 0;
    private int mStartedCounter = 0;
    private boolean mStopSent = true;

    static void init(Context context) {
        sInstance.attach(context);
    }

    /* access modifiers changed from: package-private */
    public void activityStarted() {
        this.mStartedCounter++;
        if (this.mStartedCounter == 1 && this.mStopSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
            this.mStopSent = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void activityResumed() {
        this.mResumedCounter++;
        if (this.mResumedCounter != 1) {
            return;
        }
        if (this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
            this.mPauseSent = false;
            return;
        }
        this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
    }

    /* access modifiers changed from: package-private */
    public void activityPaused() {
        this.mResumedCounter--;
        if (this.mResumedCounter == 0) {
            this.mHandler.postDelayed(this.mDelayedPauseRunnable, 700);
        }
    }

    /* access modifiers changed from: package-private */
    public void activityStopped() {
        this.mStartedCounter--;
        dispatchStopIfNeeded();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchPauseIfNeeded() {
        if (this.mResumedCounter == 0) {
            this.mPauseSent = true;
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dispatchStopIfNeeded() {
        if (this.mStartedCounter == 0 && this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
            this.mStopSent = true;
        }
    }

    private ProcessLifecycleOwner() {
    }

    /* access modifiers changed from: package-private */
    public void attach(Context context) {
        this.mHandler = new Handler();
        this.mRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() { // from class: android.arch.lifecycle.ProcessLifecycleOwner.3
            @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ReportFragment.get(activity).setProcessListener(ProcessLifecycleOwner.this.mInitializationListener);
            }

            @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner.this.activityPaused();
            }

            @Override // android.arch.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ProcessLifecycleOwner.this.activityStopped();
            }
        });
    }

    @Override // android.arch.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}

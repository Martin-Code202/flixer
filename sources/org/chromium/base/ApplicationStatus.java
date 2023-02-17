package org.chromium.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.chromium.base.annotations.CalledByNative;
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled = (!ApplicationStatus.class.desiredAssertionStatus());
    @SuppressLint({"StaticFieldLeak"})
    private static Activity sActivity;
    private static final Map<Activity, ActivityInfo> sActivityInfo = new ConcurrentHashMap();
    private static final ObserverList<ApplicationStateListener> sApplicationStateListeners = new ObserverList<>();
    @SuppressLint({"SupportAnnotationUsage"})
    private static Integer sCachedApplicationState;
    private static final Object sCachedApplicationStateLock = new Object();
    private static final ObserverList<Object> sGeneralActivityStateListeners = new ObserverList<>();
    private static ApplicationStateListener sNativeApplicationStateListener;

    public interface ApplicationStateListener {
    }

    private static native void nativeOnApplicationStateChange(int i);

    /* access modifiers changed from: package-private */
    public static class ActivityInfo {
        private ObserverList<Object> mListeners = new ObserverList<>();
        private int mStatus = 6;

        private ActivityInfo() {
        }

        public int getStatus() {
            return this.mStatus;
        }
    }

    private ApplicationStatus() {
    }

    public static Activity getLastTrackedFocusedActivity() {
        return sActivity;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (sCachedApplicationStateLock) {
            if (sCachedApplicationState == null) {
                sCachedApplicationState = Integer.valueOf(determineApplicationState());
            }
            intValue = sCachedApplicationState.intValue();
        }
        return intValue;
    }

    public static void registerApplicationStateListener(ApplicationStateListener applicationStateListener) {
        sApplicationStateListeners.addObserver(applicationStateListener);
    }

    public static void unregisterApplicationStateListener(ApplicationStateListener applicationStateListener) {
        sApplicationStateListeners.removeObserver(applicationStateListener);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: org.chromium.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.sNativeApplicationStateListener == null) {
                    ApplicationStateListener unused = ApplicationStatus.sNativeApplicationStateListener = new ApplicationStateListener() { // from class: org.chromium.base.ApplicationStatus.3.1
                    };
                    ApplicationStatus.registerApplicationStateListener(ApplicationStatus.sNativeApplicationStateListener);
                }
            }
        });
    }

    private static int determineApplicationState() {
        boolean z = false;
        boolean z2 = false;
        for (ActivityInfo activityInfo : sActivityInfo.values()) {
            int status = activityInfo.getStatus();
            if (!(status == 4 || status == 5 || status == 6)) {
                return 1;
            }
            if (status == 4) {
                z = true;
            } else if (status == 5) {
                z2 = true;
            }
        }
        if (z) {
            return 2;
        }
        if (z2) {
            return 3;
        }
        return 4;
    }
}

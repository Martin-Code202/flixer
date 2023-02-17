package org.chromium.net;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
public class AndroidCellularSignalStrength {
    private static final AndroidCellularSignalStrength sInstance = new AndroidCellularSignalStrength();
    private volatile int mSignalLevel = Integer.MIN_VALUE;

    class CellStateListener extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {
        private final TelephonyManager mTelephonyManager = ((TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone"));

        CellStateListener() {
            ThreadUtils.assertOnBackgroundThread();
            if (this.mTelephonyManager.getSimState() == 5) {
                ApplicationStatus.registerApplicationStateListener(this);
                onApplicationStateChange(ApplicationStatus.getStateForApplication());
            }
        }

        private void register() {
            this.mTelephonyManager.listen(this, 256);
        }

        private void unregister() {
            AndroidCellularSignalStrength.this.mSignalLevel = Integer.MIN_VALUE;
            this.mTelephonyManager.listen(this, 0);
        }

        @Override // android.telephony.PhoneStateListener
        @TargetApi(23)
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (ApplicationStatus.getStateForApplication() == 1) {
                AndroidCellularSignalStrength.this.mSignalLevel = signalStrength.getLevel();
            }
        }

        public void onApplicationStateChange(int i) {
            if (i == 1) {
                register();
            } else if (i == 2) {
                unregister();
            }
        }
    }

    private AndroidCellularSignalStrength() {
        if (Build.VERSION.SDK_INT >= 23) {
            HandlerThread handlerThread = new HandlerThread("AndroidCellularSignalStrength");
            handlerThread.start();
            new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: org.chromium.net.AndroidCellularSignalStrength.1
                @Override // java.lang.Runnable
                public void run() {
                    new CellStateListener();
                }
            });
        }
    }

    @TargetApi(23)
    @CalledByNative
    private static int getSignalStrengthLevel() {
        return sInstance.mSignalLevel;
    }
}

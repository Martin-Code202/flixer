package org.chromium.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.chromium.base.annotations.CalledByNative;
public class PowerMonitor {
    static final /* synthetic */ boolean $assertionsDisabled = (!PowerMonitor.class.desiredAssertionStatus());
    private static PowerMonitor sInstance;
    private boolean mIsBatteryPower;

    private static native void nativeOnBatteryChargingChanged();

    public static void create() {
        ThreadUtils.assertOnUiThread();
        if (sInstance == null) {
            Context applicationContext = ContextUtils.getApplicationContext();
            sInstance = new PowerMonitor();
            Intent registerReceiver = applicationContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                onBatteryChargingChanged(registerReceiver);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            applicationContext.registerReceiver(new BroadcastReceiver() { // from class: org.chromium.base.PowerMonitor.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    PowerMonitor.onBatteryChargingChanged(intent);
                }
            }, intentFilter);
        }
    }

    private PowerMonitor() {
    }

    /* access modifiers changed from: private */
    public static void onBatteryChargingChanged(Intent intent) {
        if ($assertionsDisabled || sInstance != null) {
            int intExtra = intent.getIntExtra("plugged", -1);
            sInstance.mIsBatteryPower = (intExtra == 2 || intExtra == 1) ? false : true;
            nativeOnBatteryChargingChanged();
            return;
        }
        throw new AssertionError();
    }

    @CalledByNative
    private static boolean isBatteryPower() {
        if (sInstance == null) {
            create();
        }
        return sInstance.mIsBatteryPower;
    }
}

package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
public final class zzj {
    private static IntentFilter zzfyw = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzfyx;
    private static float zzfyy = Float.NaN;

    @TargetApi(20)
    public static int zzcm(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzfyw);
        boolean z = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return ((zzp.zzalj() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << 1) | (z ? 1 : 0);
    }

    public static synchronized float zzcn(Context context) {
        synchronized (zzj.class) {
            if (SystemClock.elapsedRealtime() - zzfyx >= 60000 || Float.isNaN(zzfyy)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzfyw);
                if (registerReceiver != null) {
                    zzfyy = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzfyx = SystemClock.elapsedRealtime();
                return zzfyy;
            }
            return zzfyy;
        }
    }
}

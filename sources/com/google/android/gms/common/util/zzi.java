package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
public final class zzi {
    private static Boolean zzfyt;
    private static Boolean zzfyu;
    private static Boolean zzfyv;

    @TargetApi(20)
    public static boolean zzci(Context context) {
        if (zzfyt == null) {
            zzfyt = Boolean.valueOf(zzp.zzalj() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzfyt.booleanValue();
    }

    @TargetApi(24)
    public static boolean zzcj(Context context) {
        return (!zzp.isAtLeastN() || zzck(context)) && zzci(context);
    }

    @TargetApi(21)
    public static boolean zzck(Context context) {
        if (zzfyu == null) {
            zzfyu = Boolean.valueOf(zzp.zzalk() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzfyu.booleanValue();
    }

    public static boolean zzcl(Context context) {
        if (zzfyv == null) {
            zzfyv = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzfyv.booleanValue();
    }
}

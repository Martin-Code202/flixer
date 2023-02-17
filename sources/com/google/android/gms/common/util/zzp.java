package com.google.android.gms.common.util;

import android.os.Build;
public final class zzp {
    public static boolean isAtLeastN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26 || "O".equals(Build.VERSION.CODENAME) || Build.VERSION.CODENAME.startsWith("OMR") || Build.VERSION.CODENAME.startsWith("ODR");
    }

    public static boolean zzale() {
        return Build.VERSION.SDK_INT >= 15;
    }

    public static boolean zzalf() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean zzalh() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean zzali() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean zzalj() {
        return Build.VERSION.SDK_INT >= 20;
    }

    public static boolean zzalk() {
        return Build.VERSION.SDK_INT >= 21;
    }
}

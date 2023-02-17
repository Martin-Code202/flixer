package com.google.android.gms.internal;

import android.os.Build;
public final class zzaoc {
    public static int version() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            zzaom.zzf("Invalid version number", Build.VERSION.SDK);
            return 0;
        }
    }
}

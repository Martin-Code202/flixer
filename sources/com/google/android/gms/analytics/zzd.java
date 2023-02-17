package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzaom;
public final class zzd {
    public static String zzah(int i) {
        return zzc("cd", i);
    }

    public static String zzaj(int i) {
        return zzc("cm", i);
    }

    public static String zzal(int i) {
        return zzc("pr", i);
    }

    public static String zzan(int i) {
        return zzc("promo", i);
    }

    public static String zzao(int i) {
        return zzc("pi", i);
    }

    public static String zzaq(int i) {
        return zzc("il", i);
    }

    private static String zzc(String str, int i) {
        if (i > 0) {
            return new StringBuilder(String.valueOf(str).length() + 11).append(str).append(i).toString();
        }
        zzaom.zzf("index out of range for prefix", str);
        return "";
    }
}

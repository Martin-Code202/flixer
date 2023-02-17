package com.google.android.gms.internal;

import com.google.android.gms.common.zze;
public final class zzamt {
    public static final String VERSION = String.valueOf(zze.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    public static final String zzdoe;

    static {
        String valueOf = String.valueOf(VERSION);
        zzdoe = valueOf.length() != 0 ? "ma".concat(valueOf) : new String("ma");
    }
}

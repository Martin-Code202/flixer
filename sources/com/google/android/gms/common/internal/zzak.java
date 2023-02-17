package com.google.android.gms.common.internal;
public final class zzak {
    private static int zzfvh = 15;
    private static final String zzfvi = null;
    private final String zzfvj;
    private final String zzfvk;

    public zzak(String str) {
        this(str, null);
    }

    private zzak(String str, String str2) {
        zzbp.zzb(str, "log tag cannot be null");
        zzbp.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zzfvj = str;
        this.zzfvk = null;
    }
}

package com.google.android.gms.internal;
public class zzbbw<T> {
    private static String READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzaqc = new Object();
    private static zzbcc zzfpx = null;
    private static int zzfpy = 0;
    private String zzbfe;
    private T zzbff;
    private T zzfpz = null;

    protected zzbbw(String str, T t) {
        this.zzbfe = str;
        this.zzbff = t;
    }

    public static zzbbw<Float> zza(String str, Float f) {
        return new zzbca(str, f);
    }

    public static zzbbw<Integer> zza(String str, Integer num) {
        return new zzbbz(str, num);
    }

    public static zzbbw<Long> zza(String str, Long l) {
        return new zzbby(str, l);
    }

    public static zzbbw<Boolean> zze(String str, boolean z) {
        return new zzbbx(str, Boolean.valueOf(z));
    }

    public static zzbbw<String> zzt(String str, String str2) {
        return new zzbcb(str, str2);
    }
}

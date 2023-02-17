package com.google.android.gms.cast.framework;

import com.google.android.gms.internal.zzayy;
import com.google.android.gms.internal.zzazx;
public class PrecacheManager {
    private final zzazx zzejc = new zzazx("PrecacheManager");
    private final SessionManager zzeoi;
    private final CastOptions zzeom;
    private final zzayy zzepp;

    public PrecacheManager(CastOptions castOptions, SessionManager sessionManager, zzayy zzayy) {
        this.zzeom = castOptions;
        this.zzeoi = sessionManager;
        this.zzepp = zzayy;
    }
}

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zzd;
public final class zzbad {
    public static final Object zzaje = new Object();
    private static final zzazx zzejm = new zzazx("RequestTracker");
    private final zzd zzasb;
    private long zzezv = -1;
    private long zzfda;
    private long zzfdb = 0;
    private zzbac zzfdc;

    public zzbad(zzd zzd, long j) {
        this.zzasb = zzd;
        this.zzfda = j;
    }

    private final void zzaes() {
        this.zzezv = -1;
        this.zzfdc = null;
        this.zzfdb = 0;
    }

    public final void clear() {
        synchronized (zzaje) {
            if (this.zzezv != -1) {
                zzaes();
            }
        }
    }

    public final boolean test(long j) {
        boolean z;
        synchronized (zzaje) {
            z = this.zzezv != -1 && this.zzezv == j;
        }
        return z;
    }

    public final void zza(long j, zzbac zzbac) {
        zzbac zzbac2;
        long j2;
        synchronized (zzaje) {
            zzbac2 = this.zzfdc;
            j2 = this.zzezv;
            this.zzezv = j;
            this.zzfdc = zzbac;
            this.zzfdb = this.zzasb.elapsedRealtime();
        }
        if (zzbac2 != null) {
            zzbac2.zzx(j2);
        }
    }

    public final boolean zzaet() {
        boolean z;
        synchronized (zzaje) {
            z = this.zzezv != -1;
        }
        return z;
    }

    public final boolean zzc(long j, int i, Object obj) {
        boolean z = false;
        zzbac zzbac = null;
        synchronized (zzaje) {
            if (this.zzezv != -1 && this.zzezv == j) {
                zzejm.zzb("request %d completed", Long.valueOf(this.zzezv));
                zzbac = this.zzfdc;
                zzaes();
                z = true;
            }
        }
        if (zzbac != null) {
            zzbac.zza(j, i, obj);
        }
        return z;
    }

    public final boolean zzd(long j, int i) {
        boolean z = false;
        zzbac zzbac = null;
        long j2 = 0;
        synchronized (zzaje) {
            if (this.zzezv != -1 && j - this.zzfdb >= this.zzfda) {
                zzejm.zzb("request %d timed out", Long.valueOf(this.zzezv));
                j2 = this.zzezv;
                zzbac = this.zzfdc;
                zzaes();
                z = true;
            }
        }
        if (zzbac != null) {
            zzbac.zza(j2, i, null);
        }
        return z;
    }
}

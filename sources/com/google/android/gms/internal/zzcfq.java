package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
/* access modifiers changed from: package-private */
public final class zzcfq {
    private long mStartTime;
    private final zzd zzasb;

    public zzcfq(zzd zzd) {
        zzbp.zzu(zzd);
        this.zzasb = zzd;
    }

    public final void clear() {
        this.mStartTime = 0;
    }

    public final void start() {
        this.mStartTime = this.zzasb.elapsedRealtime();
    }

    public final boolean zzu(long j) {
        return this.mStartTime == 0 || this.zzasb.elapsedRealtime() - this.mStartTime >= j;
    }
}

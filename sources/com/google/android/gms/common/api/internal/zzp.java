package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbp;
/* access modifiers changed from: package-private */
public final class zzp {
    private final int zzfix;
    private final ConnectionResult zzfiy;

    zzp(ConnectionResult connectionResult, int i) {
        zzbp.zzu(connectionResult);
        this.zzfiy = connectionResult;
        this.zzfix = i;
    }

    /* access modifiers changed from: package-private */
    public final int zzagc() {
        return this.zzfix;
    }

    /* access modifiers changed from: package-private */
    public final ConnectionResult zzagd() {
        return this.zzfiy;
    }
}

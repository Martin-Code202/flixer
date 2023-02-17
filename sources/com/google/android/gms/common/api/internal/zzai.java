package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
/* access modifiers changed from: package-private */
public final class zzai implements PendingResult.zza {
    private /* synthetic */ zzs zzflb;
    private /* synthetic */ zzah zzflc;

    zzai(zzah zzah, zzs zzs) {
        this.zzflc = zzah;
        this.zzflb = zzs;
    }

    @Override // com.google.android.gms.common.api.PendingResult.zza
    public final void zzq(Status status) {
        this.zzflc.zzfkz.remove(this.zzflb);
    }
}

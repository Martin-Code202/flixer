package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
final class zzbcw extends zzbcq {
    private final zzn<Status> zzfwh;

    public zzbcw(zzn<Status> zzn) {
        this.zzfwh = zzn;
    }

    @Override // com.google.android.gms.internal.zzbcq, com.google.android.gms.internal.zzbda
    public final void zzcg(int i) {
        this.zzfwh.setResult(new Status(i));
    }
}

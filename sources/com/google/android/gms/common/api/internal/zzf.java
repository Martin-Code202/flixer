package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
public final class zzf extends zzb<Boolean> {
    private zzcl<?> zzfig;

    public zzf(zzcl<?> zzcl, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zzfig = zzcl;
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zza
    public final /* bridge */ /* synthetic */ void zza(zzah zzah, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zzb
    public final void zzb(zzbr<?> zzbr) {
        zzcs remove = zzbr.zzahw().remove(this.zzfig);
        if (remove != null) {
            remove.zzfid.zzc(zzbr.zzagn(), this.zzdzb);
            remove.zzfic.zzaim();
            return;
        }
        this.zzdzb.trySetResult(false);
    }

    @Override // com.google.android.gms.common.api.internal.zzb, com.google.android.gms.common.api.internal.zza
    public final /* bridge */ /* synthetic */ void zzr(Status status) {
        super.zzr(status);
    }
}

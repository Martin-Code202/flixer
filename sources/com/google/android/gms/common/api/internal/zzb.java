package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
abstract class zzb<T> extends zza {
    protected final TaskCompletionSource<T> zzdzb;

    public zzb(int i, TaskCompletionSource<T> taskCompletionSource) {
        super(i);
        this.zzdzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zza
    public void zza(zzah zzah, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zza
    public final void zza(zzbr<?> zzbr) {
        try {
            zzb(zzbr);
        } catch (DeadObjectException e) {
            zzr(zza.zza(e));
            throw e;
        } catch (RemoteException e2) {
            zzr(zza.zza(e2));
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzb(zzbr<?> zzbr);

    @Override // com.google.android.gms.common.api.internal.zza
    public void zzr(Status status) {
        this.zzdzb.trySetException(new ApiException(status));
    }
}

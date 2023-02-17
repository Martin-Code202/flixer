package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbp;
public abstract class zzm<R extends Result, A extends Api.zzb> extends zzs<R> implements zzn<R> {
    private final Api<?> zzfdf;
    private final Api.zzc<A> zzfiu;

    protected zzm(Api<?> api, GoogleApiClient googleApiClient) {
        super((GoogleApiClient) zzbp.zzb(googleApiClient, "GoogleApiClient must not be null"));
        this.zzfiu = (Api.zzc<A>) api.zzafe();
        this.zzfdf = api;
    }

    private final void zzc(RemoteException remoteException) {
        zzt(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.common.api.internal.zzm<R extends com.google.android.gms.common.api.Result, A extends com.google.android.gms.common.api.Api$zzb> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.zzn
    public /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzm<R, A>) ((Result) obj));
    }

    public abstract void zza(A a);

    public final Api.zzc<A> zzafe() {
        return this.zzfiu;
    }

    public final Api<?> zzafj() {
        return this.zzfdf;
    }

    public final void zzb(A a) {
        try {
            zza((zzm<R, A>) a);
        } catch (DeadObjectException e) {
            zzc(e);
            throw e;
        } catch (RemoteException e2) {
            zzc(e2);
        }
    }

    public final void zzt(Status status) {
        zzbp.zzb(!status.isSuccess(), "Failed result must not be success");
        setResult((zzm<R, A>) zzb(status));
    }
}

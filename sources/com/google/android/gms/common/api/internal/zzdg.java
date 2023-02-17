package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzbp;
import java.lang.ref.WeakReference;
public final class zzdg<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private final Object zzfje;
    private final WeakReference<GoogleApiClient> zzfjg;
    private ResultTransform<? super R, ? extends Result> zzfpg;
    private zzdg<? extends Result> zzfph;
    private volatile ResultCallbacks<? super R> zzfpi;
    private PendingResult<R> zzfpj;
    private Status zzfpk;
    private final zzdi zzfpl;
    private boolean zzfpm;

    private final void zzaio() {
        if (this.zzfpg != null || this.zzfpi != null) {
            GoogleApiClient googleApiClient = this.zzfjg.get();
            if (!(this.zzfpm || this.zzfpg == null || googleApiClient == null)) {
                googleApiClient.zza(this);
                this.zzfpm = true;
            }
            if (this.zzfpk != null) {
                zzw(this.zzfpk);
            } else if (this.zzfpj != null) {
                this.zzfpj.setResultCallback(this);
            }
        }
    }

    private final boolean zzaiq() {
        return (this.zzfpi == null || this.zzfjg.get() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(Status status) {
        synchronized (this.zzfje) {
            this.zzfpk = status;
            zzw(this.zzfpk);
        }
    }

    private final void zzw(Status status) {
        synchronized (this.zzfje) {
            if (this.zzfpg != null) {
                Status onFailure = this.zzfpg.onFailure(status);
                zzbp.zzb(onFailure, "onFailure must not return null");
                this.zzfph.zzd(onFailure);
            } else if (zzaiq()) {
                this.zzfpi.onFailure(status);
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(R r) {
        synchronized (this.zzfje) {
            if (!r.getStatus().isSuccess()) {
                zzd(r.getStatus());
                zzd(r);
            } else if (this.zzfpg != null) {
                zzct.zzahn().submit(new zzdh(this, r));
            } else if (zzaiq()) {
                this.zzfpi.onSuccess(r);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.android.gms.common.api.PendingResult<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(PendingResult<?> pendingResult) {
        synchronized (this.zzfje) {
            this.zzfpj = pendingResult;
            zzaio();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzaip() {
        this.zzfpi = null;
    }
}

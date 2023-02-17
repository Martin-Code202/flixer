package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzby;
public final class zzao implements zzbk {
    private final zzbl zzflg;
    private boolean zzflh = false;

    public zzao(zzbl zzbl) {
        this.zzflg = zzbl;
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void begin() {
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void connect() {
        if (this.zzflh) {
            this.zzflh = false;
            this.zzflg.zza(new zzaq(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final boolean disconnect() {
        if (this.zzflh) {
            return false;
        }
        if (this.zzflg.zzfjt.zzahj()) {
            this.zzflh = true;
            for (zzdg zzdg : this.zzflg.zzfjt.zzfmr) {
                zzdg.zzaip();
            }
            return false;
        }
        this.zzflg.zzg(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void onConnectionSuspended(int i) {
        this.zzflg.zzg(null);
        this.zzflg.zzfnf.zzf(i, this.zzflh);
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    /* access modifiers changed from: package-private */
    public final void zzagy() {
        if (this.zzflh) {
            this.zzflh = false;
            this.zzflg.zzfjt.zzfms.release();
            disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T zzd(T t) {
        return (T) zze(t);
    }

    @Override // com.google.android.gms.common.api.internal.zzbk
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T zze(T t) {
        try {
            this.zzflg.zzfjt.zzfms.zzb(t);
            Api.zze zze = this.zzflg.zzfjt.zzfmm.get(t.zzafe());
            zzbp.zzb(zze, "Appropriate Api was not requested.");
            if (zze.isConnected() || !this.zzflg.zzfnb.containsKey(t.zzafe())) {
                t.zzb(zze instanceof zzby ? zzby.zzakp() : zze);
                return t;
            }
            t.zzt(new Status(17));
            return t;
        } catch (DeadObjectException unused) {
            this.zzflg.zza(new zzap(this, this));
        }
    }
}

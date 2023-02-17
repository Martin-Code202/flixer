package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzam;
import com.google.android.gms.common.internal.zzj;
import java.util.Set;
/* access modifiers changed from: package-private */
public final class zzbv implements zzcy, zzj {
    private Set<Scope> zzecl = null;
    private final zzh<?> zzfgr;
    private final Api.zze zzfkg;
    private zzam zzfls = null;
    final /* synthetic */ zzbp zzfnt;
    private boolean zzfoe = false;

    public zzbv(zzbp zzbp, Api.zze zze, zzh<?> zzh) {
        this.zzfnt = zzbp;
        this.zzfkg = zze;
        this.zzfgr = zzh;
    }

    /* access modifiers changed from: private */
    public final void zzaid() {
        if (this.zzfoe && this.zzfls != null) {
            this.zzfkg.zza(this.zzfls, this.zzecl);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcy
    public final void zzb(zzam zzam, Set<Scope> set) {
        if (zzam == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zzh(new ConnectionResult(4));
            return;
        }
        this.zzfls = zzam;
        this.zzecl = set;
        zzaid();
    }

    @Override // com.google.android.gms.common.internal.zzj
    public final void zzf(ConnectionResult connectionResult) {
        this.zzfnt.mHandler.post(new zzbw(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zzcy
    public final void zzh(ConnectionResult connectionResult) {
        ((zzbr) this.zzfnt.zzfkj.get(this.zzfgr)).zzh(connectionResult);
    }
}

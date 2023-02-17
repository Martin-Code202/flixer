package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
public final class zzk extends zzaw {
    private zzd zzftm;
    private final int zzftn;

    public zzk(zzd zzd, int i) {
        this.zzftm = zzd;
        this.zzftn = i;
    }

    @Override // com.google.android.gms.common.internal.zzav
    public final void zza(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.zzav
    public final void zza(int i, IBinder iBinder, Bundle bundle) {
        zzbp.zzb(this.zzftm, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zzftm.zza(i, iBinder, bundle, this.zzftn);
        this.zzftm = null;
    }
}

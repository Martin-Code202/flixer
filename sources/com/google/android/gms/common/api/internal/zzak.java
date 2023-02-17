package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;
public class zzak extends zzo {
    private zzbp zzfgu;
    private final ArraySet<zzh<?>> zzfld;

    private final void zzagw() {
        if (!this.zzfld.isEmpty()) {
            this.zzfgu.zza(this);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onResume() {
        super.onResume();
        zzagw();
    }

    @Override // com.google.android.gms.common.api.internal.zzo, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStart() {
        super.onStart();
        zzagw();
    }

    @Override // com.google.android.gms.common.api.internal.zzo, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        super.onStop();
        this.zzfgu.zzb(this);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzo
    public final void zza(ConnectionResult connectionResult, int i) {
        this.zzfgu.zza(connectionResult, i);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzo
    public final void zzafw() {
        this.zzfgu.zzafw();
    }

    /* access modifiers changed from: package-private */
    public final ArraySet<zzh<?>> zzagv() {
        return this.zzfld;
    }
}

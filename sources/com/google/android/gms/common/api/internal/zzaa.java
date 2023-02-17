package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
/* access modifiers changed from: package-private */
public final class zzaa implements zzce {
    private /* synthetic */ zzy zzfkf;

    private zzaa(zzy zzy) {
        this.zzfkf = zzy;
    }

    /* synthetic */ zzaa(zzy zzy, zzz zzz) {
        this(zzy);
    }

    @Override // com.google.android.gms.common.api.internal.zzce
    public final void zzc(ConnectionResult connectionResult) {
        this.zzfkf.zzfkd.lock();
        try {
            this.zzfkf.zzfka = connectionResult;
            this.zzfkf.zzagj();
        } finally {
            this.zzfkf.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzce
    public final void zzf(int i, boolean z) {
        this.zzfkf.zzfkd.lock();
        try {
            if ((this.zzfkf.zzfkc) || this.zzfkf.zzfkb == null || !this.zzfkf.zzfkb.isSuccess()) {
                this.zzfkf.zzfkc = false;
                this.zzfkf.zze(i, z);
                return;
            }
            this.zzfkf.zzfkc = true;
            this.zzfkf.zzfjv.onConnectionSuspended(i);
            this.zzfkf.zzfkd.unlock();
        } finally {
            this.zzfkf.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzce
    public final void zzj(Bundle bundle) {
        this.zzfkf.zzfkd.lock();
        try {
            this.zzfkf.zzi(bundle);
            this.zzfkf.zzfka = ConnectionResult.zzffe;
            this.zzfkf.zzagj();
        } finally {
            this.zzfkf.zzfkd.unlock();
        }
    }
}

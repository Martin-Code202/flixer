package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
/* access modifiers changed from: package-private */
public final class zzab implements zzce {
    private /* synthetic */ zzy zzfkf;

    private zzab(zzy zzy) {
        this.zzfkf = zzy;
    }

    /* synthetic */ zzab(zzy zzy, zzz zzz) {
        this(zzy);
    }

    @Override // com.google.android.gms.common.api.internal.zzce
    public final void zzc(ConnectionResult connectionResult) {
        this.zzfkf.zzfkd.lock();
        try {
            this.zzfkf.zzfkb = connectionResult;
            this.zzfkf.zzagj();
        } finally {
            this.zzfkf.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzce
    public final void zzf(int i, boolean z) {
        this.zzfkf.zzfkd.lock();
        try {
            if (this.zzfkf.zzfkc) {
                this.zzfkf.zzfkc = false;
                this.zzfkf.zze(i, z);
                return;
            }
            this.zzfkf.zzfkc = true;
            this.zzfkf.zzfju.onConnectionSuspended(i);
            this.zzfkf.zzfkd.unlock();
        } finally {
            this.zzfkf.zzfkd.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzce
    public final void zzj(Bundle bundle) {
        this.zzfkf.zzfkd.lock();
        try {
            this.zzfkf.zzfkb = ConnectionResult.zzffe;
            this.zzfkf.zzagj();
        } finally {
            this.zzfkf.zzfkd.unlock();
        }
    }
}

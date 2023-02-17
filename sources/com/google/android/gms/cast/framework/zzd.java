package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
public final class zzd extends zzo {
    private final CastStateListener zzepg;

    public zzd(CastStateListener castStateListener) {
        this.zzepg = castStateListener;
    }

    @Override // com.google.android.gms.cast.framework.zzn
    public final void onCastStateChanged(int i) {
        this.zzepg.onCastStateChanged(i);
    }

    @Override // com.google.android.gms.cast.framework.zzn
    public final IObjectWrapper zzabs() {
        return zzn.zzw(this.zzepg);
    }
}

package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzazx;
public final class zze {
    private static final zzazx zzejc = new zzazx("DiscoveryManager");
    private final zzp zzeph;

    zze(zzp zzp) {
        this.zzeph = zzp;
    }

    public final IObjectWrapper zzabu() {
        try {
            return this.zzeph.zzaca();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "getWrappedThis", zzp.class.getSimpleName());
            return null;
        }
    }
}

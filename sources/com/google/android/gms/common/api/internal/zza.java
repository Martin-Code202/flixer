package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zzp;
public abstract class zza {
    private int zzecy;

    public zza(int i) {
        this.zzecy = i;
    }

    /* access modifiers changed from: private */
    public static Status zza(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (zzp.zzale() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void zza(zzah zzah, boolean z);

    public abstract void zza(zzbr<?> zzbr);

    public abstract void zzr(Status status);
}

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
public final class zza extends zzan {
    public static Account zza(zzam zzam) {
        if (zzam == null) {
            return null;
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return zzam.getAccount();
        } catch (RemoteException unused) {
            Log.w("AccountAccessor", "Remote account accessor probably died");
            return null;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.common.internal.zzam
    public final Account getAccount() {
        throw new NoSuchMethodError();
    }
}

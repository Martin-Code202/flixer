package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzao extends zzeb implements zzam {
    zzao(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // com.google.android.gms.common.internal.zzam
    public final Account getAccount() {
        Parcel zza = zza(2, zzax());
        Account account = (Account) zzed.zza(zza, Account.CREATOR);
        zza.recycle();
        return account;
    }
}

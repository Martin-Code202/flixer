package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzbcl;
public final class zzz implements Parcelable.Creator<zzy> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzy createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        zzc[] zzcArr = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 3:
                    i3 = zzbcl.zzg(parcel, readInt);
                    break;
                case 4:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 5:
                    iBinder = zzbcl.zzr(parcel, readInt);
                    break;
                case 6:
                    scopeArr = (Scope[]) zzbcl.zzb(parcel, readInt, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zzbcl.zzs(parcel, readInt);
                    break;
                case 8:
                    account = (Account) zzbcl.zza(parcel, readInt, Account.CREATOR);
                    break;
                case 9:
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
                case 10:
                    zzcArr = (zzc[]) zzbcl.zzb(parcel, readInt, zzc.CREATOR);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzy(i, i2, i3, str, iBinder, scopeArr, bundle, account, zzcArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzy[] newArray(int i) {
        return new zzy[i];
    }
}

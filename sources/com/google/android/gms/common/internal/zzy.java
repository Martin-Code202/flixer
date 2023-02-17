package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public final class zzy extends zzbck {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();
    private int version;
    private int zzfub;
    private int zzfuc;
    String zzfud;
    IBinder zzfue;
    Scope[] zzfuf;
    Bundle zzfug;
    Account zzfuh;
    zzc[] zzfui;

    public zzy(int i) {
        this.version = 3;
        this.zzfuc = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzfub = i;
    }

    zzy(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, zzc[] zzcArr) {
        zzam zzam;
        this.version = i;
        this.zzfub = i2;
        this.zzfuc = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzfud = "com.google.android.gms";
        } else {
            this.zzfud = str;
        }
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                if (iBinder == null) {
                    zzam = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                    zzam = queryLocalInterface instanceof zzam ? (zzam) queryLocalInterface : new zzao(iBinder);
                }
                account2 = zza.zza(zzam);
            }
            this.zzfuh = account2;
        } else {
            this.zzfue = iBinder;
            this.zzfuh = account;
        }
        this.zzfuf = scopeArr;
        this.zzfug = bundle;
        this.zzfui = zzcArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.version);
        zzbcn.zzc(parcel, 2, this.zzfub);
        zzbcn.zzc(parcel, 3, this.zzfuc);
        zzbcn.zza(parcel, 4, this.zzfud, false);
        zzbcn.zza(parcel, 5, this.zzfue, false);
        zzbcn.zza(parcel, 6, (Parcelable[]) this.zzfuf, i, false);
        zzbcn.zza(parcel, 7, this.zzfug, false);
        zzbcn.zza(parcel, 8, (Parcelable) this.zzfuh, i, false);
        zzbcn.zza(parcel, 10, (Parcelable[]) this.zzfui, i, false);
        zzbcn.zzai(parcel, zze);
    }
}

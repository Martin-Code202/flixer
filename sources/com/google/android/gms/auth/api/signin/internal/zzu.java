package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzu extends zzeb implements zzt {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzt
    public final void zzc(zzr zzr, GoogleSignInOptions googleSignInOptions) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzr);
        zzed.zza(zzax, googleSignInOptions);
        zzb(103, zzax);
    }
}

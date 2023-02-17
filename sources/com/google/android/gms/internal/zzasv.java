package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
public final class zzasv extends zzeb implements zzasu {
    zzasv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // com.google.android.gms.internal.zzasu
    public final void zza(zzass zzass, CredentialRequest credentialRequest) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzass);
        zzed.zza(zzax, credentialRequest);
        zzb(1, zzax);
    }

    @Override // com.google.android.gms.internal.zzasu
    public final void zza(zzass zzass, zzasw zzasw) {
        Parcel zzax = zzax();
        zzed.zza(zzax, zzass);
        zzed.zza(zzax, zzasw);
        zzb(2, zzax);
    }
}

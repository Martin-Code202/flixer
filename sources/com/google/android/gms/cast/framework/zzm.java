package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzm extends zzeb implements zzl {
    zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastSession");
    }

    @Override // com.google.android.gms.cast.framework.zzl
    public final void onConnected(Bundle bundle) {
        Parcel zzax = zzax();
        zzed.zza(zzax, bundle);
        zzb(1, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzl
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Parcel zzax = zzax();
        zzed.zza(zzax, connectionResult);
        zzb(3, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzl
    public final void onConnectionSuspended(int i) {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(2, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzl
    public final void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
        Parcel zzax = zzax();
        zzed.zza(zzax, applicationMetadata);
        zzax.writeString(str);
        zzax.writeString(str2);
        zzed.zza(zzax, z);
        zzb(4, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzl
    public final void zzb(boolean z, int i) {
        Parcel zzax = zzax();
        zzed.zza(zzax, z);
        zzax.writeInt(0);
        zzb(6, zzax);
    }

    @Override // com.google.android.gms.cast.framework.zzl
    public final void zzbe(int i) {
        Parcel zzax = zzax();
        zzax.writeInt(i);
        zzb(5, zzax);
    }
}

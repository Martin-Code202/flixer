package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbcl;
public final class zzbt implements Parcelable.Creator<zzbs> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbs createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    iBinder = zzbcl.zzr(parcel, readInt);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) zzbcl.zza(parcel, readInt, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbcl.zzc(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzbs(i, iBinder, connectionResult, z, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbs[] newArray(int i) {
        return new zzbs[i];
    }
}

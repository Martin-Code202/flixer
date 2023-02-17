package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbs;
public final class zzcqg implements Parcelable.Creator<zzcqf> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcqf createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        zzbs zzbs = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    connectionResult = (ConnectionResult) zzbcl.zza(parcel, readInt, ConnectionResult.CREATOR);
                    break;
                case 3:
                    zzbs = (zzbs) zzbcl.zza(parcel, readInt, zzbs.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzcqf(i, connectionResult, zzbs);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcqf[] newArray(int i) {
        return new zzcqf[i];
    }
}

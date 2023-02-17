package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.List;
public final class zzbzz implements Parcelable.Creator<zzbzy> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbzy createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        LocationRequest locationRequest = null;
        List<zzbyk> list = zzbzy.zzhzt;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    locationRequest = (LocationRequest) zzbcl.zza(parcel, readInt, LocationRequest.CREATOR);
                    break;
                case 2:
                case 3:
                case 4:
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
                case 5:
                    list = zzbcl.zzc(parcel, readInt, zzbyk.CREATOR);
                    break;
                case 6:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 7:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 8:
                    z2 = zzbcl.zzc(parcel, readInt);
                    break;
                case 9:
                    z3 = zzbcl.zzc(parcel, readInt);
                    break;
                case 10:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzbzy(locationRequest, list, str, z, z2, z3, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbzy[] newArray(int i) {
        return new zzbzy[i];
    }
}

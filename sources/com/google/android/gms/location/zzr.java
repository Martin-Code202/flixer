package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
import java.util.List;
public final class zzr implements Parcelable.Creator<LocationResult> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        List<Location> list = LocationResult.zzhyb;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    list = zzbcl.zzc(parcel, readInt, Location.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new LocationResult(list);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationResult[] newArray(int i) {
        return new LocationResult[i];
    }
}

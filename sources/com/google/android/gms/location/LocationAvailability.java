package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
public final class LocationAvailability extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new zzp();
    @Deprecated
    private int zzhxr;
    @Deprecated
    private int zzhxs;
    private long zzhxt;
    private int zzhxu;
    private zzy[] zzhxv;

    LocationAvailability(int i, int i2, int i3, long j, zzy[] zzyArr) {
        this.zzhxu = i;
        this.zzhxr = i2;
        this.zzhxs = i3;
        this.zzhxt = j;
        this.zzhxv = zzyArr;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.zzhxr == locationAvailability.zzhxr && this.zzhxs == locationAvailability.zzhxs && this.zzhxt == locationAvailability.zzhxt && this.zzhxu == locationAvailability.zzhxu && Arrays.equals(this.zzhxv, locationAvailability.zzhxv);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzhxu), Integer.valueOf(this.zzhxr), Integer.valueOf(this.zzhxs), Long.valueOf(this.zzhxt), this.zzhxv});
    }

    public final boolean isLocationAvailable() {
        return this.zzhxu < 1000;
    }

    @Override // java.lang.Object
    public final String toString() {
        return new StringBuilder(48).append("LocationAvailability[isLocationAvailable: ").append(isLocationAvailable()).append("]").toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzhxr);
        zzbcn.zzc(parcel, 2, this.zzhxs);
        zzbcn.zza(parcel, 3, this.zzhxt);
        zzbcn.zzc(parcel, 4, this.zzhxu);
        zzbcn.zza(parcel, 5, (Parcelable[]) this.zzhxv, i, false);
        zzbcn.zzai(parcel, zze);
    }
}

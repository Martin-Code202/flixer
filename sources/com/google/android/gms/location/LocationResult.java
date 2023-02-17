package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public final class LocationResult extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzr();
    static final List<Location> zzhyb = Collections.emptyList();
    private final List<Location> zzhyc;

    LocationResult(List<Location> list) {
        this.zzhyc = list;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.zzhyc.size() != this.zzhyc.size()) {
            return false;
        }
        Iterator<Location> it = this.zzhyc.iterator();
        for (Location location : locationResult.zzhyc) {
            if (it.next().getTime() != location.getTime()) {
                return false;
            }
        }
        return true;
    }

    public final List<Location> getLocations() {
        return this.zzhyc;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        int i = 17;
        for (Location location : this.zzhyc) {
            long time = location.getTime();
            i = (i * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i;
    }

    @Override // java.lang.Object
    public final String toString() {
        String valueOf = String.valueOf(this.zzhyc);
        return new StringBuilder(String.valueOf(valueOf).length() + 27).append("LocationResult[locations: ").append(valueOf).append("]").toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, getLocations(), false);
        zzbcn.zzai(parcel, zze);
    }
}

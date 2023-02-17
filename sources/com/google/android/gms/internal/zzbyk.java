package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbf;
public final class zzbyk extends zzbck {
    public static final Parcelable.Creator<zzbyk> CREATOR = new zzbyl();
    private String packageName;
    private int uid;

    public zzbyk(int i, String str) {
        this.uid = i;
        this.packageName = str;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbyk)) {
            return false;
        }
        zzbyk zzbyk = (zzbyk) obj;
        return zzbyk.uid == this.uid && zzbf.equal(zzbyk.packageName, this.packageName);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.uid;
    }

    @Override // java.lang.Object
    public final String toString() {
        return String.format("%d:%s", Integer.valueOf(this.uid), this.packageName);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.uid);
        zzbcn.zza(parcel, 2, this.packageName, false);
        zzbcn.zzai(parcel, zze);
    }
}

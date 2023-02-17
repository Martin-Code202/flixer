package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
public final class zzy extends zzbck {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();
    private int zzhys;
    private int zzhyt;
    private long zzhyu;
    private long zzhyv;

    zzy(int i, int i2, long j, long j2) {
        this.zzhys = i;
        this.zzhyt = i2;
        this.zzhyu = j;
        this.zzhyv = j2;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzy zzy = (zzy) obj;
        return this.zzhys == zzy.zzhys && this.zzhyt == zzy.zzhyt && this.zzhyu == zzy.zzhyu && this.zzhyv == zzy.zzhyv;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzhyt), Integer.valueOf(this.zzhys), Long.valueOf(this.zzhyv), Long.valueOf(this.zzhyu)});
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder sb = new StringBuilder("NetworkLocationStatus:");
        sb.append(" Wifi status: ").append(this.zzhys).append(" Cell status: ").append(this.zzhyt).append(" elapsed time NS: ").append(this.zzhyv).append(" system time ms: ").append(this.zzhyu);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzhys);
        zzbcn.zzc(parcel, 2, this.zzhyt);
        zzbcn.zza(parcel, 3, this.zzhyu);
        zzbcn.zza(parcel, 4, this.zzhyv);
        zzbcn.zzai(parcel, zze);
    }
}

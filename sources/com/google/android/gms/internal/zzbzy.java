package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
public final class zzbzy extends zzbck {
    public static final Parcelable.Creator<zzbzy> CREATOR = new zzbzz();
    static final List<zzbyk> zzhzt = Collections.emptyList();
    private String mTag;
    private String zzefs;
    private LocationRequest zzgzs;
    private List<zzbyk> zzhzu;
    private boolean zzhzv;
    private boolean zzhzw;
    private boolean zzhzx;
    private boolean zzhzy = true;

    zzbzy(LocationRequest locationRequest, List<zzbyk> list, String str, boolean z, boolean z2, boolean z3, String str2) {
        this.zzgzs = locationRequest;
        this.zzhzu = list;
        this.mTag = str;
        this.zzhzv = z;
        this.zzhzw = z2;
        this.zzhzx = z3;
        this.zzefs = str2;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbzy)) {
            return false;
        }
        zzbzy zzbzy = (zzbzy) obj;
        return zzbf.equal(this.zzgzs, zzbzy.zzgzs) && zzbf.equal(this.zzhzu, zzbzy.zzhzu) && zzbf.equal(this.mTag, zzbzy.mTag) && this.zzhzv == zzbzy.zzhzv && this.zzhzw == zzbzy.zzhzw && this.zzhzx == zzbzy.zzhzx && zzbf.equal(this.zzefs, zzbzy.zzefs);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.zzgzs.hashCode();
    }

    @Override // java.lang.Object
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzgzs.toString());
        if (this.mTag != null) {
            sb.append(" tag=").append(this.mTag);
        }
        if (this.zzefs != null) {
            sb.append(" moduleId=").append(this.zzefs);
        }
        sb.append(" hideAppOps=").append(this.zzhzv);
        sb.append(" clients=").append(this.zzhzu);
        sb.append(" forceCoarseLocation=").append(this.zzhzw);
        if (this.zzhzx) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 1, (Parcelable) this.zzgzs, i, false);
        zzbcn.zzc(parcel, 5, this.zzhzu, false);
        zzbcn.zza(parcel, 6, this.mTag, false);
        zzbcn.zza(parcel, 7, this.zzhzv);
        zzbcn.zza(parcel, 8, this.zzhzw);
        zzbcn.zza(parcel, 9, this.zzhzx);
        zzbcn.zza(parcel, 10, this.zzefs, false);
        zzbcn.zzai(parcel, zze);
    }
}

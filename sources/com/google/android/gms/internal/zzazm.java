package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import java.util.Arrays;
public final class zzazm extends zzbck {
    public static final Parcelable.Creator<zzazm> CREATOR = new zzazn();
    private double zzely;
    private boolean zzelz;
    private int zzfbb;
    private int zzfbc;
    private ApplicationMetadata zzfbm;

    public zzazm() {
        this(Double.NaN, false, -1, null, -1);
    }

    zzazm(double d, boolean z, int i, ApplicationMetadata applicationMetadata, int i2) {
        this.zzely = d;
        this.zzelz = z;
        this.zzfbb = i;
        this.zzfbm = applicationMetadata;
        this.zzfbc = i2;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzazm)) {
            return false;
        }
        zzazm zzazm = (zzazm) obj;
        return this.zzely == zzazm.zzely && this.zzelz == zzazm.zzelz && this.zzfbb == zzazm.zzfbb && zzazl.zza(this.zzfbm, zzazm.zzfbm) && this.zzfbc == zzazm.zzfbc;
    }

    public final int getActiveInputState() {
        return this.zzfbb;
    }

    public final ApplicationMetadata getApplicationMetadata() {
        return this.zzfbm;
    }

    public final int getStandbyState() {
        return this.zzfbc;
    }

    public final double getVolume() {
        return this.zzely;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Double.valueOf(this.zzely), Boolean.valueOf(this.zzelz), Integer.valueOf(this.zzfbb), this.zzfbm, Integer.valueOf(this.zzfbc)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, this.zzely);
        zzbcn.zza(parcel, 3, this.zzelz);
        zzbcn.zzc(parcel, 4, this.zzfbb);
        zzbcn.zza(parcel, 5, (Parcelable) this.zzfbm, i, false);
        zzbcn.zzc(parcel, 6, this.zzfbc);
        zzbcn.zzai(parcel, zze);
    }

    public final boolean zzaeo() {
        return this.zzelz;
    }
}

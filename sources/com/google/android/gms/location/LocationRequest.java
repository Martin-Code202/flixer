package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
public final class LocationRequest extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzq();
    private int mPriority;
    private boolean zzgzu;
    private long zzhxf;
    private long zzhxw;
    private long zzhxx;
    private int zzhxy;
    private float zzhxz;
    private long zzhya;

    public LocationRequest() {
        this.mPriority = 102;
        this.zzhxw = 3600000;
        this.zzhxx = 600000;
        this.zzgzu = false;
        this.zzhxf = Long.MAX_VALUE;
        this.zzhxy = Integer.MAX_VALUE;
        this.zzhxz = 0.0f;
        this.zzhya = 0;
    }

    LocationRequest(int i, long j, long j2, boolean z, long j3, int i2, float f, long j4) {
        this.mPriority = i;
        this.zzhxw = j;
        this.zzhxx = j2;
        this.zzgzu = z;
        this.zzhxf = j3;
        this.zzhxy = i2;
        this.zzhxz = f;
        this.zzhya = j4;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.mPriority == locationRequest.mPriority && this.zzhxw == locationRequest.zzhxw && this.zzhxx == locationRequest.zzhxx && this.zzgzu == locationRequest.zzgzu && this.zzhxf == locationRequest.zzhxf && this.zzhxy == locationRequest.zzhxy && this.zzhxz == locationRequest.zzhxz && getMaxWaitTime() == locationRequest.getMaxWaitTime();
    }

    public final long getMaxWaitTime() {
        long j = this.zzhya;
        return j < this.zzhxw ? this.zzhxw : j;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mPriority), Long.valueOf(this.zzhxw), Float.valueOf(this.zzhxz), Long.valueOf(this.zzhya)});
    }

    @Override // java.lang.Object
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append("Request[");
        switch (this.mPriority) {
            case 100:
                str = "PRIORITY_HIGH_ACCURACY";
                break;
            case 101:
            case 103:
            default:
                str = "???";
                break;
            case 102:
                str = "PRIORITY_BALANCED_POWER_ACCURACY";
                break;
            case 104:
                str = "PRIORITY_LOW_POWER";
                break;
            case 105:
                str = "PRIORITY_NO_POWER";
                break;
        }
        append.append(str);
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.zzhxw).append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzhxx).append("ms");
        if (this.zzhya > this.zzhxw) {
            sb.append(" maxWait=");
            sb.append(this.zzhya).append("ms");
        }
        if (this.zzhxz > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.zzhxz).append("m");
        }
        if (this.zzhxf != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(this.zzhxf - SystemClock.elapsedRealtime()).append("ms");
        }
        if (this.zzhxy != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.zzhxy);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.mPriority);
        zzbcn.zza(parcel, 2, this.zzhxw);
        zzbcn.zza(parcel, 3, this.zzhxx);
        zzbcn.zza(parcel, 4, this.zzgzu);
        zzbcn.zza(parcel, 5, this.zzhxf);
        zzbcn.zzc(parcel, 6, this.zzhxy);
        zzbcn.zza(parcel, 7, this.zzhxz);
        zzbcn.zza(parcel, 8, this.zzhya);
        zzbcn.zzai(parcel, zze);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
public final class zzays extends zzbck {
    public static final Parcelable.Creator<zzays> CREATOR = new zzayt();
    private String zzfam;

    public zzays() {
        this(null);
    }

    zzays(String str) {
        this.zzfam = str;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzays)) {
            return false;
        }
        return zzazl.zza(this.zzfam, ((zzays) obj).zzfam);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzfam});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, this.zzfam, false);
        zzbcn.zzai(parcel, zze);
    }

    public final String zzaed() {
        return this.zzfam;
    }
}

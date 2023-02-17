package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public final class Scope extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzf();
    private int zzdxr;
    private final String zzfht;

    Scope(int i, String str) {
        zzbp.zzh(str, "scopeUri must not be null or empty");
        this.zzdxr = i;
        this.zzfht = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.zzfht.equals(((Scope) obj).zzfht);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.zzfht.hashCode();
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.zzfht;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzdxr);
        zzbcn.zza(parcel, 2, this.zzfht, false);
        zzbcn.zzai(parcel, zze);
    }

    public final String zzaft() {
        return this.zzfht;
    }
}

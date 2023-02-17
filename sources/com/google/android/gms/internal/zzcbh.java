package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
public final class zzcbh extends zzbck implements Iterable<String> {
    public static final Parcelable.Creator<zzcbh> CREATOR = new zzcbj();
    private final Bundle zzinn;

    zzcbh(Bundle bundle) {
        this.zzinn = bundle;
    }

    /* access modifiers changed from: package-private */
    public final Object get(String str) {
        return this.zzinn.get(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzcbi(this);
    }

    public final int size() {
        return this.zzinn.size();
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.zzinn.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, zzaya(), false);
        zzbcn.zzai(parcel, zze);
    }

    public final Bundle zzaya() {
        return new Bundle(this.zzinn);
    }
}

package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzazl;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
import java.util.Locale;
public class LaunchOptions extends zzbck {
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new zzad();
    private String zzdmm;
    private boolean zzekq;

    public LaunchOptions() {
        this(false, zzazl.zzb(Locale.getDefault()));
    }

    LaunchOptions(boolean z, String str) {
        this.zzekq = z;
        this.zzdmm = str;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.zzekq == launchOptions.zzekq && zzazl.zza(this.zzdmm, launchOptions.zzdmm);
    }

    public String getLanguage() {
        return this.zzdmm;
    }

    public boolean getRelaunchIfRunning() {
        return this.zzekq;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zzekq), this.zzdmm});
    }

    public void setRelaunchIfRunning(boolean z) {
        this.zzekq = z;
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", Boolean.valueOf(this.zzekq), this.zzdmm);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 2, getRelaunchIfRunning());
        zzbcn.zza(parcel, 3, getLanguage(), false);
        zzbcn.zzai(parcel, zze);
    }
}

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbp;
public final class zzcav extends zzbck {
    public static final Parcelable.Creator<zzcav> CREATOR = new zzcaw();
    public String packageName;
    private int versionCode;
    public String zzimf;
    public zzcft zzimg;
    public long zzimh;
    public boolean zzimi;
    public String zzimj;
    public zzcbk zzimk;
    public long zziml;
    public zzcbk zzimm;
    public long zzimn;
    public zzcbk zzimo;

    zzcav(int i, String str, String str2, zzcft zzcft, long j, boolean z, String str3, zzcbk zzcbk, long j2, zzcbk zzcbk2, long j3, zzcbk zzcbk3) {
        this.versionCode = i;
        this.packageName = str;
        this.zzimf = str2;
        this.zzimg = zzcft;
        this.zzimh = j;
        this.zzimi = z;
        this.zzimj = str3;
        this.zzimk = zzcbk;
        this.zziml = j2;
        this.zzimm = zzcbk2;
        this.zzimn = j3;
        this.zzimo = zzcbk3;
    }

    zzcav(zzcav zzcav) {
        this.versionCode = 1;
        zzbp.zzu(zzcav);
        this.packageName = zzcav.packageName;
        this.zzimf = zzcav.zzimf;
        this.zzimg = zzcav.zzimg;
        this.zzimh = zzcav.zzimh;
        this.zzimi = zzcav.zzimi;
        this.zzimj = zzcav.zzimj;
        this.zzimk = zzcav.zzimk;
        this.zziml = zzcav.zziml;
        this.zzimm = zzcav.zzimm;
        this.zzimn = zzcav.zzimn;
        this.zzimo = zzcav.zzimo;
    }

    zzcav(String str, String str2, zzcft zzcft, long j, boolean z, String str3, zzcbk zzcbk, long j2, zzcbk zzcbk2, long j3, zzcbk zzcbk3) {
        this.versionCode = 1;
        this.packageName = str;
        this.zzimf = str2;
        this.zzimg = zzcft;
        this.zzimh = j;
        this.zzimi = z;
        this.zzimj = str3;
        this.zzimk = zzcbk;
        this.zziml = j2;
        this.zzimm = zzcbk2;
        this.zzimn = j3;
        this.zzimo = zzcbk3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.versionCode);
        zzbcn.zza(parcel, 2, this.packageName, false);
        zzbcn.zza(parcel, 3, this.zzimf, false);
        zzbcn.zza(parcel, 4, (Parcelable) this.zzimg, i, false);
        zzbcn.zza(parcel, 5, this.zzimh);
        zzbcn.zza(parcel, 6, this.zzimi);
        zzbcn.zza(parcel, 7, this.zzimj, false);
        zzbcn.zza(parcel, 8, (Parcelable) this.zzimk, i, false);
        zzbcn.zza(parcel, 9, this.zziml);
        zzbcn.zza(parcel, 10, (Parcelable) this.zzimm, i, false);
        zzbcn.zza(parcel, 11, this.zzimn);
        zzbcn.zza(parcel, 12, (Parcelable) this.zzimo, i, false);
        zzbcn.zzai(parcel, zze);
    }
}

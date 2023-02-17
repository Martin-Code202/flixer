package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbcn;
import java.util.List;
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzd();
    private final long mTimeout;
    private int zzdxr;
    private final long zzfxw;
    private int zzfxx;
    private final String zzfxy;
    private final String zzfxz;
    private final String zzfya;
    private final int zzfyb;
    private final List<String> zzfyc;
    private final String zzfyd;
    private final long zzfye;
    private int zzfyf;
    private final String zzfyg;
    private final float zzfyh;
    private long zzfyi;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.zzdxr = i;
        this.zzfxw = j;
        this.zzfxx = i2;
        this.zzfxy = str;
        this.zzfxz = str3;
        this.zzfya = str5;
        this.zzfyb = i3;
        this.zzfyi = -1;
        this.zzfyc = list;
        this.zzfyd = str2;
        this.zzfye = j2;
        this.zzfyf = i4;
        this.zzfyg = str4;
        this.zzfyh = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int getEventType() {
        return this.zzfxx;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long getTimeMillis() {
        return this.zzfxw;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzdxr);
        zzbcn.zza(parcel, 2, getTimeMillis());
        zzbcn.zza(parcel, 4, this.zzfxy, false);
        zzbcn.zzc(parcel, 5, this.zzfyb);
        zzbcn.zzb(parcel, 6, this.zzfyc, false);
        zzbcn.zza(parcel, 8, this.zzfye);
        zzbcn.zza(parcel, 10, this.zzfxz, false);
        zzbcn.zzc(parcel, 11, getEventType());
        zzbcn.zza(parcel, 12, this.zzfyd, false);
        zzbcn.zza(parcel, 13, this.zzfyg, false);
        zzbcn.zzc(parcel, 14, this.zzfyf);
        zzbcn.zza(parcel, 15, this.zzfyh);
        zzbcn.zza(parcel, 16, this.mTimeout);
        zzbcn.zza(parcel, 17, this.zzfya, false);
        zzbcn.zzai(parcel, zze);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzala() {
        return this.zzfyi;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzalb() {
        String str = this.zzfxy;
        int i = this.zzfyb;
        String join = this.zzfyc == null ? "" : TextUtils.join(",", this.zzfyc);
        int i2 = this.zzfyf;
        String str2 = this.zzfxz == null ? "" : this.zzfxz;
        String str3 = this.zzfyg == null ? "" : this.zzfyg;
        float f = this.zzfyh;
        String str4 = this.zzfya == null ? "" : this.zzfya;
        return new StringBuilder(String.valueOf(str4).length() + String.valueOf("\t").length() + 37 + String.valueOf(str).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(join).length() + String.valueOf("\t").length() + String.valueOf("\t").length() + String.valueOf(str2).length() + String.valueOf("\t").length() + String.valueOf(str3).length() + String.valueOf("\t").length() + String.valueOf("\t").length()).append("\t").append(str).append("\t").append(i).append("\t").append(join).append("\t").append(i2).append("\t").append(str2).append("\t").append(str3).append("\t").append(f).append("\t").append(str4).toString();
    }
}

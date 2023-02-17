package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzai implements Parcelable.Creator<MediaStatus> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaStatus createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        MediaInfo mediaInfo = null;
        long j = 0;
        int i = 0;
        double d = 0.0d;
        int i2 = 0;
        int i3 = 0;
        long j2 = 0;
        long j3 = 0;
        double d2 = 0.0d;
        boolean z = false;
        long[] jArr = null;
        int i4 = 0;
        int i5 = 0;
        String str = null;
        int i6 = 0;
        ArrayList arrayList = null;
        boolean z2 = false;
        AdBreakStatus adBreakStatus = null;
        VideoInfo videoInfo = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    mediaInfo = (MediaInfo) zzbcl.zza(parcel, readInt, MediaInfo.CREATOR);
                    break;
                case 3:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 4:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 5:
                    d = zzbcl.zzn(parcel, readInt);
                    break;
                case 6:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 7:
                    i3 = zzbcl.zzg(parcel, readInt);
                    break;
                case 8:
                    j2 = zzbcl.zzi(parcel, readInt);
                    break;
                case 9:
                    j3 = zzbcl.zzi(parcel, readInt);
                    break;
                case 10:
                    d2 = zzbcl.zzn(parcel, readInt);
                    break;
                case 11:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 12:
                    jArr = zzbcl.zzx(parcel, readInt);
                    break;
                case 13:
                    i4 = zzbcl.zzg(parcel, readInt);
                    break;
                case 14:
                    i5 = zzbcl.zzg(parcel, readInt);
                    break;
                case 15:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 16:
                    i6 = zzbcl.zzg(parcel, readInt);
                    break;
                case 17:
                    arrayList = zzbcl.zzc(parcel, readInt, MediaQueueItem.CREATOR);
                    break;
                case 18:
                    z2 = zzbcl.zzc(parcel, readInt);
                    break;
                case 19:
                    adBreakStatus = (AdBreakStatus) zzbcl.zza(parcel, readInt, AdBreakStatus.CREATOR);
                    break;
                case 20:
                    videoInfo = (VideoInfo) zzbcl.zza(parcel, readInt, VideoInfo.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new MediaStatus(mediaInfo, j, i, d, i2, i3, j2, j3, d2, z, jArr, i4, i5, str, i6, arrayList, z2, adBreakStatus, videoInfo);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaStatus[] newArray(int i) {
        return new MediaStatus[i];
    }
}

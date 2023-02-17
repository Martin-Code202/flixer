package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzah implements Parcelable.Creator<MediaQueueItem> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaQueueItem createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        MediaInfo mediaInfo = null;
        int i = 0;
        boolean z = false;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        long[] jArr = null;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    mediaInfo = (MediaInfo) zzbcl.zza(parcel, readInt, MediaInfo.CREATOR);
                    break;
                case 3:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 4:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 5:
                    d = zzbcl.zzn(parcel, readInt);
                    break;
                case 6:
                    d2 = zzbcl.zzn(parcel, readInt);
                    break;
                case 7:
                    d3 = zzbcl.zzn(parcel, readInt);
                    break;
                case 8:
                    jArr = zzbcl.zzx(parcel, readInt);
                    break;
                case 9:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new MediaQueueItem(mediaInfo, i, z, d, d2, d3, jArr, str);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaQueueItem[] newArray(int i) {
        return new MediaQueueItem[i];
    }
}

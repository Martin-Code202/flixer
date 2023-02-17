package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzae implements Parcelable.Creator<MediaInfo> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaInfo createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        int i = 0;
        String str2 = null;
        MediaMetadata mediaMetadata = null;
        long j = 0;
        ArrayList arrayList = null;
        TextTrackStyle textTrackStyle = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 3:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 4:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 5:
                    mediaMetadata = (MediaMetadata) zzbcl.zza(parcel, readInt, MediaMetadata.CREATOR);
                    break;
                case 6:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 7:
                    arrayList = zzbcl.zzc(parcel, readInt, MediaTrack.CREATOR);
                    break;
                case 8:
                    textTrackStyle = (TextTrackStyle) zzbcl.zza(parcel, readInt, TextTrackStyle.CREATOR);
                    break;
                case 9:
                    str3 = zzbcl.zzq(parcel, readInt);
                    break;
                case 10:
                    arrayList2 = zzbcl.zzc(parcel, readInt, AdBreakInfo.CREATOR);
                    break;
                case 11:
                    arrayList3 = zzbcl.zzc(parcel, readInt, AdBreakClipInfo.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new MediaInfo(str, i, str2, mediaMetadata, j, arrayList, textTrackStyle, str3, arrayList2, arrayList3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaInfo[] newArray(int i) {
        return new MediaInfo[i];
    }
}

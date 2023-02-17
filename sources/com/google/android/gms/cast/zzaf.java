package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzaf implements Parcelable.Creator<MediaMetadata> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaMetadata createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        ArrayList arrayList = null;
        Bundle bundle = null;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    arrayList = zzbcl.zzc(parcel, readInt, WebImage.CREATOR);
                    break;
                case 3:
                    bundle = zzbcl.zzs(parcel, readInt);
                    break;
                case 4:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new MediaMetadata(arrayList, bundle, i);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MediaMetadata[] newArray(int i) {
        return new MediaMetadata[i];
    }
}

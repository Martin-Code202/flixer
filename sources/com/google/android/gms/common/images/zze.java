package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zze implements Parcelable.Creator<WebImage> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 0;
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    uri = (Uri) zzbcl.zza(parcel, readInt, Uri.CREATOR);
                    break;
                case 3:
                    i2 = zzbcl.zzg(parcel, readInt);
                    break;
                case 4:
                    i3 = zzbcl.zzg(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new WebImage(i, uri, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage[] newArray(int i) {
        return new WebImage[i];
    }
}

package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzd implements Parcelable.Creator<ApplicationMetadata> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ApplicationMetadata createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        Uri uri = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbcl.zzq(parcel, readInt);
                    break;
                case 4:
                    arrayList = zzbcl.zzc(parcel, readInt, WebImage.CREATOR);
                    break;
                case 5:
                    arrayList2 = zzbcl.zzac(parcel, readInt);
                    break;
                case 6:
                    str3 = zzbcl.zzq(parcel, readInt);
                    break;
                case 7:
                    uri = (Uri) zzbcl.zza(parcel, readInt, Uri.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new ApplicationMetadata(str, str2, arrayList, arrayList2, str3, uri);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ApplicationMetadata[] newArray(int i) {
        return new ApplicationMetadata[i];
    }
}

package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zza implements Parcelable.Creator<CastMediaOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CastMediaOptions createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        NotificationOptions notificationOptions = null;
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
                    iBinder = zzbcl.zzr(parcel, readInt);
                    break;
                case 5:
                    notificationOptions = (NotificationOptions) zzbcl.zza(parcel, readInt, NotificationOptions.CREATOR);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new CastMediaOptions(str, str2, iBinder, notificationOptions);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CastMediaOptions[] newArray(int i) {
        return new CastMediaOptions[i];
    }
}

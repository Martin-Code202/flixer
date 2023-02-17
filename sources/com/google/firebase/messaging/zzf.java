package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
public final class zzf implements Parcelable.Creator<RemoteMessage> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RemoteMessage createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    bundle = zzbcl.zzs(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new RemoteMessage(bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RemoteMessage[] newArray(int i) {
        return new RemoteMessage[i];
    }
}

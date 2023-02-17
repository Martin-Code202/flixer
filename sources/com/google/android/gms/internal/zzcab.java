package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
public final class zzcab implements Parcelable.Creator<zzcaa> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcaa createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        int i = 1;
        zzbzy zzbzy = null;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 2:
                    zzbzy = (zzbzy) zzbcl.zza(parcel, readInt, zzbzy.CREATOR);
                    break;
                case 3:
                    iBinder = zzbcl.zzr(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zzbcl.zza(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = zzbcl.zzr(parcel, readInt);
                    break;
                case 6:
                    iBinder3 = zzbcl.zzr(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new zzcaa(i, zzbzy, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcaa[] newArray(int i) {
        return new zzcaa[i];
    }
}

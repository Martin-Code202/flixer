package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzb implements Parcelable.Creator<CastOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CastOptions createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        String str = null;
        ArrayList<String> arrayList = null;
        boolean z = false;
        LaunchOptions launchOptions = null;
        boolean z2 = false;
        CastMediaOptions castMediaOptions = null;
        boolean z3 = false;
        double d = 0.0d;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 2:
                    str = zzbcl.zzq(parcel, readInt);
                    break;
                case 3:
                    arrayList = zzbcl.zzac(parcel, readInt);
                    break;
                case 4:
                    z = zzbcl.zzc(parcel, readInt);
                    break;
                case 5:
                    launchOptions = (LaunchOptions) zzbcl.zza(parcel, readInt, LaunchOptions.CREATOR);
                    break;
                case 6:
                    z2 = zzbcl.zzc(parcel, readInt);
                    break;
                case 7:
                    castMediaOptions = (CastMediaOptions) zzbcl.zza(parcel, readInt, CastMediaOptions.CREATOR);
                    break;
                case 8:
                    z3 = zzbcl.zzc(parcel, readInt);
                    break;
                case 9:
                    d = zzbcl.zzn(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new CastOptions(str, arrayList, z, launchOptions, z2, castMediaOptions, z3, d);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CastOptions[] newArray(int i) {
        return new CastOptions[i];
    }
}

package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbcl;
import java.util.ArrayList;
public final class zzb implements Parcelable.Creator<ActivityRecognitionResult> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult createFromParcel(Parcel parcel) {
        int zzd = zzbcl.zzd(parcel);
        ArrayList arrayList = null;
        long j = 0;
        long j2 = 0;
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (readInt & 65535) {
                case 1:
                    arrayList = zzbcl.zzc(parcel, readInt, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j = zzbcl.zzi(parcel, readInt);
                    break;
                case 3:
                    j2 = zzbcl.zzi(parcel, readInt);
                    break;
                case 4:
                    i = zzbcl.zzg(parcel, readInt);
                    break;
                case 5:
                    bundle = zzbcl.zzs(parcel, readInt);
                    break;
                default:
                    zzbcl.zzb(parcel, readInt);
                    break;
            }
        }
        zzbcl.zzaf(parcel, zzd);
        return new ActivityRecognitionResult(arrayList, j, j2, i, bundle);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityRecognitionResult[] newArray(int i) {
        return new ActivityRecognitionResult[i];
    }
}

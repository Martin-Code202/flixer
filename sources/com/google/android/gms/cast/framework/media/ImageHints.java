package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
public class ImageHints extends zzbck {
    public static final Parcelable.Creator<ImageHints> CREATOR = new zzi();
    private final int zzecy;
    private final int zzesg;
    private final int zzesh;

    public ImageHints(int i, int i2, int i3) {
        this.zzecy = i;
        this.zzesg = i2;
        this.zzesh = i3;
    }

    public int getHeightInPixels() {
        return this.zzesh;
    }

    public int getType() {
        return this.zzecy;
    }

    public int getWidthInPixels() {
        return this.zzesg;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 2, getType());
        zzbcn.zzc(parcel, 3, getWidthInPixels());
        zzbcn.zzc(parcel, 4, getHeightInPixels());
        zzbcn.zzai(parcel, zze);
    }
}

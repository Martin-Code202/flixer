package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
public final class zzab extends zzbck {
    public static final Parcelable.Creator<zzab> CREATOR = new zzac();
    private int zzekp;

    public zzab() {
        this(0);
    }

    zzab(int i) {
        this.zzekp = i;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zzab) && this.zzekp == ((zzab) obj).zzekp;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzekp)});
    }

    @Override // java.lang.Object
    public final String toString() {
        String str;
        switch (this.zzekp) {
            case 0:
                str = "STRONG";
                break;
            case 2:
                str = "INVISIBLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        return String.format("joinOptions(connectionType=%s)", str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 2, this.zzekp);
        zzbcn.zzai(parcel, zze);
    }
}

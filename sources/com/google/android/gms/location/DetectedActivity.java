package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
import java.util.Comparator;
public class DetectedActivity extends zzbck {
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzd();
    private static Comparator<DetectedActivity> zzhwx = new zzc();
    private static int[] zzhwy = {9, 10};
    private static int[] zzhwz = {0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17};
    private int zzhxa;
    private int zzhxb;

    public DetectedActivity(int i, int i2) {
        this.zzhxa = i;
        this.zzhxb = i2;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.zzhxa == detectedActivity.zzhxa && this.zzhxb == detectedActivity.zzhxb;
    }

    public int getConfidence() {
        return this.zzhxb;
    }

    public int getType() {
        int i = this.zzhxa;
        if (i > 17) {
            return 4;
        }
        return i;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzhxa), Integer.valueOf(this.zzhxb)});
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        int type = getType();
        switch (type) {
            case 0:
                str = "IN_VEHICLE";
                break;
            case 1:
                str = "ON_BICYCLE";
                break;
            case 2:
                str = "ON_FOOT";
                break;
            case 3:
                str = "STILL";
                break;
            case 4:
                str = "UNKNOWN";
                break;
            case 5:
                str = "TILTING";
                break;
            case 6:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            default:
                str = Integer.toString(type);
                break;
            case 7:
                str = "WALKING";
                break;
            case 8:
                str = "RUNNING";
                break;
            case 16:
                str = "IN_ROAD_VEHICLE";
                break;
            case 17:
                str = "IN_RAIL_VEHICLE";
                break;
        }
        return new StringBuilder(String.valueOf(str).length() + 48).append("DetectedActivity [type=").append(str).append(", confidence=").append(this.zzhxb).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzhxa);
        zzbcn.zzc(parcel, 2, this.zzhxb);
        zzbcn.zzai(parcel, zze);
    }
}

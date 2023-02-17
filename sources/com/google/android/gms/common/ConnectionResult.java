package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import java.util.Arrays;
public final class ConnectionResult extends zzbck {
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb();
    public static final ConnectionResult zzffe = new ConnectionResult(0);
    private final PendingIntent mPendingIntent;
    private int zzdxr;
    private final int zzfab;
    private final String zzfff;

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.zzdxr = i;
        this.zzfab = i2;
        this.mPendingIntent = pendingIntent;
        this.zzfff = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    static String getStatusString(int i) {
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            case 13:
                return "CANCELED";
            case 14:
                return "TIMEOUT";
            case 15:
                return "INTERRUPTED";
            case 16:
                return "API_UNAVAILABLE";
            case 17:
                return "SIGN_IN_FAILED";
            case 18:
                return "SERVICE_UPDATING";
            case 19:
                return "SERVICE_MISSING_PERMISSION";
            case 20:
                return "RESTRICTED_PROFILE";
            case 21:
                return "API_VERSION_UPDATE_REQUIRED";
            case 99:
                return "UNFINISHED";
            case 1500:
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            default:
                return new StringBuilder(31).append("UNKNOWN_ERROR_CODE(").append(i).append(")").toString();
        }
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.zzfab == connectionResult.zzfab && zzbf.equal(this.mPendingIntent, connectionResult.mPendingIntent) && zzbf.equal(this.zzfff, connectionResult.zzfff);
    }

    public final int getErrorCode() {
        return this.zzfab;
    }

    public final String getErrorMessage() {
        return this.zzfff;
    }

    public final PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public final boolean hasResolution() {
        return (this.zzfab == 0 || this.mPendingIntent == null) ? false : true;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzfab), this.mPendingIntent, this.zzfff});
    }

    public final boolean isSuccess() {
        return this.zzfab == 0;
    }

    @Override // java.lang.Object
    public final String toString() {
        return zzbf.zzt(this).zzg("statusCode", getStatusString(this.zzfab)).zzg("resolution", this.mPendingIntent).zzg(DeepErrorElement.Debug.MESSAGE, this.zzfff).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzdxr);
        zzbcn.zzc(parcel, 2, getErrorCode());
        zzbcn.zza(parcel, 3, (Parcelable) getResolution(), i, false);
        zzbcn.zza(parcel, 4, getErrorMessage(), false);
        zzbcn.zzai(parcel, zze);
    }
}

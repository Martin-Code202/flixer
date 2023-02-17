package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.Arrays;
public final class Status extends zzbck implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zzg();
    public static final Status zzfhu = new Status(0);
    public static final Status zzfhv = new Status(14);
    public static final Status zzfhw = new Status(8);
    public static final Status zzfhx = new Status(15);
    public static final Status zzfhy = new Status(16);
    private static Status zzfhz = new Status(17);
    private static Status zzfia = new Status(18);
    private final PendingIntent mPendingIntent;
    private int zzdxr;
    private final int zzfab;
    private final String zzfff;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.zzdxr = i;
        this.zzfab = i2;
        this.zzfff = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzdxr == status.zzdxr && this.zzfab == status.zzfab && zzbf.equal(this.zzfff, status.zzfff) && zzbf.equal(this.mPendingIntent, status.mPendingIntent);
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.zzfab;
    }

    public final String getStatusMessage() {
        return this.zzfff;
    }

    public final boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzdxr), Integer.valueOf(this.zzfab), this.zzfff, this.mPendingIntent});
    }

    public final boolean isSuccess() {
        return this.zzfab <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i) {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    @Override // java.lang.Object
    public final String toString() {
        return zzbf.zzt(this).zzg("statusCode", zzafu()).zzg("resolution", this.mPendingIntent).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, getStatusCode());
        zzbcn.zza(parcel, 2, getStatusMessage(), false);
        zzbcn.zza(parcel, 3, (Parcelable) this.mPendingIntent, i, false);
        zzbcn.zzc(parcel, 1000, this.zzdxr);
        zzbcn.zzai(parcel, zze);
    }

    public final String zzafu() {
        return this.zzfff != null ? this.zzfff : CommonStatusCodes.getStatusCodeString(this.zzfab);
    }
}

package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzp();
    private IBinder zzftp;

    public BinderWrapper() {
        this.zzftp = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzftp = null;
        this.zzftp = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzftp = null;
        this.zzftp = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, zzp zzp) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzftp);
    }
}

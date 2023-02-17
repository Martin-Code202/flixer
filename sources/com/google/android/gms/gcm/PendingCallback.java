package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
@Keep
public final class PendingCallback implements Parcelable {
    public static final Parcelable.Creator<PendingCallback> CREATOR = new Parcelable.Creator<PendingCallback>() { // from class: com.google.android.gms.gcm.PendingCallback.1
        @Override // android.os.Parcelable.Creator
        public PendingCallback createFromParcel(Parcel parcel) {
            return new PendingCallback(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PendingCallback[] newArray(int i) {
            return new PendingCallback[i];
        }
    };
    private final IBinder mBinder;

    public PendingCallback(Parcel parcel) {
        this.mBinder = parcel.readStrongBinder();
    }

    public IBinder getIBinder() {
        return this.mBinder;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mBinder);
    }
}

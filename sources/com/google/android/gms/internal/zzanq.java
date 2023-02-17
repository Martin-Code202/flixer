package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
final class zzanq implements Parcelable.Creator<zzanp> {
    zzanq() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ zzanp createFromParcel(Parcel parcel) {
        return new zzanp(parcel);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    @Deprecated
    public final /* synthetic */ zzanp[] newArray(int i) {
        return new zzanp[i];
    }
}

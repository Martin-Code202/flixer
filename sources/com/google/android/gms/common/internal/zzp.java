package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
final class zzp implements Parcelable.Creator<BinderWrapper> {
    zzp() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, null);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper[] newArray(int i) {
        return new BinderWrapper[i];
    }
}

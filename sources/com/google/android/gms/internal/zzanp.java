package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
public final class zzanp implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<zzanp> CREATOR = new zzanq();
    private String mValue;
    private String zzbsw;
    private String zzdqi;

    @Deprecated
    public zzanp() {
    }

    @Deprecated
    zzanp(Parcel parcel) {
        this.zzbsw = parcel.readString();
        this.zzdqi = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Override // android.os.Parcelable
    @Deprecated
    public final int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.zzbsw;
    }

    public final String getValue() {
        return this.mValue;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzbsw);
        parcel.writeString(this.zzdqi);
        parcel.writeString(this.mValue);
    }
}

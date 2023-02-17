package com.netflix.mediaclient.service.webclient.model.leafs;

import android.os.Parcel;
public class ListSummary {
    private int length;

    public ListSummary(int i) {
        this.length = i;
    }

    protected ListSummary(Parcel parcel) {
        this.length = parcel.readInt();
    }

    /* access modifiers changed from: protected */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.length);
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }
}

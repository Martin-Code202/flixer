package com.netflix.mediaclient.ui.lolomo;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.cl.model.AppView;
import o.tB;
import paperparcel.PaperParcel;
@PaperParcel
public final class AutoValue_FragmentHelper_BackStackEntry extends tB {
    public static final Parcelable.Creator<AutoValue_FragmentHelper_BackStackEntry> CREATOR = PaperParcelAutoValue_FragmentHelper_BackStackEntry.f3228;

    public AutoValue_FragmentHelper_BackStackEntry(String str, Intent intent, AppView appView, Parcelable parcelable) {
        super(str, intent, appView, parcelable);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        PaperParcelAutoValue_FragmentHelper_BackStackEntry.writeToParcel(this, parcel, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}

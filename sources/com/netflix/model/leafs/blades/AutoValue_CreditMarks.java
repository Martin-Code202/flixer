package com.netflix.model.leafs.blades;

import android.os.Parcel;
import android.os.Parcelable;
/* access modifiers changed from: package-private */
public final class AutoValue_CreditMarks extends C$AutoValue_CreditMarks {
    public static final Parcelable.Creator<AutoValue_CreditMarks> CREATOR = new Parcelable.Creator<AutoValue_CreditMarks>() { // from class: com.netflix.model.leafs.blades.AutoValue_CreditMarks.1
        @Override // android.os.Parcelable.Creator
        public AutoValue_CreditMarks createFromParcel(Parcel parcel) {
            return new AutoValue_CreditMarks(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public AutoValue_CreditMarks[] newArray(int i) {
            return new AutoValue_CreditMarks[i];
        }
    };

    AutoValue_CreditMarks(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(startCredit());
        parcel.writeInt(endCredit());
        parcel.writeInt(startRecap());
        parcel.writeInt(endRecap());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}

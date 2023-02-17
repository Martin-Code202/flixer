package org.chromium.base;

import android.os.Parcel;
import android.os.Parcelable;
import org.chromium.base.annotations.CalledByNative;
public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = new Parcelable.Creator<UnguessableToken>() { // from class: org.chromium.base.UnguessableToken.1
        @Override // android.os.Parcelable.Creator
        public UnguessableToken createFromParcel(Parcel parcel) {
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            if (readLong == 0 || readLong2 == 0) {
                return null;
            }
            return new UnguessableToken(readLong, readLong2);
        }

        @Override // android.os.Parcelable.Creator
        public UnguessableToken[] newArray(int i) {
            return new UnguessableToken[i];
        }
    };
    private final long mHigh;
    private final long mLow;

    private UnguessableToken(long j, long j2) {
        this.mHigh = j;
        this.mLow = j2;
    }

    @CalledByNative
    private static UnguessableToken create(long j, long j2) {
        return new UnguessableToken(j, j2);
    }

    @CalledByNative
    public long getHighForSerialization() {
        return this.mHigh;
    }

    @CalledByNative
    public long getLowForSerialization() {
        return this.mLow;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mHigh);
        parcel.writeLong(this.mLow);
    }

    @CalledByNative
    private UnguessableToken parcelAndUnparcelForTesting() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        UnguessableToken createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }
}

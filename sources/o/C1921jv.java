package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
/* renamed from: o.jv  reason: case insensitive filesystem */
public class C1921jv implements Metadata.Entry {
    public static final Parcelable.Creator<C1921jv> CREATOR = new Parcelable.Creator<C1921jv>() { // from class: o.jv.2
        /* renamed from: ॱ  reason: contains not printable characters */
        public C1921jv createFromParcel(Parcel parcel) {
            return new C1921jv(parcel.readString());
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public C1921jv[] newArray(int i) {
            return new C1921jv[i];
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f8085;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public C1921jv(String str) {
        this.f8085 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m8081() {
        return this.f8085;
    }
}

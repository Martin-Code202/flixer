package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.mediaclient.ui.search.SearchResultsFrag;
/* renamed from: o.zs  reason: case insensitive filesystem */
public class C2386zs implements Parcelable {
    public static final Parcelable.Creator<C2386zs> CREATOR = new Parcelable.Creator<C2386zs>() { // from class: o.zs.5
        /* renamed from: ˋ  reason: contains not printable characters */
        public C2386zs createFromParcel(Parcel parcel) {
            return new C2386zs(parcel);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public C2386zs[] newArray(int i) {
            return new C2386zs[i];
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f12992;

    /* renamed from: ˎ  reason: contains not printable characters */
    public long f12993;

    /* renamed from: ˏ  reason: contains not printable characters */
    public SearchResultsFrag.SearchCategory f12994;

    /* renamed from: ॱ  reason: contains not printable characters */
    public int f12995;

    public C2386zs(SearchResultsFrag.SearchCategory searchCategory, int i, long j, String str) {
        this.f12994 = searchCategory;
        this.f12992 = str;
        this.f12995 = i;
        this.f12993 = j;
    }

    public C2386zs(Parcel parcel) {
        this.f12994 = SearchResultsFrag.SearchCategory.valueOf(parcel.readString());
        this.f12992 = parcel.readString();
        this.f12995 = parcel.readInt();
        this.f12993 = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12994.name());
        parcel.writeString(this.f12992);
        parcel.writeInt(this.f12995);
        parcel.writeLong(this.f12993);
    }
}

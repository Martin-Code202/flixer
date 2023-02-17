package o;

import android.os.Parcel;
import android.os.Parcelable;
public final class Gn<T extends Parcelable> implements Gr<T> {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Parcelable.Creator<T> f5705;

    public Gn(Parcelable.Creator<T> creator) {
        this.f5705 = creator;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public T mo5072(Parcel parcel) {
        if (this.f5705 == null) {
            return (T) parcel.readParcelable(Gn.class.getClassLoader());
        }
        if (parcel.readInt() == 1) {
            return this.f5705.createFromParcel(parcel);
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo5071(T t, Parcel parcel, int i) {
        if (this.f5705 == null) {
            parcel.writeParcelable(t, i);
        } else if (t == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            t.writeToParcel(parcel, i);
        }
    }
}

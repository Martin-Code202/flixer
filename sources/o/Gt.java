package o;

import android.os.Parcel;
public final class Gt {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static <T> T m5154(Parcel parcel, Gr<T> gr) {
        if (parcel.readInt() == 1) {
            return gr.mo5072(parcel);
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static <T> void m5155(T t, Parcel parcel, int i, Gr<T> gr) {
        if (t == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        gr.mo5071(t, parcel, i);
    }
}

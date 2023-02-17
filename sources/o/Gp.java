package o;

import android.os.Parcel;
import java.lang.Enum;
public final class Gp<T extends Enum<T>> implements Gr<T> {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Class<T> f5706;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.Gp<T extends java.lang.Enum<T>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // o.Gr
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ void mo5071(Object obj, Parcel parcel, int i) {
        m5076((Gp<T>) ((Enum) obj), parcel, i);
    }

    public Gp(Class<T> cls) {
        this.f5706 = cls;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public T mo5072(Parcel parcel) {
        return (T) Enum.valueOf(this.f5706, parcel.readString());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5076(T t, Parcel parcel, int i) {
        parcel.writeString(t.name());
    }
}

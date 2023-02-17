package o;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import java.util.Stack;
/* renamed from: o.tg  reason: case insensitive filesystem */
public class C2176tg implements Parcelable {
    public static final Parcelable.Creator<C2176tg> CREATOR = new Parcelable.Creator<C2176tg>() { // from class: o.tg.3
        /* renamed from: ˋ  reason: contains not printable characters */
        public C2176tg createFromParcel(Parcel parcel) {
            return new C2176tg(parcel);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C2176tg[] newArray(int i) {
            return new C2176tg[i];
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    int f10535;

    /* renamed from: ˋ  reason: contains not printable characters */
    Parcelable f10536;

    /* renamed from: ˎ  reason: contains not printable characters */
    oX f10537;

    /* renamed from: ˏ  reason: contains not printable characters */
    int f10538;

    /* renamed from: ॱ  reason: contains not printable characters */
    String f10539;

    C2176tg(String str, Parcelable parcelable, int i, int i2, oX oXVar) {
        this.f10538 = i;
        this.f10536 = parcelable;
        this.f10535 = i2;
        this.f10539 = str;
        this.f10537 = oXVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f10536, i);
        parcel.writeInt(this.f10538);
        parcel.writeInt(this.f10535);
        parcel.writeString(this.f10539);
        parcel.writeParcelable(this.f10537, i);
    }

    private C2176tg(Parcel parcel) {
        try {
            this.f10536 = parcel.readParcelable(C1317As.m3754(LinearLayoutManager.class));
        } catch (Throwable th) {
            C1283.m16847("KidsCharacterRelatedTitleState", "SPY-9006: Failed to load layout manager state", th);
            C1276.m16820().mo5727("SPY-9006: Failed to load layout manager state:" + th.getMessage());
        }
        this.f10538 = parcel.readInt();
        this.f10535 = parcel.readInt();
        this.f10539 = parcel.readString();
        this.f10537 = (oX) parcel.readParcelable(C1317As.m3754(LinearLayoutManager.class));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public oX m11154() {
        return this.f10537;
    }

    /* renamed from: o.tg$iF  reason: case insensitive filesystem */
    public static class C2177iF {
        /* renamed from: ॱ  reason: contains not printable characters */
        public static void m11158(Bundle bundle, Stack<C2176tg> stack) {
            bundle.putParcelableArray("RELATED_TITLES_INSTANCE_STATE", (Parcelable[]) stack.toArray(new Parcelable[stack.size()]));
        }
    }

    /* renamed from: o.tg$If */
    public static class If {
        /* renamed from: ˋ  reason: contains not printable characters */
        public static void m11157(Bundle bundle, Stack<C2176tg> stack) {
            bundle.setClassLoader(C1317As.m3754(LinearLayoutManager.class));
            Parcelable[] parcelableArray = bundle.getParcelableArray("RELATED_TITLES_INSTANCE_STATE");
            if (parcelableArray != null && parcelableArray.length > 0) {
                stack.empty();
                for (Parcelable parcelable : parcelableArray) {
                    stack.push((C2176tg) parcelable);
                }
            }
        }
    }
}

package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Map;
public class CL implements AbstractC0852, Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: o.CL.2
        /* renamed from: ˎ  reason: contains not printable characters */
        public CL createFromParcel(Parcel parcel) {
            return new CL(parcel);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public CL[] newArray(int i) {
            return new CL[i];
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    ArrayList<CM> f4954 = new ArrayList<>(0);

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m4212() {
        return this.f4954.size();
    }

    private CL() {
    }

    public CL(JsonElement jsonElement) {
        populate(jsonElement);
    }

    public CL(Parcel parcel) {
        parcel.readTypedList(this.f4954, CM.CREATOR);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public CM m4210() {
        if (this.f4954.size() > 0) {
            return this.f4954.get(0);
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m4211() {
        return m4210() == null || m4210().m4217() == null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f4954);
    }

    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
            this.f4954.add(new CM(entry.getValue()));
        }
    }
}

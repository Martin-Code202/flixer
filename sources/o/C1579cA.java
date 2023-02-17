package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import o.AbstractC2062pk;
import org.json.JSONObject;
/* renamed from: o.cA  reason: case insensitive filesystem */
public final class C1579cA extends DiscreteEvent implements AbstractC2062pk.Cif, Parcelable {
    public static final Parcelable.Creator<C1579cA> CREATOR = new Parcelable.Creator<C1579cA>() { // from class: o.cA.5
        /* renamed from: ˋ  reason: contains not printable characters */
        public C1579cA createFromParcel(Parcel parcel) {
            return new C1579cA(parcel);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public C1579cA[] newArray(int i) {
            return new C1579cA[i];
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1583cE f6206;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f6207;

    public C1579cA(C1583cE cEVar) {
        this.f6207 = System.currentTimeMillis();
        this.f6206 = cEVar;
        this.category = "pushNotification";
        this.name = "pushNotificationPresented";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("presentedTime", this.f6207);
        data.put("trackingInfo", this.f6206.m5815());
        return data;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6206, i);
        parcel.writeLong(this.f6207);
    }

    protected C1579cA(Parcel parcel) {
        this.f6206 = (C1583cE) parcel.readParcelable(C1583cE.class.getClassLoader());
        this.f6207 = parcel.readLong();
    }
}

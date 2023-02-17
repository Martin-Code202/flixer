package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import o.AbstractC2062pk;
import org.json.JSONObject;
/* renamed from: o.cB  reason: case insensitive filesystem */
public class C1580cB extends DiscreteEvent implements AbstractC2062pk.Cif, Parcelable {
    public static final Parcelable.Creator<C1580cB> CREATOR = new Parcelable.Creator<C1580cB>() { // from class: o.cB.3
        /* renamed from: ˏ  reason: contains not printable characters */
        public C1580cB createFromParcel(Parcel parcel) {
            return new C1580cB(parcel);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C1580cB[] newArray(int i) {
            return new C1580cB[i];
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1583cE f6208;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f6209;

    public C1580cB(C1583cE cEVar) {
        this.f6209 = System.currentTimeMillis();
        this.f6208 = cEVar;
        this.category = "pushNotification";
        this.name = "pushNotificationReceived";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("receivedTime", this.f6209);
        data.put("trackingInfo", this.f6208.m5815());
        return data;
    }

    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public String toString() {
        return "PushNotificationReceivedEvent{trackingInfo=" + this.f6208 + ", receivedTime=" + this.f6209 + "} " + super.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f6208, i);
        parcel.writeLong(this.f6209);
    }

    protected C1580cB(Parcel parcel) {
        this.f6208 = (C1583cE) parcel.readParcelable(C1583cE.class.getClassLoader());
        this.f6209 = parcel.readLong();
    }
}

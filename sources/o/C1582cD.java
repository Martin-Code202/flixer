package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.mediaclient.service.logging.client.model.DiscreteEvent;
import o.AbstractC2062pk;
import org.json.JSONObject;
/* renamed from: o.cD  reason: case insensitive filesystem */
public final class C1582cD extends DiscreteEvent implements AbstractC2062pk.Cif, Parcelable {
    public static final Parcelable.Creator<C1582cD> CREATOR = new Parcelable.Creator<C1582cD>() { // from class: o.cD.1
        /* renamed from: ॱ  reason: contains not printable characters */
        public C1582cD createFromParcel(Parcel parcel) {
            return new C1582cD(parcel);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public C1582cD[] newArray(int i) {
            return new C1582cD[i];
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f6212;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6213;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1583cE f6214;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f6215;

    public C1582cD(C1583cE cEVar, String str) {
        this.f6215 = System.currentTimeMillis();
        this.f6214 = cEVar;
        this.category = "pushNotification";
        this.f6213 = str;
        this.name = "pushNotificationResolved";
    }

    public C1582cD(C1583cE cEVar, String str, String str2) {
        this.f6215 = System.currentTimeMillis();
        this.f6214 = cEVar;
        this.f6212 = str2;
        this.category = "pushNotification";
        this.f6213 = str;
        this.name = "pushNotificationResolved";
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put("action", this.f6213);
        data.put("resolvedTime", this.f6215);
        if (!C1349Bv.m4113(this.f6212)) {
            data.put("trackingInfoAction", new JSONObject(this.f6212));
        }
        if (this.f6214 != null) {
            data.put("trackingInfo", this.f6214.m5815());
        }
        return data;
    }

    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public String toString() {
        return "PushNotificationResolvedEvent{mAction=" + this.f6213 + ", mTrackingInfo=" + this.f6214 + ", mResolvedTime=" + this.f6215 + "} " + super.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6213);
        parcel.writeParcelable(this.f6214, i);
        parcel.writeLong(this.f6215);
        parcel.writeString(this.f6212);
    }

    protected C1582cD(Parcel parcel) {
        this.f6213 = parcel.readString();
        this.f6214 = (C1583cE) parcel.readParcelable(C1583cE.class.getClassLoader());
        this.f6215 = parcel.readLong();
        this.f6212 = parcel.readString();
    }
}

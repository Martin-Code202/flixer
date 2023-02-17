package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.mediaclient.service.pushnotification.Payload;
import org.json.JSONObject;
/* renamed from: o.cE  reason: case insensitive filesystem */
public class C1583cE implements Parcelable {
    public static final Parcelable.Creator<C1583cE> CREATOR = new Parcelable.Creator<C1583cE>() { // from class: o.cE.2
        /* renamed from: ˎ  reason: contains not printable characters */
        public C1583cE createFromParcel(Parcel parcel) {
            return new C1583cE(parcel);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C1583cE[] newArray(int i) {
            return new C1583cE[i];
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6216;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6217;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6218;

    public C1583cE(C1999nc ncVar) {
        if (ncVar != null) {
            this.f6216 = ncVar.m9282();
            this.f6218 = ncVar.m9281();
            this.f6217 = ncVar.m9282();
        }
    }

    public C1583cE(Payload payload) {
        if (payload != null) {
            this.f6216 = payload.f2152;
            this.f6218 = payload.f2158;
            this.f6217 = payload.f2152;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public JSONObject m5815() {
        JSONObject jSONObject = new JSONObject();
        if (C1349Bv.m4107(this.f6216)) {
            jSONObject.put("messageId", this.f6216);
        }
        if (C1349Bv.m4107(this.f6218)) {
            jSONObject.put("messageGuid:", this.f6218);
        }
        if (C1349Bv.m4107(this.f6217)) {
            jSONObject.put("eventGuid", this.f6217);
        }
        return jSONObject;
    }

    @Override // java.lang.Object
    public String toString() {
        return "TrackingInfo{messageId='" + this.f6216 + "', messageGuid='" + this.f6218 + "', eventGuid='" + this.f6217 + "'}";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6216);
        parcel.writeString(this.f6218);
        parcel.writeString(this.f6217);
    }

    protected C1583cE(Parcel parcel) {
        this.f6216 = parcel.readString();
        this.f6218 = parcel.readString();
        this.f6217 = parcel.readString();
    }
}

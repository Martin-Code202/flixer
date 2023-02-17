package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
public class tO implements pC {
    public static final Parcelable.Creator<tO> CREATOR = new Parcelable.Creator<tO>() { // from class: o.tO.5
        /* renamed from: ˊ  reason: contains not printable characters */
        public tO createFromParcel(Parcel parcel) {
            return new tO(parcel);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public tO[] newArray(int i) {
            return new tO[i];
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f10405;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f10406;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final LoMoType f10407;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f10408;

    public tO(String str, String str2, LoMoType loMoType, String str3) {
        this.f10408 = str;
        this.f10405 = str2;
        this.f10407 = loMoType;
        this.f10406 = str3;
    }

    private tO(Parcel parcel) {
        this.f10408 = parcel.readString();
        this.f10407 = LoMoType.m1573(parcel.readString());
        this.f10405 = parcel.readString();
        this.f10406 = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10408);
        parcel.writeString(this.f10407.m1575());
        parcel.writeString(this.f10405);
        parcel.writeString(this.f10406);
    }

    @Override // o.pC
    public String getListContext() {
        return this.f10406;
    }

    @Override // o.pC
    public long getRefreshInterval() {
        return 0;
    }

    @Override // o.AbstractC2069pr
    public String getId() {
        return this.f10408;
    }

    @Override // o.AbstractC2069pr
    public String getTitle() {
        return this.f10405;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        tO tOVar = (tO) obj;
        return this.f10408.equals(tOVar.f10408) && this.f10405.equals(tOVar.f10405) && this.f10407 == tOVar.f10407;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((this.f10408.hashCode() * 31) + this.f10405.hashCode()) * 31) + this.f10407.hashCode();
    }

    @Override // o.AbstractC2069pr
    public LoMoType getType() {
        return null;
    }

    @Override // o.pC
    public int getNumVideos() {
        return Integer.MAX_VALUE;
    }

    @Override // o.pC
    public boolean isRichUITreatment() {
        return false;
    }

    @Override // o.pC
    public void setListPos(int i) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // o.AbstractC2087qh
    public int getTrackId() {
        return 0;
    }

    @Override // o.AbstractC2087qh
    public int getListPos() {
        return 0;
    }

    @Override // o.AbstractC2087qh
    public String getRequestId() {
        return null;
    }

    @Override // o.AbstractC2087qh
    public String getImpressionToken() {
        return null;
    }

    @Override // o.AbstractC2087qh
    public int getHeroTrackId() {
        return 0;
    }

    @Override // o.AbstractC2087qh
    public boolean isHero() {
        return false;
    }
}

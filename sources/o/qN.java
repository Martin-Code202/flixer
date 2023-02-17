package o;

import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
public class qN implements oX {
    public static final Parcelable.Creator<qN> CREATOR = new Parcelable.Creator<qN>() { // from class: o.qN.1
        /* renamed from: ˏ  reason: contains not printable characters */
        public qN createFromParcel(Parcel parcel) {
            return new qN(parcel);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public qN[] newArray(int i) {
            return new qN[i];
        }
    };

    /* renamed from: ʻ  reason: contains not printable characters */
    public static oX f9495 = new qN(null, 15250315, 0, 0);

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private static int f9496 = 250082130;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static oX f9497 = new qN(null, f9506, 0, 0);

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private static int f9498 = 13099801;

    /* renamed from: ʽ  reason: contains not printable characters */
    public static oX f9499 = new qN(null, 13804431, 0, 0);

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private static int f9500 = 250096294;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int f9501 = 88888;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static oX f9502 = new qN(null, f9512, 0, 0);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static oX f9503 = new qN(null, f9516, 0, 0);

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static oX f9504 = new qN(null, 11111111, 0, 0);

    /* renamed from: ˎ  reason: contains not printable characters */
    public static oX f9505 = new qN(null, f9498, 0, 0);

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int f9506 = 14836231;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static oX f9507 = new qN(null, f9511, 0, 0);

    /* renamed from: ͺ  reason: contains not printable characters */
    public static oX f9508 = new qN(null, f9496, 0, 0);

    /* renamed from: ॱ  reason: contains not printable characters */
    public static oX f9509 = new qN(null, f9500, 0, 0);

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static oX f9510 = new qN(null, f9514, 0, 0);

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private static int f9511 = 250077259;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private static int f9512 = 250078266;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static oX f9513 = new qN(null, 253494112, 0, 0);

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private static int f9514 = 250082256;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static oX f9515 = new qN(null, 15233083, 0, 0);

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private static int f9516 = 13747225;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final String f9517;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final int f9518;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final int f9519;

    /* renamed from: ˉ  reason: contains not printable characters */
    private final String f9520;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final int f9521;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private boolean f9522;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private PlayLocationType f9523;

    public qN(String str, int i, int i2, int i3) {
        this(str, i, i2, i3, PlayLocationType.DIRECT_PLAY, false);
    }

    public qN(String str, int i, int i2, int i3, PlayLocationType playLocationType, boolean z) {
        this(str, i, i2, i3, playLocationType, z, "");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public qN(Parcel parcel) {
        this(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (PlayLocationType) parcel.readSerializable(), parcel.readByte() == 1, parcel.readString());
    }

    protected qN(String str, int i, int i2, int i3, PlayLocationType playLocationType, boolean z, String str2) {
        this.f9517 = str;
        this.f9519 = i;
        this.f9518 = i2;
        this.f9521 = i3;
        this.f9523 = playLocationType;
        this.f9522 = z;
        this.f9520 = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public qN(AbstractC2087qh qhVar, int i) {
        this(qhVar.getRequestId(), qhVar.isHero() ? qhVar.getHeroTrackId() : qhVar.getTrackId(), qhVar.getListPos(), i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9517);
        parcel.writeInt(this.f9519);
        parcel.writeInt(this.f9518);
        parcel.writeInt(this.f9521);
        parcel.writeSerializable(this.f9523);
        parcel.writeByte((byte) (this.f9522 ? 1 : 0));
        parcel.writeString(this.f9520);
    }

    @Override // o.AbstractC2087qh
    public int getTrackId() {
        return this.f9519;
    }

    @Override // o.AbstractC2087qh
    public int getListPos() {
        return this.f9518;
    }

    @Override // o.AbstractC2087qh
    public String getRequestId() {
        return this.f9517;
    }

    @Override // o.oX
    /* renamed from: ˊ */
    public int mo9589() {
        return this.f9521;
    }

    @Override // o.oX
    /* renamed from: ˎ */
    public PlayLocationType mo9590() {
        return this.f9523;
    }

    @Override // o.oX
    /* renamed from: ॱ */
    public void mo9594(PlayLocationType playLocationType) {
        this.f9523 = playLocationType;
    }

    @Override // o.oX
    /* renamed from: ˎ */
    public void mo9591(boolean z) {
        this.f9522 = z;
    }

    @Override // o.oX
    /* renamed from: ˏ */
    public boolean mo9592() {
        return this.f9522;
    }

    @Override // o.oX
    /* renamed from: ॱ */
    public String mo9593() {
        return this.f9520;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "PlayContextImp [requestId=" + this.f9517 + ", trackId=" + this.f9519 + ", listPos=" + this.f9518 + ", videoPos=" + this.f9521 + ", playLocation=" + this.f9523 + ", browsePlay=" + this.f9522 + ", classSimpleName=" + this.f9520 + "]";
    }

    @Override // o.AbstractC2087qh
    public int getHeroTrackId() {
        throw new UnsupportedOperationException("Should not be needed");
    }

    @Override // o.AbstractC2087qh
    public String getImpressionToken() {
        throw new UnsupportedOperationException("Should not be needed");
    }

    @Override // o.AbstractC2087qh
    public boolean isHero() {
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public qN m9926(int i) {
        return new qN(getRequestId(), i, getListPos(), mo9589(), mo9590(), mo9592());
    }
}

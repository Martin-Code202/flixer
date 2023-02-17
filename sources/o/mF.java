package o;

import java.io.DataInputStream;
import java.util.UUID;
public class mF extends AbstractC1994my {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f8691;

    /* renamed from: ʼ  reason: contains not printable characters */
    private short f8692;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f8693;

    /* renamed from: ˋ  reason: contains not printable characters */
    private UUID f8694;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private String f8695;

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f8696;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f8697;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private short f8698;

    public mF(mA mAVar, DataInputStream dataInputStream) {
        super(mAVar, dataInputStream);
        if (!mAVar.m8797()) {
            throw new IllegalStateException("ISCHeader is supposed to be extended type!");
        } else if (!m8800().m8798("com.netflix.hinf")) {
            throw new IllegalStateException("ISCHeader does not have expected user type value!");
        } else {
            this.f8694 = mK.m8838(dataInputStream);
            this.f8696 = dataInputStream.readLong();
            this.f8697 = dataInputStream.readLong();
            this.f8693 = dataInputStream.readLong();
            this.f8692 = dataInputStream.readShort();
            this.f8698 = dataInputStream.readShort();
            this.f8691 = mK.m8843(mK.m8845(dataInputStream, 16));
            this.f8695 = mK.m8843(mK.m8845(dataInputStream, 16));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public short m8810() {
        return this.f8692;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public short m8809() {
        return this.f8698;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m8808(mA mAVar) {
        if (mAVar != null) {
            return "com.netflix.hinf".equals(mAVar.m8796());
        }
        throw new IllegalStateException("Header is null!");
    }

    @Override // o.AbstractC1994my, o.mB
    public String toString() {
        return "ISCHeader{assetId=" + this.f8694 + ", creationTime=" + this.f8696 + ", packageID=" + this.f8693 + ", movieID=" + this.f8697 + ", rootContainerExtentX=" + ((int) this.f8692) + ", rootContainerExtentY=" + ((int) this.f8698) + ", languageCode='" + this.f8691 + "', subtitleType='" + this.f8695 + "'} " + super.toString();
    }
}

package o;

import java.io.DataInputStream;
public class mL extends AbstractC1994my {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f8723;

    public mL(mA mAVar, DataInputStream dataInputStream) {
        super(mAVar, dataInputStream);
        if (!m8800().m8797()) {
            throw new IllegalStateException("VersionInfo is supposed to be extended type!");
        } else if (!m8800().m8798("com.netflix.vinf")) {
            throw new IllegalStateException("VersionInfo does not have expected user type value!");
        } else {
            this.f8723 = mK.m8843(mK.m8845(dataInputStream, (int) m8800().m8799()));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m8846(mA mAVar) {
        if (mAVar != null) {
            return "com.netflix.vinf".equals(mAVar.m8796());
        }
        throw new IllegalStateException("Header is null!");
    }

    @Override // o.AbstractC1994my, o.mB
    public String toString() {
        return "VersionInfo{builtWithLibraryVersion='" + this.f8723 + "'} " + super.toString();
    }
}

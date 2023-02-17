package o;

import com.netflix.msl.MslEntityAuthException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.crypto.RsaCryptoContext;
import com.netflix.msl.util.MslContext;
import java.security.PrivateKey;
import java.security.PublicKey;
/* renamed from: o.Dl  reason: case insensitive filesystem */
public class C1395Dl extends AbstractC1390Dg {

    /* renamed from: ˋ  reason: contains not printable characters */
    final AbstractC1414Ee f5439;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1397Dn f5440;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f5441;

    public C1395Dl(AbstractC1397Dn dn, AbstractC1414Ee ee) {
        this(null, dn, ee);
    }

    public C1395Dl(String str, AbstractC1397Dn dn, AbstractC1414Ee ee) {
        super(C1391Dh.f5422);
        this.f5441 = str;
        this.f5440 = dn;
        this.f5439 = ee;
    }

    @Override // o.AbstractC1390Dg
    /* renamed from: ˋ */
    public AbstractC1385Db mo4709(MslContext mslContext, C1405Dv dv) {
        return new C1394Dk(dv);
    }

    @Override // o.AbstractC1390Dg
    /* renamed from: ॱ */
    public AbstractC1386Dc mo4710(MslContext mslContext, AbstractC1385Db db) {
        if (!(db instanceof C1394Dk)) {
            throw new MslInternalException("Incorrect authentication data type " + db.getClass().getName() + ".");
        }
        C1394Dk dk = (C1394Dk) db;
        String r7 = dk.mo4706();
        if (this.f5439.mo4875(r7)) {
            throw new MslEntityAuthException(CK.f4926, "rsa " + r7).mo3077(dk);
        } else if (!this.f5439.mo4876(r7, m4714())) {
            throw new MslEntityAuthException(CK.f4915, "Authentication Scheme for Device Type Not Supported " + r7 + ":" + m4714()).mo3077(dk);
        } else {
            String r8 = dk.m4719();
            PublicKey r9 = this.f5440.mo4720(r8);
            PrivateKey r10 = this.f5440.mo4721(r8);
            if (r8.equals(this.f5441) && r10 == null) {
                throw new MslEntityAuthException(CK.f4933, r8).mo3077(dk);
            } else if (r8.equals(this.f5441) || r9 != null) {
                return new RsaCryptoContext(mslContext, r7, r10, r9, RsaCryptoContext.Mode.SIGN_VERIFY);
            } else {
                throw new MslEntityAuthException(CK.f4921, r8).mo3077(dk);
            }
        }
    }
}

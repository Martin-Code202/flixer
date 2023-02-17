package o;

import com.netflix.msl.MslMasterTokenException;
import com.netflix.msl.util.MslContext;
import javax.crypto.SecretKey;
public class CZ extends C1384Da {
    public CZ(MslContext mslContext, DV dv) {
        this(mslContext, dv, dv.m4691(), dv.m4699(), dv.m4690());
        if (!dv.m4693()) {
            throw new MslMasterTokenException(CK.f4749, dv);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CZ(MslContext mslContext, DV dv, String str, SecretKey secretKey, SecretKey secretKey2) {
        super(mslContext, str != null ? str + "_" + dv.m4695() : Long.toString(dv.m4695()), secretKey, secretKey2, null);
    }
}

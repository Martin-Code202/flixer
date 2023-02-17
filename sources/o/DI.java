package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslMessageException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.Map;
public abstract class DI implements AbstractC1399Dp {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static DI m4602(MslContext mslContext, C1405Dv dv, Map<String, AbstractC1386Dc> map) {
        try {
            AbstractC1400Dq r10 = mslContext.mo3174();
            AbstractC1385Db r7 = dv.m4750("entityauthdata") ? AbstractC1385Db.m4705(mslContext, dv.m4756("entityauthdata", r10)) : null;
            DV dv2 = dv.m4750("mastertoken") ? new DV(mslContext, dv.m4756("mastertoken", r10)) : null;
            byte[] r9 = dv.mo4761("signature");
            try {
                if (dv.m4750("headerdata")) {
                    byte[] r102 = dv.mo4761("headerdata");
                    if (r102.length != 0) {
                        return new DM(mslContext, r102, r7, dv2, r9, map);
                    }
                    throw new MslMessageException(CK.f4777).mo3076(dv2).mo3077(r7);
                } else if (dv.m4750("errordata")) {
                    byte[] r103 = dv.mo4761("errordata");
                    if (r103.length != 0) {
                        return new DD(mslContext, r103, r7, r9);
                    }
                    throw new MslMessageException(CK.f4777).mo3076(dv2).mo3077(r7);
                } else {
                    throw new MslEncodingException(CK.f4804, dv.toString());
                }
            } catch (MslEncoderException e) {
                throw new MslEncodingException(CK.f4804, "header/errormsg " + dv, e);
            }
        } catch (MslEncoderException e2) {
            throw new MslEncodingException(CK.f4804, "header/errormsg " + dv, e2);
        }
    }
}

package o;

import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslMasterTokenException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class DX extends AbstractC1412Ec {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Logger f5391 = LoggerFactory.getLogger(DX.class);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f5392;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final DV f5393;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C1411Eb f5394;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final MslContext f5395;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Map<C1407Dx, C1405Dv> f5396 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private static AbstractC1386Dc m4700(MslContext mslContext, DV dv) {
        AbstractC1386Dc r1 = mslContext.mo3159().mo4888(dv);
        if (r1 != null) {
            return r1;
        }
        return new CZ(mslContext, dv);
    }

    public DX(MslContext mslContext, DV dv, C1411Eb eb, String str) {
        super(C1410Ea.f5516);
        this.f5395 = mslContext;
        this.f5393 = dv;
        this.f5394 = eb;
        this.f5392 = str;
        if (str == null || str.isEmpty()) {
            throw new NullPointerException("entityIdentity is null/empty");
        } else if (eb == null) {
            throw new NullPointerException("userIdToken is null");
        } else {
            f5391.debug("Target ESN = {}", str);
        }
    }

    @Override // o.AbstractC1412Ec
    /* renamed from: ˊ  reason: contains not printable characters */
    public C1405Dv mo4701(AbstractC1400Dq dq, C1407Dx dx) {
        if (this.f5396.containsKey(dx)) {
            return this.f5396.get(dx);
        }
        try {
            AbstractC1386Dc r2 = m4700(this.f5395, this.f5393);
            C1405Dv r3 = dq.m4727();
            r3.mo4754("useridtoken", this.f5394);
            r3.mo4754("entityidentity", this.f5392);
            try {
                byte[] r5 = r2.mo4323(dq.mo3178(r3, dx), dq, dx);
                Object r6 = r2.mo4325(r5, dq, dx);
                C1405Dv r7 = dq.m4727();
                r7.mo4754("mastertoken", this.f5393);
                r7.mo4754("userdata", r5);
                r7.mo4754("signature", r6);
                C1405Dv r9 = dq.mo3176(dq.mo3178(r7, dx));
                this.f5396.put(dx, r9);
                return r9;
            } catch (MslCryptoException e) {
                throw new MslEncoderException("Error encrypting and signing the authentication data.", e);
            }
        } catch (MslMasterTokenException e2) {
            throw new MslEncoderException("Master token crypto context cannot be retrieved or created.", e2);
        }
    }

    @Override // o.AbstractC1412Ec
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DX)) {
            return false;
        }
        DX dx = (DX) obj;
        return super.equals(obj) && this.f5393.equals(dx.f5393) && this.f5394.equals(dx.f5394) && this.f5392.equals(dx.f5392);
    }

    @Override // o.AbstractC1412Ec
    public int hashCode() {
        return ((super.hashCode() ^ this.f5393.hashCode()) ^ this.f5394.hashCode()) ^ this.f5392.hashCode();
    }
}

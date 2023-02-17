package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslKeyExchangeException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
/* renamed from: o.Dy  reason: case insensitive filesystem */
public abstract class AbstractC1408Dy implements AbstractC1399Dp {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1409Dz f5474;

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public abstract C1405Dv mo4597(AbstractC1400Dq dq, C1407Dx dx);

    protected AbstractC1408Dy(C1409Dz dz) {
        this.f5474 = dz;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static AbstractC1408Dy m4771(MslContext mslContext, C1405Dv dv) {
        try {
            String r4 = dv.m4752("scheme");
            C1409Dz r5 = mslContext.mo3165(r4);
            if (r5 == null) {
                throw new MslKeyExchangeException(CK.f4833, r4);
            }
            C1405Dv r7 = dv.m4756("keydata", mslContext.mo3174());
            DB r8 = mslContext.mo3162(r5);
            if (r8 != null) {
                return r8.mo4582(mslContext, r7);
            }
            throw new MslKeyExchangeException(CK.f4834, r5.m4774());
        } catch (MslEncoderException e) {
            throw new MslEncodingException(CK.f4804, "keyrequestdata " + dv, e);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1409Dz m4772() {
        return this.f5474;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public final byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("scheme", this.f5474.m4774());
        r2.mo4754("keydata", mo4597(dq, dx));
        return dq.mo3178(r2, dx);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1408Dy)) {
            return false;
        }
        return this.f5474.equals(((AbstractC1408Dy) obj).f5474);
    }

    public int hashCode() {
        return this.f5474.hashCode();
    }
}

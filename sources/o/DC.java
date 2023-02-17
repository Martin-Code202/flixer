package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslKeyExchangeException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
public abstract class DC implements AbstractC1399Dp {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final DV f5253;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C1409Dz f5254;

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract C1405Dv mo4588(AbstractC1400Dq dq, C1407Dx dx);

    protected DC(DV dv, C1409Dz dz) {
        this.f5253 = dv;
        this.f5254 = dz;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static DC m4586(MslContext mslContext, C1405Dv dv) {
        AbstractC1400Dq r4 = mslContext.mo3174();
        try {
            DV dv2 = new DV(mslContext, dv.m4756("mastertoken", r4));
            String r6 = dv.m4752("scheme");
            C1409Dz r7 = mslContext.mo3165(r6);
            if (r7 == null) {
                throw new MslKeyExchangeException(CK.f4833, r6);
            }
            C1405Dv r8 = dv.m4756("keydata", r4);
            DB r9 = mslContext.mo3162(r7);
            if (r9 != null) {
                return r9.mo4584(mslContext, dv2, r8);
            }
            throw new MslKeyExchangeException(CK.f4834, r7.m4774());
        } catch (MslEncoderException e) {
            throw new MslEncodingException(CK.f4804, "keyresponsedata " + dv, e);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public DV m4587() {
        return this.f5253;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1409Dz m4589() {
        return this.f5254;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("mastertoken", this.f5253);
        r2.mo4754("scheme", this.f5254.m4774());
        r2.mo4754("keydata", mo4588(dq, dx));
        return dq.mo3178(r2, dx);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DC)) {
            return false;
        }
        DC dc = (DC) obj;
        return this.f5253.equals(dc.f5253) && this.f5254.equals(dc.f5254);
    }

    public int hashCode() {
        return this.f5253.hashCode() ^ this.f5254.hashCode();
    }
}

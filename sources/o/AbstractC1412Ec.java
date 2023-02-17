package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslUserAuthException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.Ec  reason: case insensitive filesystem */
public abstract class AbstractC1412Ec implements AbstractC1399Dp {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1416Eg f5529;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Map<C1407Dx, byte[]> f5530 = new HashMap();

    /* renamed from: ˊ */
    public abstract C1405Dv mo4701(AbstractC1400Dq dq, C1407Dx dx);

    protected AbstractC1412Ec(C1416Eg eg) {
        this.f5529 = eg;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static AbstractC1412Ec m4873(MslContext mslContext, DV dv, C1405Dv dv2) {
        try {
            String r4 = dv2.m4752("scheme");
            C1416Eg r5 = mslContext.mo3172(r4);
            if (r5 == null) {
                throw new MslUserAuthException(CK.f4944, r4);
            }
            AbstractC1415Ef r6 = mslContext.mo3171(r5);
            if (r6 != null) {
                return r6.m4878(mslContext, dv, dv2.m4756("authdata", mslContext.mo3174()));
            }
            throw new MslUserAuthException(CK.f4948, r5.m4880());
        } catch (MslEncoderException e) {
            throw new MslEncodingException(CK.f4804, "userauthdata " + dv2, e);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1416Eg m4874() {
        return this.f5529;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        if (this.f5530.containsKey(dx)) {
            return this.f5530.get(dx);
        }
        C1405Dv r2 = dq.m4727();
        r2.mo4754("scheme", this.f5529.m4880());
        r2.mo4754("authdata", mo4701(dq, dx));
        byte[] r3 = dq.mo3178(r2, dx);
        this.f5530.put(dx, r3);
        return r3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1412Ec)) {
            return false;
        }
        return this.f5529.equals(((AbstractC1412Ec) obj).f5529);
    }

    public int hashCode() {
        return this.f5529.hashCode();
    }
}

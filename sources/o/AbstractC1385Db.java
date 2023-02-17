package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslEntityAuthException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.Db  reason: case insensitive filesystem */
public abstract class AbstractC1385Db implements AbstractC1399Dp {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Map<C1407Dx, byte[]> f5407 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C1391Dh f5408;

    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract String mo4706();

    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract C1405Dv mo4708(AbstractC1400Dq dq, C1407Dx dx);

    protected AbstractC1385Db(C1391Dh dh) {
        this.f5408 = dh;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static AbstractC1385Db m4705(MslContext mslContext, C1405Dv dv) {
        try {
            String r4 = dv.m4752("scheme");
            C1391Dh r5 = mslContext.mo3163(r4);
            if (r5 == null) {
                throw new MslEntityAuthException(CK.f4906, r4);
            }
            C1405Dv r7 = dv.m4756("authdata", mslContext.mo3174());
            AbstractC1390Dg r8 = mslContext.mo3169(r5);
            if (r8 != null) {
                return r8.mo4709(mslContext, r7);
            }
            throw new MslEntityAuthException(CK.f4907, r5.m4716());
        } catch (MslEncoderException e) {
            throw new MslEncodingException(CK.f4804, "entityauthdata " + dv, e);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1391Dh m4707() {
        return this.f5408;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public final byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        if (this.f5407.containsKey(dx)) {
            return this.f5407.get(dx);
        }
        C1405Dv r2 = dq.m4727();
        r2.mo4754("scheme", this.f5408.m4716());
        r2.mo4754("authdata", mo4708(dq, dx));
        byte[] r3 = dq.mo3178(r2, dx);
        this.f5407.put(dx, r3);
        return r3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1385Db)) {
            return false;
        }
        return this.f5408.equals(((AbstractC1385Db) obj).f5408);
    }

    public int hashCode() {
        return this.f5408.hashCode();
    }
}

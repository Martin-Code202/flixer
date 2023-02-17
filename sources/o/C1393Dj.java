package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.io.MslEncoderException;
/* renamed from: o.Dj  reason: case insensitive filesystem */
public class C1393Dj extends AbstractC1385Db {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f5436;

    public C1393Dj(String str) {
        super(C1391Dh.f5420);
        this.f5436 = str;
    }

    C1393Dj(C1405Dv dv) {
        super(C1391Dh.f5420);
        try {
            this.f5436 = dv.m4752("identity");
        } catch (MslEncoderException e) {
            throw new MslEncodingException(CK.f4804, "unauthenticated authdata " + dv, e);
        }
    }

    @Override // o.AbstractC1385Db
    /* renamed from: ˊ */
    public String mo4706() {
        return this.f5436;
    }

    @Override // o.AbstractC1385Db
    /* renamed from: ॱ */
    public C1405Dv mo4708(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("identity", this.f5436);
        return r2;
    }

    @Override // o.AbstractC1385Db
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1393Dj)) {
            return false;
        }
        return super.equals(obj) && this.f5436.equals(((C1393Dj) obj).f5436);
    }

    @Override // o.AbstractC1385Db
    public int hashCode() {
        return super.hashCode() ^ this.f5436.hashCode();
    }
}

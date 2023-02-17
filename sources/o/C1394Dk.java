package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.io.MslEncoderException;
/* renamed from: o.Dk  reason: case insensitive filesystem */
public class C1394Dk extends AbstractC1385Db {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f5437;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f5438;

    public C1394Dk(C1405Dv dv) {
        super(C1391Dh.f5422);
        try {
            this.f5438 = dv.m4752("identity");
            this.f5437 = dv.m4752("pubkeyid");
        } catch (MslEncoderException e) {
            throw new MslEncodingException(CK.f4804, "RSA authdata " + dv, e);
        }
    }

    @Override // o.AbstractC1385Db
    /* renamed from: ˊ */
    public String mo4706() {
        return this.f5438;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m4719() {
        return this.f5437;
    }

    @Override // o.AbstractC1385Db
    /* renamed from: ॱ */
    public C1405Dv mo4708(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("identity", this.f5438);
        r2.mo4754("pubkeyid", this.f5437);
        return r2;
    }

    @Override // o.AbstractC1385Db
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1394Dk)) {
            return false;
        }
        C1394Dk dk = (C1394Dk) obj;
        return super.equals(obj) && this.f5438.equals(dk.f5438) && this.f5437.equals(dk.f5437);
    }

    @Override // o.AbstractC1385Db
    public int hashCode() {
        return super.hashCode() ^ (this.f5438 + "|" + this.f5437).hashCode();
    }
}

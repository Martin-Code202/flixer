package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.io.MslEncoderException;
public class DG extends DC {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final byte[] f5267;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final byte[] f5268;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final byte[] f5269;

    public DG(DV dv, C1405Dv dv2) {
        super(dv, DA.f5246);
        try {
            this.f5267 = dv2.mo4761("cdmkeyresponse");
            this.f5268 = dv2.mo4761("encryptionkeyid");
            this.f5269 = dv2.mo4761("hmackeyid");
        } catch (MslEncoderException e) {
            throw new MslEncodingException(CK.f4804, "keydata " + dv2, e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.DC
    /* renamed from: ॱ */
    public C1405Dv mo4588(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("encryptionkeyid", this.f5268);
        r2.mo4754("hmackeyid", this.f5269);
        r2.mo4754("cdmkeyresponse", this.f5267);
        return r2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public byte[] m4601() {
        return this.f5267;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public byte[] m4600() {
        return this.f5268;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] m4599() {
        return this.f5269;
    }

    @Override // o.DC
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DG)) {
            return false;
        }
        DG dg = (DG) obj;
        return super.equals(obj) && this.f5267.equals(dg.f5267) && this.f5268.equals(dg.f5268) && this.f5269.equals(dg.f5269);
    }

    @Override // o.DC
    public int hashCode() {
        return ((super.hashCode() ^ this.f5267.hashCode()) ^ this.f5268.hashCode()) ^ this.f5269.hashCode();
    }
}

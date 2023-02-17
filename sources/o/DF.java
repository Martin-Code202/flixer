package o;

import com.netflix.msl.MslEncodingException;
import com.netflix.msl.io.MslEncoderException;
public class DF extends AbstractC1408Dy {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final byte[] f5266;

    public DF(byte[] bArr) {
        super(DA.f5246);
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Key request data must be defined and non-empty.");
        }
        this.f5266 = bArr;
    }

    public DF(C1405Dv dv) {
        super(DA.f5246);
        try {
            this.f5266 = dv.mo4761("keyrequest");
        } catch (MslEncoderException e) {
            throw new MslEncodingException(CK.f4804, "keydata " + dv, e);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public byte[] m4598() {
        return this.f5266;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1408Dy
    /* renamed from: ˎ  reason: contains not printable characters */
    public C1405Dv mo4597(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("keyrequest", this.f5266);
        return r2;
    }

    @Override // o.AbstractC1408Dy
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DF)) {
            return false;
        }
        DF df = (DF) obj;
        return super.equals(obj) && (this.f5266 == df.f5266 || (this.f5266 != null && df.f5266 != null && this.f5266.equals(df.f5266)));
    }

    @Override // o.AbstractC1408Dy
    public int hashCode() {
        return super.hashCode() ^ this.f5266.hashCode();
    }
}

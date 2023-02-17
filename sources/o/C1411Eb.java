package o;

import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.Eb  reason: case insensitive filesystem */
public class C1411Eb implements AbstractC1399Dp {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final DW f5517;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final C1405Dv f5518;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final byte[] f5519;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final MslContext f5520;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final boolean f5521;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final long f5522;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final long f5523;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long f5524;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final long f5525;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Map<C1407Dx, byte[]> f5526 = new HashMap();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final byte[] f5527;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C1405Dv f5528;

    public C1411Eb(MslContext mslContext, C1405Dv dv, DV dv2) {
        this.f5520 = mslContext;
        AbstractC1386Dc r5 = mslContext.mo3160();
        AbstractC1400Dq r6 = mslContext.mo3174();
        try {
            this.f5519 = dv.mo4761("tokendata");
            if (this.f5519.length == 0) {
                throw new MslEncodingException(CK.f4881, "useridtoken " + dv).mo3076(dv2);
            }
            this.f5527 = dv.mo4761("signature");
            this.f5521 = r5.mo4324(this.f5519, this.f5527, r6);
            try {
                C1405Dv r8 = r6.mo3176(this.f5519);
                this.f5523 = r8.m4763("renewalwindow");
                this.f5524 = r8.m4763("expiration");
                if (this.f5524 < this.f5523) {
                    throw new MslException(CK.f4837, "usertokendata " + r8).mo3076(dv2);
                }
                this.f5522 = r8.m4763("mtserialnumber");
                if (this.f5522 < 0 || this.f5522 > 9007199254740992L) {
                    throw new MslException(CK.f4847, "usertokendata " + r8).mo3076(dv2);
                }
                this.f5525 = r8.m4763("serialnumber");
                if (this.f5525 < 0 || this.f5525 > 9007199254740992L) {
                    throw new MslException(CK.f4878, "usertokendata " + r8).mo3076(dv2);
                }
                byte[] r9 = r8.mo4761("userdata");
                if (r9.length == 0) {
                    throw new MslException(CK.f4864).mo3076(dv2);
                }
                byte[] r7 = this.f5521 ? r5.mo4322(r9, r6) : null;
                if (r7 != null) {
                    try {
                        this.f5518 = r6.mo3176(r7);
                        this.f5528 = this.f5518.m4750("issuerdata") ? this.f5518.m4756("issuerdata", r6) : null;
                        String r82 = this.f5518.m4752("identity");
                        if (r82 == null || r82.length() == 0) {
                            throw new MslException(CK.f4867, "userdata " + this.f5518).mo3076(dv2);
                        }
                        this.f5517 = mslContext.mo3161().mo4674(mslContext, r82);
                        if (this.f5517 == null) {
                            throw new MslInternalException("TokenFactory.createUser() returned null in violation of the interface contract.");
                        }
                    } catch (MslEncoderException e) {
                        throw new MslEncodingException(CK.f4879, "userdata " + C1418Ei.m4892(r7), e).mo3076(dv2);
                    }
                } else {
                    this.f5518 = null;
                    this.f5528 = null;
                    this.f5517 = null;
                }
                if (dv2 == null || this.f5522 != dv2.m4698()) {
                    throw new MslException(CK.f4807, "uit mtserialnumber " + this.f5522 + "; mt " + dv2).mo3076(dv2);
                }
            } catch (MslEncoderException e2) {
                throw new MslEncodingException(CK.f4888, "usertokendata " + C1418Ei.m4892(this.f5519), e2).mo3076(dv2);
            } catch (MslCryptoException e3) {
                e3.mo3076(dv2);
                throw e3;
            }
        } catch (MslEncoderException e4) {
            throw new MslEncodingException(CK.f4804, "useridtoken " + dv, e4).mo3076(dv2);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m4872() {
        return this.f5521;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m4870(Date date) {
        return date != null ? this.f5523 * 1000 <= date.getTime() : !m4872() || this.f5523 * 1000 <= this.f5520.mo3167();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m4867(Date date) {
        return date != null ? this.f5524 * 1000 <= date.getTime() : m4872() && this.f5524 * 1000 <= this.f5520.mo3167();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public DW m4866() {
        return this.f5517;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m4868() {
        return this.f5525;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m4869() {
        return this.f5522;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m4871(DV dv) {
        return dv != null && dv.m4698() == this.f5522;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        Object obj;
        byte[] bArr;
        if (this.f5526.containsKey(dx)) {
            return this.f5526.get(dx);
        }
        if (this.f5519 == null && this.f5527 == null) {
            try {
                AbstractC1386Dc r5 = this.f5520.mo3160();
                try {
                    Object r7 = r5.mo4323(dq.mo3178(this.f5518, dx), dq, dx);
                    C1405Dv r8 = dq.m4727();
                    r8.mo4754("renewalwindow", Long.valueOf(this.f5523));
                    r8.mo4754("expiration", Long.valueOf(this.f5524));
                    r8.mo4754("mtserialnumber", Long.valueOf(this.f5522));
                    r8.mo4754("serialnumber", Long.valueOf(this.f5525));
                    r8.mo4754("userdata", r7);
                    bArr = dq.mo3178(r8, dx);
                    try {
                        obj = r5.mo4325(bArr, dq, dx);
                    } catch (MslCryptoException e) {
                        throw new MslEncoderException("Error signing the token data.", e);
                    }
                } catch (MslCryptoException e2) {
                    throw new MslEncoderException("Error encrypting the user data.", e2);
                }
            } catch (MslCryptoException e3) {
                throw new MslEncoderException("Error creating the MSL crypto context.", e3);
            }
        } else {
            bArr = this.f5519;
            obj = this.f5527;
        }
        C1405Dv r52 = dq.m4727();
        r52.mo4754("tokendata", bArr);
        r52.mo4754("signature", obj);
        byte[] r6 = dq.mo3178(r52, dx);
        this.f5526.put(dx, r6);
        return r6;
    }

    public String toString() {
        AbstractC1400Dq r3 = this.f5520.mo3174();
        C1405Dv r4 = r3.m4727();
        r4.mo4754("renewalwindow", Long.valueOf(this.f5523));
        r4.mo4754("expiration", Long.valueOf(this.f5524));
        r4.mo4754("mtserialnumber", Long.valueOf(this.f5522));
        r4.mo4754("serialnumber", Long.valueOf(this.f5525));
        r4.mo4754("userdata", "(redacted)");
        C1405Dv r5 = r3.m4727();
        r5.mo4754("tokendata", r4);
        r5.mo4754("signature", this.f5527 != null ? this.f5527 : "(null)");
        return r5.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1411Eb)) {
            return false;
        }
        C1411Eb eb = (C1411Eb) obj;
        return this.f5525 == eb.f5525 && this.f5522 == eb.f5522;
    }

    public int hashCode() {
        return (String.valueOf(this.f5525) + ":" + String.valueOf(this.f5522)).hashCode();
    }
}

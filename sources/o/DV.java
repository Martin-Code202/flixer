package o;

import com.netflix.msl.MslConstants;
import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class DV implements AbstractC1399Dp {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f5377;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final SecretKey f5378;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C1405Dv f5379;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final long f5380;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final long f5381;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final Map<C1407Dx, byte[]> f5382 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final long f5383;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final MslContext f5384;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final byte[] f5385;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final boolean f5386;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final long f5387;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final byte[] f5388;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C1405Dv f5389;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final SecretKey f5390;

    public DV(MslContext mslContext, Date date, Date date2, long j, long j2, C1405Dv dv, String str, SecretKey secretKey, SecretKey secretKey2) {
        if (date2.before(date)) {
            throw new MslInternalException("Cannot construct a master token that expires before its renewal window opens.");
        } else if (j < 0 || j > 9007199254740992L) {
            throw new MslInternalException("Sequence number " + j + " is outside the valid range.");
        } else if (j2 < 0 || j2 > 9007199254740992L) {
            throw new MslInternalException("Serial number " + j2 + " is outside the valid range.");
        } else {
            this.f5384 = mslContext;
            this.f5383 = date.getTime() / 1000;
            this.f5387 = date2.getTime() / 1000;
            this.f5381 = j;
            this.f5380 = j2;
            this.f5379 = dv;
            this.f5377 = str;
            this.f5378 = secretKey;
            this.f5390 = secretKey2;
            byte[] encoded = this.f5378.getEncoded();
            byte[] encoded2 = this.f5390.getEncoded();
            try {
                MslConstants.EncryptionAlgo r6 = MslConstants.EncryptionAlgo.m3072(this.f5378.getAlgorithm());
                MslConstants.SignatureAlgo r7 = MslConstants.SignatureAlgo.m3075(this.f5390.getAlgorithm());
                this.f5389 = mslContext.mo3174().m4727();
                if (this.f5379 != null) {
                    this.f5389.mo4754("issuerdata", this.f5379);
                }
                this.f5389.mo4754("identity", this.f5377);
                this.f5389.mo4754("encryptionkey", encoded);
                this.f5389.mo4754("encryptionalgorithm", r6);
                this.f5389.mo4754("hmackey", encoded2);
                this.f5389.mo4754("signaturekey", encoded2);
                this.f5389.mo4754("signaturealgorithm", r7);
                this.f5385 = null;
                this.f5388 = null;
                this.f5386 = true;
            } catch (IllegalArgumentException e) {
                throw new MslCryptoException(CK.f4934, "encryption algorithm: " + this.f5378.getAlgorithm() + "; signature algorithm: " + this.f5390.getAlgorithm(), e);
            }
        }
    }

    public DV(MslContext mslContext, C1405Dv dv) {
        byte[] bArr;
        this.f5384 = mslContext;
        AbstractC1386Dc r4 = mslContext.mo3160();
        AbstractC1400Dq r5 = mslContext.mo3174();
        try {
            this.f5385 = dv.mo4761("tokendata");
            if (this.f5385.length == 0) {
                throw new MslEncodingException(CK.f4784, "mastertoken " + dv);
            }
            this.f5388 = dv.mo4761("signature");
            this.f5386 = r4.mo4324(this.f5385, this.f5388, r5);
            try {
                C1405Dv r7 = r5.mo3176(this.f5385);
                this.f5383 = r7.m4763("renewalwindow");
                this.f5387 = r7.m4763("expiration");
                if (this.f5387 < this.f5383) {
                    throw new MslException(CK.f4744, "mastertokendata " + r7);
                }
                this.f5381 = r7.m4763("sequencenumber");
                if (this.f5381 < 0 || this.f5381 > 9007199254740992L) {
                    throw new MslException(CK.f4764, "mastertokendata " + r7);
                }
                this.f5380 = r7.m4763("serialnumber");
                if (this.f5380 < 0 || this.f5380 > 9007199254740992L) {
                    throw new MslException(CK.f4760, "mastertokendata " + r7);
                }
                byte[] r8 = r7.mo4761("sessiondata");
                if (r8.length == 0) {
                    throw new MslEncodingException(CK.f4758, "mastertokendata " + r7);
                }
                byte[] r6 = this.f5386 ? r4.mo4322(r8, r5) : null;
                if (r6 != null) {
                    try {
                        this.f5389 = r5.mo3176(r6);
                        this.f5379 = this.f5389.m4750("issuerdata") ? this.f5389.m4756("issuerdata", r5) : null;
                        this.f5377 = this.f5389.m4752("identity");
                        byte[] r72 = this.f5389.mo4761("encryptionkey");
                        String r9 = this.f5389.m4760("encryptionalgorithm", "AES");
                        if (this.f5389.m4750("signaturekey")) {
                            bArr = this.f5389.mo4761("signaturekey");
                        } else {
                            bArr = this.f5389.mo4761("hmackey");
                        }
                        String r10 = this.f5389.m4760("signaturealgorithm", "HmacSHA256");
                        try {
                            String encryptionAlgo = MslConstants.EncryptionAlgo.m3072(r9).toString();
                            String signatureAlgo = MslConstants.SignatureAlgo.m3075(r10).toString();
                            try {
                                this.f5378 = new SecretKeySpec(r72, encryptionAlgo);
                                this.f5390 = new SecretKeySpec(bArr, signatureAlgo);
                            } catch (IllegalArgumentException e) {
                                throw new MslCryptoException(CK.f4742, e);
                            }
                        } catch (IllegalArgumentException e2) {
                            throw new MslCryptoException(CK.f4934, "encryption algorithm: " + r9 + "; signature algorithm" + r10, e2);
                        }
                    } catch (MslEncoderException e3) {
                        throw new MslEncodingException(CK.f4769, "sessiondata " + C1418Ei.m4892(r6), e3);
                    }
                } else {
                    this.f5389 = null;
                    this.f5379 = null;
                    this.f5377 = null;
                    this.f5378 = null;
                    this.f5390 = null;
                }
            } catch (MslEncoderException e4) {
                throw new MslEncodingException(CK.f4781, "mastertokendata " + C1418Ei.m4892(this.f5385), e4);
            }
        } catch (MslEncoderException e5) {
            throw new MslEncodingException(CK.f4804, "mastertoken " + dv, e5);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m4693() {
        return this.f5389 != null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m4696() {
        return this.f5386;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m4697(Date date) {
        return date != null ? this.f5383 * 1000 <= date.getTime() : !m4696() || this.f5383 * 1000 <= this.f5384.mo3167();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m4692(Date date) {
        return date != null ? this.f5387 * 1000 <= date.getTime() : m4696() && this.f5387 * 1000 <= this.f5384.mo3167();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m4695() {
        return this.f5381;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long m4698() {
        return this.f5380;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m4694(DV dv) {
        if (this.f5381 == dv.f5381) {
            return this.f5387 > dv.f5387;
        }
        if (this.f5381 > dv.f5381) {
            return dv.f5381 >= (this.f5381 - 9007199254740992L) + 127;
        }
        return this.f5381 < (dv.f5381 - 9007199254740992L) + 127;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m4691() {
        return this.f5377;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public SecretKey m4699() {
        return this.f5378;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public SecretKey m4690() {
        return this.f5390;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        Object obj;
        byte[] bArr;
        if (this.f5382.containsKey(dx)) {
            return this.f5382.get(dx);
        }
        if (this.f5385 == null && this.f5388 == null) {
            try {
                AbstractC1386Dc r5 = this.f5384.mo3160();
                try {
                    Object r7 = r5.mo4323(dq.mo3178(this.f5389, dx), dq, dx);
                    C1405Dv r8 = dq.m4727();
                    r8.mo4754("renewalwindow", Long.valueOf(this.f5383));
                    r8.mo4754("expiration", Long.valueOf(this.f5387));
                    r8.mo4754("sequencenumber", Long.valueOf(this.f5381));
                    r8.mo4754("serialnumber", Long.valueOf(this.f5380));
                    r8.mo4754("sessiondata", r7);
                    bArr = dq.mo3178(r8, dx);
                    try {
                        obj = r5.mo4325(bArr, dq, dx);
                    } catch (MslCryptoException e) {
                        throw new MslEncoderException("Error signing the token data.", e);
                    }
                } catch (MslCryptoException e2) {
                    throw new MslEncoderException("Error encrypting the session data.", e2);
                }
            } catch (MslCryptoException e3) {
                throw new MslEncoderException("Error creating the MSL crypto context.", e3);
            }
        } else {
            bArr = this.f5385;
            obj = this.f5388;
        }
        C1405Dv r52 = dq.m4727();
        r52.mo4754("tokendata", bArr);
        r52.mo4754("signature", obj);
        byte[] r6 = dq.mo3178(r52, dx);
        this.f5382.put(dx, r6);
        return r6;
    }

    public String toString() {
        AbstractC1400Dq r3 = this.f5384.mo3174();
        C1405Dv r4 = r3.m4727();
        r4.mo4754("renewalwindow", Long.valueOf(this.f5383));
        r4.mo4754("expiration", Long.valueOf(this.f5387));
        r4.mo4754("sequencenumber", Long.valueOf(this.f5381));
        r4.mo4754("serialnumber", Long.valueOf(this.f5380));
        r4.mo4754("sessiondata", "(redacted)");
        C1405Dv r5 = r3.m4727();
        r5.mo4754("tokendata", r4);
        r5.mo4754("signature", this.f5388 != null ? this.f5388 : "(null)");
        return r5.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DV)) {
            return false;
        }
        DV dv = (DV) obj;
        return this.f5380 == dv.f5380 && this.f5381 == dv.f5381 && this.f5387 == dv.f5387;
    }

    public int hashCode() {
        return (String.valueOf(this.f5380) + ":" + String.valueOf(this.f5381) + ":" + String.valueOf(this.f5387)).hashCode();
    }
}

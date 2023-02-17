package o;

import com.netflix.msl.MslConstants;
import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.HashMap;
import java.util.Map;
public class DU implements AbstractC1399Dp {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final byte[] f5364;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final byte[] f5365;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final MslConstants.CompressionAlgorithm f5366;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final long f5367;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final byte[] f5368;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f5369;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1386Dc f5370;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final MslContext f5371;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final boolean f5372;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Map<C1407Dx, byte[]> f5373;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final long f5374;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final byte[] f5375;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final boolean f5376;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static AbstractC1386Dc m4679(AbstractC1400Dq dq, C1405Dv dv, Map<String, AbstractC1386Dc> map) {
        try {
            byte[] r4 = dv.mo4761("tokendata");
            if (r4.length == 0) {
                throw new MslEncodingException(CK.f4908, "servicetoken " + dv);
            }
            String r6 = dq.mo3176(r4).m4752("name");
            if (map.containsKey(r6)) {
                return map.get(r6);
            }
            return map.get("");
        } catch (MslEncoderException e) {
            throw new MslEncodingException(CK.f4804, "servicetoken " + dv, e);
        }
    }

    public DU(MslContext mslContext, C1405Dv dv, DV dv2, C1411Eb eb, Map<String, AbstractC1386Dc> map) {
        this(mslContext, dv, dv2, eb, m4679(mslContext.mo3174(), dv, map));
    }

    public DU(MslContext mslContext, C1405Dv dv, DV dv2, C1411Eb eb, AbstractC1386Dc dc) {
        this.f5373 = new HashMap();
        this.f5371 = mslContext;
        this.f5370 = dc;
        AbstractC1400Dq r5 = mslContext.mo3174();
        try {
            this.f5365 = dv.mo4761("tokendata");
            if (this.f5365.length == 0) {
                throw new MslEncodingException(CK.f4908, "servicetoken " + dv).mo3076(dv2).mo3086(eb);
            }
            this.f5368 = dv.mo4761("signature");
            this.f5372 = dc != null ? dc.mo4324(this.f5365, this.f5368, r5) : false;
            try {
                C1405Dv r6 = r5.mo3176(this.f5365);
                this.f5369 = r6.m4752("name");
                if (r6.m4750("mtserialnumber")) {
                    this.f5367 = r6.m4763("mtserialnumber");
                    if (this.f5367 < 0 || this.f5367 > 9007199254740992L) {
                        throw new MslException(CK.f4905, "servicetokendata " + r6).mo3076(dv2).mo3086(eb);
                    }
                } else {
                    this.f5367 = -1;
                }
                if (r6.m4750("uitserialnumber")) {
                    this.f5374 = r6.m4763("uitserialnumber");
                    if (this.f5374 < 0 || this.f5374 > 9007199254740992L) {
                        throw new MslException(CK.f4904, "servicetokendata " + r6).mo3076(dv2).mo3086(eb);
                    }
                } else {
                    this.f5374 = -1;
                }
                this.f5376 = r6.m4757("encrypted");
                if (r6.m4750("compressionalgo")) {
                    String r7 = r6.m4752("compressionalgo");
                    try {
                        this.f5366 = MslConstants.CompressionAlgorithm.valueOf(r7);
                    } catch (IllegalArgumentException e) {
                        throw new MslException(CK.f4789, r7, e);
                    }
                } else {
                    this.f5366 = null;
                }
                byte[] r72 = r6.mo4761("servicedata");
                if (this.f5372) {
                    this.f5364 = (!this.f5376 || r72.length <= 0) ? r72 : dc.mo4322(r72, r5);
                    this.f5375 = this.f5366 != null ? C1420Ek.m4899(this.f5366, this.f5364) : this.f5364;
                } else {
                    this.f5364 = r72;
                    this.f5375 = r72.length == 0 ? new byte[0] : null;
                }
                if (this.f5367 != -1 && (dv2 == null || this.f5367 != dv2.m4698())) {
                    throw new MslException(CK.f4893, "st mtserialnumber " + this.f5367 + "; mt " + dv2).mo3076(dv2).mo3086(eb);
                } else if (this.f5374 == -1) {
                } else {
                    if (eb == null || this.f5374 != eb.m4868()) {
                        throw new MslException(CK.f4896, "st uitserialnumber " + this.f5374 + "; uit " + eb).mo3076(dv2).mo3086(eb);
                    }
                }
            } catch (MslEncoderException e2) {
                throw new MslEncodingException(CK.f4804, "servicetokendata " + C1418Ei.m4892(this.f5365), e2).mo3076(dv2).mo3086(eb);
            } catch (MslCryptoException e3) {
                e3.mo3076(dv2);
                e3.mo3086(eb);
                throw e3;
            }
        } catch (MslEncoderException e4) {
            throw new MslEncodingException(CK.f4804, "servicetoken " + dv, e4).mo3076(dv2).mo3086(eb);
        } catch (MslCryptoException e5) {
            e5.mo3076(dv2);
            throw e5;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m4685() {
        return this.f5369;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m4687() {
        return this.f5375 != null && this.f5375.length == 0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] m4682() {
        return this.f5375;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public long m4683() {
        return this.f5367;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m4686() {
        return this.f5367 != -1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m4684(DV dv) {
        return dv != null && dv.m4698() == this.f5367;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public long m4689() {
        return this.f5374;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m4681() {
        return this.f5374 != -1;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m4688(C1411Eb eb) {
        return eb != null && eb.m4868() == this.f5374;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m4680() {
        return this.f5367 == -1 && this.f5374 == -1;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        Object obj;
        byte[] bArr;
        if (this.f5373.containsKey(dx)) {
            return this.f5373.get(dx);
        }
        if (this.f5365 == null && this.f5368 == null) {
            try {
                Object r6 = (!this.f5376 || this.f5364.length <= 0) ? this.f5364 : this.f5370.mo4323(this.f5364, dq, dx);
                C1405Dv r7 = dq.m4727();
                r7.mo4754("name", this.f5369);
                if (this.f5367 != -1) {
                    r7.mo4754("mtserialnumber", Long.valueOf(this.f5367));
                }
                if (this.f5374 != -1) {
                    r7.mo4754("uitserialnumber", Long.valueOf(this.f5374));
                }
                r7.mo4754("encrypted", Boolean.valueOf(this.f5376));
                if (this.f5366 != null) {
                    r7.mo4754("compressionalgo", this.f5366.name());
                }
                r7.mo4754("servicedata", r6);
                bArr = dq.mo3178(r7, dx);
                try {
                    obj = this.f5370.mo4325(bArr, dq, dx);
                } catch (MslCryptoException e) {
                    throw new MslEncoderException("Error signing the token data.", e);
                }
            } catch (MslCryptoException e2) {
                throw new MslEncoderException("Error encrypting the service data.", e2);
            }
        } else {
            bArr = this.f5365;
            obj = this.f5368;
        }
        C1405Dv r62 = dq.m4727();
        r62.mo4754("tokendata", bArr);
        r62.mo4754("signature", obj);
        byte[] r72 = dq.mo3178(r62, dx);
        this.f5373.put(dx, r72);
        return r72;
    }

    public String toString() {
        AbstractC1400Dq r3 = this.f5371.mo3174();
        C1405Dv r4 = r3.m4727();
        r4.mo4754("name", this.f5369);
        r4.mo4754("mtserialnumber", Long.valueOf(this.f5367));
        r4.mo4754("uitserialnumber", Long.valueOf(this.f5374));
        r4.mo4754("servicedata", "(redacted)");
        C1405Dv r5 = r3.m4727();
        r5.mo4754("tokendata", r4);
        r5.mo4754("signature", this.f5368 != null ? this.f5368 : "(null)");
        return r5.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DU)) {
            return false;
        }
        DU du = (DU) obj;
        return this.f5369.equals(du.f5369) && this.f5367 == du.f5367 && this.f5374 == du.f5374;
    }

    public int hashCode() {
        return (this.f5369 + ":" + String.valueOf(this.f5367) + ":" + String.valueOf(this.f5374)).hashCode();
    }
}

package o;

import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.msl.MslConstants;
import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.MslMessageException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class DN implements AbstractC1399Dp {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final byte[] f5326;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final MslConstants.CompressionAlgorithm f5327;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final long f5328;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final boolean f5329;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1405Dv f5330;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final long f5331;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Map<C1407Dx, byte[]> f5332 = new HashMap();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC1386Dc f5333;

    public DN(MslContext mslContext, long j, long j2, boolean z, MslConstants.CompressionAlgorithm compressionAlgorithm, byte[] bArr, AbstractC1386Dc dc) {
        byte[] bArr2;
        if (j < 0 || j > 9007199254740992L) {
            throw new MslInternalException("Sequence number " + j + " is outside the valid range.");
        } else if (j2 < 0 || j2 > 9007199254740992L) {
            throw new MslInternalException("Message ID " + j2 + " is outside the valid range.");
        } else {
            if (compressionAlgorithm != null) {
                byte[] r5 = C1420Ek.m4900(compressionAlgorithm, bArr);
                if (r5 == null || r5.length >= bArr.length) {
                    this.f5327 = null;
                    bArr2 = bArr;
                } else {
                    this.f5327 = compressionAlgorithm;
                    bArr2 = r5;
                }
            } else {
                this.f5327 = null;
                bArr2 = bArr;
            }
            this.f5328 = j;
            this.f5331 = j2;
            this.f5329 = z;
            this.f5326 = bArr;
            this.f5330 = mslContext.mo3174().m4727();
            this.f5330.mo4754("sequencenumber", Long.valueOf(this.f5328));
            this.f5330.mo4754("messageid", Long.valueOf(this.f5331));
            if (this.f5329) {
                this.f5330.mo4754("endofmsg", Boolean.valueOf(this.f5329));
            }
            if (this.f5327 != null) {
                this.f5330.mo4754("compressionalgo", this.f5327.name());
            }
            this.f5330.mo4754(Event.DATA, bArr2);
            this.f5333 = dc;
        }
    }

    public DN(MslContext mslContext, C1405Dv dv, AbstractC1386Dc dc) {
        AbstractC1400Dq r4 = mslContext.mo3174();
        this.f5333 = dc;
        try {
            byte[] r5 = dv.mo4761("payload");
            if (!dc.mo4324(r5, dv.mo4761("signature"), r4)) {
                throw new MslCryptoException(CK.f4774);
            }
            byte[] r6 = dc.mo4322(r5, r4);
            try {
                this.f5330 = r4.mo3176(r6);
                this.f5328 = this.f5330.m4763("sequencenumber");
                if (this.f5328 < 0 || this.f5328 > 9007199254740992L) {
                    throw new MslException(CK.f4800, "payload chunk payload " + this.f5330);
                }
                this.f5331 = this.f5330.m4763("messageid");
                if (this.f5331 < 0 || this.f5331 > 9007199254740992L) {
                    throw new MslException(CK.f4797, "payload chunk payload " + this.f5330);
                }
                this.f5329 = this.f5330.m4750("endofmsg") ? this.f5330.m4757("endofmsg") : false;
                if (this.f5330.m4750("compressionalgo")) {
                    String r7 = this.f5330.m4752("compressionalgo");
                    try {
                        this.f5327 = MslConstants.CompressionAlgorithm.valueOf(r7);
                    } catch (IllegalArgumentException e) {
                        throw new MslMessageException(CK.f4789, r7, e);
                    }
                } else {
                    this.f5327 = null;
                }
                byte[] r72 = this.f5330.mo4761(Event.DATA);
                if (r72.length == 0) {
                    if (!this.f5329) {
                        throw new MslMessageException(CK.f4782);
                    }
                    this.f5326 = new byte[0];
                } else if (this.f5327 == null) {
                    this.f5326 = r72;
                } else {
                    this.f5326 = C1420Ek.m4899(this.f5327, r72);
                }
            } catch (MslEncoderException e2) {
                throw new MslEncodingException(CK.f4804, "payload chunk payload " + C1418Ei.m4892(r6), e2);
            }
        } catch (MslEncoderException e3) {
            throw new MslEncodingException(CK.f4804, "payload chunk " + dv, e3);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m4654() {
        return this.f5328;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m4655() {
        return this.f5331;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m4656() {
        return this.f5329;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public MslConstants.CompressionAlgorithm m4653() {
        return this.f5327;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] m4652() {
        return this.f5326;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        if (this.f5332.containsKey(dx)) {
            return this.f5332.get(dx);
        }
        try {
            byte[] r3 = this.f5333.mo4323(dq.mo3178(this.f5330, dx), dq, dx);
            try {
                Object r4 = this.f5333.mo4325(r3, dq, dx);
                C1405Dv r5 = dq.m4727();
                r5.mo4754("payload", r3);
                r5.mo4754("signature", r4);
                byte[] r6 = dq.mo3178(r5, dx);
                this.f5332.put(dx, r6);
                return r6;
            } catch (MslCryptoException e) {
                throw new MslEncoderException("Error signing the payload.", e);
            }
        } catch (MslCryptoException e2) {
            throw new MslEncoderException("Error encrypting the payload.", e2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DN)) {
            return false;
        }
        DN dn = (DN) obj;
        return this.f5328 == dn.f5328 && this.f5331 == dn.f5331 && this.f5329 == dn.f5329 && this.f5327 == dn.f5327 && Arrays.equals(this.f5326, dn.f5326);
    }

    public int hashCode() {
        return (((Long.valueOf(this.f5328).hashCode() ^ Long.valueOf(this.f5331).hashCode()) ^ Boolean.valueOf(this.f5329).hashCode()) ^ (this.f5327 != null ? this.f5327.hashCode() : 0)) ^ Arrays.hashCode(this.f5326);
    }
}

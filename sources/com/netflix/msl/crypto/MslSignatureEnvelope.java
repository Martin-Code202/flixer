package com.netflix.msl.crypto;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.msl.MslConstants;
import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.io.MslEncoderException;
import o.AbstractC1400Dq;
import o.C1405Dv;
import o.C1407Dx;
import o.C1418Ei;
import o.CK;
public class MslSignatureEnvelope {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final byte[] f4142;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Version f4143;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final MslConstants.SignatureAlgo f4144;

    public enum Version {
        V1,
        V2;

        /* renamed from: ˎ  reason: contains not printable characters */
        public static Version m3120(int i) {
            switch (i) {
                case 1:
                    return V1;
                case 2:
                    return V2;
                default:
                    throw new IllegalArgumentException("Unknown signature envelope version.");
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public int m3121() {
            switch (this) {
                case V1:
                    return 1;
                case V2:
                    return 2;
                default:
                    throw new MslInternalException("No integer value defined for version " + this + ".");
            }
        }
    }

    public MslSignatureEnvelope(byte[] bArr) {
        this.f4143 = Version.V1;
        this.f4144 = null;
        this.f4142 = bArr;
    }

    public MslSignatureEnvelope(MslConstants.SignatureAlgo signatureAlgo, byte[] bArr) {
        this.f4143 = Version.V2;
        this.f4144 = signatureAlgo;
        this.f4142 = bArr;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static MslSignatureEnvelope m3117(byte[] bArr, AbstractC1400Dq dq) {
        C1405Dv dv;
        Version version;
        try {
            dv = dq.mo3176(bArr);
        } catch (MslEncoderException e) {
            dv = null;
        }
        if (dv == null || !dv.m4750(LoggingRequest.VERSION)) {
            version = Version.V1;
        } else {
            try {
                version = Version.m3120(dv.m4755(LoggingRequest.VERSION));
            } catch (MslEncoderException e2) {
                version = Version.V1;
            } catch (IllegalArgumentException e3) {
                version = Version.V1;
            }
        }
        switch (version) {
            case V1:
                return new MslSignatureEnvelope(bArr);
            case V2:
                try {
                    return new MslSignatureEnvelope(MslConstants.SignatureAlgo.m3075(dv.m4752("algorithm")), dv.mo4761("signature"));
                } catch (MslEncoderException e4) {
                    return new MslSignatureEnvelope(bArr);
                } catch (IllegalArgumentException e5) {
                    return new MslSignatureEnvelope(bArr);
                }
            default:
                throw new MslCryptoException(CK.f4928, "signature envelope " + C1418Ei.m4892(bArr));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] m3118() {
        return this.f4142;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public byte[] m3119(AbstractC1400Dq dq, C1407Dx dx) {
        switch (this.f4143) {
            case V1:
                return this.f4142;
            case V2:
                C1405Dv r3 = dq.m4727();
                r3.mo4754(LoggingRequest.VERSION, Integer.valueOf(this.f4143.m3121()));
                r3.mo4754("algorithm", this.f4144.name());
                r3.mo4754("signature", this.f4142);
                return dq.mo3178(r3, dx);
            default:
                throw new MslInternalException("Signature envelope version " + this.f4143 + " encoding unsupported.");
        }
    }
}

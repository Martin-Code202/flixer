package com.netflix.msl.crypto;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import com.netflix.msl.MslConstants;
import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.io.MslEncoderException;
import o.AbstractC1399Dp;
import o.AbstractC1400Dq;
import o.C1405Dv;
import o.C1407Dx;
import o.C1418Ei;
import o.CK;
public class MslCiphertextEnvelope implements AbstractC1399Dp {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f4133;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final byte[] f4134;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Version f4135;

    /* renamed from: ˏ  reason: contains not printable characters */
    private MslConstants.CipherSpec f4136;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final byte[] f4137;

    public enum Version {
        V1,
        V2;

        /* renamed from: ˏ  reason: contains not printable characters */
        public static Version m3115(int i) {
            switch (i) {
                case 1:
                    return V1;
                case 2:
                    return V2;
                default:
                    throw new IllegalArgumentException("Unknown ciphertext envelope version " + i + ".");
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public int m3116() {
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

    public MslCiphertextEnvelope(String str, byte[] bArr, byte[] bArr2) {
        this.f4135 = Version.V1;
        this.f4133 = str;
        this.f4136 = null;
        this.f4134 = bArr;
        this.f4137 = bArr2;
    }

    public MslCiphertextEnvelope(C1405Dv dv, Version version) {
        switch (version) {
            case V1:
                try {
                    this.f4135 = Version.V1;
                    this.f4133 = dv.m4752("keyid");
                    this.f4136 = null;
                    this.f4134 = dv.m4750("iv") ? dv.mo4761("iv") : null;
                    this.f4137 = dv.mo4761("ciphertext");
                    dv.mo4761("sha256");
                    return;
                } catch (MslEncoderException e) {
                    throw new MslEncodingException(CK.f4804, "ciphertext envelope " + dv, e);
                }
            case V2:
                try {
                    this.f4135 = Version.m3115(dv.m4755(LoggingRequest.VERSION));
                    if (!Version.V2.equals(this.f4135)) {
                        throw new MslCryptoException(CK.f4922, "ciphertext envelope " + dv.toString());
                    }
                    this.f4133 = null;
                    try {
                        this.f4136 = MslConstants.CipherSpec.m3070(dv.m4752("cipherspec"));
                        this.f4134 = dv.m4750("iv") ? dv.mo4761("iv") : null;
                        this.f4137 = dv.mo4761("ciphertext");
                        return;
                    } catch (IllegalArgumentException e2) {
                        throw new MslCryptoException(CK.f4939, "ciphertext envelope " + dv, e2);
                    }
                } catch (MslEncoderException e3) {
                    throw new MslEncodingException(CK.f4804, "ciphertext envelope " + dv, e3);
                }
            default:
                throw new MslCryptoException(CK.f4932, "ciphertext envelope version " + version);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m3112() {
        return this.f4133;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] m3111() {
        return this.f4134;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public byte[] m3113() {
        return this.f4137;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ  reason: contains not printable characters */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r3 = dq.m4727();
        switch (this.f4135) {
            case V1:
                r3.mo4754("keyid", this.f4133);
                if (this.f4134 != null) {
                    r3.mo4754("iv", this.f4134);
                }
                r3.mo4754("ciphertext", this.f4137);
                r3.mo4754("sha256", C1418Ei.m4894("AA=="));
                break;
            case V2:
                r3.mo4754(LoggingRequest.VERSION, Integer.valueOf(this.f4135.m3116()));
                r3.mo4754("cipherspec", this.f4136.toString());
                if (this.f4134 != null) {
                    r3.mo4754("iv", this.f4134);
                }
                r3.mo4754("ciphertext", this.f4137);
                break;
            default:
                throw new MslEncoderException("Ciphertext envelope version " + this.f4135 + " encoding unsupported.");
        }
        return dq.mo3178(r3, dx);
    }
}

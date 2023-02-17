package o;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.service.msl.client.WidevineContextException;
import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.crypto.MslCiphertextEnvelope;
import com.netflix.msl.crypto.MslSignatureEnvelope;
import com.netflix.msl.util.MslContext;
import o.AbstractC0472;
/* renamed from: o.gI  reason: case insensitive filesystem */
public class C1803gI implements AbstractC1386Dc {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean f6894 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    private MslContext f6895;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6896;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC0472.Cif f6897;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC0472.Cif f6898;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private transient AbstractC0472.C0474 f6899;

    private C1803gI(MslContext mslContext, C0355 r8) {
        String r2 = r8.m13980("encryptionKeyId");
        String r3 = r8.m13972("hmacKeyId");
        String r4 = r8.m13972("envelopeId");
        String r5 = r8.m13972("keySetId");
        C1283.m16854("nf_msl", "WidevineCryptoContex:: restoring crypto session....");
        if (mslContext == null) {
            throw new IllegalStateException("MSL context is null!");
        } else if (C1349Bv.m4113(r4)) {
            throw new IllegalStateException("envelopeId is null!");
        } else {
            this.f6895 = mslContext;
            this.f6898 = new AbstractC0472.Cif(r2);
            this.f6897 = new AbstractC0472.Cif(r3);
            this.f6896 = r4;
            this.f6899 = C0480.m14408().mo14360(new AbstractC0472.Cif(r5));
            if (this.f6899 == null) {
                throw new IllegalStateException("Unable to restore crypto session!");
            }
        }
    }

    public C1803gI(MslContext mslContext, String str, DF df, DG dg, DV dv) {
        C1283.m16854("nf_msl", "WidevineCryptoContex::");
        if (mslContext == null) {
            throw new IllegalStateException("MSL context is null!");
        } else if (df == null) {
            throw new IllegalStateException("CDM request is null!");
        } else if (dg == null) {
            throw new IllegalStateException("CDM response is null!");
        } else {
            this.f6895 = mslContext;
            this.f6898 = new AbstractC0472.Cif(dg.m4600());
            this.f6897 = new AbstractC0472.Cif(dg.m4599());
            this.f6896 = str + "_" + dg.m4587().m4695();
            this.f6899 = C0480.m14408().mo14359(df, dg.m4601(), this.f6898, this.f6897);
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˋ */
    public byte[] mo4323(byte[] bArr, AbstractC1400Dq dq, C1407Dx dx) {
        byte[] bArr2;
        if (this.f6898 == null) {
            throw new MslCryptoException(CK.f4899, "no encryption/decryption key");
        }
        try {
            byte[] bArr3 = new byte[16];
            this.f6895.mo3173().nextBytes(bArr3);
            if (bArr.length != 0) {
                bArr2 = C0480.m14408().mo14357(this.f6899, this.f6898, bArr, bArr3);
            } else {
                bArr2 = new byte[0];
            }
            return new MslCiphertextEnvelope(this.f6896, bArr3, bArr2).mo3114(dq, dx);
        } catch (Throwable th) {
            throw new WidevineContextException("WidevineCryptoContext::encrypt failed.", StatusCode.MSL_WV_ENCRYPT_ERROR, th);
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˊ */
    public byte[] mo4322(byte[] bArr, AbstractC1400Dq dq) {
        if (this.f6898 == null) {
            throw new MslCryptoException(CK.f4891, "no encryption/decryption key");
        }
        try {
            MslCiphertextEnvelope mslCiphertextEnvelope = new MslCiphertextEnvelope(dq.mo3176(bArr), MslCiphertextEnvelope.Version.V1);
            if (!mslCiphertextEnvelope.m3112().equals(this.f6896)) {
                throw new MslCryptoException(CK.f4794);
            }
            byte[] r5 = mslCiphertextEnvelope.m3113();
            if (r5.length == 0) {
                return new byte[0];
            }
            return C0480.m14408().mo14361(this.f6899, this.f6898, r5, mslCiphertextEnvelope.m3111());
        } catch (Throwable th) {
            throw new WidevineContextException("WidevineCryptoContext::decrypt failed.", StatusCode.MSL_WV_DECRYPT_ERROR, th);
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˏ */
    public byte[] mo4325(byte[] bArr, AbstractC1400Dq dq, C1407Dx dx) {
        if (this.f6897 == null) {
            throw new MslCryptoException(CK.f4815, "No signature key.");
        }
        try {
            return new MslSignatureEnvelope(C0480.m14408().mo14362(this.f6899, this.f6897, bArr)).m3119(dq, dx);
        } catch (Throwable th) {
            throw new WidevineContextException("WidevineCryptoContext::sign failed.", StatusCode.MSL_WV_SIGN_ERROR, th);
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˏ */
    public boolean mo4324(byte[] bArr, byte[] bArr2, AbstractC1400Dq dq) {
        if (this.f6897 == null) {
            throw new MslCryptoException(CK.f4900, "No signature key.");
        }
        try {
            return C0480.m14408().mo14363(this.f6899, this.f6897, bArr, MslSignatureEnvelope.m3117(bArr2, dq).m3118());
        } catch (MslEncodingException e) {
            throw new MslCryptoException(CK.f4937, e);
        } catch (MslCryptoException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new WidevineContextException("WidevineCryptoContext::verify failed.", StatusCode.MSL_WV_VERIFY_ERROR, th);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0355 m6564() {
        C0355 r2 = new C0355();
        r2.m13986("encryptionKeyId", this.f6898.m14370());
        r2.m13986("hmacKeyId", this.f6897.m14370());
        r2.m13986("envelopeId", this.f6896);
        r2.m13986("keySetId", this.f6899.f13524.m14370());
        return r2;
    }

    public String toString() {
        return "WidevineCryptoContext{encryptionKeyId='" + this.f6898 + "', hmacKeyId='" + this.f6897 + "', ctx=" + this.f6895 + ", envelopeId='" + this.f6896 + "', cryptoSession='" + this.f6899 + "'}";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6565() {
        C1283.m16854("nf_msl", "Widevine crypto context, release crypto session!");
        C0480.m14408().mo14356(this.f6899);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1803gI m6563(MslContext mslContext, C0355 r2) {
        return new C1803gI(mslContext, r2);
    }
}

package o;

import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.crypto.MslCiphertextEnvelope;
import com.netflix.msl.crypto.MslSignatureEnvelope;
import com.netflix.msl.io.MslEncoderException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
public abstract class CY implements AbstractC1386Dc {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f5137;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final PrivateKey f5138;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected final String f5139;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f5140;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final PublicKey f5141;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AlgorithmParameterSpec f5142;

    protected CY(String str, PrivateKey privateKey, PublicKey publicKey, String str2, AlgorithmParameterSpec algorithmParameterSpec, String str3) {
        this.f5139 = str;
        this.f5138 = privateKey;
        this.f5141 = publicKey;
        this.f5140 = str2;
        this.f5142 = algorithmParameterSpec;
        this.f5137 = str3;
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˋ */
    public byte[] mo4323(byte[] bArr, AbstractC1400Dq dq, C1407Dx dx) {
        if ("nullOp".equals(this.f5140)) {
            return bArr;
        }
        if (this.f5141 == null) {
            throw new MslCryptoException(CK.f4899, "no public key");
        }
        NoSuchPaddingException noSuchPaddingException = null;
        try {
            Cipher r4 = CV.m4317(this.f5140);
            r4.init(1, this.f5141, this.f5142);
            return new MslCiphertextEnvelope(this.f5139, null, r4.doFinal(bArr)).mo3114(dq, dx);
        } catch (NoSuchPaddingException e) {
            noSuchPaddingException = e;
            throw new MslInternalException("Unsupported padding exception.", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new MslInternalException("Invalid cipher algorithm specified.", e2);
        } catch (InvalidKeyException e3) {
            throw new MslCryptoException(CK.f4842, e3);
        } catch (IllegalBlockSizeException e4) {
            throw new MslCryptoException(CK.f4737, "not expected when padding is specified", e4);
        } catch (BadPaddingException e5) {
            throw new MslCryptoException(CK.f4912, "not expected when encrypting", e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new MslCryptoException(CK.f4884, e6);
        } catch (MslEncoderException e7) {
            throw new MslCryptoException(CK.f4849, e7);
        } catch (RuntimeException e8) {
            throw e8;
        } catch (Throwable th) {
            if (noSuchPaddingException != null) {
                CV.m4316(this.f5140);
            }
            throw th;
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˊ */
    public byte[] mo4322(byte[] bArr, AbstractC1400Dq dq) {
        if ("nullOp".equals(this.f5140)) {
            return bArr;
        }
        if (this.f5138 == null) {
            throw new MslCryptoException(CK.f4891, "no private key");
        }
        NoSuchPaddingException noSuchPaddingException = null;
        try {
            MslCiphertextEnvelope mslCiphertextEnvelope = new MslCiphertextEnvelope(dq.mo3176(bArr), MslCiphertextEnvelope.Version.V1);
            Cipher r6 = CV.m4317(this.f5140);
            r6.init(2, this.f5138, this.f5142);
            return r6.doFinal(mslCiphertextEnvelope.m3113());
        } catch (NoSuchPaddingException e) {
            noSuchPaddingException = e;
            throw new MslInternalException("Unsupported padding exception.", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new MslInternalException("Invalid cipher algorithm specified.", e2);
        } catch (InvalidKeyException e3) {
            throw new MslCryptoException(CK.f4832, e3);
        } catch (IllegalBlockSizeException e4) {
            throw new MslCryptoException(CK.f4745, e4);
        } catch (BadPaddingException e5) {
            throw new MslCryptoException(CK.f4753, e5);
        } catch (MslEncoderException e6) {
            throw new MslCryptoException(CK.f4862, e6);
        } catch (MslEncodingException e7) {
            throw new MslCryptoException(CK.f4862, e7);
        } catch (InvalidAlgorithmParameterException e8) {
            throw new MslCryptoException(CK.f4884, e8);
        } catch (RuntimeException e9) {
            throw e9;
        } catch (Throwable th) {
            if (noSuchPaddingException != null) {
                CV.m4316(this.f5140);
            }
            throw th;
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˏ */
    public byte[] mo4325(byte[] bArr, AbstractC1400Dq dq, C1407Dx dx) {
        if ("nullOp".equals(this.f5137)) {
            return new byte[0];
        }
        if (this.f5138 == null) {
            throw new MslCryptoException(CK.f4815, "no private key.");
        }
        try {
            Signature r3 = CV.m4319(this.f5137);
            r3.initSign(this.f5138);
            r3.update(bArr);
            return new MslSignatureEnvelope(r3.sign()).m3119(dq, dx);
        } catch (NoSuchAlgorithmException e) {
            throw new MslInternalException("Invalid signature algorithm specified.", e);
        } catch (InvalidKeyException e2) {
            throw new MslCryptoException(CK.f4832, e2);
        } catch (SignatureException e3) {
            throw new MslCryptoException(CK.f4892, e3);
        } catch (MslEncoderException e4) {
            throw new MslCryptoException(CK.f4949, e4);
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˏ */
    public boolean mo4324(byte[] bArr, byte[] bArr2, AbstractC1400Dq dq) {
        if ("nullOp".equals(this.f5137)) {
            return true;
        }
        if (this.f5141 == null) {
            throw new MslCryptoException(CK.f4900, "no public key.");
        }
        try {
            MslSignatureEnvelope r3 = MslSignatureEnvelope.m3117(bArr2, dq);
            Signature r4 = CV.m4319(this.f5137);
            r4.initVerify(this.f5141);
            r4.update(bArr);
            return r4.verify(r3.m3118());
        } catch (NoSuchAlgorithmException e) {
            throw new MslInternalException("Invalid signature algorithm specified.", e);
        } catch (InvalidKeyException e2) {
            throw new MslCryptoException(CK.f4842, e2);
        } catch (SignatureException e3) {
            throw new MslCryptoException(CK.f4892, e3);
        } catch (MslEncodingException e4) {
            throw new MslCryptoException(CK.f4937, e4);
        }
    }
}

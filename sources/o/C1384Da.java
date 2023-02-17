package o;

import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.crypto.MslCiphertextEnvelope;
import com.netflix.msl.crypto.MslSignatureEnvelope;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.KeyParameter;
/* renamed from: o.Da  reason: case insensitive filesystem */
public class C1384Da implements AbstractC1386Dc {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final byte[] f5401 = {-90, -90, -90, -90, -90, -90, -90, -90};

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final SecretKey f5402;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected final String f5403;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected final MslContext f5404;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final SecretKey f5405;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final SecretKey f5406;

    public C1384Da(MslContext mslContext, String str, SecretKey secretKey, SecretKey secretKey2, SecretKey secretKey3) {
        if (secretKey != null && !secretKey.getAlgorithm().equals("AES")) {
            throw new IllegalArgumentException("Encryption key must be an AES key.");
        } else if (secretKey2 != null && !secretKey2.getAlgorithm().equals("HmacSHA256") && !secretKey2.getAlgorithm().equals("AESCmac")) {
            throw new IllegalArgumentException("Encryption key must be an HmacSHA256 or AESCmac key.");
        } else if (secretKey3 == null || secretKey3.getAlgorithm().equals("AES")) {
            this.f5404 = mslContext;
            this.f5403 = str;
            this.f5402 = secretKey;
            this.f5406 = secretKey2;
            this.f5405 = secretKey3;
        } else {
            throw new IllegalArgumentException("Encryption key must be an AES key.");
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˋ */
    public byte[] mo4323(byte[] bArr, AbstractC1400Dq dq, C1407Dx dx) {
        byte[] bArr2;
        if (this.f5402 == null) {
            throw new MslCryptoException(CK.f4899, "no encryption/decryption key");
        }
        try {
            byte[] bArr3 = new byte[16];
            this.f5404.mo3173().nextBytes(bArr3);
            if (bArr.length != 0) {
                Cipher r6 = CV.m4317("AES/CBC/PKCS5Padding");
                r6.init(1, this.f5402, new IvParameterSpec(bArr3));
                bArr2 = r6.doFinal(bArr);
            } else {
                bArr2 = new byte[0];
            }
            return new MslCiphertextEnvelope(this.f5403, bArr3, bArr2).mo3114(dq, dx);
        } catch (NoSuchPaddingException e) {
            throw new MslInternalException("Unsupported padding exception.", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new MslInternalException("Invalid cipher algorithm specified.", e2);
        } catch (InvalidKeyException e3) {
            throw new MslCryptoException(CK.f4759, e3);
        } catch (InvalidAlgorithmParameterException e4) {
            throw new MslCryptoException(CK.f4884, e4);
        } catch (IllegalBlockSizeException e5) {
            throw new MslCryptoException(CK.f4737, "not expected when padding is specified", e5);
        } catch (BadPaddingException e6) {
            throw new MslCryptoException(CK.f4912, "not expected when encrypting", e6);
        } catch (MslEncoderException e7) {
            throw new MslCryptoException(CK.f4849, e7);
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˊ */
    public byte[] mo4322(byte[] bArr, AbstractC1400Dq dq) {
        if (this.f5402 == null) {
            throw new MslCryptoException(CK.f4891, "no encryption/decryption key");
        }
        try {
            MslCiphertextEnvelope mslCiphertextEnvelope = new MslCiphertextEnvelope(dq.mo3176(bArr), MslCiphertextEnvelope.Version.V1);
            byte[] r5 = mslCiphertextEnvelope.m3113();
            if (r5.length == 0) {
                return new byte[0];
            }
            byte[] r6 = mslCiphertextEnvelope.m3111();
            Cipher r7 = CV.m4317("AES/CBC/PKCS5Padding");
            r7.init(2, this.f5402, new IvParameterSpec(r6));
            return r7.doFinal(r5);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MslCryptoException(CK.f4751, e);
        } catch (MslEncoderException e2) {
            throw new MslCryptoException(CK.f4862, e2);
        } catch (MslEncodingException e3) {
            throw new MslCryptoException(CK.f4862, e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new MslInternalException("Invalid cipher algorithm specified.", e4);
        } catch (NoSuchPaddingException e5) {
            throw new MslInternalException("Unsupported padding exception.", e5);
        } catch (InvalidKeyException e6) {
            throw new MslCryptoException(CK.f4759, e6);
        } catch (InvalidAlgorithmParameterException e7) {
            throw new MslCryptoException(CK.f4884, e7);
        } catch (IllegalBlockSizeException e8) {
            throw new MslCryptoException(CK.f4745, e8);
        } catch (BadPaddingException e9) {
            throw new MslCryptoException(CK.f4753, e9);
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˏ */
    public byte[] mo4325(byte[] bArr, AbstractC1400Dq dq, C1407Dx dx) {
        byte[] bArr2;
        if (this.f5406 == null) {
            throw new MslCryptoException(CK.f4815, "No signature key.");
        }
        try {
            if (this.f5406.getAlgorithm().equals("HmacSHA256")) {
                Mac r4 = CV.m4318("HmacSHA256");
                r4.init(this.f5406);
                bArr2 = r4.doFinal(bArr);
            } else if (this.f5406.getAlgorithm().equals("AESCmac")) {
                KeyParameter keyParameter = new KeyParameter(this.f5406.getEncoded());
                CMac cMac = new CMac(new AESEngine());
                cMac.init(keyParameter);
                cMac.update(bArr, 0, bArr.length);
                bArr2 = new byte[cMac.getMacSize()];
                cMac.doFinal(bArr2, 0);
            } else {
                throw new MslCryptoException(CK.f4815, "Unsupported algorithm.");
            }
            return new MslSignatureEnvelope(bArr2).m3119(dq, dx);
        } catch (NoSuchAlgorithmException e) {
            throw new MslInternalException("Invalid MAC algorithm specified.", e);
        } catch (InvalidKeyException e2) {
            throw new MslCryptoException(CK.f4761, e2);
        } catch (MslEncoderException e3) {
            throw new MslCryptoException(CK.f4949, e3);
        }
    }

    @Override // o.AbstractC1386Dc
    /* renamed from: ˏ */
    public boolean mo4324(byte[] bArr, byte[] bArr2, AbstractC1400Dq dq) {
        byte[] bArr3;
        if (this.f5406 == null) {
            throw new MslCryptoException(CK.f4900, "No signature key.");
        }
        try {
            MslSignatureEnvelope r3 = MslSignatureEnvelope.m3117(bArr2, dq);
            if (this.f5406.getAlgorithm().equals("HmacSHA256")) {
                Mac r5 = CV.m4318("HmacSHA256");
                r5.init(this.f5406);
                bArr3 = r5.doFinal(bArr);
            } else if (this.f5406.getAlgorithm().equals("AESCmac")) {
                KeyParameter keyParameter = new KeyParameter(this.f5406.getEncoded());
                CMac cMac = new CMac(new AESEngine());
                cMac.init(keyParameter);
                cMac.update(bArr, 0, bArr.length);
                bArr3 = new byte[cMac.getMacSize()];
                cMac.doFinal(bArr3, 0);
            } else {
                throw new MslCryptoException(CK.f4900, "Unsupported algorithm.");
            }
            return C1420Ek.m4898(bArr3, r3.m3118());
        } catch (MslEncodingException e) {
            throw new MslCryptoException(CK.f4937, e);
        } catch (NoSuchAlgorithmException e2) {
            throw new MslInternalException("Invalid MAC algorithm specified.", e2);
        } catch (InvalidKeyException e3) {
            throw new MslCryptoException(CK.f4761, e3);
        }
    }
}

package o;

import com.netflix.mediaclient.service.player.subtitles.image.v2.SegmentEncryptionInfo;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: o.mz  reason: case insensitive filesystem */
public class C1995mz implements mE {
    @Override // o.mE
    /* renamed from: ˋ */
    public byte[] mo8807(byte[] bArr, SegmentEncryptionInfo.C0022 r7, String str, int i) {
        C1283.m16854("nf_subtitles_imv2", "AesCtrImageDecryptor::decrypt: starts...");
        byte[] r2 = C1323Aw.m3800(str);
        byte[] r3 = r7.m1155();
        if (r3.length == 8) {
            r3 = new byte[16];
            for (int i2 = 0; i2 < r7.m1155().length; i2++) {
                r3[i2] = r7.m1155()[i2];
                r3[i2 + 8] = 0;
            }
        }
        return m9108(r2, bArr, r3);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static byte[] m9108(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        Cipher instance = Cipher.getInstance("AES/CTR/NoPadding", "BC");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr2);
    }
}

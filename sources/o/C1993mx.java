package o;

import com.netflix.mediaclient.service.player.subtitles.image.v2.SegmentEncryptionInfo;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: o.mx  reason: case insensitive filesystem */
public class C1993mx implements mE {
    @Override // o.mE
    /* renamed from: ˋ */
    public byte[] mo8807(byte[] bArr, SegmentEncryptionInfo.C0022 r6, String str, int i) {
        C1283.m16854("nf_subtitles_imv2", "AesCbcImageDecryptor::decrypt: starts...");
        return m9107(C1323Aw.m3800(str), bArr, r6.m1155());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static byte[] m9107(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] r2 = C1324Ax.m3811(bArr2, 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
        return instance.doFinal(r2);
    }
}

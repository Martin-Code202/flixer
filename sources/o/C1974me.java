package o;

import android.os.Handler;
import com.netflix.mediaclient.media.SubtitleUrl;
import java.nio.charset.Charset;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import o.AbstractC1979mj;
/* renamed from: o.me  reason: case insensitive filesystem */
public class C1974me extends C1973md {
    public C1974me(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, SubtitleUrl subtitleUrl, mP mPVar, mP mPVar2, float f, AbstractC1979mj.iF iFVar, long j, long j2, AbstractC2055pd pdVar) {
        super(handler, mhVar, mlVar, subtitleUrl, mPVar, mPVar2, f, iFVar, j, j2, pdVar);
        C1283.m16854("nf_subtitles", "Create encrypted text based subtitle parser");
    }

    /* access modifiers changed from: protected */
    @Override // o.C1973md
    /* renamed from: ˏ */
    public boolean mo9004() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.C1973md
    /* renamed from: ॱ */
    public void mo9006(byte[] bArr) {
        m8728(m9007(bArr));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m9007(byte[] bArr) {
        return new String(m9010(C1323Aw.m3800(this.f8868.getDecryptionKey()), m9008(bArr), m9009(bArr)), Charset.forName("UTF-8"));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private byte[] m9009(byte[] bArr) {
        return Arrays.copyOf(bArr, 16);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private byte[] m9008(byte[] bArr) {
        return Arrays.copyOfRange(bArr, 16, bArr.length);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static byte[] m9010(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
        return instance.doFinal(bArr2);
    }
}

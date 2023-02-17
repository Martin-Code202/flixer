package o;

import android.os.Handler;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* renamed from: o.ie  reason: case insensitive filesystem */
public class C1878ie extends C1885im {
    public C1878ie(Handler handler, AbstractC1977mh mhVar, AbstractC1981ml mlVar, AbstractC1884il ilVar, mP mPVar, mP mPVar2, float f, long j, AbstractC2055pd pdVar, boolean z) {
        super(handler, mhVar, mlVar, ilVar, mPVar, mPVar2, f, j, pdVar, Boolean.valueOf(z));
        C1283.m16854("nf_subtitles", "Create encrypted offline text based subtitle parser");
    }

    /* access modifiers changed from: protected */
    @Override // o.C1885im
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo7681() {
        C1283.m16854("nf_subtitles", "Check if cache exist!");
        File file = new File(this.f7763.m7705());
        if (file == null || !file.exists()) {
            C1283.m16850("nf_subtitles", "Offline text subtitle NOT found at " + this.f7763.m7705());
            m8987(ISubtitleDef.SubtitleFailure.download, null);
            return false;
        }
        C1283.m16851("nf_subtitles", "File %s exist", file.getAbsolutePath());
        try {
            byte[] r6 = AH.m3345(file);
            C1283.m16851("nf_subtitles", "Importing subtitles metadata from offline directory size [bytes] %d", Integer.valueOf(r6.length));
            m8728(m7678(r6));
            C1283.m16854("nf_subtitles", "Imported enc data from offline directory!");
            return true;
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "We failed to parse subtitle metadata from cached file", th);
            m8987(ISubtitleDef.SubtitleFailure.parsing, null);
            return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m7678(byte[] bArr) {
        return new String(m7680(C1323Aw.m3800(this.f8868.getDecryptionKey()), m7677(bArr), m7679(bArr)), Charset.forName("UTF-8"));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private byte[] m7679(byte[] bArr) {
        return Arrays.copyOf(bArr, 16);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private byte[] m7677(byte[] bArr) {
        return Arrays.copyOfRange(bArr, 16, bArr.length);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static byte[] m7680(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr3));
        return instance.doFinal(bArr2);
    }
}

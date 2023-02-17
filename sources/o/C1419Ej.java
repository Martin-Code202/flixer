package o;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
/* renamed from: o.Ej  reason: case insensitive filesystem */
public class C1419Ej {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static byte[] m4897(InputStream inputStream, int i) {
        if (i < 128) {
            throw new IllegalArgumentException("Buffer size should be at least 128");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}

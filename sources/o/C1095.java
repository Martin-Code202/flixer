package o;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* renamed from: o.丶  reason: contains not printable characters */
public class C1095 {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static byte[] m16187(String str) {
        return m16189(new File(str.replaceFirst("file://", "")));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static byte[] m16189(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = m16186(file);
            return m16191((InputStream) fileInputStream);
        } finally {
            m16190((Closeable) fileInputStream);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static FileInputStream m16186(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static byte[] m16191(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m16188(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m16190(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long m16188(InputStream inputStream, OutputStream outputStream) {
        long j = 0;
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }
}

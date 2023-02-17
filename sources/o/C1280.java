package o;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
/* access modifiers changed from: package-private */
/* renamed from: o.ﾕ  reason: contains not printable characters */
public final class C1280 {

    /* renamed from: ˋ  reason: contains not printable characters */
    static final Charset f15990 = Charset.forName("US-ASCII");

    /* renamed from: ˏ  reason: contains not printable characters */
    static final Charset f15991 = Charset.forName("UTF-8");

    /* renamed from: ˊ  reason: contains not printable characters */
    static void m16831(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                m16831(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}

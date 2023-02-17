package o;

import java.io.Closeable;
import java.io.IOException;
public class AM {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3393(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C1283.m16852("IoUtil", e);
            }
        }
    }
}

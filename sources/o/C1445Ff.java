package o;

import java.io.Closeable;
/* renamed from: o.Ff  reason: case insensitive filesystem */
public final class C1445Ff {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static final void m5001(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                C1432Es.m4971(th, th2);
            }
        }
    }
}

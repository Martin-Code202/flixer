package o;

import android.os.Looper;
import io.reactivex.Observer;
/* renamed from: o.ᓑ  reason: contains not printable characters */
public final class C0820 {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m15430(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m15429(Observer<?> observer) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        observer.onError(new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName()));
        return false;
    }
}

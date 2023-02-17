package o;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
public class BL {

    /* renamed from: ˊ  reason: contains not printable characters */
    static long f4583;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String f4584 = "WidevineMonitor";

    /* renamed from: ˎ  reason: contains not printable characters */
    static AtomicBoolean f4585 = new AtomicBoolean(false);

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3876(long j) {
        C1283.m16854(f4584, "isWidevinePluginBlocked: starts");
        if (f4585.get()) {
            C1283.m16854(f4584, "isWidevinePluginBlocked: not initialized");
            return false;
        } else if (f4583 < j) {
            return false;
        } else {
            C1283.m16851(f4584, "isWidevinePluginBlocked: WIDEVINE.initializationTimeInMs >= %d", Long.valueOf(j));
            return true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static boolean m3877(boolean z) {
        f4585.set(true);
        f4583 = SystemClock.elapsedRealtime() - f4583;
        return z;
    }
}

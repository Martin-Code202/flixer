package o;

import android.os.SystemClock;
public class BA {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static long f4571;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static long f4572;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3836(long j) {
        f4572 = j;
        f4571 = SystemClock.elapsedRealtime();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m3835() {
        if (f4572 == 0) {
            return System.currentTimeMillis();
        }
        return f4572 + (SystemClock.elapsedRealtime() - f4571);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3834(long j) {
        return Math.abs(System.currentTimeMillis() - m3835()) > j;
    }
}

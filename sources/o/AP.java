package o;

import java.util.Random;
public class AP {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Long f4291;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Long f4292;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static synchronized Long m3397() {
        synchronized (AP.class) {
            if (f4291 != null) {
                return f4291;
            }
            f4291 = Long.valueOf(m3399());
            C1283.m16851("nf_logids", "creating appId: %s", f4291);
            return f4291;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static synchronized Long m3400() {
        synchronized (AP.class) {
            if (f4292 != null) {
                return f4292;
            }
            f4292 = Long.valueOf(m3399());
            C1283.m16851("nf_logids", "creating sessionId %s", f4292);
            return f4292;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static long m3399() {
        return Math.abs(((BA.m3835() & -1) << 32) | ((long) (new Random().nextInt() & -1)));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static synchronized void m3401() {
        synchronized (AP.class) {
            f4291 = null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static synchronized void m3398() {
        synchronized (AP.class) {
            f4292 = null;
        }
    }
}

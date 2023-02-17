package o;

import android.support.v4.os.TraceCompat;
/* renamed from: o.If  reason: case insensitive filesystem */
public class C1466If {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f5739 = 0;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean f5740 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int f5741 = 0;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static long[] f5742;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String[] f5743;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m5165(String str) {
        if (f5740) {
            if (f5739 == 20) {
                f5741++;
                return;
            }
            f5743[f5739] = str;
            f5742[f5739] = System.nanoTime();
            TraceCompat.beginSection(str);
            f5739++;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static float m5166(String str) {
        if (f5741 > 0) {
            f5741--;
            return 0.0f;
        } else if (!f5740) {
            return 0.0f;
        } else {
            f5739--;
            if (f5739 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (!str.equals(f5743[f5739])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f5743[f5739] + ".");
            } else {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - f5742[f5739])) / 1000000.0f;
            }
        }
    }
}

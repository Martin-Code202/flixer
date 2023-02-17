package o;

import android.graphics.Path;
import android.graphics.PointF;
/* renamed from: o.ﯨ  reason: contains not printable characters */
public class C1150 {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static PointF m16326(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m16327(C0445 r14, Path path) {
        path.reset();
        PointF r7 = r14.m14314();
        path.moveTo(r7.x, r7.y);
        PointF pointF = new PointF(r7.x, r7.y);
        for (int i = 0; i < r14.m14316().size(); i++) {
            C1169 r10 = r14.m14316().get(i);
            PointF r11 = r10.m16361();
            PointF r12 = r10.m16365();
            PointF r13 = r10.m16362();
            if (!r11.equals(pointF) || !r12.equals(r13)) {
                path.cubicTo(r11.x, r11.y, r12.x, r12.y, r13.x, r13.y);
            } else {
                path.lineTo(r13.x, r13.y);
            }
            pointF.set(r13.x, r13.y);
        }
        if (r14.m14313()) {
            path.close();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static float m16323(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static double m16328(double d, double d2, double d3) {
        return ((d2 - d) * d3) + d;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m16330(int i, int i2, float f) {
        return (int) (((float) i) + (((float) (i2 - i)) * f));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m16324(float f, float f2) {
        return m16322((int) f, (int) f2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m16322(int i, int i2) {
        return i - (m16325(i, i2) * i2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int m16325(int i, int i2) {
        int i3 = i / i2;
        if ((i ^ i2) >= 0 || i3 * i2 == i) {
            return i3;
        }
        return i3 - 1;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static float m16329(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}

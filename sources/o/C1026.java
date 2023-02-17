package o;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.Build;
import android.provider.Settings;
import java.io.Closeable;
/* renamed from: o.ᵛ  reason: contains not printable characters */
public final class C1026 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Path f15130 = new Path();

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final float f15131 = ((float) Math.sqrt(2.0d));

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Path f15132 = new Path();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final PathMeasure f15133 = new PathMeasure();

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final float[] f15134 = new float[4];

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Path m16013(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            path.cubicTo(pointF.x + pointF3.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m16009(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static float m16010(Matrix matrix) {
        f15134[0] = 0.0f;
        f15134[1] = 0.0f;
        f15134[2] = f15131;
        f15134[3] = f15131;
        matrix.mapPoints(f15134);
        return ((float) Math.hypot((double) (f15134[2] - f15134[0]), (double) (f15134[3] - f15134[1]))) / 2.0f;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m16011(Path path, C1354COn cOn) {
        if (cOn != null) {
            m16014(path, cOn.m4288().mo5904().floatValue() / 100.0f, cOn.m4287().mo5904().floatValue() / 100.0f, cOn.m4289().mo5904().floatValue() / 360.0f);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m16014(Path path, float f, float f2, float f3) {
        C1466If.m5165("applyTrimPathIfNeeded");
        f15133.setPath(path, false);
        float length = f15133.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            C1466If.m5166("applyTrimPathIfNeeded");
        } else if (length < 1.0f || ((double) Math.abs((f2 - f) - 1.0f)) < 0.01d) {
            C1466If.m5166("applyTrimPathIfNeeded");
        } else {
            float f4 = length * f;
            float f5 = length * f2;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = (float) C1150.m16324(min, length);
                max = (float) C1150.m16324(max, length);
            }
            if (min < 0.0f) {
                min = (float) C1150.m16324(min, length);
            }
            if (max < 0.0f) {
                max = (float) C1150.m16324(max, length);
            }
            if (min == max) {
                path.reset();
                C1466If.m5166("applyTrimPathIfNeeded");
                return;
            }
            if (min >= max) {
                min -= length;
            }
            f15132.reset();
            f15133.getSegment(min, max, f15132, true);
            if (max > length) {
                f15130.reset();
                f15133.getSegment(0.0f, max % length, f15130, true);
                f15132.addPath(f15130);
            } else if (min < 0.0f) {
                f15130.reset();
                f15133.getSegment(length + min, length, f15130, true);
                f15132.addPath(f15130);
            }
            path.set(f15132);
            C1466If.m5166("applyTrimPathIfNeeded");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m16016(C0433 r1, int i, int i2, int i3) {
        if (r1.m14255() < i) {
            return false;
        }
        if (r1.m14255() > i) {
            return true;
        }
        if (r1.m14258() < i2) {
            return false;
        }
        return r1.m14258() > i2 || r1.m14254() >= i3;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m16012(float f, float f2, float f3, float f4) {
        int i = 17;
        if (f != 0.0f) {
            i = (int) (527.0f * f);
        }
        if (f2 != 0.0f) {
            i = (int) (((float) (i * 31)) * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (((float) (i * 31)) * f3);
        }
        if (f4 != 0.0f) {
            return (int) (((float) (i * 31)) * f4);
        }
        return i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static float m16015(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }
}

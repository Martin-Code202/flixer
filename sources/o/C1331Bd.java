package o;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
/* renamed from: o.Bd  reason: case insensitive filesystem */
public final class C1331Bd {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4012(int[] iArr) {
        if (iArr.length < 1) {
            return false;
        }
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4013(int[] iArr, int i) {
        if (iArr.length != i) {
            return false;
        }
        return m4012(iArr);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4011(Context context, String str) {
        return ActivityCompat.checkSelfPermission(context, str) != 0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m4010(Context context, String[] strArr) {
        for (String str : strArr) {
            if (m4011(context, str)) {
                return true;
            }
        }
        return false;
    }
}

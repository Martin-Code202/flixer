package o;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
/* renamed from: o.Bj  reason: case insensitive filesystem */
public class C1337Bj {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f4652 = m4027();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f4653 = -1;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m4033() {
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m4026(Context context, int i) {
        boolean z;
        if (f4653 >= 0 && i == 528) {
            return f4653 == 1;
        }
        if (m4028(context) || m4034(context) || m4025(context)) {
            z = true;
        } else {
            z = m4032(context, i);
        }
        f4653 = z ? 1 : 0;
        return z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m4031(Context context) {
        return m4026(context, 528);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m4032(Context context, int i) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        return ((float) i) <= Math.min(((float) i2) / f, ((float) i3) / f);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4028(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.hasSystemFeature("org.chromium.arc");
        }
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m4025(Context context) {
        return ((DisplayManager) context.getSystemService("display")).getDisplay(0) == null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m4034(Context context) {
        if (((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4) {
            return true;
        }
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m4027() {
        String str = "high";
        if (Runtime.getRuntime().maxMemory() <= 33554432) {
            str = "low";
        }
        if (Build.VERSION.SDK_INT < 19 || !m4023()) {
            return str;
        }
        C1283.m16846("platformUtils", "isLowRamDevice() is true");
        return "low";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4029() {
        return "low".equals(f4652);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m4024() {
        return f4652;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private static boolean m4023() {
        return "true".equals(System.getProperty("ro.config.low_ram", "false"));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m4030() {
        return true;
    }
}

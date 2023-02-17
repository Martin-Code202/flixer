package o;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import java.io.File;
/* renamed from: o.As  reason: case insensitive filesystem */
public final class C1317As {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean f4533 = false;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Bitmap m3764(Bitmap bitmap, int i, int i2, boolean z) {
        int i3;
        int i4;
        C1348Bu.m4094();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0 || i <= 0 || i2 <= 0) {
            return bitmap;
        }
        if (width > height) {
            i4 = i;
            i3 = (i2 * height) / width;
        } else {
            i3 = i2;
            i4 = (width * i2) / height;
        }
        C1283.m16863("nf_utils", "originalW=%d originalH=%d dstWidth=%d dstHeight=%d newWidth=%d newHeight=%d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3));
        return Bitmap.createScaledBitmap(bitmap, i4, i3, z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3751(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) != 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m3758() {
        return Build.VERSION.SDK_INT;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static long m3769() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static ResolveInfo m3747(Context context, Intent intent) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        } else if (intent == null) {
            throw new IllegalArgumentException("Intent cannot be null!");
        } else {
            try {
                return context.getPackageManager().resolveActivity(intent, 0);
            } catch (Throwable th) {
                return null;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3770(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if ((packageInfo.applicationInfo.flags & 1) == 0 && (packageInfo.applicationInfo.flags & 128) == 0) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3759(Activity activity) {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3750(Context context) {
        return C1322Av.m3793(context);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3760(Context context) {
        String[] list;
        File file = new File(context.getCacheDir().getParent());
        if (file.exists() && (list = file.list()) != null && list.length > 0) {
            for (String str : list) {
                if (!str.equals("lib")) {
                    m3762(new File(file, str));
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3762(File file) {
        String[] list;
        if (file != null && file.isDirectory() && (list = file.list()) != null && list.length > 0) {
            for (String str : list) {
                if (!m3762(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3756(Context context) {
        m3752(context);
        Process.killProcess(Process.myPid());
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private static void m3752(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            audioManager.setStreamMute(3, false);
            C1283.m16854("nf_utils", "UN-MUTED");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3749() {
        return m3758() >= 18;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3765(Activity activity) {
        if (activity != null && m3758() > 18) {
            activity.getWindow().addFlags(8192);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3757() {
        try {
            Class.forName("com.netflix.mediaclient.test.NetflixTestRunner");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static ClassLoader m3754(Class cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        return ClassLoader.getSystemClassLoader();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3766() {
        return Build.VERSION.SDK_INT > 22;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static boolean m3745() {
        return Build.VERSION.SDK_INT > 23;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static boolean m3774() {
        return Build.VERSION.SDK_INT > 25;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m3743() {
        return Build.VERSION.SDK_INT > 26;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3767(Context context) {
        if (context != null) {
            return ((ActivityManager) context.getSystemService("activity")).isLowRamDevice();
        }
        return false;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m3742(Context context) {
        return m3743() && !m3767(context);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m3744(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        String packageName = context.getPackageName();
        try {
            return appOpsManager.checkOpNoThrow("android:picture_in_picture", context.getPackageManager().getPackageUid(packageName, 0), packageName) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static <T> T m3755(Context context, Class<T> cls) {
        return (T) C1322Av.m3791(context, cls);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m3763(File file) {
        try {
            if (file.exists()) {
                return new StatFs(file.getPath()).getAvailableBytes();
            }
            return 0;
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static boolean m3771() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static File m3773(Context context) {
        if (context == null || !m3771()) {
            return null;
        }
        return context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m3768(Context context, int i) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getInteger(i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static long m3753(long j) {
        return j / 1048576;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static boolean m3772(Context context) {
        return m3761(context, 2);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static boolean m3746(Context context) {
        return m3761(context, 1);
    }

    @TargetApi(24)
    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m3761(Context context, int i) {
        Display display;
        Display.HdrCapabilities hdrCapabilities;
        if (m3758() < 24 || (display = ((DisplayManager) context.getSystemService("display")).getDisplay(0)) == null || (hdrCapabilities = display.getHdrCapabilities()) == null) {
            return false;
        }
        for (int i2 : hdrCapabilities.getSupportedHdrTypes()) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3748(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            C1283.m16847("nf_utils", "Exception while getting system property: ", e);
            return str2;
        }
    }
}

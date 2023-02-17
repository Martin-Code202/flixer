package o;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
public final class AD {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static AtomicBoolean f4276;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final boolean f4277 = (Build.VERSION.SDK_INT <= 16 && Build.MANUFACTURER.compareTo("LGE") == 0);

    private AD() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3301(Context context) {
        String r0 = C1318At.m3776(context);
        if (r0 == null) {
            return "N/A";
        }
        return r0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m3284(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m3291(Activity activity) {
        if (m3307(activity)) {
            activity.setRequestedOrientation(6);
        } else {
            activity.setRequestedOrientation(7);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m3290(Context context) {
        return context.getResources().getConfiguration().screenLayout & 15;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static float m3296(Context context) {
        return ((float) m3317(context)) / ((float) m3280(context));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m3308(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static int m3319(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        return i < i2 ? i : i2;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static int m3278(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        return i > i2 ? i : i2;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String m3282(Context context) {
        switch (m3290(context)) {
            case 0:
                return "undefined";
            case 1:
                return "small";
            case 2:
                return "normal";
            case 3:
                return "large";
            case 4:
                return "xlarge";
            default:
                return "unknown";
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static int m3317(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static int m3280(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public static boolean m3307(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static boolean m3306(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3292() {
        return !m3299();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3299() {
        return C1337Bj.m4031(AbstractApplicationC1258.m16692());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3312(int i) {
        return C1337Bj.m4026(AbstractApplicationC1258.m16692(), i);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static JSONObject m3289(Context context) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("dpi", m3308(context));
        jSONObject.put("screenWidthPixels", m3319(context));
        jSONObject.put("screenHeightPixels", m3278(context));
        return jSONObject;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static JSONObject m3314(Context context) {
        JSONObject jSONObject = new JSONObject();
        long r5 = C1114.m16243(context) / 1048576;
        jSONObject.put("numCpuCores", C1114.m16242());
        jSONObject.put("cpuFreqInMhz", C1114.m16241() / 1000);
        jSONObject.put("totalRAMInMb", r5);
        return jSONObject;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3309(Activity activity) {
        activity.getWindow().setSoftInputMode(2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3310(Activity activity, EditText editText) {
        if (activity != null) {
            m3298((InputMethodManager) activity.getSystemService("input_method"), editText);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3298(InputMethodManager inputMethodManager, EditText editText) {
        if (inputMethodManager != null && editText != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3286(Activity activity) {
        activity.getWindow().setSoftInputMode(20);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3311() {
        return KeyCharacterMap.deviceHasKey(4) && KeyCharacterMap.deviceHasKey(3);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static boolean m3295(Context context) {
        if (f4276 == null) {
            synchronized (AD.class) {
                if (f4276 == null) {
                    boolean z = C1339Bl.m4044(context, "nf_first_start_after_install", -1) < 0;
                    f4276 = new AtomicBoolean(z);
                    if (z) {
                        C1339Bl.m4043(context, "nf_first_start_after_install", System.currentTimeMillis());
                    }
                }
            }
        }
        return f4276.get();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static synchronized boolean m3293(Context context, int i) {
        synchronized (AD.class) {
            if (i <= 0) {
                C1283.m16854("nf_device_utils", "Everybody is enabled");
                return true;
            } else if (i >= 100) {
                C1283.m16854("nf_device_utils", "Everybody is disabled");
                return false;
            } else {
                int r5 = (int) (m3285(AbstractC0488.m14438(context)) % 100);
                if (r5 < 0) {
                    r5 += 100;
                }
                return r5 <= 100 - i;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static long m3285(String str) {
        char[] charArray;
        long j = 0;
        for (char c : str.toCharArray()) {
            j = (31 * j) + ((long) c);
        }
        return j;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public static String m3316(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if ((applicationInfo.flags & 128) != 0 || (applicationInfo.flags & 1) == 0) {
            return applicationInfo.nativeLibraryDir;
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3304(Context context, String str) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Library name not provided!");
        }
        String r2 = m3316(context);
        if (r2 != null) {
            try {
                System.load(r2 + "/lib" + str + ".so");
                return true;
            } catch (Throwable th) {
                C1283.m16847("nf_device_utils", "Failed to load library from assumed location", th);
                C1276.m16820().mo5731(th);
                return false;
            }
        } else {
            System.loadLibrary(str);
            return true;
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public static boolean m3321(Context context) {
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        if (0 == isGooglePlayServicesAvailable) {
            C1283.m16854("nf_device_utils", "Success!");
            return true;
        } else if (1 == isGooglePlayServicesAvailable) {
            C1283.m16854("nf_device_utils", "Device is not Google certified, skip");
            return false;
        } else if (9 == isGooglePlayServicesAvailable) {
            C1283.m16854("nf_device_utils", "Device is not Google certified, skip");
            return false;
        } else {
            C1283.m16854("nf_device_utils", "Device is Google certified, problem with Google Play Services");
            return true;
        }
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public static int m3315(Context context) {
        return GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public static int m3318(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (Throwable th) {
            C1283.m16854("nf_device_utils", "gms package not available");
            return 0;
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public static boolean m3279(Context context) {
        return m3318(context) < m3315(context);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3313(AbstractC2045ou ouVar, AbstractC2076py pyVar) {
        return ouVar.mo1711() && pyVar.isVideoHd();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3305(AbstractC2045ou ouVar, AbstractC2076py pyVar) {
        return ouVar.mo1712() && pyVar.isVideoUhd();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3294(AbstractC2045ou ouVar, AbstractC2076py pyVar) {
        return ouVar.mo1710() && pyVar.isVideo5dot1();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3300(AbstractC2045ou ouVar, AbstractC2076py pyVar) {
        return ouVar.mo1709() && pyVar.isVideoHdr10();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3288(AbstractC2045ou ouVar, AbstractC2076py pyVar) {
        return ouVar.mo1708() && pyVar.isVideoDolbyVision();
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public static boolean m3283(Context context) {
        return m3296(context) > 1.8f;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3287() {
        return Build.MANUFACTURER.equals("Amazon");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3303() {
        return C1337Bj.m4028(AbstractApplicationC1258.m16692());
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static boolean m3320() {
        return C1337Bj.m4025(AbstractApplicationC1258.m16692());
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m3281() {
        return C1337Bj.m4034(AbstractApplicationC1258.m16692());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3302(Activity activity) {
        if (!C1317As.m3750(activity)) {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3297(Activity activity) {
        if (!C1317As.m3750(activity)) {
            activity.getWindow().getDecorView().setSystemUiVisibility(4102);
        }
    }
}

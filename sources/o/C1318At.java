package o;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
/* renamed from: o.At  reason: case insensitive filesystem */
public final class C1318At {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String f4534 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String f4535 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3781(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(m3780(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3776(Context context) {
        if (f4535 == null) {
            String r1 = m3781(context);
            if (r1 == null) {
                return "";
            }
            int indexOf = r1.indexOf(" ");
            if (indexOf > 0) {
                f4535 = r1.substring(0, indexOf);
            } else {
                f4535 = r1;
            }
        }
        return f4535;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m3778(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(m3780(), 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (Throwable th) {
            return -1;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3777(Context context) {
        if (f4534 == null) {
            String r2 = m3776(context);
            int r3 = m3778(context);
            StringBuilder sb = new StringBuilder();
            sb.append(r2).append('-').append(r3).append(' ').append("R").append(' ').append("android-").append(Build.VERSION.SDK_INT).append('-').append("EXO");
            f4534 = sb.toString();
        }
        return f4534;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3775(Context context) {
        int r5 = C1339Bl.m4037(context, "manifestVersionCode", -1);
        int r6 = m3778(context);
        boolean z = r6 > r5 && r5 != -1;
        boolean z2 = r6 != r5;
        C1283.m16863("nf_utils", "onApplicationStart lastVersionCode=%d currentVersionCode=%d appUpgraded=%b updateManifestVersionCode=%b", Integer.valueOf(r5), Integer.valueOf(r6), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z) {
            C1283.m16862("nf_utils", "setting app upgraded pref");
            m3779(context, true);
        } else if (m3782(context)) {
            C1283.m16862("nf_utils", "resetting app upgraded pref");
            m3779(context, false);
        }
        if (z2) {
            C1339Bl.m4042(context, "manifestVersionCode", r6);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m3779(Context context, boolean z) {
        C1339Bl.m4048(context, "appUpgraded", z);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static boolean m3782(Context context) {
        return C1339Bl.m4051(context, "appUpgraded", false);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3780() {
        return C1061.m16114().mo14160();
    }
}

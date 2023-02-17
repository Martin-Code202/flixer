package o;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: o.Bl  reason: case insensitive filesystem */
public final class C1339Bl {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static AtomicBoolean f4654;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static AtomicBoolean f4655;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m4051(Context context, String str, boolean z) {
        if (!m4038(context, str)) {
            return z;
        }
        try {
            return context.getSharedPreferences("nfxpref", 0).getBoolean(str, z);
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to get preferences!", th);
            return z;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m4048(Context context, String str, boolean z) {
        if (!m4038(context, str)) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("nfxpref", 0).edit();
            edit.putBoolean(str, z);
            edit.commit();
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m4037(Context context, String str, int i) {
        if (!m4038(context, str)) {
            return i;
        }
        try {
            return context.getSharedPreferences("nfxpref", 0).getInt(str, i);
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to get preferences!", th);
            return i;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4042(Context context, String str, int i) {
        if (!m4038(context, str)) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("nfxpref", 0).edit();
            edit.putInt(str, i);
            edit.commit();
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m4039(Context context, String str, String str2) {
        if (!m4038(context, str)) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("nfxpref", 0).edit();
            edit.putString(str, str2);
            edit.commit();
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m4045(Context context, String str, String str2) {
        if (!m4038(context, str)) {
            return str2;
        }
        try {
            return context.getSharedPreferences("nfxpref", 0).getString(str, str2);
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to get preferences!", th);
            return str2;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4043(Context context, String str, long j) {
        if (!m4038(context, str)) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("nfxpref", 0).edit();
            edit.putLong(str, j);
            edit.apply();
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m4044(Context context, String str, long j) {
        if (!m4038(context, str)) {
            return j;
        }
        try {
            return context.getSharedPreferences("nfxpref", 0).getLong(str, j);
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to get preferences!", th);
            return j;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4041(Context context, String str) {
        if (!m4038(context, str)) {
            return false;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("nfxpref", 0);
            if (sharedPreferences == null) {
                C1283.m16850("nfxpref", "Prefs null, not expected!");
                return false;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                C1283.m16850("nfxpref", "Editor null, not expected!");
                return false;
            }
            edit.remove(str);
            edit.commit();
            return true;
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to save to preferences!", th);
            return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m4047(Context context, String str) {
        if (!m4038(context, str)) {
            return false;
        }
        try {
            return context.getSharedPreferences("nfxpref", 0).contains(str);
        } catch (Throwable th) {
            C1283.m16847("nfxpref", "Failed to get preferences!", th);
            return false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m4038(Context context, String str) {
        if (context == null) {
            C1283.m16865("nfxpref", "Context is null!");
            return false;
        } else if (str != null) {
            return true;
        } else {
            C1283.m16865("nfxpref", "Name is null!");
            return false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static synchronized boolean m4050() {
        boolean z;
        synchronized (C1339Bl.class) {
            if (f4654 == null) {
                f4654 = new AtomicBoolean(m4051(AbstractApplicationC1258.m16692(), "prefs_app_task_removed_user", false));
                m4041(AbstractApplicationC1258.m16692(), "prefs_app_task_removed_user");
            }
            z = f4654.get();
        }
        return z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static synchronized boolean m4040() {
        boolean z;
        synchronized (C1339Bl.class) {
            if (f4655 == null) {
                f4655 = new AtomicBoolean(m4045(AbstractApplicationC1258.m16692(), "NF_CrashReport", null) != null);
            }
            z = f4655.get();
        }
        return z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4046(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("nfxpref", 0).edit();
        edit.clear();
        edit.commit();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4049(Context context) {
        if (context != null) {
            m4041(context, "formerMemberInfo");
        }
    }
}

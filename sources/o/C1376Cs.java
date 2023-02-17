package o;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
/* renamed from: o.Cs  reason: case insensitive filesystem */
public final class C1376Cs {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static AuthorizationCredentials m4548(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        String str3 = null;
        String str4 = null;
        for (String str5 : str2.split(";")) {
            String[] split = str5.split("=");
            if (split.length >= 2) {
                if (m4554(false).equalsIgnoreCase(split[0].trim()) || m4554(true).equalsIgnoreCase(split[0].trim())) {
                    str3 = split[1];
                } else if (m4549(false).equalsIgnoreCase(split[0].trim()) || m4549(true).equalsIgnoreCase(split[0].trim())) {
                    str4 = split[1];
                }
            }
            if (C1349Bv.m4107(str) && C1349Bv.m4107(str3) && C1349Bv.m4107(str4)) {
                C1283.m16851("nf_net_cookies", "update cookies for %s: newId %s", str, str3);
                return new AuthorizationCredentials(str, str3, str4);
            }
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m4556(String str) {
        return m4553("flwssn", str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m4553(String str, String str2) {
        if (str2 == null || str == null) {
            return null;
        }
        for (String str3 : str2.split(";")) {
            String[] split = str3.split("=");
            if (split.length >= 2 && str.equalsIgnoreCase(split[0].trim())) {
                return split[1];
            }
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m4552(String str) {
        return m4553("nfvdid", str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m4554(boolean z) {
        if (z) {
            return "NetflixIdTest";
        }
        return "NetflixId";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m4549(boolean z) {
        if (z) {
            return "SecureNetflixIdTest";
        }
        return "SecureNetflixId";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m4551() {
        return "nfvdid";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4555(Context context, ValueCallback<Boolean> valueCallback) {
        if (C1317As.m3774()) {
            m4557(valueCallback);
            return;
        }
        m4550(context);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(true);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m4550(Context context) {
        if (context != null) {
            CookieSyncManager.createInstance(context);
            CookieManager.getInstance().removeAllCookie();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m4557(ValueCallback<Boolean> valueCallback) {
        CookieManager.getInstance().removeAllCookies(valueCallback);
    }
}

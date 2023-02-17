package org.chromium.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Locale;
public final class UserAgent {
    private static final Object sLock = new Object();
    private static int sVersionCode = 0;

    public static String from(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append('/');
        sb.append(versionFromContext(context));
        sb.append(" (Linux; U; Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("; ");
        sb.append(Locale.getDefault().toString());
        String str = Build.MODEL;
        if (str.length() > 0) {
            sb.append("; ");
            sb.append(str);
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            sb.append("; Build/");
            sb.append(str2);
        }
        sb.append(";");
        appendCronetVersion(sb);
        sb.append(')');
        return sb.toString();
    }

    static String getQuicUserAgentIdFrom(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        appendCronetVersion(sb);
        return sb.toString();
    }

    private static int versionFromContext(Context context) {
        int i;
        synchronized (sLock) {
            if (sVersionCode == 0) {
                try {
                    sVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalStateException("Cannot determine package version");
                }
            }
            i = sVersionCode;
        }
        return i;
    }

    private static void appendCronetVersion(StringBuilder sb) {
        sb.append(" Cronet/");
        sb.append(ImplVersion.getCronetVersion());
    }
}

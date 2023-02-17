package o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.netflix.mediaclient.service.net.NetworkType;
import java.io.File;
import org.chromium.net.CronetEngine;
import org.chromium.net.ExperimentalCronetEngine;
/* renamed from: o.চ  reason: contains not printable characters */
public final class C0655 {
    C0655() {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static ExperimentalCronetEngine m14817(Context context) {
        ExperimentalCronetEngine.Builder builder = new ExperimentalCronetEngine.Builder(context);
        m14818(context, builder);
        builder.enableNetworkQualityEstimator(true);
        return builder.build();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m14818(Context context, CronetEngine.Builder builder) {
        File file = new File(context.getCacheDir(), "cronet");
        C1283.m16851("nf_cr_helper", "Set cache to %s, it exists %b, absolute path %s", file.getPath(), Boolean.valueOf(file.exists()), file.getAbsolutePath());
        if (!file.exists()) {
            C1283.m16851("nf_cr_helper", "Cache created %b", Boolean.valueOf(file.mkdir()));
        }
        builder.enableHttp2(true);
        builder.setStoragePath(file.getPath());
        builder.enableHttpCache(3, 1048576);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static boolean m14819(String str) {
        return str.endsWith(".bif") || str.endsWith(".webp") || str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m14816(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        String str;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return null;
        }
        boolean z = false;
        switch (activeNetworkInfo.getType()) {
            case 0:
                str = "mobile";
                z = true;
                break;
            case 1:
                str = "wifi";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            default:
                str = "mobile";
                z = true;
                break;
            case 6:
                str = "wimax";
                break;
            case 7:
                str = "bluetooth";
                break;
            case 9:
                str = "ethernet";
                break;
        }
        if (!z) {
            return str;
        }
        NetworkType r6 = NetworkType.m814(activeNetworkInfo.getSubtype());
        if (NetworkType.m816(r6)) {
            return str + "_2g";
        }
        if (NetworkType.m815(r6)) {
            return str + "_3g";
        }
        if (NetworkType.m817(r6)) {
            return str + "_4g";
        }
        return str;
    }
}

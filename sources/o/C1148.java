package o;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import java.io.File;
/* renamed from: o.ﯦ  reason: contains not printable characters */
public class C1148 {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0482 m16319(Context context, AbstractC0419 r7, String str) {
        AbstractC0894 r4;
        File file = new File(context.getCacheDir(), "volley");
        String str2 = "volley/0";
        try {
            String packageName = context.getPackageName();
            str2 = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (r7 == null) {
            if (Build.VERSION.SDK_INT >= 9) {
                r4 = new C1016();
            } else {
                r4 = new C0765(AndroidHttpClient.newInstance(str2));
            }
            r7 = new C0760(r4);
        }
        C0482 r42 = new C0482(new C0763(file), r7, str);
        r42.m14410();
        return r42;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0482 m16320(Context context, String str) {
        return m16319(context, null, str);
    }
}

package o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
/* renamed from: o.Av  reason: case insensitive filesystem */
public class C1322Av {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static <T> T m3791(Context context, Class<T> cls) {
        Context baseContext;
        if (cls.isInstance(context)) {
            return cls.cast(context);
        }
        if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == context) {
            return null;
        }
        return (T) m3791(baseContext, cls);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Context m3794(Context context) {
        return context.getApplicationContext();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3793(Context context) {
        if (context == null) {
            return true;
        }
        Activity activity = context instanceof Activity ? (Activity) context : (Activity) m3791(context, Activity.class);
        if (activity != null) {
            return activity.isFinishing() || activity.isDestroyed();
        }
        C1276.m16820().mo5730(new IllegalArgumentException("No activity found in this context : " + context));
        return true;
    }

    @Deprecated
    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3792() {
        return TextUtils.equals("robolectric", Build.FINGERPRINT);
    }
}

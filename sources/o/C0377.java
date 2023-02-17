package o;

import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.view.View;
/* renamed from: o.ɩ  reason: contains not printable characters */
public class C0377 {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m14141(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            ViewCompat.setTranslationZ(view, f);
        } else if (f != 0.0f) {
            view.bringToFront();
            if (view.getParent() != null) {
                ((View) view.getParent()).invalidate();
            }
        }
    }
}

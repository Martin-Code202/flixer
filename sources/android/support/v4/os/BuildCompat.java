package android.support.v4.os;

import android.os.Build;
public class BuildCompat {
    @Deprecated
    public static boolean isAtLeastOMR1() {
        return Build.VERSION.SDK_INT >= 27;
    }
}

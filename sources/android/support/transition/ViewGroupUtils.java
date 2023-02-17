package android.support.transition;

import android.os.Build;
import android.view.ViewGroup;
class ViewGroupUtils {
    private static final ViewGroupUtilsImpl IMPL;

    ViewGroupUtils() {
    }

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            IMPL = new ViewGroupUtilsApi18();
        } else {
            IMPL = new ViewGroupUtilsApi14();
        }
    }

    static ViewGroupOverlayImpl getOverlay(ViewGroup viewGroup) {
        return IMPL.getOverlay(viewGroup);
    }

    static void suppressLayout(ViewGroup viewGroup, boolean z) {
        IMPL.suppressLayout(viewGroup, z);
    }
}

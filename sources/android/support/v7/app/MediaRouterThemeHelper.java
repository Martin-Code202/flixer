package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
final class MediaRouterThemeHelper {
    static float getDisabledAlpha(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842803, typedValue, true)) {
            return typedValue.getFloat();
        }
        return 0.5f;
    }

    static int getControllerColor(Context context, int i) {
        if (ColorUtils.calculateContrast(-1, getThemeColor(context, i, R.attr.colorPrimary)) >= 3.0d) {
            return -1;
        }
        return -570425344;
    }

    private static int getThemeColor(Context context, int i, int i2) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, new int[]{i2});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            if (color != 0) {
                return color;
            }
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        if (typedValue.resourceId != 0) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        return typedValue.data;
    }
}

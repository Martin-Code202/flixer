package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.WindowManager;
import java.util.WeakHashMap;
public abstract class DisplayManagerCompat {
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap<>();

    DisplayManagerCompat() {
    }

    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        synchronized (sInstances) {
            displayManagerCompat = sInstances.get(context);
            if (displayManagerCompat == null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    displayManagerCompat = new DisplayManagerCompatApi17Impl(context);
                } else {
                    displayManagerCompat = new DisplayManagerCompatApi14Impl(context);
                }
                sInstances.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    static class DisplayManagerCompatApi14Impl extends DisplayManagerCompat {
        private final WindowManager mWindowManager;

        DisplayManagerCompatApi14Impl(Context context) {
            this.mWindowManager = (WindowManager) context.getSystemService("window");
        }
    }

    static class DisplayManagerCompatApi17Impl extends DisplayManagerCompat {
        private final DisplayManager mDisplayManager;

        DisplayManagerCompatApi17Impl(Context context) {
            this.mDisplayManager = (DisplayManager) context.getSystemService("display");
        }
    }
}

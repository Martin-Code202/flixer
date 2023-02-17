package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;
/* access modifiers changed from: package-private */
public class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: android.support.transition.ViewUtils.2
        public Rect get(View view) {
            return ViewCompat.getClipBounds(view);
        }

        public void set(View view, Rect rect) {
            ViewCompat.setClipBounds(view, rect);
        }
    };
    private static final ViewUtilsImpl IMPL;
    static final Property<View, Float> TRANSITION_ALPHA = new Property<View, Float>(Float.class, "translationAlpha") { // from class: android.support.transition.ViewUtils.1
        public Float get(View view) {
            return Float.valueOf(ViewUtils.getTransitionAlpha(view));
        }

        public void set(View view, Float f) {
            ViewUtils.setTransitionAlpha(view, f.floatValue());
        }
    };
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;

    ViewUtils() {
    }

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            IMPL = new ViewUtilsApi22();
        } else if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new ViewUtilsApi21();
        } else if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new ViewUtilsApi19();
        } else if (Build.VERSION.SDK_INT >= 18) {
            IMPL = new ViewUtilsApi18();
        } else {
            IMPL = new ViewUtilsApi14();
        }
    }

    static ViewOverlayImpl getOverlay(View view) {
        return IMPL.getOverlay(view);
    }

    static WindowIdImpl getWindowId(View view) {
        return IMPL.getWindowId(view);
    }

    static void setTransitionAlpha(View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    static void saveNonTransitionAlpha(View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    static void clearNonTransitionAlpha(View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    static void setTransitionVisibility(View view, int i) {
        fetchViewFlagsField();
        if (sViewFlagsField != null) {
            try {
                sViewFlagsField.setInt(view, (sViewFlagsField.getInt(view) & -13) | i);
            } catch (IllegalAccessException e) {
            }
        }
    }

    static void transformMatrixToGlobal(View view, Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    static void transformMatrixToLocal(View view, Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }

    static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    private static void fetchViewFlagsField() {
        if (!sViewFlagsFieldFetched) {
            try {
                sViewFlagsField = View.class.getDeclaredField("mViewFlags");
                sViewFlagsField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            sViewFlagsFieldFetched = true;
        }
    }
}

package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;
class DrawableUtils {
    private static Method sSetConstantStateMethod;
    private static boolean sSetConstantStateMethodFetched;

    static boolean setContainerConstantState(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return setContainerConstantStateV9(drawableContainer, constantState);
    }

    private static boolean setContainerConstantStateV9(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!sSetConstantStateMethodFetched) {
            try {
                sSetConstantStateMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainer.DrawableContainerState.class);
                sSetConstantStateMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            sSetConstantStateMethodFetched = true;
        }
        if (sSetConstantStateMethod == null) {
            return false;
        }
        try {
            sSetConstantStateMethod.invoke(drawableContainer, constantState);
            return true;
        } catch (Exception e2) {
            Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            return false;
        }
    }
}

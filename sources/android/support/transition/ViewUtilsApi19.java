package android.support.transition;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
class ViewUtilsApi19 extends ViewUtilsApi18 {
    private static Method sGetTransitionAlphaMethod;
    private static boolean sGetTransitionAlphaMethodFetched;
    private static Method sSetTransitionAlphaMethod;
    private static boolean sSetTransitionAlphaMethodFetched;

    ViewUtilsApi19() {
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    public void setTransitionAlpha(View view, float f) {
        fetchSetTransitionAlphaMethod();
        if (sSetTransitionAlphaMethod != null) {
            try {
                sSetTransitionAlphaMethod.invoke(view, Float.valueOf(f));
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            view.setAlpha(f);
        }
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    public float getTransitionAlpha(View view) {
        fetchGetTransitionAlphaMethod();
        if (sGetTransitionAlphaMethod != null) {
            try {
                return ((Float) sGetTransitionAlphaMethod.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.getTransitionAlpha(view);
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    public void saveNonTransitionAlpha(View view) {
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    public void clearNonTransitionAlpha(View view) {
    }

    private void fetchSetTransitionAlphaMethod() {
        if (!sSetTransitionAlphaMethodFetched) {
            try {
                sSetTransitionAlphaMethod = View.class.getDeclaredMethod("setTransitionAlpha", Float.TYPE);
                sSetTransitionAlphaMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
            }
            sSetTransitionAlphaMethodFetched = true;
        }
    }

    private void fetchGetTransitionAlphaMethod() {
        if (!sGetTransitionAlphaMethodFetched) {
            try {
                sGetTransitionAlphaMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                sGetTransitionAlphaMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
            }
            sGetTransitionAlphaMethodFetched = true;
        }
    }
}

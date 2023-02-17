package android.support.transition;

import android.view.View;
class ViewUtilsApi18 extends ViewUtilsApi14 {
    ViewUtilsApi18() {
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    public ViewOverlayImpl getOverlay(View view) {
        return new ViewOverlayApi18(view);
    }

    @Override // android.support.transition.ViewUtilsApi14, android.support.transition.ViewUtilsImpl
    public WindowIdImpl getWindowId(View view) {
        return new WindowIdApi18(view);
    }
}

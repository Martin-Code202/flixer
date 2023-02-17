package android.support.transition;

import android.view.ViewGroup;
/* access modifiers changed from: package-private */
public interface ViewGroupUtilsImpl {
    ViewGroupOverlayImpl getOverlay(ViewGroup viewGroup);

    void suppressLayout(ViewGroup viewGroup, boolean z);
}

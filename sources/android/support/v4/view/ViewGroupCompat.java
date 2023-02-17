package android.support.v4.view;

import android.os.Build;
import android.support.compat.R;
import android.view.ViewGroup;
public final class ViewGroupCompat {
    static final ViewGroupCompatBaseImpl IMPL;

    /* access modifiers changed from: package-private */
    public static class ViewGroupCompatBaseImpl {
        ViewGroupCompatBaseImpl() {
        }

        public boolean isTransitionGroup(ViewGroup viewGroup) {
            Boolean bool = (Boolean) viewGroup.getTag(R.id.tag_transition_group);
            return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && ViewCompat.getTransitionName(viewGroup) == null) ? false : true;
        }
    }

    static class ViewGroupCompatApi18Impl extends ViewGroupCompatBaseImpl {
        ViewGroupCompatApi18Impl() {
        }
    }

    static class ViewGroupCompatApi21Impl extends ViewGroupCompatApi18Impl {
        ViewGroupCompatApi21Impl() {
        }

        @Override // android.support.v4.view.ViewGroupCompat.ViewGroupCompatBaseImpl
        public boolean isTransitionGroup(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new ViewGroupCompatApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 18) {
            IMPL = new ViewGroupCompatApi18Impl();
        } else {
            IMPL = new ViewGroupCompatBaseImpl();
        }
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return IMPL.isTransitionGroup(viewGroup);
    }
}

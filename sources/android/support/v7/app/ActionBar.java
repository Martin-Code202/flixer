package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
public abstract class ActionBar {

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean z);
    }

    @Deprecated
    public static abstract class Tab {
        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract CharSequence getText();

        public abstract void select();
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public abstract void hide();

    public abstract boolean isShowing();

    public abstract void setCustomView(View view, LayoutParams layoutParams);

    public abstract void setDisplayHomeAsUpEnabled(boolean z);

    public abstract void setDisplayShowCustomEnabled(boolean z);

    public abstract void setDisplayShowHomeEnabled(boolean z);

    public abstract void setDisplayShowTitleEnabled(boolean z);

    public abstract void setDisplayUseLogoEnabled(boolean z);

    public abstract void setTitle(CharSequence charSequence);

    public abstract void show();

    public void setHomeButtonEnabled(boolean z) {
    }

    public Context getThemedContext() {
        return null;
    }

    public void setHomeActionContentDescription(int i) {
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public int getHideOffset() {
        return 0;
    }

    public void setElevation(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z) {
    }

    public void setShowHideAnimationEnabled(boolean z) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void dispatchMenuVisibilityChanged(boolean z) {
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        return null;
    }

    public boolean openOptionsMenu() {
        return false;
    }

    public boolean closeOptionsMenu() {
        return false;
    }

    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public void setWindowTitle(CharSequence charSequence) {
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.gravity = 0;
            this.gravity = i3;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }
}

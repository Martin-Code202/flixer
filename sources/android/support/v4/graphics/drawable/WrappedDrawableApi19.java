package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.WrappedDrawableApi14;
/* access modifiers changed from: package-private */
public class WrappedDrawableApi19 extends WrappedDrawableApi14 {
    WrappedDrawableApi19(Drawable drawable) {
        super(drawable);
    }

    WrappedDrawableApi19(WrappedDrawableApi14.DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.mDrawable.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mDrawable.isAutoMirrored();
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14
    public WrappedDrawableApi14.DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateKitKat(this.mState, null);
    }

    static class DrawableWrapperStateKitKat extends WrappedDrawableApi14.DrawableWrapperState {
        DrawableWrapperStateKitKat(WrappedDrawableApi14.DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        @Override // android.support.v4.graphics.drawable.WrappedDrawableApi14.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new WrappedDrawableApi19(this, resources);
        }
    }
}

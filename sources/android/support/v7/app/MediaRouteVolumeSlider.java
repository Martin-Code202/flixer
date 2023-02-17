package android.support.v7.app;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.util.Log;
class MediaRouteVolumeSlider extends AppCompatSeekBar {
    private int mColor;
    private final float mDisabledAlpha;
    private boolean mHideThumb;
    private Drawable mThumb;

    public MediaRouteVolumeSlider(Context context) {
        this(context, null);
    }

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public MediaRouteVolumeSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDisabledAlpha = MediaRouterThemeHelper.getDisabledAlpha(context);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int i = isEnabled() ? 255 : (int) (this.mDisabledAlpha * 255.0f);
        this.mThumb.setColorFilter(this.mColor, PorterDuff.Mode.SRC_IN);
        this.mThumb.setAlpha(i);
        getProgressDrawable().setColorFilter(this.mColor, PorterDuff.Mode.SRC_IN);
        getProgressDrawable().setAlpha(i);
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable drawable) {
        this.mThumb = drawable;
        super.setThumb(this.mHideThumb ? null : this.mThumb);
    }

    public void setHideThumb(boolean z) {
        if (this.mHideThumb != z) {
            this.mHideThumb = z;
            super.setThumb(this.mHideThumb ? null : this.mThumb);
        }
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            if (Color.alpha(i) != 255) {
                Log.e("MediaRouteVolumeSlider", "Volume slider color cannot be translucent: #" + Integer.toHexString(i));
            }
            this.mColor = i;
        }
    }
}

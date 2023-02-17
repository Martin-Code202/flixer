package android.support.design.widget;

import android.graphics.drawable.Drawable;
/* access modifiers changed from: package-private */
public interface ShadowViewDelegate {
    float getRadius();

    boolean isCompatPaddingEnabled();

    void setBackgroundDrawable(Drawable drawable);

    void setShadowPadding(int i, int i2, int i3, int i4);
}

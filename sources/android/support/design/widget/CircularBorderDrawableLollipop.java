package android.support.design.widget;

import android.graphics.Outline;
class CircularBorderDrawableLollipop extends CircularBorderDrawable {
    CircularBorderDrawableLollipop() {
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.mRect);
        outline.setOval(this.mRect);
    }
}

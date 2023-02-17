package o;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;
/* renamed from: o.ᒷ  reason: contains not printable characters */
public class C0807 extends ViewFlipper {
    public C0807(Context context) {
        super(context);
    }

    public C0807(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ViewFlipper, android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (IllegalArgumentException e) {
            C1283.m16854("nf-ui", "SafeViewFlipper ignoring IllegalArgumentException");
            stopFlipping();
        }
    }
}

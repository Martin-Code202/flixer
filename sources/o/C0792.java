package o;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* renamed from: o.ᒭ  reason: contains not printable characters */
public class C0792 extends FrameLayout {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected AbstractC0774 f14455 = new C0521(this);

    public C0792(Context context) {
        super(context);
    }

    public C0792(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C0792(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPressedStateHandlerEnabled(boolean z) {
        this.f14455.m15233(z);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSetPressed(boolean z) {
        if (m15265()) {
            this.f14455.m15231(z);
        }
        super.dispatchSetPressed(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m15265() {
        return true;
    }
}

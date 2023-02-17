package o;

import android.content.Context;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.util.AttributeSet;
import android.view.View;
import o.C0602;
/* renamed from: o.氵  reason: contains not printable characters */
public class C1105 extends View {

    /* renamed from: ˏ  reason: contains not printable characters */
    private AnimatedVectorDrawableCompat f15309;

    public C1105(Context context) {
        super(context);
        m16224(null);
    }

    public C1105(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16224(attributeSet);
    }

    public C1105(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16224(attributeSet);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16224(AttributeSet attributeSet) {
        try {
            if (!C1322Av.m3792()) {
                this.f15309 = AnimatedVectorDrawableCompat.create(getContext(), C0602.C0604.avd_progress_indeterminate_horizontal);
                setBackground(this.f15309);
            }
        } catch (Exception e) {
            C1276.m16820().mo5731(e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f15309 != null) {
            this.f15309.start();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        if (this.f15309 != null) {
            this.f15309.stop();
        }
        super.onDetachedFromWindow();
    }

    public void setProgressTint(int i) {
        if (this.f15309 != null) {
            this.f15309.setTint(i);
        }
    }
}

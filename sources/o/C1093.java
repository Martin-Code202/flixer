package o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* renamed from: o.丨  reason: contains not printable characters */
public final class C1093 extends LinearLayout {

    /* renamed from: ˋ  reason: contains not printable characters */
    private Rect f15264;

    public C1093(Context context) {
        this(context, null, 0, 6, null);
    }

    public C1093(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1093(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1093(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        m16185();
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        m16185();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m16185() {
        if (this.f15264 == null) {
            this.f15264 = new Rect();
        }
        Rect rect = this.f15264;
        if (rect != null) {
            rect.set(getLeft(), (int) (-getTranslationY()), getRight(), getHeight());
        }
        super.setClipBounds(this.f15264);
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        C1457Fr.m5025(canvas, "canvas");
        Rect rect = this.f15264;
        if (rect == null || !rect.isEmpty()) {
            super.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        C1457Fr.m5025(canvas, "canvas");
        Rect rect = this.f15264;
        if (rect == null || !rect.isEmpty()) {
            super.onDraw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchDraw(Canvas canvas) {
        C1457Fr.m5025(canvas, "canvas");
        Rect rect = this.f15264;
        if (rect == null || !rect.isEmpty()) {
            super.dispatchDraw(canvas);
        }
    }
}

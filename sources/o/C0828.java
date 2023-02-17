package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
/* renamed from: o.ᓘ  reason: contains not printable characters */
public final class C0828 extends View {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f14631;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f14632;

    public C0828(Context context) {
        this(context, null, 0, 6, null);
    }

    public C0828(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0828(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        setFitsSystemWindows(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0828(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        C1457Fr.m5025(windowInsets, "insets");
        this.f14631 = windowInsets.getSystemWindowInsetTop();
        m15446();
        return windowInsets;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m15446() {
        int i = this.f14632;
        this.f14632 = (getWindowSystemUiVisibility() & 4096) == 4096 ? 0 : this.f14631;
        if (i != this.f14632) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f14632, View.MeasureSpec.getMode(i2)));
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        m15446();
    }
}

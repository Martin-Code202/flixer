package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
/* renamed from: o.ঌ  reason: contains not printable characters */
public final class C0649 extends View {

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f13992;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f13993;

    public C0649(Context context) {
        this(context, null, 0, 6, null);
    }

    public C0649(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0649(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        setFitsSystemWindows(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0649(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        C1457Fr.m5025(windowInsets, "insets");
        this.f13993 = windowInsets.getSystemWindowInsetBottom();
        m14793();
        return windowInsets;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m14793() {
        int i = this.f13992;
        this.f13992 = (getWindowSystemUiVisibility() & 4096) == 4096 ? 0 : this.f13993;
        if (i != this.f13992) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f13992, View.MeasureSpec.getMode(i2)));
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        m14793();
    }
}

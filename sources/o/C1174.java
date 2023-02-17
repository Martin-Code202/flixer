package o;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import o.C1037;
/* renamed from: o.ﹾ  reason: contains not printable characters */
public class C1174 extends ScrollView implements AbstractC0458 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f15446 = C1174.class.getSimpleName();

    /* renamed from: ˊ  reason: contains not printable characters */
    private View f15447;

    /* renamed from: ˎ  reason: contains not printable characters */
    int[] f15448;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC0444 f15449;

    /* renamed from: ॱ  reason: contains not printable characters */
    private View f15450;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0672 f15451;

    public C1174(Context context) {
        this(context, null);
    }

    public C1174(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1174(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15448 = new int[2];
        this.f15451 = new C0672(this, new C0425(context), new C1167(context, attributeSet, C1037.C1038.StickyScrollView));
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.ﹾ.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                C1174.this.f15451.m14878(C1037.C1038.StickyScrollView_stickyHeader, C1037.C1038.StickyScrollView_stickyFooter);
                C1174.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f15447 != null && !z) {
            this.f15447.getLocationInWindow(this.f15448);
            this.f15451.m14880(m16381(this.f15447), this.f15448[1]);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int m16381(View view) {
        if (view.getParent() == view.getRootView()) {
            return view.getTop();
        }
        return view.getTop() + m16381((View) view.getParent());
    }

    @Override // o.AbstractC0458
    /* renamed from: ˏ */
    public void mo14346(int i) {
        this.f15450 = findViewById(i);
        this.f15451.m14879(this.f15450.getTop());
    }

    @Override // o.AbstractC0458
    /* renamed from: ॱ */
    public void mo14347(int i) {
        this.f15447 = findViewById(i);
        this.f15451.m14882(this.f15447.getMeasuredHeight(), m16381(this.f15447));
    }

    @Override // o.AbstractC0458
    /* renamed from: ˋ */
    public void mo14343() {
        if (this.f15450 != null) {
            this.f15450.setTranslationY(0.0f);
            C0377.m14141(this.f15450, 0.0f);
        }
    }

    @Override // o.AbstractC0458
    /* renamed from: ˎ */
    public void mo14345() {
        if (this.f15447 != null) {
            this.f15447.setTranslationY(0.0f);
        }
    }

    @Override // o.AbstractC0458
    /* renamed from: ˊ */
    public void mo14342(int i) {
        if (this.f15450 != null) {
            this.f15450.setTranslationY((float) i);
            C0377.m14141(this.f15450, 1.0f);
        }
    }

    @Override // o.AbstractC0458
    /* renamed from: ˋ */
    public void mo14344(int i) {
        if (this.f15447 != null) {
            this.f15447.setTranslationY((float) i);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.f15451.m14881(i2);
        if (this.f15449 != null) {
            this.f15449.m14310(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(AbstractC0444 r1) {
        this.f15449 = r1;
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (this.f15449 != null) {
            this.f15449.m14311(z2);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("super_state", super.onSaveInstanceState());
        bundle.putBoolean("scroll_state", this.f15451.f14055);
        return bundle;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f15451.f14055 = bundle.getBoolean("scroll_state");
            parcelable = bundle.getParcelable("super_state");
        }
        super.onRestoreInstanceState(parcelable);
    }
}

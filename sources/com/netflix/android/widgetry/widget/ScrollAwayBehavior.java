package com.netflix.android.widgetry.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import o.C0843;
public class ScrollAwayBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String f159 = "ScrollAwayBehavior";

    /* renamed from: ˋ  reason: contains not printable characters */
    protected int f160 = 48;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected View f161;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f162 = 0;

    public ScrollAwayBehavior(int i) {
        this.f160 = i;
    }

    public ScrollAwayBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof C0843;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f161 = v;
        coordinatorLayout.onLayoutChild(v, i);
        v.setTranslationY((float) this.f162);
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
        m106(v, i2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m106(View view, int i) {
        int i2 = 0;
        switch (this.f160) {
            case 48:
                i2 = -i;
                if (i2 >= 0) {
                    if (this.f162 != 0) {
                        if (this.f162 + i2 > 0) {
                            i2 = -this.f162;
                            break;
                        }
                    } else {
                        return;
                    }
                } else if (this.f162 != view.getHeight()) {
                    if (this.f162 + i2 < (-view.getHeight())) {
                        i2 = -(view.getHeight() + this.f162);
                        break;
                    }
                } else {
                    return;
                }
                break;
            case 80:
                i2 = i;
                if (i <= 0) {
                    if (this.f162 != 0) {
                        if (this.f162 + i < 0) {
                            i2 = -this.f162;
                            break;
                        }
                    } else {
                        return;
                    }
                } else if (this.f162 != view.getHeight()) {
                    if (this.f162 + i > view.getHeight()) {
                        i2 = view.getHeight() - this.f162;
                        break;
                    }
                } else {
                    return;
                }
                break;
        }
        this.f162 += i2;
        view.setTranslationY((float) this.f162);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        m107();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m107() {
        if (this.f161 != null) {
            this.f161.setTranslationY(0.0f);
        }
        this.f162 = 0;
    }
}

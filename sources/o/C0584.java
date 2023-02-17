package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import o.C0602;
/* renamed from: o.م  reason: contains not printable characters */
public class C0584 extends ViewGroup {

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f13849;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f13850;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f13851 = 0;

    public C0584(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0602.aux.FlowLayout);
        try {
            this.f13850 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.FlowLayout_fl_horizontalSpacing, 0);
            this.f13849 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.FlowLayout_fl_verticalSpacing, 0);
            this.f13851 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.FlowLayout_fl_maxWidth, this.f13851);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = (View.MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int mode = View.MeasureSpec.getMode(i);
        int layoutDirection = getLayoutDirection();
        boolean z = mode != 0;
        if (this.f13851 > 0) {
            size = Math.min(size, this.f13851);
        }
        int i3 = 0;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int i4 = 0;
        int i5 = 0;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                iF iFVar = (iF) childAt.getLayoutParams();
                i5 = this.f13850;
                if (iFVar.f13852 >= 0) {
                    i5 = iFVar.f13852;
                }
                if (z && childAt.getMeasuredWidth() + paddingLeft > size) {
                    paddingTop += this.f13849 + i4;
                    i4 = 0;
                    i3 = Math.max(i3, paddingLeft - i5);
                    paddingLeft = getPaddingLeft();
                }
                if (layoutDirection == 1) {
                    iFVar.f13854 = (size - paddingLeft) - childAt.getMeasuredWidth();
                } else {
                    iFVar.f13854 = paddingLeft;
                }
                iFVar.f13853 = paddingTop;
                paddingLeft += childAt.getMeasuredWidth() + i5;
                i4 = Math.max(i4, childAt.getMeasuredHeight());
            }
        }
        int max = Math.max(i3, paddingLeft - i5) + getPaddingRight();
        int paddingBottom = paddingTop + getPaddingBottom() + i4;
        if (layoutDirection == 1 && getLayoutParams().width == -2 && size != max) {
            int i7 = size - max;
            for (int i8 = 0; i8 < childCount; i8++) {
                ((iF) getChildAt(i8).getLayoutParams()).f13854 -= i7;
            }
        }
        setMeasuredDimension(resolveSize(max, i), resolveSize(paddingBottom, i2));
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            iF iFVar = (iF) childAt.getLayoutParams();
            childAt.layout(iFVar.f13854, iFVar.f13853, iFVar.f13854 + childAt.getMeasuredWidth(), iFVar.f13853 + childAt.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof iF;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public iF generateDefaultLayoutParams() {
        return new iF(-2, -2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public iF generateLayoutParams(AttributeSet attributeSet) {
        return new iF(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public iF generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new iF(layoutParams.width, layoutParams.height);
    }

    /* renamed from: o.م$iF */
    public static class iF extends ViewGroup.LayoutParams {

        /* renamed from: ˊ  reason: contains not printable characters */
        int f13852 = -1;

        /* renamed from: ˋ  reason: contains not printable characters */
        int f13853;

        /* renamed from: ॱ  reason: contains not printable characters */
        int f13854;

        public iF(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0602.aux.FlowLayout_LayoutParams);
            try {
                this.f13852 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.FlowLayout_LayoutParams_layout_fl_horizontalSpacing, -1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public iF(int i, int i2) {
            super(i, i2);
        }
    }
}

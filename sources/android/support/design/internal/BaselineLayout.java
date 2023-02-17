package android.support.design.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
public class BaselineLayout extends ViewGroup {
    private int mBaseline = -1;

    public BaselineLayout(Context context) {
        super(context, null, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                int baseline = childAt.getBaseline();
                if (baseline != -1) {
                    i5 = Math.max(i5, baseline);
                    i6 = Math.max(i6, childAt.getMeasuredHeight() - baseline);
                }
                i3 = Math.max(i3, childAt.getMeasuredWidth());
                i4 = Math.max(i4, childAt.getMeasuredHeight());
                i7 = View.combineMeasuredStates(i7, childAt.getMeasuredState());
            }
        }
        if (i5 != -1) {
            i4 = Math.max(i4, i5 + Math.max(i6, getPaddingBottom()));
            this.mBaseline = i5;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i3, getSuggestedMinimumWidth()), i, i7), View.resolveSizeAndState(Math.max(i4, getSuggestedMinimumHeight()), i2, i7 << 16));
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i3 - i) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = paddingLeft + ((paddingRight - measuredWidth) / 2);
                if (this.mBaseline == -1 || childAt.getBaseline() == -1) {
                    i5 = paddingTop;
                } else {
                    i5 = (this.mBaseline + paddingTop) - childAt.getBaseline();
                }
                childAt.layout(i7, i5, i7 + measuredWidth, i5 + measuredHeight);
            }
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        return this.mBaseline;
    }
}

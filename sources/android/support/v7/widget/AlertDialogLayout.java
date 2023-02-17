package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        if (!tryOnMeasure(i, i2)) {
            super.onMeasure(i, i2);
        }
    }

    private boolean tryOnMeasure(int i, int i2) {
        int i3;
        View view = null;
        View view2 = null;
        View view3 = null;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int i5 = 0;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i, 0);
            paddingTop += view.getMeasuredHeight();
            i5 = View.combineMeasuredStates(0, view.getMeasuredState());
        }
        int i6 = 0;
        int i7 = 0;
        if (view2 != null) {
            view2.measure(i, 0);
            i6 = resolveMinimumHeight(view2);
            i7 = view2.getMeasuredHeight() - i6;
            paddingTop += i6;
            i5 = View.combineMeasuredStates(i5, view2.getMeasuredState());
        }
        int i8 = 0;
        if (view3 != null) {
            if (mode == 0) {
                i3 = 0;
            } else {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
            }
            view3.measure(i, i3);
            i8 = view3.getMeasuredHeight();
            paddingTop += i8;
            i5 = View.combineMeasuredStates(i5, view3.getMeasuredState());
        }
        int i9 = size - paddingTop;
        if (view2 != null) {
            int i10 = paddingTop - i6;
            int min = Math.min(i9, i7);
            if (min > 0) {
                i9 -= min;
                i6 += min;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            paddingTop = i10 + view2.getMeasuredHeight();
            i5 = View.combineMeasuredStates(i5, view2.getMeasuredState());
        }
        if (view3 != null && i9 > 0) {
            int i11 = i9 - i9;
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(i8 + i9, mode));
            paddingTop = (paddingTop - i8) + view3.getMeasuredHeight();
            i5 = View.combineMeasuredStates(i5, view3.getMeasuredState());
        }
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                i12 = Math.max(i12, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i12 + getPaddingLeft() + getPaddingRight(), i, i5), View.resolveSizeAndState(paddingTop, i2, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i2);
        return true;
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (!(view instanceof ViewGroup)) {
            return 0;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() == 1) {
            return resolveMinimumHeight(viewGroup.getChildAt(0));
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i9 = gravity & 8388615;
        switch (gravity & 112) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - measuredHeight) / 2);
                break;
            case 48:
            default:
                i5 = getPaddingTop();
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - measuredHeight;
                break;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            i6 = 0;
        } else {
            i6 = dividerDrawable.getIntrinsicHeight();
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i11 = layoutParams.gravity;
                if (i11 < 0) {
                    i11 = i9;
                }
                switch (GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)) & 7) {
                    case 1:
                        i7 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    default:
                        i7 = paddingLeft + layoutParams.leftMargin;
                        break;
                    case 5:
                        i7 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                }
                if (hasDividerBeforeChildAt(i10)) {
                    i5 += i6;
                }
                int i12 = i5 + layoutParams.topMargin;
                setChildFrame(childAt, i7, i12, measuredWidth, measuredHeight2);
                i5 = i12 + layoutParams.bottomMargin + measuredHeight2;
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }
}

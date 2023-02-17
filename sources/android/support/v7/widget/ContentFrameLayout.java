package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
public class ContentFrameLayout extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDecorPadding = new Rect();
    }

    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.mAttachListener = onAttachListener;
    }

    public void setDecorPadding(int i, int i2, int i3, int i4) {
        this.mDecorPadding.set(i, i2, i3, i4);
        if (ViewCompat.isLaidOut(this)) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z2 = false;
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue = z ? this.mFixedWidthMinor : this.mFixedWidthMajor;
            if (!(typedValue == null || typedValue.type == 0)) {
                int i3 = 0;
                if (typedValue.type == 5) {
                    i3 = (int) typedValue.getDimension(displayMetrics);
                } else if (typedValue.type == 6) {
                    i3 = (int) typedValue.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
                }
                if (i3 > 0) {
                    i = View.MeasureSpec.makeMeasureSpec(Math.min(i3 - (this.mDecorPadding.left + this.mDecorPadding.right), View.MeasureSpec.getSize(i)), 1073741824);
                    z2 = true;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z ? this.mFixedHeightMajor : this.mFixedHeightMinor;
            if (!(typedValue2 == null || typedValue2.type == 0)) {
                int i4 = 0;
                if (typedValue2.type == 5) {
                    i4 = (int) typedValue2.getDimension(displayMetrics);
                } else if (typedValue2.type == 6) {
                    i4 = (int) typedValue2.getFraction((float) displayMetrics.heightPixels, (float) displayMetrics.heightPixels);
                }
                if (i4 > 0) {
                    i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i4 - (this.mDecorPadding.top + this.mDecorPadding.bottom), View.MeasureSpec.getSize(i2)), 1073741824);
                }
            }
        }
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        boolean z3 = false;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z2 && mode == Integer.MIN_VALUE) {
            TypedValue typedValue3 = z ? this.mMinWidthMinor : this.mMinWidthMajor;
            if (!(typedValue3 == null || typedValue3.type == 0)) {
                int i5 = 0;
                if (typedValue3.type == 5) {
                    i5 = (int) typedValue3.getDimension(displayMetrics);
                } else if (typedValue3.type == 6) {
                    i5 = (int) typedValue3.getFraction((float) displayMetrics.widthPixels, (float) displayMetrics.widthPixels);
                }
                if (i5 > 0) {
                    i5 -= this.mDecorPadding.left + this.mDecorPadding.right;
                }
                if (measuredWidth < i5) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                    z3 = true;
                }
            }
        }
        if (z3) {
            super.onMeasure(makeMeasureSpec, i2);
        }
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor == null) {
            this.mMinWidthMajor = new TypedValue();
        }
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor == null) {
            this.mMinWidthMinor = new TypedValue();
        }
        return this.mMinWidthMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor == null) {
            this.mFixedWidthMajor = new TypedValue();
        }
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor == null) {
            this.mFixedWidthMinor = new TypedValue();
        }
        return this.mFixedWidthMinor;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor == null) {
            this.mFixedHeightMajor = new TypedValue();
        }
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor == null) {
            this.mFixedHeightMinor = new TypedValue();
        }
        return this.mFixedHeightMinor;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mAttachListener != null) {
            this.mAttachListener.onAttachedFromWindow();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mAttachListener != null) {
            this.mAttachListener.onDetachedFromWindow();
        }
    }
}

package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
public class LinearLayoutCompat extends ViewGroup {
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            setWillNotDraw(drawable == null);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersVertical(Canvas canvas) {
        int i;
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i2))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                i = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                i = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawDividersHorizontal(Canvas canvas) {
        int i;
        int i2;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i3))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    i2 = virtualChildAt.getRight() + layoutParams.rightMargin;
                } else {
                    i2 = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, i2);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    i = (virtualChildAt2.getLeft() - layoutParams2.leftMargin) - this.mDividerWidth;
                } else {
                    i = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                }
            } else if (isLayoutRtl) {
                i = getPaddingLeft();
            } else {
                i = (getWidth() - getPaddingRight()) - this.mDividerWidth;
            }
            drawVerticalDivider(canvas, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.mBaselineAlignedChildIndex);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i2 = this.mBaselineChildTop;
            if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
                switch (i) {
                    case 16:
                        i2 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                        break;
                    case 80:
                        i2 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                        break;
                }
            }
            return ((LayoutParams) childAt.getLayoutParams()).topMargin + i2 + baseline;
        } else if (this.mBaselineAlignedChildIndex == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    /* access modifiers changed from: package-private */
    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void measureVertical(int i, int i2) {
        this.mTotalLength = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z = true;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z2 = false;
        boolean z3 = false;
        int i7 = this.mBaselineAlignedChildIndex;
        boolean z4 = this.mUseLargestChild;
        int i8 = 0;
        int i9 = 0;
        while (i9 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i9);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i9);
            } else if (virtualChildAt.getVisibility() == 8) {
                i9 += getChildrenSkipCount(virtualChildAt, i9);
            } else {
                if (hasDividerBeforeChildAt(i9)) {
                    this.mTotalLength += this.mDividerHeight;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                f += layoutParams.weight;
                if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                    int i10 = this.mTotalLength;
                    this.mTotalLength = Math.max(i10, layoutParams.topMargin + i10 + layoutParams.bottomMargin);
                    z3 = true;
                } else {
                    int i11 = Integer.MIN_VALUE;
                    if (layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                        i11 = 0;
                        layoutParams.height = -2;
                    }
                    measureChildBeforeLayout(virtualChildAt, i9, i, 0, i2, f == 0.0f ? this.mTotalLength : 0);
                    if (i11 != Integer.MIN_VALUE) {
                        layoutParams.height = i11;
                    }
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    int i12 = this.mTotalLength;
                    this.mTotalLength = Math.max(i12, i12 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt));
                    if (z4) {
                        i8 = Math.max(measuredHeight, i8);
                    }
                }
                if (i7 >= 0 && i7 == i9 + 1) {
                    this.mBaselineChildTop = this.mTotalLength;
                }
                if (i9 >= i7 || layoutParams.weight <= 0.0f) {
                    boolean z5 = false;
                    if (mode != 1073741824 && layoutParams.width == -1) {
                        z2 = true;
                        z5 = true;
                    }
                    int i13 = layoutParams.leftMargin + layoutParams.rightMargin;
                    int measuredWidth = virtualChildAt.getMeasuredWidth() + i13;
                    i3 = Math.max(i3, measuredWidth);
                    i4 = View.combineMeasuredStates(i4, virtualChildAt.getMeasuredState());
                    z = z && layoutParams.width == -1;
                    if (layoutParams.weight > 0.0f) {
                        i6 = Math.max(i6, z5 ? i13 : measuredWidth);
                    } else {
                        i5 = Math.max(i5, z5 ? i13 : measuredWidth);
                    }
                    i9 += getChildrenSkipCount(virtualChildAt, i9);
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i9++;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerHeight;
        }
        if (z4 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.mTotalLength = 0;
            int i14 = 0;
            while (i14 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i14);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i14);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i14 += getChildrenSkipCount(virtualChildAt2, i14);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    int i15 = this.mTotalLength;
                    this.mTotalLength = Math.max(i15, i15 + i8 + layoutParams2.topMargin + layoutParams2.bottomMargin + getNextLocationOffset(virtualChildAt2));
                }
                i14++;
            }
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i2, 0);
        int i16 = (resolveSizeAndState & 16777215) - this.mTotalLength;
        if (z3 || (i16 != 0 && f > 0.0f)) {
            float f2 = this.mWeightSum > 0.0f ? this.mWeightSum : f;
            this.mTotalLength = 0;
            for (int i17 = 0; i17 < virtualChildCount; i17++) {
                View virtualChildAt3 = getVirtualChildAt(i17);
                if (virtualChildAt3.getVisibility() != 8) {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f3 = layoutParams3.weight;
                    if (f3 > 0.0f) {
                        int i18 = (int) ((((float) i16) * f3) / f2);
                        f2 -= f3;
                        i16 -= i18;
                        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                        if (layoutParams3.height == 0 && mode2 == 1073741824) {
                            virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i18 > 0 ? i18 : 0, 1073741824));
                        } else {
                            int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i18;
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
                        }
                        i4 = View.combineMeasuredStates(i4, virtualChildAt3.getMeasuredState() & -256);
                    }
                    int i19 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i19;
                    i3 = Math.max(i3, measuredWidth2);
                    i5 = Math.max(i5, mode != 1073741824 && layoutParams3.width == -1 ? i19 : measuredWidth2);
                    z = z && layoutParams3.width == -1;
                    int i20 = this.mTotalLength;
                    this.mTotalLength = Math.max(i20, virtualChildAt3.getMeasuredHeight() + i20 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                }
            }
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
        } else {
            i5 = Math.max(i5, i6);
            if (z4 && mode2 != 1073741824) {
                for (int i21 = 0; i21 < virtualChildCount; i21++) {
                    View virtualChildAt4 = getVirtualChildAt(i21);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
                    }
                }
            }
        }
        if (!z && mode != 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, i4), resolveSizeAndState);
        if (z2) {
            forceUniformWidth(virtualChildCount, i2);
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void measureHorizontal(int i, int i2) {
        this.mTotalLength = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z = true;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z2 = false;
        boolean z3 = false;
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z4 = this.mBaselineAligned;
        boolean z5 = this.mUseLargestChild;
        boolean z6 = mode == 1073741824;
        int i7 = 0;
        int i8 = 0;
        while (i8 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i8);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i8);
            } else if (virtualChildAt.getVisibility() == 8) {
                i8 += getChildrenSkipCount(virtualChildAt, i8);
            } else {
                if (hasDividerBeforeChildAt(i8)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                f += layoutParams.weight;
                if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                    if (z6) {
                        this.mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        int i9 = this.mTotalLength;
                        this.mTotalLength = Math.max(i9, layoutParams.leftMargin + i9 + layoutParams.rightMargin);
                    }
                    if (z4) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                    } else {
                        z3 = true;
                    }
                } else {
                    int i10 = Integer.MIN_VALUE;
                    if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                        i10 = 0;
                        layoutParams.width = -2;
                    }
                    measureChildBeforeLayout(virtualChildAt, i8, i, f == 0.0f ? this.mTotalLength : 0, i2, 0);
                    if (i10 != Integer.MIN_VALUE) {
                        layoutParams.width = i10;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z6) {
                        this.mTotalLength += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                    } else {
                        int i11 = this.mTotalLength;
                        this.mTotalLength = Math.max(i11, i11 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt));
                    }
                    if (z5) {
                        i7 = Math.max(measuredWidth, i7);
                    }
                }
                boolean z7 = false;
                if (mode2 != 1073741824 && layoutParams.height == -1) {
                    z2 = true;
                    z7 = true;
                }
                int i12 = layoutParams.topMargin + layoutParams.bottomMargin;
                int measuredHeight = virtualChildAt.getMeasuredHeight() + i12;
                i4 = View.combineMeasuredStates(i4, virtualChildAt.getMeasuredState());
                if (z4) {
                    int baseline = virtualChildAt.getBaseline();
                    if (baseline != -1) {
                        int i13 = ((((layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                        iArr[i13] = Math.max(iArr[i13], baseline);
                        iArr2[i13] = Math.max(iArr2[i13], measuredHeight - baseline);
                    }
                }
                i3 = Math.max(i3, measuredHeight);
                z = z && layoutParams.height == -1;
                if (layoutParams.weight > 0.0f) {
                    i6 = Math.max(i6, z7 ? i12 : measuredHeight);
                } else {
                    i5 = Math.max(i5, z7 ? i12 : measuredHeight);
                }
                i8 += getChildrenSkipCount(virtualChildAt, i8);
            }
            i8++;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
            i3 = Math.max(i3, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z5 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i14 = 0;
            while (i14 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i14);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i14);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i14 += getChildrenSkipCount(virtualChildAt2, i14);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z6) {
                        this.mTotalLength += layoutParams2.leftMargin + i7 + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i15 = this.mTotalLength;
                        this.mTotalLength = Math.max(i15, i15 + i7 + layoutParams2.leftMargin + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2));
                    }
                }
                i14++;
            }
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i, 0);
        int i16 = (resolveSizeAndState & 16777215) - this.mTotalLength;
        if (z3 || (i16 != 0 && f > 0.0f)) {
            float f2 = this.mWeightSum > 0.0f ? this.mWeightSum : f;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            i3 = -1;
            this.mTotalLength = 0;
            for (int i17 = 0; i17 < virtualChildCount; i17++) {
                View virtualChildAt3 = getVirtualChildAt(i17);
                if (!(virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8)) {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f3 = layoutParams3.weight;
                    if (f3 > 0.0f) {
                        int i18 = (int) ((((float) i16) * f3) / f2);
                        f2 -= f3;
                        i16 -= i18;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width == 0 && mode == 1073741824) {
                            virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i18 > 0 ? i18 : 0, 1073741824), childMeasureSpec);
                        } else {
                            int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i18;
                            if (measuredWidth2 < 0) {
                                measuredWidth2 = 0;
                            }
                            virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824), childMeasureSpec);
                        }
                        i4 = View.combineMeasuredStates(i4, virtualChildAt3.getMeasuredState() & -16777216);
                    }
                    if (z6) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3);
                    } else {
                        int i19 = this.mTotalLength;
                        this.mTotalLength = Math.max(i19, virtualChildAt3.getMeasuredWidth() + i19 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z8 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i20 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i20;
                    i3 = Math.max(i3, measuredHeight2);
                    i5 = Math.max(i5, z8 ? i20 : measuredHeight2);
                    z = z && layoutParams3.height == -1;
                    if (z4) {
                        int baseline2 = virtualChildAt3.getBaseline();
                        if (baseline2 != -1) {
                            int i21 = ((((layoutParams3.gravity < 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & -2) >> 1;
                            iArr[i21] = Math.max(iArr[i21], baseline2);
                            iArr2[i21] = Math.max(iArr2[i21], measuredHeight2 - baseline2);
                        }
                    }
                }
            }
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i3 = Math.max(i3, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
        } else {
            i5 = Math.max(i5, i6);
            if (z5 && mode != 1073741824) {
                for (int i22 = 0; i22 < virtualChildCount; i22++) {
                    View virtualChildAt4 = getVirtualChildAt(i22);
                    if (!(virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8 || ((LayoutParams) virtualChildAt4.getLayoutParams()).weight <= 0.0f)) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
        }
        if (!z && mode2 != 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension((-16777216 & i4) | resolveSizeAndState, View.resolveSizeAndState(Math.max(i3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, i4 << 16));
        if (z2) {
            forceUniformHeight(virtualChildCount, i);
        }
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int measureNullChild(int i) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public int getLocationOffset(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int getNextLocationOffset(View view) {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.mGravity & 112;
        int i9 = this.mGravity & 8388615;
        switch (i8) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
                break;
            case 48:
            default:
                i5 = getPaddingTop();
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
                break;
        }
        int i10 = 0;
        while (i10 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i10);
            if (virtualChildAt == null) {
                i5 += measureNullChild(i10);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i11 = layoutParams.gravity;
                if (i11 < 0) {
                    i11 = i9;
                }
                switch (GravityCompat.getAbsoluteGravity(i11, ViewCompat.getLayoutDirection(this)) & 7) {
                    case 1:
                        i6 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    default:
                        i6 = paddingLeft + layoutParams.leftMargin;
                        break;
                    case 5:
                        i6 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                }
                if (hasDividerBeforeChildAt(i10)) {
                    i5 += this.mDividerHeight;
                }
                int i12 = i5 + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i6, getLocationOffset(virtualChildAt) + i12, measuredWidth, measuredHeight);
                i5 = i12 + layoutParams.bottomMargin + measuredHeight + getNextLocationOffset(virtualChildAt);
                i10 += getChildrenSkipCount(virtualChildAt, i10);
            }
            i10++;
        }
    }

    /* access modifiers changed from: package-private */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.mGravity & 8388615;
        int i9 = this.mGravity & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        switch (GravityCompat.getAbsoluteGravity(i8, ViewCompat.getLayoutDirection(this))) {
            case 1:
                i5 = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
                break;
            case 2:
            case 3:
            case 4:
            default:
                i5 = getPaddingLeft();
                break;
            case 5:
                i5 = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
                break;
        }
        int i10 = 0;
        int i11 = 1;
        if (isLayoutRtl) {
            i10 = virtualChildCount - 1;
            i11 = -1;
        }
        int i12 = 0;
        while (i12 < virtualChildCount) {
            int i13 = i10 + (i11 * i12);
            View virtualChildAt = getVirtualChildAt(i13);
            if (virtualChildAt == null) {
                i5 += measureNullChild(i13);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                int i14 = -1;
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (z && layoutParams.height != -1) {
                    i14 = virtualChildAt.getBaseline();
                }
                int i15 = layoutParams.gravity;
                if (i15 < 0) {
                    i15 = i9;
                }
                switch (i15 & 112) {
                    case 16:
                        i6 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i6 = paddingTop + layoutParams.topMargin;
                        if (i14 != -1) {
                            i6 += iArr[1] - i14;
                            break;
                        }
                        break;
                    case 80:
                        i6 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                        if (i14 != -1) {
                            i6 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i14);
                            break;
                        }
                        break;
                    default:
                        i6 = paddingTop;
                        break;
                }
                if (hasDividerBeforeChildAt(i13)) {
                    i5 += this.mDividerWidth;
                }
                int i16 = i5 + layoutParams.leftMargin;
                setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i16, i6, measuredWidth, measuredHeight);
                i5 = i16 + layoutParams.rightMargin + measuredWidth + getNextLocationOffset(virtualChildAt);
                i12 += getChildrenSkipCount(virtualChildAt, i13);
            }
            i12++;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.mGravity & 8388615) != i2) {
            this.mGravity = (this.mGravity & -8388616) | i2;
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.mGravity & 112) != i2) {
            this.mGravity = (this.mGravity & -113) | i2;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }
    }
}

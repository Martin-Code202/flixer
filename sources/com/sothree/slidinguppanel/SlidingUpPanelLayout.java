package com.sothree.slidinguppanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import o.C1021;
public class SlidingUpPanelLayout extends ViewGroup {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final int[] f4201 = {16842927};

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f4202;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private float f4203;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f4204;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private float f4205;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f4206;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final ViewDragHelper f4207;

    /* renamed from: ʾ  reason: contains not printable characters */
    private float f4208;

    /* renamed from: ʿ  reason: contains not printable characters */
    private iF f4209;

    /* renamed from: ˈ  reason: contains not printable characters */
    private boolean f4210;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Drawable f4211;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private SlideState f4212;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f4213;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final Rect f4214;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private View f4215;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f4216;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f4217;

    /* renamed from: ͺ  reason: contains not printable characters */
    private float f4218;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Paint f4219;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f4220;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final int f4221;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean f4222;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f4223;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f4224;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private View f4225;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private boolean f4226;

    /* access modifiers changed from: package-private */
    public enum SlideState {
        EXPANDED,
        COLLAPSED,
        ANCHORED
    }

    public interface iF {
        /* renamed from: ˊ */
        void mo278(View view);

        /* renamed from: ˊ */
        void mo279(View view, float f);

        /* renamed from: ˎ */
        void mo280(View view);

        /* renamed from: ॱ */
        void mo281(View view);
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4213 = 400;
        this.f4216 = -1728053248;
        this.f4219 = new Paint();
        this.f4204 = -1;
        this.f4206 = -1;
        this.f4217 = -1;
        this.f4212 = SlideState.COLLAPSED;
        this.f4205 = 0.0f;
        this.f4210 = true;
        this.f4214 = new Rect();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4201);
            if (obtainStyledAttributes != null) {
                int i2 = obtainStyledAttributes.getInt(0, 0);
                if (i2 == 48 || i2 == 80) {
                    this.f4202 = i2 == 80;
                } else {
                    throw new IllegalArgumentException("layout_gravity must be set to either top or bottom");
                }
            }
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.C0006.SlidingUpPanelLayout);
            if (obtainStyledAttributes2 != null) {
                this.f4204 = obtainStyledAttributes2.getDimensionPixelSize(0, -1);
                this.f4206 = obtainStyledAttributes2.getDimensionPixelSize(4, -1);
                this.f4213 = obtainStyledAttributes2.getInt(3, 400);
                this.f4216 = obtainStyledAttributes2.getColor(2, -1728053248);
                this.f4217 = obtainStyledAttributes2.getResourceId(1, -1);
            }
            obtainStyledAttributes2.recycle();
        }
        float f = context.getResources().getDisplayMetrics().density;
        if (this.f4204 == -1) {
            this.f4204 = (int) ((68.0f * f) + 0.5f);
        }
        if (this.f4206 == -1) {
            this.f4206 = (int) ((4.0f * f) + 0.5f);
        }
        setWillNotDraw(false);
        this.f4207 = ViewDragHelper.create(this, 0.5f, new C0060());
        this.f4207.setMinVelocity(((float) this.f4213) * f);
        this.f4223 = true;
        this.f4226 = true;
        this.f4221 = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.f4217 != -1) {
            this.f4225 = findViewById(this.f4217);
        }
    }

    public void setCoveredFadeColor(int i) {
        this.f4216 = i;
        invalidate();
    }

    public void setPanelHeight(int i) {
        this.f4204 = i;
        requestLayout();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m3216() {
        return this.f4204;
    }

    public void setPanelSlideListener(iF iFVar) {
        this.f4209 = iFVar;
    }

    public void setDragView(View view) {
        this.f4225 = view;
    }

    public void setAnchorPoint(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.f4205 = f;
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f4211 = drawable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3209(View view) {
        if (this.f4209 != null) {
            this.f4209.mo279(view, this.f4218);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m3217(View view) {
        if (this.f4209 != null) {
            this.f4209.mo278(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3214(View view) {
        if (this.f4209 != null) {
            this.f4209.mo280(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m3212(View view) {
        if (this.f4209 != null) {
            this.f4209.mo281(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3208() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            if (this.f4215 == null || !m3188(this.f4215)) {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.f4215.getLeft();
                i3 = this.f4215.getRight();
                i2 = this.f4215.getTop();
                i = this.f4215.getBottom();
            }
            View childAt = getChildAt(0);
            int max = Math.max(paddingLeft, childAt.getLeft());
            int max2 = Math.max(paddingTop, childAt.getTop());
            int min = Math.min(width, childAt.getRight());
            int min2 = Math.min(height, childAt.getBottom());
            if (max < i4 || max2 < i2 || min > i3 || min2 > i) {
                i5 = 0;
            } else {
                i5 = 4;
            }
            childAt.setVisibility(i5);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3206() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m3188(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4210 = true;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4210 = true;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 != 1073741824) {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        } else {
            int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            int i5 = this.f4204;
            int childCount = getChildCount();
            this.f4215 = null;
            this.f4223 = false;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                C0059 r11 = (C0059) childAt.getLayoutParams();
                int i7 = paddingTop;
                if (childAt.getVisibility() == 8) {
                    r11.f4234 = false;
                } else {
                    if (i6 == 1) {
                        r11.f4233 = true;
                        r11.f4234 = true;
                        this.f4215 = childAt;
                        this.f4223 = true;
                    } else {
                        i7 -= i5;
                    }
                    if (r11.width == -2) {
                        i3 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
                    } else if (r11.width == -1) {
                        i3 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                    } else {
                        i3 = View.MeasureSpec.makeMeasureSpec(r11.width, 1073741824);
                    }
                    if (r11.height == -2) {
                        i4 = View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
                    } else if (r11.height == -1) {
                        i4 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                    } else {
                        i4 = View.MeasureSpec.makeMeasureSpec(r11.height, 1073741824);
                    }
                    childAt.measure(i3, i4);
                }
            }
            setMeasuredDimension(size, size2);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int r4 = m3195();
        int childCount = getChildCount();
        if (this.f4210) {
            switch (this.f4212) {
                case EXPANDED:
                    this.f4218 = this.f4223 ? 0.0f : 1.0f;
                    break;
                case ANCHORED:
                    this.f4218 = this.f4223 ? this.f4205 : 1.0f;
                    break;
                default:
                    this.f4218 = 1.0f;
                    break;
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0059 r8 = (C0059) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                if (r8.f4233) {
                    this.f4220 = measuredHeight - this.f4204;
                }
                int i6 = this.f4202 ? r8.f4233 ? r4 + ((int) (((float) this.f4220) * this.f4218)) : paddingTop : r8.f4233 ? r4 - ((int) (((float) this.f4220) * this.f4218)) : paddingTop + this.f4204;
                childAt.layout(paddingLeft, i6, paddingLeft + childAt.getMeasuredWidth(), i6 + measuredHeight);
            }
        }
        if (this.f4210) {
            m3208();
        }
        this.f4210 = false;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.f4210 = true;
        }
    }

    public void setSlidingEnabled(boolean z) {
        this.f4226 = z;
    }

    public void setEnableDragViewTouchEvents(boolean z) {
        this.f4222 = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!this.f4223 || !this.f4226 || (this.f4224 && actionMasked != 0)) {
            this.f4207.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f4207.cancel();
            return false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            boolean z = false;
            switch (actionMasked) {
                case 0:
                    this.f4224 = false;
                    this.f4203 = x;
                    this.f4208 = y;
                    if (m3194((int) x, (int) y) && !this.f4222) {
                        z = true;
                        break;
                    }
                case 2:
                    float abs = Math.abs(x - this.f4203);
                    float abs2 = Math.abs(y - this.f4208);
                    int touchSlop = this.f4207.getTouchSlop();
                    if (this.f4222) {
                        if (abs > ((float) this.f4221) && abs2 < ((float) this.f4221)) {
                            return super.onInterceptTouchEvent(motionEvent);
                        }
                        if (abs2 > ((float) this.f4221)) {
                            z = m3194((int) x, (int) y);
                        }
                    }
                    if ((abs2 > ((float) touchSlop) && abs > abs2) || !m3194((int) x, (int) y)) {
                        this.f4207.cancel();
                        this.f4224 = true;
                        return false;
                    }
                    break;
            }
            return this.f4207.shouldInterceptTouchEvent(motionEvent) || z;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4223 || !this.f4226) {
            return super.onTouchEvent(motionEvent);
        }
        this.f4207.processTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f4203 = x;
                this.f4208 = y;
                break;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f = x2 - this.f4203;
                float f2 = y2 - this.f4208;
                int touchSlop = this.f4207.getTouchSlop();
                View view = this.f4225 != null ? this.f4225 : this.f4215;
                if ((f * f) + (f2 * f2) < ((float) (touchSlop * touchSlop)) && m3194((int) x2, (int) y2)) {
                    view.playSoundEffect(0);
                    if (!m3218() && !m3203()) {
                        m3210(this.f4205);
                        break;
                    } else {
                        m3213();
                        break;
                    }
                }
                break;
        }
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m3194(int i, int i2) {
        View view = this.f4225 != null ? this.f4225 : this.f4215;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        return i3 >= iArr[0] && i3 < iArr[0] + view.getWidth() && i4 >= iArr[1] && i4 < iArr[1] + view.getHeight();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m3198(View view, int i, float f) {
        if (this.f4210 || m3207(f, i)) {
            return true;
        }
        return false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m3197(View view, int i) {
        if (this.f4210 || m3207(1.0f, i)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private int m3195() {
        if (this.f4215 != null) {
            return (getMeasuredHeight() - getPaddingBottom()) - this.f4215.getMeasuredHeight();
        }
        return getMeasuredHeight() - getPaddingBottom();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m3213() {
        return m3197(this.f4215, 0);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m3215() {
        return m3210(0.0f);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m3210(float f) {
        if (!m3219()) {
            m3204();
        }
        return m3198(this.f4215, 0, f);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m3218() {
        return this.f4212 == SlideState.EXPANDED;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m3205() {
        return this.f4212 == SlideState.COLLAPSED && !m3200();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean m3200() {
        return !C1021.m15987(this.f4218, 0.0f) && !C1021.m15987(this.f4218, 1.0f);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m3203() {
        return this.f4212 == SlideState.ANCHORED;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m3219() {
        return getChildCount() >= 2 && getChildAt(1).getVisibility() == 0;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m3204() {
        if (getChildCount() >= 2) {
            getChildAt(1).setVisibility(0);
            requestLayout();
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m3211() {
        if (this.f4215 != null) {
            this.f4215.setVisibility(8);
            requestLayout();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m3193(int i) {
        int r2 = m3195();
        this.f4218 = this.f4202 ? ((float) (i - r2)) / ((float) this.f4220) : ((float) (r2 - i)) / ((float) this.f4220);
        if (this.f4218 < 0.0f) {
            this.f4218 = 0.0f;
        } else if (this.f4218 > 1.0f) {
            this.f4218 = 1.0f;
        }
        m3209(this.f4215);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        C0059 r3 = (C0059) view.getLayoutParams();
        int save = canvas.save(2);
        boolean z = false;
        if (this.f4223 && !r3.f4233 && this.f4215 != null) {
            canvas.getClipBounds(this.f4214);
            if (this.f4202) {
                this.f4214.bottom = Math.min(this.f4214.bottom, this.f4215.getTop());
            } else {
                this.f4214.top = Math.max(this.f4214.top, this.f4215.getBottom());
            }
            if (this.f4218 < 1.0f) {
                z = true;
            }
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (z) {
            this.f4219.setColor((((int) (((float) ((this.f4216 & -16777216) >>> 24)) * (1.0f - this.f4218))) << 24) | (this.f4216 & 16777215));
            canvas.drawRect(this.f4214, this.f4219);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m3207(float f, int i) {
        if (!this.f4223) {
            return false;
        }
        int r3 = m3195();
        if (!this.f4207.smoothSlideViewTo(this.f4215, this.f4215.getLeft(), this.f4202 ? (int) (((float) r3) + (((float) this.f4220) * f)) : (int) (((float) r3) - (((float) this.f4220) * f)))) {
            return false;
        }
        m3206();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.f4207.continueSettling(true)) {
            return;
        }
        if (!this.f4223) {
            this.f4207.abort();
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        int i2;
        super.draw(canvas);
        if (this.f4215 != null) {
            int right = this.f4215.getRight();
            if (this.f4202) {
                i2 = this.f4215.getTop() - this.f4206;
                i = this.f4215.getTop();
            } else {
                i2 = this.f4215.getBottom();
                i = this.f4215.getBottom() + this.f4206;
            }
            int left = this.f4215.getLeft();
            if (this.f4211 != null) {
                this.f4211.setBounds(left, i2, right, i);
                this.f4211.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0059();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0059((ViewGroup.MarginLayoutParams) layoutParams) : new C0059(layoutParams);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0059) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0059(getContext(), attributeSet);
    }

    /* renamed from: com.sothree.slidinguppanel.SlidingUpPanelLayout$ˋ  reason: contains not printable characters */
    class C0060 extends ViewDragHelper.Callback {
        private C0060() {
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if (SlidingUpPanelLayout.this.f4224) {
                return false;
            }
            return ((C0059) view.getLayoutParams()).f4233;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            int i2 = (int) (SlidingUpPanelLayout.this.f4205 * ((float) SlidingUpPanelLayout.this.f4220));
            if (SlidingUpPanelLayout.this.f4207.getViewDragState() != 0) {
                return;
            }
            if (SlidingUpPanelLayout.this.f4218 == 0.0f || (SlidingUpPanelLayout.this.f4215 != null && SlidingUpPanelLayout.this.f4215.getTop() == 0)) {
                if (SlidingUpPanelLayout.this.f4212 != SlideState.EXPANDED) {
                    SlidingUpPanelLayout.this.m3208();
                    SlidingUpPanelLayout.this.m3217(SlidingUpPanelLayout.this.f4215);
                    SlidingUpPanelLayout.this.f4212 = SlideState.EXPANDED;
                }
            } else if (SlidingUpPanelLayout.this.f4218 == ((float) i2) / ((float) SlidingUpPanelLayout.this.f4220)) {
                if (SlidingUpPanelLayout.this.f4212 != SlideState.ANCHORED) {
                    SlidingUpPanelLayout.this.m3208();
                    SlidingUpPanelLayout.this.m3212(SlidingUpPanelLayout.this.f4215);
                    SlidingUpPanelLayout.this.f4212 = SlideState.ANCHORED;
                }
            } else if (SlidingUpPanelLayout.this.f4212 != SlideState.COLLAPSED) {
                SlidingUpPanelLayout.this.m3214(SlidingUpPanelLayout.this.f4215);
                SlidingUpPanelLayout.this.f4212 = SlideState.COLLAPSED;
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            SlidingUpPanelLayout.this.m3206();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.this.m3193(i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            float f3;
            if (SlidingUpPanelLayout.this.f4202) {
                i = SlidingUpPanelLayout.this.m3195();
            } else {
                i = SlidingUpPanelLayout.this.m3195() - SlidingUpPanelLayout.this.f4220;
            }
            if (SlidingUpPanelLayout.this.f4205 != 0.0f) {
                if (SlidingUpPanelLayout.this.f4202) {
                    f3 = ((float) ((int) (SlidingUpPanelLayout.this.f4205 * ((float) SlidingUpPanelLayout.this.f4220)))) / ((float) SlidingUpPanelLayout.this.f4220);
                } else {
                    f3 = ((float) (SlidingUpPanelLayout.this.f4204 - (SlidingUpPanelLayout.this.f4204 - ((int) (SlidingUpPanelLayout.this.f4205 * ((float) SlidingUpPanelLayout.this.f4220)))))) / ((float) SlidingUpPanelLayout.this.f4220);
                }
                if (f2 > 0.0f || (f2 == 0.0f && SlidingUpPanelLayout.this.f4218 >= (1.0f + f3) / 2.0f)) {
                    i += SlidingUpPanelLayout.this.f4220;
                } else if (f2 == 0.0f && SlidingUpPanelLayout.this.f4218 < (1.0f + f3) / 2.0f && SlidingUpPanelLayout.this.f4218 >= f3 / 2.0f) {
                    i = (int) (((float) i) + (((float) SlidingUpPanelLayout.this.f4220) * SlidingUpPanelLayout.this.f4205));
                }
            } else if (f2 > 0.0f || (f2 == 0.0f && SlidingUpPanelLayout.this.f4218 > 0.5f)) {
                i += SlidingUpPanelLayout.this.f4220;
            }
            SlidingUpPanelLayout.this.f4207.settleCapturedViewAt(view.getLeft(), i);
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return SlidingUpPanelLayout.this.f4220;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            int i3;
            int i4;
            if (SlidingUpPanelLayout.this.f4202) {
                i4 = SlidingUpPanelLayout.this.m3195();
                i3 = i4 + SlidingUpPanelLayout.this.f4220;
            } else {
                i3 = SlidingUpPanelLayout.this.getPaddingTop();
                i4 = i3 - SlidingUpPanelLayout.this.f4220;
            }
            return Math.min(Math.max(i, i4), i3);
        }
    }

    /* renamed from: com.sothree.slidinguppanel.SlidingUpPanelLayout$ˊ  reason: contains not printable characters */
    public static class C0059 extends ViewGroup.MarginLayoutParams {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static final int[] f4232 = {16843137};

        /* renamed from: ˋ  reason: contains not printable characters */
        boolean f4233;

        /* renamed from: ॱ  reason: contains not printable characters */
        boolean f4234;

        public C0059() {
            super(-1, -1);
        }

        public C0059(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0059(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0059(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context.obtainStyledAttributes(attributeSet, f4232).recycle();
        }
    }
}

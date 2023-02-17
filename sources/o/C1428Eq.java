package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import o.C1422Em;
import o.C1429Er;
/* renamed from: o.Eq  reason: case insensitive filesystem */
public class C1428Eq extends View implements AbstractC1427Ep {

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f5554;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private int f5555;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f5556;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f5557;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1429Er f5558;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f5559;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Paint f5560;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private int f5561;

    /* renamed from: ˎ  reason: contains not printable characters */
    private float f5562;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Paint f5563;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f5564;

    /* renamed from: ͺ  reason: contains not printable characters */
    private float f5565;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Paint f5566;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f5567;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f5568;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1429Er.AbstractC0094 f5569;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private float f5570;

    public C1428Eq(Context context) {
        this(context, null);
    }

    public C1428Eq(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1422Em.C1423iF.vpiCirclePageIndicatorStyle);
    }

    public C1428Eq(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5560 = new Paint(1);
        this.f5563 = new Paint(1);
        this.f5566 = new Paint(1);
        this.f5565 = -1.0f;
        this.f5555 = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(C1422Em.Cif.default_circle_indicator_page_color);
            int color2 = resources.getColor(C1422Em.Cif.default_circle_indicator_fill_color);
            int integer = resources.getInteger(C1422Em.C0087.default_circle_indicator_orientation);
            int color3 = resources.getColor(C1422Em.Cif.default_circle_indicator_stroke_color);
            float dimension = resources.getDimension(C1422Em.C0088.default_circle_indicator_stroke_width);
            float dimension2 = resources.getDimension(C1422Em.C0088.default_circle_indicator_radius);
            boolean z = resources.getBoolean(C1422Em.If.default_circle_indicator_centered);
            boolean z2 = resources.getBoolean(C1422Em.If.default_circle_indicator_snap);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1422Em.aux.CirclePageIndicator, i, 0);
            this.f5567 = obtainStyledAttributes.getBoolean(C1422Em.aux.CirclePageIndicator_centered, z);
            this.f5559 = obtainStyledAttributes.getInt(C1422Em.aux.CirclePageIndicator_android_orientation, integer);
            this.f5560.setStyle(Paint.Style.FILL);
            this.f5560.setColor(obtainStyledAttributes.getColor(C1422Em.aux.CirclePageIndicator_pageColor, color));
            this.f5563.setStyle(Paint.Style.STROKE);
            this.f5563.setColor(obtainStyledAttributes.getColor(C1422Em.aux.CirclePageIndicator_strokeColor, color3));
            this.f5563.setStrokeWidth(obtainStyledAttributes.getDimension(C1422Em.aux.CirclePageIndicator_strokeWidth, dimension));
            this.f5566.setStyle(Paint.Style.FILL);
            this.f5566.setColor(obtainStyledAttributes.getColor(C1422Em.aux.CirclePageIndicator_fillColor, color2));
            this.f5562 = obtainStyledAttributes.getDimension(C1422Em.aux.CirclePageIndicator_radius, dimension2);
            this.f5564 = obtainStyledAttributes.getBoolean(C1422Em.aux.CirclePageIndicator_snap, z2);
            Drawable drawable = obtainStyledAttributes.getDrawable(C1422Em.aux.CirclePageIndicator_android_background);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.f5561 = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.f5567 = z;
        invalidate();
    }

    public void setPageColor(int i) {
        this.f5560.setColor(i);
        invalidate();
    }

    public void setFillColor(int i) {
        this.f5566.setColor(i);
        invalidate();
    }

    public void setOrientation(int i) {
        switch (i) {
            case 0:
            case 1:
                this.f5559 = i;
                requestLayout();
                return;
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public void setStrokeColor(int i) {
        this.f5563.setColor(i);
        invalidate();
    }

    public void setStrokeWidth(float f) {
        this.f5563.setStrokeWidth(f);
        invalidate();
    }

    public void setRadius(float f) {
        this.f5562 = f;
        invalidate();
    }

    public void setSnap(boolean z) {
        this.f5564 = z;
        invalidate();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int count;
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (!(this.f5558 == null || (count = this.f5558.m4942().getCount()) == 0)) {
            if (this.f5556 >= count) {
                setCurrentItem(count - 1);
                return;
            }
            if (this.f5559 == 0) {
                i4 = getWidth();
                i3 = getPaddingLeft();
                i2 = getPaddingRight();
                i = getPaddingTop();
            } else {
                i4 = getHeight();
                i3 = getPaddingTop();
                i2 = getPaddingBottom();
                i = getPaddingLeft();
            }
            float f5 = this.f5562 * 3.0f;
            float f6 = ((float) i) + this.f5562;
            float f7 = ((float) i3) + this.f5562;
            if (this.f5567) {
                f7 += (((float) ((i4 - i3) - i2)) / 2.0f) - ((((float) count) * f5) / 2.0f);
            }
            float f8 = this.f5562;
            if (this.f5563.getStrokeWidth() > 0.0f) {
                f8 -= this.f5563.getStrokeWidth() / 2.0f;
            }
            for (int i5 = 0; i5 < count; i5++) {
                float f9 = f7 + (((float) i5) * f5);
                if (this.f5559 == 0) {
                    f4 = f9;
                    f3 = f6;
                } else {
                    f4 = f6;
                    f3 = f9;
                }
                if (this.f5560.getAlpha() > 0) {
                    canvas.drawCircle(f4, f3, f8, this.f5560);
                }
                if (f8 != this.f5562) {
                    canvas.drawCircle(f4, f3, this.f5562, this.f5563);
                }
            }
            float f10 = ((float) (this.f5564 ? this.f5554 : this.f5556)) * f5;
            if (!this.f5564) {
                f10 += this.f5570 * f5;
            }
            if (this.f5559 == 0) {
                f2 = f7 + f10;
                f = f6;
            } else {
                f2 = f6;
                f = f7 + f10;
            }
            canvas.drawCircle(f2, f, this.f5562, this.f5566);
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f5558 == null || this.f5558.m4942().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        switch (action) {
            case 0:
                this.f5555 = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f5565 = motionEvent.getX();
                return true;
            case 1:
            case 3:
                if (!this.f5568) {
                    int count = this.f5558.m4942().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.f5556 <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.f5556 < count - 1 && motionEvent.getX() > f + f2) {
                            if (action == 3) {
                                return true;
                            }
                            this.f5558.setCurrentItem(this.f5556 + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f5558.setCurrentItem(this.f5556 - 1);
                        return true;
                    }
                }
                this.f5568 = false;
                this.f5555 = -1;
                if (!this.f5558.m4964()) {
                    return true;
                }
                this.f5558.m4963();
                return true;
            case 2:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f5555));
                float f3 = x - this.f5565;
                if (!this.f5568 && Math.abs(f3) > ((float) this.f5561)) {
                    this.f5568 = true;
                }
                if (!this.f5568) {
                    return true;
                }
                this.f5565 = x;
                if (!this.f5558.m4964() && !this.f5558.m4953()) {
                    return true;
                }
                this.f5558.m4948(f3);
                return true;
            case 4:
            default:
                return true;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.f5565 = MotionEventCompat.getX(motionEvent, actionIndex);
                this.f5555 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                return true;
            case 6:
                int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, actionIndex2) == this.f5555) {
                    this.f5555 = MotionEventCompat.getPointerId(motionEvent, actionIndex2 == 0 ? 1 : 0);
                }
                this.f5565 = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f5555));
                return true;
        }
    }

    public void setViewPager(C1429Er er) {
        if (this.f5558 != er) {
            if (this.f5558 != null) {
                this.f5558.setOnPageChangeListener(null);
            }
            if (er.m4942() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f5558 = er;
            this.f5558.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void setViewPager(C1429Er er, int i) {
        setViewPager(er);
        setCurrentItem(i);
    }

    public void setCurrentItem(int i) {
        if (this.f5558 == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f5556 = i;
        invalidate();
    }

    @Override // o.C1429Er.AbstractC0094
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo4915(int i) {
        this.f5557 = i;
        if (this.f5569 != null) {
            this.f5569.mo4915(i);
        }
    }

    @Override // o.C1429Er.AbstractC0094
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo4916(int i, float f, int i2) {
        this.f5556 = i;
        this.f5570 = f;
        invalidate();
        if (this.f5569 != null) {
            this.f5569.mo4916(i, f, i2);
        }
    }

    @Override // o.C1429Er.AbstractC0094
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo4914(int i) {
        if (this.f5564 || this.f5557 == 0) {
            this.f5556 = i;
            this.f5554 = i;
            invalidate();
        }
        if (this.f5569 != null) {
            this.f5569.mo4914(i);
        }
    }

    public void setOnPageChangeListener(C1429Er.AbstractC0094 r1) {
        this.f5569 = r1;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f5559 == 0) {
            setMeasuredDimension(m4913(i), m4912(i2));
        } else {
            setMeasuredDimension(m4912(i), m4913(i2));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private int m4913(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.f5558 == null) {
            return size;
        }
        int count = this.f5558.m4942().getCount();
        int paddingLeft = (int) (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (count * 2)) * this.f5562) + (((float) (count - 1)) * this.f5562) + 1.0f);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(paddingLeft, size);
        }
        return paddingLeft;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int m4912(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((this.f5562 * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()) + 1.0f);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(paddingTop, size);
        }
        return paddingTop;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        If r1 = (If) parcelable;
        super.onRestoreInstanceState(r1.getSuperState());
        this.f5556 = r1.f5571;
        this.f5554 = r1.f5571;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        If r2 = new If(super.onSaveInstanceState());
        r2.f5571 = this.f5556;
        return r2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.Eq$If */
    public static class If extends View.BaseSavedState {
        public static final Parcelable.Creator<If> CREATOR = new Parcelable.Creator<If>() { // from class: o.Eq.If.3
            /* renamed from: ˋ  reason: contains not printable characters */
            public If createFromParcel(Parcel parcel) {
                return new If(parcel);
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public If[] newArray(int i) {
                return new If[i];
            }
        };

        /* renamed from: ˋ  reason: contains not printable characters */
        int f5571;

        public If(Parcelable parcelable) {
            super(parcelable);
        }

        private If(Parcel parcel) {
            super(parcel);
            this.f5571 = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5571);
        }
    }
}

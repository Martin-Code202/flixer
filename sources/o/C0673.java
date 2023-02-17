package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import o.C0602;
import o.C0697;
/* renamed from: o.৳  reason: contains not printable characters */
public class C0673 extends ViewGroup {

    /* renamed from: ʻ  reason: contains not printable characters */
    private ImageView f14061;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final int[] f14062;

    /* renamed from: ʼ  reason: contains not printable characters */
    private ViewGroup f14063;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final If f14064;

    /* renamed from: ʽ  reason: contains not printable characters */
    private FrameLayout f14065;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private int f14066;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final Rect f14067;

    /* renamed from: ʿ  reason: contains not printable characters */
    private final Paint f14068;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final Paint f14069;

    /* renamed from: ˉ  reason: contains not printable characters */
    private View f14070;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f14071;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private View.OnClickListener f14072;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private C0697.Cif f14073;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f14074;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final ViewTreeObserver.OnGlobalLayoutListener f14075;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f14076;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private boolean f14077;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private ViewPropertyAnimator f14078;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f14079;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f14080;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f14081;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f14082;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f14083;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private TextView f14084;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final RectF f14085;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final int[] f14086;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private ViewGroup f14087;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final RectF f14088;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private TextView f14089;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final Rect f14090;

    public C0673(Context context) {
        this(context, null);
    }

    public C0673(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14074 = 80;
        this.f14081 = 0;
        this.f14082 = 0;
        this.f14088 = new RectF();
        this.f14085 = new RectF();
        this.f14090 = new Rect();
        this.f14062 = new int[2];
        this.f14086 = new int[2];
        this.f14067 = new Rect();
        this.f14064 = new If();
        this.f14069 = new Paint();
        this.f14068 = new Paint();
        this.f14075 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: o.৳.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (C0673.this.f14070 != null && !C0673.this.f14070.isAttachedToWindow()) {
                    C0673.this.m14901((ViewGroup) C0673.this.getParent());
                } else if (C0673.this.m14891()) {
                    C0673.this.requestLayout();
                }
            }
        };
        this.f14079 = ContextCompat.getColor(getContext(), C0602.Cif.tooltip_accent_color);
        this.f14071 = ContextCompat.getColor(getContext(), C0602.Cif.tooltip_background_color);
        this.f14080 = getResources().getDimensionPixelSize(C0602.C0603.tooltip_max_width);
        this.f14076 = getResources().getDimensionPixelSize(C0602.C0603.tooltip_elevation);
        this.f14067.right = getResources().getDimensionPixelSize(C0602.C0603.tooltip_arrow_width);
        this.f14067.bottom = getResources().getDimensionPixelSize(C0602.C0603.tooltip_arrow_height);
        this.f14083 = getResources().getDimensionPixelSize(C0602.C0603.tooltip_height);
        this.f14068.setColor(0);
        this.f14068.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f14068.setPathEffect(new CornerPathEffect((float) getResources().getDimensionPixelSize(C0602.C0603.tooltip_radius)));
        this.f14069.setColor(ContextCompat.getColor(getContext(), C0602.Cif.tooltip_scrim_color));
        this.f14069.setStyle(Paint.Style.FILL);
        this.f14069.setAntiAlias(true);
        setBackground(new Cif());
        setFitsSystemWindows(true);
        setLayerType(1, null);
        setElevation((float) this.f14076);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    public void setScrimColor(int i) {
        this.f14069.setColor(i);
        invalidate();
    }

    public void setAccentColor(int i) {
        this.f14079 = i;
        requestLayout();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f14071 = i;
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f14061.setVisibility(8);
        this.f14089.setVisibility(0);
        this.f14089.setText(charSequence);
    }

    public void setTitle(Drawable drawable) {
        this.f14089.setVisibility(8);
        this.f14061.setVisibility(0);
        this.f14061.setImageDrawable(drawable);
    }

    public void setTitleTypeface(Typeface typeface) {
        this.f14089.setTypeface(typeface);
    }

    public void setDetailTypeface(Typeface typeface) {
        this.f14084.setTypeface(typeface);
    }

    public void setDetail(CharSequence charSequence) {
        this.f14084.setText(charSequence);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14902(View view) {
        this.f14070 = view;
        requestLayout();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public View m14903() {
        return this.f14070;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14905(ViewGroup viewGroup) {
        if (!(this.f14077 || this.f14070 == null || viewGroup == null || viewGroup.getViewTreeObserver() == null)) {
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.f14075);
            this.f14077 = true;
        }
        if (this.f14078 == null) {
            viewGroup.addView(this);
            setAlpha(0.0f);
            this.f14078 = animate().alpha(1.0f).setDuration((long) viewGroup.getResources().getInteger(17694720));
            this.f14078.setListener(new AnimatorListenerAdapter() { // from class: o.৳.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C0673.this.f14078 = null;
                    if (C0673.this.f14073 != null) {
                        C0673.this.f14073.mo12059(null);
                    }
                }
            });
            this.f14078.start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14906(C0697.Cif ifVar) {
        this.f14073 = ifVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14901(ViewGroup viewGroup) {
        final ViewGroup viewGroup2;
        if (!(this.f14070 == null || viewGroup == null || viewGroup.getViewTreeObserver() == null)) {
            viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this.f14075);
            this.f14077 = false;
        }
        if (this.f14078 == null && (viewGroup2 = (ViewGroup) getParent()) != null) {
            this.f14078 = animate().alpha(0.0f).setDuration((long) viewGroup2.getResources().getInteger(17694720));
            this.f14078.setListener(new AnimatorListenerAdapter() { // from class: o.৳.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewGroup2.removeView(C0673.this);
                    if (C0673.this.f14073 != null) {
                        C0673.this.f14073.mo12060(null);
                    }
                }
            });
            this.f14078.start();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f14065 = (FrameLayout) findViewById(C0602.IF.title);
        this.f14089 = (TextView) findViewById(C0602.IF.title_text);
        this.f14061 = (ImageView) findViewById(C0602.IF.title_image);
        this.f14084 = (TextView) findViewById(C0602.IF.detail);
        this.f14063 = (ViewGroup) findViewById(C0602.IF.tooltip);
        this.f14063.setBackground(this.f14064);
        this.f14063.setOnClickListener(new View.OnClickListener() { // from class: o.৳.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C0673.this.f14072 != null) {
                    C0673.this.f14072.onClick(view);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f14087 = (ViewGroup) getParent();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f14087 = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewParent, android.view.View
    public void requestLayout() {
        this.f14081 = 0;
        this.f14082 = 0;
        super.requestLayout();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m14891() {
        m14888(this.f14085);
        return this.f14070 != null && this.f14087 != null && this.f14070.isAttachedToWindow() && !this.f14085.equals(this.f14088);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14888(RectF rectF) {
        if (this.f14070 != null && this.f14087 != null) {
            this.f14070.getLocationInWindow(this.f14062);
            this.f14087.getLocationInWindow(this.f14086);
            int[] iArr = this.f14062;
            iArr[0] = iArr[0] - this.f14086[0];
            int[] iArr2 = this.f14062;
            iArr2[1] = iArr2[1] - this.f14086[1];
            rectF.left = (float) this.f14062[0];
            rectF.top = (float) this.f14062[1];
            rectF.right = (float) (this.f14062[0] + this.f14070.getMeasuredWidth());
            rectF.bottom = (float) (this.f14062[1] + this.f14070.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        if (this.f14070 != null && this.f14087 != null && this.f14070.isAttachedToWindow()) {
            if (m14891() || this.f14081 != getMeasuredWidth() || this.f14082 != getMeasuredHeight()) {
                m14888(this.f14085);
                this.f14088.set(this.f14085);
                measureChildWithMargins(this.f14063, View.MeasureSpec.makeMeasureSpec(Math.min(this.f14080, getMeasuredWidth()), 1073741824), 0, i2, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f14063.getLayoutParams();
                this.f14090.top = ((int) this.f14088.bottom) + marginLayoutParams.topMargin;
                this.f14090.bottom = this.f14090.top + this.f14063.getMeasuredHeight();
                this.f14090.left = Math.max(0, ((int) this.f14088.centerX()) - (this.f14063.getMeasuredWidth() / 2)) + marginLayoutParams.getMarginStart();
                this.f14090.right = this.f14090.left + this.f14063.getMeasuredWidth();
                if (this.f14090.right + marginLayoutParams.getMarginEnd() > getMeasuredWidth()) {
                    this.f14090.left = (getMeasuredWidth() - this.f14063.getMeasuredWidth()) - marginLayoutParams.getMarginEnd();
                    this.f14090.right = getMeasuredWidth() - marginLayoutParams.getMarginEnd();
                }
                if (this.f14090.top + this.f14063.getMeasuredHeight() + this.f14083 > getMeasuredHeight()) {
                    this.f14074 = 48;
                    this.f14090.bottom = ((int) this.f14088.top) - marginLayoutParams.topMargin;
                    this.f14090.top = this.f14090.bottom - this.f14063.getMeasuredHeight();
                } else {
                    this.f14074 = 80;
                }
                this.f14066 = (int) (this.f14088.centerX() - ((float) this.f14090.left));
                int width = this.f14066 - (this.f14067.width() / 2);
                int width2 = this.f14066 + (this.f14067.width() / 2);
                if (getLayoutDirection() == 1) {
                    i3 = this.f14063.getMeasuredWidth() - this.f14065.getMeasuredWidth();
                } else {
                    i3 = this.f14065.getMeasuredWidth();
                }
                if (width < i3 && width2 > i3) {
                    int width3 = this.f14067.width();
                    if (Math.abs(i3 - width) > Math.abs(i3 - width2)) {
                        this.f14066 = i3 - width3;
                    } else {
                        this.f14066 = i3 + width3;
                    }
                }
                this.f14066 += marginLayoutParams.getMarginStart();
                this.f14064.m14909();
                this.f14081 = getMeasuredWidth();
                this.f14082 = getMeasuredHeight();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f14063.layout(this.f14090.left, this.f14090.top, this.f14090.right, this.f14090.bottom);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public ViewGroup.MarginLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public ViewGroup.MarginLayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public ViewGroup.MarginLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || !isShown() || this.f14078 != null) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        if (keyEvent.getAction() != 1) {
            return true;
        }
        m14901((ViewGroup) getParent());
        return true;
    }

    /* renamed from: o.৳$if  reason: invalid class name */
    class Cif extends Drawable {
        private Cif() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.save();
            canvas.drawRect(0.0f, 0.0f, (float) C0673.this.getMeasuredWidth(), (float) C0673.this.getMeasuredHeight(), C0673.this.f14069);
            canvas.drawRect(C0673.this.f14088, C0673.this.f14068);
            canvas.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.৳$If */
    public class If extends Drawable {

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Rect f14097;

        /* renamed from: ˏ  reason: contains not printable characters */
        private C0674 f14098;

        /* renamed from: ॱ  reason: contains not printable characters */
        private C0674 f14099;

        private If() {
            this.f14097 = new Rect();
            this.f14099 = new C0674(C0673.this.f14079);
            this.f14098 = new C0674(C0673.this.f14071);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private void m14909() {
            if (this.f14099.m14910() != C0673.this.f14079) {
                this.f14099 = new C0674(C0673.this.f14079);
            }
            if (this.f14098.m14910() != C0673.this.f14071) {
                this.f14098 = new C0674(C0673.this.f14071);
            }
            this.f14097.top = 0;
            this.f14097.bottom = C0673.this.f14063.getMeasuredHeight();
            if (C0673.this.getLayoutDirection() == 1) {
                this.f14097.left = 0;
                this.f14097.right = C0673.this.f14063.getMeasuredWidth() - C0673.this.f14065.getMeasuredWidth();
            } else {
                this.f14097.left = C0673.this.f14065.getMeasuredWidth();
                this.f14097.right = C0673.this.f14063.getMeasuredWidth();
            }
            this.f14099.m14911();
            this.f14098.m14911();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.save();
            this.f14099.draw(canvas);
            canvas.clipRect(this.f14097);
            this.f14098.draw(canvas);
            canvas.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            this.f14099.setBounds(i, i2, i3, i4);
            this.f14098.setBounds(i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(Rect rect) {
            super.setBounds(rect);
            this.f14099.setBounds(rect);
            this.f14098.setBounds(rect);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.৳$If$ˋ  reason: contains not printable characters */
        public class C0674 extends Drawable {

            /* renamed from: ˊ  reason: contains not printable characters */
            private final int f14100;

            /* renamed from: ˋ  reason: contains not printable characters */
            private final Path f14101;

            /* renamed from: ˏ  reason: contains not printable characters */
            private final Paint f14103;

            private C0674(int i) {
                this.f14101 = new Path();
                this.f14103 = new Paint();
                this.f14103.setColor(i);
                this.f14103.setStyle(Paint.Style.FILL);
                this.f14103.setAntiAlias(true);
                this.f14103.setPathEffect(new CornerPathEffect((float) C0673.this.getResources().getDimensionPixelSize(C0602.C0603.tooltip_radius)));
                this.f14100 = C0673.this.getResources().getDimensionPixelSize(C0602.C0603.tooltip_horizontal_padding);
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public void m14911() {
                this.f14101.reset();
                if (C0673.this.f14074 == 48) {
                    int measuredHeight = C0673.this.f14063.getMeasuredHeight() - C0673.this.f14067.height();
                    this.f14101.moveTo(0.0f, 0.0f);
                    this.f14101.lineTo((float) C0673.this.f14063.getMeasuredWidth(), 0.0f);
                    this.f14101.lineTo((float) C0673.this.f14063.getMeasuredWidth(), (float) measuredHeight);
                    this.f14101.lineTo((float) ((C0673.this.f14066 + (C0673.this.f14067.width() / 2)) - this.f14100), (float) measuredHeight);
                    this.f14101.lineTo((float) (C0673.this.f14066 - this.f14100), (float) (C0673.this.f14067.height() + measuredHeight));
                    this.f14101.lineTo((float) ((C0673.this.f14066 - (C0673.this.f14067.width() / 2)) - this.f14100), (float) measuredHeight);
                    this.f14101.lineTo(0.0f, (float) measuredHeight);
                    this.f14101.lineTo(0.0f, 0.0f);
                    this.f14101.close();
                    C0673.this.f14063.setPadding(0, 0, 0, C0673.this.f14067.height());
                    return;
                }
                int height = C0673.this.f14067.height();
                int measuredHeight2 = C0673.this.f14063.getMeasuredHeight();
                this.f14101.moveTo(0.0f, (float) height);
                this.f14101.lineTo((float) ((C0673.this.f14066 - (C0673.this.f14067.width() / 2)) - this.f14100), (float) height);
                this.f14101.lineTo((float) (C0673.this.f14066 - this.f14100), (float) (height - C0673.this.f14067.height()));
                this.f14101.lineTo((float) ((C0673.this.f14066 + (C0673.this.f14067.width() / 2)) - this.f14100), (float) height);
                this.f14101.lineTo((float) C0673.this.f14063.getMeasuredWidth(), (float) height);
                this.f14101.lineTo((float) C0673.this.f14063.getMeasuredWidth(), (float) measuredHeight2);
                this.f14101.lineTo(0.0f, (float) measuredHeight2);
                this.f14101.lineTo(0.0f, (float) height);
                this.f14101.close();
                C0673.this.f14063.setPadding(0, C0673.this.f14067.height(), 0, 0);
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                canvas.drawPath(this.f14101, this.f14103);
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i) {
                this.f14103.setAlpha(i);
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
                this.f14103.setColorFilter(colorFilter);
            }

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return -1;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public int m14910() {
                return this.f14103.getColor();
            }
        }
    }
}

package o;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.util.List;
import o.C0602;
import o.C1177;
@SuppressLint({"ViewConstructor"})
/* renamed from: o.ǀ  reason: contains not printable characters */
public class C0362 extends ViewGroup {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Interpolator f13120 = PathInterpolatorCompat.create(0.23f, 1.0f, 0.32f, 1.0f);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final ImageView f13121;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final boolean f13122;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final Cif f13123;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final Rect f13124 = new Rect();

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Cif f13125;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final Point f13126 = new Point();

    /* renamed from: ʾ  reason: contains not printable characters */
    private final Rect f13127 = new Rect();

    /* renamed from: ʿ  reason: contains not printable characters */
    private final Rect f13128 = new Rect();

    /* renamed from: ˈ  reason: contains not printable characters */
    private final Rect f13129 = new Rect();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final CharSequence f13130;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private final Rect f13131 = new Rect();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final C0363 f13132;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final Point f13133 = new Point();

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private final int[] f13134 = new int[2];

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1177 f13135;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final ImageView f13136;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ImageView f13137;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C1177.AbstractC1178 f13138;

    /* renamed from: ͺ  reason: contains not printable characters */
    private CoordinatorLayout f13139;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final CharSequence f13140;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private Drawable f13141;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final int[] f13142 = new int[2];

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final int[] f13143 = new int[2];

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final boolean f13144;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private ImageView f13145 = null;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Cif f13146;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private boolean f13147 = false;

    /* access modifiers changed from: package-private */
    /* renamed from: o.ǀ$iF */
    public interface iF {
        /* renamed from: ˏ */
        void mo14034();
    }

    C0362(Context context, final C1177.AbstractC1178 r9, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, boolean z, boolean z2, int i) {
        super(context);
        inflate(getContext(), C0602.C0606.user_rating_overlay, this);
        this.f13122 = z2 && i == 1;
        this.f13140 = charSequence4;
        this.f13130 = charSequence5;
        this.f13144 = z;
        this.f13141 = new ColorDrawable(ContextCompat.getColor(getContext(), this.f13144 ? C0602.Cif.thumb_button_dark_dim : C0602.Cif.thumb_button_light_dim));
        setBackground(this.f13141);
        this.f13136 = (ImageView) findViewById(C0602.IF.user_rating_overlay_up);
        this.f13137 = (ImageView) findViewById(C0602.IF.user_rating_overlay_down);
        this.f13121 = (ImageView) findViewById(C0602.IF.user_rating_overlay_close);
        this.f13121.setOnClickListener(new View.OnClickListener() { // from class: o.ǀ.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C0362.this.m14022(true);
            }
        });
        this.f13125 = m14026(m14011());
        this.f13146 = m14026(m14016());
        this.f13123 = new Cif(C0602.C0604.ic_close_black_24dp, C0602.C0604.ic_close_black_24dp, false);
        this.f13136.setImageDrawable(this.f13125);
        this.f13137.setImageDrawable(this.f13146);
        this.f13121.setImageDrawable(this.f13123);
        this.f13136.setContentDescription(charSequence);
        this.f13137.setContentDescription(charSequence2);
        this.f13121.setContentDescription(charSequence3);
        this.f13138 = r9;
        AnonymousClass3 r6 = new View.OnClickListener() { // from class: o.ǀ.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!C0362.this.f13132.m14060() && C0362.this.f13135 != null) {
                    if (view == C0362.this || view == C0362.this.f13121) {
                        C0362.this.m14022(true);
                    } else if (view == C0362.this.f13137) {
                        C0362.this.f13138.mo1703(C0362.this.f13135, C0362.this.m14016());
                        C0362.this.f13132.m14053(C0362.this.f13146, new iF() { // from class: o.ǀ.3.4
                            @Override // o.C0362.iF
                            /* renamed from: ˏ */
                            public void mo14034() {
                                C0362.this.m14022(false);
                            }
                        });
                    } else if (view == C0362.this.f13136) {
                        C0362.this.f13138.mo1703(C0362.this.f13135, C0362.this.m14011());
                        C0362.this.f13132.m14053(C0362.this.f13125, new iF() { // from class: o.ǀ.3.2
                            @Override // o.C0362.iF
                            /* renamed from: ˏ */
                            public void mo14034() {
                                C0362.this.m14022(false);
                            }
                        });
                    }
                }
            }
        };
        this.f13136.setOnClickListener(r6);
        this.f13137.setOnClickListener(r6);
        this.f13121.setOnClickListener(r6);
        setOnClickListener(r6);
        this.f13132 = new C0363();
        this.f13132.f13177.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.ǀ.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                r9.mo1704(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f13126.x = getResources().getDimensionPixelSize(C0602.C0603.thumbs_motion_translation_x);
        this.f13126.y = getResources().getDimensionPixelSize(C0602.C0603.thumbs_motion_translation_y);
        this.f13133.x = getResources().getDimensionPixelSize(C0602.C0603.thumbs_motion_translation_x);
        this.f13133.y = getResources().getDimensionPixelSize(C0602.C0603.thumbs_motion_translation_y);
        ViewCompat.setElevation(this, (float) getResources().getDimensionPixelSize(C0602.C0603.thumbs_elevation));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private int m14016() {
        return this.f13122 ? 2 : 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private int m14011() {
        return this.f13122 ? 1 : 2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Cif m14026(int i) {
        return i == 2 ? new Cif(C0602.C0604.ic_thumbs_up_outline, C0602.C0604.ic_thumbs_up, true) : new Cif(C0602.C0604.ic_thumbs_down_outline, C0602.C0604.ic_thumbs_down, true);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChild(this.f13137, i, i2);
        measureChild(this.f13136, i, i2);
        measureChild(this.f13121, i, i2);
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if ((z || this.f13147 || this.f13132.m14059()) && this.f13135 != null && this.f13139 != null) {
            this.f13135.m16405().getLocationInWindow(this.f13143);
            this.f13139.getLocationInWindow(this.f13142);
            int[] iArr = this.f13143;
            iArr[0] = iArr[0] - this.f13142[0];
            int[] iArr2 = this.f13143;
            iArr2[1] = iArr2[1] - this.f13142[1];
            this.f13129.left = this.f13143[0];
            this.f13129.top = this.f13143[1];
            this.f13129.right = this.f13143[0] + this.f13135.m16405().getMeasuredWidth();
            this.f13129.bottom = this.f13143[1] + this.f13135.m16405().getMeasuredHeight();
            int measuredWidth = this.f13121.getMeasuredWidth();
            int measuredWidth2 = this.f13137.getMeasuredWidth();
            m14019(this.f13124, measuredWidth, this.f13129);
            m14019(this.f13128, measuredWidth2, this.f13129);
            m14019(this.f13127, measuredWidth2, this.f13129);
            this.f13121.layout(this.f13124.left, this.f13124.top, this.f13124.right, this.f13124.bottom);
            this.f13136.layout(m14012((float) this.f13128.left, this.f13132.m14045(), (float) (-this.f13126.x)), m14012((float) this.f13128.top, this.f13132.m14045(), (float) (-this.f13126.y)), m14012((float) this.f13128.right, this.f13132.m14045(), (float) (-this.f13126.x)), m14012((float) this.f13128.bottom, this.f13132.m14045(), (float) (-this.f13126.y)));
            this.f13137.layout(m14012((float) this.f13127.left, this.f13132.m14045(), (float) this.f13133.x), m14012((float) this.f13127.top, this.f13132.m14045(), (float) (-this.f13133.y)), m14012((float) this.f13127.right, this.f13132.m14045(), (float) this.f13133.x), m14012((float) this.f13127.bottom, this.f13132.m14045(), (float) (-this.f13133.y)));
            this.f13147 = false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m14019(Rect rect, int i, Rect rect2) {
        rect.left = rect2.centerX() - (i / 2);
        rect.top = rect2.centerY() - (i / 2);
        rect.right = rect.left + i;
        rect.bottom = rect.top + i;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m14012(float f, float f2, float f3) {
        return (int) ((f3 * f2) + f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14031(CoordinatorLayout coordinatorLayout, C1177 r6, int i) {
        if (this.f13139 == null) {
            this.f13135 = r6;
            this.f13135.m16405().setVisibility(4);
            this.f13139 = coordinatorLayout;
            m14008(true);
            this.f13139.addView(this, new CoordinatorLayout.LayoutParams(-1, -1));
            this.f13147 = true;
            this.f13125.m14040(this.f13122);
            this.f13146.m14040(!this.f13122);
            this.f13125.m14037(false);
            this.f13146.m14037(false);
            ViewCompat.setElevation(this.f13136, 0.0f);
            ViewCompat.setElevation(this.f13137, 0.0f);
            m14007();
            this.f13132.m14048(i);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14007() {
        this.f13126.x = Math.abs(this.f13133.x);
        this.f13126.y = Math.abs(this.f13133.y);
        this.f13133.x = Math.abs(this.f13133.x);
        this.f13133.y = Math.abs(this.f13133.y);
        if (this.f13135 != null && this.f13139 != null) {
            this.f13135.getLocationInWindow(this.f13143);
            this.f13139.getLocationInWindow(this.f13142);
            int[] iArr = this.f13143;
            iArr[0] = iArr[0] - this.f13142[0];
            int[] iArr2 = this.f13143;
            iArr2[1] = iArr2[1] - this.f13142[1];
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0602.C0603.thumbs_overlay_button_size);
            int i = dimensionPixelSize / 2;
            int i2 = (this.f13143[0] - this.f13126.x) - i;
            int i3 = this.f13143[0] + this.f13133.x + i + dimensionPixelSize;
            if (i2 < 0) {
                this.f13126.x *= -1;
                this.f13126.y *= -1;
                if (m14011() == 2) {
                    m14028(this.f13126, this.f13133);
                }
            } else if (i3 > this.f13139.getMeasuredWidth()) {
                this.f13133.x *= -1;
                this.f13133.y *= -1;
                if (m14016() == 2) {
                    m14028(this.f13126, this.f13133);
                }
            } else if ((this.f13143[1] - this.f13133.y) - i < 0) {
                this.f13133.y *= -1;
                this.f13126.y *= -1;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m14028(Point point, Point point2) {
        point.y ^= point2.y;
        point2.y = point.y ^ point2.y;
        point.y ^= point2.y;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14008(boolean z) {
        if (this.f13139 != null) {
            int childCount = this.f13139.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.f13139.getChildAt(i);
                if (childAt != this) {
                    if (z) {
                        ViewCompat.setImportantForAccessibility(childAt, 4);
                    } else {
                        ViewCompat.setImportantForAccessibility(childAt, 1);
                    }
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m14018(Context context, CharSequence charSequence) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) != null && enabledAccessibilityServiceList.size() > 0) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
            obtain.getText().add(charSequence);
            obtain.setEnabled(true);
            obtain.setPackageName(context.getPackageName());
            accessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m14022(boolean z) {
        if (this.f13139 != null) {
            if (z) {
                m14018(getContext(), this.f13130);
            } else {
                m14018(getContext(), this.f13140);
            }
            m14008(false);
            this.f13132.m14061(new iF() { // from class: o.ǀ.2
                @Override // o.C0362.iF
                /* renamed from: ˏ  reason: contains not printable characters */
                public void mo14034() {
                    if (C0362.this.f13135 != null) {
                        C0362.this.f13135.m16405().setVisibility(0);
                    }
                    if (C0362.this.f13139 != null) {
                        C0362.this.f13139.removeView(C0362.this);
                        C0362.this.f13139 = null;
                    }
                    C0362.this.f13135 = null;
                }
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m14032() {
        return this.f13139 != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14033(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            if (this.f13132.m14045() >= 0.8f && !m14009(this.f13136, motionEvent) && !m14009(this.f13137, motionEvent)) {
                this.f13145 = null;
            }
        } else if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
        } else {
            if (this.f13145 == null || motionEvent.getAction() != 1) {
                m14022(true);
                return;
            }
            this.f13145.performClick();
            this.f13145 = null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m14009(ImageView imageView, MotionEvent motionEvent) {
        imageView.getLocationInWindow(this.f13134);
        this.f13131.left = this.f13134[0];
        this.f13131.top = this.f13134[1];
        this.f13131.right = this.f13131.left + imageView.getMeasuredWidth();
        this.f13131.bottom = this.f13131.top + imageView.getMeasuredHeight();
        if (motionEvent.getRawX() < ((float) this.f13131.left) || motionEvent.getRawX() > ((float) this.f13131.right) || motionEvent.getRawY() < ((float) this.f13131.top) || motionEvent.getRawY() > ((float) this.f13131.bottom)) {
            return false;
        }
        if (this.f13145 == null) {
            imageView.performHapticFeedback(1);
            this.f13145 = imageView;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ǀ$ˋ  reason: contains not printable characters */
    public class C0363 {

        /* renamed from: ʻ  reason: contains not printable characters */
        private final ValueAnimator f13166;

        /* renamed from: ʼ  reason: contains not printable characters */
        private final ValueAnimator f13167;

        /* renamed from: ʽ  reason: contains not printable characters */
        private iF f13168;

        /* renamed from: ˊ  reason: contains not printable characters */
        private final ValueAnimator f13169;

        /* renamed from: ˊॱ  reason: contains not printable characters */
        private final ValueAnimator.AnimatorUpdateListener f13170;

        /* renamed from: ˋॱ  reason: contains not printable characters */
        private long f13172;

        /* renamed from: ˎ  reason: contains not printable characters */
        private Cif f13173;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final ValueAnimator f13174;

        /* renamed from: ˏॱ  reason: contains not printable characters */
        private boolean f13175;

        /* renamed from: ͺ  reason: contains not printable characters */
        private long f13176;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final ValueAnimator f13177;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private long f13178;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private iF f13179;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final ValueAnimator f13180;

        private C0363() {
            this.f13174 = new ValueAnimator();
            this.f13177 = new ValueAnimator();
            this.f13169 = new ValueAnimator();
            this.f13166 = new ValueAnimator();
            this.f13167 = new ValueAnimator();
            this.f13180 = new ValueAnimator();
            this.f13170 = new ValueAnimator.AnimatorUpdateListener() { // from class: o.ǀ.ˋ.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    int r3 = m14062(floatValue);
                    if (valueAnimator == C0363.this.f13167 || valueAnimator == C0363.this.f13180) {
                        C0363.this.f13173.m14039(r3);
                    } else if (valueAnimator == C0363.this.f13169) {
                        C0362.this.f13125.setAlpha(r3);
                        C0362.this.f13146.setAlpha(r3);
                    } else if (valueAnimator == C0363.this.f13166) {
                        C0362.this.f13123.setAlpha(r3);
                    } else if (valueAnimator == C0363.this.f13174) {
                        C0362.this.f13141.setAlpha(r3);
                        float f = 0.68f + (0.32f * floatValue);
                        C0362.this.f13125.m14041(f);
                        C0362.this.f13146.m14041(f);
                        C0362.this.f13121.setScaleX(f);
                        C0362.this.f13121.setScaleY(f);
                        C0362.this.requestLayout();
                    }
                }

                /* renamed from: ˊ  reason: contains not printable characters */
                private int m14062(float f) {
                    return Math.max(0, Math.min((int) (255.0f * f), 255));
                }
            };
            this.f13166.addUpdateListener(this.f13170);
            this.f13169.addUpdateListener(this.f13170);
            this.f13167.addUpdateListener(this.f13170);
            this.f13167.setFloatValues(0.0f, 0.5f);
            this.f13167.addListener(new AnimatorListenerAdapter(C0362.this) { // from class: o.ǀ.ˋ.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C0363.this.f13180.start();
                    if (C0362.this.f13135 != null) {
                        C0363.this.f13173.m14040(false);
                        if (C0363.this.f13173 == C0362.this.f13125) {
                            C0362.this.f13146.m14040(true);
                            C0362.this.f13125.m14037(!C0362.this.f13125.m14036());
                            C0362.this.f13135.setRating(C0362.this.f13125.m14036() ? C0362.this.m14011() : 0);
                            ViewCompat.setElevation(C0362.this.f13136, 1.0f);
                            ViewCompat.setElevation(C0362.this.f13137, 0.0f);
                            return;
                        }
                        C0362.this.f13125.m14040(true);
                        C0362.this.f13146.m14037(!C0362.this.f13146.m14036());
                        C0362.this.f13135.setRating(C0362.this.f13146.m14036() ? C0362.this.m14016() : 0);
                        ViewCompat.setElevation(C0362.this.f13136, 0.0f);
                        ViewCompat.setElevation(C0362.this.f13137, 1.0f);
                    }
                }
            });
            this.f13180.addUpdateListener(this.f13170);
            this.f13180.setFloatValues(0.5f, 0.0f);
            this.f13180.addListener(new AnimatorListenerAdapter(C0362.this) { // from class: o.ǀ.ˋ.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (C0363.this.f13179 != null) {
                        C0363.this.f13179.mo14034();
                    }
                }
            });
            this.f13174.setInterpolator(C0362.f13120);
            this.f13174.addUpdateListener(this.f13170);
            this.f13174.addListener(new AnimatorListenerAdapter(C0362.this) { // from class: o.ǀ.ˋ.4

                /* renamed from: ॱ  reason: contains not printable characters */
                private C1177 f13187 = null;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    this.f13187 = C0362.this.f13135;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.f13187 != null && C1021.m15987(((Float) C0363.this.f13169.getAnimatedValue()).floatValue(), 0.0f)) {
                        if (C0363.this.f13168 != null) {
                            C0363.this.f13168.mo14034();
                        }
                        C0362.this.f13138.mo1702(this.f13187);
                    }
                }
            });
            this.f13166.setFloatValues(0.0f);
            this.f13169.setFloatValues(0.0f);
            this.f13174.setFloatValues(0.0f);
            this.f13177.setFloatValues(0.0f);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private void m14048(int i) {
            this.f13168 = null;
            this.f13179 = null;
            this.f13178 = ((long) i) * 250;
            this.f13176 = ((long) i) * 150;
            this.f13172 = ((long) i) * 300;
            this.f13167.setDuration(((long) i) * 50);
            this.f13180.setDuration(((long) i) * 250);
            this.f13177.setDuration(this.f13178);
            this.f13166.setDuration(this.f13176);
            this.f13169.setDuration(this.f13172);
            this.f13174.setDuration(this.f13172);
            C0362.this.f13141.setAlpha(0);
            C0362.this.f13123.setAlpha(0);
            C0362.this.f13125.setAlpha(0);
            C0362.this.f13146.setAlpha(0);
            this.f13177.setStartDelay(0);
            this.f13166.setStartDelay(this.f13172 - this.f13176);
            m14047(1.0f, this.f13177, this.f13166, this.f13169, this.f13174);
            this.f13175 = false;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m14047(float f, ValueAnimator... valueAnimatorArr) {
            m14055(valueAnimatorArr);
            for (ValueAnimator valueAnimator : valueAnimatorArr) {
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), f);
                valueAnimator.start();
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m14055(ValueAnimator... valueAnimatorArr) {
            for (ValueAnimator valueAnimator : valueAnimatorArr) {
                if (valueAnimator.isRunning()) {
                    valueAnimator.cancel();
                }
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m14061(iF iFVar) {
            this.f13177.setStartDelay(this.f13172 - (this.f13178 * 2));
            this.f13166.setStartDelay(0);
            m14047(0.0f, this.f13177, this.f13166, this.f13169, this.f13174);
            this.f13168 = iFVar;
            this.f13175 = true;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private void m14053(Cif ifVar, iF iFVar) {
            this.f13173 = ifVar;
            if (this.f13167.isRunning()) {
                this.f13167.cancel();
            } else if (this.f13180.isRunning()) {
                this.f13180.cancel();
            }
            m14055(this.f13177, this.f13166, this.f13169, this.f13174);
            this.f13173.setAlpha(255);
            this.f13179 = iFVar;
            this.f13167.start();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private float m14045() {
            return ((Float) this.f13174.getAnimatedValue()).floatValue();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean m14059() {
            return this.f13174.isRunning();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m14060() {
            return this.f13175 && this.f13174.isRunning();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ǀ$if  reason: invalid class name */
    public class Cif extends Drawable {

        /* renamed from: ʻ  reason: contains not printable characters */
        private final Paint f13155;

        /* renamed from: ʼ  reason: contains not printable characters */
        private boolean f13156;

        /* renamed from: ʽ  reason: contains not printable characters */
        private final Paint f13157;

        /* renamed from: ˊ  reason: contains not printable characters */
        private Drawable f13158;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final Drawable f13160;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f13161;

        /* renamed from: ͺ  reason: contains not printable characters */
        private boolean f13162;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Drawable f13163;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private final Paint f13164;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private float f13165;

        private Cif(int i, int i2, boolean z) {
            this.f13155 = new Paint();
            this.f13157 = new Paint();
            this.f13164 = new Paint();
            this.f13165 = 1.0f;
            this.f13156 = true;
            this.f13162 = false;
            this.f13160 = DrawableCompat.wrap(ContextCompat.getDrawable(C0362.this.getContext(), i).mutate());
            DrawableCompat.setTint(this.f13160, ContextCompat.getColor(C0362.this.getContext(), C0362.this.f13144 ? C0602.Cif.thumb_button_dark_foreground : C0602.Cif.thumb_button_light_foreground));
            this.f13163 = DrawableCompat.wrap(ContextCompat.getDrawable(C0362.this.getContext(), i2).mutate());
            DrawableCompat.setTint(this.f13163, ContextCompat.getColor(C0362.this.getContext(), C0362.this.f13144 ? C0602.Cif.thumb_button_dark_foreground : C0602.Cif.thumb_button_light_foreground));
            this.f13161 = C0362.this.getResources().getDimensionPixelOffset(z ? C0602.C0603.thumbs_size : C0602.C0603.thumbs_close_size);
            m14035(z);
            m14037(false);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m14035(boolean z) {
            if (C0362.this.f13144) {
                this.f13157.setColor(ContextCompat.getColor(C0362.this.getContext(), C0602.Cif.thumb_button_dark_foreground));
                this.f13155.setColor(ContextCompat.getColor(C0362.this.getContext(), z ? C0602.Cif.thumb_button_dark_background : C0602.Cif.thumb_button_dark_close_background));
                this.f13164.setColor(ContextCompat.getColor(C0362.this.getContext(), z ? C0602.Cif.thumb_button_dark_stroke : C0602.Cif.thumb_button_dark_close_stroke));
            } else {
                this.f13157.setColor(ContextCompat.getColor(C0362.this.getContext(), C0602.Cif.thumb_button_light_foreground));
                this.f13155.setColor(ContextCompat.getColor(C0362.this.getContext(), z ? C0602.Cif.thumb_button_light_background : C0602.Cif.thumb_button_light_close_background));
                this.f13164.setColor(ContextCompat.getColor(C0362.this.getContext(), z ? C0602.Cif.thumb_button_light_stroke : C0602.Cif.thumb_button_light_close_stroke));
            }
            this.f13155.setAntiAlias(true);
            this.f13155.setStyle(Paint.Style.FILL);
            this.f13157.setAntiAlias(true);
            this.f13157.setStyle(Paint.Style.FILL);
            this.f13157.setAlpha(0);
            this.f13164.setAntiAlias(true);
            this.f13164.setStyle(Paint.Style.STROKE);
            this.f13164.setStrokeWidth((float) C0362.this.getResources().getDimensionPixelOffset(C0602.C0603.thumb_button_stroke_width));
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m14037(boolean z) {
            if (this.f13158 == null || this.f13162 != z) {
                this.f13162 = z;
                this.f13158 = m14038();
                int i = (int) (((float) this.f13161) / 0.68f);
                this.f13158.setBounds(0, 0, i, i);
                invalidateSelf();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public void m14040(boolean z) {
            this.f13156 = z;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m14036() {
            return this.f13162;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public Drawable m14038() {
            return this.f13162 ? this.f13163 : this.f13160;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            float width = (float) (getBounds().width() / 2);
            float strokeWidth = (width - this.f13164.getStrokeWidth()) * this.f13165;
            canvas.drawCircle(width, width, strokeWidth, this.f13155);
            if (this.f13157.getAlpha() > 0) {
                canvas.drawCircle(width, width, strokeWidth, this.f13157);
            }
            canvas.drawCircle(width, width, strokeWidth, this.f13164);
            canvas.save();
            float r4 = this.f13165 - (C0362.this.f13132.m14045() * 0.15f);
            float width2 = width - ((((float) this.f13158.getBounds().width()) * r4) / 2.0f);
            canvas.translate(width2, width2);
            canvas.scale(r4, r4);
            this.f13158.draw(canvas);
            canvas.restore();
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.f13155.setAlpha(i);
            this.f13164.setAlpha(i);
            if (this.f13156) {
                this.f13158.setAlpha(i);
            } else {
                this.f13158.setAlpha(255);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m14041(float f) {
            this.f13165 = f;
            invalidateSelf();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public void m14039(int i) {
            this.f13157.setAlpha(i);
            invalidateSelf();
        }
    }
}

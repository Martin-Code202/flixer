package o;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import com.netflix.mediaclient.util.l10n.BidiMarker;
import o.C0602;
/* renamed from: o.ﭙ  reason: contains not printable characters */
public class C1118 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Interpolator f15334 = PathInterpolatorCompat.create(0.6f, -0.28f, 0.735f, 0.045f);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Interpolator f15335 = PathInterpolatorCompat.create(0.175f, 0.885f, 0.32f, 1.275f);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f15336;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f15337;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Spannable f15338;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f15339;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ViewGroup f15340;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private String f15341;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final TextView f15342;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean f15343;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Cif f15344 = new Cif();

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f15345;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Spannable f15346;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int f15347;

    public C1118(TextView textView, int i, int i2, int i3) {
        this.f15342 = textView;
        this.f15340 = (ViewGroup) this.f15342.getParent();
        this.f15343 = BX.m3957();
        this.f15338 = m16256(this.f15342, C0602.C0604.ic_thumbs_up, this.f15343, i3);
        this.f15346 = m16256(this.f15342, C0602.C0604.ic_thumbs_down, this.f15343, i3);
        this.f15336 = i;
        this.f15337 = i2;
        this.f15347 = (int) this.f15342.getTextSize();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private Resources m16255() {
        return this.f15342.getResources();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16262(int i, int i2, boolean z, boolean z2) {
        int paddingEnd = this.f15342.getPaddingEnd() + this.f15342.getPaddingStart();
        int paddingTop = this.f15342.getPaddingTop() + this.f15342.getPaddingBottom();
        if (z) {
            this.f15341 = m16255().getString(this.f15337);
        } else if (i2 == 0) {
            this.f15341 = null;
        } else {
            this.f15341 = m16255().getString(this.f15336, Integer.valueOf(i2));
        }
        m16258(paddingEnd, paddingTop, i);
        int i3 = 0;
        CharSequence charSequence = null;
        switch (i) {
            case 0:
                charSequence = this.f15341;
                if (this.f15341 != null) {
                    i3 = 0;
                    break;
                } else {
                    i3 = this.f15347 + C1004.m15957(this.f15342);
                    break;
                }
            case 1:
                charSequence = this.f15346;
                i3 = this.f15339 - this.f15347;
                break;
            case 2:
                charSequence = this.f15338;
                i3 = this.f15339 - this.f15347;
                break;
        }
        m16261(i, charSequence, i3, z2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private int m16254() {
        return this.f15343 ? 1 : -1;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16261(int i, CharSequence charSequence, int i2, boolean z) {
        if (!z) {
            this.f15342.setText(charSequence);
            this.f15340.setTranslationX((float) (m16254() * i2));
            return;
        }
        this.f15344.m16266(i, charSequence, i2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Spannable m16256(TextView textView, int i, boolean z, int i2) {
        Drawable mutate = ContextCompat.getDrawable(textView.getContext(), i).mutate();
        DrawableCompat.setTint(mutate, i2);
        if (z) {
            ImageSpan imageSpan = new ImageSpan(mutate, 1);
            imageSpan.getDrawable().setBounds(0, 0, (int) textView.getTextSize(), (int) textView.getTextSize());
            SpannableString spannableString = new SpannableString(BX.m3956("X", BidiMarker.FORCED_RTL));
            spannableString.setSpan(imageSpan, 1, 2, 17);
            return spannableString;
        }
        ImageSpan imageSpan2 = new ImageSpan(mutate, 0);
        imageSpan2.getDrawable().setBounds(0, 0, (int) textView.getTextSize(), (int) textView.getTextSize());
        SpannableString spannableString2 = new SpannableString("X");
        spannableString2.setSpan(imageSpan2, 0, 1, 17);
        return spannableString2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m16258(int i, int i2, int i3) {
        StaticLayout staticLayout;
        float f;
        if (this.f15341 == null || i3 != 0) {
            staticLayout = new StaticLayout(" ", this.f15342.getPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, this.f15342.getLayout() == null ? 1.0f : this.f15342.getLayout().getSpacingMultiplier(), this.f15342.getLayout() == null ? 0.0f : this.f15342.getLayout().getSpacingAdd(), true);
        } else {
            staticLayout = new StaticLayout(this.f15341, this.f15342.getPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, this.f15342.getLayout() == null ? 1.0f : this.f15342.getLayout().getSpacingMultiplier(), this.f15342.getLayout() == null ? 0.0f : this.f15342.getLayout().getSpacingAdd(), true);
        }
        float f2 = (float) this.f15347;
        if (this.f15341 == null) {
            f = 0.0f;
        } else {
            f = this.f15342.getPaint().measureText(this.f15341, 0, this.f15341.length());
        }
        this.f15339 = (int) Math.max(f2, f);
        this.f15345 = staticLayout.getHeight() + i2;
        this.f15342.getLayoutParams().width = this.f15339 + i;
        this.f15342.getLayoutParams().height = this.f15345;
        this.f15342.requestLayout();
        this.f15340.getLayoutParams().height = this.f15345;
        this.f15340.requestLayout();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ﭙ$if  reason: invalid class name */
    public class Cif implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: ʼ  reason: contains not printable characters */
        private CharSequence f15348;

        /* renamed from: ʽ  reason: contains not printable characters */
        private int f15349;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final ValueAnimator f15351;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final ValueAnimator f15352;

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f15353;

        /* renamed from: ॱ  reason: contains not printable characters */
        private float f15354;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private int f15355;

        private Cif() {
            this.f15353 = 0;
            this.f15352 = new ValueAnimator();
            this.f15351 = new ValueAnimator();
            this.f15352.setDuration(300L);
            this.f15352.addUpdateListener(this);
            this.f15351.addUpdateListener(this);
            this.f15352.addListener(this);
            this.f15351.addListener(this);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m16266(int i, CharSequence charSequence, int i2) {
            this.f15355 = i;
            this.f15348 = charSequence;
            this.f15349 = i2;
            this.f15354 = C1118.this.f15340.getTranslationX();
            m16265(this.f15352);
            m16265(this.f15351);
            if (this.f15355 == 0) {
                this.f15352.setInterpolator(C1118.f15335);
            } else {
                this.f15352.setInterpolator(C1118.f15334);
            }
            this.f15354 = C1118.this.f15340.getTranslationX();
            if (!TextUtils.isEmpty(C1118.this.f15342.getText()) || this.f15355 == 0) {
                m16264(1, this.f15352, 1.0f, 0.0f);
                return;
            }
            C1118.this.f15342.setText(this.f15348);
            m16264(2, this.f15351, 0.0f, 1.0f);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m16264(int i, ValueAnimator valueAnimator, float... fArr) {
            valueAnimator.setFloatValues(fArr);
            this.f15353 = i;
            valueAnimator.start();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m16265(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            switch (this.f15353) {
                case 0:
                default:
                    return;
                case 1:
                    C1118.this.f15342.setText(this.f15348);
                    if (!m16263()) {
                        this.f15351.setDuration(150L);
                    } else if (!TextUtils.isEmpty(this.f15348)) {
                        this.f15351.setDuration(100L);
                    } else {
                        this.f15353 = 0;
                        return;
                    }
                    this.f15354 = C1118.this.f15340.getTranslationX();
                    m16264(2, this.f15351, 0.0f, 1.0f);
                    return;
                case 2:
                    this.f15353 = 0;
                    C1118.this.f15340.setTranslationX((float) (this.f15349 * C1118.this.m16254()));
                    return;
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean m16263() {
            return this.f15355 == 0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = 1.0f - floatValue;
            C1118.this.f15342.setAlpha(floatValue);
            if (this.f15353 == 1) {
                C1118.this.f15340.setTranslationX((this.f15354 * floatValue) + (((float) (C1118.this.f15342.getMeasuredWidth() + C1004.m15957(C1118.this.f15342))) * f * ((float) C1118.this.m16254())));
            } else if (this.f15353 == 2) {
                C1118.this.f15340.setTranslationX((this.f15354 * f) + (((float) this.f15349) * floatValue * ((float) C1118.this.m16254())));
            }
        }
    }
}

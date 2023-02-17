package o;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import o.C0602;
/* renamed from: o.र  reason: contains not printable characters */
public class C0647 extends FrameLayout {

    /* renamed from: ʼ  reason: contains not printable characters */
    private static final Interpolator f13975 = PathInterpolatorCompat.create(0.755f, 0.05f, 0.855f, 0.06f);

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final Interpolator f13976 = PathInterpolatorCompat.create(0.23f, 1.0f, 0.32f, 1.0f);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final ValueAnimator f13977;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f13978;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final ValueAnimator f13979;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f13980;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0643 f13981;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final TextView f13982;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f13983;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final ValueAnimator f13984;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f13985;

    public C0647(Context context) {
        this(context, null, 0);
    }

    public C0647(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0647(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13985 = false;
        this.f13984 = new ValueAnimator();
        this.f13977 = new ValueAnimator();
        this.f13979 = new ValueAnimator();
        inflate(context, C0602.C0606.netflix_animated_button, this);
        this.f13982 = (TextView) findViewById(C0602.IF.nab_text);
        this.f13981 = new C0643(getContext(), attributeSet);
        setBackground(new C0667(this.f13981));
        this.f13982.setTextColor(this.f13981.f13966);
        this.f13982.setText(this.f13981.f13964);
        this.f13978 = this.f13981.f13969;
        this.f13980 = (this.f13978 / 2) * -1;
        this.f13983 = getPaddingStart() + getPaddingEnd();
        setAlpha(0.0f);
    }

    public void setText(int i) {
        this.f13982.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f13982.setText(charSequence);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14789(int i, int i2, int i3, int i4, Interpolator interpolator) {
        if (this.f13984.isRunning()) {
            this.f13984.cancel();
        }
        this.f13984.setIntValues(i, i2);
        this.f13984.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.र.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                C0647.this.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                C0647.this.requestLayout();
            }
        });
        this.f13984.setDuration((long) i3);
        this.f13984.setInterpolator(interpolator);
        this.f13984.setStartDelay((long) i4);
        this.f13984.start();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m14790(int i, int i2, int i3, int i4, Interpolator interpolator) {
        if (this.f13977 != null && this.f13977.isRunning()) {
            this.f13977.cancel();
        }
        this.f13977.setIntValues(i, i2);
        this.f13977.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.र.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                C0647.this.f13982.setTranslationX((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.f13977.setDuration((long) i3);
        this.f13977.setInterpolator(interpolator);
        this.f13977.setStartDelay((long) i4);
        this.f13977.start();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14788(float f, float f2, int i, int i2) {
        if (this.f13979 != null && this.f13979.isRunning()) {
            this.f13979.cancel();
        }
        this.f13979.setFloatValues(f, f2);
        this.f13979.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.र.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C0647.this.f13982.setAlpha(floatValue);
                C0647.this.setAlpha(floatValue);
                if (floatValue == 0.0f) {
                    C0647.this.setVisibility(8);
                } else if (C0647.this.getVisibility() == 8) {
                    C0647.this.setVisibility(0);
                }
            }
        });
        this.f13979.setDuration((long) i);
        this.f13979.setStartDelay((long) i2);
        this.f13979.start();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m14791(ValueAnimator... valueAnimatorArr) {
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            if (valueAnimator.isRunning()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ˏ */
    public void mo12393(boolean z) {
        if (!this.f13985 && !m14791(this.f13979, this.f13984, this.f13977)) {
            this.f13985 = true;
            int measureText = (int) this.f13982.getPaint().measureText(this.f13982.getText(), 0, this.f13982.getText().length());
            int i = (int) (((double) ((this.f13983 * 2) + measureText)) * 0.2d);
            int i2 = measureText + (this.f13983 * 2);
            int i3 = (i2 / 2) * -1;
            getLayoutParams().width = this.f13978;
            setPadding(0, 0, 0, 0);
            this.f13982.getLayoutParams().width = measureText;
            this.f13982.setTranslationX((float) this.f13980);
            requestLayout();
            setAlpha(0.0f);
            this.f13982.setAlpha(0.0f);
            if (!z) {
                m14789(i, i2, 0, 0, f13976);
                m14790(this.f13980, 0, 0, 0, f13976);
                m14788(0.0f, 1.0f, 0, 0);
                return;
            }
            m14789(i, i2, 800, 100, f13976);
            m14790(i3, 0, 800, 100, f13976);
            m14788(0.0f, 1.0f, 200, 100);
        }
    }

    /* renamed from: ˋ */
    public void mo12391(boolean z) {
        if (this.f13985) {
            this.f13985 = false;
            int measureText = (int) this.f13982.getPaint().measureText(this.f13982.getText(), 0, this.f13982.getText().length());
            int i = (int) (((double) ((this.f13983 * 2) + measureText)) * 0.2d);
            int i2 = ((measureText + (this.f13983 * 2)) / 2) * -1;
            if (!z) {
                m14789(getMeasuredWidth(), i, 0, 0, f13975);
                m14790(0, i2, 0, 0, f13975);
                m14788(1.0f, 0.0f, 0, 0);
                return;
            }
            m14789(getMeasuredWidth(), i, 500, 100, f13975);
            m14790(0, i2, 500, 100, f13975);
            m14788(1.0f, 0.0f, 250, 350);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m14792() {
        return this.f13985;
    }
}

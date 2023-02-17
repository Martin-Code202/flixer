package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
/* renamed from: o.ᵙ  reason: contains not printable characters */
public class C1024 extends ValueAnimator {

    /* renamed from: ʽ  reason: contains not printable characters */
    private float f15122 = 0.0f;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f15123 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    private float f15124 = 1.0f;

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f15125;

    /* renamed from: ˏ  reason: contains not printable characters */
    private float f15126 = 0.0f;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f15127 = false;

    public C1024() {
        setFloatValues(0.0f, 1.0f);
        addListener(new AnimatorListenerAdapter() { // from class: o.ᵙ.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C1024.this.m16005(C1024.this.f15126, C1024.this.f15124);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                C1024.this.m16005(C1024.this.f15126, C1024.this.f15124);
            }
        });
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o.ᵙ.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!C1024.this.f15127) {
                    C1024.this.f15122 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void start() {
        if (this.f15127) {
            m16003(m16004());
            end();
            return;
        }
        super.start();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15999() {
        this.f15127 = true;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        this.f15125 = j;
        m16005(this.f15126, this.f15124);
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16003(float f) {
        if (this.f15122 != f) {
            m15994(f);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16006() {
        m15994(m16002());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15994(float f) {
        if (f < this.f15126) {
            f = this.f15126;
        } else if (f > this.f15124) {
            f = this.f15124;
        }
        this.f15122 = f;
        if (getDuration() > 0) {
            setCurrentPlayTime((long) (((float) getDuration()) * ((f - this.f15126) / (this.f15124 - this.f15126))));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public float m16002() {
        return this.f15122;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16008(boolean z) {
        this.f15123 = z;
        m16005(this.f15126, this.f15124);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16007(float f) {
        this.f15126 = f;
        m16005(f, this.f15124);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16001(float f) {
        this.f15124 = f;
        m16005(this.f15126, f);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public float m16004() {
        return this.f15124;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m16000() {
        float f = this.f15122;
        start();
        m16003(f);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0013: APUT  (r0v1 float[]), (0 ??[int, short, byte, char]), (r1v1 float) */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16005(float f, float f2) {
        float min = Math.min(f, f2);
        float max = Math.max(f, f2);
        float[] fArr = new float[2];
        fArr[0] = this.f15123 ? max : min;
        fArr[1] = this.f15123 ? min : max;
        setFloatValues(fArr);
        super.setDuration((long) (((float) this.f15125) * (max - min)));
        m16003(m16002());
    }
}

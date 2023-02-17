package o;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
public class qB {

    /* renamed from: ˏ  reason: contains not printable characters */
    private ObjectAnimator f9425;

    public qB(View view, int i, int i2) {
        this.f9425 = ObjectAnimator.ofFloat(view, "translationY", (float) i, (float) i2);
        this.f9425.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f9425.setDuration(300L);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9861(Animator.AnimatorListener animatorListener) {
        this.f9425.addListener(animatorListener);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9860() {
        this.f9425.start();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m9859() {
        return this.f9425.isRunning();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9862() {
        this.f9425.cancel();
    }
}

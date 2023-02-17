package o;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.transition.TransitionValues;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
public class BM extends BY {

    /* renamed from: ʻ  reason: contains not printable characters */
    public static Interpolator f4586 = PathInterpolatorCompat.create(0.23f, 1.0f, 0.32f, 1.0f);

    /* renamed from: ˊ  reason: contains not printable characters */
    public static long f4587 = 50;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static long f4588 = (f4589 + f4587);

    /* renamed from: ˎ  reason: contains not printable characters */
    public static long f4589 = ((f4590 - f4587) / 2);

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long f4590 = 1000;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int f4591 = 50;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static Interpolator f4592 = PathInterpolatorCompat.create(0.755f, 0.05f, 0.855f, 0.06f);

    @Override // o.BY, android.support.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (view == null) {
            return null;
        }
        m3965(view);
        ObjectAnimator r2 = m3878(view, true);
        r2.setAutoCancel(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f);
        ofFloat.setAutoCancel(true);
        view.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(r2).with(ofFloat);
        animatorSet.setTarget(view);
        animatorSet.setDuration(f4589);
        animatorSet.setStartDelay(f4588);
        animatorSet.setInterpolator(f4586);
        return animatorSet;
    }

    @Override // o.BY, android.support.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (view == null) {
            return null;
        }
        m3965(view);
        ObjectAnimator r2 = m3878(view, false);
        r2.setAutoCancel(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, 1.0f, 0.0f);
        ofFloat.setAutoCancel(true);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(r2).with(ofFloat);
        animatorSet.setTarget(view);
        animatorSet.setDuration(f4589);
        animatorSet.setInterpolator(f4592);
        return animatorSet;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private ObjectAnimator m3878(View view, boolean z) {
        float r4 = (float) C1004.m15954(view.getContext(), f4591);
        if (z) {
            return ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, -r4, 0.0f);
        }
        return ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0.0f, -r4);
    }
}

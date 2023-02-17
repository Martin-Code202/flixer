package o;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.support.transition.Visibility;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import java.util.HashSet;
import java.util.Set;
public class BY extends Visibility {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Set<Animator> f4629 = new HashSet();

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f4630 = -1;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Set<Animator> f4631 = new HashSet();

    /* renamed from: ॱ  reason: contains not printable characters */
    private Drawable f4632;

    /* renamed from: ˊ  reason: contains not printable characters */
    public Transition m3962(int i) {
        this.f4630 = i;
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3963(Animator animator) {
        this.f4629.add(animator);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3964(Animator animator) {
        this.f4631.add(animator);
    }

    @Override // android.support.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (view == null) {
            return null;
        }
        m3965(view);
        ObjectAnimator r2 = m3960(viewGroup, view, true);
        r2.setDuration((long) C1317As.m3768(view.getContext(), R.integer.activity_transition_anim_time_ms));
        r2.setTarget(view);
        if (this.f4629.isEmpty()) {
            return r2;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet.Builder play = animatorSet.play(r2);
        for (Animator animator : this.f4629) {
            animator.setDuration(2131492866);
            play.with(animator);
        }
        return animatorSet;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m3965(final View view) {
        if (this.f4630 != -1) {
            addListener(new BB() { // from class: o.BY.4
                @Override // o.BB, android.support.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition) {
                    if (BY.this.f4630 != -1) {
                        BY.this.f4632 = view.getBackground();
                        view.setBackgroundResource(BY.this.f4630);
                    }
                }

                @Override // o.BB, android.support.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition) {
                    view.setBackground(BY.this.f4632);
                    BY.this.f4632 = null;
                }
            });
        }
    }

    @Override // android.support.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (view == null) {
            return null;
        }
        m3965(view);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator r3 = m3960(viewGroup, view, false);
        animatorSet.setDuration((long) C1317As.m3768(view.getContext(), R.integer.activity_transition_anim_time_ms));
        AnimatorSet.Builder play = animatorSet.play(r3);
        if (AD.m3299()) {
            play.with(ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f));
        }
        animatorSet.setTarget(view);
        for (Animator animator : this.f4631) {
            animator.setDuration(2131492866);
            play.with(animator);
        }
        return animatorSet;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005d: APUT  (r1v2 float[]), (1 ??[boolean, int, float, short, byte, char]), (r2v1 float) */
    /* renamed from: ˎ  reason: contains not printable characters */
    private ObjectAnimator m3960(ViewGroup viewGroup, View view, boolean z) {
        float f;
        boolean r4 = AD.m3299();
        if (viewGroup.getX() <= 0.0f || viewGroup.getX() >= ((float) viewGroup.getWidth())) {
            f = z ? r4 ? (float) (viewGroup.getWidth() / 2) : (float) viewGroup.getWidth() : 0.0f;
        } else {
            f = viewGroup.getX();
        }
        if (z) {
            return ObjectAnimator.ofFloat(view, View.TRANSLATION_X, f, 0.0f);
        }
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[2];
        fArr[0] = f;
        fArr[1] = r4 ? (float) (viewGroup.getWidth() / 2) : (float) viewGroup.getWidth();
        return ObjectAnimator.ofFloat(view, property, fArr);
    }
}

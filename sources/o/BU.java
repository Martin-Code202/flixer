package o;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.TargetApi;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
@TargetApi(21)
public class BU extends Visibility {
    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), R.animator.animator_scale_up);
        animatorSet.setDuration((long) C1317As.m3768(view.getContext(), R.integer.activity_transition_anim_time_ms));
        animatorSet.setTarget(view);
        return animatorSet;
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (view == null) {
            return null;
        }
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view.getContext(), R.animator.animator_scale_down);
        animatorSet.setDuration((long) C1317As.m3768(view.getContext(), R.integer.activity_transition_anim_time_ms));
        animatorSet.setTarget(view);
        return animatorSet;
    }
}

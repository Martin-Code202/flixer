package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;
class AnimatorUtilsApi14 implements AnimatorUtilsImpl {

    interface AnimatorPauseListenerCompat {
        @Override // android.animation.Animator.AnimatorPauseListener, android.support.transition.AnimatorUtilsApi14.AnimatorPauseListenerCompat
        void onAnimationPause(Animator animator);

        @Override // android.animation.Animator.AnimatorPauseListener, android.support.transition.AnimatorUtilsApi14.AnimatorPauseListenerCompat
        void onAnimationResume(Animator animator);
    }

    AnimatorUtilsApi14() {
    }

    @Override // android.support.transition.AnimatorUtilsImpl
    public void addPauseListener(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
    }

    @Override // android.support.transition.AnimatorUtilsImpl
    public void pause(Animator animator) {
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof AnimatorPauseListenerCompat) {
                    ((AnimatorPauseListenerCompat) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    @Override // android.support.transition.AnimatorUtilsImpl
    public void resume(Animator animator) {
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof AnimatorPauseListenerCompat) {
                    ((AnimatorPauseListenerCompat) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}

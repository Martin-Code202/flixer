package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.Property;
import android.view.View;
import android.view.animation.Interpolator;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.v2.PlayerAnimationHelper$startViewAppearanceAnimationFromOutsideOfViewport$1;
public final class xA {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final xA f11946 = new xA();

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Interpolator f11947 = PathInterpolatorCompat.create(0.19f, 1.0f, 0.22f, 1.0f);

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final float f11948 = NetflixApplication.getInstance().getResources().getDimension(R.dimen.player_big_buttons_medium_translation);

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Interpolator f11949 = PathInterpolatorCompat.create(0.755f, 0.05f, 0.855f, 0.06f);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Interpolator f11950 = PathInterpolatorCompat.create(0.23f, 1.0f, 0.32f, 1.0f);

    private xA() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.xA */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ void m12737(xA xAVar, View view, boolean z, boolean z2, float f, AbstractC1449Fj fj, int i, Object obj) {
        if ((i & 8) != 0) {
            f = f11948;
        }
        if ((i & 16) != 0) {
            fj = PlayerAnimationHelper$startViewAppearanceAnimationFromOutsideOfViewport$1.f3719;
        }
        xAVar.m12738(view, z, z2, f, fj);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003f: APUT  (r1v1 float[]), (0 ??[int, short, byte, char]), (r2v0 float) */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005e: APUT  (r1v4 float[]), (0 ??[int, short, byte, char]), (r2v1 float) */
    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m12738(View view, boolean z, boolean z2, float f, AbstractC1449Fj<EA> fj) {
        C1457Fr.m5025(view, "view");
        C1457Fr.m5025(fj, "callBack");
        if (C1322Av.m3792()) {
            view.setVisibility(0);
            return;
        }
        float f2 = f > 0.0f ? f : f11948;
        if (z) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
            view.setTranslationY(z2 ? f2 : -f2);
        }
        Property property = View.TRANSLATION_Y;
        float[] fArr = new float[1];
        fArr[0] = z ? 0.0f : z2 ? f2 : -f2;
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, property, fArr).setDuration(300L);
        duration.setInterpolator(f11950);
        Property property2 = View.ALPHA;
        float[] fArr2 = new float[2];
        fArr2[0] = z ? 0.0f : 1.0f;
        fArr2[1] = z ? 1.0f : 0.0f;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, property2, fArr2).setDuration(150L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay((long) (z ? 0 : 100));
        animatorSet.play(duration).with(duration2);
        animatorSet.addListener(new C0259(view, z, fj));
        animatorSet.start();
    }

    /* renamed from: o.xA$ˊ  reason: contains not printable characters */
    public static final class C0259 extends AnimatorListenerAdapter {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ boolean f11951;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ AbstractC1449Fj f11952;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ View f11953;

        C0259(View view, boolean z, AbstractC1449Fj fj) {
            this.f11953 = view;
            this.f11951 = z;
            this.f11952 = fj;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f11953.setVisibility(this.f11951 ? 0 : 8);
            this.f11952.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f11953.setVisibility(this.f11951 ? 0 : 8);
            this.f11952.invoke();
        }
    }
}

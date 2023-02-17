package o;

import android.animation.Animator;
import android.view.ViewGroup;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import java.nio.ByteBuffer;
/* renamed from: o.we  reason: case insensitive filesystem */
public class C2263we extends vZ {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected int f11602;

    /* renamed from: ˋ  reason: contains not printable characters */
    private qB f11603;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private qB f11604;

    C2263we(PlayerFragment playerFragment) {
        super(playerFragment);
        this.f11602 = C1004.m15954(playerFragment.getActivity(), 40);
    }

    @Override // o.vZ
    /* renamed from: ˎ */
    public void mo12114(ByteBuffer byteBuffer) {
        this.f11301.set(byteBuffer != null);
        if (this.f11438 != null && this.f11302 != null) {
            m12113();
            m12423(byteBuffer);
            C1283.m16862("CurrentTimeTablet", "start end");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12423(final ByteBuffer byteBuffer) {
        C1283.m16854("CurrentTimeTablet", "startStartAnimation()");
        if (this.f11603 == null) {
            AnonymousClass3 r4 = new Animator.AnimatorListener() { // from class: o.we.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C1283.m16862("CurrentTimeTablet", "startStartAnimation end");
                    if (C2263we.this.f11301.get()) {
                        C1283.m16865("CurrentTimeTablet", "Bifs are downloaded, setup currentTimeExp layout params");
                        C2263we.this.f11438.mo2226().m12521(byteBuffer);
                        return;
                    }
                    C1283.m16865("CurrentTimeTablet", "Bifs are not downloaded, do not setup currentTimeExp layout params");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    C1283.m16862("CurrentTimeTablet", "startStartAnimation cancel");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            };
            this.f11603 = new qB(this.f11302, 0, -this.f11602);
            this.f11603.m9861(r4);
        }
        this.f11438.mo2226().mo12462(byteBuffer);
        this.f11603.m9860();
    }

    @Override // o.vZ
    /* renamed from: ˋ */
    public void mo12112(boolean z) {
        C1283.m16854("CurrentTimeTablet", "stop");
        if (this.f11438 != null && this.f11302 != null) {
            if (this.f11603 == null || !this.f11603.m9859()) {
                if (z) {
                    m12113();
                }
                m12422(z);
            } else {
                C1283.m16854("CurrentTimeTablet", "Start animation is not completed yet - cancelling it");
                this.f11603.m9862();
                this.f11438.mo2226().mo12451();
                this.f11302.setTranslationY(0.0f);
            }
            C1283.m16862("CurrentTimeTablet", "stop end");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12422(final boolean z) {
        C1283.m16854("CurrentTimeTablet", "startStopAnimation()");
        if (this.f11604 == null) {
            AnonymousClass4 r4 = new Animator.AnimatorListener() { // from class: o.we.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C1283.m16862("CurrentTimeTablet", "startStopAnimation end");
                    C2263we.this.m12111();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    C1283.m16854("CurrentTimeTablet", "startStopAnimation was canceled");
                    C2263we.this.f11438.mo2234().m12297(false);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            };
            this.f11604 = new qB(this.f11302, -this.f11602, 0);
            this.f11604.m9861(r4);
        }
        this.f11604.m9860();
        this.f11438.mo2226().mo12451();
    }

    @Override // o.vZ
    /* renamed from: ॱ */
    public void mo12116() {
        C1283.m16862("CurrentTimeTablet", "doUpdateTimeMargins");
        if (this.f11438.m14535() && this.f11302 != null && (this.f11302.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11302.getLayoutParams();
            marginLayoutParams.setMargins(this.f11438.mo2226().m12501(this.f11302), 0, 0, marginLayoutParams.bottomMargin);
            this.f11302.setLayoutParams(marginLayoutParams);
        }
    }
}

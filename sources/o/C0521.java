package o;

import android.animation.Animator;
import android.view.View;
/* renamed from: o.ү  reason: contains not printable characters */
public class C0521 extends AbstractC0774 {
    public C0521(View view) {
        super(view);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0774
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo14539(View view) {
        view.setAlpha(0.7f);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0774
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo14538(View view) {
        BQ.m3912(view, new AbstractC1335Bh() { // from class: o.ү.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C0521.this.m15232();
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0774
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo14540(View view) {
        view.setAlpha(1.0f);
    }
}

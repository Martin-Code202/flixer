package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayItem;
public abstract class wR extends LinearLayout {
    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public abstract void mo12338();

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract void mo12339();

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract void mo12340(int i);

    /* renamed from: ˏ */
    public abstract void mo12341(PostPlayItem postPlayItem, NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PlayLocationType playLocationType, View.OnClickListener onClickListener);

    public wR(Context context) {
        this(context, null);
    }

    public wR(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public wR(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m12349(int i) {
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(300).start();
        mo12340(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m12350() {
        animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: o.wR.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!C1317As.m3750(wR.this.getContext())) {
                    wR.this.mo12338();
                }
            }
        }).setDuration(300).start();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        mo12339();
    }

    /* renamed from: ˎ */
    public void mo12347(int i) {
    }
}

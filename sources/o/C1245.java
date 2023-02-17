package o;

import android.animation.Animator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.model.leafs.advisory.Advisory;
@Deprecated
/* renamed from: o.ｫ  reason: contains not printable characters */
public class C1245 extends AbstractC1180 {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final int f15786;

    /* renamed from: ʿ  reason: contains not printable characters */
    private Animator.AnimatorListener f15787 = new AbstractC1335Bh() { // from class: o.ｫ.1
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1245.this.m16611();
            C1245.this.m16609();
            C1245.super.mo16431();
        }
    };

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private Interpolator f15788 = new DecelerateInterpolator();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final View f15789;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final View f15790;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Interpolator f15791 = new AccelerateInterpolator();

    public C1245(NetflixActivity netflixActivity, Advisory advisory) {
        super(netflixActivity, advisory);
        View r2 = m16429();
        this.f15790 = r2.findViewById(R.id.view_netflix_bar);
        this.f15789 = r2.findViewById(R.id.content_advisory);
        this.f15786 = r2.getResources().getDimensionPixelSize(R.dimen.content_advisory_translation_y);
        this.f15789.setVisibility(0);
    }

    @Override // o.AbstractC1180
    /* renamed from: ˎ */
    public int mo16424() {
        return R.layout.two_line_advisory_layout;
    }

    @Override // o.AbstractC1180
    /* renamed from: ˏ */
    public int mo16426() {
        return R.id.message;
    }

    @Override // o.AbstractC1180
    /* renamed from: ˋ */
    public int mo16421() {
        return R.id.secondary_message;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1180
    /* renamed from: ˏॱ */
    public void mo16427() {
        super.mo16427();
        if (this.f15789 != null) {
            m16607();
            this.f15789.setAlpha(1.0f);
            this.f15790.setAlpha(1.0f);
            this.f15790.animate().translationYBy((float) (-this.f15790.getMeasuredHeight())).setInterpolator(this.f15788).setDuration(660);
            this.f15509.animate().alpha(1.0f).translationYBy((float) (-this.f15786)).setInterpolator(this.f15788).setDuration(833);
            if (this.f15515) {
                this.f15521.animate().alpha(1.0f).translationYBy((float) (-this.f15786)).setInterpolator(this.f15788).setDuration(660).setStartDelay(100);
            }
            this.f15789.animate().translationYBy((float) (-this.f15786)).setInterpolator(this.f15788).setDuration(660).setListener(null);
        }
    }

    @Override // o.AbstractC1180
    /* renamed from: ᐝ */
    public void mo16431() {
        C1283.m16854("AdvisorToast", "dismiss -- two line advisor");
        if (m16428() && this.f15789 != null) {
            this.f15790.animate().translationYBy((float) (-this.f15790.getMeasuredHeight())).setInterpolator(this.f15791).setDuration(400);
            this.f15509.animate().alpha(0.0f).translationYBy((float) (-this.f15786)).setInterpolator(this.f15791).setDuration(500);
            if (this.f15515) {
                this.f15521.animate().alpha(0.0f).translationYBy((float) (-this.f15786)).setInterpolator(this.f15791).setDuration(500);
            }
            this.f15789.animate().translationYBy((float) (-this.f15786)).setInterpolator(this.f15791).setDuration(833).setListener(this.f15787);
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m16607() {
        this.f15790.setTranslationY((float) this.f15790.getMeasuredHeight());
        this.f15509.setTranslationY((float) this.f15786);
        if (this.f15515) {
            this.f15521.setTranslationY((float) this.f15786);
        }
        this.f15789.setTranslationY((float) this.f15786);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m16609() {
        this.f15790.setTranslationY(0.0f);
        this.f15509.setTranslationY(0.0f);
        if (this.f15515) {
            this.f15521.setTranslationY(0.0f);
        }
        this.f15789.setTranslationY(0.0f);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m16611() {
        this.f15790.animate().cancel();
        this.f15509.animate().cancel();
        if (this.f15515) {
            this.f15521.animate().cancel();
        }
        this.f15789.animate().cancel();
    }
}

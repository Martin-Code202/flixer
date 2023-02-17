package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
/* renamed from: o.zf  reason: case insensitive filesystem */
public final class C2372zf extends C0522 {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final iF f12835 = new iF(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Animator.AnimatorListener f12836;

    /* renamed from: ˊ  reason: contains not printable characters */
    private float f12837;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f12838;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f12839;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f12840;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Animator.AnimatorListener f12841;

    public C2372zf(Context context) {
        this(context, null, 0, 6, null);
    }

    public C2372zf(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2372zf(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f12837 = 0.01f;
        this.f12840 = 1200;
        this.f12838 = 600;
        this.f12841 = new C0332(this);
        this.f12836 = new Cif(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2372zf(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.zf$iF */
    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }
    }

    public final void setScaleFactor(float f) {
        this.f12837 = f;
    }

    public final void setPulseInDuration(long j) {
        this.f12840 = j;
    }

    public final void setPulseOutDuration(long j) {
        this.f12838 = j;
    }

    /* renamed from: o.zf$ˊ  reason: contains not printable characters */
    public static final class C0332 extends AnimatorListenerAdapter {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2372zf f12843;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0332(C2372zf zfVar) {
            this.f12843 = zfVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f12843.m13637();
        }
    }

    /* renamed from: o.zf$if  reason: invalid class name */
    public static final class Cif extends AnimatorListenerAdapter {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C2372zf f12842;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        Cif(C2372zf zfVar) {
            this.f12842 = zfVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f12842.m13640();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private final void m13640() {
        animate().scaleXBy(this.f12837).scaleYBy(this.f12837).setDuration(this.f12838).setListener(this.f12841);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private final void m13637() {
        animate().scaleXBy(-this.f12837).scaleYBy(-this.f12837).setDuration(this.f12840).setListener(this.f12836);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final void m13641() {
        if (!this.f12839) {
            this.f12839 = true;
            m13640();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public final void m13642() {
        if (this.f12839) {
            this.f12839 = false;
            clearAnimation();
        }
    }
}

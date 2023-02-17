package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.widget.SeekButton$10;
import com.netflix.mediaclient.android.widget.SeekButton$11;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.C0602;
/* renamed from: o.ᒯ  reason: contains not printable characters */
public final class C0795 extends FrameLayout {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private static final Interpolator f14463 = PathInterpolatorCompat.create(0.19f, 1.0f, 0.22f, 1.0f);

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private static final Interpolator f14464 = PathInterpolatorCompat.create(0.23f, 1.0f, 0.32f, 1.0f);

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0797 f14465 = new C0797(null);

    /* renamed from: ॱ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f14466 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0795.class), "button", "getButton()Landroid/widget/ImageButton;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0795.class), SignupConstants.Field.LABEL, "getLabel()Lcom/netflix/mediaclient/android/widget/NetflixTextView;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(C0795.class), "circle", "getCircle()Landroid/view/View;"))};

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f14467;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final int f14468;

    /* renamed from: ʼ  reason: contains not printable characters */
    private AbstractC2402If f14469;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final FI f14470;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f14471;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final CharSequence f14472;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f14473;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final CharSequence f14474;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final FI f14475;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final CharSequence f14476;

    /* renamed from: ͺ  reason: contains not printable characters */
    private AnimatorSet f14477;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final CharSequence f14478;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final Drawable f14479;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final Drawable f14480;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final float f14481;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final boolean f14482;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final FI f14483;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final CharSequence f14484;

    /* renamed from: o.ᒯ$If  reason: case insensitive filesystem */
    public interface AbstractC2402If {
        /* renamed from: ˋ */
        void mo1851(C0795 v, int i, int i2);

        /* renamed from: ˎ */
        void mo1852(C0795 v, int i, int i2);
    }

    public C0795(Context context) {
        this(context, null, 0, 6, null);
    }

    public C0795(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private final View m15273() {
        return (View) this.f14483.mo4986(this, f14466[2]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private final ImageButton m15275() {
        return (ImageButton) this.f14475.mo4986(this, f14466[0]);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0716 m15278() {
        return (C0716) this.f14470.mo4986(this, f14466[1]);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0795(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f14473 = 1;
        this.f14471 = 1;
        this.f14475 = C1197.m16465(this, C0602.IF.sb_image_button);
        this.f14470 = C1197.m16465(this, C0602.IF.sb_label);
        this.f14483 = C1197.m16465(this, C0602.IF.sb_circle);
        this.f14477 = new AnimatorSet();
        FrameLayout.inflate(context, C0602.C0606.seek_button, this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0602.aux.SeekButton);
        try {
            this.f14468 = obtainStyledAttributes.getInteger(C0602.aux.SeekButton_sb_seconds, 10);
            this.f14484 = "" + this.f14468;
            this.f14476 = C0403.m14185(context, C0602.C0605.seek_button_backward_accessibility).m14186("seconds", Integer.valueOf(this.f14468)).m14188();
            this.f14472 = C0403.m14185(context, C0602.C0605.seek_button_forward_accessibility).m14186("seconds", Integer.valueOf(this.f14468)).m14188();
            this.f14478 = C0403.m14185(context, C0602.C0605.seek_button_backward).m14186("seconds", Integer.valueOf(this.f14468)).m14188();
            this.f14474 = C0403.m14185(context, C0602.C0605.seek_button_forward).m14186("seconds", Integer.valueOf(this.f14468)).m14188();
            this.f14471 = obtainStyledAttributes.getInt(C0602.aux.SeekButton_sb_size, 1);
            switch (this.f14471) {
                case -1:
                    int dimensionPixelSize = getResources().getDimensionPixelSize(C0602.C0603.seek_button_circle_size_small);
                    m15273().getLayoutParams().width = dimensionPixelSize;
                    m15273().getLayoutParams().height = dimensionPixelSize;
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0602.C0603.seek_button_image_size_small);
                    m15275().getLayoutParams().width = dimensionPixelSize2;
                    m15275().getLayoutParams().height = dimensionPixelSize2;
                    int dimensionPixelSize3 = getResources().getDimensionPixelSize(C0602.C0603.seek_button_padding_small);
                    m15275().setPadding(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3);
                    m15278().setTextSize(0, getResources().getDimension(C0602.C0603.seek_button_text_size_small));
                    if (!C1322Av.m3792()) {
                        m15278().setTypeface(ResourcesCompat.getFont(context, C0602.C2400iF.netflix_bold));
                    }
                    C0716 r7 = m15278();
                    r7.setPadding(r7.getPaddingLeft(), getResources().getDimensionPixelSize(C0602.C0603.seek_button_text_padding_small), r7.getPaddingRight(), r7.getPaddingBottom());
                    Drawable drawable = ContextCompat.getDrawable(context, C0602.C0604.seek_button_forward_small);
                    if (drawable != null) {
                        this.f14480 = drawable;
                        Drawable drawable2 = ContextCompat.getDrawable(context, C0602.C0604.seek_button_back_small);
                        if (drawable2 != null) {
                            this.f14479 = drawable2;
                            break;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Drawable");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Drawable");
                    }
                case 1:
                    int dimensionPixelSize4 = getResources().getDimensionPixelSize(C0602.C0603.seek_button_circle_size);
                    m15273().getLayoutParams().width = dimensionPixelSize4;
                    m15273().getLayoutParams().height = dimensionPixelSize4;
                    int dimensionPixelSize5 = getResources().getDimensionPixelSize(C0602.C0603.seek_button_image_size);
                    m15275().getLayoutParams().width = dimensionPixelSize5;
                    m15275().getLayoutParams().height = dimensionPixelSize5;
                    int dimensionPixelSize6 = getResources().getDimensionPixelSize(C0602.C0603.seek_button_padding);
                    m15275().setPadding(dimensionPixelSize6, dimensionPixelSize6, dimensionPixelSize6, dimensionPixelSize6);
                    m15278().setTextSize(0, getResources().getDimension(C0602.C0603.seek_button_text_size));
                    C0716 r72 = m15278();
                    r72.setPadding(r72.getPaddingLeft(), getResources().getDimensionPixelSize(C0602.C0603.seek_button_text_padding), r72.getPaddingRight(), r72.getPaddingBottom());
                    Drawable drawable3 = ContextCompat.getDrawable(context, C0602.C0604.seek_button_forward);
                    if (drawable3 != null) {
                        this.f14480 = drawable3;
                        Drawable drawable4 = ContextCompat.getDrawable(context, C0602.C0604.seek_button_back);
                        if (drawable4 != null) {
                            this.f14479 = drawable4;
                            break;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Drawable");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.Drawable");
                    }
                default:
                    throw new UnsupportedOperationException("should not happen as SeekButton_sb_size is enum");
            }
            this.f14482 = obtainStyledAttributes.getBoolean(C0602.aux.SeekButton_sb_debounce, true);
            this.f14481 = getResources().getDimension(C0602.C0603.seek_button_translation);
            setClipChildren(false);
            if (this.f14482) {
                Observable<R> map = C0965.m15783(m15275()).map(C0972.f14975);
                C1457Fr.m5016((Object) map, "RxView.clicks(this).map(VoidToUnit)");
                Observable<R> observeOn = map.map(new Function<T, R>(this) { // from class: o.ᒯ.2

                    /* renamed from: ˋ  reason: contains not printable characters */
                    final /* synthetic */ C0795 f14485;

                    {
                        this.f14485 = r1;
                    }

                    @Override // io.reactivex.functions.Function
                    public /* synthetic */ Object apply(Object obj) {
                        m15292((EA) obj);
                        return EA.f5503;
                    }

                    /* renamed from: ˋ  reason: contains not printable characters */
                    public final void m15292(EA ea) {
                        C1457Fr.m5025(ea, "it");
                        this.f14485.f14467++;
                        C0797 r4 = C0795.f14465;
                        AbstractC2402If r0 = this.f14485.m15290();
                        if (r0 != null) {
                            r0.mo1851(this.f14485, this.f14485.f14473, this.f14485.f14467);
                        }
                        C0795.m15286(this.f14485, null, 1, null);
                    }
                }).debounce(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
                C1457Fr.m5016((Object) observeOn, "button.clicks()\n        …dSchedulers.mainThread())");
                SubscribersKt.subscribeBy$default(observeOn, null, null, new SeekButton$10(this), 3, null);
            } else {
                Observable<R> map2 = C0965.m15783(m15275()).map(C0972.f14975);
                C1457Fr.m5016((Object) map2, "RxView.clicks(this).map(VoidToUnit)");
                SubscribersKt.subscribeBy$default(map2, null, null, new SeekButton$11(this), 3, null);
            }
            setMode(obtainStyledAttributes.getInt(C0602.aux.SeekButton_sb_mode, 1));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0795(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.ᒯ$ˋ  reason: contains not printable characters */
    public static final class C0797 extends C1277 {
        private C0797() {
            super("SeekButton");
        }

        public /* synthetic */ C0797(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private final Interpolator m15293() {
            return C0795.f14463;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˎ  reason: contains not printable characters */
        private final Interpolator m15295() {
            return C0795.f14464;
        }
    }

    public final void setOnSeekButtonListener(AbstractC2402If r1) {
        this.f14469 = r1;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final AbstractC2402If m15290() {
        return this.f14469;
    }

    @Override // android.view.View
    public boolean performClick() {
        return m15275().performClick();
    }

    public final void setMode(int i) {
        this.f14473 = i;
        switch (this.f14473) {
            case -1:
                m15275().setImageDrawable(this.f14479);
                m15275().setContentDescription(this.f14476);
                m15278().setText(this.f14484);
                return;
            case 1:
                m15275().setImageDrawable(this.f14480);
                m15275().setContentDescription(this.f14472);
                m15278().setText(this.f14484);
                return;
            default:
                C1276.m16820().mo5725("sb_mode attribute value should be forward or backward");
                return;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        m15275().setEnabled(z);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return super.isEnabled() && m15275().isEnabled();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: o.ᒯ */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* bridge */ /* synthetic */ void m15286(C0795 r1, AbstractC1449Fj fj, int i, Object obj) {
        if ((i & 1) != 0) {
            fj = null;
        }
        r1.m15291(fj);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m15291(AbstractC1449Fj<EA> fj) {
        switch (this.f14471) {
            case -1:
                m15277(fj);
                return;
            case 1:
                m15280(fj);
                return;
            default:
                return;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m15277(AbstractC1449Fj<EA> fj) {
        float f = this.f14473 == -1 ? -45.0f : 45.0f;
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(m15275(), PropertyValuesHolder.ofFloat(View.SCALE_X, 0.9f), PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.9f)).setDuration(100L);
        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(m15275(), PropertyValuesHolder.ofFloat(View.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.0f)).setDuration(350L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(m15275(), View.ROTATION, 0.0f, f).setDuration(150L);
        C1457Fr.m5016((Object) duration3, "animatorRotation1");
        duration3.setInterpolator(f14465.m15293());
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(m15275(), View.ROTATION, f, 0.0f).setDuration(750L);
        C1457Fr.m5016((Object) duration4, "animatorRotation2");
        duration4.setInterpolator(f14465.m15293());
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(m15273(), View.ALPHA, 0.0f, 0.7f).setDuration(100L);
        duration5.addListener(new aux(this));
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(m15273(), View.ALPHA, 0.7f, 0.0f).setDuration(350L);
        if (this.f14477.isRunning()) {
            this.f14477.cancel();
        }
        this.f14477 = new AnimatorSet();
        this.f14477.play(duration).with(duration2).before(duration3).before(duration5);
        this.f14477.play(duration4).after(duration3);
        this.f14477.play(duration6).after(duration5);
        this.f14477.addListener(new IF(this, fj));
        this.f14477.start();
    }

    /* renamed from: o.ᒯ$aux */
    public static final class aux extends AnimatorListenerAdapter {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C0795 f14488;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        aux(C0795 r1) {
            this.f14488 = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f14488.m15273().setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f14488.m15273().setVisibility(8);
        }
    }

    /* renamed from: o.ᒯ$IF */
    public static final class IF extends AnimatorListenerAdapter {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ AbstractC1449Fj f14486;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C0795 f14487;

        IF(C0795 r1, AbstractC1449Fj fj) {
            this.f14487 = r1;
            this.f14486 = fj;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f14487.m15289(this.f14487.m15275(), this.f14487.m15278(), this.f14487.m15273());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC1449Fj fj = this.f14486;
            if (fj != null) {
                EA ea = (EA) fj.invoke();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m15280(AbstractC1449Fj<EA> fj) {
        boolean z = this.f14473 == -1;
        float f = this.f14481;
        float f2 = z ? -45.0f : 45.0f;
        float f3 = z ? -f : f;
        CharSequence charSequence = z ? this.f14478 : this.f14474;
        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(m15275(), PropertyValuesHolder.ofFloat(View.SCALE_X, 0.9f), PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.9f)).setDuration(100L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(m15278(), View.ALPHA, 1.0f, 0.0f).setDuration(100L);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(m15275(), PropertyValuesHolder.ofFloat(View.SCALE_X, 1.0f), PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.0f)).setDuration(350L);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(m15275(), View.ROTATION, 0.0f, f2).setDuration(150L);
        C1457Fr.m5016((Object) duration4, "animatorRotation1");
        duration4.setInterpolator(f14465.m15293());
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(m15275(), View.ROTATION, f2, 0.0f).setDuration(750L);
        C1457Fr.m5016((Object) duration5, "animatorRotation2");
        duration5.setInterpolator(f14465.m15293());
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(m15278(), View.TRANSLATION_X, f3).setDuration(750L);
        C1457Fr.m5016((Object) duration6, "animatorTranslateX");
        duration6.setInterpolator(f14465.m15295());
        duration6.addListener(new C2403iF(this, charSequence));
        ObjectAnimator duration7 = ObjectAnimator.ofFloat(m15278(), View.ALPHA, 1.0f, 0.0f).setDuration(150L);
        duration7.addListener(new C0796(this, fj));
        ObjectAnimator duration8 = ObjectAnimator.ofFloat(m15278(), View.ALPHA, 0.0f, 1.0f).setDuration(150L);
        ObjectAnimator duration9 = ObjectAnimator.ofFloat(m15278(), View.ALPHA, 0.0f, 1.0f).setDuration(100L);
        C1457Fr.m5016((Object) duration9, "animatorFadeInLabelAfterCrossingIcon");
        duration9.setStartDelay(80);
        ObjectAnimator duration10 = ObjectAnimator.ofPropertyValuesHolder(m15278(), PropertyValuesHolder.ofFloat(View.SCALE_X, 1.4f), PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.4f)).setDuration(750L);
        C1457Fr.m5016((Object) duration10, "animatorScaleUpLabel");
        duration10.setInterpolator(f14465.m15295());
        ObjectAnimator duration11 = ObjectAnimator.ofFloat(m15273(), View.ALPHA, 0.0f, 0.7f).setDuration(100L);
        duration11.addListener(new Cif(this));
        ObjectAnimator duration12 = ObjectAnimator.ofFloat(m15273(), View.ALPHA, 0.7f, 0.0f).setDuration(350L);
        if (this.f14477.isRunning()) {
            this.f14477.cancel();
        }
        this.f14477 = new AnimatorSet();
        this.f14477.play(duration).with(duration2).before(duration9).before(duration3).before(duration4).before(duration6).before(duration10).before(duration11);
        this.f14477.play(duration5).after(duration4);
        this.f14477.play(duration7).after(duration6);
        this.f14477.play(duration8).after(duration7);
        this.f14477.play(duration12).after(duration11);
        this.f14477.addListener(new C0798(this));
        this.f14477.start();
    }

    /* renamed from: o.ᒯ$iF  reason: case insensitive filesystem */
    public static final class C2403iF extends AnimatorListenerAdapter {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ CharSequence f14489;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C0795 f14490;

        C2403iF(C0795 r1, CharSequence charSequence) {
            this.f14490 = r1;
            this.f14489 = charSequence;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f14490.m15278().setText(this.f14489);
        }
    }

    /* renamed from: o.ᒯ$ˊ  reason: contains not printable characters */
    public static final class C0796 extends AnimatorListenerAdapter {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C0795 f14492;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ AbstractC1449Fj f14493;

        C0796(C0795 r1, AbstractC1449Fj fj) {
            this.f14492 = r1;
            this.f14493 = fj;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f14492.m15278().setTranslationX(0.0f);
            this.f14492.m15278().setText(this.f14492.f14484);
            this.f14492.m15278().setScaleX(1.0f);
            this.f14492.m15278().setScaleY(1.0f);
            AbstractC1449Fj fj = this.f14493;
            if (fj != null) {
                EA ea = (EA) fj.invoke();
            }
        }
    }

    /* renamed from: o.ᒯ$if  reason: invalid class name */
    public static final class Cif extends AnimatorListenerAdapter {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C0795 f14491;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        Cif(C0795 r1) {
            this.f14491 = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f14491.m15273().setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f14491.m15273().setVisibility(8);
        }
    }

    /* renamed from: o.ᒯ$ᐝ  reason: contains not printable characters */
    public static final class C0798 extends AnimatorListenerAdapter {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ C0795 f14494;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C0798(C0795 r1) {
            this.f14494 = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f14494.m15289(this.f14494.m15275(), this.f14494.m15278(), this.f14494.m15273());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m15289(View view, TextView textView, View view2) {
        textView.setTranslationX(0.0f);
        textView.setText(this.f14484);
        textView.setScaleX(1.0f);
        textView.setScaleY(1.0f);
        textView.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotation(0.0f);
        view2.setAlpha(0.0f);
        view2.setVisibility(8);
    }
}

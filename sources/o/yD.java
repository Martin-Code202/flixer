package o;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import io.reactivex.subjects.PublishSubject;
import kotlin.TypeCastException;
import o.xJ;
public final class yD extends yJ implements AbstractC2350yo {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final Cif f12344 = new Cif(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f12345;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final ViewGroup f12346;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C1081 f12347;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final View f12348;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12349 = PublishSubject.create();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0716 f12350;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ViewGroup f12351;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final ImageView f12352;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f12353;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yD(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        this.f12346 = viewGroup;
        View inflate = LayoutInflater.from(this.f12346.getContext()).inflate(R.layout.player_seekbar, this.f12346, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…er_seekbar, parent, true)");
        this.f12348 = inflate;
        View findViewById = this.f12348.findViewById(R.id.player_seekbar);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id.player_seekbar)");
        this.f12351 = (ViewGroup) findViewById;
        View findViewById2 = aj_().findViewById(R.id.label_time_remaining);
        C1457Fr.m5016((Object) findViewById2, "uiView.findViewById(R.id.label_time_remaining)");
        this.f12350 = (C0716) findViewById2;
        View findViewById3 = aj_().findViewById(R.id.timeline_seekbar);
        C1457Fr.m5016((Object) findViewById3, "uiView.findViewById(R.id.timeline_seekbar)");
        this.f12347 = (C1081) findViewById3;
        View findViewById4 = aj_().findViewById(R.id.extra_seekbar_handler);
        C1457Fr.m5016((Object) findViewById4, "uiView.findViewById(R.id.extra_seekbar_handler)");
        this.f12352 = (ImageView) findViewById4;
        this.f12347.setOnSeekBarChangeListener(new C0298());
    }

    /* renamed from: o.yD$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public ViewGroup aj_() {
        return this.f12351;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        PublishSubject<xJ> publishSubject = this.f12349;
        C1457Fr.m5016((Object) publishSubject, "uiEventObservable");
        return publishSubject;
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean mo13108() {
        return aj_().getVisibility() == 0 || this.f12353;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
        if (!this.f12353 && !mo13108()) {
            this.f12353 = true;
            m13140().m12588(aj_(), true, new RunnableC0300(this));
        }
    }

    /* renamed from: o.yD$ᐝ  reason: contains not printable characters */
    static final class RunnableC0300 implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ yD f12366;

        RunnableC0300(yD yDVar) {
            this.f12366 = yDVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f12366.f12353 = false;
        }
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
        if (!this.f12345 && mo13108()) {
            this.f12345 = true;
            m13140().m12588(aj_(), false, new RunnableC0299(this));
        }
    }

    /* renamed from: o.yD$ˋ  reason: contains not printable characters */
    static final class RunnableC0299 implements Runnable {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ yD f12365;

        RunnableC0299(yD yDVar) {
            this.f12365 = yDVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f12365.f12345 = false;
        }
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ˏॱ */
    public void mo13085() {
        super.mo13085();
        this.f12347.setEnabled(true);
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ͺ */
    public void mo13086() {
        super.mo13086();
        this.f12347.setEnabled(false);
    }

    @Override // o.AbstractC2350yo
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo13116(String str) {
        C1457Fr.m5025(str, "timeRemaining");
        this.f12350.setText(str);
    }

    @Override // o.yJ
    public int ai_() {
        return aj_().getId();
    }

    @Override // o.AbstractC2350yo
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo13112(int i) {
        this.f12347.setMax(i);
    }

    @Override // o.AbstractC2350yo
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo13110(int i) {
        this.f12347.setProgress(i);
    }

    @Override // o.AbstractC2350yo
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo13113() {
        this.f12347.m16171(false);
    }

    @Override // o.AbstractC2350yo
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo13114() {
        this.f12347.m16171(true);
    }

    @Override // o.AbstractC2350yo
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo13111() {
        this.f12352.setVisibility(0);
    }

    @Override // o.AbstractC2350yo
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo13117() {
        this.f12352.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private final int m13106(int i) {
        return (int) this.f12347.m16172((long) i);
    }

    @Override // o.AbstractC2350yo
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo13115(int i) {
        this.f12352.setTranslationX((float) m13106(i));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m13103(int i, Runnable runnable) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f12352.getTranslationX(), (float) m13106(i));
        ofFloat.addUpdateListener(new If(this));
        ofFloat.addListener(new C2334iF(this, runnable));
        C1457Fr.m5016((Object) ofFloat, "handlerAnimation");
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    /* access modifiers changed from: package-private */
    public static final class If implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ yD f12354;

        If(yD yDVar) {
            this.f12354 = yDVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ImageView imageView = this.f12354.f12352;
            C1457Fr.m5016((Object) valueAnimator, "valueAnimator");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
            }
            imageView.setTranslationX(((Float) animatedValue).floatValue());
        }
    }

    /* renamed from: o.yD$iF  reason: case insensitive filesystem */
    public static final class C2334iF implements Animator.AnimatorListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ yD f12355;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ Runnable f12356;

        C2334iF(yD yDVar, Runnable runnable) {
            this.f12355 = yDVar;
            this.f12356 = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1457Fr.m5025(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            C1457Fr.m5025(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            this.f12355.f12352.post(this.f12356);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            C1457Fr.m5025(animator, "animation");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final int m13102(int i) {
        int i2 = (i / SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS) * SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS;
        if (i2 == i) {
        }
        return i2;
    }

    /* renamed from: o.yD$ˊ  reason: contains not printable characters */
    public final class C0298 implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        private int f12357;

        /* renamed from: ˋ  reason: contains not printable characters */
        private boolean f12358;

        /* renamed from: ˎ  reason: contains not printable characters */
        private int f12359;

        /* renamed from: ॱ  reason: contains not printable characters */
        private boolean f12361 = true;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C0298() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            C1457Fr.m5025(seekBar, "seekBar");
            if (z) {
                this.f12359 = i;
                if (Math.abs(seekBar.getProgress() - this.f12359) <= this.f12357) {
                    if (this.f12361) {
                        this.f12361 = false;
                    } else {
                        seekBar.performHapticFeedback(1);
                    }
                }
                yD.this.f12349.onNext(new xJ.C0285(this.f12359, yD.this.m13106(this.f12359), seekBar.getProgress() >= this.f12359));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public synchronized void onStartTrackingTouch(SeekBar seekBar) {
            C1457Fr.m5025(seekBar, "seekBar");
            this.f12361 = true;
            this.f12357 = (int) (((double) seekBar.getMax()) * 0.003d);
            this.f12359 = seekBar.getProgress();
            yD.this.f12349.onNext(new xJ.C0284(this.f12359, yD.this.m13106(this.f12359)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public synchronized void onStopTrackingTouch(SeekBar seekBar) {
            C1457Fr.m5025(seekBar, "fSeekBar");
            if (!(seekBar instanceof C1081)) {
                C1283.m16850("PlayerSeekbarUIView", "PlayerFragment got not a Netflix seekbar!");
                C1276.m16820().mo5727("PlayerFragment got not a Netflix seekbar!");
                return;
            }
            int progress = ((C1081) seekBar).getProgress();
            if (!this.f12358) {
                progress = yD.this.m13102(this.f12359);
                this.f12359 = 0;
            }
            ((C1081) seekBar).setProgress(progress);
            yD.this.f12349.onNext(new xJ.C2297Aux(false, progress, true));
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final boolean m13121(SeekBar seekBar, MotionEvent motionEvent, int i) {
            C1457Fr.m5025(seekBar, "seekbar");
            C1457Fr.m5025(motionEvent, "event");
            switch (motionEvent.getAction()) {
                case 0:
                    this.f12358 = false;
                    onStartTrackingTouch(seekBar);
                    onProgressChanged(seekBar, i, true);
                    return true;
                case 1:
                    if (m13120(motionEvent.getY())) {
                        onProgressChanged(seekBar, seekBar.getProgress(), true);
                    }
                    onStopTrackingTouch(seekBar);
                    return true;
                case 2:
                    if (!m13120(motionEvent.getY())) {
                        onProgressChanged(seekBar, i, true);
                        this.f12358 = false;
                        return true;
                    } else if (this.f12358) {
                        return true;
                    } else {
                        m13119(seekBar, seekBar.getProgress());
                        this.f12358 = true;
                        return true;
                    }
                default:
                    return false;
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private final boolean m13120(float f) {
            return f < -300.0f || f > 300.0f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.yD$ˊ$if  reason: invalid class name */
        public static final class Cif implements Runnable {

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ int f12362;

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ C0298 f12363;

            /* renamed from: ॱ  reason: contains not printable characters */
            final /* synthetic */ SeekBar f12364;

            Cif(C0298 r1, SeekBar seekBar, int i) {
                this.f12363 = r1;
                this.f12364 = seekBar;
                this.f12362 = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12363.onProgressChanged(this.f12364, this.f12362, true);
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private final void m13119(SeekBar seekBar, int i) {
            yD.this.m13103(i, new Cif(this, seekBar, i));
        }
    }
}

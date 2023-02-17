package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.ui.player.v2.uiView.PlayerPrimaryControlsUIView$performSkipAnimation$onAnimationEnd$1;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import o.C0795;
import o.xJ;
/* renamed from: o.yy  reason: case insensitive filesystem */
public final class C2360yy extends yJ implements AbstractC2349yn {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0313 f12535 = new C0313(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final PublishSubject<EA> f12536;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final ImageButton f12537;

    /* renamed from: ʽ  reason: contains not printable characters */
    private ViewPropertyAnimator f12538;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12539;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f12540 = SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final ViewGroup f12541;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final Cif f12542;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final View f12543;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C0795 f12544;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C0795 f12545;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2360yy(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        this.f12539 = create;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_controls_primary, viewGroup, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…ls_primary, parent, true)");
        this.f12543 = inflate;
        View findViewById = this.f12543.findViewById(R.id.player_controls_primary);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id.player_controls_primary)");
        this.f12541 = (ViewGroup) findViewById;
        View findViewById2 = aj_().findViewById(R.id.player_pause_btn);
        C1457Fr.m5016((Object) findViewById2, "uiView.findViewById(R.id.player_pause_btn)");
        this.f12537 = (ImageButton) findViewById2;
        View findViewById3 = aj_().findViewById(R.id.skip_back_seek_button);
        C1457Fr.m5016((Object) findViewById3, "uiView.findViewById(R.id.skip_back_seek_button)");
        this.f12545 = (C0795) findViewById3;
        View findViewById4 = aj_().findViewById(R.id.skip_forward_seek_button);
        C1457Fr.m5016((Object) findViewById4, "uiView.findViewById(R.id.skip_forward_seek_button)");
        this.f12544 = (C0795) findViewById4;
        this.f12536 = PublishSubject.create();
        this.f12542 = new Cif(this);
        this.f12537.setOnClickListener(new View.OnClickListener(this) { // from class: o.yy.1

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ C2360yy f12546;

            {
                this.f12546 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.performHapticFeedback(1);
                this.f12546.m13369().onNext(xJ.C0277.f12026);
            }
        });
        this.f12545.setOnSeekButtonListener(this.f12542);
        this.f12544.setOnSeekButtonListener(this.f12542);
    }

    /* renamed from: o.yy$ˋ  reason: contains not printable characters */
    public static final class C0313 {
        private C0313() {
        }

        public /* synthetic */ C0313(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public final PublishSubject<xJ> m13369() {
        return this.f12539;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public ViewGroup aj_() {
        return this.f12541;
    }

    /* renamed from: o.yy$if  reason: invalid class name */
    public static final class Cif implements C0795.AbstractC2402If {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2360yy f12549;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        Cif(C2360yy yyVar) {
            this.f12549 = yyVar;
        }

        @Override // o.C0795.AbstractC2402If
        /* renamed from: ˋ */
        public void mo1851(C0795 r6, int i, int i2) {
            C1457Fr.m5025(r6, "seekButton");
            C1300Ac.m3536(new C1080(AppView.playbackControls, null), i == -1, false, (long) this.f12549.f12540);
            this.f12549.m13369().onNext(xJ.C2302con.f12023);
        }

        @Override // o.C0795.AbstractC2402If
        /* renamed from: ˎ */
        public void mo1852(C0795 r6, int i, int i2) {
            C1457Fr.m5025(r6, "seekButton");
            C1283.m16854("PlayerPrimaryControlsUIView", "onSeekConfirmed, tapCount is " + i2);
            this.f12549.m13369().onNext(new xJ.C2297Aux(i == -1, this.f12549.f12540 * i2, false));
        }
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        return this.f12539;
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ʼ */
    public boolean mo13108() {
        return aj_().getVisibility() == 0;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
        m13368(true);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
        m13368(false);
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ˏॱ */
    public void mo13085() {
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ˏ */
    public void mo13350() {
        m13140().m12594(this.f12537, true);
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ˊ */
    public void mo13345(boolean z) {
        if (z) {
            m13140().m12594(this.f12545, true);
            m13140().m12594(this.f12544, true);
            return;
        }
        this.f12545.setEnabled(true);
        this.f12544.setEnabled(true);
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ͺ */
    public void mo13086() {
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ˊ */
    public void mo13344() {
        m13140().m12594(this.f12537, false);
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ॱ */
    public void mo13353(boolean z) {
        if (z) {
            m13140().m12594(this.f12545, false);
            m13140().m12594(this.f12544, false);
            return;
        }
        this.f12545.setEnabled(false);
        this.f12544.setEnabled(false);
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public boolean m13372() {
        return this.f12537.getVisibility() == 0;
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ˎ */
    public void mo13348() {
        if (!m13372()) {
            this.f12537.setVisibility(0);
        }
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ˋ */
    public void mo13346() {
        if (m13372()) {
            this.f12537.setVisibility(4);
        }
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ˋ */
    public void mo13347(boolean z) {
        if (z) {
            this.f12537.setImageResource(R.drawable.ic_player_pause_ab8579);
        } else {
            this.f12537.setImageResource(R.drawable.ic_player_play_ab8579);
        }
    }

    @Override // o.yJ
    public int ai_() {
        return aj_().getId();
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ˏ */
    public void mo13351(boolean z) {
        PlayerPrimaryControlsUIView$performSkipAnimation$onAnimationEnd$1 playerPrimaryControlsUIView$performSkipAnimation$onAnimationEnd$1 = new PlayerPrimaryControlsUIView$performSkipAnimation$onAnimationEnd$1(this);
        if (z) {
            this.f12545.m15291(playerPrimaryControlsUIView$performSkipAnimation$onAnimationEnd$1);
        } else {
            this.f12544.m15291(playerPrimaryControlsUIView$performSkipAnimation$onAnimationEnd$1);
        }
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ˎ */
    public void mo13349(boolean z) {
        if (z) {
            this.f12545.setVisibility(0);
        } else {
            this.f12544.setVisibility(0);
        }
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ʽ */
    public void mo13343(boolean z) {
        if (z) {
            this.f12545.setVisibility(4);
        } else {
            this.f12544.setVisibility(4);
        }
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ॱ */
    public void mo13352() {
        aj_().setVisibility(0);
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ᐝ */
    public void mo13354() {
        aj_().setVisibility(8);
    }

    @Override // o.AbstractC2349yn
    /* renamed from: ʻ */
    public Observable<EA> mo13342() {
        PublishSubject<EA> publishSubject = this.f12536;
        C1457Fr.m5016((Object) publishSubject, "skipButtonAnimationEndObservable");
        return publishSubject;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final void m13368(boolean z) {
        if (z == (aj_().getVisibility() == 0)) {
            ViewPropertyAnimator viewPropertyAnimator = this.f12538;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
            }
            aj_().setAlpha((float) (z ? 1 : 0));
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.f12538;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
        }
        if (z) {
            aj_().setAlpha(0.0f);
            aj_().setVisibility(0);
        }
        this.f12538 = aj_().animate().setDuration(150).alpha((float) (z ? 1 : 0)).setStartDelay((long) (z ? 100 : 0)).setListener(new If(this, z));
    }

    /* renamed from: o.yy$If */
    public static final class If extends AnimatorListenerAdapter {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ boolean f12547;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C2360yy f12548;

        If(C2360yy yyVar, boolean z) {
            this.f12548 = yyVar;
            this.f12547 = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1457Fr.m5025(animator, "animation");
            if (!this.f12547) {
                this.f12548.aj_().setVisibility(8);
                this.f12548.aj_().setAlpha(1.0f);
            }
            this.f12548.f12538 = null;
        }
    }
}

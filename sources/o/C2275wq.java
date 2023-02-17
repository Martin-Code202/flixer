package o;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.ViewFlipper;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.service.player.subtitles.text.FontFamilyMapping;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PlayerUiState;
import com.netflix.mediaclient.ui.player.PostPlay;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.blades.CreditMarks;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;
import java.nio.ByteBuffer;
import java.util.List;
import o.AbstractC0931;
import o.wY;
/* renamed from: o.wq  reason: case insensitive filesystem */
public class C2275wq implements wY.If {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected View f11652;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected boolean f11653;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected PlayerFragment f11654;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private boolean f11655;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected ViewFlipper f11656;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private String f11657;

    /* renamed from: ʾ  reason: contains not printable characters */
    private ViewPropertyAnimator f11658;

    /* renamed from: ʿ  reason: contains not printable characters */
    private int f11659;

    /* renamed from: ˈ  reason: contains not printable characters */
    private boolean f11660 = true;

    /* renamed from: ˉ  reason: contains not printable characters */
    private Disposable f11661;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected PlayerUiState f11662 = PlayerUiState.Loading;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private Disposable f11663;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected PostPlay f11664;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected View f11665;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected View f11666;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected SurfaceHolder f11667;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected boolean f11668 = false;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected View f11669;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected C2306xb f11670;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final C0942 f11671;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected ImageView f11672;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected wY f11673;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected View f11674;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected C2258wa f11675;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private PlayerUiState f11676;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected C0256 f11677;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected RelativeLayout f11678;

    /* renamed from: o.wq$ˊ  reason: contains not printable characters */
    public static class C0256 {

        /* renamed from: ʻ  reason: contains not printable characters */
        public AbstractC0931.AbstractC0932 f11688;

        /* renamed from: ʼ  reason: contains not printable characters */
        public View.OnClickListener f11689;

        /* renamed from: ʽ  reason: contains not printable characters */
        public View.OnClickListener f11690;

        /* renamed from: ˊ  reason: contains not printable characters */
        public SeekBar.OnSeekBarChangeListener f11691;

        /* renamed from: ˋ  reason: contains not printable characters */
        public SeekBar.OnSeekBarChangeListener f11692;

        /* renamed from: ˎ  reason: contains not printable characters */
        public View.OnClickListener f11693;

        /* renamed from: ˏ  reason: contains not printable characters */
        public View.OnClickListener f11694;

        /* renamed from: ॱ  reason: contains not printable characters */
        public View.OnClickListener f11695;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        public View.OnClickListener f11696;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public SurfaceHolder.Callback f11697;

        /* renamed from: ᐝ  reason: contains not printable characters */
        public View.OnTouchListener f11698;
    }

    C2275wq(final PlayerFragment playerFragment, View view, C0256 r6, PostPlayFactory.PostPlayType postPlayType) {
        if (playerFragment == null || r6 == null) {
            throw new IllegalArgumentException("Argument can not be null!");
        }
        this.f11654 = playerFragment;
        this.f11677 = r6;
        mo12459(playerFragment, view, r6);
        this.f11671 = (C0942) view.findViewById(R.id.surface);
        if (this.f11671 != null) {
            mo12454(this.f11671);
            this.f11667 = this.f11671.getHolder();
        }
        if (this.f11667 != null) {
            this.f11667.addCallback(r6.f11697);
        }
        this.f11656 = (ViewFlipper) view.findViewById(R.id.flipper);
        this.f11665 = view.findViewById(R.id.background);
        this.f11678 = (RelativeLayout) view.findViewById(R.id.displayArea);
        this.f11652 = view.findViewById(R.id.splash_buffering);
        this.f11669 = view.findViewById(R.id.playoutSplash);
        this.f11672 = (ImageView) view.findViewById(m12487(playerFragment.m14534().isTablet()) ? R.id.tablet_bifs : R.id.bifs);
        this.f11666 = view.findViewById(R.id.current_time_exp);
        this.f11674 = view.findViewById(R.id.data_saving_toast);
        this.f11664 = PostPlayFactory.m2595(playerFragment);
        this.f11653 = false;
        this.f11673 = (wY) view.findViewById(R.id.skip_credits_button);
        mo12453(PlayerUiState.Loading);
        if (Config_Ab9454_InPlayerPivots.m517()) {
            this.f11661 = (Disposable) playerFragment.f3537.subscribeWith(new DisposableObserver<IPlayerFragment.PublisherEvents>() { // from class: o.wq.1
                /* renamed from: ˏ  reason: contains not printable characters */
                public void onNext(IPlayerFragment.PublisherEvents publisherEvents) {
                    switch (AnonymousClass5.f11686[publisherEvents.ordinal()]) {
                        case 1:
                            C2275wq.this.mo12453(PlayerUiState.PlayingWithTrickPlayOverlay);
                            return;
                        case 2:
                            C2275wq.this.m12474(playerFragment.f3537);
                            return;
                        case 3:
                            if (C2275wq.this.f11661 != null) {
                                C2275wq.this.f11661.dispose();
                            }
                            if (C2275wq.this.f11663 != null) {
                                C2275wq.this.f11663.dispose();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                }
            });
            m12474(playerFragment.f3537);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12474(PublishSubject<IPlayerFragment.PublisherEvents> publishSubject) {
        if (Config_Ab9454_InPlayerPivots.m517()) {
            if (this.f11663 != null) {
                this.f11663.dispose();
            }
            this.f11663 = (Disposable) publishSubject.filter(new Predicate<IPlayerFragment.PublisherEvents>() { // from class: o.wq.3
                /* renamed from: ॱ  reason: contains not printable characters */
                public boolean test(IPlayerFragment.PublisherEvents publisherEvents) {
                    return publisherEvents == IPlayerFragment.PublisherEvents.ON_SHOW_POST_PLAY_MARK;
                }
            }).take(1).subscribeWith(new DisposableObserver<IPlayerFragment.PublisherEvents>() { // from class: o.wq.4
                /* renamed from: ˏ  reason: contains not printable characters */
                public void onNext(IPlayerFragment.PublisherEvents publisherEvents) {
                    C2275wq.this.mo12453(PlayerUiState.PlayingWithTrickPlayOverlay);
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo12454(C0942 r2) {
        r2.m15759(this.f11677.f11688);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public void mo12459(PlayerFragment playerFragment, View view, C0256 r4) {
        this.f11670 = new C2306xb(playerFragment, r4);
        this.f11675 = new C2258wa(playerFragment, view, r4);
    }

    /* renamed from: ˏ */
    public void mo12465() {
        final C2279wu r3 = this.f11654.mo2239();
        if (r3 == null || r3.m12545() == null) {
            C1283.m16865("screen", "PlayerFragment getVideoDetails() is null. Advisory notice is disabled.");
        } else if (!this.f11655 && this.f11654 != null && m12478(this.f11654)) {
            this.f11654.m14536().m9764().mo9474(r3.m12545().getPlayableId(), new AbstractC2061pj() { // from class: o.wq.2
                @Override // o.AbstractC2061pj, o.oU
                public void onAdvisoriesFetched(List<Advisory> list, Status status) {
                    NetflixActivity r2;
                    if (!status.mo301() && (r2 = C2275wq.this.f11654.m14534()) != null && !r2.isFinishing()) {
                        C2275wq.this.f11655 = r3.m12550() || list.isEmpty();
                        for (int i = 0; i < list.size(); i++) {
                            Advisory advisory = list.get(i);
                            AbstractC1180 r5 = AbstractC1180.m16407(r2, advisory);
                            if (advisory.getType() == Advisory.Type.EXPIRY_NOTICE) {
                                ((C1184) r5).m16441(C2275wq.this.f11654);
                            }
                            if (i == list.size() - 1) {
                                r5.m16419(new PopupWindow.OnDismissListener() { // from class: o.wq.2.4
                                    @Override // android.widget.PopupWindow.OnDismissListener
                                    public void onDismiss() {
                                        C2275wq.this.f11655 = true;
                                        if (C2275wq.this.m12508() != null) {
                                            C2275wq.this.m12508().m12903(false);
                                        }
                                    }
                                });
                            }
                            r5.m16430();
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12502() {
        AbstractC1180.m16416();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12516() {
        AbstractC1180.m16406();
    }

    /* renamed from: ˊ */
    public synchronized void mo12453(PlayerUiState playerUiState) {
        if (this.f11654 == null || !this.f11654.m14535()) {
            C1283.m16865("screen", "moveToState() mController is already in finishing state, do nothing");
        } else if (this.f11662 != playerUiState) {
            this.f11676 = playerUiState;
            switch (playerUiState) {
                case Loading:
                    m12483();
                    break;
                case Playing:
                    mo12534();
                    break;
                case PlayingWithTrickPlayOverlay:
                    mo12491();
                    break;
                case PostPlay:
                    m12509();
                    break;
                case PrePlay:
                    m12479();
                    break;
                case Interrupter:
                    m12484();
                    break;
                case SkipCredits:
                    m12482(this.f11662);
                    break;
                default:
                    C1283.m16850("screen", "Invalid state set, ignoring");
                    break;
            }
            this.f11662 = playerUiState;
            this.f11676 = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.wq$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: ˎ  reason: contains not printable characters */
        static final /* synthetic */ int[] f11686 = new int[IPlayerFragment.PublisherEvents.values().length];

        static {
            f11687 = new int[PlayerUiState.values().length];
            try {
                f11687[PlayerUiState.Loading.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11687[PlayerUiState.Playing.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11687[PlayerUiState.PlayingWithTrickPlayOverlay.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11687[PlayerUiState.PostPlay.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11687[PlayerUiState.PrePlay.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f11687[PlayerUiState.Interrupter.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f11687[PlayerUiState.SkipCredits.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f11686[IPlayerFragment.PublisherEvents.INTENT_ON_PLAYER_TOUCH_FLING_UP.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f11686[IPlayerFragment.PublisherEvents.ON_PLAYER_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f11686[IPlayerFragment.PublisherEvents.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private void m12484() {
        this.f11654.m14534().removeVisibleDialog();
        if (this.f11654.m14534().isDialogFragmentVisible()) {
            this.f11654.m14534().removeDialogFrag();
        }
        m12498();
        this.f11668 = true;
        mo12437();
        this.f11654.mo2245().mo9033(false);
        C1283.m16854("screen", "Interrupted");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12509() {
        this.f11654.m14534().removeVisibleDialog();
        if (this.f11654.m14534().isDialogFragmentVisible()) {
            this.f11654.m14534().removeDialogFrag();
        }
        m12498();
        C1283.m16854("screen", "POST_PLAY");
        this.f11668 = true;
        mo12437();
        this.f11664.m2576(m12505());
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private void m12479() {
        mo12491();
        this.f11654.m14534().removeVisibleDialog();
        if (this.f11654.m14534().isDialogFragmentVisible()) {
            this.f11654.m14534().removeDialogFrag();
        }
        this.f11668 = true;
        mo12437();
        if (this.f11673 != null) {
            this.f11673.setSkipCreditsButtonType(0);
            this.f11673.setText(R.string.label_skip_recap_button);
            mo12463(true);
            this.f11673.setIsWithinCreditMarks(false);
            this.f11673.mo12393(true);
            this.f11673.setShowSkipButtonIndependentlyOfPlayerControls(false);
        }
        this.f11668 = true;
    }

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private void m12483() {
        C1283.m16854("screen", "STATE_LOADING, default");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo12435(boolean z) {
        boolean r3 = AD.m3299();
        if (!z) {
            if (r3) {
                this.f11654.m2498().setFlags(1024, 1024);
            }
            if (this.f11675 != null) {
                this.f11675.mo12107();
            }
            if (m12508() != null) {
                m12508().m12900();
            }
        } else {
            if (r3) {
                this.f11654.m2498().clearFlags(1024);
            }
            if (this.f11675 != null) {
                this.f11675.m12412(mo12499());
                this.f11675.mo12099();
            }
            if (m12508() != null) {
                m12508().m12892();
            }
            if (m12505()) {
                m12494();
            }
        }
        AbstractC1978mi r4 = this.f11654.mo2245();
        if (r4 != null && (!z || !this.f11654.mo2241())) {
            r4.mo9028(z);
        }
        if (this.f11654.mo2241()) {
            m12527(z);
        }
    }

    /* renamed from: ॱ */
    public void mo12470() {
        if (this.f11675 != null) {
            this.f11675.mo12107();
        }
        if (m12508() != null) {
            m12508().m12900();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m12494() {
        mo12470();
        if (this.f11673 != null) {
            this.f11673.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12527(boolean z) {
        if (this.f11654.m14534().getNetflixActionBar() != null) {
            C0772 r2 = this.f11654.m14534().getNetflixActionBar().m358();
            if (z && !r2.isShown()) {
                r2.setVisibility(0);
            }
            if (m12496().mo2500().mo892() || z) {
                if ((r2.getAlpha() > 0.0f) != z) {
                    BQ.m3916(r2, z);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo12534() {
        C1283.m16854("screen", "STATE_LOADED");
        boolean z = !this.f11654.m2470();
        if (this.f11675 != null) {
            this.f11675.mo12104(z);
        }
        int color = this.f11654.getResources().getColor(R.color.transparent);
        if (this.f11665 != null) {
            this.f11665.setBackgroundColor(color);
        }
        if (this.f11671 != null) {
            this.f11671.setBackgroundColor(color);
        }
        if (this.f11657 != null) {
            this.f11654.m14534().reportUiModelessViewSessionEnded(IClientLogging.ModalView.playbackControls, this.f11657);
            this.f11657 = null;
        }
        mo12435(false);
        if (this.f11673 != null) {
            this.f11673.mo12391(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public void mo12491() {
        C1283.m16854("screen", "STATE_LOADED_TAPPED");
        boolean z = !this.f11654.m2470();
        if (this.f11673 != null) {
            mo12463(true);
            this.f11673.setSkipCreditsButtonType(1);
            this.f11673.mo12393(false);
        }
        if (this.f11675 != null) {
            this.f11675.mo12104(z);
        }
        int color = this.f11654.getResources().getColor(R.color.transparent);
        if (this.f11665 != null) {
            this.f11665.setBackgroundColor(color);
        }
        if (this.f11671 != null) {
            this.f11671.setBackgroundColor(color);
        }
        this.f11657 = this.f11654.m14534().reportUiModelessViewSessionStart(IClientLogging.ModalView.playbackControls);
        mo12435(true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public void mo12463(boolean z) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12482(PlayerUiState playerUiState) {
        m12496().m2469(SystemClock.elapsedRealtime());
        this.f11654.m14534().removeVisibleDialog();
        if (this.f11654.m14534().isDialogFragmentVisible()) {
            this.f11654.m14534().removeDialogFrag();
        }
        this.f11668 = true;
        mo12437();
        if (this.f11673 != null) {
            this.f11673.setSkipCreditsButtonType(1);
            mo12463(playerUiState == PlayerUiState.PlayingWithTrickPlayOverlay);
            this.f11673.mo12393(true);
            if (playerUiState == PlayerUiState.PlayingWithTrickPlayOverlay) {
                this.f11673.setShowSkipButtonIndependentlyOfPlayerControls(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void m12488() {
        if (this.f11674 != null) {
            this.f11674.setVisibility(8);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m12478(AbstractC0517 r1) {
        return (r1 == null || r1.m14536() == null || r1.m14536().m9764() == null) ? false : true;
    }

    /* renamed from: ˋ */
    public void mo12460(boolean z) {
        if (!z) {
            C1283.m16854("screen", "Hack to make player overlay visible on ICS+ devices. It is only called when event is null");
            if (this.f11668) {
                C1283.m16854("screen", "Navigation bar visibility was already triggered. Ignore.");
                return;
            } else {
                C1283.m16854("screen", "Navigation bar is now visible. Make player overlay visible.");
                this.f11668 = true;
            }
        } else {
            C1283.m16854("screen", "Event is received. We are either not on ICS+ phone or this is tap to hide overlay.");
            this.f11668 = false;
        }
        switch (this.f11662) {
            case Loading:
            case Interrupter:
            default:
                C1283.m16854("screen", "noop");
                break;
            case Playing:
                m12496().f3537.onNext(IPlayerFragment.PublisherEvents.ON_SHOW_PLAYER_CONTROLS);
                if (!m12496().m2458().m12375()) {
                    mo12453(PlayerUiState.PlayingWithTrickPlayOverlay);
                    break;
                } else {
                    mo12453(PlayerUiState.PrePlay);
                    break;
                }
            case PlayingWithTrickPlayOverlay:
            case PrePlay:
            case SkipCredits:
                m12496().f3537.onNext(IPlayerFragment.PublisherEvents.ON_HIDE_PLAYER_CONTROLS);
                C1283.m16854("screen", "Move to Playing");
                mo12453(PlayerUiState.Playing);
                break;
            case PostPlay:
                if (!this.f11664.m2594()) {
                    C1283.m16854("screen", "Move to PlayingWithTrickPlayOverlay from post play");
                    mo12453(PlayerUiState.Playing);
                    this.f11664.m2582();
                    mo12436();
                    break;
                } else {
                    C1283.m16854("screen", "PostPlay was dismissed before, stay in it!");
                    if (!m12506().m2588()) {
                        this.f11664.m2582();
                        break;
                    }
                }
                break;
        }
        if (this.f11653) {
            mo12435(false);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m12500(int i, int i2, boolean z) {
        this.f11659 = i;
        if (this.f11675 != null) {
            this.f11675.m12408(i, i2, z);
        }
        return i;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int m12531() {
        return this.f11659;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12522(boolean z) {
        if (this.f11675 != null) {
            this.f11675.m12402(z);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m12492(boolean z) {
        if (this.f11675 != null) {
            this.f11675.m12404(z);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m12495(boolean z) {
        if (this.f11675 != null) {
            this.f11675.m12407(z);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m12532(boolean z) {
        if (this.f11675 != null) {
            this.f11675.mo12104(z);
        }
    }

    /* renamed from: ˊॱ */
    public void mo12456() {
        mo12455(false, false);
        mo12473(false);
        this.f11675.m12411();
    }

    /* renamed from: ˏॱ */
    public void mo12468() {
        mo12473(true);
        this.f11675.m12405();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12511(int i, Runnable runnable) {
        this.f11675.m12400(i, runnable);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public String m12513() {
        return this.f11675.m12410().m4133(this.f11675.m12399());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m12501(View view) {
        return this.f11675.mo12106(view);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12510(int i) {
        if (this.f11675 != null) {
            this.f11675.m12409(i);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void mo12528() {
        if (this.f11662 == PlayerUiState.Loading) {
            C1283.m16854("screen", "=========================>");
            if (this.f11656 != null) {
                this.f11656.showNext();
            }
            if (m12496().m2458().m12375()) {
                mo12453(PlayerUiState.PrePlay);
            } else if (this.f11662 != PlayerUiState.SkipCredits) {
                mo12453(PlayerUiState.PlayingWithTrickPlayOverlay);
            }
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m12524() {
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public void m12529() {
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public void m12533() {
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public void m12530() {
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public synchronized void mo12536() {
        if (this.f11677 != null) {
            if (this.f11671 != null) {
                this.f11671.m15757(this.f11677.f11688);
            }
            if (this.f11667 != null) {
                this.f11667.removeCallback(this.f11677.f11697);
            }
        }
        if (m12508() != null) {
            m12508().mo12118();
        }
        if (this.f11675 != null) {
            this.f11675.mo12118();
        }
        if (this.f11664 != null) {
            this.f11664.m2555();
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public final C0942 m12489() {
        return this.f11671;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public void m12498() {
        this.f11668 = false;
        if (this.f11662 != PlayerUiState.Loading) {
            mo12453(PlayerUiState.Playing);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo12535(boolean z) {
    }

    /* renamed from: ʻ */
    public void mo12450(boolean z) {
        View view = this.f11652;
        if (view == null) {
            C1283.m16865("screen", "bufferingOverlay is NULL!");
        } else if (z) {
            C1283.m16854("screen", "Display buffering overlay");
            view.setVisibility(0);
        } else {
            C1283.m16854("screen", "Remove buffering overlay");
            view.setVisibility(8);
        }
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public PlayerUiState m12493() {
        return this.f11662;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public synchronized boolean m12497() {
        if (this.f11662 == PlayerUiState.PostPlay) {
            C1283.m16854("screen", "We are in post play state, do not exit player activity");
            this.f11664.mo2559();
            return false;
        } else if (this.f11664.m2594()) {
            C1283.m16854("screen", "Postplay was dismissed, force postplay");
            mo12453(PlayerUiState.PostPlay);
            this.f11664.mo2559();
            this.f11664.mo2563(true);
            return false;
        } else {
            C1283.m16854("screen", "Not in postplay, exit activity");
            return true;
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m12514(boolean z) {
        mo12455(z, true);
    }

    /* renamed from: ˊ */
    public void mo12455(boolean z, boolean z2) {
        if (this.f11654.m14535() && this.f11662 != PlayerUiState.SkipCredits) {
            if (m12508() != null) {
                m12508().mo12898(z);
            }
            if (this.f11675 != null) {
                this.f11675.m12403(z, z2);
            }
        }
    }

    /* renamed from: ॱˊ */
    public void mo12473(boolean z) {
        if (m12508() == null) {
            return;
        }
        if (!z || m12505()) {
            m12508().m12900();
        } else if (this.f11662 == PlayerUiState.PlayingWithTrickPlayOverlay || this.f11662 == PlayerUiState.SkipCredits) {
            m12508().m12892();
        } else {
            C1283.m16854("screen", "Player UI is NOT visible. Do not make top panel visible");
        }
    }

    /* renamed from: ˎ */
    public void mo12462(ByteBuffer byteBuffer) {
        if (this.f11654 != null && this.f11654.m14535()) {
            this.f11675.m12398().m12117(byteBuffer != null);
            if (byteBuffer == null || this.f11672 == null) {
                C1283.m16854("screen", "bif data is null");
                return;
            }
            if (m12487(this.f11654.m2490())) {
                int r2 = C1004.m15954(this.f11654.getActivity(), 40);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11666.getLayoutParams();
                marginLayoutParams.setMargins(this.f11675.mo12106(this.f11666), 0, 0, r2);
                this.f11666.setLayoutParams(marginLayoutParams);
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
            if (null != decodeByteArray) {
                this.f11672.setImageBitmap(decodeByteArray);
            } else {
                C1283.m16854("screen", "bitmap is null");
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12521(ByteBuffer byteBuffer) {
        if (this.f11654 != null && this.f11654.m14535()) {
            if (m12487(this.f11654.m2490())) {
                this.f11658 = BQ.m3916(this.f11666, true);
            } else {
                BQ.m3916(this.f11672, true);
            }
            mo12462(byteBuffer);
        }
    }

    /* renamed from: ˈ */
    public void mo12451() {
        if (this.f11654 != null && this.f11654.m14535()) {
            if (!m12487(this.f11654.m2490())) {
                BQ.m3916(this.f11672, false);
            } else if (this.f11658 != null) {
                this.f11658.cancel();
                this.f11658 = null;
                this.f11666.setAlpha(0.0f);
            } else {
                BQ.m3916(this.f11666, false);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12504(ByteBuffer byteBuffer) {
        C2258wa waVar;
        if (this.f11654 != null && this.f11654.m14535() && (waVar = this.f11675) != null && waVar.m12398() != null) {
            waVar.m12398().mo12114(byteBuffer);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m12525(boolean z) {
        C2258wa waVar;
        if (this.f11654 != null && this.f11654.m14535() && (waVar = this.f11675) != null && waVar.m12398() != null) {
            waVar.m12398().mo12112(z);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12520(String str) {
        if (m12508() != null) {
            m12508().m12890(str);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C2275wq m12486(PlayerFragment playerFragment, C0256 r6, PostPlayFactory.PostPlayType postPlayType) {
        View view = playerFragment.getView();
        if (view == null) {
            throw new IllegalStateException("Tried to instantiate PlayScreen when fragment view was null");
        }
        C2275wq wqVar = null;
        if (C1317As.m3758() >= 16) {
            C1283.m16854("screen", "PlayScreen for JB (Android 4.1+");
            wqVar = new C2272wn(playerFragment, view, r6, postPlayType);
        } else if (Build.MANUFACTURER.equals("Amazon") && (Build.MODEL.equals("KFOT") || Build.MODEL.equals("KFTT") || Build.MODEL.equals("KFJWA") || Build.MODEL.equals("KFJWI"))) {
            C1283.m16854("screen", "PlayScreen for Amazon Kindle HD");
            wqVar = new C2273wo(playerFragment, view, r6, postPlayType);
        } else if (Build.MODEL.equals("Kindle Fire") && Build.MANUFACTURER.equals("Amazon")) {
            C1283.m16854("screen", "PlayScreen for Amazon Kindle Fire");
            wqVar = new C2276wr(playerFragment, view, r6, postPlayType);
        }
        if (wqVar != null) {
            return wqVar;
        }
        C1283.m16854("screen", "PlayScreen for Froyo/Gingerbread (Android 2.2-2.3) - default");
        return new C2275wq(playerFragment, view, r6, postPlayType);
    }

    /* renamed from: ॱ */
    public void mo12472(pT pTVar, IPlayer.PlaybackType playbackType) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12519(Language language) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʽॱ  reason: contains not printable characters */
    public PlayerFragment m12496() {
        return this.f11654;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo12517(Configuration configuration) {
        this.f11664.mo2574(configuration);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void mo12507(boolean z) {
        if (null == this.f11671) {
            return;
        }
        if (z) {
            this.f11671.setMode(1);
        } else {
            this.f11671.setMode(0);
        }
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    public boolean m12505() {
        return this.f11653;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m12523(boolean z) {
        this.f11653 = z;
        if (m12505()) {
            mo12535(false);
            this.f11670.m12900();
            this.f11675.mo12107();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12503(long j, long j2) {
        CreditMarks creditMarks;
        m12506().m2578(j, j2);
        if (m12496().mo2268() != null && (creditMarks = m12496().mo2268().getCreditMarks()) != null && this.f11673 != null && this.f11673.m12392(j, creditMarks, m12496().m2491(), this) && this.f11673.m12394()) {
            mo12453(PlayerUiState.SkipCredits);
        }
    }

    @Override // o.wY.If
    /* renamed from: ॱ */
    public void mo12396(View view, int i) {
        if (this.f11673 == null || this.f11673.m12395() != 0) {
            C1283.m16851("screen", "CreditMarks - Seeking player to %s", Integer.valueOf(i));
            m12496().mo2258(i);
            return;
        }
        m12496().ad_();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public void m12490(boolean z) {
        this.f11660 = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˉ  reason: contains not printable characters */
    public boolean mo12499() {
        return this.f11660 && this.f11671.m15756();
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public C2306xb m12508() {
        return this.f11670;
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public PostPlay m12506() {
        return this.f11664;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋˊ */
    public void mo12436() {
        C1283.m16854("screen", "hide nav noop");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋᐝ */
    public void mo12437() {
        C1283.m16854("screen", "show nav noop");
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    public synchronized boolean m12515() {
        return this.f11662 == PlayerUiState.Interrupter || this.f11676 == PlayerUiState.Interrupter;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m12477(PostPlayFactory.PostPlayType postPlayType) {
        if (C0913.m15712()) {
            C1283.m16854("screen", "playout_ab9691");
            return R.layout.playout_ab9691;
        } else if (postPlayType == PostPlayFactory.PostPlayType.EpisodesForPhone || postPlayType == PostPlayFactory.PostPlayType.SignupForPhone) {
            C1283.m16854("screen", "playout_phone_episode");
            return R.layout.playout_phone_episode;
        } else if (postPlayType == PostPlayFactory.PostPlayType.EpisodesForTablet || postPlayType == PostPlayFactory.PostPlayType.SignupForTablet) {
            C1283.m16854("screen", "playout_tablet_episode");
            return R.layout.playout_tablet_episode;
        } else if (postPlayType == PostPlayFactory.PostPlayType.RecommendationForTablet) {
            C1283.m16854("screen", "playout_tablet_movie");
            return R.layout.playout_tablet_movie;
        } else {
            C1283.m16854("screen", "playout_phone_movie");
            return R.layout.playout_phone_movie;
        }
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    public boolean m12512() {
        return this.f11655;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12526(Watermark watermark) {
        float f;
        if (this.f11678 != null && watermark != null && C1349Bv.m4107(watermark.getIdentifier())) {
            C0544 r4 = new C0544(this.f11654.getActivity());
            r4.setGravity(119);
            int r5 = C1004.m15954(this.f11654.getActivity(), 5);
            r4.setPadding(r5, r5, r5, r5);
            r4.setText(this.f11654.getActivity().getString(R.string.label_watermark, new Object[]{watermark.getIdentifier()}));
            if (this.f11654.m14534().isTablet()) {
                f = this.f11654.getResources().getDimension(R.dimen.player_tablet_watermark_size);
            } else {
                f = this.f11654.getResources().getDimension(R.dimen.player_phone_watermark_size);
            }
            C1346Bs.m4084(r4, m12481(watermark.getOpacity()), f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            if (Watermark.Anchor.top_center == watermark.getAnchor()) {
                layoutParams.addRule(10);
            } else {
                layoutParams.addRule(12);
            }
            this.f11678.addView(r4, layoutParams);
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void m12537(boolean z) {
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public static boolean m12487(boolean z) {
        return true;
    }

    /* renamed from: ˎˎ  reason: contains not printable characters */
    public wY m12518() {
        return this.f11673;
    }

    /* renamed from: ˌ */
    public boolean mo12461() {
        return false;
    }

    /* renamed from: ˏˎ */
    public boolean mo12467() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo12452(PlayerFragment playerFragment, View view, C0256 r3) {
    }

    /* renamed from: ॱ */
    public void mo12471(Activity activity) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private mP m12481(int i) {
        return new mP("watermark", "white", null, null, null, mO.m8853(), FontFamilyMapping.defaultType, null, null, null, Float.valueOf(((float) i) / 100.0f), null, null);
    }
}

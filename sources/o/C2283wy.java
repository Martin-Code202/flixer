package o;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Rational;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.service.net.LogMobileType;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.servicemgr.ExitPipAction;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadState;
import com.netflix.mediaclient.servicemgr.interface_.offline.WatchState;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.PictureInPictureManager;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import com.netflix.mediaclient.ui.player.ScaleType;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import com.netflix.mediaclient.util.ConnectivityUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedList;
import o.AbstractC0496;
import o.C0567;
import o.DialogC1104;
import o.DialogC2233vc;
import o.qI;
import o.qO;
import o.xE;
import o.xF;
import o.xH;
import o.xJ;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.wy  reason: case insensitive filesystem */
public class C2283wy extends AbstractC0517 implements AbstractC0496.Cif, qK, C0567.Cif, IPlayerFragment {

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private static wD f11802;

    /* renamed from: ʻ  reason: contains not printable characters */
    public final PublishSubject<xH> f11803 = PublishSubject.create();

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private PictureInPictureManager f11804;

    /* renamed from: ʼ  reason: contains not printable characters */
    public qI f11805;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final wV f11806 = new wV(this);

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f11807;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f11808 = true;

    /* renamed from: ʾ  reason: contains not printable characters */
    private oY f11809;

    /* renamed from: ʿ  reason: contains not printable characters */
    private BroadcastReceiver f11810;

    /* renamed from: ˈ  reason: contains not printable characters */
    private C2279wu f11811;

    /* renamed from: ˉ  reason: contains not printable characters */
    private final PublishSubject<EA> f11812 = PublishSubject.create();

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private CH f11813 = null;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private final xE f11814 = new xE();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final Handler f11815 = new Handler();

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final CompositeDisposable f11816 = new CompositeDisposable();

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private AbstractC2056pe f11817;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private uW f11818;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private Language f11819;

    /* renamed from: ˌ  reason: contains not printable characters */
    private Long f11820 = 0L;

    /* renamed from: ˍ  reason: contains not printable characters */
    private final LinkedList<Runnable> f11821 = new LinkedList<>();

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private Long f11822 = 0L;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private final IPlayer.Cif f11823 = new IPlayer.Cif() { // from class: o.wy.13
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.Cif
        /* renamed from: ॱ */
        public void mo1529(long j) {
            C2283wy.this.m12613(j);
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    public final wG f11824 = new wG();

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private final IPlayer.AbstractC1291iF f11825 = new IPlayer.AbstractC1291iF() { // from class: o.wy.22
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC1291iF
        /* renamed from: ˋ */
        public void mo1528() {
            C2283wy.this.m12601();
        }
    };
    @Deprecated

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private PublishSubject<xJ> f11826;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private OrientationEventListener f11827;

    /* renamed from: ˑ  reason: contains not printable characters */
    private final IPlayer.AbstractC0024 f11828 = new IPlayer.AbstractC0024() { // from class: o.wy.27
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0024
        /* renamed from: ˎ */
        public void mo1530(IPlayer.aux aux) {
            C2283wy.this.m12646(aux);
        }
    };

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f11829 = 2000;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private final IPlayer.IF f11830 = new IPlayer.IF() { // from class: o.wy.1
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.IF
        /* renamed from: ˋ */
        public void mo1523() {
            C2283wy.this.m12602();
        }
    };

    /* renamed from: ـ  reason: contains not printable characters */
    private final View.OnClickListener f11831 = new View.OnClickListener() { // from class: o.wy.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2283wy.this.m12713() != null) {
                C2283wy.this.f11824.m12287(SystemClock.elapsedRealtime());
                C2283wy.this.m12714();
                if (C2283wy.this.m12713().mo892()) {
                    C1300Ac.m3535(new C1080(AppView.playbackControls, null), new C1243(), new C1051(1.0f, false, "KEYCODE_BUTTON_A"));
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.pause, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    C2283wy.this.m12695(true);
                    return;
                }
                C1300Ac.m3535(new C1080(AppView.playbackControls, null), new C0519(), new C1051(1.0f, false, "KEYCODE_BUTTON_A"));
                C1364Cj.m4434(UIViewLogging.UIViewCommandName.unPause, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                C2283wy.this.mo2247();
            }
        }
    };

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private final Runnable f11832 = new Runnable() { // from class: o.wy.7
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("PlayerFragment", "Pause, release awake clock");
            C2283wy.this.m12655();
        }
    };

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private final IPlayer.AbstractC0026 f11833 = new IPlayer.AbstractC0026() { // from class: o.wy.31
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0026
        /* renamed from: ˏ */
        public void mo1532(IPlayer.PlayerStallReason playerStallReason) {
            C2283wy.this.f11803.onNext(xH.C0269.f12003);
        }
    };

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private final IPlayer.AbstractC1290If f11834 = new IPlayer.AbstractC1290If() { // from class: o.wy.29
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC1290If
        /* renamed from: ˋ */
        public void mo1524() {
            if (C2283wy.this.m12628()) {
                C2283wy.this.m12711().setSurface();
                C2283wy.this.mo2247();
            }
        }
    };

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private wE f11835;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private ViewGroup f11836;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean f11837;

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private final IPlayer.AbstractC0027 f11838 = new IPlayer.AbstractC0027() { // from class: o.wy.35
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0027
        /* renamed from: ˏ */
        public void mo1533() {
            if (C2283wy.this.m12629() && !C2283wy.this.mo2265() && C2283wy.this.m12713() != null) {
                C2283wy.this.m12668(true);
                C2283wy.this.m12713().mo906((Surface) null);
            } else if (!C2283wy.this.m12598()) {
                C1283.m16854("PlayerFragment", "In postplay when surface is destroyed, do not exit");
            } else if (C2283wy.this.f11824.f11448 == PlayerFragment.PlayerFragmentState.ACTIVITY_PLAYER_LOADING_NEXT) {
                C1283.m16854("PlayerFragment", "refreshing UI for new playback.");
            } else {
                C1283.m16854("PlayerFragment", "Surface destroyed, exit if we are not already in it");
                C2283wy.this.mo2248();
            }
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public C0951 f11839;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f11840;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AbstractC1221 f11841;

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private final BroadcastReceiver f11842 = new BroadcastReceiver() { // from class: o.wy.17
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16854("PlayerFragment", "mFinishPipPlayerIntentReceiver has" + intent.getAction());
            if (C2283wy.this.mo2265() && "com.netflix.mediaclient.intent.action.END_PIP".equalsIgnoreCase(intent.getAction())) {
                C2283wy.this.m12603();
            }
        }
    };

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private final BroadcastReceiver f11843 = new BroadcastReceiver() { // from class: o.wy.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C2283wy.this.m12714();
        }
    };

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private AbstractC0496 f11844;

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private final qI.AbstractC0168 f11845 = new qI.AbstractC0168() { // from class: o.wy.12
        @Override // o.qI.AbstractC0168
        /* renamed from: ˊ */
        public void mo2532() {
            C2283wy.this.mo2247();
            C2283wy.this.m12701();
            C2283wy.this.m14534().reportUiModelessViewSessionEnded(IClientLogging.ModalView.audioSubtitlesSelector, C2283wy.this.f11807);
        }

        @Override // o.qI.AbstractC0168
        /* renamed from: ˏ */
        public void mo2533(Dialog dialog) {
            C2283wy.this.m14534().updateVisibleDialog(dialog);
        }

        @Override // o.qI.AbstractC0168
        /* renamed from: ˏ */
        public void mo2534(Language language, boolean z) {
            C2283wy.this.m12614(language);
            C2283wy.this.m14534().reportUiModelessViewSessionEnded(IClientLogging.ModalView.audioSubtitlesSelector, C2283wy.this.f11807);
        }

        @Override // o.qI.AbstractC0168
        /* renamed from: ॱ */
        public boolean mo2535() {
            return C2283wy.this.m12609();
        }
    };

    /* renamed from: ᐧ  reason: contains not printable characters */
    private final Runnable f11846 = new Runnable() { // from class: o.wy.15
        @Override // java.lang.Runnable
        public void run() {
            if (!C2283wy.this.m14535() || C2283wy.this.f11824.f11440 || C2283wy.this.f11824.f11459) {
                C1283.m16854("PlayerFragment", "METADATA exit");
                return;
            }
            synchronized (this) {
                if (!C2283wy.this.f11824.f11440 && !C2283wy.this.f11824.f11459) {
                    if (C2283wy.this.f11824.m12296() > 0 && SystemClock.elapsedRealtime() - C2283wy.this.f11824.m12296() > 5000) {
                        C2283wy.this.f11803.onNext(xH.C0275.f12009);
                        C2283wy.this.f11824.m12287(0);
                    }
                    if (C2283wy.this.m12711().m2347()) {
                        int r5 = (int) C2283wy.this.m12711().m2334();
                        if (C2283wy.this.m12711().m2347()) {
                            C2283wy.this.f11803.onNext(new xH.C2292auX(r5));
                        }
                    }
                }
                C2283wy.this.m12634(1000);
            }
        }
    };

    /* renamed from: ᐨ  reason: contains not printable characters */
    private final BroadcastReceiver f11847 = new BroadcastReceiver() { // from class: o.wy.18
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16854("PlayerFragment", "mPlayerSuspendIntentReceiver has" + intent.getAction());
            if (C2283wy.this.m12628() && wD.m12270(intent.getAction())) {
                C2283wy.this.mo2248();
            }
        }
    };

    /* renamed from: ᶥ  reason: contains not printable characters */
    private final Runnable f11848 = new Runnable() { // from class: o.wy.16
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("PlayerFragment", "pause has timed out, exit playback");
            IClientLogging iClientLogging = null;
            C2059ph r3 = C2283wy.this.m14536();
            if (r3 != null) {
                iClientLogging = r3.m9825();
            }
            if (iClientLogging != null) {
                iClientLogging.mo1504().mo5775("pauseTimeout calling cleanupExit");
            }
            C2283wy.this.mo2248();
            if (iClientLogging != null) {
                iClientLogging.mo1504().mo5775("pauseTimeout cleanupExit done");
            }
        }
    };

    /* renamed from: ㆍ  reason: contains not printable characters */
    private final BroadcastReceiver f11849 = new BroadcastReceiver() { // from class: o.wy.21
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C2283wy.this.m12654();
        }
    };

    /* renamed from: ꓸ  reason: contains not printable characters */
    private final Runnable f11850 = new Runnable() { // from class: o.wy.19
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("PlayerFragment", "Playback canceled when not longer on WiFi");
            C2283wy.this.mo2248();
        }
    };

    /* renamed from: ꜞ  reason: contains not printable characters */
    private final BroadcastReceiver f11851 = new BroadcastReceiver() { // from class: o.wy.23
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                C2283wy.this.m12695(false);
            }
        }
    };

    /* renamed from: ꜟ  reason: contains not printable characters */
    private final qO.Cif f11852 = new qO.Cif() { // from class: o.wy.26
        @Override // o.qO.Cif
        /* renamed from: ˏ */
        public void mo2536(pI pIVar) {
            if (C2283wy.this.m14535()) {
                C1364Cj.m4447(IClientLogging.ModalView.episodesSelector, null);
                C2283wy.this.m12659();
                if (C2283wy.this.f11811 != null && C2283wy.this.f11811.m12545() != null && TextUtils.equals(C2283wy.this.f11811.m12545().getPlayableId(), pIVar.getPlayable().getPlayableId())) {
                    C1283.m16854("PlayerFragment", "Request to play same episode, do nothing");
                    C2283wy.this.m12701();
                    C2283wy.this.mo2247();
                } else if (!C2283wy.this.m12705(pIVar.getPlayable().getPlayableId(), qN.f9505)) {
                    C2283wy.this.mo2243(new C2279wu(pIVar.getPlayable(), C2283wy.this.f11811.m12546(), qN.f9505, pIVar.getPlayable().getPlayableBookmarkPosition()));
                }
            }
        }
    };

    /* renamed from: ﾟ  reason: contains not printable characters */
    private final AbstractC0496.iF f11853 = new AbstractC0496.iF() { // from class: o.wy.30
        @Override // o.AbstractC0496.iF
        /* renamed from: ˋ */
        public void mo2537(AbstractC0496 r4) {
            if ((r4 instanceof C2116re) && C2283wy.this.m14535()) {
                C2283wy.this.f11824.m12287(SystemClock.elapsedRealtime());
                C2283wy.this.m12714();
                C1283.m16854("PlayerFragment", "Episode selector was dismissed");
                if (C2283wy.this.m12713() != null) {
                    if (C2283wy.this.m12713().mo892()) {
                        C2283wy.this.m12695(true);
                    } else {
                        C2283wy.this.mo2247();
                    }
                }
                C2283wy.this.m12701();
            }
        }
    };

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ᐝॱ */
    public /* synthetic */ Context mo2269() {
        return super.getActivity();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static IPlayerFragment m12663(String str, VideoType videoType, oX oXVar, int i, int i2) {
        C2283wy wyVar = new C2283wy();
        wyVar.setArguments(m12632(str, videoType, oXVar, i, i2));
        return wyVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Bundle m12632(String str, VideoType videoType, oX oXVar, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString(NetflixActivity.EXTRA_VIDEO_ID, str);
        bundle.putString(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE, videoType.getValue());
        bundle.putParcelable(NetflixActivity.EXTRA_PLAY_CONTEXT, oXVar);
        if (i > -1) {
            bundle.putInt("extra_bookmark_seconds_from_start_param", i);
        }
        bundle.putInt("EXTRA_AUTO_PLAY_COUNT", i2);
        return bundle;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1317As.m3759((Activity) getActivity());
        m12698().getAttributes().buttonBrightness = 0.0f;
        this.f11824.m12299();
        C1362Ch.m4393((UserActionLogging.CommandName) null, IClientLogging.ModalView.playback);
        this.f11824.f11451.set(true);
        this.f11805 = qI.m9894(m14534(), m14534().isTablet(), this.f11845);
        this.f11835 = new wE(m14534(), this);
        if (C1317As.m3742(NetflixApplication.getInstance())) {
            this.f11804 = new PictureInPictureManager(this, new PictureInPictureManager.iF() { // from class: o.wy.32
                @Override // com.netflix.mediaclient.ui.player.PictureInPictureManager.iF
                /* renamed from: ॱ */
                public void mo2371(boolean z) {
                    super.mo2371(z);
                    if (z) {
                        NetflixApplication.getInstance().m237().m14204(true);
                        return;
                    }
                    NetflixApplication.getInstance().m237().m14204(false);
                    C2283wy.this.f11840 = true;
                }
            });
        }
        AbstractC1358Cd.m4354();
        m12684();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f11836 = (ViewGroup) layoutInflater.inflate(R.layout.player_base_container, (ViewGroup) null, false);
        this.f11839 = (C0951) this.f11836.findViewById(R.id.playback_surface);
        if (this.f11839 == null) {
            C1276.m16820().mo5725("VideoView is not included in the XML");
            mo2248();
        }
        return this.f11836;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m12702(view, new xG((ViewGroup) view, this.f11803, this.f11812, this.f11814, m12711()));
        this.f11816.add((Disposable) this.f11814.m12746().subscribeWith(new DisposableObserver<xE.If>() { // from class: o.wy.33
            /* renamed from: ˊ  reason: contains not printable characters */
            public void onNext(xE.If r7) {
                if (r7.m12751() == null || r7.m12750().mo301()) {
                    C2283wy.this.mo2248();
                    C1276.m16820().mo5725("PlayerFragment No data, finishing up the player. Details=" + r7.m12751() + "Status is " + r7.m12750());
                    return;
                }
                C2283wy.this.m12664(r7.m12751(), r7.m12749(), r7.m12748(), r7.m12752(), false);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                C2283wy.this.mo2248();
                C1276.m16820().mo5729("PlayerFragment No data, finishing up the player", th);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
            }
        }));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private synchronized void m12637(uW uWVar) {
        this.f11803.onNext(new xH.C0263(uWVar));
        this.f11818 = uWVar;
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    public void m12693() {
        if (this.f11818 == null || this.f11818.m11664() == null || this.f11818.m11664().length < 2) {
            C1283.m16854("PlayerFragment", "Non local targets are not available!");
            return;
        }
        C1283.m16854("PlayerFragment", "MDX target is reachable, display dialog");
        m14534().displayDialog(m12683());
    }

    /* renamed from: ꓸ  reason: contains not printable characters */
    private AlertDialog m12683() {
        C1362Ch.m4394("impression", IClientLogging.ModalView.castDeviceSelector, this.f11818.m11663());
        final Long r4 = Logger.INSTANCE.m142(new C1224(C1300Ac.m3534(this.f11818.m11663()), AppView.castDeviceSelector));
        final boolean r5 = m12711().m2347();
        int r6 = this.f11818.m11659();
        this.f11818.m11662(r6);
        DialogC2233vc.C0245 r7 = new DialogC2233vc.C0245(getActivity());
        r7.setCancelable(false);
        r7.setTitle(R.string.label_localMdxTargetWatch);
        r7.m12128(this.f11818.m11661(getActivity()));
        r7.m12129(r6, String.format(getString(R.string.now_playing_title), xI.f12010.m12777(mo2268())));
        r7.m12130(new AdapterView.OnItemClickListener() { // from class: o.wy.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2;
                if (C2283wy.this.m14534() != null && C2283wy.this.m14536() != null && C2283wy.this.m14534().getServiceManager().m9811() != null) {
                    C1283.m16854("PlayerFragment", "Mdx target clicked: item with id " + j + ", on position " + i);
                    C2283wy.this.m12674();
                    if (C2283wy.this.f11818 != null) {
                        C2283wy.this.f11818.m11662(i);
                        uZ r42 = C2283wy.this.f11818.m11665();
                        if (r42 == null) {
                            C1283.m16850("PlayerFragment", "Target is NULL, this should NOT happen!");
                            if (r5) {
                                C2283wy.this.mo2247();
                            }
                        } else if (r42.m11679()) {
                            C1283.m16854("PlayerFragment", "Target is local, same as cancel. Do nothing");
                            if (r5) {
                                C2283wy.this.mo2247();
                            }
                        } else if (AU.m3421(C2283wy.this.m14534().getServiceManager(), r42.m11680())) {
                            C1283.m16854("PlayerFragment", "Remote target is available, start MDX playback, use local bookmark!");
                            C2283wy.this.m14534().getServiceManager().m9811().mo6180(r42.m11680());
                            pF r52 = C2283wy.this.mo2268();
                            oX r62 = C2283wy.this.mo1635();
                            VideoType r72 = C2283wy.this.m12631();
                            if (r52 != null) {
                                i2 = r52.getPlayableBookmarkPosition();
                            } else {
                                i2 = (int) (C2283wy.this.m12711().m2334() / 1000);
                            }
                            PlaybackLauncher.m1613(C2283wy.this.m14534(), r52, r72, r62, i2);
                            C2283wy.this.m14534().getServiceManager().m9811().mo6185();
                            C2283wy.this.m14534().finish();
                        } else {
                            C1283.m16865("PlayerFragment", "Remote target is NOT available anymore, continue local plaback");
                            if (r5) {
                                C2283wy.this.mo2247();
                            }
                        }
                    }
                }
            }
        });
        r7.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: o.wy.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                Logger.INSTANCE.m129(r4);
                C2283wy.this.mo2247();
            }
        });
        r7.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: o.wy.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Logger.INSTANCE.m140(r4);
            }
        });
        return r7.create();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12702(View view, xG xGVar) {
        if (view instanceof ViewGroup) {
            m12694(xGVar.m12755());
            Observable filter = PublishSubject.merge(xGVar.m12756()).filter(new Predicate<xJ>() { // from class: o.wy.4
                /* renamed from: ˏ  reason: contains not printable characters */
                public boolean test(xJ xJVar) {
                    return C2283wy.this.m14535() && C2283wy.this.mo2268() != null;
                }
            });
            this.f11816.add((Disposable) filter.filter(new Predicate<xJ>() { // from class: o.wy.6
                /* renamed from: ˊ  reason: contains not printable characters */
                public boolean test(xJ xJVar) {
                    return !(xJVar instanceof xF);
                }
            }).subscribeWith(new DisposableObserver<xJ>() { // from class: o.wy.8
                /* renamed from: ॱ  reason: contains not printable characters */
                public void onNext(xJ xJVar) {
                    C2283wy.this.mo2229();
                    C2283wy.this.m12714();
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    C1276.m16820().mo5730(th);
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                }
            }));
            this.f11816.add((Disposable) filter.subscribeWith(new DisposableObserver<xJ>() { // from class: o.wy.10
                /* renamed from: ॱ  reason: contains not printable characters */
                public void onNext(xJ xJVar) {
                    if ((xJVar instanceof xJ.C2298If) || (xJVar instanceof xJ.AUx)) {
                        if (C2283wy.this.f11824.m12301()) {
                            C2283wy.this.f11824.m12292(false);
                            C2283wy.this.f11824.m12294(true);
                        }
                        C2283wy.this.f11803.onNext(xH.C0270.f12004);
                    } else if (xJVar instanceof xJ.C2300auX) {
                        C2283wy.this.f11803.onNext(xH.C2290If.f11987);
                    } else if (xJVar instanceof xJ.C2303iF) {
                        C1300Ac.m3540(new C1080(AppView.playbackControls, null), new C1136());
                        C2283wy.this.m14534().onBackPressed();
                    } else if (xJVar instanceof xJ.C2296AuX) {
                        C1300Ac.m3540(new C1080(AppView.playbackControls, null), new C0659());
                        C2283wy.this.m12706();
                        C2283wy.this.m12699();
                    } else if (xJVar instanceof xJ.C0276) {
                        C1364Cj.m4434(UIViewLogging.UIViewCommandName.viewAudioSubtitlesSelector, IClientLogging.ModalView.audioSubtitlesSelector, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                        C1300Ac.m3540(new C1080(AppView.audioSelector, null), new C0550());
                        C2283wy.this.m12706();
                        C2283wy.this.f11805.m9898(C2283wy.this.m12712());
                        C2283wy.this.f11807 = C2283wy.this.m14534().reportUiModelessViewSessionStart(IClientLogging.ModalView.audioSubtitlesSelector);
                    } else if (xJVar instanceof xJ.C2299aUx) {
                        if (!C2283wy.this.mo2234().m12301()) {
                            boolean r6 = ((xJ.C2299aUx) xJVar).m12783();
                            C2283wy.this.mo2234().m12285(!((xJ.C2299aUx) xJVar).m12782());
                            C2283wy.this.f11803.onNext(new xH.Cif(r6));
                            if (r6) {
                                C1300Ac.m3536(new C1080(AppView.playbackControls, null), true, true, 10000);
                                C2283wy.this.m12615(CommandEndedEvent.InputValue.doubleTap, (int) SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
                                C2283wy.this.m12690(-10000, true);
                                return;
                            }
                            C1300Ac.m3536(new C1080(AppView.playbackControls, null), false, true, 10000);
                            C2283wy.this.m12615(CommandEndedEvent.InputValue.doubleTap, (int) SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
                            C2283wy.this.m12690(SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS, true);
                        }
                    } else if (xJVar instanceof xJ.C2297Aux) {
                        boolean r62 = ((xJ.C2297Aux) xJVar).m12780();
                        int r7 = ((xJ.C2297Aux) xJVar).m12779();
                        if (r62) {
                            C1300Ac.m3540(new C1080(AppView.playbackControls, null), new C0343());
                            C2283wy.this.m12615(CommandEndedEvent.InputValue.touch, r7);
                            C2283wy.this.f11824.f11440 = false;
                            C2283wy.this.f11803.onNext(new xH.C0267());
                            C2283wy.this.m12690(r7, false);
                        } else if (((xJ.C2297Aux) xJVar).m12778()) {
                            C1300Ac.m3536(new C1080(AppView.playbackControls, null), true, false, (long) r7);
                            C2283wy.this.m12615(CommandEndedEvent.InputValue.tap, r7);
                            C2283wy.this.m12690(-r7, true);
                        } else {
                            C1300Ac.m3536(new C1080(AppView.playbackControls, null), false, false, (long) r7);
                            C2283wy.this.m12615(CommandEndedEvent.InputValue.tap, r7);
                            C2283wy.this.m12690(r7, true);
                        }
                    } else if (xJVar instanceof xJ.C0285) {
                        C2283wy.this.mo2240();
                        C2283wy.this.f11803.onNext(new xH.C0266(((xJ.C0285) xJVar).m12787(), ((xJ.C0285) xJVar).m12788(), ((xJ.C0285) xJVar).m12786()));
                    } else if (xJVar instanceof xJ.C0284) {
                        C2283wy.this.m12706();
                        C2283wy.this.mo2234().f11440 = true;
                        C2283wy.this.f11803.onNext(new xH.AUX(((xJ.C0284) xJVar).m12785(), ((xJ.C0284) xJVar).m12784()));
                        C2283wy.this.m12704(false, true);
                        C2283wy.this.m12708();
                    } else if (xJVar instanceof xJ.C0277) {
                        if (C2283wy.this.m12713().mo892()) {
                            C1300Ac.m3540(new C1080(AppView.playbackControls, null), new C1243());
                            C2283wy.this.m12695(true);
                            return;
                        }
                        C1300Ac.m3540(new C1080(AppView.playbackControls, null), new C0519());
                        C2283wy.this.mo2247();
                    } else if (xJVar instanceof xJ.C2301aux) {
                        if (C2283wy.this.m12700() != null) {
                            C1300Ac.m3540(new C1080(AppView.playbackControls, null), new C1263());
                            C2283wy.this.mo2243(new C2279wu(C2283wy.this.m12700(), VideoType.EPISODE, qN.f9509, C2283wy.this.m12700().getPlayableBookmarkPosition()));
                        }
                    } else if (xJVar instanceof xJ.C0281) {
                        C1300Ac.m3540(new C1080(AppView.skipRecapButton, null), new C0513());
                        if (C2283wy.this.f11806.m12375()) {
                            C2283wy.this.m12601();
                        } else if (C2283wy.this.mo2268().getCreditMarks() != null && C2283wy.this.mo2268().getCreditMarks().endRecap() > 0) {
                            C2283wy.this.m12690(C2283wy.this.mo2268().getCreditMarks().endRecap(), false);
                        }
                    } else if (xJVar instanceof xJ.C0286) {
                        C1300Ac.m3540(new C1080(AppView.skipIntroButton, null), new C0513());
                        if (C2283wy.this.mo2268().getCreditMarks() != null) {
                            C2283wy.this.m12690(C2283wy.this.mo2268().getCreditMarks().endCredit(), false);
                        }
                    } else if (xJVar instanceof xJ.C0278) {
                        C2283wy.this.m12707();
                        C2283wy.this.m12693();
                    } else if (xJVar instanceof xJ.IF) {
                        C1300Ac.m3540(new C1080(AppView.playbackControls, null), new C1217());
                        C2283wy.this.m12692(true);
                    } else if (xJVar instanceof xJ.C0287) {
                        C1300Ac.m3540(new C1080(AppView.playbackControls, null), new C1157());
                        C2283wy.this.m12692(false);
                    } else if (xJVar instanceof xF.C0261) {
                        if (C2283wy.this.m14536() != null) {
                            C2283wy.this.m14536().m9764().mo9473(((xF.C0261) xJVar).m12754(), ((xF.C0261) xJVar).m12753());
                        }
                    } else if (xJVar instanceof xF.If) {
                        C2283wy.this.f11822 = Logger.INSTANCE.m142(new C1224(null, AppView.autoPlayInterrupter));
                        C2283wy.this.mo2240();
                        C2283wy.this.f11803.onNext(xH.C2293aux.f11990);
                        C2283wy.this.f11824.m12300(true);
                        C2283wy.this.f11824.m12291(0);
                    } else if (xJVar instanceof xJ.C0282) {
                        if (C2283wy.this.f11822.longValue() > 0) {
                            Logger.INSTANCE.m140(C2283wy.this.f11822);
                        }
                        C2283wy.this.f11824.m12300(false);
                        C2283wy.this.mo2247();
                    } else if (xJVar instanceof xJ.Cif) {
                        if (C2283wy.this.f11822.longValue() > 0) {
                            Logger.INSTANCE.m140(C2283wy.this.f11822);
                        }
                        C2283wy.this.f11824.m12300(false);
                        C2283wy.this.mo2258(0);
                    } else if (xJVar instanceof xJ.C0283) {
                        if (C2283wy.this.f11822.longValue() > 0) {
                            Logger.INSTANCE.m140(C2283wy.this.f11822);
                        }
                        C2283wy.this.f11824.m12300(false);
                        C2283wy.this.mo2248();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    C1276.m16820().mo5730(th);
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                }
            }));
        }
    }

    /* renamed from: ͺॱ  reason: contains not printable characters */
    public CH m12700() {
        return this.f11813;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public void mo2260(String str, VideoType videoType, oX oXVar, int i) {
        if (m14536() != null) {
            m12625(m14536(), str, videoType, oXVar, i);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12625(C2059ph phVar, String str, VideoType videoType, oX oXVar, int i) {
        this.f11814.m12747(phVar, str, videoType, oXVar, i);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m12708();
        if (!m12685()) {
            m12689();
        }
    }

    /* renamed from: ꜞ  reason: contains not printable characters */
    private void m12684() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f11810 = new BroadcastReceiver() { // from class: o.wy.9
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (!C2283wy.this.isDetached()) {
                        C2283wy.this.m12687();
                    }
                }
            };
            activity.registerReceiver(this.f11810, new IntentFilter("ACTION_RELOAD_VIDEO"));
        }
    }

    /* renamed from: ㆍ  reason: contains not printable characters */
    private void m12682() {
        if (this.f11810 != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.unregisterReceiver(this.f11810);
            }
            this.f11810 = null;
        }
    }

    /* renamed from: ᶥ  reason: contains not printable characters */
    private void m12681() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !mo2265()) {
            activity.finish();
        }
    }

    /* renamed from: ꜟ  reason: contains not printable characters */
    private boolean m12685() {
        if (Build.VERSION.SDK_INT < 24 || C1322Av.m3793(getActivity())) {
            return true;
        }
        return !getActivity().isInMultiWindowMode() && !mo2265();
    }

    /* renamed from: ﾟ  reason: contains not printable characters */
    private void m12689() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12648(boolean z) {
        if (this.f11824.f11448 == PlayerFragment.PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            m12695(z);
        }
        m12608();
        if (this.f11835 != null) {
            this.f11835.m12277(2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (m12685()) {
            m12689();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (m12685()) {
            m12648(true);
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (!m12685()) {
            m12648(true);
        }
        super.onStop();
        if (m12628() || m12629()) {
            C1283.m16854("PlayerFragment", "PlayerActivity::onStop done, player is backgrounded");
            return;
        }
        if (this.f11824.f11451.getAndSet(false)) {
            C1283.m16854("PlayerFragment", "Start play is in progress and user canceled playback");
            C1362Ch.m4408(IClientLogging.CompletionReason.canceled, null, null, m12658());
        }
        if (mo2265()) {
            m12603();
        } else {
            mo2248();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f11803.onComplete();
        this.f11812.onNext(EA.f5503);
        this.f11812.onComplete();
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onDestroy() {
        C1283.m16854("PlayerFragment", "====> Destroying PlayerFragment " + hashCode());
        this.f11803.onComplete();
        this.f11812.onNext(EA.f5503);
        this.f11812.onComplete();
        this.f11816.clear();
        NetflixApplication.getInstance().m237().m14204(false);
        if (m12628()) {
            mo2248();
        }
        m12698().getAttributes().buttonBrightness = -1.0f;
        m12655();
        this.f11815.removeCallbacks(this.f11848);
        this.f11815.removeCallbacks(this.f11832);
        if (this.f11835 != null) {
            this.f11835.m12279();
        }
        AbstractC1358Cd.m4359(false);
        if (this.f11827 != null) {
            this.f11827.disable();
        }
        m12682();
        super.onDestroy();
        C1283.m16854("PlayerFragment", "====> Destroying PlayerFragment done");
    }

    /* renamed from: ˏˏ  reason: contains not printable characters */
    public Window m12698() {
        return getActivity().getWindow();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊᐝ */
    public boolean mo2241() {
        return getActivity() != null && AD.m3306(getActivity());
    }

    /* renamed from: ꞌ  reason: contains not printable characters */
    private void m12686() {
        C1283.m16846("PlayerFragment", "Playback verified - completing init process...");
        if (this.f11806.m12371()) {
            C1283.m16850("PlayerFragment", "preplay is fetching content. Waiting for the call back");
            return;
        }
        if (this.f11806.m12378()) {
            this.f11806.m12379();
        }
        if (m12710() == null) {
            C1276.m16820().mo5730(new IllegalStateException("Invalid state, continue init after play verify on a null asset"));
            m12681();
            return;
        }
        m12656();
        m12687();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ﹳ  reason: contains not printable characters */
    private void m12687() {
        if (m12595() && m12710() != null) {
            m12711().setOnStartedListener(this.f11830);
            m12711().setOnPlayProgressListener(this.f11823);
            m12711().setOnCompletionListener(this.f11825);
            m12711().setOnErrorListener(this.f11828);
            m12711().setPlayerSurfaceAvailableListener(this.f11834);
            m12711().setPlayerSurfaceDestroyedListener(this.f11838);
            m12711().setOnStalledListener(this.f11833);
            m12711().setViewInFocus(true);
            m12711().mo2340(m12697(), C1349Bv.m4108(m12710().getPlayableId()), m12631(), AbstractC2055pd.f9383, mo1635(), (long) m12662(), true);
            m12692(m12672() || mo2241());
        }
    }

    /* renamed from: ʹ  reason: contains not printable characters */
    private boolean m12595() {
        if (!m14535() || this.f11811 == null) {
            C1283.m16854("PlayerFragment", "fragment is not valid. ");
            return false;
        }
        pF r2 = this.f11811.m12545();
        if (r2 == null) {
            C1283.m16850("PlayerFragment", "trying to load a video with a null playable.");
            return false;
        }
        C2059ph r3 = m14536();
        if (r3 != null && this.f11811.m12556() == IPlayer.PlaybackType.OfflinePlayback) {
            if (r3.m9774(vO.m12017(m14536(), r2.getPlayableId()))) {
                C1283.m16862("PlayerFragment", "continue with offline player");
            } else {
                C1283.m16862("PlayerFragment", "switching to streaming player");
                this.f11811.m12552(IPlayer.PlaybackType.StreamingPlayback);
                m12657();
            }
        }
        if (!ConnectivityUtils.m2970(getActivity()) && !mo2255()) {
            C1283.m16854("PlayerFragment", "Raising no connectivity warning");
            m12652();
            return false;
        } else if (m12654()) {
            return true;
        } else {
            C1283.m16854("PlayerFragment", "Network check fails");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏˎ  reason: contains not printable characters */
    public oY m12697() {
        m12688();
        this.f11809 = this.f11817.mo7800();
        return this.f11809;
    }

    /* renamed from: ﾞ  reason: contains not printable characters */
    private void m12688() {
        if (this.f11809 != null) {
            if (this.f11817 != null) {
                this.f11817.mo7802(this.f11809);
            } else {
                C1276.m16820().mo5725("releaseVideoGroup but session manager is null");
            }
            this.f11809 = null;
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊॱ */
    public void mo2240() {
        if (C1317As.m3742(NetflixApplication.getInstance())) {
            this.f11804.m2370(PictureInPictureManager.PipAction.PLAY);
        }
        m12695(false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12695(boolean z) {
        m12704(z, false);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12704(boolean z, boolean z2) {
        if (m12619()) {
            C1283.m16862("PlayerFragment", "doPause: volume up or down is pressed, do not pause...");
            return;
        }
        boolean r5 = m12609();
        C1283.m16863("PlayerFragment", "doPause: paused %b", Boolean.valueOf(r5));
        C1283.m16861("playback paused.");
        if (z || r5) {
            m12711().m2350();
            if (this.f11835 != null) {
                this.f11835.m12277(2);
            }
            C1283.m16854("PlayerFragment", "Pause, release awake clock after 2 minutes.");
            this.f11815.postDelayed(this.f11832, 120000);
            this.f11815.postDelayed(this.f11848, 900000);
            C1283.m16862("PlayerFragment", "doPause() remove reporting");
            this.f11803.onNext(xH.C0274.f12008);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12615(CommandEndedEvent.InputValue inputValue, int i) {
        try {
            C1364Cj.m4454(UIViewLogging.UIViewCommandName.seek, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, inputValue, new JSONObject().put("mediaOffset", i));
        } catch (JSONException e) {
            C1276.m16820().mo5729("Error reporting seek to CL", e);
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋॱ */
    public void mo2247() {
        C1283.m16862("PlayerFragment", "unpaused");
        C1283.m16861("playback resumed");
        if (m12709() || m12628()) {
            m12708();
            if (m12628()) {
                this.f11824.m12287(SystemClock.elapsedRealtime());
                m12714();
                m12668(false);
                m12597();
            } else {
                m12711().m2345();
                if (this.f11835 != null) {
                    this.f11835.m12277(3);
                }
            }
            this.f11803.onNext(xH.C0271.f12005);
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʻॱ */
    public C2275wq mo2226() {
        return null;
    }

    /* renamed from: ʻˊ  reason: contains not printable characters */
    private void m12597() {
        if (m12713() != null) {
            m12713().mo919(-5000, 5000);
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    @Deprecated
    /* renamed from: ॱ */
    public void mo2258(int i) {
        m12690(i, false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12690(int i, boolean z) {
        this.f11824.f11442 = true;
        this.f11824.f11454 = true;
        m12624(i, z);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m12624(int i, boolean z) {
        if (z) {
            m12711().m2337(m12711().m2334() + ((long) i));
        } else {
            m12711().m2337((long) i);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12692(boolean z) {
        m12711().setScaleType(z ? ScaleType.ZOOM : ScaleType.CROP);
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.hardKeyboardHidden == 1) {
            C1283.m16854("PlayerFragment", "keyboard out");
        } else if (configuration.hardKeyboardHidden == 2) {
            C1283.m16854("PlayerFragment", "keyboard in");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼˋ  reason: contains not printable characters */
    private void m12602() {
        C1283.m16854("PlayerFragment", "Playout started: " + mo2268());
        C1348Bu.m4093();
        if (this.f11811 == null || this.f11811.m12545() == null || C1317As.m3750(getActivity())) {
            if (m14535()) {
                UIError uIError = new UIError(RootCause.clientFailure, ActionOnUIError.handledSilently, null, null);
                if (this.f11820.longValue() > 0) {
                    Logger.INSTANCE.m145(this.f11820, new C0510(RootCause.clientFailure.toString()));
                }
                C1362Ch.m4408(IClientLogging.CompletionReason.failed, uIError, null, m12658());
            }
            this.f11824.f11451.set(false);
            mo2248();
            return;
        }
        m12711().setSubtitleVisiblity(true);
        m12711().setVolume(1.0f);
        m12599();
        Language r4 = m12712();
        if (r4 == null) {
            r4 = C1344Bq.m4069(getContext(), m12713());
        }
        m12635(r4);
        C1283.m16861((mo2255() ? "Offline" : "Streaming") + " playback started");
    }

    /* renamed from: ʻᐝ  reason: contains not printable characters */
    private void m12599() {
        C1283.m16854("PlayerFragment", "handleEveryPlaybackStart.");
        int r9 = m12713() != null ? (int) m12713().mo928() : 0;
        long r10 = this.f11811 != null ? this.f11811.m12548() : 0;
        C1283.m16851("PlayerFragment", "handleEveryPlaybackStart, position: %d,  duration: %d", Integer.valueOf(r9), Long.valueOf(r10));
        this.f11824.f11457 = true;
        m12674();
        this.f11803.onNext(new xH.Con(this.f11811, r9, (int) r10, m12713(), mo2265(), this.f11806.m12375(), mo2234().m12298()));
        C1362Ch.m4408(IClientLogging.CompletionReason.success, null, null, m12658());
        this.f11824.f11451.set(false);
        m12620();
        if (C1317As.m3742(NetflixApplication.getInstance())) {
            this.f11804.m2370(PictureInPictureManager.PipAction.PAUSE);
        }
        if (this.f11835 != null) {
            this.f11835.m12278();
        }
        if (this.f11824.f11454) {
            C1283.m16854("PlayerFragment", "Dismissing buffering progress bar...");
            this.f11824.f11442 = false;
            this.f11824.f11444 = false;
            this.f11824.f11454 = false;
            m12708();
        }
        this.f11808 = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻˋ  reason: contains not printable characters */
    private boolean m12598() {
        C1283.m16854("PlayerFragment", "canExitPlaybackEndOfPlay");
        if (this.f11824.m12301()) {
            C1283.m16854("PlayerFragment", "canExitPlaybackEndOfPlay - isInPostPlayState");
            this.f11803.onNext(xH.IF.f11986);
            return false;
        } else if (!this.f11824.m12302()) {
            return true;
        } else {
            C1283.m16854("PlayerFragment", "canExitPlaybackEndOfPlay - wasPostPlayDismissed");
            mo2249();
            this.f11803.onNext(xH.IF.f11986);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼˊ  reason: contains not printable characters */
    private void m12601() {
        C1283.m16854("PlayerFragment", "onCompletion, check if we are in postplay or in preplay");
        m12706();
        if (this.f11820.longValue() > 0) {
            Logger.INSTANCE.m140(this.f11820);
        }
        if (!m12598()) {
            C1283.m16854("PlayerFragment", "onCompletion, In PostPlay, allow screen to lock after timeout...");
            this.f11815.postDelayed(this.f11832, 120000);
        } else if (this.f11806.m12375()) {
            C1283.m16854("PlayerFragment", "OnCompletion of preplay.");
            C2279wu r9 = this.f11806.m12373();
            mo2248();
            if (r9 != null) {
                PlaybackLauncher.m1610(m14534(), r9.m12545(), r9.m12546(), r9.m12563(), r9.m12555(), true, r9.m12550(), r9.m12559(), true);
            }
        } else {
            C1283.m16854("PlayerFragment", "OnCompletion - exiting.");
            m12691((C2279wu) null, PlaybackLauncher.PlayLaunchedBy.LaunchActivity);
            if (mo2265()) {
                m12603();
            } else {
                mo2248();
            }
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʿ */
    public void mo2232() {
        C1283.m16862("PlayerFragment", "performUpAction");
        NetflixActivity r3 = m14534();
        if (r3 != null) {
            C1364Cj.m4442(UIViewLogging.UIViewCommandName.actionBarBackButton, r3.getUiScreen().f4084, r3.getDataContext());
        }
        C1300Ac.m3540(new C1080(AppView.playbackControls, null), new C1085());
        C2279wu r4 = this.f11806.m12375() ? this.f11806.m12373() : this.f11811;
        m12607();
        m12691(r4, PlaybackLauncher.PlayLaunchedBy.LaunchActivity, PlaybackLauncher.PlayLaunchedBy.HomeScreen);
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊ */
    public boolean mo2237(PlaybackLauncher.PlayLaunchedBy... playLaunchedByArr) {
        NetflixActivity r5 = m14534();
        if (r5 == null) {
            return false;
        }
        Intent intent = r5.getIntent();
        if (!intent.hasExtra("play_launched_by")) {
            return false;
        }
        int intExtra = intent.getIntExtra("play_launched_by", PlaybackLauncher.PlayLaunchedBy.Unknown.ordinal());
        C1283.m16863("PlayerFragment", "launchDetailScreenIfRequired launchedBy=%d", Integer.valueOf(intExtra));
        if (intExtra < 0 || intExtra >= PlaybackLauncher.PlayLaunchedBy.values().length) {
            return false;
        }
        PlaybackLauncher.PlayLaunchedBy playLaunchedBy = PlaybackLauncher.PlayLaunchedBy.values()[intExtra];
        for (PlaybackLauncher.PlayLaunchedBy playLaunchedBy2 : playLaunchedByArr) {
            if (playLaunchedBy == playLaunchedBy2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12691(C2279wu wuVar, PlaybackLauncher.PlayLaunchedBy... playLaunchedByArr) {
        if (wuVar != null && m14534() != null) {
            boolean z = mo2237(playLaunchedByArr) || this.f11840;
            C1283.m16863("PlayerFragment", "launchDetailScreenIfRequired launchDetailsScreen=%b", Boolean.valueOf(z));
            if (z) {
                oX r8 = wuVar.m12563();
                if (wuVar.m12545() != null) {
                    VideoType r9 = wuVar.m12546();
                    if (r9 == VideoType.EPISODE) {
                        r9 = VideoType.SHOW;
                    }
                    if (this.f11840) {
                        m14534().finishAndRemoveTask();
                    }
                    qU.m9966(m14534(), r9, wuVar.m12545().getTopLevelId(), wuVar.m12545().getParentTitle(), r8, "PlayerFragment");
                }
            }
        }
    }

    /* renamed from: ʽᐝ  reason: contains not printable characters */
    private void m12607() {
        m12645(IClientLogging.CompletionReason.success);
        if (m12628()) {
            m12668(false);
        }
        m12606();
        m12706();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋᐝ */
    public void mo2248() {
        C1283.m16854("PlayerFragment", "cleanupAndExit");
        m12607();
        this.f11824.f11448 = PlayerFragment.PlayerFragmentState.ACTIVITY_NOTREADY;
        C1283.m16854("PlayerFragment", "cleanupAndExit calling finish");
        if (!C1317As.m3750(m14534()) && !getActivity().isChangingConfigurations()) {
            m12681();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼᐝ  reason: contains not printable characters */
    private void m12603() {
        FragmentActivity activity;
        C1283.m16854("PlayerFragment", "cleanupAndExit");
        m12607();
        this.f11824.f11448 = PlayerFragment.PlayerFragmentState.ACTIVITY_NOTREADY;
        C1283.m16854("PlayerFragment", "cleanupAndExit calling finish");
        if (!C1317As.m3750(m14534()) && !getActivity().isChangingConfigurations() && (activity = getActivity()) != null && !activity.isFinishing() && mo2265()) {
            activity.finishAndRemoveTask();
        }
    }

    /* renamed from: ʽˋ  reason: contains not printable characters */
    private void m12606() {
        C1283.m16854("PlayerFragment", "stopPlayback");
        if (this.f11824.f11451.getAndSet(false)) {
            C1283.m16854("PlayerFragment", "Start play is in progress and user canceled playback");
            C1362Ch.m4408(IClientLogging.CompletionReason.canceled, null, null, m12658());
        }
        if (this.f11824.f11448 == PlayerFragment.PlayerFragmentState.ACTIVITY_SRVCMNGR_READY || this.f11824.f11448 == PlayerFragment.PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            m12657();
            this.f11824.f11448 = PlayerFragment.PlayerFragmentState.ACTIVITY_NOTREADY;
            if (this.f11811 != null) {
                m12605();
            }
        }
        this.f11811 = null;
        if (this.f11835 != null) {
            this.f11835.m12280();
        }
    }

    /* renamed from: ʽˊ  reason: contains not printable characters */
    private void m12605() {
        if (m14535() && this.f11811 != null && this.f11811.m12545() != null) {
            if (this.f11820.longValue() > 0) {
                Logger.INSTANCE.m129(this.f11820);
            }
            C1306Ah.m3615().m3622(this.f11811.m12545().isPinProtected(), this.f11811.m12545().isPreviewProtected());
            getActivity().sendBroadcast(m12612("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP", this.f11811));
            m12608();
            C1283.m16846("PlayerFragment", "Intent PLAYER_PLAY_STOP sent");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private Intent m12612(String str, C2279wu wuVar) {
        return C2058pg.m9730(str, wuVar.m12545().getPlayableId(), wuVar.m12556(), wuVar.m12546(), wuVar.m12555(), wuVar.m12558().mo9715());
    }

    /* renamed from: ʾॱ  reason: contains not printable characters */
    private void m12608() {
        vO.m12015(m14536(), m12610(), this.f11811 == null ? null : C2052pa.m9718(this.f11811.m12562(), this.f11811.m12555()));
    }

    /* renamed from: ˈॱ  reason: contains not printable characters */
    private String m12610() {
        C2059ph r1 = m14536();
        if (r1 != null) {
            return r1.m9835();
        }
        return null;
    }

    /* renamed from: ˊʼ  reason: contains not printable characters */
    private boolean m12619() {
        return System.currentTimeMillis() - this.f11824.f11455 < 500;
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    public void m12699() {
        NetflixActivity r4 = m14534();
        if (r4 != null && !C1317As.m3750(r4) && this.f11811 != null) {
            pF r5 = this.f11811.m12545();
            this.f11844 = C2116re.m10364(r5.getTopLevelId(), r5.getPlayableId(), false);
            this.f11844.onManagerReady(m14536(), AbstractC0367.f13235);
            this.f11844.setCancelable(true);
            this.f11844.setStyle(1, R.style.res_2131951876_netflixdialog_episodes);
            this.f11844.m14471(m12698().getDecorView().getSystemUiVisibility());
            if (this.f11844 instanceof C2172tc) {
                ((C2172tc) this.f11844).m11100(r5.getTopLevelId(), r5.getPlayableId());
            }
            m12605();
            r4.showDialog(this.f11844);
            C1364Cj.m4434(UIViewLogging.UIViewCommandName.viewEpisodesSelector, IClientLogging.ModalView.episodesSelector, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12614(Language language) {
        if (m14535()) {
            C1355Ca.m4328(getActivity(), language);
            AudioSource selectedAudio = language.getSelectedAudio();
            Subtitle selectedSubtitle = language.getSelectedSubtitle();
            boolean z = false;
            if (selectedSubtitle == null) {
                C1283.m16854("PlayerFragment", "Selected subtitle is NONE");
                z = true;
            }
            if (selectedAudio.getNccpOrderNumber() != language.getCurrentNccpAudioIndex()) {
                z = true;
                C1283.m16854("PlayerFragment", "Start change language, get awake clock");
            } else {
                C1283.m16854("PlayerFragment", "No need to change audio.");
            }
            if (selectedSubtitle == null) {
                C1283.m16854("PlayerFragment", "Subtitle is off");
                z = true;
            } else if (selectedSubtitle.getNccpOrderNumber() != language.getCurrentNccpSubtitleIndex()) {
                z = true;
            } else {
                C1283.m16854("PlayerFragment", "No need to change subtitle.");
            }
            if (z) {
                C1283.m16854("PlayerFragment", "Reloading tracks");
                m12703(language);
                return;
            }
            C1283.m16854("PlayerFragment", "No need to switch tracks");
            mo2247();
            m12701();
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ͺ */
    public void mo2256() {
        m12644(-30000);
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱˊ */
    public void mo2264() {
        m12644(30000);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12644(int i) {
        this.f11824.m12287(SystemClock.elapsedRealtime());
        m12714();
        C1364Cj.m4434(UIViewLogging.UIViewCommandName.seek, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
        m12690(i, true);
    }

    @Override // o.C0567.Cif
    public void N_() {
        DialogFragment dialogFragment = m14534().getDialogFragment();
        if (dialogFragment instanceof C0567.Cif) {
            ((C0567.Cif) dialogFragment).N_();
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊˋ */
    public C2279wu mo2239() {
        return this.f11806.m12375() ? this.f11806.m12373() : this.f11811;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʿॱ  reason: contains not printable characters */
    private boolean m12609() {
        return m12711().m2347();
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        if (!m14535()) {
            C1283.m16865("PlayerFragment", "onManagerReady() was called when activity is already not in valid state - skipping...");
            return;
        }
        C1348Bu.m4093();
        this.f11824.f11448 = PlayerFragment.PlayerFragmentState.ACTIVITY_SRVCMNGR_READY;
        this.f11817 = phVar.m9759();
        Bundle arguments = getArguments();
        if (this.f11811 == null) {
            if (arguments == null) {
                C1276.m16820().mo5730(new IllegalStateException("Bundle is empty, no video ID to play"));
                m12681();
                return;
            }
            String string = arguments.getString(NetflixActivity.EXTRA_VIDEO_ID);
            if (C1349Bv.m4113(string)) {
                C1276.m16820().mo5730(new IllegalStateException("unable to start playback with invalid video id"));
                m12681();
                return;
            }
            VideoType create = VideoType.create(arguments.getString(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE));
            if (create == null) {
                C1276.m16820().mo5730(new IllegalStateException("unable to start playback with invalid video type"));
                m12681();
                return;
            }
            oX oXVar = (oX) arguments.getParcelable(NetflixActivity.EXTRA_PLAY_CONTEXT);
            if (oXVar == null) {
                C1276.m16820().mo5725("Empty context passed in intent");
                oXVar = new oB("PlayerFragment");
            }
            m12625(phVar, string, create, oXVar, arguments.getInt("extra_bookmark_seconds_from_start_param", -1));
        }
        if (arguments != null) {
            this.f11824.m12291(arguments.getInt("EXTRA_AUTO_PLAY_COUNT", 0));
        }
        if (phVar.m9756() != null) {
            phVar.m9756().mo5361();
        }
        if (getActivity() != null) {
            C1328Ba.m3985(phVar, getActivity().getIntent());
        }
        this.f11841 = phVar.m9827();
        if (this.f11841 == null) {
            C1283.m16854("PlayerFragment", "Unable to receive handle to config, finishing activity ");
            m12681();
            return;
        }
        m12687();
        mo2233();
        phVar.m9754();
        qX.m10015(m14536());
        m12618();
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
        C1283.m16850("PlayerFragment", "NetflixService is NOT available!");
        mo2248();
    }

    /* renamed from: ˊʻ  reason: contains not printable characters */
    private void m12618() {
        m14534().registerReceiverWithAutoUnregister(this.f11849, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        m14534().registerReceiverWithAutoUnregister(this.f11847, wD.m12273());
        m14534().registerReceiverWithAutoUnregister(this.f11851, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        m14534().registerReceiverWithAutoUnregister(this.f11843, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        m14534().registerReceiverWithAutoUnregister(this.f11842, new IntentFilter("com.netflix.mediaclient.intent.action.END_PIP"));
        m12611();
    }

    /* renamed from: ˉॱ  reason: contains not printable characters */
    private void m12611() {
        this.f11827 = new OrientationEventListener(getActivity()) { // from class: o.wy.14

            /* renamed from: ˎ  reason: contains not printable characters */
            final int f11860 = 10;

            /* renamed from: ˏ  reason: contains not printable characters */
            int f11861;

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                if (C2283wy.this.m14535() && i != -1) {
                    if (Math.abs(i - this.f11861) > 10) {
                        C2283wy.this.m12714();
                    }
                    this.f11861 = i;
                }
            }
        };
        this.f11827.enable();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12634(int i) {
        this.f11815.removeCallbacks(this.f11846);
        this.f11815.postDelayed(this.f11846, (long) i);
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱˋ */
    public boolean mo2265() {
        return C1317As.m3742(NetflixApplication.getInstance()) && this.f11804.m2368();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12668(boolean z) {
        this.f11837 = z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋʼ  reason: contains not printable characters */
    private boolean m12628() {
        return this.f11837;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋʽ  reason: contains not printable characters */
    private boolean m12629() {
        return m14535() && m12711().m2332() && !m12696() && !mo2234().m12301() && this.f11841 != null && !this.f11841.mo16548() && this.f11841.mo16520().mo14183();
    }

    /* renamed from: ˋʻ  reason: contains not printable characters */
    private boolean m12627() {
        return m14535() && C1317As.m3742(getActivity()) && m12711().m2332() && !m12696() && !mo2234().m12301();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱᐝ */
    public pF mo2268() {
        if (this.f11811 == null) {
            return null;
        }
        return this.f11811.m12545();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˌॱ  reason: contains not printable characters */
    private VideoType m12631() {
        if (this.f11811 == null) {
            return VideoType.UNKNOWN;
        }
        return this.f11811.m12546();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12635(Language language) {
        if (language == null) {
            C1283.m16865("PlayerFragment", "Language is null!");
            return;
        }
        C1283.m16854("PlayerFragment", "Sets language");
        this.f11819 = language;
    }

    /* renamed from: ˊʽ  reason: contains not printable characters */
    private void m12620() {
        if (m14535()) {
            this.f11824.m12287(SystemClock.elapsedRealtime());
            m12701();
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊ */
    public void mo2236(boolean z) {
        C1283.m16854("PlayerFragment", "onWindowFocusChanged done");
        C1283.m16854("PlayerFragment", "====> In focus: " + z);
        if (m14535() && m12685()) {
            if (m12713() != null) {
                if (z) {
                    mo2247();
                } else {
                    mo2240();
                }
            }
            C1283.m16854("PlayerFragment", "onWindowFocusChanged done");
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public boolean mo2263(int i, KeyEvent keyEvent) {
        if (i != 62 && i != 66) {
            return false;
        }
        if (m12711().m2347()) {
            m12695(true);
            return true;
        }
        mo2247();
        return true;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˏ */
    public boolean mo2254(int i, KeyEvent keyEvent) {
        this.f11824.m12287(SystemClock.elapsedRealtime());
        m12714();
        if (i == 4) {
            if (this.f11824.m12290()) {
                C1283.m16854("PlayerFragment", "Back used to dismiss interrupter overlay, send it back to framework");
                return false;
            }
            C1283.m16854("PlayerFragment", "Back...");
            mo2231();
            mo2248();
            return true;
        } else if (i == 84) {
            return true;
        } else {
            if (i == 82) {
                keyEvent.startTracking();
                return true;
            } else if (m12641(i, keyEvent)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m12641(int i, KeyEvent keyEvent) {
        if (i == 96) {
            if (keyEvent.getRepeatCount() > 0) {
                return false;
            }
            C1283.m16846("PlayerFragment", "A button pressed");
            this.f11831.onClick(null);
            return true;
        } else if (i == 21 || i == 102) {
            if (this.f11824.f11448 != PlayerFragment.PlayerFragmentState.ACTIVITY_PLAYER_READY) {
                return false;
            }
            mo2256();
            return true;
        } else if (i == 22 || i == 103) {
            if (this.f11824.f11448 != PlayerFragment.PlayerFragmentState.ACTIVITY_PLAYER_READY) {
                return false;
            }
            mo2264();
            return true;
        } else if (i == 93) {
            if (m12713() == null || !m12713().mo892()) {
                return true;
            }
            m12695(true);
            return true;
        } else if (i == 92) {
            if (m12713() == null || m12713().mo892()) {
                return true;
            }
            mo2247();
            return true;
        } else if (i == 41) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            AudioManager audioManager = (AudioManager) getActivity().getSystemService("audio");
            if (audioManager != null) {
                audioManager.adjustStreamVolume(3, 101, 5);
                return true;
            }
            C1283.m16850("PlayerFragment", "Audio manager is not available, can not change volume");
            return false;
        } else if (i == 19) {
            AudioManager audioManager2 = (AudioManager) getActivity().getSystemService("audio");
            if (audioManager2 != null) {
                audioManager2.adjustStreamVolume(3, 1, 5);
                return true;
            }
            C1283.m16850("PlayerFragment", "Audio manager not available, cannot change volume");
            return false;
        } else if (i != 20) {
            return false;
        } else {
            AudioManager audioManager3 = (AudioManager) getActivity().getSystemService("audio");
            if (audioManager3 != null) {
                audioManager3.adjustStreamVolume(3, -1, 5);
                return true;
            }
            C1283.m16850("PlayerFragment", "Audio manager not available, cannot change volume");
            return false;
        }
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    public boolean m12696() {
        return m12713() != null && this.f11824.f11442;
    }

    /* renamed from: ॱͺ  reason: contains not printable characters */
    public boolean m12709() {
        return m12713() != null && !m12713().mo892();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˏ */
    public String mo2252(int i, String str) {
        return super.getString(i, str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12703(Language language) {
        C1348Bu.m4093();
        if (language != null) {
            m12635(language);
            m12711().setAudioTrack(language.getSelectedAudio());
            m12711().setSubtitleTrack(language.getSelectedSubtitle());
            language.commit();
        }
        C1283.m16854("PlayerFragment", "Language change should be completed");
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˉ */
    public wG mo2234() {
        return this.f11824;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊ */
    public void mo2235(Runnable runnable) {
        this.f11836.post(runnable);
    }

    /* renamed from: ॱʼ  reason: contains not printable characters */
    public void m12707() {
        this.f11824.m12287(SystemClock.elapsedRealtime());
        m12714();
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f11808;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˈ */
    public void mo2233() {
        if (m14536() == null || m14536().m9811() == null || this.f11841 == null) {
            m12637((uW) null);
            return;
        }
        Pair<String, String>[] r2 = m14536().m9811().mo6163();
        if (r2 == null || r2.length < 1) {
            m12637((uW) null);
        } else {
            m12637(m12623(r2, m14536().m9811().mo6171(), this.f11841));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private uW m12623(Pair<String, String>[] pairArr, String str, AbstractC1221 r6) {
        return new uW(pairArr, str, (r6 != null ? r6.mo16520() : this.f11841.mo16520()).mo14182());
    }

    /* renamed from: ˏͺ  reason: contains not printable characters */
    private void m12650() {
        C1348Bu.m4093();
        m14534().displayDialog(C0505.m14491(getActivity(), this.f11815, new C1278(null, getString(R.string.label_nowifi_warning), getString(R.string.label_ok), this.f11850)));
    }

    /* renamed from: ˎͺ  reason: contains not printable characters */
    private void m12643() {
        m14534().displayDialog(C0505.m14491(getActivity(), this.f11815, new C1278(null, getString(R.string.label_slow_connection), getString(R.string.label_ok), this.f11850)));
    }

    /* renamed from: ˑॱ  reason: contains not printable characters */
    private void m12652() {
        m14534().displayDialog(C0505.m14491(getActivity(), this.f11815, new C1278(null, getString(R.string.label_startup_nointernet), getString(R.string.label_ok), this.f11850)));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺˎ  reason: contains not printable characters */
    private boolean m12654() {
        C1283.m16862("PlayerFragment", "Check connection");
        if (mo2255()) {
            C1283.m16862("PlayerFragment", "offline playback network is not needed.");
            return true;
        }
        LogMobileType r3 = ConnectivityUtils.m2956(m14534());
        if (r3 == null) {
            C1283.m16862("PlayerFragment", "No internet connection. Since this is expected state on Verizons' phones, skip");
            return true;
        } else if (r3 == LogMobileType._2G) {
            C1283.m16862("PlayerFragment", "2G only, alert");
            m12643();
            return false;
        } else if (r3 == LogMobileType.WIFI) {
            C1283.m16862("PlayerFragment", "WiFi connection, do playback");
            return true;
        } else {
            boolean r4 = C0577.m14688(getActivity());
            C1283.m16862("PlayerFragment", "3G Preference setting: " + r4);
            if (r4) {
                C1283.m16865("PlayerFragment", "We should warn user if he is on NON WIFI network!");
                m12650();
                return false;
            }
            C1283.m16854("PlayerFragment", "Warning is not required, proceed with playback");
            return true;
        }
    }

    /* renamed from: ـ  reason: contains not printable characters */
    public void m12701() {
        m12634(1000);
        C1283.m16854("PlayerFragment", "===>> Screen update thread started");
    }

    /* renamed from: ॱʻ  reason: contains not printable characters */
    public void m12706() {
        this.f11815.removeCallbacks(this.f11846);
        C1283.m16854("PlayerFragment", "===>> Screen update thread canceled");
    }

    /* renamed from: ॱʽ  reason: contains not printable characters */
    public void m12708() {
        if (m14535()) {
            C1283.m16854("PlayerFragment", "KEEP_SCREEN: ON");
            m12698().addFlags(128);
        }
        this.f11815.removeCallbacks(this.f11848);
        this.f11815.removeCallbacks(this.f11832);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺˏ  reason: contains not printable characters */
    private void m12655() {
        if (m14535()) {
            C1283.m16854("PlayerFragment", "KEEP_SCREEN: OFF");
            m12698().clearFlags(128);
        }
    }

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    public Language m12712() {
        return this.f11819;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12613(long j) {
        if (m14535() && this.f11811 != null) {
            if (this.f11811.m12545() != null) {
                C1306Ah.m3615().m3622(this.f11811.m12545().isPinProtected(), this.f11811.m12545().isPreviewProtected());
            }
            if (m12609() && m12713() != null) {
                this.f11811.m12551((int) (m12713().mo928() / 1000));
            }
            if (m12642(j)) {
                this.f11811.m12553(true);
                this.f11803.onNext(new xH.C2288AuX(PostPlayFactory.m2595(this), this.f11811));
            }
            this.f11803.onNext(new xH.C0265(j, this.f11811.m12548()));
            if (mo2268() != null && mo2268().getCreditMarks() != null) {
                if (wY.m12388(mo2268().getCreditMarks(), j, m12671())) {
                    this.f11803.onNext(xH.C2287AUx.f11975);
                } else if (wY.m12387(mo2268().getCreditMarks(), j, m12671())) {
                    this.f11803.onNext(xH.C0262.f11994);
                } else {
                    this.f11803.onNext(xH.C2289Aux.f11978);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12646(final IPlayer.aux aux) {
        C2059ph r6;
        this.f11824.f11448 = PlayerFragment.PlayerFragmentState.ACTIVITY_NOTREADY;
        if (aux instanceof C1935kf) {
            mo2235(new Runnable() { // from class: o.wy.24
                @Override // java.lang.Runnable
                public void run() {
                    final NetflixActivity r1 = C2283wy.this.m14534();
                    if (r1 != null && !C2283wy.this.isDetached()) {
                        r1.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.wy.24.4
                            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                            public void run(C2059ph phVar) {
                                vV r2 = vV.f11264.m12080((C1935kf) aux);
                                r2.onManagerReady(C2283wy.this.m14536(), AbstractC0367.f13235);
                                r2.setCancelable(true);
                                r1.showDialog(r2);
                                C2283wy.this.mo2266();
                            }
                        });
                    }
                }
            });
        } else if (aux instanceof C1931kb) {
            mo2235(new Runnable() { // from class: o.wy.25
                @Override // java.lang.Runnable
                public void run() {
                    NetflixActivity r3 = C2283wy.this.m14534();
                    if (r3 != null && !C2283wy.this.isDetached()) {
                        if (AD.m3292()) {
                            r3.setRequestedOrientation(1);
                        }
                        zW r4 = zW.f12754.m13575(C2283wy.this.m14534(), ((C1931kb) aux).m8375());
                        r4.setCancelable(true);
                        r4.m13570(new DialogInterface() { // from class: o.wy.25.4
                            @Override // android.content.DialogInterface
                            public void cancel() {
                                C2283wy.this.mo2248();
                            }

                            @Override // android.content.DialogInterface
                            public void dismiss() {
                                C2283wy.this.mo2248();
                            }
                        });
                        r3.showDialog(r4);
                    }
                }
            });
        } else {
            if (this.f11820.longValue() > 0) {
                Logger.INSTANCE.m145(this.f11820, new C0510(String.valueOf(aux.mo998())));
            }
            m12688();
            AbstractC1268 r4 = C2316xl.m12949(this, aux);
            if (r4 != null && r4.mo10135() != null && (r6 = m14536()) != null && r6.m9756() != null) {
                r6.m9756().mo5362(r4);
            }
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊˊ */
    public Handler mo2238() {
        return this.f11815;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public void mo2261(pF pFVar, VideoType videoType, oX oXVar, boolean z, boolean z2, int i, boolean z3) {
        if (!m14535()) {
            C1283.m16854("PlayerFragment", "Activity already destroyed, ignore next!");
            return;
        }
        C1283.m16854("PlayerFragment", "playable to play next: " + pFVar);
        if (C1349Bv.m4113(pFVar.getPlayableId())) {
            C1283.m16850("PlayerFragment", "PlayableId is null - skip playback");
            C1276.m16820().mo5727("PlayableId is null - skip playback");
            return;
        }
        if (z) {
            this.f11824.m12284();
        }
        int r9 = this.f11824.m12283();
        mo2248();
        PlaybackLauncher.m1609(m14534(), pFVar, videoType, oXVar, i, z3, false, false, r9);
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʽॱ */
    public qO.Cif mo2230() {
        return this.f11852;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱˎ */
    public void mo2266() {
        if (m12713() != null) {
            m12713().mo931();
        }
        m12657();
        this.f11824.f11446 = false;
    }

    /* renamed from: י  reason: contains not printable characters */
    private void m12657() {
        m12711().m2327();
        m12688();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ٴ  reason: contains not printable characters */
    private void m12659() {
        if (m14534().isDialogFragmentVisible()) {
            m14534().removeDialogFrag();
        }
    }

    @Override // o.AbstractC0496.Cif, com.netflix.mediaclient.ui.player.IPlayerFragment
    public AbstractC0496.iF ab_() {
        return this.f11853;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʾ */
    public boolean mo2231() {
        C1283.m16862("PlayerFragment", "handleBackPressed");
        if (this.f11824.m12290()) {
            this.f11824.m12300(false);
            if (this.f11822.longValue() > 0) {
                Logger.INSTANCE.m129(this.f11822);
            }
            mo2247();
            return true;
        }
        C2279wu r4 = this.f11806.m12375() ? this.f11806.m12373() : this.f11811;
        m12607();
        m12691(r4, PlaybackLauncher.PlayLaunchedBy.LaunchActivity);
        return false;
    }

    /* renamed from: ߴ  reason: contains not printable characters */
    private void m12660() {
        if (this.f11811 != null) {
            pF r9 = this.f11811.m12545();
            if (r9.isAgeProtected() || !this.f11811.m12559()) {
                C1305Ag.m3609(m14534(), r9.isAgeProtected(), new PlayVerifierVault(PlayVerifierVault.RequestedBy.PLAYER.m2951(), r9.getPlayableId(), r9.isPreviewProtected(), r9.isPinProtected(), this.f11811.m12546(), this.f11811.m12556() == IPlayer.PlaybackType.StreamingPlayback, this.f11811.m12563(), this.f11811.m12555()));
                return;
            }
            C1283.m16854("PlayerFragment", String.format("nf_pin PlayerActivity pinVerification skipped - ageProtected: %b, pinVerified:%b, pinProtected:%b", Boolean.valueOf(r9.isAgeProtected()), Boolean.valueOf(this.f11811.m12559()), Boolean.valueOf(r9.isPinProtected())));
            m12686();
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋ */
    public void mo2244(boolean z, PlayVerifierVault playVerifierVault) {
        C1283.m16854("nf_pin", String.format("%s onPlayVerification vault: %s", PlayerFragment.class.getSimpleName(), playVerifierVault));
        if (this.f11811 == null) {
            C1276.m16820().mo5725("playback called on null playback item");
            mo2248();
        } else if (!z || !PlayVerifierVault.RequestedBy.PLAYER.m2951().equals(playVerifierVault.m2945())) {
            C1283.m16854("PlayerFragment", "Age/Pin verification failed cannot proceed - close playback");
            mo2248();
        } else {
            this.f11811.m12549(true);
            m12686();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12664(pT pTVar, IPlayer.PlaybackType playbackType, oX oXVar, int i, boolean z) {
        if (m14535()) {
            if (!z && pTVar != null) {
                this.f11811 = new C2279wu(pTVar.getPlayable(), pTVar.getType(), oXVar, i);
            }
            if (pTVar != null) {
                m12636(pTVar);
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f11811.m12557(arguments.getBoolean("advisory_disabled", false));
                this.f11811.m12561(arguments.getBoolean("SeamlessMode", false));
                this.f11811.m12549(arguments.getBoolean("is_pin_verified", false));
                if (!arguments.getBoolean("extra_skip_preplay", false) && !z) {
                    this.f11806.m12374(this.f11811);
                }
            }
            if (pTVar != null) {
                this.f11813 = C1841h.m6800(pTVar);
            }
            if (playbackType == IPlayer.PlaybackType.OfflinePlayback && pTVar != null) {
                C2052pa r5 = vO.m12023(m14536(), m12610(), pTVar.getPlayable().getPlayableId());
                pF playable = pTVar.getPlayable();
                if (!(r5 == null || playable == null)) {
                    this.f11811.m12551(C1352By.m4135(r5.mBookmarkInSecond, playable.getEndtime(), playable.getRuntime()));
                }
            } else if (!z && this.f11806.m12372()) {
                C1283.m16854("PlayerFragment", "Need to fetch pre-play, aborting playback to fetch it.");
                this.f11806.m12377(pTVar);
                return;
            }
            if (!(this.f11835 == null || pTVar == null)) {
                this.f11835.m12281(pTVar);
            }
            pV r52 = vO.m12017(m14536(), this.f11811.m12545().getPlayableId());
            if (m14536().m9774(r52)) {
                this.f11811.m12552(IPlayer.PlaybackType.OfflinePlayback);
                DialogC1104.Cif r6 = m12633(r52.mo6912());
                if (r6 != null) {
                    m14534().displayDialog(r6);
                    return;
                }
            } else {
                this.f11811.m12552(IPlayer.PlaybackType.StreamingPlayback);
            }
            m12678();
            m12660();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12636(pT pTVar) {
        if (f11802 == null) {
            f11802 = new wD(getActivity().getApplicationContext());
        }
        f11802.m12275(pTVar, m14536().m9838(), m14536().m9839());
        this.f11817.mo7797(f11802);
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public void mo2262(pT pTVar, Status status, IPlayer.PlaybackType playbackType) {
        if (m14535()) {
            this.f11811 = this.f11806.m12376();
            if (status.mo301() || pTVar == null || this.f11811 == null) {
                C1283.m16850("PlayerFragment", "unable to fetch preplay experience details. going with main playback");
                this.f11811 = this.f11806.m12373();
            }
            if (this.f11811 != null) {
                m12664(pTVar, playbackType, this.f11811.m12563(), this.f11811.m12555(), true);
            }
        }
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    public oM m12713() {
        return m12711().m2333();
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        if (this.f11811 != null) {
            return this.f11811.m12563();
        }
        if (getArguments() == null) {
            return new oB("PlayerFragment");
        }
        oX oXVar = (oX) getArguments().getParcelable(NetflixActivity.EXTRA_PLAY_CONTEXT);
        return oXVar == null ? new oB("PlayerFragment") : oXVar;
    }

    /* renamed from: ـॱ  reason: contains not printable characters */
    private PlayLocationType m12658() {
        return mo1635().mo9590();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋˊ */
    public AbstractC1978mi mo2245() {
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private DialogC1104.Cif m12633(WatchState watchState) {
        int i = -1;
        int i2 = -1;
        switch (watchState) {
            case NOT_WATCHABLE_DUE_TO_NOT_ENOUGH_DATA:
                i = R.string.offline_not_enough_data;
                i2 = R.string.offline_message_no_available_title;
                break;
            case LICENSE_EXPIRED:
                i2 = R.string.offline_message_expired_offline_title;
                if (!ConnectivityUtils.m2954(getActivity())) {
                    i = R.string.offline_message_expired_to_renew_description;
                    break;
                } else {
                    i = R.string.offline_license_expired_online;
                    break;
                }
            case PLAY_WINDOW_EXPIRED_BUT_RENEWABLE:
                i2 = R.string.offline_message_expired_offline_title;
                i = R.string.offline_message_expired_to_renew_description;
                break;
            case PLAY_WINDOW_EXPIRED_FINAL:
                i2 = R.string.offline_message_expired_offline_title;
                i = R.string.offline_message_expired_to_delete_description;
                break;
            case VIEW_WINDOW_EXPIRED:
                i2 = R.string.offline_message_expired_offline_title;
                i = R.string.offline_message_no_longer_available_description;
                break;
            case GEO_BLOCKED:
                i2 = R.string.offline_message_no_available_title;
                i = R.string.offline_message_no_available_geo_description;
                break;
        }
        if (i == -1 || i2 == -1) {
            return null;
        }
        String string = getString(i2);
        String string2 = getString(i);
        if (m14535()) {
            return C0505.m14491(getActivity(), this.f11815, new C1278(string, string2, getString(R.string.label_ok), this.f11850));
        }
        return null;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˏॱ */
    public boolean mo2255() {
        return this.f11811 != null && this.f11811.m12556() == IPlayer.PlaybackType.OfflinePlayback;
    }

    /* renamed from: ՙ  reason: contains not printable characters */
    private void m12656() {
        pF r5;
        pV r6;
        if (mo2255() && this.f11811 != null && (r5 = this.f11811.m12545()) != null && (r6 = vO.m12017(m14536(), this.f11811.m12545().getPlayableId())) != null) {
            C1365Ck.m4462(r6.mo6913(), r6.mo6915(), r5.getRuntime(), r5.getLogicalStart(), r5.getEndtime());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12645(IClientLogging.CompletionReason completionReason) {
        if (mo2255()) {
            C1365Ck.m4459(null, completionReason, null);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m12705(String str, oX oXVar) {
        C2059ph r2 = m14536();
        if (r2 == null) {
            return false;
        }
        pV r3 = vO.m12017(r2, str);
        if (!r2.m9774(r3) || r3.mo6881() != DownloadState.Complete) {
            return false;
        }
        m12606();
        m12681();
        startActivity(ActivityC2280wv.m12564(m14534().getApplicationContext(), str, VideoType.EPISODE, oXVar));
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m12642(long j) {
        if (j <= 0 || this.f11811 == null || this.f11811.m12554()) {
            return false;
        }
        return (ConnectivityUtils.m2954(getActivity()) || mo2255()) && 60000 + j >= this.f11811.m12560();
    }

    /* renamed from: ॱʿ  reason: contains not printable characters */
    private boolean m12672() {
        return AD.m3283(getActivity()) && (!m12661() || m12673());
    }

    /* renamed from: ߵ  reason: contains not printable characters */
    private boolean m12661() {
        return (m12711().m2342() == 0 || m12711().m2341() == 0) ? false : true;
    }

    /* renamed from: ॱˈ  reason: contains not printable characters */
    private boolean m12673() {
        return m12711().m2338() == m12711().m2341() && m12711().m2336() == m12711().m2342() && Math.abs((m12711().m2338() * 9) - (m12711().m2336() * 16)) < 10;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʼॱ */
    public void mo2228() {
        if (m12627()) {
            m12674();
            this.f11804.m2369(new Rational(m12711().m2338(), m12711().m2336()));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPictureInPictureModeChanged(boolean z) {
        if (C1317As.m3742(NetflixApplication.getInstance())) {
            super.onPictureInPictureModeChanged(z);
            if (m12713() != null) {
                C1283.m16854("PlayerFragment", "onPipModeChanged, is PIP?  " + z);
                if (z) {
                    this.f11803.onNext(xH.C0273.f12007);
                    m12713().K_();
                    m12713().mo7758(true);
                } else {
                    m12713().mo907(ExitPipAction.CONTINUEPLAY);
                    m12713().mo7758(false);
                    this.f11803.onNext(xH.C0272.f12006);
                }
                this.f11804.m2367(z);
            }
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public void mo2259(String str, VideoType videoType, oX oXVar) {
        C1283.m16854("PlayerFragment", "restarting activity from pip. ");
        m12606();
        m12681();
        startActivity(ActivityC2280wv.m12564(m14534().getApplicationContext(), str, videoType, oXVar));
    }

    /* renamed from: ॱʾ  reason: contains not printable characters */
    private int m12671() {
        return this.f11829;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˏ */
    public void mo2253(pF pFVar, VideoType videoType, oX oXVar, int i) {
        if (!m12705(pFVar.getPlayableId(), oXVar)) {
            mo2243(new C2279wu(pFVar, videoType, oXVar, i));
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋ */
    public void mo2243(C2279wu wuVar) {
        if (m14535()) {
            C1283.m16851("PlayerFragment", "CUSNP PlaybackVideoWrapper is %s", wuVar.m12545().getPlayableId());
            m12706();
            mo2247();
            mo2266();
            this.f11811 = wuVar;
            if (this.f11806.m12375()) {
                this.f11806.m12370();
            } else if (this.f11811 != null) {
                this.f11806.m12374(this.f11811);
            }
            m12605();
            this.f11824.m12292(false);
            this.f11824.m12294(false);
            this.f11824.f11448 = PlayerFragment.PlayerFragmentState.ACTIVITY_PLAYER_LOADING_NEXT;
            this.f11803.onNext(xH.C2295iF.f11992);
            m12625(m14536(), this.f11811.m12562(), this.f11811.m12546(), this.f11811.m12563(), this.f11811.m12555());
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʽ */
    public void mo2229() {
        mo2234().m12287(SystemClock.elapsedRealtime());
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱॱ */
    public String mo2267() {
        if (mo2268() != null) {
            return mo2268().getPlayableId();
        }
        return null;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʻ */
    public VideoType mo2225() {
        return m12631();
    }

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    public pF m12710() {
        if (this.f11811 == null) {
            return null;
        }
        return this.f11811.m12545();
    }

    /* renamed from: ߺ  reason: contains not printable characters */
    private int m12662() {
        if (this.f11811 == null) {
            return 0;
        }
        int r3 = this.f11811.m12555();
        if (r3 == -1) {
            r3 = this.f11811.m12545().getPlayableBookmarkPosition();
        }
        if (r3 >= 0) {
            return r3;
        }
        C1283.m16854("PlayerFragment", hashCode() + " Invalid bookmark, reset to 0");
        return 0;
    }

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    public C0951 m12711() {
        return this.f11839;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋˋ */
    public View mo2246() {
        return getView();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˉ  reason: contains not printable characters */
    private void m12674() {
        m14534().removeVisibleDialog();
        if (m14534().isDialogFragmentVisible()) {
            m14534().removeDialogFrag();
        }
        if (this.f11844 != null) {
            this.f11844.dismiss();
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˌ */
    public void mo2249() {
        m12674();
        this.f11803.onNext(xH.C2294con.f11991);
        this.f11824.m12292(true);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12694(PublishSubject<xJ> publishSubject) {
        this.f11826 = publishSubject;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˎˎ */
    public PublishSubject<xJ> mo2251() {
        return this.f11826;
    }

    /* renamed from: ॱـ  reason: contains not printable characters */
    private void m12678() {
        C2279wu r3 = mo2239();
        if (r3 != null && r3.m12545() != null) {
            int autoPlayMaxCount = r3.m12545().getAutoPlayMaxCount();
            if (autoPlayMaxCount <= -1) {
                C1283.m16854("PlayerFragment", "Interrupter: autoPlayMaxCount = " + autoPlayMaxCount + " resetting to 3");
                autoPlayMaxCount = 3;
            }
            if (this.f11824.m12283() >= autoPlayMaxCount && this.f11824.m12289()) {
                C1283.m16854("PlayerFragment", "This is " + autoPlayMaxCount + " consecutive auto play with no user interaction, prepare the interrupter");
                this.f11803.onNext(xH.C0264.f11996);
            }
        }
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    public void m12714() {
        if (this.f11824 != null) {
            this.f11824.m12286();
            this.f11824.m12291(0);
            this.f11803.onNext(xH.C0268.f12002);
        }
    }
}

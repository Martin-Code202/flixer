package com.netflix.mediaclient.ui.player;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Rational;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.media.PlayerManifestData;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
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
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import com.netflix.mediaclient.ui.verifyplay.PlayVerifierVault;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.l10n.BidiMarker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import o.AD;
import o.AN;
import o.AbstractC0367;
import o.AbstractC0496;
import o.AbstractC0517;
import o.AbstractC0931;
import o.AbstractC1221;
import o.AbstractC1268;
import o.AbstractC1358Cd;
import o.AbstractC1978mi;
import o.AbstractC2056pe;
import o.AbstractC2271wm;
import o.ActivityC2280wv;
import o.BX;
import o.C0505;
import o.C0567;
import o.C0577;
import o.C0650;
import o.C0913;
import o.C0942;
import o.C1004;
import o.C1081;
import o.C1276;
import o.C1278;
import o.C1283;
import o.C1305Ag;
import o.C1306Ah;
import o.C1317As;
import o.C1322Av;
import o.C1328Ba;
import o.C1339Bl;
import o.C1348Bu;
import o.C1349Bv;
import o.C1352By;
import o.C1355Ca;
import o.C1362Ch;
import o.C1364Cj;
import o.C1365Ck;
import o.C1841h;
import o.C1931kb;
import o.C1935kf;
import o.C1987mr;
import o.C2052pa;
import o.C2058pg;
import o.C2059ph;
import o.C2116re;
import o.C2172tc;
import o.C2266wh;
import o.C2269wk;
import o.C2274wp;
import o.C2275wq;
import o.C2278wt;
import o.C2279wu;
import o.C2316xl;
import o.CH;
import o.DialogC1104;
import o.oB;
import o.oM;
import o.oX;
import o.oY;
import o.pF;
import o.pI;
import o.pT;
import o.pV;
import o.qI;
import o.qK;
import o.qN;
import o.qO;
import o.qU;
import o.qX;
import o.uW;
import o.vO;
import o.vV;
import o.wD;
import o.wE;
import o.wG;
import o.wT;
import o.wV;
import o.xD;
import o.xE;
import o.xJ;
import o.zW;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
public class PlayerFragment extends AbstractC0517 implements AudioManager.OnAudioFocusChangeListener, oM.AbstractC0160, AbstractC0496.Cif, qK, C0567.Cif, IPlayerFragment {

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean f3486 = false;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final int f3487 = ((C0650.m14801() || Config_Ab9454_InPlayerPivots.m513()) ? 3000 : 5000);

    /* renamed from: ﾟ  reason: contains not printable characters */
    private static wD f3488;

    /* renamed from: ʹ  reason: contains not printable characters */
    private qI.AbstractC0168 f3489 = new qI.AbstractC0168() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.2
        @Override // o.qI.AbstractC0168
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo2532() {
            PlayerFragment.this.mo2247();
            PlayerFragment.this.m2482();
            PlayerFragment.this.m14534().reportUiModelessViewSessionEnded(IClientLogging.ModalView.audioSubtitlesSelector, PlayerFragment.this.f3535);
        }

        @Override // o.qI.AbstractC0168
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo2533(Dialog dialog) {
            PlayerFragment.this.m14534().updateVisibleDialog(dialog);
        }

        @Override // o.qI.AbstractC0168
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo2534(Language language, boolean z) {
            PlayerFragment.this.m2494(language);
            PlayerFragment.this.m14534().reportUiModelessViewSessionEnded(IClientLogging.ModalView.audioSubtitlesSelector, PlayerFragment.this.f3535);
        }

        @Override // o.qI.AbstractC0168
        /* renamed from: ॱ  reason: contains not printable characters */
        public boolean mo2535() {
            return PlayerFragment.this.mo2454();
        }
    };

    /* renamed from: ʻˊ  reason: contains not printable characters */
    private final BroadcastReceiver f3490 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.17
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PlayerFragment.this.m2480();
        }
    };

    /* renamed from: ʻˋ  reason: contains not printable characters */
    private final BroadcastReceiver f3491 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.13
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16854("PlayerFragment", "mFinishPipPlayerIntentReceiver has" + intent.getAction());
            if (PlayerFragment.this.mo2265() && "com.netflix.mediaclient.intent.action.END_PIP".equalsIgnoreCase(intent.getAction())) {
                PlayerFragment.this.m2529();
            }
        }
    };

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected final View.OnClickListener f3492 = new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayerFragment.this.mo2500() != null) {
                if (C0650.m14806() || Config_Ab9454_InPlayerPivots.m525()) {
                    C2274wp.m12442(view);
                }
                PlayerFragment.this.f3532.m12287(SystemClock.elapsedRealtime());
                PlayerFragment.this.m2502();
                if (PlayerFragment.this.mo2500().mo892()) {
                    PlayerFragment.this.m2488(true);
                    C1364Cj.m4434(UIViewLogging.UIViewCommandName.pause, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                    return;
                }
                PlayerFragment.this.mo2247();
                C1364Cj.m4434(UIViewLogging.UIViewCommandName.unPause, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
            }
        }
    };

    /* renamed from: ʻᐝ  reason: contains not printable characters */
    private final Runnable f3493 = new Runnable() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.11
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("PlayerFragment", "pause has timed out, exit playback");
            IClientLogging iClientLogging = null;
            C2059ph r3 = PlayerFragment.this.m14536();
            if (r3 != null) {
                iClientLogging = r3.m9825();
            }
            if (iClientLogging != null) {
                iClientLogging.mo1504().mo5775("pauseTimeout calling cleanupExit");
            }
            PlayerFragment.this.mo2248();
            if (iClientLogging != null) {
                iClientLogging.mo1504().mo5775("pauseTimeout cleanupExit done");
            }
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    public Handler f3494 = new Handler();

    /* renamed from: ʼˊ  reason: contains not printable characters */
    private final BroadcastReceiver f3495 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                PlayerFragment.this.m2488(false);
            }
        }
    };

    /* renamed from: ʼˋ  reason: contains not printable characters */
    private final BroadcastReceiver f3496 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.12
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            PlayerFragment.this.m2502();
        }
    };

    /* renamed from: ʼॱ  reason: contains not printable characters */
    protected final View.OnClickListener f3497 = new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerFragment.this.mo2256();
        }
    };

    /* renamed from: ʽ  reason: contains not printable characters */
    protected AbstractC1221 f3498;

    /* renamed from: ʽˊ  reason: contains not printable characters */
    private final qO.Cif f3499 = new qO.Cif() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.20
        @Override // o.qO.Cif
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo2536(pI pIVar) {
            if (PlayerFragment.this.m14535()) {
                C1364Cj.m4447(IClientLogging.ModalView.episodesSelector, null);
                PlayerFragment.this.m2449();
                if (PlayerFragment.this.f3512 != null && PlayerFragment.this.f3512.m12545() != null && TextUtils.equals(PlayerFragment.this.f3512.m12545().getPlayableId(), pIVar.getPlayable().getPlayableId())) {
                    C1283.m16854("PlayerFragment", "Request to play same episode, do nothing");
                    PlayerFragment.this.m2482();
                    PlayerFragment.this.mo2247();
                } else if (PlayerFragment.this.f3534 == null) {
                    C1283.m16865("PlayerFragment", "SPY-8951 - mScreen is null inside onEpisodeSelectedForPlayback. Ignoring playback.");
                    C1276.m16820().mo5727("SPY-8951 - mScreen is null inside onEpisodeSelectedForPlayback. Ignoring playback.");
                } else if (!PlayerFragment.this.m2422(pIVar.getPlayable().getPlayableId(), qN.f9505)) {
                    PlayerFragment.this.mo2243(new C2279wu(pIVar.getPlayable(), PlayerFragment.this.f3512.m12546(), qN.f9505, pIVar.getPlayable().getPlayableBookmarkPosition()));
                }
            }
        }
    };

    /* renamed from: ʽॱ  reason: contains not printable characters */
    protected final View.OnClickListener f3500 = new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.28
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1364Cj.m4434(UIViewLogging.UIViewCommandName.zoom, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
            PlayerFragment.this.f3532.m12287(SystemClock.elapsedRealtime());
            PlayerFragment.this.m2502();
            if (PlayerFragment.this.f3514) {
                PlayerFragment.this.mo2524();
            } else {
                PlayerFragment.this.mo2521();
            }
            PlayerFragment.this.f3514 = !PlayerFragment.this.f3514;
        }
    };

    /* renamed from: ʽᐝ  reason: contains not printable characters */
    private final AbstractC0496.iF f3501 = new AbstractC0496.iF() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.24
        @Override // o.AbstractC0496.iF
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo2537(AbstractC0496 r4) {
            if ((r4 instanceof C2116re) && PlayerFragment.this.m14535()) {
                PlayerFragment.this.f3532.m12287(SystemClock.elapsedRealtime());
                PlayerFragment.this.m2502();
                C1283.m16854("PlayerFragment", "Episode selector was dismissed");
                if (PlayerFragment.this.mo2500() != null) {
                    if (PlayerFragment.this.mo2500().mo892()) {
                        PlayerFragment.this.m2488(true);
                    } else {
                        PlayerFragment.this.mo2247();
                    }
                }
                PlayerFragment.this.m2482();
            }
        }
    };

    /* renamed from: ʾ  reason: contains not printable characters */
    protected final View.OnClickListener f3502 = new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.30
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerFragment.this.mo2264();
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    protected final View.OnClickListener f3503 = new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayerFragment.this.m14535()) {
                PlayerFragment.this.m2479();
                PlayerFragment.this.f3543.m9898(PlayerFragment.this.m2501());
                PlayerFragment.this.m2481();
                PlayerFragment.this.f3535 = PlayerFragment.this.m14534().reportUiModelessViewSessionStart(IClientLogging.ModalView.audioSubtitlesSelector);
                C1364Cj.m4434(UIViewLogging.UIViewCommandName.viewAudioSubtitlesSelector, IClientLogging.ModalView.audioSubtitlesSelector, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
            }
        }
    };

    /* renamed from: ˈ  reason: contains not printable characters */
    protected final View.OnClickListener f3504 = new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.29
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PlayerFragment.this.m14535()) {
                if (PlayerFragment.this.f3512 == null) {
                    C1283.m16850("PlayerFragment", "mCurrentPlaybackItem is null!");
                    return;
                }
                pF r2 = PlayerFragment.this.f3512.m12545();
                if (r2 == null) {
                    C1283.m16850("PlayerFragment", "playable is null!");
                } else if (!r2.isPlayableEpisode()) {
                    C1283.m16850("PlayerFragment", "playable is not episode detail!");
                } else if (PlayerFragment.this.f3526 == null || !PlayerFragment.this.f3526.isVisible()) {
                    C1283.m16854("PlayerFragment", "Start episodes dialog");
                    PlayerFragment.this.m2481();
                    PlayerFragment.this.m2424();
                } else {
                    C1283.m16850("PlayerFragment", "Episode dialog already showing");
                }
            }
        }
    };

    /* renamed from: ˉ  reason: contains not printable characters */
    Runnable f3505 = new Runnable() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.15
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("PlayerFragment", "Playback canceled when not longer on WiFi");
            PlayerFragment.this.mo2248();
        }
    };

    /* renamed from: ˊˊ  reason: contains not printable characters */
    protected final SeekBar.OnSeekBarChangeListener f3506 = new SeekBar.OnSeekBarChangeListener() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.4
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && PlayerFragment.this.f3532.f11459) {
                AudioManager audioManager = (AudioManager) PlayerFragment.this.getActivity().getSystemService("audio");
                if (audioManager != null) {
                    audioManager.setStreamVolume(3, i, 0);
                } else {
                    C1283.m16850("PlayerFragment", "Audio manager is not available, can not change volume");
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            PlayerFragment.this.f3532.f11459 = true;
            C1283.m16854("PlayerFragment", "Start volume change, get awake clock");
            PlayerFragment.this.m2499();
            PlayerFragment.this.m2481();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            C1283.m16854("PlayerFragment", "volume::onStopTrackingTouch called");
            PlayerFragment.this.f3532.f11459 = false;
            PlayerFragment.this.f3532.f11444 = false;
            PlayerFragment.this.m2482();
        }
    };

    /* renamed from: ˊˋ  reason: contains not printable characters */
    protected final SurfaceHolder.Callback f3507 = new SurfaceHolder.Callback() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.9
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public synchronized void surfaceCreated(SurfaceHolder surfaceHolder) {
            PlayerFragment.f3486 = false;
            C1283.m16854("PlayerFragment", "Surface created");
            if (surfaceHolder == null || surfaceHolder.getSurface() == null) {
                PlayerFragment.this.f3513 = false;
                if (PlayerFragment.this.f3512 == null) {
                    C1283.m16850("PlayerFragment", "surfaceCreated again, playout already set to null");
                }
                C1283.m16854("PlayerFragment", "SurfaceCreated again, no playback");
            } else {
                PlayerFragment.this.f3513 = true;
                if (PlayerFragment.this.m2505() != null) {
                    PlayerFragment.this.m2505().setVisibility(0);
                }
                PlayerFragment.this.m2515();
                if (null != PlayerFragment.this.mo2500()) {
                    PlayerFragment.this.f3541.mo906(surfaceHolder.getSurface());
                }
                if (PlayerFragment.this.m2462()) {
                    PlayerFragment.this.m2449();
                    PlayerFragment.this.mo2247();
                }
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            PlayerFragment.f3486 = true;
            PlayerFragment.this.f3513 = false;
            if (null != PlayerFragment.this.f3541 && PlayerFragment.this.mo2463() && !PlayerFragment.this.mo2265()) {
                PlayerFragment.this.f3541.mo906((Surface) null);
                PlayerFragment.this.m2512(true);
            } else if (PlayerFragment.this.f3534 != null && !PlayerFragment.this.f3534.m12497()) {
                C1283.m16854("PlayerFragment", "In postplay when surface is destroyed, do not exit");
            } else if (PlayerFragment.this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_LOADING_NEXT) {
                C1283.m16854("PlayerFragment", "refreshing UI for new playback.");
            } else {
                C1283.m16854("PlayerFragment", "Surface destroyed, exit if we are not already in it");
                PlayerFragment.this.mo2248();
            }
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected BroadcastReceiver f3508;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private boolean f3509;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    protected final AbstractC0931.AbstractC0932 f3510 = new AbstractC0931.AbstractC0932() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.7
        @Override // o.AbstractC0931.AbstractC0932
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo2538(MotionEvent motionEvent) {
            C1283.m16854("PlayerFragment", "PA tap");
            if (PlayerFragment.this.f3532.f11442 || PlayerFragment.this.f3532.f11444) {
                C1283.m16854("PlayerFragment", "Seekto in progress, ignore");
            } else if (PlayerFragment.this.f3534 == null || !PlayerFragment.this.f3534.m12515()) {
                boolean z = motionEvent != null;
                PlayerFragment.this.f3532.m12287(SystemClock.elapsedRealtime());
                PlayerFragment.this.m2502();
                PlayerFragment.this.m2477(z);
            } else {
                C1283.m16854("PlayerFragment", "In interrupted state, ignore");
            }
        }
    };

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private OrientationEventListener f3511;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected C2279wu f3512;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private boolean f3513;

    /* renamed from: ˌ  reason: contains not printable characters */
    private boolean f3514 = true;

    /* renamed from: ˍ  reason: contains not printable characters */
    private wT f3515;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private int f3516 = 2000;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private boolean f3517;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private PictureInPictureManager f3518;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private Language f3519;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean f3520;

    /* renamed from: ˑ  reason: contains not printable characters */
    private boolean f3521;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected ViewGroup f3522;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private xD f3523;

    /* renamed from: ـ  reason: contains not printable characters */
    private boolean f3524;

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private Menu f3525;

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private AbstractC0496 f3526;

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private boolean f3527;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected wE f3528;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public final Runnable f3529 = new Runnable() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.25
        @Override // java.lang.Runnable
        public void run() {
            C1283.m16854("PlayerFragment", "Pause, release awake clock");
            PlayerFragment.this.m2440();
        }
    };

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public final wV f3530 = new wV(this);

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private Menu f3531;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final wG f3532 = new wG();

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected final CompositeDisposable f3533 = new CompositeDisposable();

    /* renamed from: ᐝ  reason: contains not printable characters */
    public C2275wq f3534;

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private String f3535;

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private boolean f3536;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public final PublishSubject<IPlayerFragment.PublisherEvents> f3537 = PublishSubject.create();

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private ArrayList<AbstractC2271wm> f3538;

    /* renamed from: ᐧ  reason: contains not printable characters */
    private boolean f3539 = true;

    /* renamed from: ᐨ  reason: contains not printable characters */
    private PlayerManifestData f3540;

    /* renamed from: ᶥ  reason: contains not printable characters */
    private oM f3541;

    /* renamed from: ㆍ  reason: contains not printable characters */
    private AbstractC2056pe f3542;

    /* renamed from: ꓸ  reason: contains not printable characters */
    private qI f3543;

    /* renamed from: ꜞ  reason: contains not printable characters */
    private final xE f3544 = new xE();

    /* renamed from: ꜟ  reason: contains not printable characters */
    private oY f3545;

    /* renamed from: ꞌ  reason: contains not printable characters */
    private CH f3546 = null;

    /* renamed from: ﹳ  reason: contains not printable characters */
    private final BroadcastReceiver f3547 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1283.m16854("PlayerFragment", "mPlayerSuspendIntentReceiver has" + intent.getAction());
            if (PlayerFragment.this.m2462() && wD.m12270(intent.getAction())) {
                PlayerFragment.this.mo2248();
            }
        }
    };

    /* renamed from: ﾞ  reason: contains not printable characters */
    private final Runnable f3548 = new Runnable() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.8
        @Override // java.lang.Runnable
        public void run() {
            if (!PlayerFragment.this.m14535() || PlayerFragment.this.f3532.f11440 || PlayerFragment.this.f3532.f11459) {
                C1283.m16854("PlayerFragment", "METADATA exit");
                return;
            }
            synchronized (PlayerFragment.this) {
                if (PlayerFragment.this.f3534 != null && !PlayerFragment.this.f3532.f11440 && !PlayerFragment.this.f3532.f11459) {
                    PlayerUiState r5 = PlayerFragment.this.f3534.m12493();
                    if (PlayerFragment.this.f3532.m12296() > 0 && SystemClock.elapsedRealtime() - PlayerFragment.this.f3532.m12296() > ((long) PlayerFragment.f3487) && r5 != PlayerUiState.PostPlay && r5 != PlayerUiState.SkipCredits) {
                        C1283.m16854("PlayerFragment", "Time to remove panel");
                        PlayerFragment.this.m2459();
                    }
                    if (PlayerFragment.this.f3532.m12296() > 0 && SystemClock.elapsedRealtime() - PlayerFragment.this.f3532.m12296() > 6000 && PlayerFragment.this.f3534.m12493() != PlayerUiState.PostPlay && PlayerFragment.this.f3534.m12493() == PlayerUiState.SkipCredits) {
                        if (!(PlayerFragment.this.f3534.m12518() == null || PlayerFragment.this.f3534.m12518().m12395() == 0)) {
                            C1283.m16854("PlayerFragment", "Time to remove panel when in SkipCredits");
                            PlayerFragment.this.f3534.m12518().mo12391(true);
                        }
                        PlayerFragment.this.m2459();
                    }
                    PlayerFragment.this.m2437();
                    PlayerFragment.this.m2429();
                }
                PlayerFragment.this.m2388(1000);
            }
        }
    };

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ᐝॱ */
    public /* synthetic */ Context mo2269() {
        return super.getActivity();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static PlayerFragment m2419(String str, VideoType videoType, oX oXVar, int i, int i2) {
        PlayerFragment playerFragment = new PlayerFragment();
        playerFragment.setArguments(m2410(str, videoType, oXVar, i, i2));
        return playerFragment;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Bundle m2410(String str, VideoType videoType, oX oXVar, int i, int i2) {
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
        m2498().getAttributes().buttonBrightness = 0.0f;
        this.f3532.m12299();
        C1362Ch.m4393((UserActionLogging.CommandName) null, IClientLogging.ModalView.playback);
        this.f3532.f11451.set(true);
        this.f3543 = qI.m9894(m14534(), m14534().isTablet(), this.f3489);
        this.f3528 = new wE(m14534(), this);
        if (C1317As.m3742(NetflixApplication.getInstance())) {
            this.f3518 = new PictureInPictureManager(this, new PictureInPictureManager.iF() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.5
                @Override // com.netflix.mediaclient.ui.player.PictureInPictureManager.iF
                /* renamed from: ॱ */
                public void mo2371(boolean z) {
                    super.mo2371(z);
                    if (z) {
                        NetflixApplication.getInstance().m237().m14204(true);
                        if (PlayerFragment.this.f3534 != null) {
                            PlayerFragment.this.f3534.m12523(true);
                        }
                        if (C0913.m15712()) {
                            C2278wt wtVar = (C2278wt) PlayerFragment.this.f3534;
                            if (wtVar != null && wtVar.m12544() != null) {
                                wtVar.m12544().setSubtitleVisiblity(false);
                                return;
                            }
                            return;
                        }
                        PlayerFragment.this.f3523.mo9033(false);
                        PlayerFragment.this.f3523.mo9034();
                        PlayerFragment.this.f3523.mo9031();
                        return;
                    }
                    NetflixApplication.getInstance().m237().m14204(false);
                    PlayerFragment.this.f3521 = true;
                    if (PlayerFragment.this.f3534 != null) {
                        PlayerFragment.this.f3534.m12523(false);
                    }
                    if (C0913.m15712()) {
                        C2278wt wtVar2 = (C2278wt) PlayerFragment.this.f3534;
                        if (wtVar2 != null && wtVar2.m12544() != null) {
                            wtVar2.m12544().setSubtitleVisiblity(true);
                            return;
                        }
                        return;
                    }
                    PlayerFragment.this.f3523.mo9033(true);
                }
            });
        }
        AbstractC1358Cd.m4354();
        mo2483();
        C1283.m16854("PlayerFragment", "onCreate done");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1283.m16862("PlayerFragment", "onCreateView");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f3522 = new FrameLayout(getActivity());
        setHasOptionsMenu(true);
        return this.f3522;
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f3523 = new xD(getView());
        this.f3533.add((Disposable) this.f3544.m12746().subscribeWith(new DisposableObserver<xE.If>() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.14
            /* renamed from: ˋ  reason: contains not printable characters */
            public void onNext(xE.If r6) {
                if (r6.m12751() == null || r6.m12750().mo301()) {
                    PlayerFragment.this.mo2248();
                    C1276.m16820().mo5725("PlayerFragment No data, finishing up the player. Details=" + r6.m12751() + "Status is " + r6.m12750());
                    return;
                }
                PlayerFragment.this.m2396(r6.m12751(), r6.m12749(), r6.m12748(), r6.m12752());
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                PlayerFragment.this.mo2248();
                C1276.m16820().mo5729("PlayerFragment No data, finishing up the player", th);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
            }
        }));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2484(int i) {
        C1283.m16862("PlayerFragment", "setFragmentContentView");
        FragmentActivity activity = getActivity();
        if (!C1322Av.m3793(activity)) {
            this.f3522.removeAllViews();
            this.f3522.addView(activity.getLayoutInflater().inflate(i, (ViewGroup) null), new LinearLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public void mo2260(String str, VideoType videoType, oX oXVar, int i) {
        if (m14536() != null) {
            m2397(m14536(), str, videoType, oXVar, i);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2397(C2059ph phVar, String str, VideoType videoType, oX oXVar, int i) {
        this.f3544.m12747(phVar, str, videoType, oXVar, i);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        m2499();
        PostPlay r2 = m2447();
        if (r2 != null) {
            r2.m2566();
        }
        if (this.f3534 != null) {
            this.f3534.m12524();
        }
        AudioManager audioManager = (AudioManager) getActivity().getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(this, 3, 1);
        } else {
            C1283.m16850("PlayerFragment", "Audio manager not found. Unable to ask for audio focus!");
        }
        if (!m2497()) {
            m2415();
        }
        C1283.m16854("PlayerFragment", "onStart done");
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    public void mo2483() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f3508 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.23
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (!PlayerFragment.this.isDetached()) {
                        PlayerFragment.this.m2416();
                    }
                }
            };
            activity.registerReceiver(this.f3508, new IntentFilter("ACTION_RELOAD_VIDEO"));
        }
    }

    /* renamed from: ՙ  reason: contains not printable characters */
    private void m2414() {
        if (this.f3508 != null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.unregisterReceiver(this.f3508);
            }
            this.f3508 = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺॱ  reason: contains not printable characters */
    public void m2504() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !mo2265()) {
            activity.finish();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏˎ  reason: contains not printable characters */
    public boolean m2497() {
        if (Build.VERSION.SDK_INT < 24 || C1322Av.m3793(getActivity())) {
            return true;
        }
        return !getActivity().isInMultiWindowMode() && !mo2265();
    }

    /* renamed from: ٴ  reason: contains not printable characters */
    private void m2415() {
        PostPlay r3 = m2447();
        if (r3 != null) {
            r3.m2558();
        }
        if (this.f3534 != null) {
            this.f3534.m12537(C1339Bl.m4051(getActivity().getBaseContext(), "ui.playergraphicref", false));
            this.f3534.m12530();
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m2445(boolean z) {
        this.f3537.onNext(IPlayerFragment.PublisherEvents.ON_PLAYER_PAUSED);
        this.f3527 = m2470() || m2466();
        if (this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            m2488(z);
        }
        m2425();
        if (this.f3528 != null) {
            this.f3528.m12277(2);
        }
        PostPlay r2 = m2447();
        if (r2 != null) {
            r2.m2557();
        }
        if (this.f3534 != null) {
            this.f3534.m12533();
        }
        C1283.m16854("PlayerFragment", "onPause called done");
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        this.f3537.onNext(IPlayerFragment.PublisherEvents.ON_RESUME);
        if (this.f3534 != null) {
            this.f3534.mo12471(getActivity());
            if (this.f3534.m12505()) {
                C1283.m16854("PlayerFragment", "starting new playback with pip present");
            }
        }
        super.onResume();
        if (m2497()) {
            m2415();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        if (m2497()) {
            m2445(true);
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (!m2497()) {
            m2445(true);
        }
        PostPlay r4 = m2447();
        if (r4 != null) {
            r4.m2560();
        }
        if (this.f3534 != null) {
            this.f3534.m12529();
        }
        super.onStop();
        AudioManager audioManager = (AudioManager) getActivity().getSystemService("audio");
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this);
        } else {
            C1283.m16850("PlayerFragment", "Audio manager not found. Unable to abandon audio focus!");
        }
        if (m2462() || mo2463()) {
            C1283.m16854("PlayerFragment", "PlayerActivity::onStop done, player is backgrounded");
            return;
        }
        if (this.f3532.f11451.getAndSet(false)) {
            C1283.m16854("PlayerFragment", "Start play is in progress and user canceled playback");
            C1362Ch.m4408(IClientLogging.CompletionReason.canceled, null, null, m2446());
        }
        if (mo2265()) {
            m2529();
        } else {
            mo2248();
        }
        C1283.m16854("PlayerFragment", "PlayerActivity::onStop done");
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    public void onDestroy() {
        this.f3533.clear();
        ((NetflixApplication) getContext().getApplicationContext()).m237().m14204(false);
        if (m2462()) {
            mo2248();
        }
        m2498().getAttributes().buttonBrightness = -1.0f;
        m2440();
        this.f3494.removeCallbacks(this.f3493);
        this.f3494.removeCallbacks(this.f3529);
        if (this.f3534 != null) {
            this.f3534.mo12536();
        }
        if (this.f3523 != null) {
            this.f3523.mo9027();
        }
        if (this.f3528 != null) {
            this.f3528.m12279();
        }
        AbstractC1358Cd.m4359(false);
        if (this.f3511 != null) {
            this.f3511.disable();
        }
        m2414();
        this.f3537.onNext(IPlayerFragment.PublisherEvents.ON_DESTROY);
        this.f3537.onComplete();
        super.onDestroy();
        C1283.m16854("PlayerFragment", "====> Destroying PlayerFragment done");
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    public boolean m2490() {
        return this.f3520;
    }

    /* renamed from: ˏˏ  reason: contains not printable characters */
    public Window m2498() {
        return getActivity().getWindow();
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    public oM mo2500() {
        return this.f3541;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊᐝ */
    public boolean mo2241() {
        return getActivity() != null && AD.m3306(getActivity());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱʽ  reason: contains not printable characters */
    public void m2515() {
        if (!this.f3513) {
            C1283.m16854("PlayerFragment", "Surface not ready - cannot complete init");
        } else if (this.f3512 != null && this.f3512.m12547()) {
            C1283.m16846("PlayerFragment", "completeInitIfReady()");
            m2503();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ـ  reason: contains not printable characters */
    public void m2506() {
        C1283.m16846("PlayerFragment", "Playback verified - completing init process...");
        C2059ph r3 = m14536();
        boolean z = false;
        if (this.f3530.m12371()) {
            C1283.m16850("PlayerFragment", "preplay is fetching content. Waiting for the call back");
            return;
        }
        if (this.f3530.m12378()) {
            this.f3530.m12379();
        }
        pF r5 = m2507();
        if (r5 == null) {
            C1276.m16820().mo5730(new IllegalStateException("Invalid state, continue init after play verify on a null asset"));
            m2504();
            return;
        }
        if (this.f3534 != null) {
            this.f3534.m12520(mo2509(r5));
            if (this.f3534.m12518() != null) {
                this.f3534.m12518().setSkipCreditsButtonType(this.f3530.m12375() ? 0 : 1);
            }
        }
        if (r3 != null) {
            z = r3.m9758();
        }
        if (!(this.f3534 == null || mo2255() || this.f3534.m12508() == null)) {
            this.f3534.m12508().m12895(r5.isPlayableEpisode() && !z);
        }
        m2448();
        mo2513();
    }

    /* renamed from: ॱʻ  reason: contains not printable characters */
    public void mo2513() {
        if (!this.f3532.f11446 && m2416()) {
            this.f3532.f11448 = PlayerFragmentState.ACTIVITY_PLAYER_READY;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱͺ  reason: contains not printable characters */
    public boolean m2516() {
        if (!m14535()) {
            C1283.m16854("PlayerFragment", "fragment is not valid. ");
            return false;
        }
        pF r2 = this.f3512.m12545();
        if (r2 == null) {
            C1283.m16850("PlayerFragment", "trying to load a video with a null playable.");
            return false;
        }
        C2059ph r3 = m14536();
        if (!(mo2500() == null || r3 == null || this.f3512.m12556() != IPlayer.PlaybackType.OfflinePlayback)) {
            if (r3.m9774(vO.m12017(m14536(), r2.getPlayableId()))) {
                C1283.m16862("PlayerFragment", "continue with offline player");
            } else {
                C1283.m16862("PlayerFragment", "switching to streaming player");
                this.f3512.m12552(IPlayer.PlaybackType.StreamingPlayback);
                mo2500().mo921(this);
                m2438();
            }
        }
        if (!ConnectivityUtils.m2970(getActivity()) && !mo2255()) {
            C1283.m16854("PlayerFragment", "Raising no connectivity warning");
            m2442();
            return false;
        } else if (m2480()) {
            return true;
        } else {
            C1283.m16854("PlayerFragment", "Network check fails");
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ߵ  reason: contains not printable characters */
    private boolean m2416() {
        if (this.f3512 == null) {
            C1276.m16820().mo5725("video loaded with not playback Item");
            return false;
        } else if (!m2516()) {
            return false;
        } else {
            this.f3532.f11446 = true;
            int r9 = m2508();
            m2520();
            this.f3545 = this.f3542.mo7800();
            this.f3517 = true;
            C1276.m16820().mo5728("PlayerFragment.loadVideo trackId:" + this.f3512.m12563().getTrackId());
            C2269wk.m12432(this.f3512.m12563());
            this.f3541 = this.f3542.mo7792(this, this.f3545, this.f3512.m12558(), C1349Bv.m4108(this.f3512.m12545().getPlayableId()), this.f3512.m12563(), (long) (r9 * 1000));
            if (this.f3541 == null) {
                mo2248();
                return false;
            }
            if (m2505() != null) {
                mo2500().mo906(m2505().getHolder().getSurface());
            }
            m2453();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱʼ  reason: contains not printable characters */
    public oY m2514() {
        m2520();
        this.f3545 = this.f3542.mo7800();
        return this.f3545;
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    public void m2520() {
        if (this.f3545 != null) {
            if (this.f3542 != null) {
                this.f3542.mo7802(this.f3545);
            } else {
                C1276.m16820().mo5725("releaseVideoGroup but session manager is null");
            }
            this.f3545 = null;
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊॱ */
    public void mo2240() {
        if (C1317As.m3742(NetflixApplication.getInstance())) {
            this.f3518.m2370(PictureInPictureManager.PipAction.PLAY);
        }
        m2488(false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2488(boolean z) {
        m2489(z, false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2489(boolean z, boolean z2) {
        if (m2527()) {
            C1283.m16862("PlayerFragment", "doPause: volume up or down is pressed, do not pause...");
            return;
        }
        boolean r5 = mo2454();
        C1283.m16863("PlayerFragment", "doPause: paused %b", Boolean.valueOf(r5));
        C1283.m16861("playback paused.");
        if (z || r5) {
            if (!z2 && this.f3534 != null) {
                this.f3534.m12522(true);
            }
            long r6 = mo2518();
            if (this.f3528 != null) {
                this.f3528.m12277(2);
            }
            C1283.m16854("PlayerFragment", "Pause, release awake clock after 2 minutes.");
            this.f3494.postDelayed(this.f3529, 120000);
            this.f3494.postDelayed(this.f3493, 900000);
            C1283.m16862("PlayerFragment", "doPause() remove reporting");
            m2496(true, r6);
        }
    }

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    public long mo2518() {
        if (this.f3532.f11448 != PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            C1283.m16862("PlayerFragment", "doPause: Invalid state, exit...:" + this.f3532.f11448.m2539());
            mo2248();
            return 0;
        } else if (mo2500() == null) {
            C1283.m16862("PlayerFragment", "doPause: mPlayerSession is null");
            return 0;
        } else {
            this.f3523.mo9034();
            mo2500().mo931();
            return mo2500().mo928();
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋॱ */
    public void mo2247() {
        C1283.m16863("PlayerFragment", "doUnpause: resume mPlayerBackgrounded=%b pausePlaybackOnPlayerBackgrounded=%b playing=%b", Boolean.valueOf(this.f3524), Boolean.valueOf(this.f3536), Boolean.valueOf(mo2454()));
        C1283.m16861("playback resumed");
        if (mo2471() || m2462()) {
            if (this.f3534 != null) {
                this.f3534.m12522(false);
            }
            m2499();
            if (m2462()) {
                this.f3532.m12287(SystemClock.elapsedRealtime());
                m2502();
                m2512(false);
                if (this.f3536) {
                    C1283.m16854("PlayerFragment", "Pause playback is true, so not resuming playback from player backgrounded case.");
                } else {
                    mo2519();
                }
            } else {
                long r5 = mo2517();
                if (this.f3528 != null) {
                    this.f3528.m12277(3);
                }
                m2496(false, r5);
            }
        }
    }

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    public long mo2517() {
        if (this.f3532.f11448 != PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            C1283.m16862("PlayerFragment", "doUnpause: Invalid state, exit...:" + this.f3532.f11448.m2539());
            mo2248();
            return 0;
        } else if (mo2500() == null) {
            C1283.m16862("PlayerFragment", "doUnpause: session is null");
            return 0;
        } else {
            this.f3523.mo9034();
            mo2500().mo929();
            return mo2500().mo928();
        }
    }

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    public void mo2519() {
        if (this.f3523 != null) {
            this.f3523.mo9031();
        }
        if (mo2500() != null) {
            mo2500().mo919(-5000, 5000);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2393(CommandEndedEvent.InputValue inputValue, int i) {
        try {
            C1364Cj.m4454(UIViewLogging.UIViewCommandName.seek, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap, new JSONObject().put("mediaOffset", i));
        } catch (JSONException e) {
            C1276.m16820().mo5729("Error reporting seek to CL", e);
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public void mo2258(int i) {
        m2393(CommandEndedEvent.InputValue.tap, i);
        m2485(i, false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m2467(int i) {
        m2393(CommandEndedEvent.InputValue.swipe, i);
        m2485(i, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2485(int i, boolean z) {
        if (this.f3534 != null) {
            this.f3534.m12514(false);
            this.f3532.f11442 = true;
            m2435();
            this.f3537.onNext(IPlayerFragment.PublisherEvents.ON_PLAYER_BUFFERING);
            if (this.f3534 != null) {
                this.f3534.m12522(false);
            }
            mo2468(i, z);
            if (mo2500() != null) {
                m2496(true, mo2500().mo928());
            }
            if (this.f3523 != null) {
                this.f3523.mo9031();
            }
            if (this.f3534.m12518() != null) {
                this.f3534.m12518().m12390();
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2468(int i, boolean z) {
        if (this.f3532.f11448 != PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            C1283.m16862("PlayerFragment", "doSeek: Invalid state, exit...:" + this.f3532.f11448.m2539());
            mo2248();
        }
        if (mo2500() == null) {
            return;
        }
        if (!z) {
            C1283.m16854("PlayerFragment", "==> doSeek: " + i);
            C1283.m16861("playback seek to " + i);
            mo2500().mo897((long) i, false);
            return;
        }
        C1283.m16854("PlayerFragment", "==> doSeek: skip " + i);
        C1283.m16861("playback skip " + i);
        mo2500().mo919(i, 5000);
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    public void mo2521() {
        if (this.f3532.f11448 != PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            C1283.m16862("PlayerFragment", "doZoomIn: Invalid state, exit...:" + this.f3532.f11448.m2539());
            mo2248();
            return;
        }
        C1283.m16862("PlayerFragment", "doZoomIn: start");
        if (this.f3534 != null) {
            this.f3534.mo12507(false);
            this.f3534.m12492(true);
        }
    }

    /* renamed from: ꓸ  reason: contains not printable characters */
    public void mo2524() {
        if (this.f3532.f11448 != PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            C1283.m16862("PlayerFragment", "doZoomIn: Invalid state, exit...:" + this.f3532.f11448.m2539());
            mo2248();
            return;
        }
        C1283.m16854("PlayerFragment", "doZoomOut: start");
        if (this.f3534 != null) {
            this.f3534.mo12507(true);
            this.f3534.m12492(false);
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.hardKeyboardHidden == 1) {
            C1283.m16854("PlayerFragment", "keyboard out");
        } else if (configuration.hardKeyboardHidden == 2) {
            C1283.m16854("PlayerFragment", "keyboard in");
        }
        if (this.f3534 != null) {
            this.f3534.mo12517(configuration);
        }
    }

    @Override // o.oM.AbstractC0160
    /* renamed from: ˎ */
    public void mo2353(Watermark watermark) {
        C1348Bu.m4093();
        if (this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            try {
                Point point = m2452().getPlaybackDisplaySpec().aspectRatioDimension;
                int i = point.x;
                int i2 = point.y;
                if (!(i == 0 || i2 == 0 || this.f3534 == null)) {
                    m2412(i, i2);
                    this.f3534.m12490(m2433());
                }
                Point point2 = m2452().getPlaybackDisplaySpec().croppedAspectRatioDimension;
                if (!(point2 == null || point2.x == 0 || point2.y == 0)) {
                    m2402(point2.x, point2.y);
                }
                if (!(this.f3534 == null || watermark == null)) {
                    this.f3534.m12526(watermark);
                }
                m2522();
                this.f3516 = m2452().getGopMaxSizeInMs();
            } catch (Exception e) {
                C1276.m16820().mo5729("Failed to start player", e);
                mo2248();
            }
        } else {
            C1283.m16850("PlayerFragment", "onPrepared not in correct state, ActivityState: " + this.f3532.f11448.m2539());
            mo2248();
        }
    }

    /* renamed from: ᶥ  reason: contains not printable characters */
    public void m2522() {
        if (mo2500() != null) {
            Subtitle[] r6 = this.f3541.mo890();
            AudioSource[] r7 = this.f3541.mo7753();
            AudioSubtitleDefaultOrderInfo[] r8 = this.f3541.mo894();
            C1283.m16854("PlayerFragment", "Create localization manager");
            boolean z = false;
            AN r11 = new C2266wh(getActivity(), r6, r7, r8, mo2255()).m12429();
            AudioSource r12 = r11.m3394();
            int i = -1;
            if (r12 != null) {
                i = r12.getNccpOrderNumber();
            } else {
                C1283.m16854("PlayerFragment", "No need to set initial audio source");
            }
            Subtitle r14 = r11.m3395();
            int i2 = -1;
            if (r14 != null) {
                i2 = r14.getNccpOrderNumber();
                z = true;
            } else {
                C1283.m16854("PlayerFragment", "No need to set initial subtitle");
            }
            this.f3541.mo901(r12);
            this.f3541.mo918(r14, false);
            this.f3523.mo9032(this.f3541);
            m2495(z);
            m2475(new Language(r7, i, r6, i2, z));
        }
    }

    @Override // o.oM.AbstractC0160
    public synchronized void ac_() {
        C1283.m16854("PlayerFragment", "Playout started: " + mo2268());
        C1348Bu.m4093();
        if (this.f3512.m12545() == null || this.f3532.f11448 != PlayerFragmentState.ACTIVITY_PLAYER_READY || C1317As.m3750(getActivity())) {
            if (m14535()) {
                C1362Ch.m4408(IClientLogging.CompletionReason.failed, new UIError(RootCause.clientFailure, ActionOnUIError.handledSilently, null, null), null, m2446());
            }
            this.f3532.f11451.set(false);
            mo2248();
            return;
        }
        if (mo2500() == null) {
            mo2248();
        }
        mo2500().mo915(1.0f);
        m2526();
        C1283.m16861((mo2255() ? "Offline" : "Streaming") + " playback started");
    }

    /* renamed from: ꜟ  reason: contains not printable characters */
    public void m2526() {
        this.f3537.onNext(IPlayerFragment.PublisherEvents.ON_PLAYER_STARTED);
        C1283.m16854("PlayerFragment", "handleEveryPlaybackStart.");
        int r5 = mo2500() != null ? (int) mo2500().mo928() : 0;
        long r6 = this.f3512.m12548();
        C1283.m16851("PlayerFragment", "handleEveryPlaybackStart, position: %d,  duration: %d", Integer.valueOf(r5), Long.valueOf(r6));
        this.f3532.f11457 = true;
        if (this.f3534 != null) {
            this.f3534.m12510((int) r6);
            this.f3534.m12500(r5, (int) r6, true);
            this.f3534.mo12528();
        }
        C1362Ch.m4408(IClientLogging.CompletionReason.success, null, null, m2446());
        this.f3532.f11451.set(false);
        boolean z = m2443() || mo2241();
        if (this.f3534 != null) {
            this.f3534.mo12507(z);
            this.f3534.m12492(!z);
            this.f3534.mo12465();
        }
        m2436();
        if (C1317As.m3742(NetflixApplication.getInstance())) {
            this.f3518.m2370(PictureInPictureManager.PipAction.PAUSE);
        }
        if (this.f3528 != null) {
            this.f3528.m12278();
        }
        if (this.f3532.f11454) {
            C1283.m16854("PlayerFragment", "Dismissing buffering progress bar...");
            this.f3532.f11442 = false;
            this.f3532.f11444 = false;
            this.f3532.f11454 = false;
            this.f3527 = false;
            m2499();
            if (this.f3534 != null) {
                this.f3534.m12514(true);
                this.f3534.mo12450(false);
                C1283.m16854("PlayerFragment", "Remove bif image if it was visible. Only for phones!!!");
                if (!this.f3520) {
                    this.f3534.mo12451();
                }
            }
        }
        this.f3539 = false;
        if (this.f3534 != null) {
            this.f3534.m12495(true);
            if (mo2255()) {
                this.f3534.m12522(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ㆍ  reason: contains not printable characters */
    public void m2523() {
        if (mo2500() != null) {
            this.f3512.m12551((int) (mo2500().mo928() / 1000));
        }
    }

    @Override // o.oM.AbstractC0160
    /* renamed from: ˊ */
    public synchronized void mo2351(IPlayer.PlayerStallReason playerStallReason) {
        C1283.m16865("PlayerFragment", "Playout stalled");
        C1348Bu.m4093();
        if (this.f3534 != null && m14535()) {
            C1283.m16854("PlayerFragment", "Playout stalled, clear pending updates");
            this.f3523.mo9034();
            if (this.f3532.f11442 || this.f3532.f11444) {
                C1283.m16854("PlayerFragment", "Seek in progress...");
                return;
            }
            this.f3537.onNext(IPlayerFragment.PublisherEvents.ON_PLAYER_BUFFERING);
            switch (playerStallReason) {
                case avStalled:
                    this.f3532.f11454 = true;
                    break;
                case subtitleStalled:
                    this.f3532.f11450 = true;
                    break;
            }
            this.f3534.m12514(false);
            this.f3534.m12522(false);
            this.f3534.mo12450(true);
            if (this.f3532.f11447) {
                C1283.m16854("PlayerFragment", "Enabled Toast");
                C1004.m15958(getActivity(), (int) R.string.label_lowBandwidth_2, 1);
            }
        }
    }

    @Override // o.oM.AbstractC0160
    public void ad_() {
        C1283.m16854("PlayerFragment", "onCompletion, check if we are in postplay or in preplay");
        m2481();
        if (this.f3534 != null && !this.f3534.m12497()) {
            C1283.m16854("PlayerFragment", "onCompletion, In PostPlay, allow screen to lock after timeout...");
            this.f3494.postDelayed(this.f3529, 120000);
        } else if (this.f3530.m12375()) {
            C1283.m16854("PlayerFragment", "OnCompletion of preplay.");
            C2279wu r9 = this.f3530.m12373();
            mo2248();
            PlaybackLauncher.m1610(m14534(), r9.m12545(), r9.m12546(), r9.m12563(), r9.m12555(), true, r9.m12550(), r9.m12559(), true);
        } else {
            C1283.m16854("PlayerFragment", "OnCompletion - exiting.");
            m2487((C2279wu) null, PlaybackLauncher.PlayLaunchedBy.LaunchActivity);
            mo2248();
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʿ */
    public void mo2232() {
        C1283.m16862("PlayerFragment", "performUpAction");
        NetflixActivity r3 = m14534();
        C1364Cj.m4442(UIViewLogging.UIViewCommandName.actionBarBackButton, r3.getUiScreen().f4084, r3.getDataContext());
        C2279wu r4 = this.f3530.m12375() ? this.f3530.m12373() : this.f3512;
        mo2525();
        m2487(r4, PlaybackLauncher.PlayLaunchedBy.LaunchActivity, PlaybackLauncher.PlayLaunchedBy.HomeScreen);
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

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2487(C2279wu wuVar, PlaybackLauncher.PlayLaunchedBy... playLaunchedByArr) {
        if (wuVar != null && m14534() != null) {
            boolean z = mo2237(playLaunchedByArr) || this.f3521;
            C1283.m16863("PlayerFragment", "launchDetailScreenIfRequired launchDetailsScreen=%b", Boolean.valueOf(z));
            if (z && wuVar != null) {
                oX r8 = wuVar.m12563();
                if (wuVar.m12545() != null && r8 != null) {
                    VideoType r9 = wuVar.m12546();
                    if (r9 == VideoType.EPISODE) {
                        r9 = VideoType.SHOW;
                    }
                    if (this.f3521) {
                        m14534().finishAndRemoveTask();
                    }
                    qU.m9966(m14534(), r9, wuVar.m12545().getTopLevelId(), wuVar.m12545().getParentTitle(), r8, "PlayerFragment");
                }
            }
        }
    }

    /* renamed from: ꜞ  reason: contains not printable characters */
    public void mo2525() {
        m2476(IClientLogging.CompletionReason.success);
        if (m2462()) {
            m2512(false);
        }
        if (this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            m2417();
        }
        m2481();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋᐝ */
    public void mo2248() {
        C1283.m16854("PlayerFragment", "cleanupAndExit");
        mo2525();
        this.f3532.f11448 = PlayerFragmentState.ACTIVITY_NOTREADY;
        C1283.m16854("PlayerFragment", "cleanupAndExit calling finish");
        if (!C1317As.m3750(m14534()) && !getActivity().isChangingConfigurations()) {
            m2504();
        }
    }

    /* renamed from: ﾞ  reason: contains not printable characters */
    public void m2529() {
        FragmentActivity activity;
        C1283.m16854("PlayerFragment", "cleanupAndExit");
        mo2525();
        this.f3532.f11448 = PlayerFragmentState.ACTIVITY_NOTREADY;
        C1283.m16854("PlayerFragment", "cleanupAndExit calling finish");
        if (!C1317As.m3750(m14534()) && !getActivity().isChangingConfigurations() && (activity = getActivity()) != null && !activity.isFinishing() && mo2265()) {
            activity.finishAndRemoveTask();
        }
    }

    /* renamed from: ߺ  reason: contains not printable characters */
    private void m2417() {
        C1283.m16854("PlayerFragment", "stopPlayback");
        if (this.f3532.f11451.getAndSet(false)) {
            C1283.m16854("PlayerFragment", "Start play is in progress and user canceled playback");
            C1362Ch.m4408(IClientLogging.CompletionReason.canceled, null, null, m2446());
        }
        if (this.f3532.f11448 == PlayerFragmentState.ACTIVITY_SRVCMNGR_READY || this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_READY) {
            m2438();
            this.f3532.f11448 = PlayerFragmentState.ACTIVITY_NOTREADY;
            if (this.f3534 != null) {
                this.f3534.m12532(false);
            }
            this.f3537.onNext(IPlayerFragment.PublisherEvents.ON_PLAYER_STOPPED);
            if (this.f3512 != null) {
                m2530();
            }
        }
        this.f3512 = null;
        IClientLogging iClientLogging = null;
        C2059ph r5 = m14536();
        if (r5 != null) {
            iClientLogging = r5.m9825();
        }
        if (iClientLogging != null) {
            iClientLogging.mo1504().mo5775("setting currentPlaybackItem to null");
        }
        if (this.f3528 != null) {
            this.f3528.m12280();
        }
    }

    /* renamed from: ʹ  reason: contains not printable characters */
    public void m2453() {
        if (this.f3512 != null && this.f3512.m12545() != null) {
            getActivity().sendBroadcast(m2473("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_START", this.f3512));
            C1283.m16846("PlayerFragment", "Intent PLAYER_PLAY_START sent");
        }
    }

    /* renamed from: ﾟ  reason: contains not printable characters */
    public void m2530() {
        if (m14535() && this.f3512 != null && this.f3512.m12545() != null) {
            C1306Ah.m3615().m3622(this.f3512.m12545().isPinProtected(), this.f3512.m12545().isPreviewProtected());
            getActivity().sendBroadcast(m2473("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP", this.f3512));
            m2425();
            C1283.m16846("PlayerFragment", "Intent PLAYER_PLAY_STOP sent");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Intent m2473(String str, C2279wu wuVar) {
        return C2058pg.m9730(str, wuVar.m12545().getPlayableId(), wuVar.m12556(), wuVar.m12546(), wuVar.m12555(), wuVar.m12558().mo9715());
    }

    /* renamed from: ॱˈ  reason: contains not printable characters */
    private void m2425() {
        vO.m12015(m14536(), m2423(), this.f3512 == null ? null : C2052pa.m9718(this.f3512.m12562(), this.f3512.m12555()));
    }

    /* renamed from: ॱʾ  reason: contains not printable characters */
    private String m2423() {
        C2059ph r1 = m14536();
        if (r1 != null) {
            return r1.m9835();
        }
        return null;
    }

    /* renamed from: ﹳ  reason: contains not printable characters */
    public void m2528() {
        m2499();
        if (m14535()) {
            this.f3532.m12287(SystemClock.elapsedRealtime());
            m2502();
            m2388(0);
            m2482();
        }
        if (this.f3534 != null) {
            this.f3534.m12514(true);
        }
        mo2247();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ꞌ  reason: contains not printable characters */
    public boolean m2527() {
        return System.currentTimeMillis() - this.f3532.f11455 < 500;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱʿ  reason: contains not printable characters */
    private void m2424() {
        NetflixActivity r4 = m14534();
        if (r4 != null && !C1317As.m3750(r4) && this.f3512 != null) {
            pF r5 = this.f3512.m12545();
            this.f3526 = C2116re.m10364(r5.getTopLevelId(), r5.getPlayableId(), false);
            this.f3526.onManagerReady(m14536(), AbstractC0367.f13235);
            this.f3526.setCancelable(true);
            this.f3526.setStyle(1, R.style.res_2131951876_netflixdialog_episodes);
            this.f3526.m14471(m2498().getDecorView().getSystemUiVisibility());
            if (this.f3526 instanceof C2172tc) {
                ((C2172tc) this.f3526).m11100(r5.getTopLevelId(), r5.getPlayableId());
            }
            m2530();
            r4.showDialog(this.f3526);
            C1364Cj.m4434(UIViewLogging.UIViewCommandName.viewEpisodesSelector, IClientLogging.ModalView.episodesSelector, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2494(Language language) {
        boolean z;
        if (mo2226() != null && m14535()) {
            C1355Ca.m4328(getActivity(), language);
            AudioSource selectedAudio = language.getSelectedAudio();
            Subtitle selectedSubtitle = language.getSelectedSubtitle();
            boolean z2 = false;
            if (selectedSubtitle == null) {
                C1283.m16854("PlayerFragment", "Selected subtitle is NONE");
                z = false;
                z2 = true;
            } else {
                z = true;
            }
            mo2245().mo9033(z);
            if (selectedAudio.getNccpOrderNumber() != language.getCurrentNccpAudioIndex()) {
                z2 = true;
                C1283.m16854("PlayerFragment", "Start change language, get awake clock");
            } else {
                C1283.m16854("PlayerFragment", "No need to change audio.");
            }
            if (selectedSubtitle == null) {
                C1283.m16854("PlayerFragment", "Subtitle is off");
                z2 = true;
            } else if (selectedSubtitle.getNccpOrderNumber() != language.getCurrentNccpSubtitleIndex()) {
                z2 = true;
            } else {
                C1283.m16854("PlayerFragment", "No need to change subtitle.");
            }
            if (z2) {
                C1283.m16854("PlayerFragment", "Reloading tracks");
                mo2511(language);
                return;
            }
            C1283.m16854("PlayerFragment", "No need to switch tracks");
            mo2247();
            m2482();
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ͺ */
    public void mo2256() {
        m2493(-30000);
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱˊ */
    public void mo2264() {
        m2493(30000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2493(int i) {
        this.f3532.m12287(SystemClock.elapsedRealtime());
        m2502();
        C1364Cj.m4434(UIViewLogging.UIViewCommandName.seek, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
        m2485(i, true);
    }

    @Override // o.C0567.Cif
    public void N_() {
        DialogFragment dialogFragment = m14534().getDialogFragment();
        if (dialogFragment instanceof C0567.Cif) {
            ((C0567.Cif) dialogFragment).N_();
        }
    }

    /* renamed from: ʼˋ  reason: contains not printable characters */
    public wV m2458() {
        return this.f3530;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m2469(long j) {
        this.f3532.m12287(j);
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊˋ */
    public C2279wu mo2239() {
        return this.f3530.m12375() ? this.f3530.m12373() : this.f3512;
    }

    /* renamed from: ʻˊ  reason: contains not printable characters */
    public boolean mo2454() {
        return mo2500() != null && mo2500().mo892();
    }

    /* renamed from: com.netflix.mediaclient.ui.player.PlayerFragment$ˊ  reason: contains not printable characters */
    public class C0040 implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: ˋ  reason: contains not printable characters */
        protected int f3592;

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean f3594;

        /* renamed from: ॱ  reason: contains not printable characters */
        protected boolean f3595 = true;

        public C0040() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if ((C0650.m14806() || Config_Ab9454_InPlayerPivots.m525()) && PlayerFragment.this.f3532.f11440 && Math.abs(seekBar.getProgress() - i) <= this.f3592) {
                if (this.f3595) {
                    this.f3595 = false;
                } else {
                    C2274wp.m12442(seekBar);
                }
            }
            if (z && PlayerFragment.this.f3532.f11440 && PlayerFragment.this.mo2500() != null) {
                if (PlayerFragment.this.f3534 != null) {
                    PlayerFragment.this.f3534.m12500(i, -1, false);
                }
                ByteBuffer r3 = PlayerFragment.this.mo2500().mo905((long) i);
                if (PlayerFragment.this.f3534 != null) {
                    PlayerFragment.this.f3534.mo12462(r3);
                }
            } else if (!z && PlayerFragment.this.f3532.f11440 && PlayerFragment.this.f3534 != null) {
                PlayerFragment.this.f3534.m12500(i, -1, false);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public synchronized void onStartTrackingTouch(SeekBar seekBar) {
            this.f3595 = true;
            this.f3592 = (int) (((double) seekBar.getMax()) * 0.003d);
            PlayerFragment.this.f3532.f11440 = true;
            ((C1081) seekBar).m16171(true);
            PlayerFragment.this.m2489(false, true);
            if (!(PlayerFragment.this.f3534 == null || PlayerFragment.this.f3534.m12518() == null)) {
                PlayerFragment.this.f3534.m12518().mo12391(false);
            }
            if (PlayerFragment.this.f3523 != null) {
                PlayerFragment.this.f3523.mo9033(false);
            }
            C1283.m16854("PlayerFragment", "Start seek, get awake clock");
            PlayerFragment.this.m2499();
            PlayerFragment.this.m2481();
            if (!(PlayerFragment.this.mo2500() == null || PlayerFragment.this.f3534 == null)) {
                PlayerFragment.this.f3534.m12504(PlayerFragment.this.mo2500().mo905((long) seekBar.getProgress()));
            }
            if (PlayerFragment.this.f3534 != null) {
                PlayerFragment.this.f3534.mo12456();
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private boolean m2541(C1081 r4) {
            if (r4 == null || PlayerFragment.this.f3534 == null || r4.getProgress() != PlayerFragment.this.f3534.m12531()) {
                return false;
            }
            C1283.m16854("PlayerFragment", "Back to start position after snap, do NOT seek!");
            PlayerFragment.this.f3532.f11449 = true;
            return true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public synchronized void onStopTrackingTouch(SeekBar seekBar) {
            PlayerFragment.this.f3532.f11440 = false;
            C1283.m16854("PlayerFragment", "onStopTrackingTouch called");
            if (seekBar instanceof C1081) {
                C1081 r2 = (C1081) seekBar;
                boolean z = this.f3594 || m2541(r2);
                if (z) {
                    C1283.m16854("PlayerFragment", "Do not seek!");
                    r2.setProgress(r2.getProgress());
                    PlayerFragment.this.m2467(r2.getProgress());
                } else if (PlayerFragment.this.f3534 != null) {
                    int r4 = PlayerFragment.this.m2401(PlayerFragment.this.f3534.m12531());
                    r2.setProgress(r4);
                    C1283.m16854("PlayerFragment", "Seek!");
                    PlayerFragment.this.m2467(r4);
                }
                if (PlayerFragment.this.f3534 != null) {
                    PlayerFragment.this.f3534.mo12468();
                }
                if (PlayerFragment.this.f3523 != null) {
                    PlayerFragment.this.f3523.mo9033(true);
                }
                r2.m16171(false);
                if (PlayerFragment.this.f3534 != null) {
                    PlayerFragment.this.f3534.m12525(!z);
                }
                C1364Cj.m4447(IClientLogging.ModalView.trickplayScrubberThumb, null);
                return;
            }
            C1283.m16850("PlayerFragment", "PlayerFragment got not a Netflix seekbar!");
            C1276.m16820().mo5727("PlayerFragment got not a Netflix seekbar!");
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean m2543(SeekBar seekBar, MotionEvent motionEvent, int i) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f3594 = false;
                    onStartTrackingTouch(seekBar);
                    onProgressChanged(seekBar, i, true);
                    return true;
                case 1:
                    if (m2540(seekBar, motionEvent.getY())) {
                        onProgressChanged(seekBar, seekBar.getProgress(), true);
                        PlayerFragment.this.f3532.f11449 = true;
                    }
                    onStopTrackingTouch(seekBar);
                    return true;
                case 2:
                    if (!m2540(seekBar, motionEvent.getY())) {
                        onProgressChanged(seekBar, i, true);
                        this.f3594 = false;
                        return true;
                    } else if (this.f3594) {
                        return true;
                    } else {
                        m2542(seekBar, seekBar.getProgress());
                        this.f3594 = true;
                        return true;
                    }
                default:
                    return false;
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private boolean m2540(SeekBar seekBar, float f) {
            float dimension = PlayerFragment.this.getResources().getDimension(R.dimen.player_gap_to_cancel_progress);
            int height = PlayerFragment.this.f3520 ? (int) (2.0f * dimension) : seekBar.getHeight();
            if (C0650.m14799() || Config_Ab9454_InPlayerPivots.m517()) {
                height = 300;
                dimension = 300.0f;
            }
            return f < (-dimension) || f > ((float) height);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public void m2542(final SeekBar seekBar, final int i) {
            if (PlayerFragment.this.f3534 != null) {
                PlayerFragment.this.f3534.m12511(i, new Runnable() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.ˊ.3
                    @Override // java.lang.Runnable
                    public void run() {
                        C0040.this.onProgressChanged(seekBar, i, true);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private int m2401(int i) {
        return (i / SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS) * SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS;
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        if (!m14535()) {
            C1283.m16865("PlayerFragment", "onManagerReady() was called when activity is already not in valid state - skipping...");
            return;
        }
        C1348Bu.m4093();
        this.f3520 = m14534().isTablet();
        this.f3515 = wT.m12351(this.f3520);
        this.f3542 = phVar.m9759();
        Bundle arguments = getArguments();
        if (this.f3512 == null && arguments != null) {
            String string = arguments.getString(NetflixActivity.EXTRA_VIDEO_ID);
            if (C1349Bv.m4113(string)) {
                C1276.m16820().mo5730(new IllegalStateException("unable to start playback with invalid video id"));
                m2504();
                return;
            }
            VideoType create = VideoType.create(arguments.getString(NetflixActivity.EXTRA_VIDEO_TYPE_STRING_VALUE));
            if (create == null) {
                C1276.m16820().mo5730(new IllegalStateException("unable to start playback with invalid video type"));
                m2504();
                return;
            }
            oX oXVar = (oX) arguments.getParcelable(NetflixActivity.EXTRA_PLAY_CONTEXT);
            if (oXVar == null) {
                C1276.m16820().mo5725("Empty context passed in intent");
                oXVar = new oB("PlayerFragment");
            }
            m2397(phVar, string, create, oXVar, arguments.getInt("extra_bookmark_seconds_from_start_param", -1));
        }
        if (arguments != null) {
            this.f3532.m12291(arguments.getInt("EXTRA_AUTO_PLAY_COUNT", 0));
        }
        if (m14535() && !mo2255()) {
            m2484(AD.m3299() ? R.layout.playout_tablet_episode : R.layout.playout_phone_episode);
        }
        if (phVar.m9756() != null) {
            phVar.m9756().mo5361();
        }
        if (getActivity() != null) {
            C1328Ba.m3985(phVar, getActivity().getIntent());
        }
    }

    @Override // o.AbstractC0517, o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
        C1283.m16850("PlayerFragment", "NetflixService is NOT available!");
        mo2248();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        if (this.f3525 == menu) {
            if (this.f3534 == null || this.f3534.m12508() == null || getView() == null) {
                C1283.m16865("PlayerFragment", "onCreateOptionsMenu() was triggered before UI was initialized. Scheduling panel menu update to be called later.");
                this.f3531 = menu;
                return;
            }
            this.f3534.m12508().m12886(menu);
            this.f3531 = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f3534 == null || this.f3534.m12508() == null || !this.f3534.m12508().m12899(menuItem)) {
            return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int mo2492(PostPlayFactory.PostPlayType postPlayType) {
        return C2275wq.m12477(postPlayType);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo2478(pT pTVar) {
        C1283.m16846("PlayerFragment", "updateUI, details: " + pTVar);
        C2059ph r4 = m14536();
        if (r4 == null || !m14535()) {
            C1283.m16865("PlayerFragment", "Wrong activity state, finishing activity ");
            m2504();
            return false;
        }
        PostPlayFactory.PostPlayType r5 = PostPlay.m2546(m14534(), this.f3512.m12545(), this.f3512.m12546());
        m2484(mo2492(r5));
        mo2455();
        pV r6 = vO.m12017(r4, this.f3512.m12545().getPlayableId());
        if (r4.m9774(r6)) {
            this.f3512.m12552(IPlayer.PlaybackType.OfflinePlayback);
            DialogC1104.Cif r7 = m2392(r6.mo6912());
            if (r7 != null) {
                m14534().displayDialog(r7);
                return false;
            }
        } else {
            this.f3512.m12552(IPlayer.PlaybackType.StreamingPlayback);
        }
        this.f3498 = r4.m9827();
        if (this.f3498 == null) {
            C1283.m16854("PlayerFragment", "Unable to receive handle to config, finishing activity ");
            m2504();
            return false;
        }
        r4.m9754();
        qX.m10015(r4);
        this.f3534 = mo2474(mo2456(), r5);
        this.f3534.m12537(C1339Bl.m4051(getActivity().getBaseContext(), "ui.playergraphicref", false));
        this.f3534.mo12472(pTVar, this.f3512.m12556());
        if (this.f3531 != null && !mo2241()) {
            this.f3531.clear();
            if (this.f3534 != null) {
                this.f3534.m12508().m12886(this.f3531);
            }
            getActivity().invalidateOptionsMenu();
        }
        if (!C0913.m15712() && m2505() != null) {
            m2505().setSecure(true);
        }
        mo2233();
        m2430();
        m2426();
        m2428();
        mo2457();
        this.f3532.f11448 = PlayerFragmentState.ACTIVITY_SRVCMNGR_READY;
        return true;
    }

    /* renamed from: ʼˊ  reason: contains not printable characters */
    public void mo2457() {
    }

    /* renamed from: ʻˋ  reason: contains not printable characters */
    public void mo2455() {
        Toolbar toolbar = (Toolbar) this.f3522.findViewById(R.id.top_panel_toolbar);
        if (toolbar != null) {
            this.f3525 = toolbar.getMenu();
            m14534().setSupportActionBar(toolbar);
            return;
        }
        C1276.m16820().mo5727("Trying to set tool bar while is not inflated - , is in NetflixVideoView AB test? " + C0913.m15712());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C2275wq mo2474(C2275wq.C0256 r2, PostPlayFactory.PostPlayType postPlayType) {
        return C2275wq.m12486(this, r2, postPlayType);
    }

    /* renamed from: ॱˑ  reason: contains not printable characters */
    private void m2430() {
        m14534().registerReceiverWithAutoUnregister(this.f3490, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        m14534().registerReceiverWithAutoUnregister(this.f3547, wD.m12273());
        m14534().registerReceiverWithAutoUnregister(this.f3495, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        m14534().registerReceiverWithAutoUnregister(this.f3496, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        m14534().registerReceiverWithAutoUnregister(this.f3491, new IntentFilter("com.netflix.mediaclient.intent.action.END_PIP"));
        m2431();
    }

    /* renamed from: ॱـ  reason: contains not printable characters */
    private void m2431() {
        this.f3511 = new OrientationEventListener(getActivity()) { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.10

            /* renamed from: ˎ  reason: contains not printable characters */
            int f3551;

            /* renamed from: ˏ  reason: contains not printable characters */
            final int f3552 = 10;

            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i) {
                if (PlayerFragment.this.m14535() && i != -1) {
                    if (Math.abs(i - this.f3551) > 10) {
                        PlayerFragment.this.m2502();
                    }
                    this.f3551 = i;
                }
            }
        };
        this.f3511.enable();
    }

    /* renamed from: ॱˉ  reason: contains not printable characters */
    private void m2426() {
    }

    /* renamed from: ॱˌ  reason: contains not printable characters */
    private void m2428() {
    }

    /* renamed from: ʻᐝ  reason: contains not printable characters */
    public C2275wq.C0256 mo2456() {
        C2275wq.C0256 r1 = new C2275wq.C0256();
        r1.f11691 = new C0040();
        r1.f11695 = this.f3492;
        r1.f11697 = this.f3507;
        r1.f11688 = this.f3510;
        r1.f11692 = this.f3506;
        r1.f11693 = this.f3497;
        r1.f11694 = this.f3502;
        r1.f11689 = this.f3500;
        r1.f11690 = this.f3504;
        r1.f11696 = this.f3503;
        return r1;
    }

    /* renamed from: ʼᐝ  reason: contains not printable characters */
    public void m2459() {
        if (this.f3534 != null && this.f3534.m12493() != PlayerUiState.PostPlay) {
            this.f3534.m12498();
            this.f3532.m12287(0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m2388(int i) {
        this.f3494.removeCallbacks(this.f3548);
        this.f3494.postDelayed(this.f3548, (long) i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˍ  reason: contains not printable characters */
    private void m2429() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱꓸ  reason: contains not printable characters */
    private void m2437() {
        PlayerManifestData r2 = m2452();
        if (mo2500() != null && !this.f3532.f11440 && r2 != null) {
            int r3 = (int) mo2500().mo928();
            int duration = (int) r2.getDuration();
            if (mo2500().mo892() && this.f3534 != null) {
                this.f3534.m12500(r3, duration, true);
            }
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱˋ */
    public boolean mo2265() {
        return C1317As.m3742(NetflixApplication.getInstance()) && this.f3518.m2368();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2512(boolean z) {
        this.f3524 = z;
    }

    /* renamed from: ʽᐝ  reason: contains not printable characters */
    public boolean m2462() {
        return this.f3524;
    }

    /* renamed from: ʾॱ  reason: contains not printable characters */
    public boolean mo2463() {
        return m14535() && ((mo2255() && this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_READY) || (this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_READY && this.f3532.m12295() && !m2470() && !m2466() && !m2464() && this.f3534 != null && this.f3534.m12493() != PlayerUiState.PostPlay && this.f3498 != null && !this.f3498.mo16548() && this.f3498.mo16520().mo14183()));
    }

    /* renamed from: ʽˋ  reason: contains not printable characters */
    public boolean mo2461() {
        return m14535() && C1317As.m3742(getActivity()) && ((mo2255() && this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_READY) || (this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_READY && this.f3532.m12295() && !m2470() && !m2466() && !m2464() && this.f3534 != null && this.f3534.m12493() != PlayerUiState.PostPlay));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo2509(pF pFVar) {
        String r5 = BX.m3956(pFVar.getParentTitle(), BidiMarker.FORCED_RTL);
        String r6 = BX.m3956(pFVar.getPlayableTitle(), BidiMarker.FORCED_RTL);
        if (this.f3512.m12546() != VideoType.EPISODE) {
            return getResources().getString(R.string.title_movie_string, r6);
        }
        String string = getResources().getString(R.string.title_episode_string, r5, pFVar.getSeasonAbbrSeqLabel(), Integer.valueOf(pFVar.getEpisodeNumber()), r6);
        if (pFVar.isNSRE() || pFVar.isEpisodeNumberHidden()) {
            return getResources().getString(R.string.title_episode_string_basic, r5, r6);
        }
        return string;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱᐝ */
    public pF mo2268() {
        if (this.f3512 == null) {
            return null;
        }
        return this.f3512.m12545();
    }

    /* renamed from: ʽˊ  reason: contains not printable characters */
    public VideoType m2460() {
        if (this.f3512 == null) {
            return null;
        }
        return this.f3512.m12546();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2412(int i, int i2) {
        if (m2505() != null) {
            m2505().setVideoWidth(i);
            m2505().setVideoHeight(i2);
            m2505().getHolder().setFixedSize((i * 1080) / i2, 1080);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2402(int i, int i2) {
        if (i != 0 && i2 != 0 && m2505() != null) {
            m2505().setCroppedVideoWidth(i);
            m2505().setCroppedVideoHeight(i2);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2475(Language language) {
        if (language == null) {
            C1283.m16865("PlayerFragment", "Language is null!");
            return;
        }
        C1283.m16854("PlayerFragment", "Sets language");
        this.f3519 = language;
        if (this.f3534 != null) {
            this.f3534.m12519(language);
        }
    }

    /* renamed from: ॱㆍ  reason: contains not printable characters */
    private void m2436() {
        if (m14535()) {
            this.f3532.m12287(SystemClock.elapsedRealtime());
            m2482();
        }
    }

    /* renamed from: ॱᶥ  reason: contains not printable characters */
    private void m2435() {
        C1348Bu.m4093();
        C1283.m16854("PlayerFragment", "onSeek");
        m2465();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˈॱ  reason: contains not printable characters */
    public void m2465() {
        this.f3532.f11454 = true;
        if (this.f3534 != null && !mo2255()) {
            this.f3534.mo12450(true);
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊ */
    public void mo2236(boolean z) {
        if (m14535() && m2497()) {
            if (this.f3534 == null || PlayerUiState.Loading == this.f3534.m12493()) {
                C1283.m16854("PlayerFragment", "UI is not in focus on splash screen. Do NOT pause, ignore.");
                return;
            }
            if (this.f3532.f11448 == PlayerFragmentState.ACTIVITY_PLAYER_READY) {
                if (z) {
                    mo2247();
                } else {
                    mo2240();
                }
            }
            C1283.m16854("PlayerFragment", "onWindowFocusChanged done");
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        switch (i) {
            case -3:
                if (this.f3541 != null) {
                    this.f3541.mo926(true);
                }
                return;
            case PagerAdapter.POSITION_NONE /* -2 */:
                if (this.f3541 != null && this.f3541.mo892()) {
                    this.f3509 = true;
                    m2445(false);
                    return;
                }
                return;
            case -1:
                return;
            case 0:
            default:
                String str = "unknown audio focus: " + i;
                return;
            case 1:
                if (this.f3541 != null) {
                    this.f3541.mo926(false);
                }
                if (this.f3509) {
                    m2415();
                    mo2247();
                    this.f3509 = false;
                    return;
                }
                return;
            case 2:
                return;
            case 3:
                return;
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public boolean mo2263(int i, KeyEvent keyEvent) {
        if (i != 62 && i != 66) {
            return false;
        }
        if (mo2500() == null || !mo2500().mo892()) {
            m2477(false);
            mo2247();
            return true;
        }
        m2477(false);
        m2488(true);
        return true;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˏ */
    public boolean mo2254(int i, KeyEvent keyEvent) {
        this.f3532.m12287(SystemClock.elapsedRealtime());
        m2502();
        if (i == 4) {
            if (this.f3534 == null || !this.f3534.m12515()) {
                C1283.m16854("PlayerFragment", "Back...");
                mo2231();
                mo2248();
                return true;
            }
            C1283.m16854("PlayerFragment", "Back used to dismiss interrupter overlay, send it back to framework");
            return false;
        } else if (i == 84) {
            return true;
        } else {
            if (i == 82) {
                keyEvent.startTracking();
                return true;
            } else if (m2408(i, keyEvent)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m2408(int i, KeyEvent keyEvent) {
        if (i == 96) {
            if (keyEvent.getRepeatCount() > 0) {
                return false;
            }
            C1283.m16846("PlayerFragment", "A button pressed");
            m2477(false);
            this.f3492.onClick(null);
            return true;
        } else if (i == 21 || i == 102) {
            if (this.f3532.f11448 != PlayerFragmentState.ACTIVITY_PLAYER_READY) {
                return false;
            }
            m2477(false);
            mo2256();
            return true;
        } else if (i == 22 || i == 103) {
            if (this.f3532.f11448 != PlayerFragmentState.ACTIVITY_PLAYER_READY) {
                return false;
            }
            m2477(false);
            mo2264();
            return true;
        } else if (i == 93) {
            if (mo2500() == null || !mo2500().mo892()) {
                return true;
            }
            m2477(false);
            m2488(true);
            return true;
        } else if (i == 92) {
            if (mo2500() == null || mo2500().mo892()) {
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

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2477(boolean z) {
        if (this.f3534 != null) {
            this.f3534.mo12460(z);
        } else {
            C1283.m16865("PlayerFragment", "Screen is null!");
        }
    }

    /* renamed from: ˊʻ  reason: contains not printable characters */
    public boolean m2470() {
        return this.f3532.f11454;
    }

    /* renamed from: ˉॱ  reason: contains not printable characters */
    public boolean m2466() {
        if (mo2500() == null) {
            return false;
        }
        return this.f3532.f11442;
    }

    /* renamed from: ˊʼ  reason: contains not printable characters */
    public boolean mo2471() {
        return mo2500() != null && !mo2500().mo892();
    }

    /* renamed from: ʿॱ  reason: contains not printable characters */
    public boolean m2464() {
        return this.f3527;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʻॱ */
    public C2275wq mo2226() {
        return this.f3534;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˏ */
    public String mo2252(int i, String str) {
        return super.getString(i, str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo2511(Language language) {
        C1348Bu.m4093();
        if (language != null) {
            m2475(language);
            if (mo2500() != null) {
                mo2500().mo901(language.getSelectedAudio());
                mo2500().mo918(language.getSelectedSubtitle(), true);
            }
            if (language.getSelectedSubtitle() == null) {
                C1283.m16854("PlayerFragment", "Disable subtitles, none is selected");
                this.f3523.mo9027();
            }
            language.commit();
        }
        C1283.m16854("PlayerFragment", "Language change should be completed");
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˉ */
    public wG mo2234() {
        return this.f3532;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊ */
    public void mo2235(Runnable runnable) {
        this.f3522.post(runnable);
    }

    /* renamed from: ˋʻ  reason: contains not printable characters */
    public void m2479() {
        this.f3532.m12287(SystemClock.elapsedRealtime());
        m2502();
    }

    /* renamed from: ॱᐧ  reason: contains not printable characters */
    private boolean m2433() {
        return true;
    }

    /* renamed from: ˊʽ  reason: contains not printable characters */
    public wT m2472() {
        return this.f3515;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return this.f3539;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˈ */
    public void mo2233() {
        if (this.f3534 == null || this.f3534.m12508() == null || !m14535()) {
            C1283.m16862("PlayerFragment", "Skipping setTargetSelection()");
            return;
        }
        C2059ph r2 = m14536();
        if (r2 == null || !r2.mo9519() || r2.m9811() == null) {
            this.f3534.m12508().mo12902((uW) null);
            return;
        }
        Pair<String, String>[] r3 = r2.m9811().mo6163();
        if (r3 == null || r3.length < 1) {
            this.f3534.m12508().mo12902((uW) null);
            return;
        }
        this.f3534.m12508().mo12902(m2510(r3, r2.m9811().mo6171(), (AbstractC1221) null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public uW m2510(Pair<String, String>[] pairArr, String str, AbstractC1221 r6) {
        return new uW(pairArr, str, (r6 != null ? r6.mo16520() : this.f3498.mo16520()).mo14182());
    }

    /* renamed from: ॱᐨ  reason: contains not printable characters */
    private void m2434() {
        C1348Bu.m4093();
        m14534().displayDialog(C0505.m14491(getActivity(), this.f3494, new C1278(null, getString(R.string.label_nowifi_warning), getString(R.string.label_ok), this.f3505)));
    }

    /* renamed from: ॱﹳ  reason: contains not printable characters */
    private void m2441() {
        m14534().displayDialog(C0505.m14491(getActivity(), this.f3494, new C1278(null, getString(R.string.label_slow_connection), getString(R.string.label_ok), this.f3505)));
    }

    /* renamed from: ॱﾞ  reason: contains not printable characters */
    private void m2442() {
        m14534().displayDialog(C0505.m14491(getActivity(), this.f3494, new C1278(null, getString(R.string.label_startup_nointernet), getString(R.string.label_ok), this.f3505)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋʼ  reason: contains not printable characters */
    public boolean m2480() {
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
            m2441();
            return false;
        } else if (r3 == LogMobileType.WIFI) {
            C1283.m16862("PlayerFragment", "WiFi connection, do playback");
            return true;
        } else {
            boolean r4 = C0577.m14688(getActivity());
            C1283.m16862("PlayerFragment", "3G Preference setting: " + r4);
            if (r4) {
                C1283.m16865("PlayerFragment", "We should warn user if he is on NON WIFI network!");
                m2434();
                return false;
            }
            C1283.m16854("PlayerFragment", "Warning is not required, proceed with playback");
            return true;
        }
    }

    /* renamed from: ˌॱ  reason: contains not printable characters */
    public void m2482() {
        m2388(1000);
        C1283.m16854("PlayerFragment", "===>> Screen update thread started");
    }

    /* renamed from: ˋʽ  reason: contains not printable characters */
    public void m2481() {
        this.f3494.removeCallbacks(this.f3548);
        C1283.m16854("PlayerFragment", "===>> Screen update thread canceled");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏͺ  reason: contains not printable characters */
    public void m2499() {
        if (m14535()) {
            C1283.m16854("PlayerFragment", "KEEP_SCREEN: ON");
            m2498().addFlags(128);
        }
        this.f3494.removeCallbacks(this.f3493);
        this.f3494.removeCallbacks(this.f3529);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱꞌ  reason: contains not printable characters */
    private void m2440() {
        if (m14535()) {
            C1283.m16854("PlayerFragment", "KEEP_SCREEN: OFF");
            m2498().clearFlags(128);
        }
    }

    @Override // o.oM.AbstractC0160
    /* renamed from: ˎ */
    public void mo2354(C1987mr mrVar) {
        if (!m14535()) {
            C1283.m16865("PlayerFragment", "Activity isn't already in a valid state - no need to update the subtitles");
        } else {
            this.f3523.mo9035(mrVar, m2439());
        }
    }

    /* renamed from: ॱꜟ  reason: contains not printable characters */
    private Point m2439() {
        PlayerManifestData r2;
        if (mo2500() == null || (r2 = mo2500().mo904()) == null || r2.getPlaybackDisplaySpec() == null) {
            return null;
        }
        return r2.getPlaybackDisplaySpec().aspectRatioDimension;
    }

    public enum PlayerFragmentState {
        ACTIVITY_NOTREADY(0, "NOTREADY"),
        ACTIVITY_SRVCMNGR_READY(1, "SRVCMNGR_READY"),
        ACTIVITY_PLAYER_READY(2, "PLAYER_READY"),
        ACTIVITY_PLAYER_LOADING_NEXT(3, "PLAYER_LOADING_NEXT");
        

        /* renamed from: ʼ  reason: contains not printable characters */
        String f3590;

        /* renamed from: ˏ  reason: contains not printable characters */
        int f3591;

        private PlayerFragmentState(int i, String str) {
            this.f3591 = i;
            this.f3590 = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: ॱ  reason: contains not printable characters */
        public String m2539() {
            return this.f3590;
        }
    }

    /* renamed from: ˑॱ  reason: contains not printable characters */
    public Language m2501() {
        return this.f3519;
    }

    @Override // o.oM.AbstractC0160
    /* renamed from: ॱ */
    public void mo2355(long j) {
        m2486(j);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2486(long j) {
        if (!m14535() || this.f3512 == null) {
            C1283.m16862("PlayerFragment", "Activity is already not in valid state - sikpping onPlaybackPositionUpdated()");
        } else if (this.f3512 == null) {
            C1276.m16820().mo5725("playback position update with null playbackitem");
        } else {
            if (m2404(j)) {
                this.f3512.m12553(true);
                if (this.f3534 != null) {
                    this.f3534.m12506().m2565();
                }
            }
            if (this.f3534 != null) {
                this.f3534.m12503(j, this.f3512.m12548());
            }
            if (this.f3512.m12545() != null) {
                C1306Ah.m3615().m3622(this.f3512.m12545().isPinProtected(), this.f3512.m12545().isPreviewProtected());
            }
            m2523();
            if (this.f3534 != null && j >= ((long) this.f3534.m12506().m2573(this.f3512.m12545()))) {
                this.f3537.onNext(IPlayerFragment.PublisherEvents.ON_SHOW_POST_PLAY_MARK);
            }
        }
    }

    @Override // o.oM.AbstractC0160
    /* renamed from: ˋ */
    public void mo2352(final IPlayer.aux aux) {
        C2059ph r4;
        this.f3532.f11448 = PlayerFragmentState.ACTIVITY_NOTREADY;
        if (aux instanceof C1935kf) {
            mo2235(new Runnable() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.16
                @Override // java.lang.Runnable
                public void run() {
                    final NetflixActivity r1 = PlayerFragment.this.m14534();
                    if (r1 != null && !PlayerFragment.this.isDetached()) {
                        r1.runWhenManagerIsReady(new NetflixActivity.If() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.16.5
                            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                            public void run(C2059ph phVar) {
                                vV r2 = vV.f11264.m12080((C1935kf) aux);
                                r2.onManagerReady(PlayerFragment.this.m14536(), AbstractC0367.f13235);
                                r2.setCancelable(true);
                                r1.showDialog(r2);
                                PlayerFragment.this.mo2266();
                            }
                        });
                    }
                }
            });
        } else if (aux instanceof C1931kb) {
            mo2235(new Runnable() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.18
                @Override // java.lang.Runnable
                public void run() {
                    NetflixActivity r3 = PlayerFragment.this.m14534();
                    if (r3 != null && !PlayerFragment.this.isDetached()) {
                        if (!PlayerFragment.this.f3520) {
                            r3.setRequestedOrientation(1);
                        }
                        zW r42 = zW.f12754.m13575(PlayerFragment.this.m14534(), ((C1931kb) aux).m8375());
                        r42.setCancelable(true);
                        r42.m13570(new DialogInterface() { // from class: com.netflix.mediaclient.ui.player.PlayerFragment.18.3
                            @Override // android.content.DialogInterface
                            public void cancel() {
                                PlayerFragment.this.mo2248();
                            }

                            @Override // android.content.DialogInterface
                            public void dismiss() {
                                PlayerFragment.this.mo2248();
                            }
                        });
                        r3.showDialog(r42);
                    }
                }
            });
        } else {
            m2520();
            AbstractC1268 r2 = C2316xl.m12949(this, aux);
            if (r2 != null && r2.mo10135() != null && (r4 = m14536()) != null && r4.m9756() != null) {
                r4.m9756().mo5362(r2);
            }
        }
    }

    @Override // o.oM.AbstractC0160
    /* renamed from: ᐝ */
    public void mo2356() {
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊˊ */
    public Handler mo2238() {
        return this.f3494;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public void mo2261(pF pFVar, VideoType videoType, oX oXVar, boolean z, boolean z2, int i, boolean z3) {
        if (!m14535()) {
            C1283.m16854("PlayerFragment", "Activity already destroyed, ignore next!");
            return;
        }
        boolean z4 = this.f3534 != null && this.f3534.m12512();
        if (C1349Bv.m4113(pFVar.getPlayableId())) {
            C1283.m16850("PlayerFragment", "PlayableId is null - skip playback");
            C1276.m16820().mo5727("PlayableId is null - skip playback");
            return;
        }
        if (z) {
            this.f3532.m12284();
        }
        int r10 = this.f3532.m12283();
        mo2248();
        PlaybackLauncher.m1609(m14534(), pFVar, videoType, oXVar, i, z3, z4, false, r10);
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʽॱ */
    public qO.Cif mo2230() {
        return this.f3499;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱˎ */
    public void mo2266() {
        if (mo2500() != null) {
            mo2500().mo931();
        }
        m2438();
        this.f3532.f11446 = false;
        m2465();
    }

    /* renamed from: ॱꜞ  reason: contains not printable characters */
    private void m2438() {
        this.f3517 = false;
        if (mo2500() != null) {
            mo2500().mo921(this);
        }
        if (this.f3523 != null) {
            this.f3523.mo9032((oM) null);
        }
        this.f3541 = null;
        m2520();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐧॱ  reason: contains not printable characters */
    private void m2449() {
        if (m14534().isDialogFragmentVisible()) {
            m14534().removeDialogFrag();
        }
    }

    @Override // o.AbstractC0496.Cif, com.netflix.mediaclient.ui.player.IPlayerFragment
    public AbstractC0496.iF ab_() {
        return this.f3501;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʾ */
    public boolean mo2231() {
        C1283.m16862("PlayerFragment", "handleBackPressed");
        if (this.f3534 == null || !this.f3534.m12515()) {
            C2279wu r3 = this.f3530.m12375() ? this.f3530.m12373() : this.f3512;
            mo2525();
            m2487(r3, PlaybackLauncher.PlayLaunchedBy.LaunchActivity);
            return false;
        }
        this.f3534.m12506().m2570(false);
        return true;
    }

    /* renamed from: ᐝʼ  reason: contains not printable characters */
    private PostPlay m2447() {
        if (this.f3534 == null) {
            return null;
        }
        return this.f3534.m12506();
    }

    @Override // o.oM.AbstractC0160
    public boolean ae_() {
        return this.f3517;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺˏ  reason: contains not printable characters */
    public void m2503() {
        pF r9 = this.f3512.m12545();
        if (r9.isAgeProtected() || !this.f3512.m12559()) {
            C1305Ag.m3609(m14534(), r9.isAgeProtected(), new PlayVerifierVault(PlayVerifierVault.RequestedBy.PLAYER.m2951(), r9.getPlayableId(), r9.isPreviewProtected(), r9.isPinProtected(), this.f3512.m12546(), this.f3512.m12556() == IPlayer.PlaybackType.StreamingPlayback, this.f3512.m12563(), this.f3512.m12555()));
            return;
        }
        C1283.m16854("PlayerFragment", String.format("nf_pin PlayerActivity pinVerification skipped - ageProtected: %b, pinVerified:%b, pinProtected:%b", Boolean.valueOf(r9.isAgeProtected()), Boolean.valueOf(this.f3512.m12559()), Boolean.valueOf(r9.isPinProtected())));
        m2506();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋ */
    public void mo2244(boolean z, PlayVerifierVault playVerifierVault) {
        C1283.m16854("nf_pin", String.format("%s onPlayVerification vault: %s", PlayerFragment.class.getSimpleName(), playVerifierVault));
        if (this.f3512 == null) {
            C1276.m16820().mo5725("playback called on null playback item");
            mo2248();
        } else if (!z || !PlayVerifierVault.RequestedBy.PLAYER.m2951().equals(playVerifierVault.m2945())) {
            C1283.m16854("PlayerFragment", "Age/Pin verification failed cannot proceed - close playback");
            mo2248();
        } else {
            this.f3512.m12549(true);
            m2506();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2396(pT pTVar, IPlayer.PlaybackType playbackType, oX oXVar, int i) {
        if (m14535()) {
            this.f3512 = new C2279wu(pTVar.getPlayable(), pTVar.getType(), oXVar, i);
            m2395(pTVar);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f3512.m12557(arguments.getBoolean("advisory_disabled", false));
                this.f3512.m12561(arguments.getBoolean("SeamlessMode", false));
                this.f3512.m12549(arguments.getBoolean("is_pin_verified", false));
                if (!arguments.getBoolean("extra_skip_preplay", false)) {
                    this.f3530.m12374(this.f3512);
                }
            }
            this.f3546 = C1841h.m6800(pTVar);
            if (playbackType == IPlayer.PlaybackType.OfflinePlayback) {
                C2052pa r5 = vO.m12023(m14536(), m2423(), pTVar.getPlayable().getPlayableId());
                pF playable = pTVar.getPlayable();
                if (!(r5 == null || playable == null)) {
                    this.f3512.m12551(C1352By.m4135(r5.mBookmarkInSecond, playable.getEndtime(), playable.getRuntime()));
                }
            } else if (this.f3530.m12372()) {
                this.f3530.m12377(pTVar);
                return;
            }
            if (this.f3528 != null) {
                this.f3528.m12281(pTVar);
            }
            if (!this.f3513) {
                mo2478(pTVar);
                return;
            }
            if (this.f3534 != null) {
                this.f3534.mo12472(pTVar, playbackType);
            }
            m2515();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2395(pT pTVar) {
        if (f3488 == null) {
            f3488 = new wD(getActivity().getApplicationContext());
        }
        f3488.m12275(pTVar, m14536().m9838(), m14536().m9839());
        this.f3542.mo7797(f3488);
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public void mo2262(pT pTVar, Status status, IPlayer.PlaybackType playbackType) {
        if (m14535()) {
            this.f3512 = this.f3530.m12376();
            if (status.mo301() || pTVar == null || this.f3512 == null) {
                C1283.m16850("PlayerFragment", "unable to fetch preplay experience details. going with main playback");
                this.f3512 = this.f3530.m12373();
            }
            if (!this.f3513) {
                mo2478(pTVar);
                return;
            }
            if (this.f3534 != null) {
                this.f3534.mo12472(pTVar, playbackType);
            }
            m2515();
        }
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        if (this.f3512 != null) {
            return this.f3512.m12563();
        }
        oX oXVar = (oX) getArguments().getParcelable(NetflixActivity.EXTRA_PLAY_CONTEXT);
        return oXVar == null ? new oB("PlayerFragment") : oXVar;
    }

    /* renamed from: ᐝʻ  reason: contains not printable characters */
    private PlayLocationType m2446() {
        return mo1635().mo9590();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋˊ */
    public AbstractC1978mi mo2245() {
        return this.f3523;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private DialogC1104.Cif m2392(WatchState watchState) {
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
            return C0505.m14491(getActivity(), this.f3494, new C1278(string, string2, getString(R.string.label_ok), this.f3505));
        }
        return null;
    }

    /* renamed from: ͺˎ  reason: contains not printable characters */
    public void m2502() {
        if (this.f3532 != null) {
            this.f3532.m12286();
            this.f3532.m12291(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2496(boolean z, long j) {
        if (this.f3538 != null && !this.f3538.isEmpty()) {
            Iterator<AbstractC2271wm> it = this.f3538.iterator();
            while (it.hasNext()) {
                AbstractC2271wm next = it.next();
                if (next != null) {
                    next.m12434(z, j);
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2495(boolean z) {
        if (this.f3523 != null) {
            this.f3523.mo9033(z);
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˏॱ */
    public boolean mo2255() {
        return this.f3512 != null && this.f3512.m12556() == IPlayer.PlaybackType.OfflinePlayback;
    }

    /* renamed from: ᐝʽ  reason: contains not printable characters */
    private void m2448() {
        pF r5;
        pV r6;
        if (mo2255() && (r5 = this.f3512.m12545()) != null && (r6 = vO.m12017(m14536(), this.f3512.m12545().getPlayableId())) != null) {
            C1365Ck.m4462(r6.mo6913(), r6.mo6915(), r5.getRuntime(), r5.getLogicalStart(), r5.getEndtime());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2476(IClientLogging.CompletionReason completionReason) {
        if (mo2255()) {
            C1365Ck.m4459(null, completionReason, null);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m2422(String str, oX oXVar) {
        if (this.f3512 != null) {
            C1283.m16854("PlayerFragment", "playableId: " + this.f3512.m12545().getPlayableId() + " => " + str);
        }
        C2059ph r3 = m14536();
        if (r3 == null) {
            return false;
        }
        pV r4 = vO.m12017(r3, str);
        if (!r3.m9774(r4) || r4.mo6881() != DownloadState.Complete) {
            return false;
        }
        m2417();
        m2504();
        startActivity(ActivityC2280wv.m12564(m14534().getApplicationContext(), str, VideoType.EPISODE, oXVar));
        return true;
    }

    @Deprecated
    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m2404(long j) {
        if (j <= 0 || this.f3512 == null || this.f3512.m12554()) {
            return false;
        }
        return (ConnectivityUtils.m2954(getActivity()) || mo2255()) && 60000 + j >= this.f3512.m12560();
    }

    /* renamed from: ॱﾟ  reason: contains not printable characters */
    private boolean m2443() {
        return AD.m3283(getActivity()) && (!m2451() || m2450());
    }

    /* renamed from: ᵎ  reason: contains not printable characters */
    private boolean m2451() {
        PlayerManifestData r1 = m2452();
        if (r1 == null) {
            return false;
        }
        Point point = r1.getPlaybackDisplaySpec().croppedAspectRatioDimension;
        return (point.x == 0 || point.y == 0) ? false : true;
    }

    /* renamed from: ᐨॱ  reason: contains not printable characters */
    private boolean m2450() {
        Point point = m2452().getPlaybackDisplaySpec().aspectRatioDimension;
        Point point2 = m2452().getPlaybackDisplaySpec().croppedAspectRatioDimension;
        return point.x == point2.x && point.y == point2.y && Math.abs((point.x * 9) - (point.y * 16)) < 10;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ʼॱ */
    public void mo2228() {
        if (mo2461() && m2452() != null) {
            if (this.f3526 != null) {
                this.f3526.dismiss();
            }
            if (this.f3534 != null) {
                this.f3534.m12494();
            }
            Point point = m2452().getPlaybackDisplaySpec().aspectRatioDimension;
            this.f3518.m2369(new Rational(point.x, point.y));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPictureInPictureModeChanged(boolean z) {
        if (C1317As.m3742(NetflixApplication.getInstance())) {
            super.onPictureInPictureModeChanged(z);
            if (mo2500() != null) {
                C1283.m16854("PlayerFragment", "onPipModeChanged, is PIP?  " + z);
                if (z) {
                    mo2500().K_();
                    mo2500().mo7758(true);
                } else {
                    mo2500().mo907(ExitPipAction.CONTINUEPLAY);
                    mo2500().mo7758(false);
                }
                this.f3518.m2367(z);
            }
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱ */
    public void mo2259(String str, VideoType videoType, oX oXVar) {
        C1283.m16854("PlayerFragment", "restarting activity from pip. ");
        m2417();
        m2504();
        startActivity(ActivityC2280wv.m12564(m14534().getApplicationContext(), str, videoType, oXVar));
    }

    /* renamed from: ᵢ  reason: contains not printable characters */
    private PlayerManifestData m2452() {
        PlayerManifestData r1 = mo2500() != null ? mo2500().mo904() : null;
        if (r1 != null) {
            this.f3540 = r1;
        }
        return this.f3540;
    }

    /* renamed from: ˎͺ  reason: contains not printable characters */
    public int m2491() {
        return this.f3516;
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˏ */
    public void mo2253(pF pFVar, VideoType videoType, oX oXVar, int i) {
        if (!m2422(pFVar.getPlayableId(), oXVar)) {
            mo2243(new C2279wu(pFVar, videoType, oXVar, i));
        }
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋ */
    public void mo2243(C2279wu wuVar) {
        if (m14535()) {
            long r2 = mo2500() != null ? mo2500().mo928() : 0;
            m2481();
            mo2247();
            mo2266();
            this.f3512 = wuVar;
            if (this.f3530.m12375()) {
                this.f3530.m12370();
            } else {
                this.f3530.m12374(this.f3512);
            }
            m2530();
            m2496(true, r2);
            if (this.f3534 != null) {
                this.f3534.m12514(false);
                this.f3534.m12495(false);
            }
            if (this.f3534 != null) {
                PostPlay r4 = this.f3534.m12506();
                if (r4.m2590()) {
                    r4.mo2589();
                }
                r4.m2571();
                r4.m2553();
                this.f3534.mo12453(PlayerUiState.PlayingWithTrickPlayOverlay);
            }
            this.f3532.f11448 = PlayerFragmentState.ACTIVITY_PLAYER_LOADING_NEXT;
            m2506();
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
        return m2460();
    }

    /* renamed from: ـॱ  reason: contains not printable characters */
    public pF m2507() {
        if (this.f3512 == null) {
            return null;
        }
        return this.f3512.m12545();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ߴ  reason: contains not printable characters */
    public int m2508() {
        if (this.f3512 == null) {
            return 0;
        }
        int r3 = this.f3512.m12555();
        if (r3 == -1) {
            r3 = this.f3512.m12545().getPlayableBookmarkPosition();
        }
        if (r3 >= 0) {
            return r3;
        }
        C1283.m16854("PlayerFragment", hashCode() + " Invalid bookmark, reset to 0");
        return 0;
    }

    /* renamed from: י  reason: contains not printable characters */
    public C0942 m2505() {
        if (this.f3534 == null || this.f3534.m12489() == null) {
            return null;
        }
        return this.f3534.m12489();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˋˋ */
    public View mo2246() {
        return getView();
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    @Deprecated
    /* renamed from: ˌ */
    public void mo2249() {
    }

    @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
    @Deprecated
    /* renamed from: ˎˎ */
    public PublishSubject<xJ> mo2251() {
        return null;
    }
}

package com.netflix.mediaclient.ui.player;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.PlayerManifestData;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.Watermark;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AbstractC1978mi;
import o.AbstractC2055pd;
import o.AbstractC2308xd;
import o.AbstractC2309xe;
import o.C1276;
import o.C1283;
import o.C1344Bq;
import o.C1348Bu;
import o.C1349Bv;
import o.C1987mr;
import o.C2058pg;
import o.C2059ph;
import o.C2267wi;
import o.C2269wk;
import o.C2313xi;
import o.SurfaceHolder$CallbackC2307xc;
import o.TextureView$SurfaceTextureListenerC2310xf;
import o.oM;
import o.oX;
import o.oY;
import o.xD;
public class NetflixVideoView extends FrameLayout implements AudioManager.OnAudioFocusChangeListener, Handler.Callback {

    /* renamed from: ʼ  reason: contains not printable characters */
    private static boolean f3401 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f3402 = NetflixVideoView.class.getName();

    /* renamed from: ʻ  reason: contains not printable characters */
    protected oM f3403;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private int f3404;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private IPlayer.PlayerState f3405;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected ScaleType f3406;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f3407;

    /* renamed from: ʾ  reason: contains not printable characters */
    private float f3408;

    /* renamed from: ʿ  reason: contains not printable characters */
    private Rect f3409;

    /* renamed from: ˈ  reason: contains not printable characters */
    private long f3410;

    /* renamed from: ˉ  reason: contains not printable characters */
    private oX f3411;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected AbstractC2308xd f3412;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private boolean f3413;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private AudioSource f3414;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f3415;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private Subtitle f3416;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private oY f3417;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private IPlayer.AbstractC1291iF f3418;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f3419;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private IPlayer.AbstractC0024 f3420;

    /* renamed from: ˌ  reason: contains not printable characters */
    private IPlayer.Cif f3421;

    /* renamed from: ˍ  reason: contains not printable characters */
    private IPlayer.IF f3422;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected final C2313xi f3423;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private IPlayer.AbstractC0026 f3424;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private IPlayer.AbstractC0027 f3425;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected ViewGroup f3426;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private IPlayer.AbstractC0025 f3427;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private IPlayer.AbstractC1290If f3428;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f3429;

    /* renamed from: ˑ  reason: contains not printable characters */
    private boolean f3430;

    /* renamed from: ͺ  reason: contains not printable characters */
    private long f3431;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private AtomicBoolean f3432;

    /* renamed from: ـ  reason: contains not printable characters */
    private Subtitle f3433;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected C2267wi f3434;

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private AbstractC1978mi f3435;

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private PlaybackSessionState f3436;

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private boolean f3437;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private VideoType f3438;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private int f3439;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private int f3440;

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private int f3441;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected AbstractC2055pd f3442;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private int f3443;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected Handler f3444;

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    private AbstractC2309xe f3445;

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    private final oM.AbstractC0160 f3446;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private float f3447;

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    private boolean f3448;

    /* renamed from: ᐨ  reason: contains not printable characters */
    private boolean f3449;

    /* access modifiers changed from: package-private */
    public enum PlaybackSessionState {
        NOTREADY(0, "NOTREADY"),
        VIDEO_LOADED(1, "VIDEO_LOADED"),
        READY(2, "PLAYER_READY");
        

        /* renamed from: ˋ  reason: contains not printable characters */
        String f3455;

        /* renamed from: ˏ  reason: contains not printable characters */
        int f3456;

        private PlaybackSessionState(int i, String str) {
            this.f3456 = i;
            this.f3455 = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˋ  reason: contains not printable characters */
        public String m2357() {
            return this.f3455;
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m2358() {
            return this.f3456 == 1 || this.f3456 == 2;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC1978mi m2343() {
        return this.f3435;
    }

    /* renamed from: com.netflix.mediaclient.ui.player.NetflixVideoView$ˊ  reason: contains not printable characters */
    class C0039 implements AbstractC2309xe {
        C0039() {
        }

        @Override // o.AbstractC2309xe
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo2359(AbstractC2308xd xdVar) {
            C1283.m16854(NetflixVideoView.f3402, "surfaceCreated " + System.identityHashCode(this) + " with playable id " + NetflixVideoView.this.f3410 + ", current view is visible? " + NetflixVideoView.this.getVisibility());
            if (!NetflixVideoView.this.mo2339()) {
                C1283.m16865(NetflixVideoView.f3402, "Ignoring playback request as view does not have focus.");
                return;
            }
            C1283.m16854(NetflixVideoView.f3402, "has focus, load video");
            if (xdVar == null || xdVar.mo12914() == null) {
                C1283.m16854(NetflixVideoView.f3402, "SurfaceCreated again, no playback");
                return;
            }
            NetflixVideoView.this.f3412 = xdVar;
            xdVar.mo12916().setVisibility(0);
            xdVar.mo12915(true);
            C1283.m16854(NetflixVideoView.f3402, "loadVideo and start play");
            if (!NetflixVideoView.this.f3436.m2358() && NetflixVideoView.this.m2309()) {
                NetflixVideoView.this.f3436 = PlaybackSessionState.READY;
            }
            if (NetflixVideoView.this.f3428 != null) {
                NetflixVideoView.this.f3428.mo1524();
            }
        }

        @Override // o.AbstractC2309xe
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo2361(AbstractC2308xd xdVar, int i, int i2) {
            NetflixVideoView.this.f3444.sendEmptyMessage(1);
            if (NetflixVideoView.this.m2347()) {
                NetflixVideoView.this.m2349();
            }
        }

        @Override // o.AbstractC2309xe
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo2360(AbstractC2308xd xdVar) {
            C1283.m16854(NetflixVideoView.f3402, "surfaceDestroyed " + System.identityHashCode(this) + " with playable id " + NetflixVideoView.this.f3410);
            NetflixVideoView.this.f3412 = null;
            if (NetflixVideoView.this.f3425 != null) {
                NetflixVideoView.this.f3425.mo1533();
            } else {
                NetflixVideoView.this.m2327();
            }
        }

        @Override // o.AbstractC2309xe
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo2362(AbstractC2308xd xdVar) {
        }
    }

    public void setSurface() {
        if (this.f3403 != null && this.f3412 != null) {
            this.f3403.mo906(this.f3412.mo12914());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m2349() {
        this.f3444.removeMessages(2);
        if (this.f3435 != null) {
            this.f3435.mo9027();
            this.f3435.mo9032((oM) null);
            this.f3435.mo9033(false);
            this.f3435 = null;
            this.f3448 = false;
        }
        this.f3435 = new xD(this);
        if (this.f3403 != null) {
            this.f3435.mo9032(this.f3403);
        }
        this.f3435.mo9033(this.f3413);
        this.f3444.sendEmptyMessage(2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private synchronized void m2317(long j) {
        if (this.f3403 == null) {
            C1283.m16850(f3402, "no current playback session");
        } else if (this.f3403.mo891() == null) {
            C1283.m16854(f3402, "Subtitles are not visible, do not send any update");
        } else if (!m2347()) {
            C1283.m16854(f3402, "Not playing, do NOT send subtitle screen update");
        } else {
            C1987mr r2 = this.f3403.mo924(j);
            if (r2 == null) {
                C1283.m16854(f3402, "No subtitle data, do NOT send subtitle screen update");
            } else if (this.f3435 == null) {
                C1276.m16820().mo5725("Subtitle updated but subtitleManager is null");
            } else {
                this.f3435.mo9035(r2, m2292());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private Point m2292() {
        PlayerManifestData r2;
        if (this.f3403 == null || (r2 = this.f3403.mo904()) == null || r2.getPlaybackDisplaySpec() == null) {
            return null;
        }
        return r2.getPlaybackDisplaySpec().aspectRatioDimension;
    }

    public NetflixVideoView(Context context) {
        this(context, null);
    }

    public NetflixVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetflixVideoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public NetflixVideoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3406 = ScaleType.CROP;
        this.f3447 = 1.0f;
        this.f3407 = true;
        this.f3408 = 1.0f;
        this.f3442 = AbstractC2055pd.f9383;
        this.f3413 = true;
        this.f3432 = new AtomicBoolean(false);
        this.f3441 = 2000;
        this.f3449 = true;
        this.f3445 = new C0039();
        this.f3446 = new oM.AbstractC0160() { // from class: com.netflix.mediaclient.ui.player.NetflixVideoView.1
            @Override // o.oM.AbstractC0160
            public boolean ae_() {
                return NetflixVideoView.this.f3430;
            }

            @Override // o.oM.AbstractC0160
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo2353(Watermark watermark) {
                C1348Bu.m4093();
                if (NetflixVideoView.this.f3436 == PlaybackSessionState.READY) {
                    try {
                        if (NetflixVideoView.this.m2298() == null) {
                            C1283.m16854(NetflixVideoView.f3402, "onPrepared called when manifest data is empty.");
                            NetflixVideoView.this.m2286();
                            return;
                        }
                        Point point = NetflixVideoView.this.m2298().getPlaybackDisplaySpec().aspectRatioDimension;
                        if (!(point == null || point.x == 0 || point.y == 0)) {
                            C1283.m16854(NetflixVideoView.f3402, "====> aspect ratio is = " + point);
                            NetflixVideoView.this.setVideoWidth(point.x);
                            NetflixVideoView.this.setVideoHeight(point.y);
                        }
                        Point point2 = NetflixVideoView.this.m2298().getPlaybackDisplaySpec().croppedAspectRatioDimension;
                        if (!(point2 == null || point2.x == 0 || point2.y == 0)) {
                            C1283.m16854(NetflixVideoView.f3402, "====> cropped aspect ratio is = " + point2);
                            NetflixVideoView.this.m2316(point2.x);
                            NetflixVideoView.this.m2302(point2.y);
                        }
                        if (NetflixVideoView.this.f3412 != null) {
                            NetflixVideoView.this.f3412.mo12913(point, point2);
                        }
                        if (NetflixVideoView.this.f3414 == null) {
                            NetflixVideoView.this.f3414 = C1344Bq.m4072(NetflixVideoView.this.getContext(), NetflixVideoView.this.f3403);
                            if (NetflixVideoView.this.f3414 == null) {
                                NetflixVideoView.this.f3414 = NetflixVideoView.this.f3403.mo893();
                            }
                        }
                        if (NetflixVideoView.this.f3416 == null) {
                            NetflixVideoView.this.f3416 = C1344Bq.m4073(NetflixVideoView.this.getContext(), NetflixVideoView.this.f3403);
                        }
                        NetflixVideoView.this.f3433 = NetflixVideoView.this.f3416;
                        if (!NetflixVideoView.this.m2304() || (NetflixVideoView.this.f3416 != null && !NetflixVideoView.this.f3416.isForcedNarrativeOrNone())) {
                            NetflixVideoView.this.f3449 = true;
                        } else {
                            NetflixVideoView.this.f3416 = C1344Bq.m4071(NetflixVideoView.this.getContext(), NetflixVideoView.this.f3403);
                            if (NetflixVideoView.this.f3433 != NetflixVideoView.this.f3416) {
                                NetflixVideoView.this.f3449 = false;
                            }
                        }
                        if (NetflixVideoView.this.mo2339()) {
                            if (NetflixVideoView.this.f3414 != null) {
                                NetflixVideoView.this.f3403.mo901(NetflixVideoView.this.f3414);
                            }
                            NetflixVideoView.this.f3403.mo918(NetflixVideoView.this.f3416, NetflixVideoView.this.f3449);
                            NetflixVideoView.this.f3448 = true;
                        }
                        NetflixVideoView.this.setSubtitleVisiblity(NetflixVideoView.this.f3413);
                        NetflixVideoView.this.m2318(IPlayer.PlayerState.Prepared);
                        NetflixVideoView.this.f3444.sendEmptyMessage(1);
                        NetflixVideoView.this.f3441 = NetflixVideoView.this.m2298().getGopMaxSizeInMs();
                    } catch (Exception e) {
                        C1276.m16820().mo5729("Failed to start player", e);
                        NetflixVideoView.this.m2286();
                    }
                } else {
                    C1283.m16850(NetflixVideoView.f3402, "onPrepared not in correct state, View state: " + NetflixVideoView.this.f3436.m2357());
                    NetflixVideoView.this.m2286();
                }
            }

            @Override // o.oM.AbstractC0160
            public void ad_() {
                NetflixVideoView.this.m2318(IPlayer.PlayerState.Completed);
                C1283.m16854(NetflixVideoView.f3402, "onCompletion");
                if (NetflixVideoView.this.f3418 != null) {
                    NetflixVideoView.this.f3418.mo1528();
                }
                NetflixVideoView.this.f3437 = true;
                NetflixVideoView.this.f3435 = null;
            }

            @Override // o.oM.AbstractC0160
            public void ac_() {
                C1283.m16854(NetflixVideoView.f3402, "onStarted");
                C1348Bu.m4093();
                if (NetflixVideoView.this.f3403 == null || NetflixVideoView.this.f3436 != PlaybackSessionState.READY) {
                    NetflixVideoView.this.m2318(IPlayer.PlayerState.Error);
                    NetflixVideoView.this.m2286();
                } else if (!NetflixVideoView.this.mo2339()) {
                    NetflixVideoView.this.m2350();
                } else {
                    NetflixVideoView.this.m2319(true);
                    if (!(NetflixVideoView.this.f3414 == null || NetflixVideoView.this.f3414 == NetflixVideoView.this.f3403.mo893())) {
                        NetflixVideoView.this.f3403.mo901(NetflixVideoView.this.f3414);
                    }
                    if (!NetflixVideoView.this.f3448 || NetflixVideoView.this.f3416 != NetflixVideoView.this.f3403.mo891()) {
                        NetflixVideoView.this.f3403.mo918(NetflixVideoView.this.f3416, NetflixVideoView.this.f3449);
                    }
                    NetflixVideoView.this.setSubtitleVisiblity(NetflixVideoView.this.f3413);
                    NetflixVideoView.this.f3403.mo915(NetflixVideoView.this.f3447);
                    NetflixVideoView.this.m2318(IPlayer.PlayerState.Started);
                    if (NetflixVideoView.this.f3412 != null) {
                        NetflixVideoView.this.f3412.mo12913(new Point(NetflixVideoView.this.f3404, NetflixVideoView.this.f3439), new Point(NetflixVideoView.this.f3440, NetflixVideoView.this.f3443));
                    }
                    if (!NetflixVideoView.this.f3407) {
                        NetflixVideoView.this.m2350();
                    } else {
                        C1283.m16861((NetflixVideoView.this.m2280() ? "Offline" : "Streaming") + " playback started");
                        NetflixVideoView.this.f3444.sendEmptyMessage(2);
                    }
                    if (NetflixVideoView.this.f3422 != null) {
                        NetflixVideoView.this.f3422.mo1523();
                    }
                }
            }

            @Override // o.oM.AbstractC0160
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo2351(IPlayer.PlayerStallReason playerStallReason) {
                if (NetflixVideoView.this.f3424 != null) {
                    NetflixVideoView.this.f3424.mo1532(playerStallReason);
                }
            }

            @Override // o.oM.AbstractC0160
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo2354(C1987mr mrVar) {
                if (NetflixVideoView.this.f3435 != null) {
                    NetflixVideoView.this.f3435.mo9035(mrVar, NetflixVideoView.this.m2292());
                } else {
                    C1276.m16820().mo5725("Subtitle updated but subtitleManager is null");
                }
            }

            @Override // o.oM.AbstractC0160
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo2355(long j) {
                if (NetflixVideoView.this.f3421 != null) {
                    NetflixVideoView.this.f3421.mo1529(j);
                }
            }

            @Override // o.oM.AbstractC0160
            /* renamed from: ˋ  reason: contains not printable characters */
            public void mo2352(IPlayer.aux aux) {
                NetflixVideoView.this.m2318(IPlayer.PlayerState.Error);
                if (NetflixVideoView.this.f3420 != null) {
                    NetflixVideoView.this.f3420.mo1530(aux);
                }
            }

            @Override // o.oM.AbstractC0160
            /* renamed from: ᐝ  reason: contains not printable characters */
            public void mo2356() {
                NetflixVideoView.this.f3436 = PlaybackSessionState.NOTREADY;
                NetflixVideoView.this.f3405 = IPlayer.PlayerState.Idle;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.C0006.NetflixVideoView, i, 0);
        this.f3415 = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        this.f3444 = new Handler(this);
        this.f3423 = new C2313xi();
        setKeepScreenOn(true);
        this.f3405 = IPlayer.PlayerState.Idle;
        this.f3436 = PlaybackSessionState.NOTREADY;
        this.f3435 = new xD(this);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo2340(oY oYVar, long j, VideoType videoType, AbstractC2055pd pdVar, oX oXVar, long j2, boolean z) {
        if (this.f3435 == null) {
            this.f3435 = new xD(this);
        }
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(this, 3, 1);
        } else {
            C1283.m16850(f3402, "Audio manager not found. Unable to ask for audio focus!");
        }
        if (videoType == null || oXVar == null || oYVar == null) {
            C1276.m16820().mo5725("attachPlaybackSession videoType=" + videoType + " playContext=" + oXVar + " group=" + oYVar);
            return false;
        }
        this.f3417 = oYVar;
        this.f3442 = pdVar;
        this.f3410 = j;
        this.f3411 = oXVar;
        this.f3431 = j2;
        this.f3407 = z;
        this.f3436 = PlaybackSessionState.NOTREADY;
        this.f3438 = videoType;
        if (!this.f3437 || this.f3403 == null || this.f3412 == null) {
            this.f3437 = false;
            return m2330();
        }
        this.f3436 = PlaybackSessionState.READY;
        this.f3403.mo897(0, true);
        this.f3403.mo906(this.f3412.mo12914());
        return true;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m2327() {
        C1283.m16851(f3402, "detachPlaybackSession, resetting surface and session %d", Long.valueOf(this.f3410));
        if (this.f3403 != null) {
            this.f3444.removeMessages(2);
            this.f3403.mo931();
            this.f3403.mo921(this.f3446);
            this.f3403.mo906((Surface) null);
            if (this.f3435 != null) {
                this.f3435.mo9032((oM) null);
            }
            if (this.f3429) {
                this.f3429 = false;
                NetflixApplication.getInstance().sendBroadcast(C2058pg.m9730("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP", this.f3410 + "", this.f3403.mo914(), this.f3438, (int) this.f3431, this.f3442.mo9715()));
            }
        }
        m2319(false);
        this.f3436 = PlaybackSessionState.NOTREADY;
        m2318(IPlayer.PlayerState.Idle);
        this.f3412 = null;
        this.f3430 = false;
        this.f3403 = null;
        if (this.f3435 != null) {
            this.f3435.mo9027();
            this.f3435 = null;
        }
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this);
        } else {
            C1283.m16850(f3402, "Audio manager not found. Unable to abandon audio focus!");
        }
        this.f3448 = false;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m2347() {
        return this.f3403 != null && m2344() == IPlayer.PlayerState.Started;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m2331() {
        return this.f3403 != null && m2344() == IPlayer.PlayerState.Paused;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m2329() {
        return this.f3403 != null && m2344() == IPlayer.PlayerState.Stalled;
    }

    public void setExperience(AbstractC2055pd pdVar) {
        this.f3442 = pdVar;
    }

    public void setVideoWidth(int i) {
        this.f3404 = i;
    }

    public void setVideoHeight(int i) {
        this.f3439 = i;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public int m2338() {
        return this.f3404;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public int m2336() {
        return this.f3439;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public int m2341() {
        return this.f3440;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2316(int i) {
        this.f3440 = i;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public int m2342() {
        return this.f3443;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m2302(int i) {
        this.f3443 = i;
    }

    @Override // o.AbstractC0931
    public void setScale(float f) {
        this.f3408 = f;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public IPlayer.PlayerState m2344() {
        return this.f3405;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public long m2346() {
        return this.f3410;
    }

    public void setSubtitleAreaPadding(int i, int i2, int i3, int i4) {
        this.f3409 = new Rect(i, i2, i3, i4);
        if (this.f3426 != null) {
            ((ViewGroup.MarginLayoutParams) this.f3426.getLayoutParams()).setMargins(i, i2, i3, i4);
            this.f3426.requestLayout();
        }
    }

    public void setSubtitleDisplayArea(ViewGroup viewGroup) {
        if (this.f3415) {
            C1283.m16854(f3402, "Setting subtitle display area while using default display area. Ignored.");
            return;
        }
        if (this.f3426 != null && m2347()) {
            m2349();
        }
        this.f3426 = viewGroup;
        this.f3426.requestLayout();
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public ViewGroup m2348() {
        return this.f3426;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void m2350() {
        if (this.f3403 != null) {
            C1283.m16854(f3402, "Pause for playable id: " + this.f3403.mo7754());
            this.f3403.mo931();
            this.f3444.removeMessages(2);
        }
        m2318(IPlayer.PlayerState.Paused);
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public void m2345() {
        if (this.f3403 == null || !mo2339()) {
            C1276.m16820().mo5725("unpause on NetflixVidewView called when session is no longer active");
        } else if (this.f3412 != null) {
            C1283.m16854(f3402, "Unpause for playable id: " + this.f3403.mo7754());
            this.f3403.mo927();
            this.f3444.sendEmptyMessage(2);
            m2318(IPlayer.PlayerState.Started);
        } else {
            C1283.m16854(f3402, "Surface is not created while unpause is called. ");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2337(long j) {
        if (j < 0) {
            j = 0;
        }
        if (m2333() == null) {
            return;
        }
        if (m2310(j)) {
            m2333().mo919((int) (j - m2333().mo928()), 5000);
            return;
        }
        m2333().mo897(j, true);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m2310(long j) {
        if (Math.abs(j - this.f3403.mo928()) <= ((long) (this.f3441 + 100))) {
            return true;
        }
        return false;
    }

    public void b_() {
        C1283.m16854(f3402, "reset current view");
        if (this.f3403 != null) {
            m2327();
        }
        removeAllViewsInLayout();
        m2318(IPlayer.PlayerState.Idle);
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public void m2328() {
        C1283.m16854(f3402, "reset current playback without destroying the view");
        if (this.f3403 != null) {
            m2327();
        }
        m2318(IPlayer.PlayerState.Idle);
    }

    public void setVolume(float f) {
        Subtitle r2;
        this.f3447 = f;
        if (this.f3403 != null) {
            this.f3403.mo915(f);
            if (!m2304()) {
                return;
            }
            if ((this.f3416 != null && !this.f3416.isForcedNarrativeOrNone()) || (r2 = C1344Bq.m4071(getContext(), this.f3403)) == null) {
                return;
            }
            if (this.f3416 == null || !C1349Bv.m4126(r2.getId(), this.f3416.getId())) {
                this.f3416 = C1344Bq.m4071(getContext(), this.f3403);
                this.f3449 = false;
                setSubtitleTrack(this.f3416);
            }
        }
    }

    public void setAudioTrack(AudioSource audioSource) {
        this.f3414 = audioSource;
        if (this.f3403 != null && mo2339() && this.f3414 != null) {
            this.f3403.mo901(this.f3414);
        }
    }

    public void setAudioDuck(boolean z) {
        if (this.f3403 != null) {
            this.f3403.mo926(z);
        }
    }

    public void setSubtitleTrack(Subtitle subtitle) {
        this.f3416 = subtitle;
        if (this.f3403 != null && mo2339() && this.f3414 != null) {
            setSubtitleVisiblity(false);
            this.f3403.mo918(this.f3416, this.f3449);
            setSubtitleVisiblity(this.f3413);
        }
    }

    public void setScaleType(ScaleType scaleType) {
        this.f3406 = scaleType;
        if (this.f3412 != null) {
            this.f3412.mo12912(scaleType);
            this.f3444.sendEmptyMessage(1);
        }
    }

    public void setOnStartedListener(IPlayer.IF r1) {
        this.f3422 = r1;
    }

    public void setOnCompletionListener(IPlayer.AbstractC1291iF iFVar) {
        this.f3418 = iFVar;
    }

    public void setOnErrorListener(IPlayer.AbstractC0024 r1) {
        this.f3420 = r1;
    }

    public void setOnStalledListener(IPlayer.AbstractC0026 r1) {
        this.f3424 = r1;
    }

    public void setOnPlayProgressListener(IPlayer.Cif ifVar) {
        this.f3421 = ifVar;
    }

    public void setPlayerStatusChangeListener(IPlayer.AbstractC0025 r1) {
        this.f3427 = r1;
    }

    public void setPlayerSurfaceAvailableListener(IPlayer.AbstractC1290If r1) {
        this.f3428 = r1;
    }

    public void setPlayerSurfaceDestroyedListener(IPlayer.AbstractC0027 r1) {
        this.f3425 = r1;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public oM m2333() {
        return this.f3403;
    }

    public void setSubtitleVisiblity(boolean z) {
        if (this.f3435 != null && mo2339()) {
            this.f3413 = z;
            this.f3435.mo9033(z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˈ  reason: contains not printable characters */
    public AbstractC2308xd m2335() {
        if (!this.f3442.mo9717() || !this.f3442.mo9713() || this.f3423.m12937()) {
            return new SurfaceHolder$CallbackC2307xc(getContext(), this.f3445);
        }
        return new TextureView$SurfaceTextureListenerC2310xf(getContext(), this.f3445);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼॱ  reason: contains not printable characters */
    public boolean m2330() {
        removeAllViewsInLayout();
        this.f3412 = m2335();
        if (this.f3412 == null || this.f3412.mo12916() == null) {
            C1283.m16850(f3402, "Unable to create rendering surface");
            return false;
        }
        this.f3412.mo12912(this.f3406);
        addView(this.f3412.mo12916(), new FrameLayout.LayoutParams(-1, -1, 17));
        if (this.f3415) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.f3426 = new RelativeLayout(getContext());
            if (this.f3409 != null) {
                layoutParams.setMargins(this.f3409.left, this.f3409.top, this.f3409.right, this.f3409.bottom);
            }
            addView(this.f3426, layoutParams);
        }
        if (!f3401) {
            return true;
        }
        this.f3434 = new C2267wi(getContext());
        addView(this.f3434);
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m2309() {
        C1283.m16854(f3402, "Do load Video");
        this.f3436 = PlaybackSessionState.VIDEO_LOADED;
        int r9 = m2287();
        C1283.m16854(f3402, "Playable id " + this.f3410 + " play from position " + r9);
        if (r9 < 0) {
            C1283.m16854(f3402, " Invalid bookmark, reset to 0");
            r9 = 0;
        }
        C2059ph r10 = C2059ph.m9741((NetflixActivity) getContext());
        if (r10 == null) {
            return false;
        }
        if (mo2339()) {
            C2269wk.m12432(this.f3411);
            if (r10.m9759() == null) {
                C1276.m16820().mo5725("VideoView - svcManager.getPlaybackSessionManager is null");
                return false;
            }
            this.f3403 = r10.m9759().mo7792(this.f3446, this.f3417, this.f3442, this.f3410, this.f3411, (long) (r9 * 1000));
            if (this.f3403 == null) {
                C1283.m16854(f3402, "cannot open playback session");
                return false;
            }
            if (this.f3435 == null) {
                C1283.m16854(f3402, "SubtitleManager is null while setting current session");
                this.f3435 = new xD(this);
            }
            this.f3435.mo9032(this.f3403);
            this.f3430 = true;
            if (this.f3412 != null) {
                this.f3403.mo906(this.f3412.mo12914());
            } else {
                C1283.m16850(f3402, "surface is not available when video is ready");
            }
            this.f3436 = PlaybackSessionState.READY;
            NetflixApplication.getInstance().sendBroadcast(C2058pg.m9730("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_START", this.f3410 + "", this.f3403.mo914(), this.f3438, (int) this.f3431, this.f3442.mo9715()));
            this.f3429 = true;
            return true;
        }
        C1283.m16854(f3402, "view no longer in focus, no not open session");
        m2286();
        return false;
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private int m2287() {
        return (int) this.f3431;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                requestLayout();
                return true;
            case 2:
                if (this.f3403 == null) {
                    C1283.m16854(f3402, "no current playback session. ");
                    return false;
                }
                m2317(this.f3403.mo928());
                if (f3401 && this.f3434 != null) {
                    this.f3434.m12430(this.f3403, this.f3435);
                }
                if (m2344() != IPlayer.PlayerState.Started) {
                    return true;
                }
                this.f3444.sendEmptyMessageDelayed(2, 1000);
                return true;
            default:
                return false;
        }
    }

    public void setViewInFocus(boolean z) {
        C1283.m16854(f3402, "focus = " + z);
        this.f3432.set(z);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo2339() {
        return this.f3432.get();
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public long m2334() {
        if (m2333() != null) {
            return m2333().mo928();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋˊ  reason: contains not printable characters */
    private PlayerManifestData m2298() {
        if (this.f3403 != null) {
            return this.f3403.mo904();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊˊ  reason: contains not printable characters */
    private void m2286() {
        C1283.m16854(f3402, "cleanup");
        this.f3436 = PlaybackSessionState.NOTREADY;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2318(IPlayer.PlayerState playerState) {
        if (this.f3405 != playerState) {
            this.f3405 = playerState;
            if (this.f3427 != null) {
                this.f3427.mo1531(this.f3405);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˉ  reason: contains not printable characters */
    private boolean m2280() {
        oM oMVar = this.f3403;
        return oMVar != null && oMVar.mo914() == IPlayer.PlaybackType.OfflinePlayback;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2319(boolean z) {
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        if (audioManager == null) {
            return;
        }
        if (z) {
            audioManager.requestAudioFocus(this, 3, 1);
        } else {
            audioManager.abandonAudioFocus(this);
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        String str;
        switch (i) {
            case -3:
                if (this.f3403 != null) {
                    this.f3403.mo926(true);
                }
                str = "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK";
                break;
            case PagerAdapter.POSITION_NONE /* -2 */:
                str = "AUDIOFOCUS_LOSS_TRANSIENT";
                if (this.f3403 != null && this.f3403.mo892()) {
                    this.f3419 = true;
                    m2350();
                    break;
                }
            case -1:
            case 0:
            default:
                str = "unknown audio focus: " + i;
                break;
            case 1:
                str = "AUDIOFOCUS_GAIN";
                if (this.f3403 != null) {
                    this.f3403.mo926(false);
                    if (this.f3419) {
                        m2345();
                        this.f3419 = false;
                        break;
                    }
                }
                break;
        }
        C1283.m16851(f3402, "onAudioFocusChange %s", str);
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public boolean m2332() {
        return m2344() == IPlayer.PlayerState.Started || m2344() == IPlayer.PlayerState.Paused;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎˎ  reason: contains not printable characters */
    private boolean m2304() {
        return Math.abs(this.f3447 - 0.0f) < 0.01f;
    }
}

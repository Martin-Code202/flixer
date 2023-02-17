package o;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.BillboardInteractionType;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.player.NetflixVideoView;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.originals.BigRowSummary;
import com.netflix.model.leafs.originals.BillboardAvailabilityDates;
import com.netflix.model.leafs.originals.BillboardCTA;
import com.netflix.model.leafs.originals.BillboardLogo;
import com.netflix.model.leafs.originals.BillboardPhase;
import com.netflix.model.leafs.originals.Tone;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class uF extends ConstraintLayout {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C0522 f10708;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private AbstractC2070ps f10709;

    /* renamed from: ʼ  reason: contains not printable characters */
    private C0656 f10710;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private boolean f10711 = false;

    /* renamed from: ʽ  reason: contains not printable characters */
    private ProgressBar f10712;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private HashMap<String, String> f10713 = new HashMap<>(3);

    /* renamed from: ʾ  reason: contains not printable characters */
    private boolean f10714;

    /* renamed from: ʿ  reason: contains not printable characters */
    private String f10715 = "";

    /* renamed from: ˈ  reason: contains not printable characters */
    private C2103qw f10716;

    /* renamed from: ˉ  reason: contains not printable characters */
    private boolean f10717;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1050 f10718;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private long f10719 = -1;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private boolean f10720 = false;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final Runnable f10721 = new Runnable() { // from class: o.uF.4
        @Override // java.lang.Runnable
        public void run() {
            uF.this.m11401(true);
        }
    };

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private IPlayer.PlayerState f10722;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C0754 f10723;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private boolean f10724;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private Disposable f10725;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private AddToListData.Cif f10726;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private pF f10727;

    /* renamed from: ˌ  reason: contains not printable characters */
    private AbstractC2055pd f10728 = uA.m11323("billboard-bigRow");

    /* renamed from: ˎ  reason: contains not printable characters */
    private NetflixVideoView f10729;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private VideoType f10730;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0754 f10731;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final ValueAnimator f10732 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);

    /* renamed from: ͺ  reason: contains not printable characters */
    private View f10733;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C0754 f10734;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private C0716 f10735;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final ValueAnimator f10736 = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(500L);

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final ValueAnimator f10737 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(500L);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0754 f10738;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private oX f10739 = new oB("BigRowView");

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0716 f10740;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final ValueAnimator f10741 = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(300L);

    public uF(Context context) {
        super(context);
    }

    public uF(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public uF(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f10733 = findViewById(R.id.icon_shader);
        this.f10710 = (C0656) findViewById(R.id.big_row_audio_button);
        this.f10735 = (C0716) findViewById(R.id.big_row_news_feed_hashtag);
        this.f10714 = false;
        this.f10740 = (C0716) findViewById(R.id.big_row_item_header_text);
        this.f10734 = (C0754) findViewById(R.id.big_row_play_button);
        this.f10723 = (C0754) findViewById(R.id.big_row_info_button);
        this.f10731 = (C0754) findViewById(R.id.big_row_share_button);
        this.f10729 = (NetflixVideoView) findViewById(R.id.big_row_netflix_video_view);
        this.f10718 = (C1050) findViewById(R.id.big_row_image_view);
        this.f10708 = (C0522) findViewById(R.id.big_row_logo);
        this.f10712 = (ProgressBar) findViewById(R.id.big_row_spinner);
        this.f10738 = (C0754) findViewById(R.id.big_row_my_list_button);
        this.f10718.setCutomCroppingEnabled(true);
        this.f10718.setCenterHorizontally(true);
        this.f10729.setOnErrorListener(new IPlayer.AbstractC0024() { // from class: o.uF.14
            @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0024
            /* renamed from: ˎ */
            public void mo1530(IPlayer.aux aux) {
                if (uF.this.f10720) {
                    C1004.m15961(uF.this.getContext(), aux.mo1000(), 0);
                }
            }
        });
        this.f10729.setOnStalledListener(new IPlayer.AbstractC0026() { // from class: o.uF.13
            @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0026
            /* renamed from: ˏ */
            public void mo1532(IPlayer.PlayerStallReason playerStallReason) {
                uF.this.f10712.setVisibility(0);
                uF.this.f10733.setVisibility(0);
            }
        });
        this.f10729.setOnPlayProgressListener(new IPlayer.Cif() { // from class: o.uF.18
            @Override // com.netflix.mediaclient.servicemgr.IPlayer.Cif
            /* renamed from: ॱ */
            public void mo1529(long j) {
                if (uF.this.f10712.getVisibility() == 0) {
                    uF.this.f10712.setVisibility(8);
                    uF.this.f10733.setVisibility(8);
                }
            }
        });
        this.f10729.setPlayerStatusChangeListener(new IPlayer.AbstractC0025() { // from class: o.uF.19
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0025
            /* renamed from: ˏ */
            public void mo1531(IPlayer.PlayerState playerState) {
                IPlayer.PlayerState playerState2 = uF.this.f10722;
                uF.this.f10722 = playerState;
                C1283.m16854("BigRowView", "setPlayerStatusChangeListener new status\t" + playerState.m1527() + " old status\t " + playerState2);
                switch (playerState) {
                    case Error:
                        if (uF.this.f10720) {
                            C1004.m15961(uF.this.getContext(), UmaAlert.TYPE_ERROR, 0);
                            break;
                        }
                        break;
                    case Completed:
                        break;
                    case Idle:
                        if (playerState2 == IPlayer.PlayerState.Paused || playerState2 == IPlayer.PlayerState.Started) {
                            uF.this.m11383(false);
                            return;
                        }
                        return;
                    case Paused:
                    case Prepared:
                    default:
                        return;
                    case Started:
                        uF.this.m11390(true);
                        uF.this.m11371(true);
                        uF.this.f10712.setVisibility(8);
                        NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(uF.this.getContext(), NetflixActivity.class);
                        if (!C1322Av.m3793(netflixActivity)) {
                            C2196tz.m11304(netflixActivity, uF.this.f10715, System.currentTimeMillis());
                            netflixActivity.getServiceManager().m9764().mo9487(new C0943(), new oP("BigRowView"));
                            uF.this.f10717 = true;
                            if (uF.this.f10720 && uF.this.f10719 > 0) {
                                C1004.m15961(uF.this.getContext(), "Perceived time to start " + String.valueOf(System.currentTimeMillis() - uF.this.f10719), 0);
                                uF.this.f10719 = -1;
                                return;
                            }
                            return;
                        }
                        return;
                }
                uF.this.m11383(true);
                uF.this.m11411();
            }
        });
        this.f10729.setOnClickListener(new View.OnClickListener() { // from class: o.uF.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                uF.this.m11395(true);
            }
        });
        this.f10710.setOnClickListener(new View.OnClickListener() { // from class: o.uF.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (uF.this.f10714) {
                    uF.this.f10729.setVolume(0.0f);
                    uF.this.f10729.setSubtitleVisiblity(true);
                    uF.this.f10710.setImageResource(R.drawable.ic_audio_off);
                } else {
                    uF.this.f10729.setVolume(1.0f);
                    uF.this.f10729.setSubtitleVisiblity(false);
                    uF.this.f10710.setImageResource(R.drawable.ic_audio_on);
                    AudioManager audioManager = (AudioManager) uF.this.getContext().getSystemService("audio");
                    if (audioManager != null) {
                        audioManager.setStreamVolume(3, audioManager.getStreamVolume(3), 1);
                    }
                }
                uF.this.f10714 = !uF.this.f10714;
                uF.this.m11395(true);
            }
        });
        AnonymousClass17 r2 = new ValueAnimator.AnimatorUpdateListener() { // from class: o.uF.17
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                uF.this.f10718.setAlpha(floatValue);
                if (uF.this.f10708.m14545()) {
                    uF.this.f10708.setAlpha(floatValue);
                }
                if (C1349Bv.m4112(uF.this.f10735.getText())) {
                    uF.this.f10735.setAlpha(floatValue);
                }
            }
        };
        this.f10736.addUpdateListener(r2);
        this.f10736.addListener(new AbstractC1335Bh() { // from class: o.uF.23
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                uF.this.m11390(false);
            }
        });
        this.f10737.addUpdateListener(r2);
        this.f10737.addListener(new AbstractC1335Bh() { // from class: o.uF.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                uF.this.f10729.setVisibility(8);
            }
        });
        AnonymousClass3 r3 = new ValueAnimator.AnimatorUpdateListener() { // from class: o.uF.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                uF.this.f10710.setAlpha(floatValue);
                uF.this.f10733.setAlpha(floatValue);
            }
        };
        this.f10732.addUpdateListener(r3);
        this.f10732.addListener(new AbstractC1335Bh() { // from class: o.uF.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                uF.this.f10710.postDelayed(uF.this.f10721, 2000);
            }
        });
        this.f10741.addUpdateListener(r3);
        this.f10741.addListener(new AbstractC1335Bh() { // from class: o.uF.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                uF.this.f10710.setVisibility(8);
                uF.this.f10710.setAlpha(1.0f);
            }
        });
        this.f10731.setOnClickListener(new View.OnClickListener() { // from class: o.uF.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(uF.this.getContext(), NetflixActivity.class);
                if (!C1322Av.m3793(netflixActivity) && uF.this.f10709 != null) {
                    AJ.m3357(netflixActivity, uF.this.f10709.getBigRowSummary().getId(), uF.this.f10709.getTitle());
                }
            }
        });
        this.f10718.setOnClickListener(new View.OnClickListener() { // from class: o.uF.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(uF.this.getContext(), NetflixActivity.class);
                if (uF.this.f10709 != null && !C1322Av.m3793(netflixActivity)) {
                    if (uF.this.m11374(uF.this.f10709)) {
                        qU.m9979(netflixActivity, uF.this.f10709.getType(), uF.this.f10709.getId(), uF.this.f10709.getTitle(), uF.this.f10739, "BigRow", null);
                    } else {
                        qU.m9974(netflixActivity, uF.this.f10709, uF.this.f10739, "BigRow");
                    }
                }
            }
        });
        this.f10723.setOnClickListener(new View.OnClickListener() { // from class: o.uF.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(uF.this.getContext(), NetflixActivity.class);
                if (!C1322Av.m3793(netflixActivity) && uF.this.f10709 != null) {
                    qU.m9974(netflixActivity, uF.this.f10709, uF.this.f10739, "BigRow");
                }
            }
        });
        this.f10734.setOnClickListener(new View.OnClickListener() { // from class: o.uF.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(uF.this.getContext(), NetflixActivity.class);
                if (!C1322Av.m3793(netflixActivity) && uF.this.f10727 != null) {
                    PlaybackLauncher.m1605(netflixActivity, uF.this.f10727, uF.this.f10730, uF.this.f10739, -1);
                }
            }
        });
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11412(AbstractC2070ps psVar, pC pCVar, final oY oYVar) {
        BigRowSummary bigRowSummary;
        String str;
        String motionId;
        this.f10709 = psVar;
        ImageLoader imageLoader = NetflixActivity.getImageLoader(getContext());
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class);
        if (C1322Av.m3793(netflixActivity) || imageLoader == null || this.f10709 == null || (bigRowSummary = this.f10709.getBigRowSummary()) == null) {
            m11381("no big row data or activity is null");
            return;
        }
        boolean r11 = m11374(this.f10709);
        boolean r12 = C1349Bv.m4126(this.f10709.getBigRowSummary().getBillboardType(), "newsFeed");
        String supplementalMessage = r11 ? bigRowSummary.getPhase().supplementalMessage() : bigRowSummary.getSupplementalMessage();
        if (C1349Bv.m4113(supplementalMessage)) {
            supplementalMessage = bigRowSummary.getTitle();
        }
        this.f10740.setText(supplementalMessage);
        m11388(psVar, netflixActivity, r11 ? bigRowSummary.getPhase().actions() : bigRowSummary.getActions(), r12);
        String str2 = null;
        this.f10708.setVisibility(8);
        if (bigRowSummary.getBackground() != null) {
            str = bigRowSummary.getBackground().getUrl();
            if (bigRowSummary.getLogo() != null) {
                str2 = bigRowSummary.getLogo().getTone();
                this.f10708.setVisibility(0);
                m11392(bigRowSummary.getLogo());
                imageLoader.mo3063(this.f10708, bigRowSummary.getLogo().getUrl(), AssetType.merchStill, psVar.getTitle(), StaticImgConfig.DARK_NO_PLACEHOLDER, false, 1);
            }
        } else if (bigRowSummary.getBackgroundPortrait() != null) {
            this.f10708.setVisibility(8);
            str = bigRowSummary.getBackgroundPortrait().getUrl();
        } else {
            m11381("no background.");
            return;
        }
        imageLoader.mo3063(this.f10718, str, AssetType.merchStill, psVar.getTitle(), StaticImgConfig.DARK_NO_PLACEHOLDER, false, 1);
        this.f10739 = new qN(pCVar.getRequestId(), pCVar.getTrackId(), pCVar.getListPos(), 0);
        if (this.f10709.isPreRelease()) {
            m11370(this.f10709.getBigRowSummary());
        }
        this.f10713.put("awardCampaign", bigRowSummary.getAwardTrackId());
        this.f10713.put("billboardTheme", bigRowSummary.getBillboardTheme());
        this.f10713.put("billboardType", bigRowSummary.getBillboardType());
        if (!(bigRowSummary.getVideo() == null || (motionId = bigRowSummary.getVideo().motionId()) == null)) {
            this.f10715 = motionId;
        }
        Pair<String, Long> r17 = C2196tz.m11302(netflixActivity);
        boolean z = System.currentTimeMillis() > ((Long) r17.second).longValue() + 86400000;
        if (C1349Bv.m4126((String) r17.first, this.f10715)) {
            this.f10724 = true;
            this.f10717 = true;
            netflixActivity.getServiceManager().m9764().mo9487(new C0545(), new AbstractC2061pj() { // from class: o.uF.9
                @Override // o.AbstractC2061pj, o.oU
                public void onBigRowYellowSquareValueFetched(boolean z2, Status status) {
                    uF.this.f10717 = z2;
                    boolean z3 = uF.this.f10724;
                    uF.this.f10724 = false;
                    if (uF.this.f10711 && z3) {
                        uF.this.m11373(oYVar);
                    }
                }
            });
        } else {
            this.f10724 = false;
            this.f10717 = !z;
        }
        if (C1349Bv.m4107(bigRowSummary.getUiLabel())) {
            this.f10728 = uA.m11323(bigRowSummary.getUiLabel());
        }
        if (!r12 || !C1349Bv.m4107(str2) || !C1349Bv.m4107(this.f10709.getBigRowSummary().getHashtag())) {
            this.f10735.setVisibility(8);
            return;
        }
        this.f10735.setTextColor(Tone.LIGHT.equals(str2) ? -1 : -16777216);
        this.f10735.setVisibility(0);
        this.f10735.setText(this.f10709.getBigRowSummary().getHashtag());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m11374(AbstractC2070ps psVar) {
        Long start;
        BigRowSummary bigRowSummary = psVar.getBigRowSummary();
        BillboardAvailabilityDates availabilityDates = bigRowSummary.getAvailabilityDates();
        return (!psVar.isPreRelease() || bigRowSummary.getPhase() == null || availabilityDates == null || (start = availabilityDates.start()) == null || start.longValue() - System.currentTimeMillis() >= 0) ? false : true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11388(AbstractC2070ps psVar, NetflixActivity netflixActivity, List<BillboardCTA> list, boolean z) {
        final C2059ph serviceManager = netflixActivity.getServiceManager();
        if (list == null) {
            list = new ArrayList(2);
        }
        this.f10734.setVisibility(8);
        this.f10738.setVisibility(8);
        this.f10731.setVisibility(8);
        this.f10723.setVisibility(8);
        if (list.size() == 0) {
            list.add(new BillboardCTA("", false, "play", "", false, "play", psVar.getId()));
        }
        if (list.size() == 1) {
            String type = list.get(0).getType();
            if (C1349Bv.m4107(type)) {
                char c = 65535;
                switch (type.hashCode()) {
                    case 3443508:
                        if (type.equals("play")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (z) {
                            list.add(new BillboardCTA("", false, "share", "", false, "share", psVar.getId()));
                            break;
                        } else {
                            list.add(new BillboardCTA("", false, "addToPlaylist", "", false, "addToPlaylist", psVar.getId()));
                            break;
                        }
                    default:
                        list.add(0, new BillboardCTA("", false, "play", "", false, "play", psVar.getId()));
                        break;
                }
            }
        }
        while (list.size() > 2) {
            list.remove(list.size() - 1);
        }
        for (final BillboardCTA billboardCTA : list) {
            if (C1349Bv.m4107(billboardCTA.getType())) {
                String type2 = billboardCTA.getType();
                char c2 = 65535;
                switch (type2.hashCode()) {
                    case 107961:
                        if (type2.equals("mdp")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3443508:
                        if (type2.equals("play")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 109400031:
                        if (type2.equals("share")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1557721666:
                        if (type2.equals("details")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1879443694:
                        if (type2.equals("addToPlaylist")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1879474642:
                        if (type2.equals("playlist")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                        this.f10723.setVisibility(0);
                        continue;
                    case 2:
                        this.f10731.setVisibility(0);
                        continue;
                    case 3:
                    case 4:
                        if (!psVar.isPreRelease() || m11374(psVar)) {
                            this.f10716 = null;
                        } else {
                            this.f10716 = new C2103qw(netflixActivity, psVar.getId());
                            netflixActivity.registerReceiver(this.f10716, new IntentFilter("com.netflix.mediaclient.mylist.intent.action.ADD"));
                        }
                        this.f10738.setVisibility(0);
                        this.f10726 = serviceManager.m9792(netflixActivity, this.f10738, psVar.getId(), psVar.getType(), this.f10739.getTrackId(), false);
                        serviceManager.m9802(psVar.getId(), this.f10726);
                        continue;
                    case 5:
                        this.f10734.setVisibility(0);
                        this.f10734.setText(C2223uw.m11781(getContext(), billboardCTA.getName(), billboardCTA.getSequenceNumber()));
                        C2223uw.m11782(serviceManager, psVar, billboardCTA, new oP("BigRowView") { // from class: o.uF.12
                            @Override // o.oP, o.oU
                            public void onMovieDetailsFetched(pP pPVar, Status status) {
                                super.onMovieDetailsFetched(pPVar, status);
                                if (pPVar != null) {
                                    uF.this.f10730 = VideoType.MOVIE;
                                    uF.this.f10727 = pPVar.getPlayable();
                                }
                            }

                            @Override // o.oP, o.oU
                            public void onEpisodeDetailsFetched(pI pIVar, Status status) {
                                super.onEpisodeDetailsFetched(pIVar, status);
                                if (pIVar != null) {
                                    uF.this.f10730 = VideoType.EPISODE;
                                    uF.this.f10727 = pIVar.getPlayable();
                                }
                            }

                            @Override // o.oP, o.oU
                            public void onEpisodesFetched(List<pI> list2, Status status) {
                                super.onEpisodesFetched(list2, status);
                                if (list2 != null && !list2.isEmpty()) {
                                    uF.this.f10730 = list2.get(0).getType();
                                    uF.this.f10727 = list2.get(0).getPlayable();
                                }
                            }

                            @Override // o.oP, o.oU
                            public void onShowDetailsFetched(pR pRVar, Status status) {
                                super.onShowDetailsFetched(pRVar, status);
                                if (pRVar == null) {
                                    return;
                                }
                                if (C2223uw.m11783(billboardCTA.getName())) {
                                    serviceManager.m9764().mo9484(pRVar.getCurrentEpisodeId(), null, this);
                                    return;
                                }
                                uF.this.f10730 = VideoType.SHOW;
                                uF.this.f10727 = pRVar.getPlayable();
                            }
                        });
                        continue;
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11370(BigRowSummary bigRowSummary) {
        if (bigRowSummary.getPhase() != null && bigRowSummary.getAvailabilityDates() != null) {
            final BillboardPhase phase = bigRowSummary.getPhase();
            Long start = bigRowSummary.getAvailabilityDates().start();
            if (start != null) {
                Long valueOf = Long.valueOf(start.longValue() - Long.valueOf(System.currentTimeMillis()).longValue());
                if (valueOf.longValue() > 0 && this.f10725 == null) {
                    C1283.m16854("BigRowView", " adding the delayed handlers for Pre Release content for " + valueOf + "ms");
                    this.f10725 = Completable.timer(valueOf.longValue(), TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: o.uF.15
                        @Override // io.reactivex.functions.Action
                        public void run() {
                            NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(uF.this.getContext(), NetflixActivity.class);
                            if (!C1322Av.m3793(netflixActivity) && uF.this.f10709 != null) {
                                uF.this.m11388(uF.this.f10709, netflixActivity, phase.actions(), C1349Bv.m4126(uF.this.f10709.getBigRowSummary().getBillboardType(), "newsFeed"));
                                uF.this.f10740.setText(C1349Bv.m4113(phase.supplementalMessage()) ? uF.this.f10709.getBigRowSummary().getTitle() : phase.supplementalMessage());
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m11373(oY oYVar) {
        if (!C1349Bv.m4107(this.f10715) || oYVar == null || this.f10729.m2347() || C1330Bc.m4006() || !m11372() || this.f10724) {
            return false;
        }
        if (0 == 0 && this.f10717) {
            return false;
        }
        this.f10719 = System.currentTimeMillis();
        this.f10729.setViewInFocus(true);
        this.f10729.setVisibility(4);
        this.f10729.setVolume(this.f10714 ? 1.0f : 0.0f);
        this.f10710.setImageResource(this.f10714 ? R.drawable.ic_audio_on : R.drawable.ic_audio_off);
        return this.f10729.mo2340(oYVar, Long.parseLong(this.f10715), VideoType.MOVIE, this.f10728, this.f10739, 0, true);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m11372() {
        if (ConnectivityUtils.m2955(getContext())) {
            return true;
        }
        return !C0577.m14681(getContext()) && C0577.m14684(getContext()) >= BandwidthPreferenceDialogFragment.ManualBwChoice.HIGH.m1601();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11392(BillboardLogo billboardLogo) {
        int intValue = billboardLogo.getWidth().intValue();
        int intValue2 = billboardLogo.getHeight().intValue();
        float marginStart = (float) ((ViewGroup.MarginLayoutParams) this.f10708.getLayoutParams()).getMarginStart();
        float r5 = (float) AD.m3317(getContext());
        float f = (r5 / 1.778f) - (2.0f * marginStart);
        float f2 = (r5 / 3.0f) - marginStart;
        float f3 = (((float) intValue2) * f2) / ((float) intValue);
        if (f3 > f) {
            f2 = (f2 * f) / f3;
            f3 = f;
        }
        ViewGroup.LayoutParams layoutParams = this.f10708.getLayoutParams();
        layoutParams.width = (int) f2;
        layoutParams.height = (int) f3;
        this.f10708.setLayoutParams(layoutParams);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11381(String str) {
        setVisibility(8);
        C1276.m16820().mo5725("unable to show big row " + str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11410() {
        this.f10715 = "";
        this.f10730 = VideoType.UNKNOWN;
        this.f10727 = null;
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class);
        if (this.f10709 != null && !C1322Av.m3793(netflixActivity)) {
            if (this.f10716 != null) {
                netflixActivity.unregisterReceiver(this.f10716);
                this.f10716 = null;
            }
            if (this.f10726 != null) {
                C2059ph serviceManager = netflixActivity.getServiceManager();
                if (serviceManager.mo9519()) {
                    serviceManager.m9781(this.f10709.getId(), this.f10726);
                    this.f10726 = null;
                }
            }
        }
        m11411();
        m11383(false);
        this.f10710.removeCallbacks(this.f10721);
        m11401(false);
        if (this.f10725 != null) {
            this.f10725.dispose();
        }
        this.f10725 = null;
        if (this.f10718 != null) {
            this.f10718.mo14543();
        }
        if (this.f10708 != null) {
            this.f10708.mo14543();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11411() {
        this.f10729.setViewInFocus(false);
        this.f10729.b_();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11390(boolean z) {
        m11380();
        this.f10729.setVisibility(0);
        if (z) {
            this.f10736.start();
            return;
        }
        this.f10718.setVisibility(4);
        this.f10708.setVisibility(8);
        this.f10735.setVisibility(8);
        this.f10729.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11383(boolean z) {
        m11380();
        this.f10718.setVisibility(0);
        this.f10708.setVisibility(0);
        this.f10735.setVisibility(0);
        if (z) {
            this.f10718.setAlpha(0.0f);
            this.f10708.setAlpha(0.0f);
            this.f10735.setAlpha(0.0f);
            this.f10737.start();
            return;
        }
        this.f10718.setAlpha(1.0f);
        this.f10708.setAlpha(1.0f);
        this.f10735.setAlpha(1.0f);
        this.f10729.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11395(boolean z) {
        if (this.f10710.getVisibility() == 0) {
            m11401(z);
        } else {
            m11371(z);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m11387() {
        this.f10741.cancel();
        this.f10732.cancel();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11380() {
        this.f10737.cancel();
        this.f10736.cancel();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m11401(boolean z) {
        this.f10710.removeCallbacks(this.f10721);
        m11387();
        if (z) {
            this.f10710.setVisibility(0);
            this.f10733.setVisibility(0);
            this.f10741.start();
            return;
        }
        this.f10710.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11371(boolean z) {
        this.f10710.removeCallbacks(this.f10721);
        m11387();
        this.f10710.setVisibility(0);
        this.f10733.setVisibility(0);
        if (z) {
            this.f10732.start();
        } else {
            this.f10710.postDelayed(this.f10721, 2000);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (this.f10709 == null) {
                return;
            }
            if (this.f10729.m2331()) {
                this.f10729.m2345();
            } else {
                m11383(false);
            }
        } else if (this.f10729.m2347()) {
            this.f10729.m2350();
        }
    }

    public void setIsInViewPort(boolean z, oY oYVar) {
        if (this.f10711 != z) {
            if (z) {
                this.f10729.setViewInFocus(true);
                if (this.f10729.m2331()) {
                    this.f10729.m2345();
                } else {
                    m11373(oYVar);
                    NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class);
                    if (!(C1322Av.m3793(netflixActivity) || this.f10709 == null || this.f10709.getBigRowSummary() == null)) {
                        this.f10713.put("token", this.f10709.getBigRowSummary().getImpressionToken());
                        netflixActivity.getServiceManager().m9764().mo9466(this.f10709, BillboardInteractionType.IMPRESSION, this.f10713);
                    }
                }
            } else {
                this.f10729.setViewInFocus(false);
                if (this.f10729.m2347()) {
                    this.f10729.m2350();
                }
            }
        }
        this.f10711 = z;
    }
}

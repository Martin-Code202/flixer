package com.netflix.mediaclient.ui.details;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.lomo.LoMoUtils;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.EnumMap;
import java.util.Map;
import o.AD;
import o.AU;
import o.AbstractC2045ou;
import o.AbstractC2381zo;
import o.BX;
import o.C0522;
import o.C0784;
import o.C0892;
import o.C1050;
import o.C1080;
import o.C1118;
import o.C1131;
import o.C1177;
import o.C1244;
import o.C1283;
import o.C1300Ac;
import o.C1317As;
import o.C1322Av;
import o.C1349Bv;
import o.C1362Ch;
import o.C1702eO;
import o.C2059ph;
import o.X;
import o.oX;
import o.pE;
import o.pR;
import o.pT;
import o.qK;
import o.qT;
import o.qY;
public class VideoDetailsViewGroup extends LinearLayout {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final EnumMap<SupportedCapabilities, Integer> f2905 = new EnumMap<SupportedCapabilities, Integer>(SupportedCapabilities.class) { // from class: com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.1
        {
            put((AnonymousClass1) SupportedCapabilities.HD, (SupportedCapabilities) Integer.valueOf((int) R.string.icon_font_new_hd));
            put((AnonymousClass1) SupportedCapabilities.UHD, (SupportedCapabilities) Integer.valueOf((int) R.string.icon_font_UHD));
            put((AnonymousClass1) SupportedCapabilities._5dot1, (SupportedCapabilities) Integer.valueOf((int) R.string.icon_font_5dot1));
            put((AnonymousClass1) SupportedCapabilities.HDR10, (SupportedCapabilities) Integer.valueOf((int) R.string.icon_font_HDR10));
            put((AnonymousClass1) SupportedCapabilities.DOLBY_VISION, (SupportedCapabilities) Integer.valueOf((int) R.string.icon_font_DolbyVision));
        }
    };

    /* renamed from: ʻ  reason: contains not printable characters */
    protected TextView f2906;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected TextView f2907;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected View.OnClickListener f2908;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    protected ImageView f2909;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected TextView f2910;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    protected TextView f2911;

    /* renamed from: ʾ  reason: contains not printable characters */
    protected ViewGroup f2912;

    /* renamed from: ʿ  reason: contains not printable characters */
    protected View f2913;

    /* renamed from: ˈ  reason: contains not printable characters */
    protected C1177 f2914;

    /* renamed from: ˉ  reason: contains not printable characters */
    protected TextView f2915;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected TextView f2916;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    protected boolean f2917;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public qY f2918;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected C1050 f2919;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    protected ViewStub f2920;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    protected ViewStub f2921;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    public pT f2922;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected ViewGroup f2923;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private C1118 f2924;

    /* renamed from: ˌ  reason: contains not printable characters */
    private int f2925;

    /* renamed from: ˍ  reason: contains not printable characters */
    private String f2926;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected TextView f2927;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private View f2928;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected DownloadButton f2929;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private final BroadcastReceiver f2930 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1283.m16846("VideoDetailsViewGroup", "Received null intent - ignoring");
                return;
            }
            if (C1349Bv.m4126(VideoDetailsViewGroup.this.f2926, intent.getStringExtra(NetflixActivity.EXTRA_VIDEO_ID)) && VideoDetailsViewGroup.this.f2914 != null) {
                int r3 = C1131.m16286(intent.getIntExtra("extra_user_thumb_rating", 0));
                VideoDetailsViewGroup.this.f2914.setRating(r3);
                VideoDetailsViewGroup.this.m1664(r3, true);
            }
        }
    };

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected TextView f2931;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected TextView f2932;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private final BroadcastReceiver f2933 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetflixActivity r2 = ViewUtils.m3026(VideoDetailsViewGroup.this);
            if (!C1317As.m3750(r2) && VideoDetailsViewGroup.this.f2922 != null) {
                VideoDetailsViewGroup.this.m1689(VideoDetailsViewGroup.this.f2922, r2);
            }
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    protected LinearLayout f2934;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected TextView f2935;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    protected TextView f2936;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected TextView f2937;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected TextView f2938;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected ViewGroup f2939;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected View f2940;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected View f2941;

    /* access modifiers changed from: package-private */
    public enum SupportedCapabilities {
        HD,
        UHD,
        _5dot1,
        HDR10,
        DOLBY_VISION
    }

    /* renamed from: com.netflix.mediaclient.ui.details.VideoDetailsViewGroup$ˊ  reason: contains not printable characters */
    public interface AbstractC0033 {
        /* renamed from: ˋ  reason: contains not printable characters */
        CharSequence mo1713();

        /* renamed from: ˎ  reason: contains not printable characters */
        CharSequence mo1714();

        /* renamed from: ॱ  reason: contains not printable characters */
        CharSequence mo1715();
    }

    public VideoDetailsViewGroup(Context context) {
        super(context);
        m1672();
    }

    public VideoDetailsViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1672();
    }

    public VideoDetailsViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1672();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo1697() {
        return R.layout.video_details_view_group;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m1672() {
        LayoutInflater.from(getContext()).inflate(mo1697(), (ViewGroup) this, true);
        setOrientation(1);
        this.f2928 = ViewUtils.m3033((NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class));
        addView(this.f2928, 0);
        mo1692();
        NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class);
        if (!(this.f2915 == null || netflixActivity == null)) {
            this.f2915.setTextColor(BrowseExperience.m1767(netflixActivity, (int) R.attr.matchPercentageColor));
            this.f2924 = new C1118(this.f2915, R.string.rating_match_percentage, R.string.rating_new_to_pvr, BrowseExperience.m1767(netflixActivity, 16843982));
        }
        this.f2925 = m1657();
        m1669();
        this.f2908 = new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1300Ac.m3540(new C1080(AppView.storyArt, null), new C1244());
                NetflixActivity netflixActivity2 = (NetflixActivity) C1322Av.m3791(VideoDetailsViewGroup.this.getContext(), NetflixActivity.class);
                if (!C1322Av.m3793(netflixActivity2) && (netflixActivity2 instanceof qK)) {
                    oX r4 = ((qK) netflixActivity2).mo1635();
                    r4.mo9594(PlayLocationType.STORY_ART);
                    PlaybackLauncher.m1607(netflixActivity2, VideoDetailsViewGroup.this.f2922.getPlayable(), VideoDetailsViewGroup.this.f2922.getType(), r4);
                }
            }
        };
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo1691(boolean z) {
        View view;
        if (!this.f2917) {
            if (this.f2920 == null || this.f2921 == null) {
                view = this;
            } else {
                view = (z ? this.f2920 : this.f2921).inflate();
            }
            this.f2934 = (LinearLayout) view.findViewById(R.id.video_actions);
            this.f2940 = view.findViewById(R.id.video_details_add_to_queue_group);
            this.f2916 = (TextView) view.findViewById(R.id.video_details_add_to_queue);
            this.f2927 = (TextView) view.findViewById(R.id.video_details_add_to_queue_label);
            this.f2929 = (DownloadButton) view.findViewById(R.id.video_details_download_button);
            ViewStub viewStub = (ViewStub) findViewById(R.id.user_rating_stub);
            NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class);
            boolean z2 = netflixActivity != null && netflixActivity.getServiceManager().m9822();
            if (viewStub != null) {
                viewStub.setLayoutResource(C0892.f14768.m15612(z2, BrowseExperience.m1780(), getLayoutDirection()) ? R.layout.user_rating_button_lottie_view : R.layout.user_rating_button_view);
                viewStub.inflate();
                this.f2914 = (C1177) findViewById(R.id.user_rating);
                this.f2914.setDark(!BrowseExperience.m1780());
            }
            BX.m3950(this.f2914);
            mo1687();
            this.f2917 = true;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo1692() {
        this.f2920 = (ViewStub) findViewById(R.id.my_list_mdp);
        this.f2921 = (ViewStub) findViewById(R.id.my_list_sdp);
        this.f2915 = (TextView) findViewById(R.id.video_details_match_percentage);
        this.f2931 = (TextView) findViewById(R.id.video_details_basic_info);
        this.f2932 = (TextView) findViewById(R.id.video_details_episode_badge);
        this.f2935 = (TextView) findViewById(R.id.video_details_episode_title);
        this.f2907 = (TextView) findViewById(R.id.video_details_supplemental);
        this.f2937 = (TextView) findViewById(R.id.video_details_synopsis);
        this.f2910 = (TextView) findViewById(R.id.video_details_starring);
        this.f2906 = (TextView) findViewById(R.id.video_details_creators);
        this.f2919 = (C1050) findViewById(R.id.video_img);
        this.f2938 = (TextView) findViewById(R.id.video_details_title);
        this.f2923 = (ViewGroup) findViewById(R.id.video_img_group);
        this.f2909 = (ImageView) findViewById(R.id.background_img);
        this.f2911 = (TextView) findViewById(R.id.similar_items_grid_view_title);
        this.f2936 = (TextView) findViewById(R.id.basic_info_badges);
        this.f2912 = (ViewGroup) findViewById(R.id.video_details_footer);
        this.f2939 = (ViewGroup) findViewById(R.id.video_details_copyright_group);
        this.f2941 = findViewById(R.id.video_play_icon);
        this.f2913 = findViewById(R.id.video_details_info_layout);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo1687() {
        int i;
        int i2;
        int i3;
        if (this.f2934 == null) {
            return;
        }
        if (this.f2934.getChildCount() < 3) {
            throw new IllegalStateException("At least 3 buttons expected in the video actions");
        }
        m1683(this.f2929);
        m1683(this.f2914);
        m1683(this.f2940);
        if (this.f2929 == null) {
            i = 0;
        } else {
            i = this.f2929.getMeasuredWidth();
        }
        if (this.f2914 == null) {
            i2 = 0;
        } else {
            i2 = this.f2914.getMeasuredWidth();
        }
        if (this.f2940 == null) {
            i3 = 0;
        } else {
            i3 = this.f2940.getMeasuredWidth();
        }
        int max = Math.max(Math.min(getMeasuredWidth() / 4, Math.max(i, Math.max(i2, Math.max(i3, getResources().getDimensionPixelSize(R.dimen.video_actions_button_max_width))))), getResources().getDimensionPixelSize(R.dimen.video_actions_button_min_width));
        if (this.f2934 != null) {
            for (int i4 = 0; i4 < this.f2934.getChildCount(); i4++) {
                this.f2934.getChildAt(i4).setVisibility(4);
            }
        }
        m1666(this.f2929, max);
        m1666(this.f2914, max);
        m1666(this.f2940, max);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1683(View view) {
        if (view != null) {
            view.measure(0, 0);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static void m1666(View view, int i) {
        if (view != null && view.getParent() != null) {
            FrameLayout frameLayout = (FrameLayout) view.getParent();
            frameLayout.setVisibility(view.getVisibility());
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(i, -1));
        }
    }

    public void setMyListVisibility(int i) {
        if (this.f2940 != null) {
            this.f2940.setVisibility(i);
            mo1687();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m1694(pT pTVar) {
        NetflixActivity netflixActivity;
        return pTVar != null && pTVar.getType() == VideoType.MOVIE && (netflixActivity = (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class)) != null && pTVar != null && netflixActivity.getServiceManager() != null && netflixActivity.getServiceManager().mo9519() && !C1317As.m3750(netflixActivity) && this.f2929 != null && netflixActivity.getServiceManager().m9824() && pTVar.getPlayable().isAvailableOffline();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m1678(pT pTVar) {
        if (m1694(pTVar)) {
            this.f2929.setVisibility(0);
            this.f2929.setEnabled(true);
            this.f2929.setStateFromPlayable(pTVar.getPlayable(), (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class));
            mo1687();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void setupDownloadButton(pT pTVar) {
        if (m1694(pTVar)) {
            this.f2929.setStateFromPlayable(pTVar.getPlayable(), (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class));
            ViewUtils.m3020((View) this.f2929, true);
            mo1687();
            return;
        }
        ViewUtils.m3020((View) this.f2929, false);
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m1669() {
        mo1701();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewUtils.m3009(VideoDetailsViewGroup.this, this);
                VideoDetailsViewGroup.this.mo1701();
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0522 m1676() {
        return this.f2919;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public ViewGroup m1682() {
        return this.f2912;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public ImageView m1673() {
        return this.f2909;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo1701() {
        this.f2919.getLayoutParams().height = mo1674();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public int mo1674() {
        int measuredWidth = this.f2923.getMeasuredWidth();
        if (measuredWidth <= 0) {
            measuredWidth = AD.m3317(getContext());
        }
        return (int) (((float) measuredWidth) * 0.5625f);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m1700() {
        if (this.f2911 != null) {
            this.f2911.setVisibility(0);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m1675() {
        if (this.f2911 != null) {
            this.f2911.setVisibility(8);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public TextView mo1696() {
        return this.f2916;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public TextView m1699() {
        return this.f2927;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public DownloadButton mo1686() {
        return this.f2929;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m1695() {
        if (this.f2928 != null) {
            removeView(this.f2928);
            this.f2928 = null;
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void m1681() {
        if (this.f2919 != null) {
            this.f2919.m14542();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo1685(pT pTVar, AbstractC0033 r9) {
        this.f2926 = pTVar.getId();
        this.f2922 = pTVar;
        mo1691(pTVar.getType() == VideoType.MOVIE);
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class);
        mo1680(pTVar, netflixActivity, String.format(getResources().getString(R.string.accesibility_play_video), pTVar.getTitle()));
        mo1684(pTVar);
        mo1690(pTVar, r9);
        m1689(pTVar, netflixActivity);
        m1688(pTVar);
        m1698(pTVar);
        m1693(r9);
        m1671(pTVar);
        if (this.f2907 != null) {
            if (C1349Bv.m4113(pTVar.getSupplementalMessage())) {
                this.f2907.setVisibility(8);
            } else {
                this.f2907.setText(pTVar.getSupplementalMessage());
            }
        }
        boolean z = (this.f2935 == null || this.f2932 == null || this.f2907 == null || this.f2910 == null || this.f2906 == null) ? false : true;
        m1670(pTVar);
        if (!m1659(pTVar) || !z) {
            if (this.f2932 != null) {
                this.f2932.setVisibility(8);
            }
            if (this.f2935 != null) {
                this.f2935.setVisibility(8);
                return;
            }
            return;
        }
        m1677((pR) pTVar);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m1670(pT pTVar) {
        if ((pTVar instanceof pR) && this.f2932 != null) {
            LoMoUtils.m2145(((pR) pTVar).getCurrentEpisodeBadge(), this.f2932);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m1671(pT pTVar) {
        if (this.f2941 != null) {
            this.f2941.setVisibility(pTVar.isPreRelease() ? 4 : 0);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m1677(pR pRVar) {
        String currentEpisodeTitle = pRVar.getCurrentEpisodeTitle();
        if (currentEpisodeTitle != null) {
            this.f2935.setText(getResources().getString(R.string.label_episodeTitleBasicQuoted, currentEpisodeTitle));
            if (this.f2907 != null) {
                this.f2907.setText(pRVar.getSupplementalMessage());
                this.f2907.setVisibility(0);
            }
            this.f2910.setVisibility(8);
            this.f2906.setVisibility(8);
            return;
        }
        this.f2935.setText(pRVar.getSupplementalMessage());
        if (this.f2907 != null) {
            this.f2907.setVisibility(8);
        }
        this.f2910.setVisibility(0);
        this.f2906.setVisibility(0);
    }

    public void setCopyright(pT pTVar) {
        if (this.f2939 == null) {
            return;
        }
        if (C1349Bv.m4107(pTVar.getCopyright())) {
            this.f2939.setVisibility(0);
            new qT(pTVar, getContext(), this.f2939);
            return;
        }
        this.f2939.setVisibility(8);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1688(final pT pTVar) {
        CoordinatorLayout coordinatorLayout;
        if (this.f2914 != null) {
            final qK qKVar = (qK) C1317As.m3755(getContext(), qK.class);
            final NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(getContext(), NetflixActivity.class);
            if (!C1317As.m3750(netflixActivity) && (coordinatorLayout = (CoordinatorLayout) netflixActivity.findViewById(R.id.coordinatorLayout)) != null) {
                this.f2914.setRating(pTVar.getUserThumbRating());
                this.f2914.setOnRateListener(coordinatorLayout, new C1177.AbstractC1178() { // from class: com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.3

                    /* renamed from: ˎ  reason: contains not printable characters */
                    private boolean f2945 = false;

                    /* renamed from: ॱॱ  reason: contains not printable characters */
                    private boolean f2948 = false;

                    @Override // o.C1177.AbstractC1178
                    /* renamed from: ˎ  reason: contains not printable characters */
                    public void mo1705(C1177 r1, boolean z) {
                        this.f2945 = z;
                    }

                    @Override // o.C1177.AbstractC1178
                    /* renamed from: ˊ  reason: contains not printable characters */
                    public void mo1703(C1177 r11, int i) {
                        C1362Ch.m4380(null, netflixActivity.getUiScreen().f4084);
                        netflixActivity.getServiceManager().m9764().mo9468(VideoDetailsViewGroup.this.f2926, pTVar.getType(), i, (qKVar == null || qKVar.mo1635() == null) ? -1 : qKVar.mo1635().getTrackId(), new AbstractC2381zo("VideoDetailsViewGroup", pTVar, Logger.INSTANCE.m142(new C0784(C1131.m16285(i)))) { // from class: com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.3.2
                            /* access modifiers changed from: protected */
                            @Override // o.AbstractC2381zo
                            /* renamed from: ˋ  reason: contains not printable characters */
                            public void mo1706(pE pEVar) {
                            }

                            /* access modifiers changed from: protected */
                            @Override // o.AbstractC2381zo
                            /* renamed from: ˏ  reason: contains not printable characters */
                            public void mo1707(Status status) {
                            }
                        });
                        this.f2948 = true;
                    }

                    @Override // o.C1177.AbstractC1178
                    /* renamed from: ˎ  reason: contains not printable characters */
                    public void mo1704(float f) {
                        if (VideoDetailsViewGroup.this.f2934 != null) {
                            VideoDetailsViewGroup.this.f2934.setAlpha(1.0f - f);
                        }
                    }

                    @Override // o.C1177.AbstractC1178
                    /* renamed from: ˊ  reason: contains not printable characters */
                    public void mo1702(C1177 r4) {
                        X.m5323(r4.getContext(), this.f2948, this.f2945);
                        this.f2945 = false;
                        this.f2948 = false;
                    }
                }, true, 1);
                m1664(pTVar.getUserThumbRating(), false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1664(int i, boolean z) {
        if (this.f2915 != null && this.f2924 != null) {
            this.f2924.m16262(i, this.f2922.getMatchPercentage(), this.f2922.isNewForPvr(), z);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo1690(pT pTVar, AbstractC0033 r4) {
        if (this.f2931 != null && pTVar != null && pTVar.isAvailableToStream()) {
            this.f2931.setText(r4.mo1715());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1689(pT pTVar, NetflixActivity netflixActivity) {
        String str = "";
        for (Map.Entry<SupportedCapabilities, Boolean> entry : m1661(pTVar, netflixActivity).entrySet()) {
            if (entry.getValue().booleanValue()) {
                str = str + getResources().getString(f2905.get(entry.getKey()).intValue()) + m1668();
            }
        }
        m1667(str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1698(pT pTVar) {
        String synopsis = pTVar.getSynopsis();
        if (this.f2937 != null) {
            if (m1659(pTVar)) {
                synopsis = m1660(((pR) pTVar).getCurrentEpisodeSynopsis(), synopsis);
            }
            this.f2937.setText(C1349Bv.m4113(synopsis) ? "" : C1349Bv.m4128(synopsis));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m1693(AbstractC0033 r4) {
        if (this.f2910 != null) {
            CharSequence r2 = r4.mo1713();
            if (C1349Bv.m4121(r2)) {
                this.f2910.setVisibility(8);
            } else {
                this.f2910.setText(r2);
                this.f2910.setVisibility(0);
            }
        }
        if (this.f2906 != null) {
            CharSequence r22 = r4.mo1714();
            if (C1349Bv.m4121(r22)) {
                this.f2906.setVisibility(8);
                return;
            }
            this.f2906.setText(r22);
            this.f2906.setVisibility(0);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo1684(pT pTVar) {
        if (this.f2938 != null) {
            this.f2938.setText(pTVar.getTitle());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo1680(pT pTVar, NetflixActivity netflixActivity, String str) {
        String storyUrl = pTVar.getStoryUrl();
        if (m1659(pTVar)) {
            storyUrl = m1660(((pR) pTVar).getCurrentEpisodeHorzDispUrl(), storyUrl);
        }
        NetflixActivity.getImageLoader(netflixActivity).mo3063(this.f2919, storyUrl, AssetType.boxArt, str, BrowseExperience.m1769(), true, 1);
        mo1679(pTVar, netflixActivity);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean m1658(pT pTVar) {
        return (pTVar instanceof pR) && VideoType.SHOW.equals(pTVar.getType()) && pTVar.isNSRE();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m1656(pT pTVar) {
        return pTVar != null && pTVar.hasWatched();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean m1659(pT pTVar) {
        return m1658(pTVar) && m1656(pTVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m1660(String str, String str2) {
        return (str == null || str.isEmpty()) ? str2 : str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo1679(pT pTVar, NetflixActivity netflixActivity) {
        if (!pTVar.isPreRelease()) {
            this.f2919.requestFocus();
            this.f2919.setOnClickListener(this.f2908);
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private int m1657() {
        return getResources().getDimensionPixelSize(R.dimen.double_padding);
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private String m1668() {
        return "  ";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private EnumMap<SupportedCapabilities, Boolean> m1661(pT pTVar, NetflixActivity netflixActivity) {
        C1702eO r3;
        AbstractC2045ou ouVar = null;
        if (AU.m3423(netflixActivity.getServiceManager()) && (r3 = netflixActivity.getServiceManager().m9811().mo6173()) != null) {
            ouVar = r3;
        }
        if (ouVar == null) {
            ouVar = m1662(netflixActivity.getServiceManager());
        }
        EnumMap<SupportedCapabilities, Boolean> enumMap = new EnumMap<>(SupportedCapabilities.class);
        enumMap.put((EnumMap<SupportedCapabilities, Boolean>) SupportedCapabilities._5dot1, (SupportedCapabilities) Boolean.valueOf(AD.m3294(ouVar, pTVar)));
        if (AD.m3288(ouVar, pTVar)) {
            enumMap.put((EnumMap<SupportedCapabilities, Boolean>) SupportedCapabilities.DOLBY_VISION, (SupportedCapabilities) true);
        } else if (AD.m3300(ouVar, pTVar)) {
            enumMap.put((EnumMap<SupportedCapabilities, Boolean>) SupportedCapabilities.HDR10, (SupportedCapabilities) true);
        } else if (AD.m3305(ouVar, pTVar)) {
            enumMap.put((EnumMap<SupportedCapabilities, Boolean>) SupportedCapabilities.UHD, (SupportedCapabilities) true);
        } else if (AD.m3313(ouVar, pTVar)) {
            enumMap.put((EnumMap<SupportedCapabilities, Boolean>) SupportedCapabilities.HD, (SupportedCapabilities) true);
        }
        return enumMap;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m1667(String str) {
        if (this.f2936 != null) {
            this.f2936.setPadding(C1349Bv.m4107(str) ? this.f2925 : 0, 0, 0, 0);
            this.f2936.setText(str);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.f2930, new IntentFilter("com.netflix.falkor.ACTION_NOTIFY_OF_RATINGS_CHANGE"));
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.f2933, new IntentFilter("com.netflix.mediaclient.intent.action.UPDATE_CAPABILITIES_BADGES"));
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f2930);
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f2933);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setDetailsHelper(qY qYVar) {
        this.f2918 = qYVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2045ou m1662(final C2059ph phVar) {
        return new AbstractC2045ou() { // from class: com.netflix.mediaclient.ui.details.VideoDetailsViewGroup.9
            @Override // o.AbstractC2045ou
            /* renamed from: ˎ  reason: contains not printable characters */
            public boolean mo1711() {
                return phVar != null && phVar.m9776();
            }

            @Override // o.AbstractC2045ou
            /* renamed from: ˋ  reason: contains not printable characters */
            public boolean mo1710() {
                return phVar != null && phVar.m9785();
            }

            @Override // o.AbstractC2045ou
            /* renamed from: ॱ  reason: contains not printable characters */
            public boolean mo1712() {
                return false;
            }

            @Override // o.AbstractC2045ou
            /* renamed from: ˊ  reason: contains not printable characters */
            public boolean mo1709() {
                return phVar != null && phVar.m9788();
            }

            @Override // o.AbstractC2045ou
            /* renamed from: ʼ  reason: contains not printable characters */
            public boolean mo1708() {
                return phVar != null && phVar.m9790();
            }
        };
    }
}

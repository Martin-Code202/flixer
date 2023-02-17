package com.netflix.mediaclient.ui.lomo;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.AddToListData;
import com.netflix.mediaclient.servicemgr.BillboardInteractionType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.model.leafs.originals.BillboardAwardsHeadline;
import com.netflix.model.leafs.originals.BillboardBackground;
import com.netflix.model.leafs.originals.BillboardCTA;
import com.netflix.model.leafs.originals.BillboardDateBadge;
import com.netflix.model.leafs.originals.BillboardLogo;
import com.netflix.model.leafs.originals.BillboardSummary;
import com.netflix.model.leafs.originals.Tone;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.AD;
import o.AbstractC2061pj;
import o.AbstractC2077pz;
import o.AbstractC2087qh;
import o.C0522;
import o.C1050;
import o.C1283;
import o.C1317As;
import o.C1322Av;
import o.C1349Bv;
import o.C1364Cj;
import o.C2059ph;
import o.C2223uw;
import o.View$OnClickListenerC1193;
import o.oB;
import o.oP;
import o.oX;
import o.pF;
import o.pI;
import o.pP;
import o.pR;
import o.pT;
import o.qJ;
import o.qN;
import o.qU;
import o.tP;
import o.uG;
import o.uO;
public class BillboardView extends RelativeLayout implements uO.Cif<AbstractC2077pz> {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected Button f3250;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    protected View.OnClickListener f3251 = new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.lomo.BillboardView.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C2059ph serviceManager = ((NetflixActivity) BillboardView.this.getContext()).getServiceManager();
            BillboardView.this.m2118(BillboardInteractionType.ACTION);
            if (serviceManager.mo9519()) {
                serviceManager.m9764().mo9466(BillboardView.this.f3278, BillboardInteractionType.ACTION, BillboardView.this.f3286);
            }
            qU.m9969((NetflixActivity) BillboardView.this.getContext(), BillboardView.this.f3278, BillboardView.this.f3278.getTopLevelId(), BillboardView.this.f3278.getParentTitle(), BillboardView.this.f3252, "BbView");
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    protected oX f3252 = new oB("BillboardView");

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private C0522 f3253;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected View$OnClickListenerC1193 f3254;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private View f3255;

    /* renamed from: ʾ  reason: contains not printable characters */
    private TextView f3256;

    /* renamed from: ʿ  reason: contains not printable characters */
    private C0522 f3257;

    /* renamed from: ˈ  reason: contains not printable characters */
    private View f3258;

    /* renamed from: ˉ  reason: contains not printable characters */
    private C0522 f3259;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected Button f3260;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private boolean f3261 = true;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private View f3262;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected String f3263;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private View f3264;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected TextView f3265;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private Button f3266;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private TextureView f3267;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected FrameLayout f3268;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private boolean f3269 = false;

    /* renamed from: ˌ  reason: contains not printable characters */
    private TextView f3270;

    /* renamed from: ˍ  reason: contains not printable characters */
    private qJ f3271;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected C1050 f3272;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private String f3273 = C1364Cj.f5158;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private final If f3274 = new If();

    /* renamed from: ˏ  reason: contains not printable characters */
    protected TextView f3275;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private int f3276;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected AddToListData.Cif f3277;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected AbstractC2077pz f3278;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected TextView f3279;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected String f3280;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private View f3281;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected String f3282;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected Button f3283;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected String f3284;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected boolean f3285;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected Map<String, String> f3286;

    public enum BillboardType {
        NSRE_SHOW("nsreShow"),
        NSRE_EPISODIC("nsreEpisodic"),
        VERTICAL("vertical"),
        AWARD("award");
        

        /* renamed from: ˋ  reason: contains not printable characters */
        private String f3308;

        private BillboardType(String str) {
            this.f3308 = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.f3308;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        protected static boolean m2140(BillboardSummary billboardSummary) {
            return m2141(billboardSummary, NSRE_SHOW.f3308);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        protected static boolean m2139(BillboardSummary billboardSummary) {
            return m2141(billboardSummary, NSRE_EPISODIC.f3308);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static boolean m2142(BillboardSummary billboardSummary) {
            return m2141(billboardSummary, VERTICAL.f3308);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        protected static boolean m2138(BillboardSummary billboardSummary) {
            return m2141(billboardSummary, AWARD.f3308);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private static boolean m2141(BillboardSummary billboardSummary, String str) {
            return billboardSummary != null && str.equalsIgnoreCase(billboardSummary.getBillboardType());
        }
    }

    /* access modifiers changed from: package-private */
    public enum BackgroundArtworkType {
        BillBoard("BILLBOARD"),
        StoryArt("StoryArt");
        

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f3302;

        private BackgroundArtworkType(String str) {
            this.f3302 = str;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public static boolean m2136(BillboardSummary billboardSummary) {
            return m2137(billboardSummary, BillBoard);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private static boolean m2137(BillboardSummary billboardSummary, BackgroundArtworkType backgroundArtworkType) {
            return (billboardSummary == null || billboardSummary.getBackground() == null || !backgroundArtworkType.f3302.equalsIgnoreCase(billboardSummary.getBackground().getArtWorkType())) ? false : true;
        }
    }

    public BillboardView(Context context) {
        super(context);
        m2111();
    }

    public BillboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2111();
    }

    public BillboardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2111();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m2111() {
        setFocusable(true);
        NetflixActivity netflixActivity = (NetflixActivity) getContext();
        this.f3254 = new View$OnClickListenerC1193(netflixActivity, this);
        netflixActivity.getLayoutInflater().inflate(mo2117(), this);
        mo2115();
        this.f3261 = AD.m3299();
        this.f3285 = m2104(netflixActivity);
        this.f3276 = AD.m3317(getContext());
        mo2129();
        m2100(netflixActivity);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public int mo2117() {
        return R.layout.billboard_view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2115() {
        this.f3281 = findViewById(R.id.billboard_info_view_group);
        this.f3258 = findViewById(R.id.billboard_info_margin);
        this.f3279 = (TextView) findViewById(R.id.billboard_basic_info);
        this.f3265 = (TextView) findViewById(R.id.billboard_phone_info);
        this.f3255 = findViewById(R.id.billboard_info_wrapper);
        this.f3275 = (TextView) findViewById(R.id.billboard_episode_badge);
        this.f3257 = (C0522) findViewById(R.id.billboard_date_badge);
        this.f3253 = (C0522) findViewById(R.id.billboard_awards_headline);
        this.f3256 = (TextView) findViewById(R.id.billboard_synopsis);
        this.f3259 = (C0522) findViewById(R.id.billboard_tv_card);
        this.f3268 = (FrameLayout) findViewById(R.id.billboard_story_art_frame);
        this.f3272 = (C1050) findViewById(R.id.billboard_story_art);
        this.f3267 = (TextureView) findViewById(R.id.motion_billboard_story_art);
        this.f3270 = (TextView) findViewById(R.id.motion_billboard_mute);
        this.f3262 = findViewById(R.id.billboard_shadow_overlay);
        this.f3264 = findViewById(R.id.billboard_shadow_overlay_gradient);
        this.f3260 = (Button) findViewById(R.id.billboard_cta1_button);
        this.f3250 = (Button) findViewById(R.id.billboard_cta2_button);
        this.f3266 = (Button) findViewById(R.id.billboard_add_to_queue);
        this.f3283 = (Button) findViewById(R.id.billboard_info_button);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo2129() {
        int i = this.f3285 ? 0 : this.f3276 / 3;
        ViewUtils.m3036(this.f3268, i);
        ((RelativeLayout.LayoutParams) this.f3262.getLayoutParams()).width = i;
        ((RelativeLayout.LayoutParams) this.f3264.getLayoutParams()).setMarginStart(i);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m2104(NetflixActivity netflixActivity) {
        return !AD.m3299() && AD.m3306(netflixActivity);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo2125() {
        this.f3281.setVisibility(this.f3285 ? 8 : 0);
        this.f3262.setVisibility(this.f3285 ? 8 : 0);
        this.f3264.setVisibility(this.f3285 ? 8 : 0);
        this.f3272.setVisibility(0);
        this.f3268.setVisibility(0);
        this.f3256.setVisibility(this.f3261 ? 0 : 8);
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        return this.f3252;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void mo2114() {
        if (this.f3257 != null) {
            this.f3257.mo14543();
        }
        if (this.f3253 != null) {
            this.f3253.mo14543();
        }
        if (this.f3259 != null) {
            this.f3259.mo14543();
        }
        if (this.f3272 != null) {
            this.f3272.mo14543();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(m2100((NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class)), 1073741824));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static int m2100(NetflixActivity netflixActivity) {
        if (netflixActivity == null) {
            return 0;
        }
        if (m2104(netflixActivity)) {
            return m2089(netflixActivity) + m2099((Context) netflixActivity) + m2107(netflixActivity);
        }
        return AD.m3306(netflixActivity) ? m2089(netflixActivity) : m2093(netflixActivity);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m2107(NetflixActivity netflixActivity) {
        return netflixActivity.getResources().getDimensionPixelSize(R.dimen.billboard_cta_portrait_height);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m2099(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.billboard_info_phone_height);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m2089(NetflixActivity netflixActivity) {
        if (tP.Cif.m10990()) {
            return (int) (((float) tP.Cif.m10989(netflixActivity, false)) * 1.08f);
        }
        return (int) (((float) tP.Cif.m10989(netflixActivity, false)) * 0.5625f);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m2093(NetflixActivity netflixActivity) {
        return (int) (((float) tP.Cif.m10989(netflixActivity, false)) / 2.39f);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo2124(AbstractC2077pz pzVar) {
        BillboardSummary billboardSummary;
        String str = this.f3263;
        if (!this.f3285 || (billboardSummary = pzVar.getBillboardSummary()) == null || billboardSummary.getLogo() == null || billboardSummary.getBackground() == null || billboardSummary.getBackgroundPortrait() == null) {
            return str;
        }
        String artWorkType = billboardSummary.getBackgroundPortrait().getArtWorkType();
        if ((artWorkType != null && "VERTICAL_BACKGROUND".equalsIgnoreCase(artWorkType)) || "VERTICAL_STORY_ART".equalsIgnoreCase(artWorkType) || "TALL PANEL".equalsIgnoreCase(artWorkType)) {
            C1283.m16850("BillboardView", "Receiving Vertical Asset for Billboard instead of receiving SDP");
        }
        return billboardSummary.getBackgroundPortrait().getUrl();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo2121() {
        this.f3260.setVisibility(8);
        this.f3250.setVisibility(8);
        this.f3266.setVisibility(8);
        this.f3255.setVisibility(8);
        this.f3253.setVisibility(8);
        this.f3259.setVisibility(8);
        this.f3265.setText(R.string.billboard_error_loading);
        this.f3256.setText(R.string.billboard_error_loading);
        ViewUtils.m3002(this.f3265, this.f3285);
        ViewUtils.m3002(this.f3256, !this.f3285);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo2123(AbstractC2077pz pzVar, AbstractC2087qh qhVar, int i, boolean z, boolean z2) {
        BillboardSummary billboardSummary;
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class);
        if (netflixActivity == null || pzVar == null || (billboardSummary = pzVar.getBillboardSummary()) == null) {
            mo2121();
            return;
        }
        C2059ph serviceManager = netflixActivity.getServiceManager();
        BillboardLogo logo = billboardSummary.getLogo();
        this.f3252 = new qN(qhVar, i);
        this.f3278 = pzVar;
        setVisibility(0);
        String title = pzVar.getTitle();
        setContentDescription(title);
        m2122(billboardSummary);
        this.f3284 = billboardSummary.getActionToken();
        this.f3282 = billboardSummary.getImpressionToken();
        this.f3263 = billboardSummary.getBackground() == null ? null : billboardSummary.getBackground().getUrl();
        String synopsis = billboardSummary.getSynopsis();
        this.f3280 = m2128(billboardSummary);
        m2091(billboardSummary);
        m2112(billboardSummary);
        if (!(!this.f3269 || billboardSummary.getVideoAssets() == null || billboardSummary.getVideoAssets().horizontalBackground() == null)) {
            m2097(billboardSummary.getVideoAssets().horizontalBackground().motionUrl(), billboardSummary.getVideoAssets().horizontalBackground().motionShouldLoop());
        }
        this.f3254.m16462(this.f3272, pzVar);
        this.f3265.setOnClickListener(m2116());
        if (this.f3285) {
            if (!C1349Bv.m4113(this.f3280)) {
                this.f3265.setText(this.f3280);
                this.f3265.setVisibility(0);
            } else {
                this.f3265.setVisibility(8);
            }
            this.f3272.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.billboard_info_phone_height));
        } else {
            this.f3265.setVisibility(8);
            this.f3272.setPadding(0, 0, 0, 0);
            m2095(billboardSummary.getBackground());
            if (logo != null) {
                m2103(billboardSummary);
                NetflixActivity.getImageLoader(getContext()).mo3063(this.f3259, logo.getUrl(), AssetType.boxArt, title, StaticImgConfig.DARK_NO_PLACEHOLDER, true, 1);
            }
            if (this.f3278.isOriginal()) {
                this.f3255.getLayoutParams().width = this.f3276 / 3;
            }
            this.f3279.setText(this.f3280);
            this.f3256.setText(synopsis);
            m2092(pzVar);
        }
        NetflixActivity.getImageLoader(getContext()).mo3063(this.f3272, mo2124(pzVar), AssetType.merchStill, title, StaticImgConfig.DARK, true, 1);
        m2118(BillboardInteractionType.IMPRESSION);
        if (serviceManager.mo9519()) {
            C1283.m16846("BillboardView", "Logging billboard impression for video: " + pzVar.getId());
            serviceManager.m9764().mo9466(pzVar, BillboardInteractionType.IMPRESSION, this.f3286);
        }
        mo2125();
        m2119(billboardSummary);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2118(BillboardInteractionType billboardInteractionType) {
        if (this.f3286 == null) {
            return;
        }
        if (billboardInteractionType == BillboardInteractionType.ACTION) {
            this.f3286.put("token", this.f3284);
        } else {
            this.f3286.put("token", this.f3282);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2122(BillboardSummary billboardSummary) {
        this.f3286 = new HashMap();
        this.f3286.put("awardCampaign", billboardSummary.getAwardTrackId());
        this.f3286.put("billboardTheme", billboardSummary.getBillboardTheme());
        this.f3286.put("billboardType", billboardSummary.getBillboardType());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2119(BillboardSummary billboardSummary) {
        if (BackgroundArtworkType.m2136(billboardSummary) && !BillboardType.m2139(billboardSummary)) {
            this.f3268.setPadding(0, 0, 0, 0);
            this.f3262.setVisibility(8);
            this.f3264.setVisibility(8);
            if (this.f3261 && !AD.m3306(getContext())) {
                ((ViewGroup.MarginLayoutParams) this.f3258.getLayoutParams()).setMarginStart(Math.round(2.0f * getContext().getResources().getDimension(R.dimen.billboard_info_view_group_margin_left)));
            }
        }
        if (!this.f3285) {
            this.f3272.setCutomCroppingEnabled(true);
            this.f3272.setCenterHorizontally(true);
        }
        if (BillboardType.m2138(billboardSummary)) {
            int i = getResources().getDisplayMetrics().widthPixels / 2;
            if (getContext().getResources().getDimension(R.dimen.billboard_info_width) > ((float) i) && !this.f3285) {
                this.f3253.getLayoutParams().width = i;
            }
            this.f3256.setVisibility(8);
        } else if (this.f3261) {
            this.f3256.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public String m2128(BillboardSummary billboardSummary) {
        this.f3280 = billboardSummary.getSupplementalMessage();
        String string = getResources().getString(R.string.billboard_watch_now);
        if (BillboardType.m2139(billboardSummary) && !this.f3285) {
            this.f3280 = !TextUtils.isEmpty(billboardSummary.getTitle()) ? getResources().getString(R.string.label_episodeTitleBasicQuoted, billboardSummary.getTitle()) : this.f3280;
        }
        LoMoUtils.m2146(billboardSummary.getBadgeKeys(), this.f3275);
        if (BillboardType.m2140(billboardSummary) && this.f3285) {
            this.f3280 = string;
        }
        if (!TextUtils.isEmpty(this.f3280) && this.f3279 != null) {
            this.f3279.setTypeface(this.f3279.getTypeface(), 1);
        } else if (this.f3285) {
            this.f3280 = string;
        }
        return this.f3280;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2092(AbstractC2077pz pzVar) {
        List<BillboardCTA> list;
        if (!((NetflixActivity) getContext()).getServiceManager().mo9519()) {
            C1283.m16865("BillboardView", "Manager is null/notReady - can't reload data");
            return;
        }
        if (pzVar == null || pzVar.getBillboardSummary() == null || pzVar.getBillboardSummary().getActions() == null) {
            list = new ArrayList<>();
        } else {
            list = pzVar.getBillboardSummary().getActions();
        }
        this.f3283.setVisibility(8);
        if (list.size() >= 2) {
            m2126(list.get(1), this.f3250);
            this.f3266.setVisibility(8);
        } else {
            m2109(this.f3278.getId(), this.f3278.getType());
            m2131();
            this.f3250.setVisibility(8);
        }
        if (list.size() >= 1) {
            m2126(list.get(0), this.f3260);
        } else {
            this.f3260.setVisibility(8);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m2109(String str, VideoType videoType) {
        this.f3266.setVisibility(0);
        C2059ph serviceManager = ((NetflixActivity) getContext()).getServiceManager();
        if (this.f3277 != null) {
            serviceManager.m9781(str, this.f3277);
            this.f3277 = null;
        }
        if (this.f3266 != null) {
            this.f3277 = serviceManager.m9792((NetflixActivity) getContext(), this.f3266, str, videoType, m2113(), false);
            serviceManager.m9802(str, this.f3277);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m2131() {
        C2059ph serviceManager = ((NetflixActivity) getContext()).getServiceManager();
        switch (this.f3278.getType()) {
            case MOVIE:
                serviceManager.m9764().mo9513(this.f3278.getId(), (String) null, this.f3274);
                return;
            case SHOW:
                serviceManager.m9764().mo9503(this.f3278.getId(), (String) null, this.f3274);
                return;
            default:
                C1283.m16850("BillboardView", "unable to handle or update the my list button as the videotype is not handled.");
                if (this.f3266 != null && this.f3266.getVisibility() == 0) {
                    this.f3266.setVisibility(8);
                    return;
                }
                return;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m2113() {
        int trackId = this.f3252.getTrackId();
        C1283.m16854("BillboardView", "TrackId found in PlayContextImpl");
        return trackId;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m2105() {
        this.f3283.setVisibility(0);
        this.f3283.setOnClickListener(m2116());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public View.OnClickListener m2116() {
        final C2059ph serviceManager = ((NetflixActivity) getContext()).getServiceManager();
        return new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.lomo.BillboardView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BillboardView.this.m2118(BillboardInteractionType.ACTION);
                if (serviceManager.mo9519()) {
                    serviceManager.m9764().mo9466(BillboardView.this.f3278, BillboardInteractionType.ACTION, BillboardView.this.f3286);
                }
                qU.m9969((NetflixActivity) BillboardView.this.getContext(), BillboardView.this.f3278, BillboardView.this.f3278.getTopLevelId(), BillboardView.this.f3278.getParentTitle(), BillboardView.this.f3252, "BbView");
            }
        };
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2096(BillboardCTA billboardCTA) {
        m2105();
        this.f3283.setText(C2223uw.m11781(getContext(), billboardCTA.getName(), billboardCTA.getSequenceNumber()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2126(BillboardCTA billboardCTA, Button button) {
        String type = billboardCTA.getType();
        char c = 65535;
        switch (type.hashCode()) {
            case 107961:
                if (type.equals("mdp")) {
                    c = 0;
                    break;
                }
                break;
            case 3443508:
                if (type.equals("play")) {
                    c = 3;
                    break;
                }
                break;
            case 1557721666:
                if (type.equals("details")) {
                    c = 2;
                    break;
                }
                break;
            case 1879443694:
                if (type.equals("addToPlaylist")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                button.setVisibility(8);
                m2105();
                return;
            case 1:
                button.setVisibility(8);
                m2109(this.f3278.getId(), this.f3278.getType());
                return;
            case 2:
                button.setVisibility(8);
                m2096(billboardCTA);
                return;
            case 3:
                button.setVisibility(0);
                button.setText(C2223uw.m11781(getContext(), billboardCTA.getName(), billboardCTA.getSequenceNumber()));
                String bookmarkPosition = billboardCTA.ignoreBookmark() ? "0" : billboardCTA.getBookmarkPosition();
                C2059ph serviceManager = ((NetflixActivity) getContext()).getServiceManager();
                if (TextUtils.equals(this.f3278.getId(), billboardCTA.getVideoId())) {
                    m2127(this.f3278, this.f3278.getType(), button, bookmarkPosition);
                    return;
                } else {
                    C2223uw.m11782(serviceManager, this.f3278, billboardCTA, new Cif(button, bookmarkPosition, billboardCTA.getName().toLowerCase().contains("continue")));
                    return;
                }
            default:
                button.setVisibility(8);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public class If extends oP {
        public If() {
            super("BillboardView");
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            super.onMovieDetailsFetched(pPVar, status);
            m2143(pPVar);
        }

        @Override // o.oP, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            super.onShowDetailsFetched(pRVar, status);
            m2143(pRVar);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m2143(pT pTVar) {
            NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(BillboardView.this.getContext(), NetflixActivity.class);
            if (pTVar != null && !C1317As.m3750(netflixActivity)) {
                netflixActivity.getServiceManager().m9818(pTVar.getId(), pTVar.isInQueue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.lomo.BillboardView$if  reason: invalid class name */
    public class Cif extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Button f3310;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f3312;

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean f3313 = false;

        public Cif(Button button, String str) {
            super("BillboardView");
            this.f3312 = str;
            this.f3310 = button;
        }

        public Cif(Button button, String str, boolean z) {
            super("BillboardView");
            this.f3313 = z;
            this.f3312 = str;
            this.f3310 = button;
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            super.onMovieDetailsFetched(pPVar, status);
            if (pPVar != null) {
                BillboardView.this.m2130(pPVar, this.f3310, this.f3312);
            }
        }

        @Override // o.oP, o.oU
        public void onEpisodeDetailsFetched(pI pIVar, Status status) {
            super.onEpisodeDetailsFetched(pIVar, status);
            if (pIVar != null) {
                BillboardView.this.m2130(pIVar, this.f3310, this.f3312);
            }
        }

        @Override // o.oP, o.oU
        public void onEpisodesFetched(List<pI> list, Status status) {
            super.onEpisodesFetched(list, status);
            if (!list.isEmpty()) {
                BillboardView.this.m2127(list.get(0).getPlayable(), list.get(0).getType(), this.f3310, this.f3312);
            }
        }

        @Override // o.oP, o.oU
        public void onShowDetailsFetched(pR pRVar, Status status) {
            super.onShowDetailsFetched(pRVar, status);
            if (pRVar == null) {
                return;
            }
            if (this.f3313) {
                ((NetflixActivity) BillboardView.this.getContext()).getServiceManager().m9764().mo9484(pRVar.getCurrentEpisodeId(), null, new Cif(this.f3310, this.f3312));
            } else {
                BillboardView.this.m2130(pRVar, this.f3310, this.f3312);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2130(pT pTVar, Button button, String str) {
        m2127(pTVar.getPlayable(), pTVar.getType(), button, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2127(final pF pFVar, final VideoType videoType, Button button, final String str) {
        final C2059ph serviceManager = ((NetflixActivity) getContext()).getServiceManager();
        button.requestFocus();
        button.setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.lomo.BillboardView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BillboardView.this.m2118(BillboardInteractionType.ACTION);
                if (serviceManager.mo9519()) {
                    serviceManager.m9764().mo9466(BillboardView.this.f3278, BillboardInteractionType.ACTION, BillboardView.this.f3286);
                }
                PlaybackLauncher.m1605((NetflixActivity) BillboardView.this.getContext(), pFVar, videoType, BillboardView.this.f3252, TextUtils.isEmpty(str) ? -1 : Integer.parseInt(str));
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m2103(BillboardSummary billboardSummary) {
        if (billboardSummary.getLogo() != null) {
            int intValue = billboardSummary.getLogo().getWidth().intValue();
            int intValue2 = billboardSummary.getLogo().getHeight().intValue();
            int r5 = m2100((NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class)) / 2;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.billboard_tv_card_regular_width);
            int i = this.f3276;
            if (billboardSummary.isOriginal()) {
                dimensionPixelSize = Math.min(i / 3, getResources().getDimensionPixelSize(R.dimen.billboard_info_width));
            }
            int i2 = (intValue2 * dimensionPixelSize) / intValue;
            if (i2 > r5) {
                dimensionPixelSize = (dimensionPixelSize * r5) / i2;
            }
            ViewGroup.LayoutParams layoutParams = this.f3259.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            this.f3259.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m2091(BillboardSummary billboardSummary) {
        BillboardDateBadge dateBadge = billboardSummary != null ? billboardSummary.getDateBadge() : null;
        String url = dateBadge != null ? dateBadge.getUrl() : "";
        if (!BillboardType.m2140(billboardSummary) || url.isEmpty()) {
            this.f3257.setVisibility(8);
            if (!TextUtils.isEmpty(this.f3280)) {
                this.f3279.setText(this.f3280);
                this.f3255.setVisibility(0);
                return;
            }
            this.f3279.setVisibility(8);
            return;
        }
        NetflixActivity.getImageLoader(getContext()).mo3063(this.f3257, url, AssetType.merchStill, this.f3280, StaticImgConfig.DARK, true, 1);
        this.f3257.setVisibility(0);
        this.f3255.setVisibility(8);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m2112(BillboardSummary billboardSummary) {
        BillboardAwardsHeadline awardsHeadline = billboardSummary != null ? billboardSummary.getAwardsHeadline() : null;
        String url = awardsHeadline != null ? awardsHeadline.getUrl() : "";
        if (url.isEmpty() || !this.f3261) {
            this.f3253.setVisibility(8);
            return;
        }
        NetflixActivity.getImageLoader(getContext()).mo3063(this.f3253, url, AssetType.merchStill, this.f3280, StaticImgConfig.DARK, true, 1);
        this.f3253.setVisibility(0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2095(BillboardBackground billboardBackground) {
        if (billboardBackground != null) {
            this.f3263 = billboardBackground.getUrl();
            if (Tone.LIGHT.equals(billboardBackground.getTone())) {
                this.f3256.setTextColor(getResources().getColor(R.color.billboard_text_synopsis_light_color));
                this.f3279.setTextColor(getResources().getColor(R.color.black));
                this.f3279.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                this.f3256.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                return;
            }
            this.f3256.setTextColor(getResources().getColor(R.color.billboard_text_synopsis_dark_color));
            this.f3256.setShadowLayer(2.0f, 0.0f, -1.0f, getResources().getColor(R.color.translucent_black));
            this.f3279.setTextColor(getResources().getColor(R.color.white));
            this.f3279.setShadowLayer(2.0f, 0.0f, -1.0f, getResources().getColor(R.color.translucent_black));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m2097(String str, boolean z) {
        if (!this.f3261 || TextUtils.isEmpty(str) || (this.f3271 != null && this.f3271.m9917())) {
            m2098();
            return;
        }
        this.f3272.setVisibility(0);
        if (this.f3271 == null) {
            this.f3271 = new uG(this.f3267, z, 3, 0.0f, AssetType.motionBillboard, new qJ.iF() { // from class: com.netflix.mediaclient.ui.lomo.BillboardView.2
                @Override // o.qJ.iF
                /* renamed from: ˊ  reason: contains not printable characters */
                public void mo2132() {
                }

                @Override // o.qJ.iF
                /* renamed from: ˏ  reason: contains not printable characters */
                public void mo2134() {
                    BillboardView.this.m2098();
                }

                @Override // o.qJ.iF
                /* renamed from: ˎ  reason: contains not printable characters */
                public void mo2133() {
                }

                @Override // o.qJ.iF
                /* renamed from: ˏ  reason: contains not printable characters */
                public void mo2135(int i, int i2) {
                }
            });
            m2102(Uri.parse(str).buildUpon().clearQuery().build().toString());
            return;
        }
        m2106();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m2102(String str) {
        ((NetflixActivity) getContext()).getServiceManager().m9770(str, AssetType.motionBillboard, new AbstractC2061pj() { // from class: com.netflix.mediaclient.ui.lomo.BillboardView.1
            @Override // o.AbstractC2061pj, o.oU
            public void onResourceCached(String str2, String str3, long j, long j2, Status status) {
                super.onResourceCached(str2, str3, j, j2, status);
                if (!status.mo301() && BillboardView.this.f3271 != null && !TextUtils.isEmpty(str3)) {
                    BillboardView.this.f3271.m9915(str3, j, j2);
                    BillboardView.this.m2106();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private void m2106() {
        C1283.m16846("BillboardView", "Showing motion BB");
        this.f3272.setVisibility(8);
        this.f3267.setVisibility(0);
        this.f3270.setVisibility(0);
        m2110();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m2098() {
        C1283.m16846("BillboardView", "Hiding motion BB");
        this.f3272.setVisibility(0);
        this.f3267.setVisibility(8);
        this.f3270.setOnClickListener(null);
        this.f3270.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m2110() {
        if (this.f3271 != null) {
            this.f3270.setText(getResources().getString(this.f3271.m9916() ? R.string.icon_font_muted : R.string.icon_font_not_muted));
            this.f3270.setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.lomo.BillboardView.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BillboardView.this.f3271 != null) {
                        BillboardView.this.f3271.m9912();
                    }
                    BillboardView.this.m2110();
                }
            });
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (z && this.f3278 != null) {
            C1283.m16846("BillboardView", "Playback ready, updating myList state");
            m2131();
        }
        if (this.f3271 == null || !this.f3269) {
            C1283.m16846("BillboardView", "null mediaPlayerWrapper - bailing");
        } else if (!z) {
            C1283.m16846("BillboardView", "Losing window focus - pausing playback");
            this.f3271.m9909();
        } else if (this.f3271.m9917()) {
            C1283.m16846("BillboardView", "Received focus but media playback complete - skipping resume");
            m2098();
        } else if (!this.f3271.m9911()) {
            C1283.m16846("BillboardView", "Playback not ready yet, but showing motion BB");
            m2106();
        }
    }
}

package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.VideoDetailsViewGroup;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.util.ViewUtils;
@SuppressLint({"ViewConstructor"})
/* renamed from: o.tk  reason: case insensitive filesystem */
public class C2181tk extends VideoDetailsViewGroup {

    /* renamed from: ˋ  reason: contains not printable characters */
    protected TextView f10561;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    protected C0522 f10562;

    /* renamed from: ˌ  reason: contains not printable characters */
    protected C0522 f10563;

    /* renamed from: ˍ  reason: contains not printable characters */
    private C0522 f10564;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private C0792 f10565;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private RadioButton f10566;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private C0628 f10567;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private ImageView f10568;

    /* renamed from: ˑ  reason: contains not printable characters */
    private RadioButton f10569;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private DownloadButton f10570;

    /* renamed from: ـ  reason: contains not printable characters */
    private TextView f10571;

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private View f10572;

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private int f10573;

    /* renamed from: ॱʽ  reason: contains not printable characters */
    private View f10574;

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private View f10575;

    public C2181tk(Context context, int i) {
        super(context);
        this.f10573 = i;
        m11185();
        m11187();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˏ */
    public void mo1692() {
        super.mo1692();
        this.f10566 = (RadioButton) findViewById(R.id.video_data_selector_episodes);
        this.f10569 = (RadioButton) findViewById(R.id.video_data_selector_related);
        this.f10575 = findViewById(R.id.video_data_selector_episodes_top);
        this.f10563 = (C0522) findViewById(R.id.kids_hero_row_title_image);
        this.f10571 = (TextView) findViewById(R.id.kids_basic_info_certification);
        this.f10561 = (TextView) findViewById(R.id.kids_basic_supplemental_info);
        this.f10574 = findViewById(R.id.video_data_selector_related_top);
        this.f10562 = (C0522) findViewById(R.id.video_img_2);
        this.f10567 = (C0628) findViewById(R.id.video_details_add_to_queue);
        this.f10570 = (DownloadButton) findViewById(R.id.video_details_download_button);
        this.f10572 = findViewById(R.id.video_actions);
        this.f10564 = (C0522) findViewById(R.id.kids_character_view);
        this.f10568 = (ImageView) findViewById(R.id.kids_play_button);
        this.f10565 = (C0792) findViewById(R.id.pressable_view_group);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ॱ */
    public int mo1697() {
        return R.layout.kids_character_video_details_view_group;
    }

    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˋ */
    public void mo1685(pT pTVar, VideoDetailsViewGroup.AbstractC0033 r5) {
        super.mo1685(pTVar, r5);
        mo1684(pTVar);
        m11188(pTVar);
        m11193();
        m11194();
        m11186(pTVar);
        pF playable = pTVar.getPlayable();
        if (playable != null) {
            this.f10561.setText(playable.getPlayableTitle());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ᐝ */
    public void mo1701() {
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˊ */
    public void mo1679(pT pTVar, NetflixActivity netflixActivity) {
    }

    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ͺ */
    public TextView mo1696() {
        return this.f10567;
    }

    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˋॱ */
    public DownloadButton mo1686() {
        return this.f10570;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˎ */
    public void mo1690(pT pTVar, VideoDetailsViewGroup.AbstractC0033 r2) {
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˊ */
    public void mo1680(pT pTVar, NetflixActivity netflixActivity, String str) {
        if (netflixActivity != null && netflixActivity.getServiceManager() != null && pTVar != null) {
            String storyUrl = pTVar.getStoryUrl();
            NetflixActivity.getImageLoader(netflixActivity).mo3064(this.f2919, storyUrl, AssetType.boxArt, str, BrowseExperience.m1769(), true, 1, Bitmap.Config.ARGB_8888);
            this.f2919.setTag(storyUrl);
            mo1679(pTVar, netflixActivity);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˋ */
    public void mo1684(pT pTVar) {
        if (pTVar != null && this.f2938 != null) {
            String titleImgUrl = pTVar.getTitleImgUrl();
            if (C1349Bv.m4113(titleImgUrl) || !C1317As.m3749()) {
                this.f2938.setText(pTVar.getTitle());
                this.f2938.setVisibility(0);
                this.f10563.setVisibility(4);
                return;
            }
            this.f2938.setVisibility(8);
            this.f10563.setVisibility(0);
            NetflixActivity.getImageLoader(getContext()).mo3064(this.f10563, titleImgUrl, AssetType.heroImage, pTVar.getTitle(), StaticImgConfig.DARK_NO_PLACEHOLDER, true, 1, Bitmap.Config.RGB_565);
            if (!AD.m3299()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10563.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, 0);
                this.f10563.setLayoutParams(layoutParams);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ʼ */
    public int mo1674() {
        return (int) (((float) AD.m3317(getContext())) * 0.5625f);
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m11185() {
        int i;
        int r4 = AD.m3317(getContext());
        this.f10565.setOnClickListener(this.f2908);
        m1673().setBackground(m11183());
        m1673().getLayoutParams().width = r4;
        if (AD.m3307(getContext())) {
            i = (int) (((double) AD.m3280(getContext())) * 0.7d);
        } else {
            i = (int) (((float) r4) * 0.5625f);
        }
        m1673().getLayoutParams().height = i;
        m1676().getLayoutParams().width = (int) (((float) i) * 1.778f * 0.6f);
        m1676().getLayoutParams().height = (int) (((float) i) * 0.6f);
        this.f10561.getLayoutParams().width = (int) (((float) r4) * 0.36f);
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m11187() {
        int i;
        if (this.f10568 != null) {
            switch (this.f10573) {
                case R.color.kids_blue /* 2131099835 */:
                    i = R.drawable.btn_play_blue_normal;
                    break;
                case R.color.kids_green /* 2131099839 */:
                    i = R.drawable.btn_play_green_normal;
                    break;
                case R.color.kids_orange /* 2131099843 */:
                    i = R.drawable.btn_play_orange_normal;
                    break;
                case R.color.kids_purple /* 2131099845 */:
                    i = R.drawable.btn_play_purple_normal;
                    break;
                case R.color.kids_yellow /* 2131099851 */:
                    i = R.drawable.btn_play_yellow_normal;
                    break;
                default:
                    i = R.drawable.btn_play_default_normal;
                    break;
            }
            this.f10568.setImageResource(i);
        }
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private Drawable m11183() {
        switch (this.f10573) {
            case R.color.kids_blue /* 2131099835 */:
                return getResources().getDrawable(R.drawable.bg_cdp_blue);
            case R.color.kids_green /* 2131099839 */:
                return getResources().getDrawable(R.drawable.bg_cdp_green);
            case R.color.kids_orange /* 2131099843 */:
                return getResources().getDrawable(R.drawable.bg_cdp_orange);
            case R.color.kids_purple /* 2131099845 */:
                return getResources().getDrawable(R.drawable.bg_cdp_purple);
            case R.color.kids_yellow /* 2131099851 */:
                return getResources().getDrawable(R.drawable.bg_cdp_yellow);
            default:
                return getResources().getDrawable(R.drawable.bg_cdp_blue);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11191(pL pLVar) {
        m11190(pLVar);
        m11192(pLVar);
        m11184(pLVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11192(pL pLVar) {
        if (this.f10564 != null) {
            this.f10564.setPassActualScaleTypeToParent(true);
            this.f10564.setScaleType(ImageView.ScaleType.FIT_CENTER);
            NetflixActivity.getImageLoader(getContext()).mo3057(this.f10564, pLVar.mo4183(), AssetType.boxArt, String.format(getResources().getString(R.string.accesibility_play_video), pLVar.getTitle()), BrowseExperience.m1769(), true);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11190(pL pLVar) {
        if (pLVar != null) {
            String r8 = pLVar.mo4182();
            NetflixActivity.getImageLoader(getContext()).mo3057(this.f2919, r8, AssetType.boxArt, String.format(getResources().getString(R.string.accesibility_play_video), pLVar.getTitle()), BrowseExperience.m1769(), true);
            this.f2919.setTag(r8);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11184(pL pLVar) {
        if (pLVar != null && this.f2938 != null && ViewUtils.m3023((View) this.f2938)) {
            this.f2938.setText(pLVar.mo4179());
            this.f10563.setVisibility(8);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m11186(pT pTVar) {
        if (this.f2907 != null) {
            String supplementalMessage = pTVar.getSupplementalMessage();
            this.f2907.setText(supplementalMessage);
            ViewUtils.m3002(this.f2907, !TextUtils.isEmpty(supplementalMessage));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public void m11194() {
        if (this.f10572 != null) {
            ((RelativeLayout.LayoutParams) this.f10572.getLayoutParams()).addRule(21);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public void m11188(pT pTVar) {
        if (pTVar != null) {
            m11182(pTVar);
            m11181(pTVar);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m11182(pT pTVar) {
        if (this.f10571 != null) {
            String certification = pTVar.getCertification();
            this.f10571.setText(certification);
            this.f10571.setVisibility(C1349Bv.m4113(certification) ? 8 : 0);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m11181(pT pTVar) {
        if (this.f10561 != null) {
            if (pTVar.getType() == VideoType.SHOW && (pTVar instanceof pR)) {
                pR pRVar = (pR) pTVar;
                if (pRVar.getSeasonCount() > 0) {
                    this.f10561.setText(pRVar.getNumSeasonsLabel());
                    this.f10561.setVisibility(0);
                    return;
                }
                this.f10561.setVisibility(8);
            } else if (pTVar instanceof CH) {
                int runtime = ((CH) pTVar).getRuntime();
                if (runtime > 0) {
                    this.f10561.setText(BD.m3838(runtime, getContext()));
                    this.f10561.setVisibility(0);
                    return;
                }
                this.f10561.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    public void m11193() {
        if (this.f10566 != null) {
            this.f10566.setTextColor(getResources().getColor(R.color.white));
            this.f10575.setVisibility(0);
            this.f10566.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (this.f10569 != null) {
            this.f10569.setTextColor(getResources().getColor(R.color.kids_text_color_light));
            this.f10574.setVisibility(4);
            this.f10569.setTypeface(Typeface.DEFAULT);
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public C0522 m11189() {
        return this.f10562;
    }
}

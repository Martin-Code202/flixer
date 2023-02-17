package o;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.details.VideoDetailsViewGroup;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.Locale;
public class rA extends VideoDetailsViewGroup {

    /* renamed from: ˋ  reason: contains not printable characters */
    private RadioGroup f9623;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private View f9624;

    /* renamed from: ˌ  reason: contains not printable characters */
    private RadioButton f9625;

    /* renamed from: ˍ  reason: contains not printable characters */
    private RadioButton f9626;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private View f9627;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private TextView f9628;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private TextView f9629;

    /* renamed from: ˑ  reason: contains not printable characters */
    private TextView f9630;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private View f9631;

    public rA(Context context) {
        super(context);
    }

    public rA(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public rA(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ॱ */
    public int mo1697() {
        return R.layout.video_details_view_group_ab9204;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˏ */
    public void mo1692() {
        this.f2920 = (ViewStub) findViewById(R.id.my_list_mdp);
        this.f2921 = (ViewStub) findViewById(R.id.my_list_sdp);
        this.f2934 = (LinearLayout) findViewById(R.id.video_actions);
        this.f2915 = (TextView) findViewById(R.id.video_details_match_percentage);
        this.f9630 = (TextView) findViewById(R.id.video_details_basic_info_year);
        this.f9628 = (TextView) findViewById(R.id.video_details_basic_info_maturity);
        this.f9629 = (TextView) findViewById(R.id.video_details_basic_info_num_seasons);
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
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m10131() {
        if (this.f2922 != null) {
            this.f9623 = (RadioGroup) findViewById(R.id.video_data_selector);
            if (this.f2922.getType() != VideoType.MOVIE) {
                this.f9626 = (RadioButton) findViewById(R.id.video_data_selector_episodes);
                this.f9627 = findViewById(R.id.video_data_selector_episodes_top);
                if (C1353Bz.m4153(this.f2922)) {
                    this.f9624 = findViewById(R.id.video_data_selector_trailers_top);
                    this.f9625 = (RadioButton) findViewById(R.id.video_data_selector_trailers);
                } else {
                    this.f9624 = findViewById(R.id.video_data_selector_related_top);
                    this.f9625 = (RadioButton) findViewById(R.id.video_data_selector_related);
                }
                ViewUtils.m3002((View) this.f9626.getParent(), true);
                ViewUtils.m3002((View) this.f9625.getParent(), true);
                m10129();
            } else if (C1353Bz.m4153(this.f2922)) {
                this.f9626 = (RadioButton) findViewById(R.id.video_data_selector_related);
                this.f9627 = findViewById(R.id.video_data_selector_related_top);
                this.f9624 = findViewById(R.id.video_data_selector_trailers_top);
                this.f9625 = (RadioButton) findViewById(R.id.video_data_selector_trailers);
                ViewUtils.m3002((View) this.f9626.getParent(), true);
                ViewUtils.m3002((View) this.f9625.getParent(), true);
                m10129();
            } else {
                this.f9626 = (RadioButton) findViewById(R.id.video_data_selector_related);
                this.f9627 = findViewById(R.id.video_data_selector_related_top);
                ViewUtils.m3002((View) this.f9626.getParent(), true);
            }
            ViewUtils.m3002(this.f9627, true);
        }
    }

    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˋ */
    public void mo1685(final pT pTVar, VideoDetailsViewGroup.AbstractC0033 r4) {
        super.mo1685(pTVar, r4);
        m10131();
        if (this.f9631 != null) {
            this.f9631.setOnClickListener(new View.OnClickListener() { // from class: o.rA.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AJ.m3357(rA.this.getContext(), pTVar.getId(), pTVar.getTitle());
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˎ */
    public void mo1687() {
        int i;
        if (this.f2934 == null) {
            return;
        }
        if (this.f2934.getChildCount() != 4) {
            throw new IllegalStateException("Only 4 buttons expected in the video actions");
        }
        char c = m1694(this.f2922) ? (char) 4 : 3;
        if (!AD.m3307(getContext())) {
            i = Math.max(getMeasuredWidth() / 4, getResources().getDimensionPixelSize(R.dimen.video_actions_button_min_width));
        } else {
            i = Math.max(Math.min(getMeasuredWidth() / 4, getResources().getDimensionPixelSize(R.dimen.video_actions_button_max_width)), getResources().getDimensionPixelSize(R.dimen.video_actions_button_min_width));
        }
        for (int i2 = 0; i2 < this.f2934.getChildCount(); i2++) {
            this.f2934.getChildAt(i2).setVisibility(8);
        }
        if (c == 4) {
            m1666(this.f2929, i);
        }
        m1666(this.f2914, i);
        m1666(this.f2940, i);
        m10130(this.f9631, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m10130(View view, int i) {
        if (view != null) {
            view.setLayoutParams(new LinearLayout.LayoutParams(i, -1));
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˎ */
    public void mo1691(boolean z) {
        View view;
        if (!this.f2917) {
            if (this.f2920 == null || this.f2921 == null) {
                view = this;
            } else {
                view = (z ? this.f2920 : this.f2921).inflate();
            }
            this.f2940 = view.findViewById(R.id.video_details_add_to_queue_group);
            this.f2916 = (TextView) view.findViewById(R.id.video_details_add_to_queue);
            this.f2927 = (TextView) view.findViewById(R.id.video_details_add_to_queue_label);
            this.f2929 = (DownloadButton) view.findViewById(R.id.video_details_download_button);
            this.f2914 = (C1177) view.findViewById(R.id.user_rating);
            this.f9631 = view.findViewById(R.id.video_details_share_group);
            BX.m3950(this.f2914);
            this.f2917 = true;
            this.f2914.setDark(!BrowseExperience.m1780());
            mo1687();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.details.VideoDetailsViewGroup
    /* renamed from: ˎ */
    public void mo1690(pT pTVar, VideoDetailsViewGroup.AbstractC0033 r8) {
        if (pTVar != null && pTVar.isAvailableToStream()) {
            if (this.f9630 != null) {
                this.f9630.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(pTVar.getYear())));
            }
            if (this.f9628 != null) {
                this.f9628.setText(pTVar.getCertification());
            }
            if (this.f9629 != null && (pTVar instanceof pR)) {
                this.f9629.setText(((pR) pTVar).getNumSeasonsLabel());
            }
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m10129() {
        AnonymousClass3 r1 = new View.OnClickListener() { // from class: o.rA.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Fragment fragment;
                if (rA.this.f2918 != null) {
                    fragment = rA.this.f2922.getType() == VideoType.MOVIE ? rA.this.f2918.m10052() : rA.this.f2918.m10064();
                } else {
                    AbstractActivityC0360 r3 = (AbstractActivityC0360) C1322Av.m3791(rA.this.getContext(), AbstractActivityC0360.class);
                    if (r3 != null) {
                        fragment = rA.this.f2922.getType() == VideoType.MOVIE ? r3.mo10792() : r3.m14001();
                    } else {
                        return;
                    }
                }
                if (fragment instanceof qV) {
                    switch (view.getId()) {
                        case R.id.video_data_selector_episodes /* 2131428701 */:
                            ((qV) fragment).R_();
                            rA.this.m10132();
                            return;
                        case R.id.video_data_selector_episodes_top /* 2131428702 */:
                        case R.id.video_data_selector_related_top /* 2131428704 */:
                        default:
                            return;
                        case R.id.video_data_selector_related /* 2131428703 */:
                            ((qV) fragment).Q_();
                            if (rA.this.f2922.getType() == VideoType.MOVIE) {
                                rA.this.m10132();
                                return;
                            } else {
                                rA.this.m10133();
                                return;
                            }
                        case R.id.video_data_selector_trailers /* 2131428705 */:
                            ((qV) fragment).U_();
                            rA.this.m10133();
                            return;
                    }
                }
            }
        };
        if (this.f9626 != null) {
            this.f9626.setOnClickListener(r1);
        }
        if (this.f9625 != null) {
            this.f9625.setOnClickListener(r1);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void m10133() {
        if (!(this.f9625 == null || this.f9624 == null)) {
            this.f9625.setTextColor(BrowseExperience.m1767((Activity) C1322Av.m3791(getContext(), Activity.class), (int) R.attr.dpTabActiveTextColor));
            this.f9624.setVisibility(0);
            this.f9625.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (this.f9626 != null && this.f9627 != null) {
            this.f9626.setTextColor(BrowseExperience.m1767((Activity) C1322Av.m3791(getContext(), Activity.class), (int) R.attr.dpTabInactiveTextColor));
            this.f9627.setVisibility(4);
            this.f9626.setTypeface(Typeface.DEFAULT);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public void m10132() {
        if (!(this.f9626 == null || this.f9627 == null)) {
            this.f9626.setTextColor(BrowseExperience.m1767((Activity) C1322Av.m3791(getContext(), Activity.class), (int) R.attr.dpTabActiveTextColor));
            this.f9627.setVisibility(0);
            this.f9626.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (this.f9625 != null && this.f9624 != null) {
            this.f9625.setTextColor(BrowseExperience.m1767((Activity) C1322Av.m3791(getContext(), Activity.class), (int) R.attr.dpTabInactiveTextColor));
            this.f9624.setVisibility(4);
            this.f9625.setTypeface(Typeface.DEFAULT);
        }
    }
}

package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import o.uO;
public class uC extends RelativeLayout implements uO.Cif<AbstractC2074pw> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final View.OnClickListener f10679 = new View.OnClickListener() { // from class: o.uC.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (uC.this.f10680 != null) {
                PlaybackLauncher.m1607((NetflixActivity) C1317As.m3755(uC.this.getContext(), NetflixActivity.class), uC.this.f10680, uC.this.f10680.getType(), uC.this.f10681);
            } else {
                C1276.m16820().mo5725("CwView onClick(): video is null");
            }
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    private AbstractC2074pw f10680;

    /* renamed from: ʽ  reason: contains not printable characters */
    private oX f10681 = new oB("CwView");

    /* renamed from: ˊ  reason: contains not printable characters */
    protected C0522 f10682;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected View f10683;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected TextView f10684;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected TextView f10685;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected ProgressBar f10686;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private View$OnClickListenerC1193 f10687;

    public uC(Context context) {
        super(context);
        m11329();
    }

    public uC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11329();
    }

    public uC(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11329();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public int mo11334() {
        return R.layout.continue_watching_view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo11332() {
        this.f10685 = (TextView) findViewById(R.id.video_info);
        this.f10684 = (TextView) findViewById(R.id.cw_view_title);
        this.f10682 = (C0522) findViewById(R.id.cw_view_img);
        this.f10686 = (ProgressBar) findViewById(R.id.cw_view_video_progress);
        this.f10683 = findViewById(R.id.cw_view_info);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m11329() {
        setFocusable(true);
        setBackgroundResource(R.drawable.selectable_video_background);
        inflate(getContext(), mo11334(), this);
        mo11332();
        this.f10687 = new View$OnClickListenerC1193((NetflixActivity) C1322Av.m3791(getContext(), NetflixActivity.class), this);
        if (BrowseExperience.m1780()) {
            View findViewById = findViewById(R.id.cw_view_gradient_overlay);
            if (findViewById != null) {
                findViewById.setBackground(getResources().getDrawable(R.drawable.shadow_trans_to_blue));
            }
            if (this.f10685 != null) {
                this.f10685.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.kids_video_info_background));
                this.f10685.setTextColor(ContextCompat.getColor(getContext(), R.color.kids_video_info_text));
            }
            if (this.f10686 != null) {
                this.f10686.setProgressTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.brand_red)));
                this.f10686.setProgressBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.kids_progress_bar_background)));
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo11331(AbstractC2074pw pwVar) {
        if (pwVar == null) {
            return null;
        }
        return pwVar.getCleanBoxshotUrl();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo2123(AbstractC2074pw pwVar, AbstractC2087qh qhVar, int i, boolean z, boolean z2) {
        this.f10680 = pwVar;
        if (qhVar != null) {
            this.f10681 = new qN(qhVar, i);
        }
        setVisibility(0);
        String format = String.format(getResources().getString(R.string.accesibility_play_video), pwVar.getTitle());
        setContentDescription(format);
        if (this.f10684 != null) {
            setTitle(pwVar);
        }
        NetflixActivity.getImageLoader(getContext()).mo3063(this.f10682, mo11331(pwVar), AssetType.bif, format, BrowseExperience.m1769(), true, z ? 1 : 0);
        setOnClickListener(this.f10679);
        this.f10686.setProgress(m11326(pwVar.getRuntime(), pwVar.getPlayableBookmarkPosition()));
        if (this.f10683 != null) {
            this.f10683.setContentDescription(String.format(getResources().getString(R.string.accessibility_show_details_for), pwVar.getTitle()));
            this.f10687.m16462(this.f10683, pwVar);
        }
        if (this.f10685 != null) {
            m11327(pwVar, this.f10685);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m11327(AbstractC2074pw pwVar, TextView textView) {
        String str;
        if (VideoType.SHOW == pwVar.getType()) {
            str = pwVar.isEpisodeNumberHidden() ? "" : getContext().getString(R.string.label_season_and_episode_abbreviated, pwVar.getSeasonAbbrSeqLabel(), Integer.valueOf(pwVar.getEpisodeNumber()));
        } else {
            str = BD.m3838(pwVar.getRuntime(), getContext());
        }
        int r5 = C1349Bv.m4104(str, ' ', 2);
        if (r5 > -1) {
            String replace = str.replace(' ', (char) 160);
            str = replace.substring(0, r5) + (char) 8203 + replace.substring(r5 + 1);
        }
        textView.setText(str);
    }

    public void setInfoViewId(int i) {
        this.f10683.setId(i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m11326(int i, int i2) {
        if (i > 0) {
            return (i2 * 100) / i;
        }
        return 0;
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        return this.f10681;
    }

    public void setTitle(AbstractC2074pw pwVar) {
        if (!VideoType.SHOW.equals(pwVar.getType())) {
            this.f10684.setText(pwVar.getTitle());
        } else if (pwVar.isNSRE() || pwVar.isEpisodeNumberHidden()) {
            this.f10684.setText(getContext().getString(R.string.label_cwViewShowTitleEpisodeTitle, pwVar.getTitle(), pwVar.getCurrentEpisodeTitle()));
        } else {
            this.f10684.setText(getContext().getString(R.string.label_showTitleSeasonEpisode, pwVar.getTitle(), pwVar.getSeasonAbbrSeqLabel(), Integer.valueOf(pwVar.getEpisodeNumber())));
        }
    }
}

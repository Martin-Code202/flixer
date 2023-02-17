package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.lomo.LoMoUtils;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayAction;
import com.netflix.model.leafs.PostPlayItem;
import java.util.ArrayList;
import java.util.List;
public class wU extends LinearLayout {

    /* renamed from: ʻ  reason: contains not printable characters */
    private TextView f11523;

    /* renamed from: ʼ  reason: contains not printable characters */
    private TextView f11524;

    /* renamed from: ʽ  reason: contains not printable characters */
    private TextView f11525;

    /* renamed from: ˊ  reason: contains not printable characters */
    private TextView f11526;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private List<wL> f11527;

    /* renamed from: ˋ  reason: contains not printable characters */
    private TextView f11528;

    /* renamed from: ˎ  reason: contains not printable characters */
    private wI f11529;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0522 f11530;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private LinearLayout f11531;

    /* renamed from: ͺ  reason: contains not printable characters */
    private TextView f11532;

    /* renamed from: ॱ  reason: contains not printable characters */
    private LinearLayout f11533;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private LinearLayout f11534;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private TextView f11535;

    public wU(Context context) {
        this(context, null);
    }

    public wU(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public wU(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11527 = new ArrayList(3);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12352() {
        this.f11529 = (wI) findViewById(R.id.post_play_countdown);
        this.f11530 = (C0522) findViewById(R.id.post_play_item_logo);
        this.f11533 = (LinearLayout) findViewById(R.id.post_play_title_bar);
        this.f11526 = (TextView) findViewById(R.id.post_play_episode_badge);
        this.f11528 = (TextView) findViewById(R.id.post_play_title);
        this.f11534 = (LinearLayout) findViewById(R.id.post_play_metadata_bar);
        this.f11524 = (TextView) findViewById(R.id.video_details_match_percentage);
        this.f11535 = (TextView) findViewById(R.id.post_play_year);
        this.f11523 = (TextView) findViewById(R.id.post_play_maturity_rating);
        this.f11525 = (TextView) findViewById(R.id.post_play_content_length);
        this.f11532 = (TextView) findViewById(R.id.post_play_synopsis);
        this.f11531 = (LinearLayout) findViewById(R.id.post_play_buttons_container);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12358() {
        if (this.f11529 != null) {
            this.f11529.m12306();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12360() {
        if (this.f11529 != null) {
            this.f11529.m12303();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12359(PostPlayItem postPlayItem, NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PlayLocationType playLocationType) {
        boolean z = postPlayItem.getExperienceType().equals("episodicTeaser") && postPlayItem.getLogoAsset() != null;
        this.f11531.removeAllViews();
        if (m12354(postPlayItem) && !playLocationType.equals(PlayLocationType.MDX)) {
            for (int i = 1; i < postPlayItem.getActions().size(); i++) {
                PostPlayAction postPlayAction = postPlayItem.getActions().get(i);
                Button button = (Button) netflixActivity.getLayoutInflater().inflate(R.layout.post_play_button, (ViewGroup) this.f11531, false);
                this.f11531.addView(button);
                this.f11527.add(new wL(netflixActivity, iPlayerFragment, postPlayAction, playLocationType, button));
            }
        }
        if (postPlayItem.getSynopsis() == null || z) {
            this.f11532.setVisibility(8);
        } else {
            this.f11532.setText(postPlayItem.getSynopsis());
            this.f11532.setVisibility(0);
        }
        if (this.f11529 != null) {
            if (postPlayItem.isAutoPlay()) {
                this.f11529.m12305(postPlayItem, netflixActivity);
                this.f11529.setVisibility(0);
            } else {
                this.f11529.setVisibility(8);
            }
        }
        if (this.f11533 != null) {
            m12355(postPlayItem);
        }
        if (this.f11534 != null) {
            m12353(postPlayItem);
        }
        if (this.f11530 == null) {
            return;
        }
        if (z) {
            NetflixActivity.getImageLoader(netflixActivity).mo3063(this.f11530, postPlayItem.getLogoAsset().getUrl(), AssetType.merchStill, postPlayItem.getAncestorTitle(), StaticImgConfig.LIGHT_NO_PLACEHOLDER, true, 1);
            this.f11530.setVisibility(0);
            return;
        }
        this.f11530.setVisibility(8);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m12354(PostPlayItem postPlayItem) {
        String experienceType = postPlayItem.getExperienceType();
        char c = 65535;
        switch (experienceType.hashCode()) {
            case -192601208:
                if (experienceType.equals("nextEpisode")) {
                    c = 0;
                    break;
                }
                break;
            case -59216460:
                if (experienceType.equals("episodicTeaser")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return false;
            default:
                return true;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m12355(PostPlayItem postPlayItem) {
        if (postPlayItem.getTitle() != null) {
            this.f11528.setText(m12356(postPlayItem));
            this.f11528.setVisibility(0);
        } else {
            this.f11528.setVisibility(8);
        }
        if (postPlayItem.hasNewBadge()) {
            LoMoUtils.m2146(postPlayItem.getBadgeKeys(), this.f11526);
            this.f11526.setVisibility(0);
            return;
        }
        this.f11526.setVisibility(8);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12353(PostPlayItem postPlayItem) {
        if (AD.m3299()) {
            this.f11534.setVisibility(0);
            this.f11524.setVisibility(8);
            if (postPlayItem.isNewForPvr() || postPlayItem.getMatchPercentage() > 0) {
                if (postPlayItem.isNewForPvr()) {
                    this.f11524.setText(R.string.rating_new_to_pvr);
                } else {
                    this.f11524.setText(getResources().getString(R.string.rating_match_percentage, Integer.valueOf(postPlayItem.getMatchPercentage())));
                }
                this.f11524.setVisibility(0);
            }
            if (postPlayItem.getYear() != null) {
                this.f11535.setText(String.valueOf(postPlayItem.getYear()));
                this.f11535.setVisibility(0);
            } else {
                this.f11535.setVisibility(8);
            }
            if (postPlayItem.getMaturityRating() != null) {
                this.f11523.setText(postPlayItem.getMaturityRating());
                this.f11523.setVisibility(0);
            } else {
                this.f11523.setVisibility(8);
            }
            String r5 = m12357(getContext(), postPlayItem);
            if (r5 != null) {
                this.f11525.setText(r5);
                this.f11525.setVisibility(0);
                return;
            }
            this.f11525.setVisibility(8);
            return;
        }
        this.f11534.setVisibility(8);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m12356(PostPlayItem postPlayItem) {
        String str;
        if (postPlayItem.isEpisodeNumberHidden()) {
            return getContext().getResources().getString(R.string.label_postplay_title_without_episodenumber, postPlayItem.getAncestorTitle(), postPlayItem.getTitle());
        }
        if (postPlayItem.isNSRE()) {
            return postPlayItem.getTitle();
        }
        if (!postPlayItem.getType().equals(PostPlayItem.POST_PLAY_ITEM_EPISODE) || postPlayItem.getPlayAction() == null) {
            str = postPlayItem.getTitle();
        } else {
            PostPlayAction playAction = postPlayItem.getPlayAction();
            str = getContext().getResources().getString(R.string.label_postplay_episode_title, postPlayItem.getAncestorTitle(), playAction.getSeasonSequenceAbbr(), Integer.valueOf(playAction.getEpisode()), postPlayItem.getTitle());
        }
        if (C1349Bv.m4113(postPlayItem.getSupplementalMessage()) || postPlayItem.getExperienceType().contains("nextEpisode") || postPlayItem.getExperienceType().contains("recommendation")) {
            return str;
        }
        return postPlayItem.getSupplementalMessage();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String m12357(Context context, PostPlayItem postPlayItem) {
        String type = postPlayItem.getType();
        char c = 65535;
        switch (type.hashCode()) {
            case -906335517:
                if (type.equals("season")) {
                    c = 1;
                    break;
                }
                break;
            case -905838985:
                if (type.equals("series")) {
                    c = 2;
                    break;
                }
                break;
            case 3529469:
                if (type.equals("show")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return postPlayItem.getSeasonsLabel();
            case 1:
            case 2:
                return postPlayItem.getEpisodes() + " episodes";
            default:
                return BD.m3838(postPlayItem.getRuntime(), context);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        m12352();
    }
}

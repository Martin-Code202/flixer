package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayItem;
public class wH extends wC {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected C1050 f11461;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected int f11462;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final DecelerateInterpolator f11463;

    public wH(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11463 = new DecelerateInterpolator();
        this.f11462 = SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS;
    }

    public wH(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    @Override // o.wC
    /* renamed from: ˎ */
    public void mo12264() {
        this.f11461 = (C1050) findViewById(R.id.postplay_bgd);
        ImageView imageView = (ImageView) findViewById(R.id.post_play_play_button);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // o.wC
    /* renamed from: ˏ */
    public void mo12265() {
        if (this.f11420 != null && this.f11461 != null && !AD.m3307(this.f11420) && this.f11461.getMeasuredWidth() == 0) {
            this.f11461.getLayoutParams().height = (int) (((double) AD.m3280(this.f11420)) * 0.6d);
            this.f11461.getLayoutParams().width = (int) (((float) this.f11461.getLayoutParams().height) * 1.778f);
            this.f11461.animate().setStartDelay(1000).setDuration((long) this.f11462).x((float) (this.f11461.getLayoutParams().height - this.f11461.getLayoutParams().width)).setInterpolator(this.f11463);
        }
    }

    @Override // o.wC
    /* renamed from: ˋ */
    public void mo12263(PostPlayItem postPlayItem, NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PlayLocationType playLocationType) {
        this.f11420 = netflixActivity;
        if (!(this.f11461 == null || playLocationType == null)) {
            this.f11461.setCutomCroppingEnabled(true);
            this.f11461.setCenterHorizontally(true);
        }
        if (postPlayItem.getBackgroundAsset() != null && postPlayItem.getBackgroundAsset().getUrl() != null) {
            NetflixActivity.getImageLoader(netflixActivity).mo3063(this.f11461, postPlayItem.getBackgroundAsset().getUrl(), AssetType.merchStill, String.format(netflixActivity.getResources().getString(R.string.accesibility_postplay_select_recommendation), postPlayItem.getTitle()), StaticImgConfig.DARK, true, 1);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.wC
    /* renamed from: ˊ */
    public void mo12261() {
    }

    /* access modifiers changed from: protected */
    @Override // o.wC
    /* renamed from: ˋ */
    public void mo12262() {
    }
}

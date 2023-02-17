package o;

import android.content.Context;
import android.util.AttributeSet;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayItem;
public class wJ extends wC {

    /* renamed from: ˊ  reason: contains not printable characters */
    private wU f11470;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0522 f11471;

    /* renamed from: ॱ  reason: contains not printable characters */
    private wH f11472;

    public wJ(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public wJ(Context context) {
        super(context, null);
    }

    /* access modifiers changed from: protected */
    @Override // o.wC
    /* renamed from: ˎ */
    public void mo12264() {
        this.f11472 = (wH) findViewById(R.id.post_play_background_wrapper);
        this.f11470 = (wU) findViewById(R.id.post_play_metadata);
        this.f11471 = (C0522) findViewById(R.id.post_play_logo);
    }

    @Override // o.wC
    /* renamed from: ˋ */
    public void mo12263(PostPlayItem postPlayItem, NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PlayLocationType playLocationType) {
        this.f11472.mo12263(postPlayItem, netflixActivity, iPlayerFragment, playLocationType);
        this.f11470.m12359(postPlayItem, netflixActivity, iPlayerFragment, playLocationType);
        if (postPlayItem.getLogoAsset() != null && postPlayItem.getLogoAsset().getUrl() != null) {
            NetflixActivity.getImageLoader(netflixActivity).mo3063(this.f11471, postPlayItem.getLogoAsset().getUrl(), AssetType.merchStill, postPlayItem.getAncestorTitle(), StaticImgConfig.DARK_NO_PLACEHOLDER, true, 1);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.wC
    /* renamed from: ˊ */
    public void mo12261() {
        if (this.f11470 != null) {
            this.f11470.m12358();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.wC
    /* renamed from: ˋ */
    public void mo12262() {
        if (this.f11470 != null) {
            this.f11470.m12360();
        }
    }

    @Override // o.wC
    /* renamed from: ˏ */
    public void mo12265() {
        if (this.f11472 != null) {
            this.f11472.mo12265();
        }
    }
}

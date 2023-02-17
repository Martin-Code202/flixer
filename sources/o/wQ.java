package o;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayItem;
public class wQ extends wR {

    /* renamed from: ˊ  reason: contains not printable characters */
    private ImageView f11510;

    /* renamed from: ˎ  reason: contains not printable characters */
    private PostPlayItem f11511;

    /* renamed from: ˏ  reason: contains not printable characters */
    private wL f11512;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C0522 f11513;

    public wQ(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public wQ(Context context) {
        super(context, null);
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˏ */
    public void mo12339() {
        this.f11513 = (C0522) findViewById(R.id.post_play_display_art);
        this.f11510 = (ImageView) findViewById(R.id.post_play_play_button);
    }

    @Override // o.wR
    /* renamed from: ˏ */
    public void mo12341(PostPlayItem postPlayItem, NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PlayLocationType playLocationType, View.OnClickListener onClickListener) {
        this.f11511 = postPlayItem;
        if (this.f11511.getPlayAction() != null) {
            this.f11512 = new wL(netflixActivity, iPlayerFragment, this.f11511.getPlayAction(), PlayLocationType.POST_PLAY);
            if (!(this.f11511.getDisplayArtAsset() == null || this.f11511.getDisplayArtAsset().getUrl() == null)) {
                NetflixActivity.getImageLoader(netflixActivity).mo3063(this.f11513, this.f11511.getDisplayArtAsset().getUrl(), AssetType.merchStill, String.format(netflixActivity.getResources().getString(R.string.accesibility_postplay_select_recommendation), this.f11511.getTitle()), StaticImgConfig.LIGHT_NO_PLACEHOLDER, true, 1);
            }
            if (onClickListener != null) {
                setOnClickListener(onClickListener);
                if (!TextUtils.equals(this.f11511.getExperienceType(), "recommendations")) {
                    this.f11510.setVisibility(0);
                } else {
                    this.f11510.setVisibility(8);
                }
            } else {
                this.f11510.setVisibility(8);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12348() {
        if (this.f11512 != null) {
            this.f11512.m12337(false);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        if (this.f11511 != null && TextUtils.equals(this.f11511.getExperienceType(), "recommendations")) {
            this.f11510.setVisibility(z ? 0 : 8);
        }
        super.setSelected(z);
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˏ */
    public void mo12340(int i) {
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˎ */
    public void mo12338() {
    }
}

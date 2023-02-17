package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayItem;
public class wM extends wR {

    /* renamed from: ˋ  reason: contains not printable characters */
    wQ f11493;

    /* renamed from: ˏ  reason: contains not printable characters */
    wU f11494;

    public wM(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public wM(Context context) {
        super(context, null);
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12339() {
        this.f11493 = (wQ) findViewById(R.id.post_play_item_poster);
        this.f11494 = (wU) findViewById(R.id.post_play_metadata);
    }

    @Override // o.wR
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12341(PostPlayItem postPlayItem, NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PlayLocationType playLocationType, View.OnClickListener onClickListener) {
        this.f11493.mo12341(postPlayItem, netflixActivity, iPlayerFragment, playLocationType, onClickListener);
        this.f11494.m12359(postPlayItem, netflixActivity, iPlayerFragment, playLocationType);
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12340(int i) {
        if (this.f11494 != null) {
            this.f11494.m12358();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo12338() {
        if (this.f11494 != null) {
            this.f11494.m12360();
        }
    }
}

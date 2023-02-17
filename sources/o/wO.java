package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayItem;
public class wO extends wR {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected TextView f11501;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected C0754 f11502;

    public wO(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public wO(Context context) {
        super(context, null);
    }

    /* access modifiers changed from: protected */
    @Override // o.wR
    /* renamed from: ˏ */
    public void mo12339() {
        this.f11501 = (TextView) findViewById(R.id.sampling_details);
        this.f11502 = (C0754) findViewById(R.id.sampling_button);
    }

    @Override // o.wR
    /* renamed from: ˏ */
    public void mo12341(PostPlayItem postPlayItem, NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PlayLocationType playLocationType, View.OnClickListener onClickListener) {
        this.f11501.setText(getContext().getString(R.string.label_sampling_details, postPlayItem.getAncestorTitle()));
        this.f11502.setOnClickListener(onClickListener);
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

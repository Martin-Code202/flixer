package o;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayItem;
public abstract class wC extends FrameLayout {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected NetflixActivity f11420;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract void mo12261();

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract void mo12262();

    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract void mo12263(PostPlayItem postPlayItem, NetflixActivity netflixActivity, IPlayerFragment iPlayerFragment, PlayLocationType playLocationType);

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void mo12264();

    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract void mo12265();

    public wC(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public wC(Context context) {
        this(context, null);
    }

    public wC(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        mo12264();
    }
}

package o;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.model.leafs.PostPlayItem;
import o.C1352By;
public class wI extends LinearLayout {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected NetflixActivity f11464;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1352By.C0072 f11465;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Runnable f11466 = new Runnable() { // from class: o.wI.2
        @Override // java.lang.Runnable
        public void run() {
            wI.this.m12304();
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    PostPlayItem f11467;

    /* renamed from: ॱ  reason: contains not printable characters */
    private TextView f11468;

    public wI(Context context) {
        super(context);
    }

    public wI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public wI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12305(PostPlayItem postPlayItem, NetflixActivity netflixActivity) {
        this.f11464 = netflixActivity;
        this.f11467 = postPlayItem;
        this.f11465 = new C1352By.C0072(netflixActivity);
        this.f11465.m4149(this.f11466);
        this.f11465.m4148(postPlayItem.getAutoPlaySeconds());
        m12304();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12306() {
        if (this.f11465 != null) {
            this.f11465.m4151();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12303() {
        if (this.f11465 != null) {
            this.f11465.m4150();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12304() {
        int max = Math.max(1, this.f11465.m4146());
        int i = this.f11467.isNextEpisodeAutoPlay() ? R.string.label_postplay_nextEpisode : R.string.label_postplay_startsIn;
        if (this.f11468 != null) {
            this.f11468.setText(C1349Bv.m4102(C0403.m14185(this.f11464, i).m14187(max).m14188()));
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f11465 != null) {
            this.f11465.m4150();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f11468 = (TextView) findViewById(R.id.post_play_countdown_action);
    }
}

package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.NetflixVideoView;
import io.reactivex.subjects.PublishSubject;
public final class yG implements AbstractC2354ys {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final iF f12373 = new iF(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final View f12374;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ViewGroup f12375;

    public yG(ViewGroup viewGroup, NetflixVideoView netflixVideoView) {
        C1457Fr.m5025(viewGroup, "parent");
        C1457Fr.m5025(netflixVideoView, "videoView");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_controls_subtitles_view, viewGroup, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…itles_view, parent, true)");
        this.f12374 = inflate;
        View findViewById = this.f12374.findViewById(R.id.player_subtitles_container);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id…ayer_subtitles_container)");
        this.f12375 = (ViewGroup) findViewById;
        netflixVideoView.setSubtitleDisplayArea(this.f12375);
    }

    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
        this.f12375.setVisibility(8);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʼ */
    public boolean mo13108() {
        return this.f12375.getVisibility() == 0;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
        this.f12375.setVisibility(0);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ˏॱ */
    public void mo13085() {
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ͺ */
    public void mo13086() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        return create;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m13129() {
        return this.f12375.getId();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m13126() {
        this.f12375.animate().cancel();
        this.f12375.animate().setDuration(0).setStartDelay(900).alpha(1.0f).start();
    }

    @Override // o.AbstractC2354ys
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo13128() {
        this.f12375.setAlpha(0.0f);
        m13126();
    }
}

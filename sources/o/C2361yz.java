package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.v2.uiView.IPlayerSkipCreditsUIView;
import io.reactivex.subjects.PublishSubject;
import o.xJ;
/* renamed from: o.yz  reason: case insensitive filesystem */
public final class C2361yz extends yJ implements IPlayerSkipCreditsUIView {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12550;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0647 f12551;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final View f12552;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2361yz(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_controls_skip_recap_pre_play, viewGroup, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…p_pre_play, parent, true)");
        this.f12552 = inflate;
        View findViewById = this.f12552.findViewById(R.id.skip_recap_pre_play_button);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id…ip_recap_pre_play_button)");
        this.f12551 = (C0647) findViewById;
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        this.f12550 = create;
        aj_().setOnClickListener(new View.OnClickListener(this) { // from class: o.yz.2

            /* renamed from: ˊ  reason: contains not printable characters */
            final /* synthetic */ C2361yz f12553;

            {
                this.f12553 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12553.f12550.onNext(xJ.C0281.f12029);
                this.f12553.aj_().mo12391(true);
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0647 aj_() {
        return this.f12551;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
        this.f12550.onNext(xJ.C0279.f12027);
        aj_().mo12393(true);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
        aj_().mo12391(true);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        return this.f12550;
    }

    @Override // com.netflix.mediaclient.ui.player.v2.uiView.IPlayerSkipCreditsUIView
    /* renamed from: ˋ */
    public void mo2734(int i) {
        aj_().setText(i);
    }

    @Override // com.netflix.mediaclient.ui.player.v2.uiView.IPlayerSkipCreditsUIView
    /* renamed from: ˋ */
    public void mo2735(boolean z) {
        aj_().mo12391(z);
    }

    @Override // com.netflix.mediaclient.ui.player.v2.uiView.IPlayerSkipCreditsUIView
    /* renamed from: ˎ */
    public void mo2736(boolean z) {
        aj_().mo12393(z);
    }

    @Override // o.yJ
    public int ai_() {
        return aj_().getId();
    }

    @Override // com.netflix.mediaclient.ui.player.v2.uiView.IPlayerSkipCreditsUIView
    /* renamed from: ॱ */
    public void mo2737(IPlayerSkipCreditsUIView.SkipCreditsType skipCreditsType) {
        C1457Fr.m5025(skipCreditsType, "type");
    }

    @Override // com.netflix.mediaclient.ui.player.v2.uiView.IPlayerSkipCreditsUIView
    /* renamed from: ˊ */
    public void mo2733() {
        aj_().setVisibility(8);
    }
}

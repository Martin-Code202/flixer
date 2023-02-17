package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
/* renamed from: o.yv  reason: case insensitive filesystem */
public final class C2357yv extends yJ implements AbstractC2342yg {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final View f12505;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final View f12506;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2357yv(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_controls_gradient_view, (ViewGroup) null, false);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…adient_view, null, false)");
        this.f12506 = inflate;
        View findViewById = this.f12506.findViewById(R.id.player_background_gradient);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id…ayer_background_gradient)");
        this.f12505 = findViewById;
        viewGroup.addView(this.f12506, 1);
    }

    @Override // o.yJ
    public View aj_() {
        return this.f12505;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
        m13140().m12587(aj_(), true);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
        m13140().m12587(aj_(), false);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        return create;
    }
}

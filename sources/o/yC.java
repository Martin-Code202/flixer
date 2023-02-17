package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
public final class yC extends yJ implements AbstractC2348ym {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final View f12341;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12342;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ViewGroup f12343;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yC(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_play, viewGroup, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare….post_play, parent, true)");
        this.f12341 = inflate;
        View findViewById = this.f12341.findViewById(R.id.postplay);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id.postplay)");
        this.f12343 = (ViewGroup) findViewById;
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        this.f12342 = create;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public ViewGroup aj_() {
        return this.f12343;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
        aj_().setVisibility(0);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
        aj_().setVisibility(8);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        return this.f12342;
    }

    @Override // o.yJ
    public int ai_() {
        return aj_().getId();
    }
}

package o;

import android.app.Activity;
import android.view.ViewGroup;
import io.reactivex.subjects.PublishSubject;
/* renamed from: o.yt  reason: case insensitive filesystem */
public final class C2355yt extends yJ implements AbstractC2341yf {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final ViewGroup f12500;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2355yt(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        this.f12500 = viewGroup;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        return create;
    }

    @Override // o.AbstractC2341yf
    /* renamed from: ˊ */
    public void mo13334() {
        AD.m3297((Activity) C0345.m13893(aj_().getContext(), Activity.class));
    }

    @Override // o.AbstractC2341yf
    /* renamed from: ˋ */
    public void mo13335() {
        AD.m3302((Activity) C0345.m13893(aj_().getContext(), Activity.class));
    }
}

package o;

import android.view.View;
public abstract class yJ implements AbstractC2351yp {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C2282wx f12387 = new C2282wx();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final View f12388;

    public yJ(View view) {
        C1457Fr.m5025(view, "uiView");
        this.f12388 = view;
    }

    public View aj_() {
        return this.f12388;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public final C2282wx m13140() {
        return this.f12387;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʼ */
    public boolean mo13108() {
        return aj_().getVisibility() == 0;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ˏॱ */
    public void mo13085() {
        this.f12387.m12594(aj_(), true);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ͺ */
    public void mo13086() {
        this.f12387.m12594(aj_(), false);
    }

    public int ai_() {
        return aj_().getId();
    }
}

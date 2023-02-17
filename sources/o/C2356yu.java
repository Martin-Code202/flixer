package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
/* renamed from: o.yu  reason: case insensitive filesystem */
public final class C2356yu extends yJ implements AbstractC2344yi {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final View f12501;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final View f12502;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final ViewGroup f12503;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final TextView f12504;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2356yu(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        this.f12503 = viewGroup;
        View inflate = LayoutInflater.from(this.f12503.getContext()).inflate(R.layout.player_loading_spinner, this.f12503, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…ng_spinner, parent, true)");
        this.f12502 = inflate;
        View findViewById = this.f12502.findViewById(R.id.player_loading_container);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id.player_loading_container)");
        this.f12501 = findViewById;
        View findViewById2 = this.f12502.findViewById(R.id.loading_label);
        C1457Fr.m5016((Object) findViewById2, "rootUI.findViewById(R.id.loading_label)");
        this.f12504 = (TextView) findViewById2;
    }

    @Override // o.yJ
    public View aj_() {
        return this.f12501;
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
        this.f12504.setVisibility(8);
        aj_().setBackground(null);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        return create;
    }
}

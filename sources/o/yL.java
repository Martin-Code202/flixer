package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
public final class yL extends yJ implements AbstractC2352yq {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12391;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final View f12392;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final TextView f12393;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ViewGroup f12394;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yL(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        this.f12394 = viewGroup;
        View inflate = LayoutInflater.from(this.f12394.getContext()).inflate(R.layout.player_controls_watermark, this.f12394, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…_watermark, parent, true)");
        this.f12392 = inflate;
        View findViewById = this.f12392.findViewById(R.id.player_watermark);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id.player_watermark)");
        this.f12393 = (TextView) findViewById;
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        this.f12391 = create;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public TextView aj_() {
        return this.f12393;
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

    /* renamed from: ˊ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        return this.f12391;
    }

    @Override // o.AbstractC2352yq
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo13215(String str) {
        C1457Fr.m5025(str, "text");
        aj_().setText(this.f12394.getContext().getString(R.string.label_watermark, str));
    }

    @Override // o.AbstractC2352yq
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo13214(float f) {
        aj_().setAlpha(f);
    }
}

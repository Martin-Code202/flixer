package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
import o.xJ;
public final class yB extends yJ implements AbstractC2346yk {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12333;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final ImageButton f12334;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ViewGroup f12335;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final View f12336;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final TextView f12337;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ImageButton f12338;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yB(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_controls_navigation, viewGroup, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…navigation, parent, true)");
        this.f12336 = inflate;
        View findViewById = this.f12336.findViewById(R.id.player_controls_navigation);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id…ayer_controls_navigation)");
        this.f12335 = (ViewGroup) findViewById;
        View findViewById2 = this.f12336.findViewById(R.id.player_back_button);
        C1457Fr.m5016((Object) findViewById2, "rootUI.findViewById(R.id.player_back_button)");
        this.f12338 = (ImageButton) findViewById2;
        View findViewById3 = this.f12336.findViewById(R.id.player_cast_text_button);
        C1457Fr.m5016((Object) findViewById3, "rootUI.findViewById(R.id.player_cast_text_button)");
        this.f12334 = (ImageButton) findViewById3;
        View findViewById4 = this.f12336.findViewById(R.id.player_title_label);
        C1457Fr.m5016((Object) findViewById4, "rootUI.findViewById(R.id.player_title_label)");
        this.f12337 = (TextView) findViewById4;
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        this.f12333 = create;
        this.f12338.setOnClickListener(new View.OnClickListener(this) { // from class: o.yB.5

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ yB f12340;

            {
                this.f12340 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12340.f12333.onNext(new xJ.C2303iF());
            }
        });
        this.f12334.setOnClickListener(new View.OnClickListener(this) { // from class: o.yB.4

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ yB f12339;

            {
                this.f12339 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12339.f12333.onNext(new xJ.C0278());
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public ViewGroup aj_() {
        return this.f12335;
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ˏॱ */
    public void mo13085() {
        this.f12334.setEnabled(true);
        m13140().m12590((View) this.f12334, true);
        m13140().m12590((View) this.f12337, true);
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ͺ */
    public void mo13086() {
        this.f12334.setEnabled(false);
        m13140().m12590((View) this.f12334, false);
        m13140().m12590((View) this.f12337, false);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
        xA.m12737(xA.f11946, aj_(), true, false, 0.0f, null, 24, null);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
        xA.m12737(xA.f11946, aj_(), false, false, 0.0f, null, 24, null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        return this.f12333;
    }

    @Override // o.AbstractC2346yk
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo13093(String str) {
        C1457Fr.m5025(str, "text");
        this.f12337.setText(str);
    }

    @Override // o.AbstractC2346yk
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo13094() {
        this.f12334.setVisibility(4);
    }

    @Override // o.AbstractC2346yk
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo13091() {
        this.f12334.setVisibility(0);
    }
}

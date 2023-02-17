package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
import o.xJ;
public final class yA extends yJ implements AbstractC2347yl {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Button f12324;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ViewGroup f12325;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Button f12326;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final View f12327;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Button f12328;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12329;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yA(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_controls_secondary, viewGroup, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…_secondary, parent, true)");
        this.f12327 = inflate;
        View findViewById = this.f12327.findViewById(R.id.player_controls_secondary);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id…layer_controls_secondary)");
        this.f12325 = (ViewGroup) findViewById;
        View findViewById2 = this.f12327.findViewById(R.id.player_episodes_button);
        C1457Fr.m5016((Object) findViewById2, "rootUI.findViewById(R.id.player_episodes_button)");
        this.f12324 = (Button) findViewById2;
        View findViewById3 = this.f12327.findViewById(R.id.player_langSubs_button);
        C1457Fr.m5016((Object) findViewById3, "rootUI.findViewById(R.id.player_langSubs_button)");
        this.f12328 = (Button) findViewById3;
        View findViewById4 = this.f12327.findViewById(R.id.player_next_episode_button);
        C1457Fr.m5016((Object) findViewById4, "rootUI.findViewById(R.id…ayer_next_episode_button)");
        this.f12326 = (Button) findViewById4;
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        this.f12329 = create;
        this.f12324.setOnClickListener(new View.OnClickListener(this) { // from class: o.yA.5

            /* renamed from: ˊ  reason: contains not printable characters */
            final /* synthetic */ yA f12332;

            {
                this.f12332 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12332.f12329.onNext(xJ.C2296AuX.f12012);
            }
        });
        this.f12328.setOnClickListener(new View.OnClickListener(this) { // from class: o.yA.3

            /* renamed from: ˊ  reason: contains not printable characters */
            final /* synthetic */ yA f12330;

            {
                this.f12330 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12330.f12329.onNext(xJ.C0276.f12025);
            }
        });
        this.f12326.setOnClickListener(new View.OnClickListener(this) { // from class: o.yA.4

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ yA f12331;

            {
                this.f12331 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12331.f12329.onNext(xJ.C2301aux.f12022);
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public ViewGroup aj_() {
        return this.f12325;
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void mo13085() {
        super.mo13085();
        this.f12326.setEnabled(true);
        this.f12328.setEnabled(true);
        this.f12324.setEnabled(true);
    }

    @Override // o.yJ, o.AbstractC2351yp
    /* renamed from: ͺ  reason: contains not printable characters */
    public void mo13086() {
        super.mo13086();
        this.f12326.setEnabled(false);
        this.f12328.setEnabled(false);
        this.f12324.setEnabled(false);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void mo13088() {
        xA.m12737(xA.f11946, aj_(), true, true, 0.0f, null, 24, null);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ  reason: contains not printable characters */
    public void mo13079() {
        xA.m12737(xA.f11946, aj_(), false, true, 0.0f, null, 24, null);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        return this.f12329;
    }

    @Override // o.AbstractC2347yl
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo13083() {
        this.f12326.setVisibility(0);
    }

    @Override // o.AbstractC2347yl
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo13081() {
        this.f12326.setVisibility(8);
    }

    @Override // o.AbstractC2347yl
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo13084() {
        this.f12324.setVisibility(0);
    }

    @Override // o.AbstractC2347yl
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo13087() {
        this.f12324.setVisibility(8);
    }
}

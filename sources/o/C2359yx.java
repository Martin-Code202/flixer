package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
import o.xF;
import o.xJ;
/* renamed from: o.yx  reason: case insensitive filesystem */
public final class C2359yx extends yJ implements AbstractC2340ye {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12526;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final View f12527;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final View f12528;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0754 f12529;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0754 f12530;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C0754 f12531;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2359yx(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.playout_interrupter, viewGroup, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…nterrupter, parent, true)");
        this.f12527 = inflate;
        View findViewById = this.f12527.findViewById(R.id.interrupter);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id.interrupter)");
        this.f12528 = findViewById;
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        this.f12526 = create;
        View findViewById2 = aj_().findViewById(R.id.postplay_continueWatching);
        C1457Fr.m5016((Object) findViewById2, "uiView.findViewById(R.id…ostplay_continueWatching)");
        this.f12529 = (C0754) findViewById2;
        View findViewById3 = aj_().findViewById(R.id.postplay_playFromBeginning);
        C1457Fr.m5016((Object) findViewById3, "uiView.findViewById(R.id…stplay_playFromBeginning)");
        this.f12530 = (C0754) findViewById3;
        View findViewById4 = aj_().findViewById(R.id.postplay_stopWatching);
        C1457Fr.m5016((Object) findViewById4, "uiView.findViewById(R.id.postplay_stopWatching)");
        this.f12531 = (C0754) findViewById4;
        this.f12529.setOnClickListener(new View.OnClickListener(this) { // from class: o.yx.3

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ C2359yx f12533;

            {
                this.f12533 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12533.m13364().onNext(xJ.C0282.f12030);
            }
        });
        this.f12530.setOnClickListener(new View.OnClickListener(this) { // from class: o.yx.2

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ C2359yx f12532;

            {
                this.f12532 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12532.m13364().onNext(xJ.Cif.f12024);
            }
        });
        this.f12531.setOnClickListener(new View.OnClickListener(this) { // from class: o.yx.5

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ C2359yx f12534;

            {
                this.f12534 = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12534.mo13332();
            }
        });
    }

    @Override // o.yJ
    public View aj_() {
        return this.f12528;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final PublishSubject<xJ> m13364() {
        return this.f12526;
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

    /* renamed from: ˋ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        return this.f12526;
    }

    @Override // o.AbstractC2340ye
    /* renamed from: ॱ */
    public void mo13333() {
        this.f12526.onNext(xF.If.f11968);
    }

    @Override // o.AbstractC2340ye
    /* renamed from: ˊ */
    public void mo13332() {
        this.f12526.onNext(xJ.C0283.f12031);
    }
}

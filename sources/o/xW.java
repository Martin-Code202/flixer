package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSeekbarPresenter$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSeekbarPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSeekbarPresenter$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSeekbarPresenter$4;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSeekbarPresenter$5;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xW extends C2338yc {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final Cif f12099 = new Cif(null);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final String f12100 = f12100;

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f12101;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractC2350yo f12102;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1351Bx f12103 = new C1351Bx();

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f12104;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Observable<xJ> f12105 = this.f12102.mo13082();

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f12106;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xW(AbstractC2350yo yoVar, Observable<xH> observable, Observable<EA> observable2) {
        super(yoVar, observable, observable2);
        C1457Fr.m5025(yoVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12102 = yoVar;
        Observable<xH> takeUntil = observable.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy(takeUntil, new PlayerSeekbarPresenter$2(this), new PlayerSeekbarPresenter$3(this), new PlayerSeekbarPresenter$1(this));
        Observable<xJ> takeUntil2 = this.f12105.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil2, "uiEventObservable\n      …eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil2, new PlayerSeekbarPresenter$5(this), null, new PlayerSeekbarPresenter$4(this), 2, null);
    }

    /* renamed from: o.xW$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m12857(int i, int i2, boolean z) {
        m12862(i, i2);
        if (!z) {
            this.f12102.mo13088();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m12862(int i, int i2) {
        this.f12102.mo13110(i);
        AbstractC2350yo yoVar = this.f12102;
        String r1 = this.f12103.m4133(i2 - i);
        C1457Fr.m5016((Object) r1, "timeLineFormatterHelper.…orMs(duration - progress)");
        yoVar.mo13116(r1);
    }
}

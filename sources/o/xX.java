package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSkipCreditsUIPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSkipCreditsUIPresenter$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSkipCreditsUIPresenter$5;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSkipCreditsUIPresenter$6;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSkipCreditsUIPresenter$8;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSkipCreditsUIPresenter$9;
import com.netflix.mediaclient.ui.player.v2.uiView.IPlayerSkipCreditsUIView;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xX {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final IPlayerSkipCreditsUIView f12107;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f12108;

    public xX(IPlayerSkipCreditsUIView iPlayerSkipCreditsUIView, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(iPlayerSkipCreditsUIView, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12107 = iPlayerSkipCreditsUIView;
        Observable<xH> filter = observable.takeUntil(observable2).filter(AnonymousClass3.f12110);
        C1457Fr.m5016((Object) filter, "playerStateEventObservab…rIsNotWithinCreditMarks }");
        SubscribersKt.subscribeBy$default(filter, PlayerSkipCreditsUIPresenter$3.f3779, null, new PlayerSkipCreditsUIPresenter$2(this), 2, null);
        Observable<xH> filter2 = observable.takeUntil(observable2).filter(new Predicate<xH>(this) { // from class: o.xX.2

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ xX f12109;

            {
                this.f12109 = r1;
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final boolean test(xH xHVar) {
                C1457Fr.m5025(xHVar, "it");
                return !this.f12109.m12868();
            }
        });
        C1457Fr.m5016((Object) filter2, "playerStateEventObservab…filter { !isWithinMarks }");
        SubscribersKt.subscribeBy$default(filter2, PlayerSkipCreditsUIPresenter$6.f3781, null, new PlayerSkipCreditsUIPresenter$5(this), 2, null);
        Observable<xH> filter3 = observable.takeUntil(observable2).filter(new Predicate<xH>(this) { // from class: o.xX.4

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ xX f12111;

            {
                this.f12111 = r1;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final boolean test(xH xHVar) {
                C1457Fr.m5025(xHVar, "it");
                return this.f12111.m12868();
            }
        });
        C1457Fr.m5016((Object) filter3, "playerStateEventObservab….filter { isWithinMarks }");
        SubscribersKt.subscribeBy$default(filter3, PlayerSkipCreditsUIPresenter$9.f3783, null, new PlayerSkipCreditsUIPresenter$8(this), 2, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m12867(boolean z) {
        this.f12108 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final boolean m12868() {
        return this.f12108;
    }
}

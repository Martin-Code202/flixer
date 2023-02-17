package o;

import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSkipPrePlayUIPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSkipPrePlayUIPresenter$4;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerSkipPrePlayUIPresenter$5;
import com.netflix.mediaclient.ui.player.v2.uiView.IPlayerSkipCreditsUIView;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xV {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f12094;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final IPlayerSkipCreditsUIView f12095;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f12096;

    public xV(IPlayerSkipCreditsUIView iPlayerSkipCreditsUIView, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(iPlayerSkipCreditsUIView, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12095 = iPlayerSkipCreditsUIView;
        this.f12095.mo2734(R.string.label_skip_recap_button);
        Observable<xH> filter = observable.takeUntil(observable2).filter(AnonymousClass4.f12098);
        C1457Fr.m5016((Object) filter, "playerStateEventObservab…tateEvent.PlayerStarted }");
        SubscribersKt.subscribeBy$default(filter, null, null, new PlayerSkipPrePlayUIPresenter$2(this), 3, null);
        Observable<xH> filter2 = observable.takeUntil(observable2).filter(new Predicate<xH>(this) { // from class: o.xV.3

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ xV f12097;

            {
                this.f12097 = r1;
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final boolean test(xH xHVar) {
                C1457Fr.m5025(xHVar, "it");
                return this.f12097.f12096;
            }
        });
        C1457Fr.m5016((Object) filter2, "playerStateEventObservab…  .filter { isInPrePlay }");
        SubscribersKt.subscribeBy$default(filter2, PlayerSkipPrePlayUIPresenter$5.f3786, null, new PlayerSkipPrePlayUIPresenter$4(this), 2, null);
    }
}

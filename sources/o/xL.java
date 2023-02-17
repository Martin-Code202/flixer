package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerImmersiveModePresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerImmersiveModePresenter$3;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xL {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2341yf f12040;

    public xL(AbstractC2341yf yfVar, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(yfVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12040 = yfVar;
        Observable<xH> filter = observable.takeUntil(observable2).filter(AnonymousClass2.f12041);
        C1457Fr.m5016((Object) filter, "playerStateEventObservab…ostPlay\n                }");
        SubscribersKt.subscribeBy$default(filter, PlayerImmersiveModePresenter$3.f3735, null, new PlayerImmersiveModePresenter$2(this), 2, null);
    }
}

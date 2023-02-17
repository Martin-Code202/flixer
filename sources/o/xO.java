package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerGradientUIPresenter$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerGradientUIPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerGradientUIPresenter$3;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
public final class xO extends C2338yc {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC2342yg f12076;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xO(AbstractC2342yg ygVar, Observable<xH> observable, Observable<EA> observable2) {
        super(ygVar, observable, observable2);
        C1457Fr.m5025(ygVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12076 = ygVar;
        Observable<xH> takeUntil = observable.takeUntil(observable2);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy(takeUntil, new PlayerGradientUIPresenter$2(this), new PlayerGradientUIPresenter$3(this), new PlayerGradientUIPresenter$1(this));
    }
}

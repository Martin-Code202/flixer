package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPrimaryControlsPresenter$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPrimaryControlsPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPrimaryControlsPresenter$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPrimaryControlsPresenter$observeForSkipAnimationEndTakingOne$1;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPrimaryControlsPresenter$observeForSkipAnimationEndTakingOne$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPrimaryControlsPresenter$observePlayerStartAndSkipAnimationEndTakingOne$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerPrimaryControlsPresenter$observePlayerStartAndSkipAnimationEndTakingOne$3;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import kotlin.Pair;
import o.xH;
public class xS extends C2338yc {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2349yn f12082;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Observable<xH> f12083;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f12084;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Observable<EA> f12085;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public xS(AbstractC2349yn ynVar, Observable<xH> observable, Observable<EA> observable2) {
        super(ynVar, observable, observable2);
        C1457Fr.m5025(ynVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12082 = ynVar;
        this.f12083 = observable;
        this.f12085 = observable2;
        Observable<xH> takeUntil = this.f12083.takeUntil(this.f12085);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy(takeUntil, new PlayerPrimaryControlsPresenter$2(this), new PlayerPrimaryControlsPresenter$3(this), new PlayerPrimaryControlsPresenter$1(this));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m12836(boolean z) {
        this.f12084 = z;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12835(boolean z) {
        Observable<EA> take = this.f12082.mo13342().takeUntil(this.f12085).take(1);
        C1457Fr.m5016((Object) take, "uiView.getSkipButtonAnim…\n                .take(1)");
        SubscribersKt.subscribeBy$default(take, PlayerPrimaryControlsPresenter$observeForSkipAnimationEndTakingOne$2.f3763, null, new PlayerPrimaryControlsPresenter$observeForSkipAnimationEndTakingOne$1(this, z), 2, null);
    }

    static final class iF<T> implements Predicate<xH> {

        /* renamed from: ˋ  reason: contains not printable characters */
        public static final iF f12086 = new iF();

        iF() {
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final boolean test(xH xHVar) {
            C1457Fr.m5025(xHVar, "it");
            return xHVar instanceof xH.Con;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12834() {
        Observable<xH> filter = this.f12083.takeUntil(this.f12085).filter(iF.f12086);
        C1457Fr.m5016((Object) filter, "playerStateEventObservab…tateEvent.PlayerStarted }");
        Observable<R> zipWith = filter.zipWith(this.f12082.mo13342(), Cif.f12087);
        C1457Fr.m5016((Object) zipWith, "zipWith(other, BiFunction { t, u -> Pair(t,u) })");
        Observable<R> takeUntil = zipWith.take(1).takeUntil(this.f12085);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil, PlayerPrimaryControlsPresenter$observePlayerStartAndSkipAnimationEndTakingOne$3.f3765, null, new PlayerPrimaryControlsPresenter$observePlayerStartAndSkipAnimationEndTakingOne$2(this), 2, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m12831() {
        this.f12082.mo13344();
        if (this.f12084) {
            this.f12082.mo13353(false);
        } else {
            this.f12082.mo13353(true);
        }
    }

    /* renamed from: o.xS$if  reason: invalid class name */
    public static final class Cif<T1, T2, R> implements BiFunction<xH, EA, Pair<? extends xH, ? extends EA>> {

        /* renamed from: ˏ  reason: contains not printable characters */
        public static final Cif f12087 = new Cif();

        /* renamed from: ˋ  reason: contains not printable characters */
        public final Pair<xH, EA> apply(xH xHVar, EA ea) {
            return new Pair<>(xHVar, ea);
        }
    }
}

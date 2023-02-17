package o;

import com.netflix.mediaclient.ui.player.v2.presenter.PlayerInterrupterUIPresenter$10;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerInterrupterUIPresenter$12;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerInterrupterUIPresenter$13;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerInterrupterUIPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerInterrupterUIPresenter$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerInterrupterUIPresenter$7;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerInterrupterUIPresenter$8;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerInterrupterUIPresenter$9;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.concurrent.TimeUnit;
import o.xH;
public final class xM {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final String f12042 = f12042;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C0288 f12043 = new C0288(null);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static long f12044 = -1;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static long f12045 = -1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC2340ye f12046;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Observable<xJ> f12047 = this.f12046.mo13082();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Observable<EA> f12048;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f12049;

    public xM(AbstractC2340ye yeVar, Observable<xH> observable, Observable<EA> observable2) {
        C1457Fr.m5025(yeVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12046 = yeVar;
        this.f12048 = observable2;
        Observable<xH> filter = observable.takeUntil(this.f12048).filter(iF.f12055);
        Observable<xH> takeUntil = observable.filter(AnonymousClass3.f12052).take(1).delay(120000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).takeUntil(Observable.merge(this.f12048, filter));
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…e, userInteractionEvent))");
        SubscribersKt.subscribeBy$default(takeUntil, PlayerInterrupterUIPresenter$3.f3745, null, new PlayerInterrupterUIPresenter$2(this, observable, filter), 2, null);
        Observable<xH> takeUntil2 = observable.takeUntil(this.f12048).filter(AnonymousClass5.f12054).take(1).doOnNext(new Consumer<xH>(this) { // from class: o.xM.1

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ xM f12050;

            {
                this.f12050 = r1;
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public final void accept(xH xHVar) {
                C1457Fr.m5025(xHVar, "it");
                this.f12050.f12046.mo13088();
            }
        }).delay(3600000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).takeUntil(this.f12048).takeUntil(this.f12047.filter(AnonymousClass2.f12051));
        C1457Fr.m5016((Object) takeUntil2, "playerStateEventObservab…tTimeToShowInterrupter })");
        SubscribersKt.subscribeBy$default(takeUntil2, PlayerInterrupterUIPresenter$8.f3747, null, new PlayerInterrupterUIPresenter$7(this), 2, null);
        Observable<xH> takeUntil3 = observable.takeUntil(this.f12048);
        C1457Fr.m5016((Object) takeUntil3, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil3, PlayerInterrupterUIPresenter$10.f3736, null, new PlayerInterrupterUIPresenter$9(this), 2, null);
        Observable<xJ> filter2 = this.f12047.takeUntil(this.f12048).filter(AnonymousClass4.f12053);
        C1457Fr.m5016((Object) filter2, "uiEventObservable\n      …atching\n                }");
        SubscribersKt.subscribeBy$default(filter2, new PlayerInterrupterUIPresenter$13(this), null, new PlayerInterrupterUIPresenter$12(this), 2, null);
    }

    /* renamed from: o.xM$ˋ  reason: contains not printable characters */
    public static final class C0288 {
        private C0288() {
        }

        public /* synthetic */ C0288(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public final String m12803() {
            return xM.f12042;
        }
    }

    static final class iF<T> implements Predicate<xH> {

        /* renamed from: ॱ  reason: contains not printable characters */
        public static final iF f12055 = new iF();

        iF() {
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final boolean test(xH xHVar) {
            C1457Fr.m5025(xHVar, "it");
            return C1457Fr.m5018(xHVar, xH.C0268.f12002);
        }
    }
}

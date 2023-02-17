package o;

import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$5;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$6;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$7;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$8;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$initialObservePlayerEventsToShowAdvisories$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$initialObservePlayerEventsToShowAdvisories$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$observePlayerEventsToShowAdvisoriesWithData$2;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$observePlayerEventsToShowAdvisoriesWithData$3;
import com.netflix.mediaclient.ui.player.v2.presenter.PlayerContentAdvisoryUIPresenter$showAdvisories$3;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.Ref;
import o.xH;
public class xN {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final If f12056 = new If(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Observable<xH> f12057;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Observable<EA> f12058;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final CompositeDisposable f12059 = new CompositeDisposable();

    /* renamed from: ˋ  reason: contains not printable characters */
    private LinkedHashMap<Advisory, Boolean> f12060 = new LinkedHashMap<>();

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f12061 = "INVALID_FROM_AdvisoryUIPresenter";

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f12062;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final AbstractC2336ya f12063;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC2343yh f12064;

    public xN(AbstractC2343yh yhVar, Observable<xH> observable, AbstractC2336ya yaVar, Observable<EA> observable2) {
        C1457Fr.m5025(yhVar, "uiView");
        C1457Fr.m5025(observable, "playerStateEventObservable");
        C1457Fr.m5025(yaVar, "contentAdvisoryRepository");
        C1457Fr.m5025(observable2, "destroyObservable");
        this.f12064 = yhVar;
        this.f12057 = observable;
        this.f12063 = yaVar;
        this.f12058 = observable2;
        Observable<xH> filter = this.f12057.takeUntil(this.f12058).filter(new Predicate<xH>(this) { // from class: o.xN.3

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ xN f12066;

            {
                this.f12066 = r1;
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public final boolean test(xH xHVar) {
                C2279wu r0;
                C1457Fr.m5025(xHVar, "it");
                if (xHVar instanceof xH.Con) {
                    C2279wu r02 = ((xH.Con) xHVar).m12763();
                    if ((!C1457Fr.m5018((Object) (r02 != null ? r02.m12562() : null), (Object) this.f12066.f12061)) && (r0 = ((xH.Con) xHVar).m12763()) != null && !r0.m12550()) {
                        return true;
                    }
                }
                return false;
            }
        });
        C1457Fr.m5016((Object) filter, "playerStateEventObservab…= false\n                }");
        SubscribersKt.subscribeBy$default(filter, PlayerContentAdvisoryUIPresenter$3.f3721, null, new PlayerContentAdvisoryUIPresenter$2(this), 2, null);
        Observable<xH> filter2 = this.f12057.takeUntil(this.f12058).filter(AnonymousClass1.f12065);
        C1457Fr.m5016((Object) filter2, "playerStateEventObservab…lsOnTap\n                }");
        SubscribersKt.subscribeBy$default(filter2, PlayerContentAdvisoryUIPresenter$6.f3723, null, new PlayerContentAdvisoryUIPresenter$5(this), 2, null);
        Observable<xH> takeUntil = this.f12057.takeUntil(this.f12058);
        C1457Fr.m5016((Object) takeUntil, "playerStateEventObservab…eUntil(destroyObservable)");
        SubscribersKt.subscribeBy$default(takeUntil, PlayerContentAdvisoryUIPresenter$8.f3725, null, new PlayerContentAdvisoryUIPresenter$7(this), 2, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final LinkedHashMap<Advisory, Boolean> m12812() {
        return this.f12060;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m12814(LinkedHashMap<Advisory, Boolean> linkedHashMap) {
        C1457Fr.m5025(linkedHashMap, "<set-?>");
        this.f12060 = linkedHashMap;
    }

    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: o.xN$if  reason: invalid class name */
    static final class Cif<T> implements Predicate<xH> {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ xN f12068;

        Cif(xN xNVar) {
            this.f12068 = xNVar;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final boolean test(xH xHVar) {
            C1457Fr.m5025(xHVar, "it");
            return !this.f12068.f12062 && ((xHVar instanceof xH.C0270) || C1457Fr.m5018(xHVar, xH.C0275.f12009) || C1457Fr.m5018(xHVar, xH.C0272.f12006));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12815() {
        Observable<xH> filter = this.f12057.takeUntil(this.f12058).filter(new Cif(this));
        C1457Fr.m5016((Object) filter, "playerStateEventObservab…ipMode)\n                }");
        Observable<R> zipWith = filter.zipWith(this.f12063.mo13314(), C2304iF.f12067);
        C1457Fr.m5016((Object) zipWith, "zipWith(other, BiFunction { t, u -> Pair(t,u) })");
        Observable<R> take = zipWith.take(1);
        C1457Fr.m5016((Object) take, "playerStateEventObservab…\n                .take(1)");
        SubscribersKt.subscribeBy$default(take, PlayerContentAdvisoryUIPresenter$initialObservePlayerEventsToShowAdvisories$3.f3727, null, new PlayerContentAdvisoryUIPresenter$initialObservePlayerEventsToShowAdvisories$2(this), 2, null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12811() {
        CompositeDisposable compositeDisposable = this.f12059;
        Observable<xH> take = this.f12057.takeUntil(this.f12058).filter(new C0290(this)).take(1);
        C1457Fr.m5016((Object) take, "playerStateEventObservab…\n                .take(1)");
        compositeDisposable.add(SubscribersKt.subscribeBy$default(take, PlayerContentAdvisoryUIPresenter$observePlayerEventsToShowAdvisoriesWithData$3.f3729, null, new PlayerContentAdvisoryUIPresenter$observePlayerEventsToShowAdvisoriesWithData$2(this), 2, null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.xN$ˋ  reason: contains not printable characters */
    public static final class C0290<T> implements Predicate<xH> {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ xN f12070;

        C0290(xN xNVar) {
            this.f12070 = xNVar;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final boolean test(xH xHVar) {
            C1457Fr.m5025(xHVar, "it");
            return !this.f12070.f12062 && (C1457Fr.m5018(xHVar, xH.C0270.f12004) || C1457Fr.m5018(xHVar, xH.C0275.f12009) || C1457Fr.m5018(xHVar, xH.C0272.f12006)) && !this.f12070.m12812().isEmpty();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12810() {
        CompositeDisposable compositeDisposable = this.f12059;
        Observable concatMap = Observable.fromIterable(this.f12060.entrySet()).filter(C0289.f12069).concatMap(new C0291(this));
        C1457Fr.m5016((Object) concatMap, "Observable\n             …   })\n\n                })");
        compositeDisposable.add(SubscribersKt.subscribeBy$default(concatMap, PlayerContentAdvisoryUIPresenter$showAdvisories$3.f3730, null, null, 6, null));
    }

    /* renamed from: o.xN$ˊ  reason: contains not printable characters */
    static final class C0289<T> implements Predicate<Map.Entry<? extends Advisory, ? extends Boolean>> {

        /* renamed from: ˎ  reason: contains not printable characters */
        public static final C0289 f12069 = new C0289();

        C0289() {
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final boolean test(Map.Entry<? extends Advisory, Boolean> entry) {
            C1457Fr.m5025(entry, "it");
            return !entry.getValue().booleanValue();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.xN$ᐝ  reason: contains not printable characters */
    public static final class C0291<T, R> implements Function<T, ObservableSource<? extends R>> {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ xN f12071;

        C0291(xN xNVar) {
            this.f12071 = xNVar;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final Observable<Map.Entry<Advisory, Boolean>> apply(Map.Entry<? extends Advisory, Boolean> entry) {
            int i;
            C1457Fr.m5025(entry, "it");
            long delay = (long) (((Advisory) entry.getKey()).getDelay() * 1000.0f);
            long duration = (long) (((Advisory) entry.getKey()).getDuration() * 1000.0f);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f4254 = "";
            if (entry instanceof ExpiringContentAdvisory) {
                ExpiringContentAdvisory.ContentType contentType = ((ExpiringContentAdvisory) entry).contentType;
                if (contentType != null) {
                    switch (xK.f12039[contentType.ordinal()]) {
                        case 1:
                            i = R.string.expiring_content_warning_series;
                            break;
                        case 2:
                            i = R.string.expiring_content_warning_show;
                            break;
                        case 3:
                            i = R.string.expiring_content_warning_season;
                            break;
                    }
                    NetflixApplication instance = NetflixApplication.getInstance();
                    C1457Fr.m5016((Object) instance, "NetflixApplication.getInstance()");
                    T t = (T) instance.getResources().getString(i, ((ExpiringContentAdvisory) entry).localizedDate);
                    C1457Fr.m5016((Object) t, "NetflixApplication.getIn…(label, it.localizedDate)");
                    objectRef.f4254 = t;
                }
                i = R.string.expiring_content_warning_movie;
                NetflixApplication instance = NetflixApplication.getInstance();
                C1457Fr.m5016((Object) instance, "NetflixApplication.getInstance()");
                T t = (T) instance.getResources().getString(i, ((ExpiringContentAdvisory) entry).localizedDate);
                C1457Fr.m5016((Object) t, "NetflixApplication.getIn…(label, it.localizedDate)");
                objectRef.f4254 = t;
            } else if (((Advisory) entry.getKey()).getMessage() != null) {
                T t2 = (T) ((Advisory) entry.getKey()).getMessage();
                C1457Fr.m5016((Object) t2, "it.key.message");
                objectRef.f4254 = t2;
            }
            final String secondaryMessage = ((Advisory) entry.getKey()).getSecondaryMessage() != null ? ((Advisory) entry.getKey()).getSecondaryMessage() : "";
            return Observable.just(entry).delay(delay, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).doOnNext(new Consumer<Map.Entry<? extends Advisory, ? extends Boolean>>(this) { // from class: o.xN.ᐝ.3

                /* renamed from: ˎ  reason: contains not printable characters */
                final /* synthetic */ C0291 f12075;

                {
                    this.f12075 = r1;
                }

                /* renamed from: ˋ  reason: contains not printable characters */
                public final void accept(Map.Entry<? extends Advisory, Boolean> entry2) {
                    C1457Fr.m5025(entry2, "it");
                    C1283.m16854("AdvisoryUIPresenter", "Showing Advisory...");
                    this.f12075.f12071.f12064.mo13336(objectRef.f4254);
                    AbstractC2343yh yhVar = this.f12075.f12071.f12064;
                    String str = secondaryMessage;
                    C1457Fr.m5016((Object) str, "secondaryLabel");
                    yhVar.mo13337(str);
                    this.f12075.f12071.f12064.mo13341(entry2.getKey() instanceof ExpiringContentAdvisory, this.f12075.f12071.f12061);
                }
            }).delay(this.f12071.f12064.mo13340() + duration, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).doOnNext(new Consumer<Map.Entry<? extends Advisory, ? extends Boolean>>(this) { // from class: o.xN.ᐝ.2

                /* renamed from: ˏ  reason: contains not printable characters */
                final /* synthetic */ C0291 f12072;

                {
                    this.f12072 = r1;
                }

                /* renamed from: ˊ  reason: contains not printable characters */
                public final void accept(Map.Entry<? extends Advisory, Boolean> entry2) {
                    C1457Fr.m5025(entry2, "it");
                    this.f12072.f12071.f12064.mo13339(entry2.getKey() instanceof ExpiringContentAdvisory, this.f12072.f12071.f12061);
                    this.f12072.f12071.m12812().put(entry2.getKey(), true);
                }
            });
        }
    }

    /* renamed from: o.xN$iF  reason: case insensitive filesystem */
    public static final class C2304iF<T1, T2, R> implements BiFunction<xH, LinkedHashMap<Advisory, Boolean>, Pair<? extends xH, ? extends LinkedHashMap<Advisory, Boolean>>> {

        /* renamed from: ˎ  reason: contains not printable characters */
        public static final C2304iF f12067 = new C2304iF();

        /* renamed from: ˋ  reason: contains not printable characters */
        public final Pair<xH, LinkedHashMap<Advisory, Boolean>> apply(xH xHVar, LinkedHashMap<Advisory, Boolean> linkedHashMap) {
            return new Pair<>(xHVar, linkedHashMap);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12813() {
        C1283.m16854("AdvisoryUIPresenter", "Cancelling Advisories...");
        this.f12059.clear();
        this.f12064.mo13338();
        this.f12064.mo13079();
        m12811();
    }
}

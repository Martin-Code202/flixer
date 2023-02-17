package o;

import android.view.ViewGroup;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$3;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$4;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$6;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$7;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$8;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$9;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$initRepo$1;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$initRepo$2;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$initRepo$3;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$initRepo$4;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$initRepo$5;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$initRepo$6;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$resetPostPlayTimer$2;
import com.netflix.mediaclient.ui.player.pivots.PivotsPresenter$resetPostPlayTimer$3;
import com.netflix.mediaclient.ui.player.pivots.PivotsUIView;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
/* renamed from: o.xq  reason: case insensitive filesystem */
public final class C2322xq extends AbstractC0385<C2325xt> {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final String f12239 = f12239;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0295 f12240 = new C0295(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final IPlayerFragment f12241;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final PublishSubject<IPlayerFragment.PublisherEvents> f12242;

    /* renamed from: ˊ  reason: contains not printable characters */
    public C2326xu f12243;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Disposable f12244;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Disposable f12245;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final CompositeDisposable f12246;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2322xq(ViewGroup viewGroup, PublishSubject<IPlayerFragment.PublisherEvents> publishSubject, AbstractC2264wf wfVar, IPlayerFragment iPlayerFragment) {
        super(new PivotsUIView(viewGroup, publishSubject, wfVar, iPlayerFragment), new C2325xt(true, PivotsUIView.PivotsListVisibility.HIDE, !iPlayerFragment.mo2255() && C1457Fr.m5018(Config_Ab9454_InPlayerPivots.f1097.m534(), Config_Ab9454_InPlayerPivots.Companion.InitialDisplayExperience.UP_NEXT_BUTTON), true, new ArrayList(), PivotsUIView.PivotsListAssetType.HORIZONTAL_BOX_ART, null, 0, false, 128, null));
        C1457Fr.m5025(viewGroup, "container");
        C1457Fr.m5025(publishSubject, "playerEventsObservable");
        C1457Fr.m5025(wfVar, "bottomPanel");
        C1457Fr.m5025(iPlayerFragment, "player");
        this.f12242 = publishSubject;
        this.f12241 = iPlayerFragment;
        this.f12246 = new CompositeDisposable();
        NetflixActivity netflixActivity = (NetflixActivity) C0345.m13893(viewGroup.getContext(), NetflixActivity.class);
        if (netflixActivity != null) {
            netflixActivity.runWhenManagerIsReady(new NetflixActivity.If(this) { // from class: o.xq.3

                /* renamed from: ˎ  reason: contains not printable characters */
                final /* synthetic */ C2322xq f12247;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.f12247 = r1;
                }

                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    C1457Fr.m5025(phVar, "serviceManager");
                    this.f12247.m12982(new C2326xu(phVar));
                    this.f12247.m12979(this.f12247.m12984(), this.f12247.m12985().mo2267(), this.f12247.m12985().mo2225());
                }
            });
        }
        CompositeDisposable compositeDisposable = this.f12246;
        Observable<IPlayerFragment.PublisherEvents> take = this.f12242.filter(AnonymousClass5.f12249).take(1);
        C1457Fr.m5016((Object) take, "playerEventsObservable\n …\n                .take(1)");
        compositeDisposable.add(SubscribersKt.subscribeBy$default(take, PivotsPresenter$4.f3663, null, new PivotsPresenter$3(this), 2, null));
        CompositeDisposable compositeDisposable2 = this.f12246;
        Observable<IPlayerFragment.PublisherEvents> skip = this.f12242.filter(AnonymousClass4.f12248).skip(1);
        C1457Fr.m5016((Object) skip, "playerEventsObservable\n …\n                .skip(1)");
        compositeDisposable2.add(SubscribersKt.subscribeBy$default(skip, PivotsPresenter$7.f3665, null, new PivotsPresenter$6(this), 2, null));
        this.f12246.add(SubscribersKt.subscribeBy$default(this.f12242, PivotsPresenter$9.f3667, null, new PivotsPresenter$8(this), 2, null));
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final IPlayerFragment m12985() {
        return this.f12241;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m12982(C2326xu xuVar) {
        C1457Fr.m5025(xuVar, "<set-?>");
        this.f12243 = xuVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final C2326xu m12984() {
        C2326xu xuVar = this.f12243;
        if (xuVar == null) {
            C1457Fr.m5017("pivotsRepo");
        }
        return xuVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final CompositeDisposable m12981() {
        return this.f12246;
    }

    /* renamed from: o.xq$ˋ  reason: contains not printable characters */
    public static final class C0295 {
        private C0295() {
        }

        public /* synthetic */ C0295(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final String m12990() {
            return C2322xq.f12239;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m12979(C2326xu xuVar, String str, VideoType videoType) {
        switch (C2324xs.f12254[Config_Ab9454_InPlayerPivots.f1097.m537().ordinal()]) {
            case 1:
                this.f12246.add(SubscribersKt.subscribeBy$default(xuVar.m13004(this.f12241.mo2255()), new PivotsPresenter$initRepo$2(this), null, new PivotsPresenter$initRepo$1(this), 2, null));
                break;
            case 2:
                this.f12246.add(SubscribersKt.subscribeBy$default(xuVar.m13005(str, videoType, this.f12241.mo2255()), new PivotsPresenter$initRepo$4(this), null, new PivotsPresenter$initRepo$3(this), 2, null));
                break;
        }
        this.f12246.add(SubscribersKt.subscribeBy$default(xuVar.m13006(str, this.f12241.mo2255()), new PivotsPresenter$initRepo$6(this), null, new PivotsPresenter$initRepo$5(this), 2, null));
    }

    /* access modifiers changed from: private */
    /* renamed from: ʽ  reason: contains not printable characters */
    public final void m12970() {
        AbstractC0385.m14153(this, m12977(this, false, PivotsUIView.PivotsListVisibility.HIDE, false, false, null, null, null, 0, false, 509, null), null, 2, null);
        C1276.m16820().mo5727(f12240.m12990() + "- Error loading data");
    }

    /* access modifiers changed from: private */
    /* renamed from: ʼ  reason: contains not printable characters */
    public final void m12969() {
        Disposable disposable = this.f12245;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.f12244;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        Observable<IPlayerFragment.PublisherEvents> take = this.f12242.filter(Cif.f12250).take(1);
        C1457Fr.m5016((Object) take, "playerEventsObservable\n …\n                .take(1)");
        this.f12245 = SubscribersKt.subscribeBy$default(take, PivotsPresenter$resetPostPlayTimer$3.f3678, null, new PivotsPresenter$resetPostPlayTimer$2(this), 2, null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.xq$if  reason: invalid class name */
    public static final class Cif<T> implements Predicate<IPlayerFragment.PublisherEvents> {

        /* renamed from: ˋ  reason: contains not printable characters */
        public static final Cif f12250 = new Cif();

        Cif() {
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final boolean test(IPlayerFragment.PublisherEvents publisherEvents) {
            C1457Fr.m5025(publisherEvents, "it");
            return C1457Fr.m5018(publisherEvents, IPlayerFragment.PublisherEvents.ON_SHOW_POST_PLAY_MARK);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ʻ  reason: contains not printable characters */
    public final void m12968() {
        AbstractC0409 r0 = m14155();
        if (r0 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
        }
        CH r9 = ((C2325xt) r0).m13000();
        if (r9 != null) {
            this.f12241.mo2243(new C2279wu(r9.getPlayable(), r9.getType(), new qN(null, qN.f9501, 0, 0), 0));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: o.xq */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ AbstractC0409 m12977(C2322xq xqVar, boolean z, PivotsUIView.PivotsListVisibility pivotsListVisibility, boolean z2, boolean z3, List list, PivotsUIView.PivotsListAssetType pivotsListAssetType, CH ch, int i, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            AbstractC0409 r0 = xqVar.m14155();
            if (r0 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
            }
            z = ((C2325xt) r0).m12993();
        }
        if ((i2 & 2) != 0) {
            AbstractC0409 r02 = xqVar.m14155();
            if (r02 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
            }
            pivotsListVisibility = ((C2325xt) r02).m12995();
        }
        if ((i2 & 4) != 0) {
            AbstractC0409 r03 = xqVar.m14155();
            if (r03 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
            }
            z2 = ((C2325xt) r03).m12996();
        }
        if ((i2 & 8) != 0) {
            AbstractC0409 r04 = xqVar.m14155();
            if (r04 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
            }
            z3 = ((C2325xt) r04).m12998();
        }
        List<CH> list2 = list;
        if ((i2 & 16) != 0) {
            AbstractC0409 r05 = xqVar.m14155();
            if (r05 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
            }
            list2 = ((C2325xt) r05).m12994();
        }
        if ((i2 & 32) != 0) {
            AbstractC0409 r06 = xqVar.m14155();
            if (r06 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
            }
            pivotsListAssetType = ((C2325xt) r06).m12991();
        }
        if ((i2 & 64) != 0) {
            AbstractC0409 r07 = xqVar.m14155();
            if (r07 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
            }
            ch = ((C2325xt) r07).m13000();
        }
        if ((i2 & 128) != 0) {
            AbstractC0409 r08 = xqVar.m14155();
            if (r08 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
            }
            i = ((C2325xt) r08).m12999();
        }
        if ((i2 & 256) != 0) {
            AbstractC0409 r09 = xqVar.m14155();
            if (r09 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.pivots.PivotsUIModel");
            }
            z4 = ((C2325xt) r09).m12992();
        }
        return xqVar.m12983(z, pivotsListVisibility, z2, z3, list2, pivotsListAssetType, ch, i, z4);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final AbstractC0409<C2325xt> m12983(boolean z, PivotsUIView.PivotsListVisibility pivotsListVisibility, boolean z2, boolean z3, List<CH> list, PivotsUIView.PivotsListAssetType pivotsListAssetType, CH ch, int i, boolean z4) {
        C1457Fr.m5025(pivotsListVisibility, "visibility");
        C1457Fr.m5025(list, "videoList");
        C1457Fr.m5025(pivotsListAssetType, "listAssetType");
        return new C2325xt(z, pivotsListVisibility, z2, z3, list, pivotsListAssetType, ch, i, z4);
    }
}

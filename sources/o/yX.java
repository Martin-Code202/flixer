package o;

import android.content.Context;
import android.os.Bundle;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.ui.previews.PreviewsSlideShowUIPresenter$1;
import com.netflix.mediaclient.ui.previews.PreviewsSlideShowUIPresenter$2;
import com.netflix.mediaclient.ui.previews.PreviewsSlideShowUIPresenter$onServiceManagerReady$1;
import com.netflix.mediaclient.ui.previews.PreviewsSlideShowUIPresenter$onServiceManagerReady$2;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import o.C2369ze;
public final class yX extends AbstractC0471 {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0307 f12473 = new C0307(null);

    /* renamed from: ʼ  reason: contains not printable characters */
    private C2059ph f12474;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f12475;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final CompositeDisposable f12476 = new CompositeDisposable();

    /* renamed from: ˎ  reason: contains not printable characters */
    private yZ f12477 = new yZ(null, null, 3, null);

    /* renamed from: ॱ  reason: contains not printable characters */
    private C2366zb f12478;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f12479;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yX(C2369ze zeVar, Bundle bundle, String str) {
        super(zeVar, null, 2, null);
        C1457Fr.m5025(zeVar, "uiView");
        C1457Fr.m5025(str, "listId");
        this.f12479 = str;
        if (bundle != null) {
            yT.f12460.m13281(Integer.valueOf(bundle.getInt("last_preview_item_on_restore")));
        }
        zeVar.mo11047(this.f12477);
        CompositeDisposable compositeDisposable = this.f12476;
        Observable<C0461> onErrorResumeNext = zeVar.m14353().onErrorResumeNext(Observable.just(C2369ze.Cif.C2371iF.f12823));
        C1457Fr.m5016((Object) onErrorResumeNext, "uiView.uiEventObservable…servable.just(NullEvent))");
        compositeDisposable.add(SubscribersKt.subscribeBy$default(onErrorResumeNext, PreviewsSlideShowUIPresenter$2.f3820, null, new PreviewsSlideShowUIPresenter$1(this), 2, null));
    }

    /* renamed from: o.yX$ˋ  reason: contains not printable characters */
    public static final class C0307 extends C1277 {
        private C0307() {
            super("PreviewsSlideShowUIPresenter");
        }

        public /* synthetic */ C0307(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m13309(C2059ph phVar) {
        C1457Fr.m5025(phVar, "serviceManager");
        this.f12478 = new C2366zb(phVar, this.f12479);
        this.f12474 = phVar;
        CompositeDisposable compositeDisposable = this.f12476;
        C2366zb zbVar = this.f12478;
        if (zbVar == null) {
            C1457Fr.m5017("dataRepo");
        }
        Observable<Pair<Status, List<yR>>> onErrorResumeNext = zbVar.m13595().onErrorResumeNext(Observable.just(new Pair(AbstractC0367.f13235, EI.m4805())));
        C1457Fr.m5016((Object) onErrorResumeNext, "dataRepo.fetchFeedList\n …monStatus.OK, listOf())))");
        compositeDisposable.add(SubscribersKt.subscribeBy$default(onErrorResumeNext, PreviewsSlideShowUIPresenter$onServiceManagerReady$2.f3822, null, new PreviewsSlideShowUIPresenter$onServiceManagerReady$1(this), 2, null));
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m13301(C0461 r8) {
        if (r8 instanceof C2369ze.Cif.C0323) {
            C0307 r5 = f12473;
            m13302(((C2369ze.Cif.C0323) r8).m13632());
            m14367().mo13625(new C2369ze.AbstractC0326.C0327(((C2369ze.Cif.C0323) r8).m13632()));
            m13306(((C2369ze.Cif.C0323) r8).m13632());
            this.f12475 = ((C2369ze.Cif.C0323) r8).m13632();
        } else if (r8 instanceof C2369ze.Cif.C0322) {
            C0307 r52 = f12473;
            m13302(((C2369ze.Cif.C0322) r8).m13631());
            if (((C2369ze.Cif.C0322) r8).m13631() < this.f12477.m13312().size() - 1) {
                m14367().mo13625(new C2369ze.AbstractC0326.Cif(((C2369ze.Cif.C0322) r8).m13631() + 1));
            } else {
                m14367().mo13625(C2369ze.AbstractC0326.C0328.f12831);
            }
        } else if (r8 instanceof C2369ze.Cif.If) {
            C0307 r53 = f12473;
        } else if (r8 instanceof C2369ze.Cif.aux) {
            int r54 = ((C2369ze.Cif.aux) r8).m13630() + (((C2369ze.Cif.aux) r8).m13629() == 3 ? -1 : 1);
            C0307 r6 = f12473;
            m14367().mo13625(new C2369ze.AbstractC0326.Cif(r54));
        } else if (r8 instanceof C2369ze.Cif.C0324) {
            m14367().mo13625(new C2369ze.AbstractC0326.iF(((C2369ze.Cif.C0324) r8).m13633()));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m13302(int i) {
        if (m14367() instanceof C2369ze) {
            int size = this.f12477.m13312().size();
            if (i >= (size - 5) - 1) {
                C2366zb zbVar = this.f12478;
                if (zbVar == null) {
                    C1457Fr.m5017("dataRepo");
                }
                zbVar.m13594(size);
            }
        }
    }

    @Override // o.AbstractC0471
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo13308() {
        this.f12476.clear();
    }

    @Override // o.AbstractC0471
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo13307(Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("last_preview_item_on_restore", this.f12475);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m13306(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = i + 1;
        int size = this.f12477.m13312().size();
        if (0 <= i2 && size > i2) {
            arrayList.add(this.f12477.m13312().get(i2));
        }
        int i3 = i - 1;
        if (i3 >= 0) {
            arrayList.add(this.f12477.m13312().get(i3));
        }
        int i4 = i + 2;
        int size2 = this.f12477.m13312().size();
        if (0 <= i4 && size2 > i4) {
            arrayList.add(this.f12477.m13312().get(i4));
        }
        yN yNVar = yN.f12408;
        Context context = m14367().m14352().getContext();
        C1457Fr.m5016((Object) context, "uiView.rootView.context");
        yNVar.m13223(context);
        yN yNVar2 = yN.f12408;
        Context context2 = m14367().m14352().getContext();
        C1457Fr.m5016((Object) context2, "uiView.rootView.context");
        yN.m13222(yNVar2, arrayList, context2, 0, 0, 12, null);
    }
}

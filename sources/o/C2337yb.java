package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.model.leafs.advisory.Advisory;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
/* renamed from: o.yb  reason: case insensitive filesystem */
public final class C2337yb implements AbstractC2336ya {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final PublishSubject<LinkedHashMap<Advisory, Boolean>> f12483;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final NetflixActivity f12484;

    public C2337yb(NetflixActivity netflixActivity) {
        this.f12484 = netflixActivity;
        PublishSubject<LinkedHashMap<Advisory, Boolean>> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<Li…Map<Advisory, Boolean>>()");
        this.f12483 = create;
    }

    /* renamed from: o.yb$ˊ  reason: contains not printable characters */
    public static final class C0309 extends NetflixActivity.If {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ String f12485;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2337yb f12486;

        C0309(C2337yb ybVar, String str) {
            this.f12486 = ybVar;
            this.f12485 = str;
        }

        /* renamed from: o.yb$ˊ$ˊ  reason: contains not printable characters */
        public static final class C0310 extends AbstractC2061pj {

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ C0309 f12487;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C0310(C0309 r1) {
                this.f12487 = r1;
            }

            @Override // o.AbstractC2061pj, o.oU
            public void onAdvisoriesFetched(List<? extends Advisory> list, Status status) {
                C1457Fr.m5025(status, "res");
                super.onAdvisoriesFetched(list, status);
                if (!status.mo301() && list != null && !list.isEmpty()) {
                    PublishSubject publishSubject = this.f12487.f12486.f12483;
                    List<? extends Advisory> list2 = list;
                    LinkedHashMap linkedHashMap = new LinkedHashMap(FF.m4987(ES.m4860(EI.m4812((Iterable) list2, 10)), 16));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        linkedHashMap.put(it.next(), false);
                    }
                    publishSubject.onNext(linkedHashMap);
                }
            }
        }

        @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
        public void run(C2059ph phVar) {
            C1457Fr.m5025(phVar, "serviceManager");
            phVar.m9764().mo9474(this.f12485, new C0310(this));
        }
    }

    @Override // o.AbstractC2336ya
    /* renamed from: ˏ */
    public void mo13315(String str) {
        C1457Fr.m5025(str, "playableId");
        NetflixActivity netflixActivity = this.f12484;
        if (netflixActivity != null) {
            netflixActivity.runWhenManagerIsReady(new C0309(this, str));
        }
    }

    @Override // o.AbstractC2336ya
    /* renamed from: ˏ */
    public Observable<LinkedHashMap<Advisory, Boolean>> mo13314() {
        return this.f12483;
    }
}

package o;

import android.annotation.SuppressLint;
import com.netflix.mediaclient.service.DataRequestQueue$add$1;
import com.netflix.mediaclient.service.DataRequestQueue$add$2;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import io.reactivex.Observable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.ReplaySubject;
import java.util.List;
/* renamed from: o.ᘧ  reason: contains not printable characters */
public final class C0938 {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: ˊ  reason: contains not printable characters */
    private static C2003ng f14818;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static List<NetflixDataRequest> f14819;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final C0938 f14820 = new C0938();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final ReplaySubject<C0938> f14821 = ReplaySubject.create();

    /* renamed from: ॱ  reason: contains not printable characters */
    private static AbstractC1221 f14822;

    private C0938() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final synchronized void m15750(List<NetflixDataRequest> list, C2003ng ngVar, AbstractC1221 r4) {
        C1457Fr.m5025(list, "mslRequests");
        C1457Fr.m5025(ngVar, "resourceFetcher");
        C1457Fr.m5025(r4, "configurationAgent");
        f14819 = list;
        f14818 = ngVar;
        f14822 = r4;
        f14821.onNext(this);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final synchronized boolean m15751(NetflixDataRequest netflixDataRequest) {
        boolean z;
        C1457Fr.m5025(netflixDataRequest, "dataRequest");
        List<NetflixDataRequest> list = f14819;
        C2003ng ngVar = f14818;
        AbstractC1221 r8 = f14822;
        if (list == null || ngVar == null || r8 == null) {
            Observable<C0938> take = f14821.take(1);
            C1457Fr.m5016((Object) take, "instanceObservable\n                .take(1)");
            SubscribersKt.subscribeBy$default(take, DataRequestQueue$add$2.f1059, null, new DataRequestQueue$add$1(netflixDataRequest), 2, null);
            z = true;
        } else if (!(netflixDataRequest instanceof oO) || !r8.mo16508()) {
            z = ngVar.mo6791(netflixDataRequest);
        } else {
            C1283.m16854("DataRequestQueue", "Add MSL request to queue since Crypto initialization is delayed...");
            list.add(netflixDataRequest);
            z = true;
        }
        return z;
    }
}

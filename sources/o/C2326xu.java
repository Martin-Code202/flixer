package o;

import android.util.Pair;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
/* renamed from: o.xu  reason: case insensitive filesystem */
public final class C2326xu {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final String f12265 = f12265;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final If f12266 = new If(null);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final int f12267 = 25;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C2059ph f12268;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final BehaviorSubject<Pair<Status, List<AbstractC2074pw>>> f12269 = BehaviorSubject.create();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final BehaviorSubject<Pair<Status, List<CH>>> f12270 = BehaviorSubject.create();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final BehaviorSubject<Pair<Status, pI>> f12271 = BehaviorSubject.create();

    public C2326xu(C2059ph phVar) {
        C1457Fr.m5025(phVar, "serviceManager");
        this.f12268 = phVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final BehaviorSubject<Pair<Status, List<AbstractC2074pw>>> m13007() {
        return this.f12269;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final BehaviorSubject<Pair<Status, List<CH>>> m13008() {
        return this.f12270;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final BehaviorSubject<Pair<Status, pI>> m13003() {
        return this.f12271;
    }

    /* renamed from: o.xu$ˊ  reason: contains not printable characters */
    public static final class C0297 extends oP {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2326xu f12274;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0297(C2326xu xuVar, String str) {
            super(str);
            this.f12274 = xuVar;
        }

        @Override // o.oP, o.oU
        public void onCWVideosFetched(List<? extends AbstractC2074pw> list, Status status) {
            C1457Fr.m5025(status, "res");
            super.onCWVideosFetched(list, status);
            if (status.mo301()) {
                this.f12274.m13007().onNext(new Pair<>(status, list));
            } else if (list == null || list.isEmpty()) {
                this.f12274.m13007().onNext(new Pair<>(AbstractC0367.f13245, null));
            } else {
                this.f12274.m13007().onNext(new Pair<>(AbstractC0367.f13235, list));
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final Observable<Pair<Status, List<AbstractC2074pw>>> m13004(boolean z) {
        if (!z) {
            this.f12268.m9764().mo9489(0, f12266.m13012(), (String) null, new C0297(this, f12266.m13010()));
        }
        BehaviorSubject<Pair<Status, List<AbstractC2074pw>>> behaviorSubject = this.f12269;
        C1457Fr.m5016((Object) behaviorSubject, "cwListObservable");
        return behaviorSubject;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final Observable<Pair<Status, List<CH>>> m13005(String str, VideoType videoType, boolean z) {
        if (!(str == null || videoType == null || z)) {
            this.f12268.m9764().mo9487(new C0853(str, videoType), new Cif(this, f12266.m13010()));
        }
        BehaviorSubject<Pair<Status, List<CH>>> behaviorSubject = this.f12270;
        C1457Fr.m5016((Object) behaviorSubject, "simListObservable");
        return behaviorSubject;
    }

    /* renamed from: o.xu$if  reason: invalid class name */
    public static final class Cif extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2326xu f12273;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Cif(C2326xu xuVar, String str) {
            super(str);
            this.f12273 = xuVar;
        }

        @Override // o.oP, o.oU
        public void onSimsFetched(List<CH> list, Status status) {
            C1457Fr.m5025(status, "res");
            super.onSimsFetched(list, status);
            if (status.mo301()) {
                this.f12273.m13008().onNext(new Pair<>(status, list));
            } else if (list == null || list.isEmpty()) {
                this.f12273.m13008().onNext(new Pair<>(AbstractC0367.f13245, null));
            } else {
                this.f12273.m13008().onNext(new Pair<>(AbstractC0367.f13235, list));
            }
        }
    }

    /* renamed from: o.xu$iF  reason: case insensitive filesystem */
    public static final class C2327iF extends oP {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2326xu f12272;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2327iF(C2326xu xuVar, String str) {
            super(str);
            this.f12272 = xuVar;
        }

        @Override // o.oP, o.oU
        public void onEpisodeDetailsFetched(pI pIVar, Status status) {
            C1457Fr.m5025(status, "res");
            super.onEpisodeDetailsFetched(pIVar, status);
            if (status.mo301()) {
                this.f12272.m13003().onNext(new Pair<>(status, pIVar));
            } else if (pIVar == null) {
                this.f12272.m13003().onNext(new Pair<>(AbstractC0367.f13245, null));
            } else {
                this.f12272.m13003().onNext(new Pair<>(AbstractC0367.f13235, pIVar));
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final Observable<Pair<Status, pI>> m13006(String str, boolean z) {
        if (str != null && !z) {
            this.f12268.m9764().mo9484(str, null, new C2327iF(this, f12266.m13010()));
        }
        BehaviorSubject<Pair<Status, pI>> behaviorSubject = this.f12271;
        C1457Fr.m5016((Object) behaviorSubject, "nexEpisodeObservable");
        return behaviorSubject;
    }

    /* renamed from: o.xu$If */
    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private final String m13010() {
            return C2326xu.f12265;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final int m13012() {
            return C2326xu.f12267;
        }
    }
}

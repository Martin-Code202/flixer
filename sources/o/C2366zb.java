package o;

import com.netflix.mediaclient.android.app.Status;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
/* renamed from: o.zb  reason: case insensitive filesystem */
public final class C2366zb {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0320 f12779 = new C0320(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final List<yR> f12780 = new ArrayList();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C2059ph f12781;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final PublishSubject<Pair<Status, List<yR>>> f12782 = PublishSubject.create();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f12783;

    public C2366zb(C2059ph phVar, String str) {
        C1457Fr.m5025(phVar, "serviceManager");
        C1457Fr.m5025(str, "listId");
        this.f12781 = phVar;
        this.f12783 = str;
        Integer r0 = yT.f12460.m13282();
        m13592(0, r0 != null ? r0.intValue() : 0);
    }

    /* renamed from: o.zb$ˊ  reason: contains not printable characters */
    public static final class C0320 {
        private C0320() {
        }

        public /* synthetic */ C0320(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final PublishSubject<Pair<Status, List<yR>>> m13595() {
        return this.f12782;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final List<yR> m13593() {
        return this.f12780;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m13592(int i, int i2) {
        yT.f12460.m13285(i);
        yT.f12460.m13283((i2 + 10) - 1);
        oF r0 = this.f12781.m9764();
        if (r0 != null) {
            r0.mo9477(yT.f12460.m13284(), yT.f12460.m13279(), this.f12783, new If(this, "PreviewsRepository"));
        }
    }

    /* renamed from: o.zb$If */
    public static final class If extends oP {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2366zb f12784;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        If(C2366zb zbVar, String str) {
            super(str);
            this.f12784 = zbVar;
        }

        @Override // o.oP, o.oU
        public void onPreviewsFetched(List<pD> list, Status status) {
            C1457Fr.m5025(status, "res");
            super.onPreviewsFetched(list, status);
            if (status.mo301() || list == null) {
                this.f12784.m13595().onError(new IllegalStateException("PreviewsRepository - error in onPreviewsFetched."));
            } else if (list.isEmpty()) {
                this.f12784.m13595().onNext(new Pair<>(status, EI.m4805()));
            } else {
                ArrayList arrayList = new ArrayList();
                for (T t : list) {
                    if (t.getId() != null) {
                        arrayList.add(t);
                    }
                }
                ArrayList<pD> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(EI.m4812((Iterable) arrayList2, 10));
                for (pD pDVar : arrayList2) {
                    arrayList3.add(new yR(pDVar));
                }
                this.f12784.m13593().clear();
                this.f12784.m13593().addAll(arrayList3);
                this.f12784.m13595().onNext(new Pair<>(AbstractC0367.f13235, this.f12784.m13593()));
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m13594(int i) {
        m13592(i, i);
    }
}

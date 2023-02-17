package o;

import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ٮ  reason: contains not printable characters */
public class C0587 extends AbstractRunnableC0373 {
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0587(C0876<?> r1, AbstractC1203 r2) {
        super(r1, r2);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("genreList"));
    }

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋ */
    public Request.Priority mo14117() {
        return Request.Priority.NORMAL;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r3, C0856 r4) {
        r3.mo8534(this.f13290.m15576(), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8534(Collections.emptyList(), status);
    }
}

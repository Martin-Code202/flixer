package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ᔩ  reason: contains not printable characters */
public class C0872 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14741;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f14742;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0872(C0876<?> r2, int i, AbstractC1203 r4) {
        super(r2, r4);
        this.f14741 = i;
        this.f14742 = i + 29;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public boolean mo14121(List<C0859> list) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("watchHistory", C0859.m15532(this.f14741, this.f14742), C0859.m15523("summary", "detail", "bookmark", "tvCardArt")));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r4, C0856 r5) {
        r4.mo8519(this.f13290.m15255(r5.f14697), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8519(Collections.emptyList(), status);
    }
}

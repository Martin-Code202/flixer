package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import java.util.Collections;
import java.util.List;
/* renamed from: o.າ  reason: contains not printable characters */
public class C0710 extends AbstractRunnableC0373 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f14235;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14236;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14237;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0710(C0876<?> r1, String str, int i, int i2, AbstractC1203 r5) {
        super(r1, r5);
        this.f14237 = str;
        this.f14236 = i;
        this.f14235 = i2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("topGenres", this.f14237, C0859.m15532(this.f14236, this.f14235), "summary"));
        list.add(C0859.m15528("topGenres", this.f14237, C0859.m15532(this.f14236, this.f14235), C0859.m15519(uH.m11414(m14132(), LoMoType.STANDARD) - 1), "summary"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r5, C0856 r6) {
        r5.mo8535(this.f13290.m15580(this.f14236, r6.f14697), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8535(Collections.emptyList(), status);
    }
}

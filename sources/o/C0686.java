package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.List;
/* renamed from: o.บ  reason: contains not printable characters */
public class C0686 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14175;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean f14176;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0686(C0876<?> r1, int i, boolean z, AbstractC1203 r4) {
        super(r1, r4);
        this.f14175 = i;
        this.f14176 = z;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱॱ */
    public boolean mo14131() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ʻ */
    public boolean mo14110() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("nonMemberVideos", C0859.m15519(this.f14175), C0859.m15523("summary", "detail")));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r4, C0856 r5) {
        if (!this.f14176 || r4 == null) {
            mV.m8965(m14132());
        } else {
            r4.mo7398(this.f13290.m15255(r5.f14697), AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        if (r2 != null) {
            r2.mo7398(Collections.emptyList(), status);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋॱ */
    public boolean mo14118() {
        return this.f14176;
    }
}

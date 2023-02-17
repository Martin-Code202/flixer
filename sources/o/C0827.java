package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.List;
/* renamed from: o.ᓗ  reason: contains not printable characters */
public class C0827 extends AbstractRunnableC0373 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f14628;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14629;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final VideoType f14630;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0827(C0876<?> r1, VideoType videoType, String str, String str2, AbstractC1203 r5) {
        super(r1, r5);
        this.f14630 = videoType;
        this.f14629 = str;
        this.f14628 = str2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0506.m14494(this.f14630.getValue(), this.f14629, this.f14628));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r7, C0856 r8) {
        CA ca = (CA) this.f13290.m15584(C0506.m14494(this.f14630.getValue(), this.f14629, this.f14628));
        int r5 = ca == null ? 0 : ca.m4168();
        C1283.m16854("CmpTask", String.format("FetchScenePositionTask rtn: %s", ca));
        r7.mo8536(r5, AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8536(-1, status);
    }
}

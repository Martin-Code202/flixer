package o;

import android.text.TextUtils;
import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.List;
/* renamed from: o.ɬ  reason: contains not printable characters */
public abstract class AbstractC0380 extends AbstractC0502 {

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0902 f13327;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean f13328;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f13329;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public AbstractC0380(C0876<?> r1, AbstractC0948 r2, C0902 r3, String str, boolean z, AbstractC1203 r6) {
        super(r1, r2, r6);
        this.f13329 = str;
        this.f13328 = z;
        this.f13327 = r3;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋ */
    public Request.Priority mo14117() {
        return this.f13328 ? Request.Priority.LOW : super.mo14117();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public void mo14122() {
        super.mo14122();
        if (!TextUtils.isEmpty(this.f13329) && this.f13328) {
            C1283.m16851("BaseFetchDetailsTask", "Prefetch DP request in-flight for %s ", this.f13329);
            qX.m10002(this.f13329);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public Object mo14126() {
        return qX.m10005();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        if (!this.f13328) {
            qX.m10009(this.f13329);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r1, C0856 r2) {
        m14142();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r1, Status status) {
        m14142();
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final void m14142() {
        if (!TextUtils.isEmpty(this.f13329) && this.f13328) {
            C1283.m16851("BaseFetchDetailsTask", "Prefetch DP request in-flight for %s completed", this.f13329);
            qX.m10014(this.f13329);
            this.f13327.m15645();
        }
    }
}

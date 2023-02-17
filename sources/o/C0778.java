package o;

import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ᒐ  reason: contains not printable characters */
public class C0778 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14425;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final CmpTaskMode f14426;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C0859 f14427;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0778(C0876<?> r1, String str, CmpTaskMode cmpTaskMode, AbstractC1203 r4) {
        super(r1, r4);
        this.f14425 = str;
        this.f14426 = cmpTaskMode;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("shows", this.f14425, "seasons", "summary"));
        this.f14427 = C0506.m14513(Collections.singletonList(this.f14425));
        list.add(this.f14427);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋॱ */
    public boolean mo14118() {
        return this.f14426 == CmpTaskMode.FROM_CACHE_ONLY;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return this.f14426 == CmpTaskMode.FROM_NETWORK;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r4, C0856 r5) {
        r4.mo8518(this.f13290.mo15259(this.f14427), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8518(Collections.emptyList(), status);
    }
}

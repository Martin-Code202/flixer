package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.List;
/* renamed from: o.ע  reason: contains not printable characters */
public class C0562 extends AbstractC0502 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f13805;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f13806;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0562(C0876<?> r1, AbstractC0948 r2, String str, String str2, AbstractC1203 r5) {
        super(r1, r2, r5);
        this.f13806 = str;
        this.f13805 = str2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("episodes", this.f13806, C0859.m15523("detail", "summary", "bookmark", "offlineAvailable", "rating")));
        list.add(C0859.m15528("episodes", this.f13806, "watchNext", C0859.m15523("detail", "summary", "bookmark", "offlineAvailable", "rating")));
        if (C1349Bv.m4107(this.f13805)) {
            list.add(C0506.m14494(VideoType.EPISODE.getValue(), this.f13806, this.f13805));
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r7, C0856 r8) {
        pI pIVar = (pI) this.f13290.mo15251(C0859.m15528("episodes", this.f13806));
        if (pIVar != null && (pIVar instanceof CH)) {
            m14483(this.f13806, ((CH) pIVar).getBookmark());
        }
        r7.mo6203(pIVar, AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo6203((pI) null, status);
    }
}

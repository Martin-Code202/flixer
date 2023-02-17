package o;

import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ڈ  reason: contains not printable characters */
public class C0598 extends AbstractC0502 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final List<C0859> f13890 = C0506.f13639;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f13891;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final CmpTaskMode f13892;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f13893;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f13894;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final VideoType f13895;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0598(C0876<?> r1, AbstractC0948 r2, String str, CmpTaskMode cmpTaskMode, VideoType videoType, int i, int i2, AbstractC1203 r8) {
        super(r1, r2, r8);
        this.f13893 = str;
        this.f13892 = cmpTaskMode;
        this.f13895 = videoType;
        this.f13891 = i;
        this.f13894 = i2;
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
        list.add(C0859.m15528(this.f13895.getValue(), this.f13893, "episodes", C0859.m15532(this.f13891, this.f13894), f13890));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋॱ */
    public boolean mo14118() {
        return this.f13892 == CmpTaskMode.FROM_CACHE_ONLY;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return this.f13892 == CmpTaskMode.FROM_NETWORK;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r7, C0856 r8) {
        List<pI> r2 = this.f13290.m15255(r8.f14697);
        if (r2 != null) {
            for (pI pIVar : r2) {
                if (pIVar != null && (pIVar instanceof CH)) {
                    CH ch = (CH) pIVar;
                    m14483(ch.getPlayable().getPlayableId(), ch.getBookmark());
                }
            }
        }
        r7.mo7347(r2, AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo7347(Collections.emptyList(), status);
    }
}

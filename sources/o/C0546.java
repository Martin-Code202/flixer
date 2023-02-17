package o;

import android.text.TextUtils;
import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.List;
/* renamed from: o.א  reason: contains not printable characters */
public class C0546 extends AbstractC0502 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final CmpTaskMode f13757;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f13758;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f13759;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f13760;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0546(C0876<?> r1, AbstractC0948 r2, int i, int i2, String str, CmpTaskMode cmpTaskMode, AbstractC1203 r7) {
        super(r1, r2, r7);
        this.f13759 = i;
        this.f13758 = i2;
        this.f13760 = str;
        this.f13757 = cmpTaskMode;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        C0506.m14498(list, this.f13760, this.f13290.m15575(), this.f13759, this.f13758, true);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        C0859 r3;
        if (TextUtils.isEmpty(this.f13760)) {
            r3 = C0859.m15528("lolomo", "continueWatching", C0859.m15532(this.f13759, this.f13758), "summary");
        } else {
            r3 = C0859.m15528("lists", this.f13760, C0859.m15532(this.f13759, this.f13758), "summary");
        }
        List<AbstractC2074pw> r4 = this.f13290.mo15259(r3);
        r6.mo7395(r4, AbstractC0367.f13235);
        m14587(m14485(), r4);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14587(BookmarkStore bookmarkStore, List<AbstractC2074pw> list) {
        if (bookmarkStore != null) {
            bookmarkStore.onCWVideosFetched(list, m14482());
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo7395(Collections.emptyList(), status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋॱ */
    public boolean mo14118() {
        return this.f13757 == CmpTaskMode.FROM_CACHE_ONLY;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return this.f13757 == CmpTaskMode.FROM_NETWORK;
    }
}

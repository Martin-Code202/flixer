package o;

import android.text.TextUtils;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ᓺ  reason: contains not printable characters */
public class C0849 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f14683;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14684;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f14685;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0849(C0876<?> r1, int i, int i2, String str, AbstractC1203 r5) {
        super(r1, r5);
        this.f14684 = i;
        this.f14685 = i2;
        this.f14683 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        C0506.m14511(list, this.f13290.m15575(), this.f14683, this.f14684, this.f14685, true);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        C0859 r3;
        if (TextUtils.isEmpty(this.f14683)) {
            r3 = C0859.m15528("lolomo", "shortForm", C0859.m15532(this.f14684, this.f14685), "summary");
        } else {
            r3 = C0859.m15528("lists", this.f14683, C0859.m15532(this.f14684, this.f14685), "summary");
        }
        r6.mo8539(this.f13290.mo15259(r3), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8539(Collections.emptyList(), status);
    }
}

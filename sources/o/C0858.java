package o;

import com.netflix.mediaclient.android.app.Status;
import java.util.List;
/* renamed from: o.ᔃ  reason: contains not printable characters */
public class C0858 extends AbstractC0380 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14703;

    public C0858(C0876<?> r1, AbstractC0948 r2, C0902 r3, String str, boolean z, AbstractC1203 r6) {
        super(r1, r2, r3, str, z, r6);
        this.f14703 = str;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ᐝ */
    public void mo14133() {
        this.f13290.m15254(C0859.m15528("characters", this.f14703, "watchNext"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        super.mo14127(list);
        list.add(C0859.m15528("characters", this.f14703, C0859.m15523("summary", "detail")));
        list.add(C0859.m15528("characters", this.f14703, "watchNext", C0859.m15523("summary", "detail", "bookmark", "offlineAvailable")));
        list.add(C0859.m15528("characters", this.f14703, "gallery", "summary"));
        list.add(C0506.m14506(this.f14703));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        super.mo14114(r6, r7);
        r6.mo8532((pL) this.f13290.m15584(C0859.m15528("characters", this.f14703)), true, AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r3, Status status) {
        super.mo14128(r3, status);
        r3.mo8532(null, false, status);
    }
}

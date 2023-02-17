package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ᔂ  reason: contains not printable characters */
public class C0857 extends AbstractC0454 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14700;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f14701;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f14702;

    public C0857(String str, int i, int i2) {
        this.f14702 = str;
        this.f14700 = i;
        this.f14701 = i2;
    }

    @Override // o.AbstractC0487
    /* renamed from: ˊ */
    public void mo14421(List<C0859> list) {
        list.add(C0859.m15528("trailersFeed", C0859.m15532(this.f14700, this.f14701), "video", C0859.m15523("summary", "detail", "inQueue")));
        list.add(C0859.m15528("trailersFeed", C0859.m15532(this.f14700, this.f14701), "supplemental", C0859.m15523("summary", "detail")));
        list.add(C0859.m15528("trailersFeed", C0859.m15532(this.f14700, this.f14701), "detail"));
        if (C0682.m14929()) {
            list.add(C0859.m15528("trailersFeed", C0859.m15532(this.f14700, this.f14701), "tags"));
        }
        list.add(C0859.m15528("trailersFeed", "summary"));
    }

    @Override // o.AbstractC0487
    /* renamed from: ॱ */
    public void mo14423(C0498 r7, AbstractC1203 r8, C0856 r9) {
        r8.mo8520((TrailersFeedItemSummary) r7.f13290.mo15251(C0859.m15528("trailersFeed", "summary")), r7.f13290.mo15259(C0859.m15528("trailersFeed", C0859.m15532(this.f14700, this.f14701))), AbstractC0367.f13235);
    }

    @Override // o.AbstractC0487
    /* renamed from: ˋ */
    public void mo14422(AbstractC1203 r3, Status status) {
        r3.mo8520(null, Collections.emptyList(), status);
    }

    @Override // o.AbstractC0454, o.AbstractC0487
    /* renamed from: ˎ */
    public boolean mo14339(List<C0859> list) {
        return true;
    }
}

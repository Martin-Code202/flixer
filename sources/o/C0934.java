package o;

import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.ArrayList;
import java.util.List;
import o.AB;
/* renamed from: o.ᘤ  reason: contains not printable characters */
public class C0934 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f14814;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14815;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14816;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0934(C0876<?> r1, String str, VideoType videoType, String str2, String str3, AbstractC1203 r6) {
        super(r1, r6);
        this.f14815 = str;
        this.f14816 = str2;
        this.f14814 = str3;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋ */
    public Request.Priority mo14117() {
        return Request.Priority.LOW;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("videos", this.f14815, "postPlayImpression"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new AB.If("impressionData", this.f14816));
        arrayList.add(new AB.If("impressionToken", this.f14814));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r3, C0856 r4) {
        r3.mo8521(true, (Status) AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8521(false, status);
    }
}

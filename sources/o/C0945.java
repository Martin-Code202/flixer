package o;

import com.android.volley.Request;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.ArrayList;
import java.util.List;
import o.AB;
/* renamed from: o.ᴈ  reason: contains not printable characters */
public class C0945 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14843;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14844;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public <T extends AbstractC0730> C0945(C0876<?> r1, String str, String str2, AbstractC1203 r4) {
        super(r1, r4);
        this.f14843 = str;
        this.f14844 = str2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528("prePlay", this.f14843, "prePlayImpression"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˋ */
    public Request.Priority mo14117() {
        return Request.Priority.LOW;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new AB.If("impressionData", this.f14844));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r3, C0856 r4) {
        r3.mo8533(true, (Status) AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8533(false, status);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ͺ */
    public boolean mo14125() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊॱ */
    public boolean mo14116() {
        return true;
    }
}

package o;

import com.android.volley.VolleyError;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.volley.StatusCodeError;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.ArrayList;
import java.util.List;
import o.AB;
/* renamed from: o.ᔮ  reason: contains not printable characters */
public class C0877 extends AbstractRunnableC0373 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final boolean f14757;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final VideoType f14758;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14759;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0877(C0876<?> r1, VideoType videoType, String str, boolean z, AbstractC1203 r5) {
        super(r1, r5);
        this.f14758 = videoType;
        this.f14759 = str;
        this.f14757 = z;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528(this.f14758.getValue(), this.f14759, "hideViewing"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public boolean mo14115() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new AB.If("param", this.f14759));
        arrayList.add(new AB.If("param", String.valueOf(this.f14757)));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public VolleyError mo14119(JsonObject jsonObject) {
        String r2 = C0848.m15514(jsonObject, "CmpTask");
        if (C0848.m15505(r2)) {
            return new StatusCodeError(StatusCode.NOT_IN_QUEUE);
        }
        return new FalkorException(r2);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r2, C0856 r3) {
        r2.mo8527(AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r1, Status status) {
        r1.mo8527(status);
    }
}

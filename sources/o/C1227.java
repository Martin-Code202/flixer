package o;

import com.android.volley.VolleyError;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.webclient.volley.StatusCodeError;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.ArrayList;
import java.util.List;
import o.AB;
/* renamed from: o.ｆ  reason: contains not printable characters */
public class C1227 extends AbstractRunnableC0373 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f15747;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f15748;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f15749;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f15750;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final VideoType f15751;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f15752;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final boolean f15753;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C1227(C0876<?> r2, String str, VideoType videoType, String str2, String str3, String str4, String str5, AbstractC1203 r9) {
        super(r2, r9);
        this.f15750 = str;
        this.f15751 = videoType;
        this.f15752 = str2;
        this.f15749 = str3;
        this.f15747 = str4;
        this.f15748 = str5;
        this.f15753 = C1349Bv.m4107(str3);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        if (this.f15753) {
            list.add(C0859.m15528("lolomos", this.f15752, "remove"));
        } else {
            list.add(C0859.m15528(this.f15751.getValue(), this.f15750, "removeFromQueue"));
        }
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
        ArrayList arrayList = new ArrayList(8);
        if (this.f15753) {
            m16566();
            String format = String.format("['%s','%s']", this.f15751.getValue(), this.f15750);
            String format2 = String.format("[{'from':%d,'to':%d}]", Integer.valueOf(this.f13290.m15250()), Integer.valueOf(this.f13290.m15248()));
            arrayList.add(new AB.If("param", this.f15747));
            arrayList.add(new AB.If("param", format));
            arrayList.add(new AB.If("pathSuffix", format2));
            arrayList.add(new AB.If("pathSuffix", "['summary']"));
        }
        if (C1349Bv.m4107(this.f15748)) {
            arrayList.add(new AB.If("signature", this.f15748));
        }
        return arrayList;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m16566() {
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
    public void mo14114(AbstractC1203 r5, C0856 r6) {
        C1283.m16846("CmpTask", "Remove from queue was successful");
        if (this.f15753) {
            this.f13290.m15254(C0859.m15528("lists", this.f15749));
        }
        C2059ph.m9734(m14132(), LoMoType.INSTANT_QUEUE.m1575());
        C1362Ch.m4406(IClientLogging.CompletionReason.success, (UIError) null);
        r5.mo8524(AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r5, Status status) {
        String str;
        if (status.mo302() == StatusCode.NOT_IN_QUEUE) {
            C1283.m16846("CmpTask", "Remove from queue failed - video was not in queue");
            str = m14132().getString(R.string.label_ok_remove_from_my_list_deep_link);
        } else {
            C1283.m16846("CmpTask", "Remove from queue failed - general error");
            str = m14132().getString(R.string.label_error_remove_from_list_deep_link);
        }
        C1362Ch.m4406(IClientLogging.CompletionReason.failed, AbstractC1358Cd.m4353(status, str, ActionOnUIError.displayedError));
        r5.mo8524(status);
    }
}

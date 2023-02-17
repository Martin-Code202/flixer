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
/* renamed from: o.υ  reason: contains not printable characters */
public class C0466 extends AbstractC0502 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f13510;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f13511;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f13512;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f13513;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final boolean f13514;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final VideoType f13515;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f13516;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f13517;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0466(C0876<?> r2, AbstractC0948 r3, String str, VideoType videoType, String str2, String str3, String str4, int i, String str5, AbstractC1203 r11) {
        super(r2, r3, r11);
        this.f13513 = str;
        this.f13515 = videoType;
        this.f13516 = str2;
        this.f13510 = str3;
        this.f13517 = str4;
        this.f13511 = String.valueOf(i);
        this.f13512 = str5;
        this.f13514 = C1349Bv.m4107(str3);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        if (this.f13514) {
            list.add(C0859.m15528("lolomos", this.f13516, "add"));
        } else {
            list.add(C0859.m15528(this.f13515.getValue(), this.f13513, "addToQueue"));
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
        if (this.f13514) {
            m14351();
            String format = String.format("'%s'", this.f13510);
            String format2 = String.format("['%s','%s']", this.f13515.getValue(), this.f13513);
            String format3 = String.format("[{'from':%d,'to':%d}]", Integer.valueOf(this.f13290.m15250()), Integer.valueOf(this.f13290.m15248()));
            arrayList.add(new AB.If("param", format));
            arrayList.add(new AB.If("param", this.f13517));
            arrayList.add(new AB.If("param", format2));
            arrayList.add(new AB.If("param", this.f13511));
            arrayList.add(new AB.If("pathSuffix", format3));
            arrayList.add(new AB.If("pathSuffix", "['summary']"));
        } else {
            arrayList.add(new AB.If("param", this.f13511));
        }
        if (C1349Bv.m4107(this.f13512)) {
            arrayList.add(new AB.If("signature", this.f13512));
        }
        return arrayList;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m14351() {
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public VolleyError mo14119(JsonObject jsonObject) {
        String r2 = C0848.m15514(jsonObject, "AddToQueueTask");
        if (C0848.m15507(r2)) {
            C1283.m16846("AddToQueueTask", "Video already in queue");
            return new StatusCodeError(StatusCode.ALREADY_IN_QUEUE);
        } else if (!C0848.m15510(r2)) {
            return new FalkorException(r2);
        } else {
            C1283.m16846("AddToQueueTask", "Add to Queue Request not valid");
            return new StatusCodeError(StatusCode.NOT_VALID);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r7, C0856 r8) {
        C1283.m16846("AddToQueueTask", "Add to queue was successful");
        boolean z = C1349Bv.m4107(this.f13516) && !this.f13514;
        if (this.f13514) {
            this.f13290.m15254(C0859.m15528("lists", this.f13510));
        }
        C2059ph.m9734(m14132(), LoMoType.INSTANT_QUEUE.m1575());
        C1362Ch.m4401(IClientLogging.CompletionReason.success, (UIError) null, (Integer) null);
        r7.mo8537(AbstractC0367.f13235);
        if (z) {
            C1283.m16854("AddToQueueTask", "addToQueue new user case");
            AbstractC1899j r5 = m14484();
            if (r5 != null) {
                r5.mo7815((String) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r5, Status status) {
        String str;
        if (status.mo302() == StatusCode.ALREADY_IN_QUEUE) {
            C1283.m16846("AddToQueueTask", "Add to queue failed - video already in queue");
            str = m14132().getString(R.string.label_warning_add_to_my_list_deep_link_title_exist);
        } else {
            C1283.m16846("AddToQueueTask", "Add to queue failed - general error");
            str = m14132().getString(R.string.label_error_add_to_my_list_deep_link);
        }
        C1362Ch.m4401(IClientLogging.CompletionReason.failed, AbstractC1358Cd.m4353(status, str, ActionOnUIError.displayedError), (Integer) null);
        r5.mo8537(status);
    }
}

package o;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.falkor.FalkorAgentStatus;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.PrePlayExperiences;
import java.util.List;
/* renamed from: o.ᒍ  reason: contains not printable characters */
public class C0773 extends AbstractC0380 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14414;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final VideoType f14415;

    public C0773(C0876<?> r8, AbstractC0948 r9, C0902 r10, String str, VideoType videoType, AbstractC1203 r13) {
        super(r8, r9, r10, str, false, r13);
        this.f14414 = str;
        this.f14415 = videoType;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        super.mo14127(list);
        C0859 r3 = C0859.m15528(this.f14415.getValue(), this.f14414, "prePlay");
        list.add(r3);
        this.f13290.m15254(r3);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        super.mo14114(r6, r7);
        CH ch = (CH) this.f13290.mo15251(C0859.m15528(this.f14415.getValue(), this.f14414, "prePlay"));
        r6.mo8529(ch != null ? ch.getPreplayExperiences() : null, new FalkorAgentStatus(StatusCode.OK, m14129()));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        super.mo14128(r2, status);
        r2.mo8529((PrePlayExperiences) null, status);
    }
}

package o;

import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.falkor.FalkorAgentStatus;
import java.util.Collections;
import java.util.List;
/* renamed from: o.ᓻ  reason: contains not printable characters */
public class C0850 extends AbstractC0380 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C0859 f14686;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f14687;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14688;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14689;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final boolean f14690;

    public C0850(C0876<?> r8, AbstractC0948 r9, C0902 r10, String str, String str2, boolean z, boolean z2, boolean z3, AbstractC1203 r16) {
        super(r8, r9, r10, str, z3, r16);
        this.f14689 = str;
        this.f14688 = str2;
        this.f14690 = z;
        this.f14687 = z2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        super.mo14127(list);
        List singletonList = Collections.singletonList(this.f14689);
        C0506.m14499(list, singletonList, this.f14688, this.f14690, this.f14687, C0881.m15600(NetflixApplication.getInstance()));
        this.f14686 = C0506.m14513(singletonList);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public boolean mo14121(List<C0859> list) {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r7, C0856 r8) {
        super.mo14114(r7, r8);
        pR pRVar = (pR) this.f13290.m15584(C0859.m15528("shows", this.f14689));
        if (this.f14690) {
            r7.mo7346(pRVar, this.f13290.mo15259(this.f14686), new FalkorAgentStatus(StatusCode.OK, m14129()));
        } else {
            r7.mo8175(pRVar, new FalkorAgentStatus(StatusCode.OK, m14129()));
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0380, o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r3, Status status) {
        super.mo14128(r3, status);
        if (this.f14690) {
            r3.mo7346(null, null, status);
        } else {
            r3.mo8175((pR) null, status);
        }
    }
}

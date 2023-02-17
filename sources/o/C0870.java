package o;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.falkor.FalkorAgentStatus;
import java.util.List;
/* renamed from: o.ᔦ  reason: contains not printable characters */
public class C0870 extends AbstractC0454 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean f14738;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f14739;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14740;

    public C0870(String str, boolean z) {
        this.f14740 = str;
        this.f14738 = z;
        this.f14739 = z ? "movies" : "shows";
    }

    @Override // o.AbstractC0454, o.AbstractC0487
    /* renamed from: ˊ */
    public boolean mo14335() {
        return true;
    }

    @Override // o.AbstractC0487
    /* renamed from: ˊ */
    public void mo14421(List<C0859> list) {
        C0506.m14512(list, this.f14740, this.f14738);
    }

    @Override // o.AbstractC0487
    /* renamed from: ॱ */
    public void mo14423(C0498 r7, AbstractC1203 r8, C0856 r9) {
        CH ch = (CH) r7.f13290.m15584(C0859.m15528(this.f14739, this.f14740));
        if (ch == null || C1349Bv.m4113(ch.getId())) {
            String str = "SPY-12098: FetchVideoVolatileNodesTask bad " + this.f14739 + " id. Requested: " + this.f14740 + ", got: " + (ch == null ? "rtn=null" : ch.getId());
            C1276.m16820().mo5725(str);
            C1283.m16850("FetchVideoVolatileNodesTask", str);
            r8.mo6200((pP) null, new FalkorAgentStatus(StatusCode.INT_ERR_CMP_RESP_NULL, false));
            return;
        }
        r7.m14483(this.f14740, ch.getBookmark());
        if (this.f14738) {
            r8.mo6200((pP) ch, new FalkorAgentStatus(StatusCode.OK, false));
        } else {
            r8.mo8175((pR) ch, new FalkorAgentStatus(StatusCode.OK, false));
        }
    }

    @Override // o.AbstractC0487
    /* renamed from: ˋ */
    public void mo14422(AbstractC1203 r2, Status status) {
        if (this.f14738) {
            r2.mo6200((pP) null, status);
        } else {
            r2.mo8175((pR) null, status);
        }
    }
}

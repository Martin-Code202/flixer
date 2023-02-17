package o;

import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
/* renamed from: o.cC  reason: case insensitive filesystem */
public class C1581cC {

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC1221 f6210;

    /* renamed from: ˏ  reason: contains not printable characters */
    private UserAgentInterface f6211;

    public C1581cC(AbstractC1221 r1, UserAgentInterface userAgentInterface) {
        this.f6210 = r1;
        this.f6211 = userAgentInterface;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public NetflixDataRequest m5812(String str, String str2, C1632cx cxVar, AbstractC1634cz czVar) {
        if (this.f6210.mo16511()) {
            return AX.m3489(this.f6211, str, new C1631cw(str2, cxVar, czVar), false);
        }
        return BK.m3874(this.f6211, str, new C1633cy(str2, cxVar, czVar), false);
    }
}

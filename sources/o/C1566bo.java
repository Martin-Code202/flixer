package o;

import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
/* renamed from: o.bo  reason: case insensitive filesystem */
public final class C1566bo {

    /* renamed from: ˊ  reason: contains not printable characters */
    private UserAgentInterface f6165;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1221 f6166;

    public C1566bo(AbstractC1221 r1, UserAgentInterface userAgentInterface) {
        this.f6166 = r1;
        this.f6165 = userAgentInterface;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public NetflixDataRequest m5793(String str, String str2, String str3, AbstractC1562bk bkVar) {
        if (this.f6166.mo16511()) {
            return AX.m3489(this.f6165, str, new C1565bn(str2, str3, bkVar), false);
        }
        return BK.m3874(this.f6165, str, new C1574bw(str2, str3, bkVar), false);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public NetflixDataRequest m5792(String str, String str2, String str3, AbstractC1562bk bkVar) {
        if (this.f6166.mo16511()) {
            return AX.m3489(this.f6165, str, new C1569br(str2, str3, bkVar), true);
        }
        return BK.m3874(this.f6165, str, new C1567bp(str2, str3, bkVar), true);
    }
}

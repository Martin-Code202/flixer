package o;

import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
/* renamed from: o.ap  reason: case insensitive filesystem */
public final class C1511ap {

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1221 f6048;

    public C1511ap(AbstractC1221 r1) {
        this.f6048 = r1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public NetflixDataRequest m5630(String str, AbstractC1505aj ajVar) {
        if (this.f6048.mo16511()) {
            return new C1512aq(str, ajVar);
        }
        return new C1513ar(str, ajVar);
    }
}

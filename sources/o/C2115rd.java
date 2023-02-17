package o;

import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.List;
import o.AbstractC0801;
/* renamed from: o.rd  reason: case insensitive filesystem */
public class C2115rd extends C2119rh {

    /* renamed from: ᐝ  reason: contains not printable characters */
    private List<pI> f9821;

    public C2115rd(NetflixActivity netflixActivity, C2116re reVar, AbstractC0801.Cif ifVar) {
        super(netflixActivity, reVar, ifVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2119rh
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo10349(List<pI> list, int i) {
        if (!(this.f9885 instanceof C2117rf)) {
            this.f9821 = list;
            super.mo10349(list, i);
        } else if (((C2117rf) this.f9885).m10415()) {
            this.f9821 = list;
            super.mo10349(list, i);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public List<pI> m10348() {
        return this.f9821;
    }
}

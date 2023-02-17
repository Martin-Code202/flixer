package o;
public class DY extends AbstractC1412Ec {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f5397;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1411Eb f5398;

    public DY(C1411Eb eb, String str) {
        super(C1410Ea.f5515);
        this.f5398 = eb;
        this.f5397 = str;
    }

    @Override // o.AbstractC1412Ec
    /* renamed from: ˊ */
    public C1405Dv mo4701(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("useridtoken", dq.mo3176(this.f5398.mo3114(dq, dx)));
        r2.mo4754("profileguid", this.f5397);
        return r2;
    }

    @Override // o.AbstractC1412Ec
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DY)) {
            return false;
        }
        DY dy = (DY) obj;
        return super.equals(obj) && this.f5398.equals(dy.f5398) && this.f5397.equals(dy.f5397);
    }

    @Override // o.AbstractC1412Ec
    public int hashCode() {
        return (super.hashCode() ^ this.f5398.hashCode()) ^ this.f5397.hashCode();
    }
}

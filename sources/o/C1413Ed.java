package o;

import com.netflix.msl.MslInternalException;
/* renamed from: o.Ed  reason: case insensitive filesystem */
public class C1413Ed extends AbstractC1412Ec {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final DV f5531;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C1411Eb f5532;

    public C1413Ed(DV dv, C1411Eb eb) {
        super(C1416Eg.f5534);
        if (!eb.m4871(dv)) {
            throw new MslInternalException("User ID token must be bound to master token.");
        }
        this.f5531 = dv;
        this.f5532 = eb;
    }

    @Override // o.AbstractC1412Ec
    /* renamed from: ˊ */
    public C1405Dv mo4701(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("mastertoken", this.f5531);
        r2.mo4754("useridtoken", this.f5532);
        return dq.mo3176(dq.mo3178(r2, dx));
    }

    @Override // o.AbstractC1412Ec
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1413Ed)) {
            return false;
        }
        C1413Ed ed = (C1413Ed) obj;
        return super.equals(obj) && this.f5531.equals(ed.f5531) && this.f5532.equals(ed.f5532);
    }

    @Override // o.AbstractC1412Ec
    public int hashCode() {
        return (super.hashCode() ^ this.f5531.hashCode()) ^ this.f5532.hashCode();
    }
}

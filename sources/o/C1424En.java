package o;

import com.netflix.msl.MslException;
import java.util.Collections;
import java.util.Set;
/* renamed from: o.En  reason: case insensitive filesystem */
public class C1424En implements AbstractC1417Eh {
    @Override // o.AbstractC1417Eh
    /* renamed from: ˏ */
    public void mo4886(DV dv, AbstractC1386Dc dc) {
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˎ */
    public DV mo4884() {
        return null;
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˎ */
    public long mo4882(DV dv) {
        return 1;
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ॱ */
    public AbstractC1386Dc mo4888(DV dv) {
        return null;
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˋ */
    public void mo4881(DV dv) {
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ॱ */
    public void mo4891(String str, C1411Eb eb) {
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ॱ */
    public C1411Eb mo4889(String str) {
        return null;
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˏ */
    public void mo4887(C1411Eb eb) {
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˎ */
    public void mo4885(Set<DU> set) {
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ˎ */
    public Set<DU> mo4883(DV dv, C1411Eb eb) {
        if (eb != null) {
            if (dv == null) {
                throw new MslException(CK.f4857);
            } else if (!eb.m4871(dv)) {
                throw new MslException(CK.f4807, "uit mtserialnumber " + eb.m4869() + "; mt " + dv.m4698());
            }
        }
        return Collections.emptySet();
    }

    @Override // o.AbstractC1417Eh
    /* renamed from: ॱ */
    public void mo4890(String str, DV dv, C1411Eb eb) {
        if (eb != null && dv != null && !eb.m4871(dv)) {
            throw new MslException(CK.f4807, "uit mtserialnumber " + eb.m4869() + "; mt " + dv.m4698());
        }
    }
}

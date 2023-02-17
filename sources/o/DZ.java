package o;
public final class DZ extends AbstractC1412Ec {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f5399;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f5400;

    public String toString() {
        return "NetflixIdAuthenticationData(netflixId=" + m4704() + ", secureNetflixId=" + m4703() + ")";
    }

    @Override // o.AbstractC1412Ec
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DZ)) {
            return false;
        }
        DZ dz = (DZ) obj;
        if (!dz.m4702(this) || !super.equals(obj)) {
            return false;
        }
        String r2 = m4704();
        String r3 = dz.m4704();
        if (r2 == null) {
            if (r3 != null) {
                return false;
            }
        } else if (!r2.equals(r3)) {
            return false;
        }
        String r4 = m4703();
        String r5 = dz.m4703();
        return r4 == null ? r5 == null : r4.equals(r5);
    }

    @Override // o.AbstractC1412Ec
    public int hashCode() {
        String r4 = m4704();
        int hashCode = (super.hashCode() + 59) * 59;
        int hashCode2 = r4 == null ? 43 : r4.hashCode();
        String r5 = m4703();
        return ((hashCode + hashCode2) * 59) + (r5 == null ? 43 : r5.hashCode());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m4702(Object obj) {
        return obj instanceof DZ;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m4704() {
        return this.f5399;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m4703() {
        return this.f5400;
    }

    public DZ(String str, String str2) {
        super(C1410Ea.f5513);
        this.f5399 = str;
        this.f5400 = str2;
    }

    @Override // o.AbstractC1412Ec
    /* renamed from: ˊ */
    public C1405Dv mo4701(AbstractC1400Dq dq, C1407Dx dx) {
        C1405Dv r2 = dq.m4727();
        r2.mo4754("netflixid", this.f5399);
        if (this.f5400 != null) {
            r2.mo4754("securenetflixid", this.f5400);
        }
        return r2;
    }
}

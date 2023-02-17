package o;
/* access modifiers changed from: package-private */
/* renamed from: o.gz  reason: case insensitive filesystem */
public class C1840gz implements AbstractC1414Ee {

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC0518 f7053;

    C1840gz(AbstractC0518 r3) {
        if (r3 == null || C1349Bv.m4113(r3.mo14449())) {
            throw new IllegalArgumentException("ESN missing!");
        }
        this.f7053 = r3;
    }

    @Override // o.AbstractC1414Ee
    /* renamed from: ˊ */
    public boolean mo4875(String str) {
        return false;
    }

    @Override // o.AbstractC1414Ee
    /* renamed from: ˊ */
    public boolean mo4876(String str, C1391Dh dh) {
        C1283.m16851("nf_msl_auth_client", "isSchemePermitted: identity %s, entityAuthenticationScheme: %s", str, dh);
        if (!this.f7053.mo14449().equals(str) || dh != C1391Dh.f5420) {
            return false;
        }
        return true;
    }
}

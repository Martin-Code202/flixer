package o;
/* access modifiers changed from: package-private */
/* renamed from: o.gJ  reason: case insensitive filesystem */
public class C1804gJ implements AbstractC1414Ee {
    C1804gJ() {
    }

    @Override // o.AbstractC1414Ee
    /* renamed from: ˊ */
    public boolean mo4875(String str) {
        return false;
    }

    @Override // o.AbstractC1414Ee
    /* renamed from: ˊ */
    public boolean mo4876(String str, C1391Dh dh) {
        C1283.m16851("nf_msl_auth_server", "isSchemePermitted: identity %s, entityAuthenticationScheme: %s", str, dh);
        if (("APPBOOT".equals(str) || "Netflix".equals(str)) && dh == C1391Dh.f5422) {
            return true;
        }
        return false;
    }
}

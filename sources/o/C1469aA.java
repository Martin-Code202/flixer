package o;
/* renamed from: o.aA  reason: case insensitive filesystem */
public class C1469aA extends AbstractC1523az {
    @Override // o.AbstractC1561bj
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo5364() {
        return "appSession";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1484aP m5366(boolean z, boolean z2) {
        C1484aP aPVar = new C1484aP();
        aPVar.m5388(z);
        aPVar.m5389(z2);
        aPVar.setCategory(mo5643());
        aPVar.setSessionId(this.f6158);
        return aPVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1481aM m5365() {
        C1481aM aMVar = new C1481aM(System.currentTimeMillis() - this.f6160);
        aMVar.setCategory(mo5643());
        aMVar.setSessionId(this.f6158);
        return aMVar;
    }
}

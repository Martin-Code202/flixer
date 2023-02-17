package o;
/* renamed from: o.aH  reason: case insensitive filesystem */
public class C1476aH extends AbstractC1523az {

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f5898;

    public C1476aH(String str) {
        this.f5898 = str;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "sharedContext";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1488aT m5379() {
        C1488aT aTVar = new C1488aT(this.f5898);
        aTVar.setCategory(mo5643());
        aTVar.setSessionId(this.f6158);
        return aTVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1486aR m5378() {
        C1486aR aRVar = new C1486aR(this.f6158, System.currentTimeMillis() - this.f6160, this.f5898);
        aRVar.setCategory(mo5643());
        return aRVar;
    }
}

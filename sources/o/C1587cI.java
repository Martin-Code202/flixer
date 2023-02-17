package o;
/* renamed from: o.cI  reason: case insensitive filesystem */
public class C1587cI extends AbstractC1523az {
    public C1587cI(long j) {
        mo5386(j);
    }

    @Override // o.AbstractC1523az, o.AbstractC1560bi
    /* renamed from: ˋ */
    public String mo5643() {
        return "uiView";
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "focus";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1589cK m5823(String str) {
        C1589cK cKVar = new C1589cK(str);
        cKVar.setCategory(mo5643());
        cKVar.setSessionId(this.f6158);
        return cKVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1592cN m5824() {
        C1592cN cNVar = new C1592cN(System.currentTimeMillis() - this.f6160);
        cNVar.setCategory(mo5643());
        cNVar.setSessionId(this.f6158);
        return cNVar;
    }
}

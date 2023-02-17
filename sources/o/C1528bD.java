package o;
/* renamed from: o.bD  reason: case insensitive filesystem */
public final class C1528bD extends AbstractC1531bF {
    @Override // o.AbstractC1531bF, o.AbstractC1560bi
    /* renamed from: ˋ */
    public /* bridge */ /* synthetic */ String mo5643() {
        return super.mo5643();
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "FtlConnection";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1536bK m5717(String str) {
        C1536bK bKVar = new C1536bK(str);
        bKVar.setCategory(mo5643());
        bKVar.setSessionId(this.f6158);
        return bKVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1535bJ m5718() {
        C1535bJ bJVar = new C1535bJ(this.f6158, System.currentTimeMillis() - this.f6160);
        bJVar.setCategory(mo5643());
        bJVar.setSessionId(this.f6158);
        return bJVar;
    }
}

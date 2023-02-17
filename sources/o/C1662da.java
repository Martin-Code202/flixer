package o;
/* renamed from: o.da  reason: case insensitive filesystem */
public class C1662da extends AbstractC1604cX {

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1672dk f6432;

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "unfocused";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6011() {
        C1672dk dkVar = new C1672dk();
        dkVar.setCategory(mo5643());
        dkVar.setSessionId(this.f6158);
        this.f6432 = dkVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1675dn m6010() {
        long currentTimeMillis = System.currentTimeMillis() - this.f6160;
        if (currentTimeMillis <= 500) {
            return null;
        }
        C1675dn dnVar = new C1675dn(currentTimeMillis);
        dnVar.setCategory(mo5643());
        dnVar.setSessionId(this.f6158);
        return dnVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1672dk m6012() {
        return this.f6432;
    }
}
